package com.baidu.tbadk.core;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.BdToken.o;
import com.baidu.tbadk.BdToken.r;
import com.baidu.tbadk.KuangFloatingWindowController;
import com.baidu.tbadk.MainAPKFragmentActivityPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements o, TbPageContextSupport, com.baidu.tbadk.m.a, com.baidu.tbadk.pageInfo.a {
    private final int SHOW_SOFT_KEYBOARD_DELAY;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private List<Dialog> dialogList;
    private String fromPageName;
    private boolean isAddSwipeBackLayout;
    protected long lastResumeTime;
    private View loadingRootView;
    private com.baidu.tbadk.l.g loadingView;
    private int mAboveKeyboardHeight;
    private ViewGroup mActivityRootView;
    private com.baidu.tbadk.core.dialog.f mClickableTextToast;
    private String mCurAccountId;
    protected PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    private boolean mHideStatusImmersiveStyle;
    private boolean mIsHasScreenShotListener;
    private com.baidu.tbadk.core.view.d mKeyboardAdjust;
    private int mLastOrientation;
    protected int mLastScreenHeight;
    protected int mLastScreenWidth;
    private boolean mLayoutHasInit;
    private c mLayoutMode;
    private int mMaxHeight;
    private com.baidu.tbadk.pageExtra.c mPageExtra;
    private e mPermissionCallback;
    private int mPreHeight;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.l.h mRefreshView;
    private aa mScreenShotListenManager;
    private SwipeBackLayout mSwipeBackLayout;
    private TbPageTag mTbPageTag;
    private boolean mUseStyleImmersiveSticky;
    private bh mVirtualBarAssist;
    private b netRefreshListener;
    private final CustomMessageListener nightResourcesChangeListener;
    private TbPageContext<BaseFragmentActivity> pageContext;
    private com.baidu.tbadk.m.d pageStayDurationItem;
    private List<PopupWindow> popupWindowList;
    private com.baidu.adp.lib.f.c resourcesWrapper;
    private final CustomMessageListener skinTypeChangeListener;
    private static Class<? extends TbPageContext<BaseFragmentActivity>> mClazz4GetPageContext = MainAPKFragmentActivityPageContext.class;
    private static int flog = 1;
    protected com.baidu.tbadk.core.view.a mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;
    protected int mSkinType = 3;
    protected boolean mIsLogin = false;

    protected abstract void onChangeSkinType(int i);

    public BaseFragmentActivity() {
        this.mCurAccountId = TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount();
        this.SHOW_SOFT_KEYBOARD_DELAY = 150;
        this.isAddSwipeBackLayout = true;
        this.mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        this.mHideStatusImmersiveStyle = false;
        this.mKeyboardAdjust = null;
        this.mLayoutHasInit = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mAboveKeyboardHeight = 0;
        this.mCurrentPermissionJudgePolicy = null;
        this.mLastScreenWidth = 0;
        this.mLastScreenHeight = 0;
        this.mLastOrientation = 1;
        this.mIsHasScreenShotListener = false;
        this.nightResourcesChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.tbadk.core.BaseFragmentActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && BaseFragmentActivity.this.mLayoutMode != null) {
                    BaseFragmentActivity.this.mLayoutMode.setPluginRes(null);
                    if (BaseFragmentActivity.this.mKeyboardAdjust != null) {
                        BaseFragmentActivity.this.mKeyboardAdjust.onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
                    }
                    BaseFragmentActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.core.BaseFragmentActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = true;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    BaseFragmentActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (BaseFragmentActivity.this.shouldChangeStatusBarIconAndTextColor()) {
                        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                            z = false;
                        }
                        UtilHelper.changeStatusBarIconAndTextColor(z, BaseFragmentActivity.this);
                    }
                }
            }
        };
    }

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.g
    public TbPageContext<BaseFragmentActivity> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(BaseFragmentActivity.class).newInstance(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.pageContext;
    }

    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        if (this.mPageExtra == null) {
            this.mPageExtra = new com.baidu.tbadk.pageExtra.c(getUniqueId(), getCurrentExtraPageKey(), getIntent());
        }
        return this.mPageExtra;
    }

    public String getPreExtraPageKey() {
        com.baidu.tbadk.pageExtra.c tbPageExtra = getTbPageExtra();
        return tbPageExtra != null ? tbPageExtra.bHm() : "";
    }

    private String getCurrentExtraPageKey() {
        String currentPageKey = getCurrentPageKey();
        if (TextUtils.isEmpty(currentPageKey)) {
            return getClass().getSimpleName();
        }
        return currentPageKey;
    }

    @Override // com.baidu.tbadk.pageInfo.a
    public final com.baidu.tbadk.pageInfo.b getTbPageInfo() {
        return new com.baidu.tbadk.pageInfo.b(getUniqueId(), getTbPageTag(), getIntent());
    }

    public final TbPageTag getPrePageTag() {
        return com.baidu.tbadk.pageInfo.c.K(getIntent());
    }

    public TbPageTag getTbPageTag() {
        if (this.mTbPageTag == null) {
            this.mTbPageTag = new TbPageTag();
            this.mTbPageTag.locatePage = getCurrentPageKey();
        }
        return this.mTbPageTag;
    }

    public Fragment getVisibleFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager != null ? supportFragmentManager.getFragments() : null;
        if (x.isEmpty(fragments)) {
            return null;
        }
        for (Fragment fragment : fragments) {
            if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).isPrimary()) {
                return fragment;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("obj_source");
    }

    @Override // com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (x.isEmpty(arrayList3)) {
            arrayList = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList3);
            arrayList = arrayList4;
        }
        if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
            if (StringUtils.isNull(currentPageKey)) {
                arrayList2 = arrayList;
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
                arrayList2 = arrayList;
            }
            Fragment visibleFragment = getVisibleFragment();
            if (visibleFragment instanceof com.baidu.tbadk.m.a) {
                String currentPageKey2 = ((com.baidu.tbadk.m.a) visibleFragment).getCurrentPageKey();
                if (!StringUtils.isNull(currentPageKey2)) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(currentPageKey2);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return null;
    }

    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.m.d();
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
        }
        this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout.attachToActivity(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.IS_EXIT_APP_NOT_START_WEBSOCKET, false);
            BdSocketLinkService.startService(false, "app start");
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity(), this.mHideStatusImmersiveStyle);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            UtilHelper.changeStatusBarIconAndTextColor(z, this);
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        super.onCreate(bundle);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        bc.setCurrentActivity(getClass().getName());
        this.mLayoutMode = new c();
        registerListener(this.nightResourcesChangeListener);
        registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.mIsLogin = TbadkCoreApplication.isLogin();
        this.mScreenShotListenManager = new aa(this);
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        flog = 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.d.ag(getPageContext().getPageActivity());
        }
    }

    protected void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.d.c(getPageContext().getPageActivity(), i, z);
        }
    }

    private void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.d.i(getPageContext().getPageActivity(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInputOnSkinTypeChanged(int i) {
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.onSkinTypeChanged(i);
        }
    }

    protected void adjustResizeForSoftInputOnDestory() {
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.onDestory();
            this.mKeyboardAdjust = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeBottomVirtualBar() {
        if (this.mVirtualBarAssist == null) {
            this.mVirtualBarAssist = bh.ad(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        com.baidu.tieba.t.a.getInstance().onResume(this);
        this.lastResumeTime = System.currentTimeMillis();
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TbadkCoreApplication.getInst().AddResumeNum();
        bc.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        boolean isLogin = TbadkCoreApplication.isLogin();
        String currentAccount = TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount();
        if (this.mIsLogin != isLogin || !at.equals(currentAccount, this.mCurAccountId)) {
            this.mCurAccountId = currentAccount;
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND, this));
        }
        TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        setCurrentActivityTid();
        startScreenShotListen();
        if (this.mVirtualBarAssist != null) {
            this.mVirtualBarAssist.onResume();
        }
        TbSingleton.getInstance().getClass();
        if (!"BaseFragmentActivity".equals(TbSingleton.getInstance().isSwitchActivity)) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            TbSingleton.getInstance().getClass();
            tbSingleton.isSwitchActivity = "BaseFragmentActivity";
            flog = 0;
        }
        if (this == TbadkCoreApplication.getInst().getCurrentActivity() && TbSingleton.getInstance().isShowBackLabel && KuangFloatingWindowController.getInstance().init() && flog == 0) {
            showFloatingWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserChanged(boolean z) {
    }

    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i = 0;
                try {
                    View findViewById = BaseFragmentActivity.this.findViewById(16908290);
                    if (findViewById != null) {
                        i = findViewById.getHeight();
                    }
                    int height = BaseFragmentActivity.this.getWindow().getDecorView().getRootView().getHeight();
                    if (!BaseFragmentActivity.this.mLayoutHasInit) {
                        BaseFragmentActivity.this.mLayoutHasInit = true;
                        BaseFragmentActivity.this.mMaxHeight = i;
                    } else {
                        BaseFragmentActivity.this.mMaxHeight = BaseFragmentActivity.this.mMaxHeight < i ? i : BaseFragmentActivity.this.mMaxHeight;
                    }
                    if (BaseFragmentActivity.this.mLayoutHasInit && BaseFragmentActivity.this.mMaxHeight > i && i != BaseFragmentActivity.this.mPreHeight) {
                        int i2 = BaseFragmentActivity.this.mMaxHeight - i;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                            BaseFragmentActivity.this.onKeyboardHeightChanged(i2);
                        }
                    }
                    raiseOnKeyboardVisibilityChanged(height);
                    BaseFragmentActivity.this.mPreHeight = i;
                } catch (Exception e) {
                }
            }

            private void raiseOnKeyboardVisibilityChanged(int i) {
                View childAt;
                int height;
                boolean z = false;
                View findViewById = BaseFragmentActivity.this.findViewById(16908290);
                if ((findViewById instanceof ViewGroup) && (childAt = ((ViewGroup) findViewById).getChildAt(0)) != null && (height = childAt.getHeight()) != BaseFragmentActivity.this.mAboveKeyboardHeight) {
                    boolean z2 = height < (i * 2) / 3;
                    if (BaseFragmentActivity.this.mAboveKeyboardHeight != 0 && BaseFragmentActivity.this.mAboveKeyboardHeight < (i * 2) / 3) {
                        z = true;
                    }
                    if (z2 != z) {
                        BaseFragmentActivity.this.onKeyboardVisibilityChanged(z2);
                        if (TbSingleton.getInstance().isShowBackLabel && BaseFragmentActivity.this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z)));
                        }
                    }
                    BaseFragmentActivity.this.mAboveKeyboardHeight = height;
                }
            }
        });
    }

    protected void onKeyboardHeightChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new com.baidu.adp.lib.f.c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            try {
                if (this.mSwipeBackLayout != null) {
                    this.mSwipeBackLayout.onChangeSkinType(i);
                }
                if (this.loadingView != null) {
                    this.loadingView.onChangeSkinType();
                }
                if (this.mUseStyleImmersiveSticky) {
                    this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
                }
                onChangeSkinType(this.mSkinType);
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tieba.t.a.getInstance().onPause(this);
        super.onPause();
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            hideFloatingWindow();
        }
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            com.baidu.tbadk.m.e.bHs().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        stopScreenShotListen();
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND, this));
        if (this.mVirtualBarAssist != null) {
            this.mVirtualBarAssist.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            flog = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        if (this.loadingRootView != null) {
            hideLoadingView(this.loadingRootView);
        }
        if (this.mVirtualBarAssist != null) {
            this.mVirtualBarAssist.onDestroy();
        }
        adjustResizeForSoftInputOnDestory();
        hideClickableTextToast();
        this.pageStayDurationItem = null;
        this.mTbPageTag = null;
        clearAnimatable();
        clearAnimation();
        this.mPermissionCallback = null;
        this.mPageExtra = null;
        unRegisterResponsedEventListener();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        l.hideSoftKeyPad(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    protected int getSkinType() {
        return TbadkCoreApplication.getInst().getSkinType();
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    BaseFragmentActivity.this.mWaitingDialog = null;
                }
            };
        }
        if (!isFinishing() && com.baidu.adp.lib.f.g.a(getPageContext())) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
            if (str != null) {
                this.mWaitingDialog.setTipString(str);
            } else {
                this.mWaitingDialog.setTipString(R.string.Waiting);
            }
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(false);
            this.mWaitingDialog.setCancelListener(this.mDialogListener);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
        if (str != null) {
            this.mWaitingDialog.setTipString(str);
        } else {
            this.mWaitingDialog.setTipString(R.string.Waiting);
        }
        this.mWaitingDialog.setAutoSetCancelable(false);
        this.mWaitingDialog.setCancelable(true);
        this.mWaitingDialog.setCancelListener(onCancelListener);
        this.mWaitingDialog.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.setDialogVisiable(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public com.baidu.tbadk.core.view.a getLoadingDialog() {
        return this.mWaitingDialog;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        l.showToast(getPageContext().getContext(), str);
    }

    public void showToast(int i) {
        l.showToast(getPageContext().getContext(), i);
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            l.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            l.showToast(getPageContext().getContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdToast.b(getPageContext().getContext(), str, i, false).bud();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getPageContext().getContext(), str, i, i2, false).bud();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon).bud();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon, i).bud();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        flog = 0;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.mLayoutMode == null) {
            this.mLayoutMode = new c();
        }
        this.mLayoutMode.initModeInfos(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public void showProgressBar() {
        try {
            showProgressBarWithOffset(0, 0);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        if (this.mProgressBar == null) {
            try {
                this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
            } catch (Throwable th) {
                return;
            }
        }
        this.mProgressBar.setPadding(l.dip2px(getPageContext().getContext(), i), l.dip2px(getPageContext().getContext(), i2), 0, 0);
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public boolean isProgressBarShown() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showLoadingView(View view, boolean z, int i) {
        this.loadingRootView = view;
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new com.baidu.tbadk.l.g(getPageContext().getPageActivity());
            } else {
                this.loadingView = new com.baidu.tbadk.l.g(getPageContext().getPageActivity(), i);
                this.loadingView.bGs();
            }
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view, z);
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.isViewAttached();
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.dettachView(view);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            try {
                if (keyEvent.isLongPress()) {
                    return true;
                }
            } catch (IllegalStateException e) {
                if (i == 4) {
                    finish();
                    return true;
                }
                return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean showDialog(Dialog dialog) {
        if (com.baidu.adp.lib.f.g.a(dialog, getPageContext())) {
            if (this.dialogList == null) {
                this.dialogList = new LinkedList();
            }
            this.dialogList.add(dialog);
            return true;
        }
        return false;
    }

    public void dismissDialogInteface(DialogInterface dialogInterface) {
        if (dialogInterface instanceof Dialog) {
            dismissDialog((Dialog) dialogInterface);
        }
    }

    public void dismissDialog(Dialog dialog) {
        if (this.dialogList != null) {
            this.dialogList.remove(dialog);
        }
        com.baidu.adp.lib.f.g.b(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                com.baidu.adp.lib.f.g.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (com.baidu.adp.lib.f.g.showPopupWindowAtLocation(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        com.baidu.adp.lib.f.g.dismissPopupWindow(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(popupWindow, getPageContext().getPageActivity());
            }
            this.popupWindowList.clear();
        }
    }

    protected void clearAnimatable() {
        if (this.animatableList != null) {
            try {
                synchronized (this.animatableList) {
                    for (int i = 0; i < this.animatableList.size(); i++) {
                        Animatable animatable = this.animatableList.get(i);
                        if (animatable != null && animatable.isRunning()) {
                            animatable.stop();
                        }
                        this.animatableList.clear();
                    }
                }
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    public void startAnimatable(Animatable animatable) {
        if (animatable != null && !isFinishing()) {
            if (this.animatableList == null) {
                this.animatableList = new ArrayList();
            }
            synchronized (this.animatableList) {
                this.animatableList.add(animatable);
            }
            try {
                animatable.start();
            } catch (Throwable th) {
            }
        }
    }

    protected void clearAnimation() {
        View view;
        if (this.animationList != null) {
            synchronized (this.animationList) {
                for (int i = 0; i < this.animationList.size(); i++) {
                    WeakReference<View> weakReference = this.animationList.get(i);
                    if (weakReference != null && (view = weakReference.get()) != null) {
                        view.clearAnimation();
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void startAnimation(View view, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation != null && !isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation2);
                    }
                    synchronized (BaseFragmentActivity.this.animationList) {
                        BaseFragmentActivity.this.animationList.remove(weakReference);
                    }
                }
            });
            if (this.animationList == null) {
                this.animationList = new ArrayList();
            }
            synchronized (this.animationList) {
                this.animationList.add(weakReference);
            }
            try {
                view.startAnimation(animation);
            } catch (Throwable th) {
            }
        }
    }

    protected boolean shouldChangeStatusBarIconAndTextColor() {
        return true;
    }

    public boolean isSwipeBackEnabled() {
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || this.mSwipeBackLayout == null) {
            return false;
        }
        return this.mSwipeBackLayout.isSwipeBackEnabled();
    }

    public void disableSwipeJustOnce() {
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.disableSwipeJustOnce();
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.setIsSupportNight(z);
        }
    }

    public void setActivityBgTransparent() {
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.setBgTransparent();
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    public void setHideStatusImmersiveStyle(boolean z) {
        this.mHideStatusImmersiveStyle = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private View mView;

        public a(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BaseFragmentActivity.this.isFinishing()) {
                BaseFragmentActivity.this.ShowSoftKeyPad((InputMethodManager) BaseFragmentActivity.this.getSystemService("input_method"), this.mView);
            }
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    protected void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        if (view != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view, 0);
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new a(view), i);
    }

    public void ShowSoftKeyPadDelay(View view) {
        ShowSoftKeyPadDelay(view, 150);
    }

    public ViewGroup getActivityRootView() {
        return this.mActivityRootView;
    }

    public boolean grantWindowPermission(e eVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(getBaseContext())) {
                if (eVar != null) {
                    eVar.onPermissionResult(true);
                }
            } else {
                this.mPermissionCallback = eVar;
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.KEY_IS_WINDOW_PERMISSION_DIALOG_SHOWN, false);
                if (z) {
                    z2 = false;
                }
                if (!z2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                    aVar.jI(false);
                    aVar.oZ(R.string.request_permission_default_title);
                    aVar.pa(R.string.request_window_permission_default_text);
                    aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.7
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            try {
                                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                intent.setData(Uri.parse("package:" + BaseFragmentActivity.this.getPackageName()));
                                BaseFragmentActivity.this.startActivityForResult(intent, RequestResponseCode.REQUEST_CODE_WINDOW_PERMISSION);
                            } catch (Exception e) {
                                BaseFragmentActivity.this.showToast(R.string.request_window_permission_default_text_by_yourself);
                                if (BaseFragmentActivity.this.mPermissionCallback != null) {
                                    BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
                                }
                            }
                        }
                    }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (BaseFragmentActivity.this.mPermissionCallback != null) {
                                BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
                            }
                        }
                    }).b(getPageContext());
                    aVar.btX();
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.KEY_IS_WINDOW_PERMISSION_DIALOG_SHOWN, true);
                    return false;
                } else if (this.mPermissionCallback != null) {
                    this.mPermissionCallback.onPermissionResult(false);
                    return false;
                } else {
                    return false;
                }
            }
        } else if (eVar != null) {
            eVar.onPermissionResult(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPermissionCallback != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
            this.mPermissionCallback.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
            this.mPermissionCallback = null;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        r.a(motionEvent, getPageId(), getMissionTid());
        com.baidu.tieba.t.a.getInstance().behaviorRecordEvent(motionEvent, this);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z = false;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr != null && iArr.length > 0 && strArr != null && strArr.length > 0) {
            if (iArr[0] != 0) {
                if (this.mCurrentPermissionJudgePolicy != null) {
                    this.mCurrentPermissionJudgePolicy.checkPermissionForbidden(this, strArr[0]);
                    return;
                }
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z && this.mCurrentPermissionJudgePolicy != null) {
                this.mCurrentPermissionJudgePolicy.onPermissionsGranted();
            }
        }
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
    }

    public int getPageId() {
        BdUniqueId uniqueId = getUniqueId();
        if (uniqueId != null) {
            return uniqueId.getId();
        }
        return 0;
    }

    public long getMissionTid() {
        return 0L;
    }

    @Override // com.baidu.tbadk.BdToken.o
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        hideClickableTextToast();
        this.mClickableTextToast = r.a(completeTaskToastData);
        return true;
    }

    private void hideClickableTextToast() {
        if (this.mClickableTextToast != null) {
            this.mClickableTextToast.hide();
        }
    }

    public void setCurrentActivityTid() {
        r.n(getPageId(), getMissionTid());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    l.deviceDataInited = false;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
                }
            } else {
                this.mLastOrientation = configuration.orientation;
            }
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
            }
        }
    }

    public void publishEvent(com.baidu.tbadk.mutiprocess.a aVar) {
        if (aVar != null) {
            if (aVar.getTag() == 0) {
                aVar.setTag(getUniqueId());
            }
            com.baidu.tbadk.mutiprocess.g.publishEvent(aVar);
        }
    }

    public void registerResponsedEventListener(Class<? extends com.baidu.tbadk.mutiprocess.a> cls, com.baidu.tbadk.mutiprocess.h hVar) {
        com.baidu.tbadk.mutiprocess.g.bGF().a(cls, hVar, getUniqueId());
    }

    public void unRegisterResponsedEventListener() {
        com.baidu.tbadk.mutiprocess.g.bGF().m(getUniqueId());
    }

    public boolean checkUpIsLogin() {
        return bg.checkUpIsLogin(getPageContext().getPageActivity());
    }

    public void fullScreen(boolean z) {
        if (getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.flags |= 1024;
                getWindow().setAttributes(attributes);
                getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.flags &= -1025;
            getWindow().setAttributes(attributes2);
            getWindow().clearFlags(512);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.setTitle(str);
            this.mRefreshView.setSubText(str2);
            this.mRefreshView.setButtonText(str3);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new b();
        }
        return this.netRefreshListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragmentActivity.this.onNetRefreshButtonClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNetRefreshButtonClicked() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.setLayoutMargin(i);
        }
    }

    public void hideNetRefreshView(View view) {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(view);
        }
    }

    private void startScreenShotListen() {
        if (!this.mIsHasScreenShotListener && this.mScreenShotListenManager != null) {
            this.mScreenShotListenManager.a(new aa.b() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.8
                @Override // com.baidu.tbadk.util.aa.b
                public void onShot(String str) {
                    if (BaseFragmentActivity.this.getCurrentPageKey() != PageStayDurationConstants.PageName.HOMEPAGE && BaseFragmentActivity.this.getCurrentPageKey() != PageStayDurationConstants.PageName.PB && BaseFragmentActivity.this.getCurrentPageKey() != PageStayDurationConstants.PageName.FRS) {
                        TiebaStatic.log(new aq("c13848").dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", 4));
                    }
                    BaseFragmentActivity.this.onScreenShot(str);
                }
            });
            this.mScreenShotListenManager.startListen();
            this.mIsHasScreenShotListener = true;
        }
    }

    private void stopScreenShotListen() {
        if (this.mIsHasScreenShotListener && this.mScreenShotListenManager != null) {
            this.mScreenShotListenManager.stopListen();
            this.mIsHasScreenShotListener = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onScreenShot(String str) {
    }

    public void showFloatingWindow() {
        grantWindowPermission(new e() { // from class: com.baidu.tbadk.core.BaseFragmentActivity.9
            @Override // com.baidu.tbadk.core.e
            public void onPermissionResult(boolean z) {
                if (z) {
                    TbadkCoreApplication.getInst().setCurrentActivity(BaseFragmentActivity.this.getPageContext().getPageActivity());
                    if (KuangFloatingWindowController.getInstance().init()) {
                        TbSingleton.getInstance().isShowBackLabel = true;
                        KuangFloatingWindowController.getInstance().showFloatingView();
                    }
                }
            }
        }, false);
    }

    public void hideFloatingWindow() {
        KuangFloatingWindowController.getInstance().hideFloatingView();
    }
}
