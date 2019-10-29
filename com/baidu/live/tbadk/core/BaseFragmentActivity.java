package com.baidu.live.tbadk.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdBaseFragmentActivity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.lib.safe.ResourcesWrapper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.SwipeBackLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.MainAPKFragmentActivityPageContext;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.TbPageContextSupport;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaStaticHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.core.view.KeyboardAdjust;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.pagestayduration.IPageStayDuration;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationItem;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationStat;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements TbPageContextSupport<BaseFragmentActivity>, IPageStayDuration {
    private static Class<? extends TbPageContext<BaseFragmentActivity>> mClazz4GetPageContext = MainAPKFragmentActivityPageContext.class;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private List<Dialog> dialogList;
    private String fromPageName;
    private long lastResumeTime;
    private View loadingRootView;
    private LoadingView loadingView;
    private ViewGroup mActivityRootView;
    private BDLayoutMode mLayoutMode;
    private ICheckPermissionCallback mPermissionCallback;
    private ProgressBar mProgressBar;
    private SwipeBackLayout mSwipeBackLayout;
    private TbPageContext<BaseFragmentActivity> pageContext;
    private PageStayDurationItem pageStayDurationItem;
    private List<PopupWindow> popupWindowList;
    private ResourcesWrapper resourcesWrapper;
    protected BlueCircleProgressDialog mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;
    protected int mSkinType = 3;
    protected boolean mIsLogin = false;
    private final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    private boolean isAddSwipeBackLayout = true;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    private boolean mHideStatusImmersiveStyle = false;
    private KeyboardAdjust mKeyboardAdjust = null;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int mAboveKeyboardHeight = 0;
    private final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
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
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseFragmentActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                UtilHelper.changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 1, BaseFragmentActivity.this.getActivity());
            }
        }
    };

    protected abstract void onChangeSkinType(int i);

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
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

    public Fragment getVisibleFragment() {
        FragmentManager supportFragmentManager = ((FragmentActivity) getActivity()).getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager != null ? supportFragmentManager.getFragments() : null;
        if (ListUtils.isEmpty(fragments)) {
            return null;
        }
        for (Fragment fragment : fragments) {
            if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).isPrimary()) {
                return fragment;
            }
        }
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("obj_source");
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList3)) {
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
            if (visibleFragment instanceof IPageStayDuration) {
                String currentPageKey2 = ((IPageStayDuration) visibleFragment).getCurrentPageKey();
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

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new PageStayDurationItem();
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
        }
        this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout.attachToActivity(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity(), this.mHideStatusImmersiveStyle);
            UtilHelper.changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 1, getActivity());
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        super.onCreate(bundle);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        this.mLayoutMode = new BDLayoutMode();
        registerListener(this.nightResourcesChangeListener);
        registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    public void enterExitAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    public void closeAnimation() {
        if (this instanceof Activity) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    protected void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = KeyboardAdjust.assistActivity(getPageContext().getPageActivity());
        }
    }

    protected void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = KeyboardAdjust.assistActivity(getPageContext().getPageActivity(), i, z);
        }
    }

    private void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = KeyboardAdjust.assistActivity(getPageContext().getPageActivity(), z);
        }
    }

    protected void adjustResizeForSoftInputOnSkinTypeChanged(int i) {
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
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getActivity().getWindow());
        super.onResume();
        this.lastResumeTime = System.currentTimeMillis();
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TbadkCoreApplication.getInst().AddResumeNum();
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND, this));
        }
    }

    protected void onUserChanged(boolean z) {
    }

    protected void addGlobalLayoutListener() {
        getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i = 0;
                try {
                    View findViewById = BaseFragmentActivity.this.getActivity().findViewById(16908290);
                    if (findViewById != null) {
                        i = findViewById.getHeight();
                    }
                    int height = BaseFragmentActivity.this.getActivity().getWindow().getDecorView().getRootView().getHeight();
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
                View findViewById = BaseFragmentActivity.this.getActivity().findViewById(16908290);
                if ((findViewById instanceof ViewGroup) && (childAt = ((ViewGroup) findViewById).getChildAt(0)) != null && (height = childAt.getHeight()) != BaseFragmentActivity.this.mAboveKeyboardHeight) {
                    boolean z2 = height < (i * 2) / 3;
                    if (BaseFragmentActivity.this.mAboveKeyboardHeight != 0 && BaseFragmentActivity.this.mAboveKeyboardHeight < (i * 2) / 3) {
                        z = true;
                    }
                    if (z2 != z) {
                        BaseFragmentActivity.this.onKeyboardVisibilityChanged(z2);
                    }
                    BaseFragmentActivity.this.mAboveKeyboardHeight = height;
                }
            }
        });
    }

    protected void onKeyboardHeightChanged(int i) {
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst() != null && BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new ResourcesWrapper(super.getResources());
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
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            PageStayDurationItem pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            PageStayDurationStat.getInstance().stat(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        if (this.loadingRootView != null) {
            hideLoadingView(this.loadingRootView);
        }
        adjustResizeForSoftInputOnDestory();
        this.pageStayDurationItem = null;
        clearAnimatable();
        clearAnimation();
        this.mPermissionCallback = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        BdUtilHelper.hideSoftKeyPad(getActivity().getApplicationContext(), getActivity().getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    protected int getSkinType() {
        return TbadkCoreApplication.getInst().getSkinType();
    }

    public BDLayoutMode getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(BDLayoutMode bDLayoutMode) {
        this.mLayoutMode = bDLayoutMode;
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    BaseFragmentActivity.this.mWaitingDialog = null;
                }
            };
        }
        if (!getActivity().isFinishing() && ShowUtil.isActivityCanShowDialogOrPopupWindow(getPageContext())) {
            this.mWaitingDialog = new BlueCircleProgressDialog(getPageContext());
            if (str != null) {
                this.mWaitingDialog.setTipString(str);
            } else {
                this.mWaitingDialog.setTipString(a.i.sdk_Waiting);
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
        this.mWaitingDialog = new BlueCircleProgressDialog(getPageContext());
        if (str != null) {
            this.mWaitingDialog.setTipString(str);
        } else {
            this.mWaitingDialog.setTipString(a.i.sdk_Waiting);
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

    public BlueCircleProgressDialog getLoadingDialog() {
        return this.mWaitingDialog;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        BdUtilHelper.showToast(getPageContext().getContext(), str);
    }

    public void showToast(int i) {
        BdUtilHelper.showToast(getPageContext().getContext(), i);
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            BdUtilHelper.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            BdUtilHelper.showToast(getPageContext().getContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdUtilHelper.showToast(getPageContext().getContext(), str);
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdUtilHelper.showToast(getPageContext().getContext(), str, i2);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.mLayoutMode == null) {
            this.mLayoutMode = new BDLayoutMode();
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(a.f.sdk_progressbar));
                ((FrameLayout) getActivity().findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
            } catch (Throwable th) {
                return;
            }
        }
        this.mProgressBar.setPadding(BdUtilHelper.dip2px(getPageContext().getContext(), i), BdUtilHelper.dip2px(getPageContext().getContext(), i2), 0, 0);
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
                this.loadingView = new LoadingView(getPageContext().getPageActivity());
            } else {
                this.loadingView = new LoadingView(getPageContext().getPageActivity(), i);
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
        if (ShowUtil.showDialog(dialog, getPageContext())) {
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
        ShowUtil.dismissDialog(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                ShowUtil.dismissDialog(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (ShowUtil.showPopupWindowAsDropDown(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (ShowUtil.showPopupWindowAsDropDown(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (ShowUtil.showPopupWindowAtLocation(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        ShowUtil.dismissPopupWindow(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                ShowUtil.dismissPopupWindow(popupWindow, getPageContext().getPageActivity());
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
        if (animatable != null && !getActivity().isFinishing()) {
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
        if (animation != null && !getActivity().isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.3
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

    public boolean isSwipeBackEnabled() {
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || this.mSwipeBackLayout == null) {
            return false;
        }
        return this.mSwipeBackLayout.isSwipeBackEnabled();
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
    /* loaded from: classes6.dex */
    public class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BaseFragmentActivity.this.getActivity().isFinishing()) {
                BaseFragmentActivity.this.ShowSoftKeyPad((InputMethodManager) BaseFragmentActivity.this.getActivity().getSystemService("input_method"), this.mView);
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
        new Handler().postDelayed(new DelayRunnable(view), i);
    }

    public void ShowSoftKeyPadDelay(View view) {
        ShowSoftKeyPadDelay(view, 150);
    }

    public ViewGroup getActivityRootView() {
        return this.mActivityRootView;
    }

    public boolean grantWindowPermission(ICheckPermissionCallback iCheckPermissionCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(getActivity().getBaseContext())) {
                if (iCheckPermissionCallback != null) {
                    iCheckPermissionCallback.onPermissionResult(true);
                }
            } else {
                this.mPermissionCallback = iCheckPermissionCallback;
                if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.KEY_IS_WINDOW_PERMISSION_DIALOG_SHOWN, false)) {
                    BdAlertDialog bdAlertDialog = new BdAlertDialog(getActivity());
                    bdAlertDialog.setCanceledOnTouchOutside(false);
                    bdAlertDialog.setTitle(a.i.sdk_request_permission_default_title);
                    bdAlertDialog.setMessageId(a.i.sdk_request_window_permission_default_text);
                    bdAlertDialog.setPositiveButton(a.i.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.7
                        @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                        public void onClick(BdAlertDialog bdAlertDialog2) {
                            bdAlertDialog2.dismiss();
                            try {
                                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                intent.setData(Uri.parse("package:" + BaseFragmentActivity.this.getActivity().getPackageName()));
                                BaseFragmentActivity.this.getActivity().startActivityForResult(intent, RequestResponseCode.REQUEST_CODE_WINDOW_PERMISSION);
                            } catch (Exception e) {
                                BaseFragmentActivity.this.showToast(a.i.sdk_request_window_permission_default_text_by_yourself);
                                if (BaseFragmentActivity.this.mPermissionCallback != null) {
                                    BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
                                }
                            }
                        }
                    }).setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.tbadk.core.BaseFragmentActivity.6
                        @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                        public void onClick(BdAlertDialog bdAlertDialog2) {
                            bdAlertDialog2.dismiss();
                            if (BaseFragmentActivity.this.mPermissionCallback != null) {
                                BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
                            }
                        }
                    }).create(getPageContext());
                    bdAlertDialog.show();
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.KEY_IS_WINDOW_PERMISSION_DIALOG_SHOWN, true);
                    return false;
                } else if (this.mPermissionCallback != null) {
                    this.mPermissionCallback.onPermissionResult(false);
                    return false;
                } else {
                    return false;
                }
            }
        } else if (iCheckPermissionCallback != null) {
            iCheckPermissionCallback.onPermissionResult(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPermissionCallback != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
            this.mPermissionCallback.onPermissionResult(Settings.canDrawOverlays(getActivity().getBaseContext()));
            this.mPermissionCallback = null;
        }
    }
}
