package com.baidu.tbadk;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
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
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.GuidPageView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.pageStayDuration.a;
import com.baidu.tbadk.pageStayDuration.d;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport<T>, a {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    private static Class<? extends TbPageContext> mClazz4GetPageContext = MainAPKActivityPageContext.class;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private e customToast;
    private List<Dialog> dialogList;
    private long lastResumeTime;
    private View loadingRootView;
    private f loadingView;
    private com.baidu.tbadk.core.a mLayoutInflateFactory;
    private c mLayoutMode;
    private com.baidu.tbadk.core.e mPermissionCallback;
    private ProgressBar mProgressBar;
    private g mRefreshView;
    protected SwipeBackLayout mSwipeBackLayout;
    private BaseActivity<T>.NetRefreshListener netRefreshListener;
    private TbPageContext<T> pageContext;
    private d pageStayDurationItem;
    private List<PopupWindow> popupWindowList;
    private com.baidu.adp.lib.g.c resourcesWrapper;
    protected com.baidu.tbadk.core.view.a mWaitingDialog = null;
    private b mListMenu = null;
    private final Handler mSafeHandler = new Handler();
    protected int mSkinType = 3;
    private final GuidPageView mGuidPage = null;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    protected boolean mIsLogin = false;
    private com.baidu.tbadk.core.view.c mKeyboardAdjust = null;
    private boolean isAddSwipeBackLayout = true;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int mAboveKeyboardHeight = 0;
    private final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.BaseActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && BaseActivity.this.mLayoutMode != null) {
                BaseActivity.this.mLayoutMode.b(null);
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tbadk.BaseActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                UtilHelper.changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 1, BaseActivity.this);
            }
        }
    };

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.f
    public TbPageContext<T> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(BaseActivity.class).newInstance(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.pageContext;
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout.r(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkCoreApplication.getInst().setExitAppCloseWebSocket(false);
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        this.customToast = e.uB();
        super.onCreate(bundle);
        this.mLayoutMode = new c();
        this.mLayoutInflateFactory = new com.baidu.tbadk.core.a();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        av.en(getClass().getName());
        registerListener(this.nightResourcesChangeListener);
        registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.BaseActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i = 0;
                try {
                    View rootView = BaseActivity.this.getRootView();
                    if (rootView != null) {
                        i = rootView.getHeight();
                    }
                    int height = BaseActivity.this.getWindow().getDecorView().getRootView().getHeight();
                    if (!BaseActivity.this.mLayoutHasInit) {
                        BaseActivity.this.mLayoutHasInit = true;
                        BaseActivity.this.mMaxHeight = i;
                    } else {
                        BaseActivity.this.mMaxHeight = BaseActivity.this.mMaxHeight < i ? i : BaseActivity.this.mMaxHeight;
                    }
                    if (BaseActivity.this.mLayoutHasInit && BaseActivity.this.mMaxHeight > i && i != BaseActivity.this.mPreHeight) {
                        int i2 = BaseActivity.this.mMaxHeight - i;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                            BaseActivity.this.onKeyboardHeightChanged(i2);
                        }
                    }
                    raiseOnKeyboardVisibilityChanged(height);
                    BaseActivity.this.mPreHeight = i;
                } catch (Exception e) {
                }
            }

            private void raiseOnKeyboardVisibilityChanged(int i) {
                View childAt;
                int height;
                boolean z = false;
                View rootView = BaseActivity.this.getRootView();
                if ((rootView instanceof ViewGroup) && (childAt = ((ViewGroup) rootView).getChildAt(0)) != null && (height = childAt.getHeight()) != BaseActivity.this.mAboveKeyboardHeight) {
                    boolean z2 = height < (i * 2) / 3;
                    if (BaseActivity.this.mAboveKeyboardHeight != 0 && BaseActivity.this.mAboveKeyboardHeight < (i * 2) / 3) {
                        z = true;
                    }
                    if (z2 != z) {
                        BaseActivity.this.onKeyboardVisibilityChanged(z2);
                    }
                    BaseActivity.this.mAboveKeyboardHeight = height;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        try {
            return findViewById(16908290);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new com.baidu.adp.lib.g.c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.c.x(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.c.a(getPageContext().getPageActivity(), i, z);
        }
    }

    protected void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = com.baidu.tbadk.core.view.c.a(getPageContext().getPageActivity(), z);
        }
    }

    private void adjustResizeForSoftInputOnDestory() {
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.onDestory();
            this.mKeyboardAdjust = null;
        }
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        closeLoadingDialog();
        if (this.mGuidPage != null) {
            this.mGuidPage.wD();
        }
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        if (this.loadingRootView != null) {
            hideLoadingView(this.loadingRootView);
        }
        adjustResizeForSoftInputOnDestory();
        hideListMenu();
        clearAnimatable();
        clearAnimation();
        this.pageStayDurationItem = null;
        this.mPermissionCallback = null;
        super.onDestroy();
        this.mSafeHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    public void finish() {
        l.b(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
    }

    public void showProgressBar() {
        try {
            showProgressBarWithOffset(0, 0);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void showProgressBar(boolean z, int i, int i2) {
        if (this.mProgressBar == null) {
            try {
                this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.progressbar));
                FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(-2, -2, 17));
            } catch (Throwable th) {
                return;
            }
        }
        if (z && this.mProgressBar != null) {
            this.mProgressBar.bringToFront();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setPadding(l.dip2px(getPageContext().getPageActivity(), i), l.dip2px(getPageContext().getPageActivity(), i2), 0, 0);
            this.mProgressBar.setVisibility(0);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mProgressBar != null && this.mProgressBar.isShown()) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        showProgressBar(false, i, i2);
    }

    public void hideProgressBar() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public boolean isProgressBarShown() {
        return this.mProgressBar != null && this.mProgressBar.getVisibility() == 0;
    }

    public void showLoadingDialog(String str) {
        showLoadingDialog(str, (DialogInterface.OnCancelListener) null);
    }

    public void destroyWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        showLoadingDialog(str, onCancelListener, true);
    }

    public void showLoadingDialog(String str, boolean z) {
        showLoadingDialog(str, null, true);
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        if (!isFinishing() && com.baidu.adp.lib.g.g.a(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
            this.mWaitingDialog.eJ(str);
            this.mWaitingDialog.d(onCancelListener);
            this.mWaitingDialog.aJ(false);
            this.mWaitingDialog.setCancelable(z);
            this.mWaitingDialog.aI(true);
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.aI(false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdToast.b(getPageContext().getContext(), str, i).tL();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getPageContext().getContext(), str, i, i2).tL();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon).tL();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon, i).tL();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = getApplicationContext().getPackageName() + ".chat";
        if (name.startsWith(getApplicationContext().getPackageName() + ".im") || name.startsWith(str2)) {
            this.customToast.showToast(str, 2000);
        } else {
            l.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(String str, int i) {
        this.customToast.i(str, 2000, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.j(i, 2000, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = getApplicationContext().getPackageName() + ".chat";
        if (name.startsWith(getApplicationContext().getPackageName() + ".im") || name.startsWith(str)) {
            this.customToast.showToast(i, 2000);
        } else {
            l.showToast(getPageContext().getContext(), i);
        }
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

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        if (view2 != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view2, 0);
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view2, int i) {
        new Handler().postDelayed(new DelayRunnable(view2), i);
    }

    public void ShowSoftKeyPadDelay(View view2) {
        ShowSoftKeyPadDelay(view2, SHOW_SOFT_KEYBOARD_DELAY);
    }

    protected b newListMenu(String[] strArr, b.InterfaceC0086b interfaceC0086b) {
        this.mListMenu = new b(getPageContext().getPageActivity());
        this.mListMenu.dd(TbadkCoreApplication.getInst().getResources().getString(d.k.operation));
        this.mListMenu.a(strArr, interfaceC0086b);
        this.mListMenu.d(getPageContext());
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b createListMenu(String[] strArr, b.InterfaceC0086b interfaceC0086b) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, interfaceC0086b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b getListMenu() {
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListMenu() {
        if (this.mListMenu != null) {
            this.mListMenu.tG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideListMenu() {
        if (this.mListMenu != null) {
            this.mListMenu.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.U(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Gt().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        this.customToast.onPause();
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE);
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.w(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Go()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return null;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
            this.pageStayDurationItem.I(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.gO(getCurrentPageKey());
        }
        return this.pageStayDurationItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        this.lastResumeTime = System.currentTimeMillis();
        this.customToast.onResume();
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TbadkCoreApplication.getInst().AddResumeNum();
        av.en(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserChanged(boolean z) {
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            try {
                onChangeSkinType(this.mSkinType);
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        onResourceRecycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResourceRecycle() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.onChangeSkinType(i);
        }
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.dh(i);
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        if (this.mListMenu != null) {
            this.mListMenu.c(getPageContext());
        }
    }

    protected void quitDialog() {
        UtilHelper.quitDialog(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view2) {
            this.mView = null;
            this.mView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BaseActivity.this.isFinishing()) {
                BaseActivity.this.ShowSoftKeyPad((InputMethodManager) BaseActivity.this.getSystemService("input_method"), this.mView);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class LoadDataCallBack {
        public abstract void callback(Object... objArr);

        public LoadDataCallBack() {
        }

        public void onProgressUpdate(Object obj) {
        }
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public com.baidu.tbadk.core.a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(com.baidu.tbadk.core.a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(k kVar) {
        super.onPreLoad(kVar);
        ad.a(kVar, getUniqueId());
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean showDialog(Dialog dialog) {
        if (com.baidu.adp.lib.g.g.a(dialog, getPageContext())) {
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
        com.baidu.adp.lib.g.g.b(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                com.baidu.adp.lib.g.g.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2) {
        if (com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(popupWindow, view2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2, int i, int i2) {
        if (com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(popupWindow, view2, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view2, int i, int i2, int i3) {
        if (com.baidu.adp.lib.g.g.showPopupWindowAtLocation(popupWindow, view2, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        com.baidu.adp.lib.g.g.a(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                com.baidu.adp.lib.g.g.a(popupWindow, getPageContext().getPageActivity());
            }
            this.popupWindowList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearAnimatable() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearAnimation() {
        View view2;
        if (this.animationList != null) {
            synchronized (this.animationList) {
                for (int i = 0; i < this.animationList.size(); i++) {
                    WeakReference<View> weakReference = this.animationList.get(i);
                    if (weakReference != null && (view2 = weakReference.get()) != null) {
                        view2.clearAnimation();
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void startAnimation(View view2, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation != null && !isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view2);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.BaseActivity.2
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
                    synchronized (BaseActivity.this.animationList) {
                        BaseActivity.this.animationList.remove(weakReference);
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
                view2.startAnimation(animation);
            } catch (Throwable th) {
            }
        }
    }

    public void showLoadingView(View view2) {
        showLoadingView(view2, false);
    }

    public void showLoadingView(View view2, boolean z, int i) {
        this.loadingRootView = view2;
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new f(getPageContext().getContext());
            } else {
                this.loadingView = new f(getPageContext().getContext(), i);
            }
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.d(view2, z);
    }

    public void showLoadingView(View view2, boolean z) {
        showLoadingView(view2, z, -1);
    }

    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.Fm();
    }

    public void hideLoadingView(View view2) {
        if (this.loadingView != null) {
            this.loadingView.P(view2);
        }
    }

    public f getLoadingView() {
        return this.loadingView;
    }

    public g getRefreshView() {
        return this.mRefreshView;
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.setTitle(str);
        this.mRefreshView.setSubText(str2);
        this.mRefreshView.setButtonText(str3);
        this.mRefreshView.d(view2, z);
        this.mRefreshView.Fu();
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(l.e(getApplicationContext(), d.e.ds300));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.Fm()) {
            this.mRefreshView.fa(i);
        }
    }

    @Deprecated
    protected void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.Fm() && this.mRefreshView.Fs() != null && (this.mRefreshView.Fs().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.Fs().getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshLayoutMarginTop(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.Fm() && this.mRefreshView.Fs() != null && (this.mRefreshView.Fs().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.Fs().getLayoutParams()).topMargin = z ? BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT, false) : BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
    }

    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.setSubText(str);
        this.mRefreshView.d(view2, z);
        this.mRefreshView.Fv();
    }

    public void showNetRefreshView(View view2, String str) {
        showNetRefreshView(view2, str, false);
    }

    public void showNetRefreshViewNoClick(View view2, String str) {
        showNetRefreshViewNoClick(view2, str, false);
    }

    public void hideNetRefreshView(View view2) {
        if (this.mRefreshView != null) {
            this.mRefreshView.P(view2);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.fa(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener();
        }
        return this.netRefreshListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNetRefreshButtonClicked() {
    }

    public void skipToRegisterActivity() {
        az.aI(getPageContext().getPageActivity());
    }

    public void skipToLoginActivity() {
        az.aJ(getPageContext().getPageActivity());
    }

    public boolean checkUpIsLogin() {
        return az.aK(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class NetRefreshListener implements View.OnClickListener {
        private NetRefreshListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BaseActivity.this.onNetRefreshButtonClicked();
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

    public void changeSwipeSkinType(int i) {
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.aN(i);
        }
    }

    public boolean isLogin() {
        return this.mIsLogin;
    }

    public Handler getSafeHandler() {
        return this.mSafeHandler;
    }

    public void setExcludeHeight(int i) {
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.setExcludeHeight(i);
        }
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

    public boolean grantWindowPermission(com.baidu.tbadk.core.e eVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(getBaseContext())) {
                if (eVar != null) {
                    eVar.ak(true);
                }
            } else {
                this.mPermissionCallback = eVar;
                if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_is_window_permission_dialog_shown", false)) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                    aVar.as(false);
                    aVar.bY(d.k.request_permission_default_title);
                    aVar.bZ(d.k.request_window_permission_default_text);
                    aVar.a(d.k.isopen, new a.b() { // from class: com.baidu.tbadk.BaseActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            try {
                                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                intent.setData(Uri.parse("package:" + BaseActivity.this.getPackageName()));
                                BaseActivity.this.startActivityForResult(intent, IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH);
                            } catch (Exception e) {
                                BaseActivity.this.showToast(d.k.request_window_permission_default_text_by_yourself);
                                if (BaseActivity.this.mPermissionCallback != null) {
                                    BaseActivity.this.mPermissionCallback.ak(false);
                                }
                            }
                        }
                    }).b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.BaseActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (BaseActivity.this.mPermissionCallback != null) {
                                BaseActivity.this.mPermissionCallback.ak(false);
                            }
                        }
                    }).b(getPageContext());
                    aVar.tD();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_is_window_permission_dialog_shown", true);
                    return false;
                } else if (this.mPermissionCallback != null) {
                    this.mPermissionCallback.ak(false);
                    return false;
                } else {
                    return false;
                }
            }
        } else if (eVar != null) {
            eVar.ak(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPermissionCallback != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
            this.mPermissionCallback.ak(Settings.canDrawOverlays(getBaseContext()));
            this.mPermissionCallback = null;
        }
    }
}
