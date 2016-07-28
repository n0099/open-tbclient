package com.baidu.tbadk;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.f;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.g.h;
import com.baidu.tbadk.pageStayDuration.a;
import com.baidu.tbadk.pageStayDuration.b;
import com.baidu.tbadk.pageStayDuration.d;
import com.baidu.tbadk.pageStayDuration.e;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
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
    private f customToast;
    private List<Dialog> dialogList;
    private long lastResumeTime;
    private View loadingRootView;
    private com.baidu.tbadk.g.f loadingView;
    private com.baidu.tbadk.core.a mLayoutInflateFactory;
    private c mLayoutMode;
    private ProgressBar mProgressBar;
    private h mRefreshView;
    protected com.baidu.adp.widget.f mSwipeBackLayout;
    private BaseActivity<T>.NetRefreshListener netRefreshListener;
    private TbPageContext<T> pageContext;
    private d pageStayDurationItem;
    private List<PopupWindow> popupWindowList;
    private com.baidu.adp.lib.h.c resourcesWrapper;
    protected ProgressDialog mWaitingDialog = null;
    private com.baidu.tbadk.core.dialog.c mListMenu = null;
    private final Handler mSafeHandler = new Handler();
    protected int mSkinType = 3;
    private final com.baidu.tbadk.core.view.d mGuidPage = null;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    protected boolean mIsLogin = false;
    private k mKeyboardAdjust = null;
    private boolean isAddSwipeBackLayout = true;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int mAboveKeyboardHeight = 0;
    private final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.tbadk.BaseActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && BaseActivity.this.mLayoutMode != null) {
                BaseActivity.this.mLayoutMode.b((Resources) null);
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.BaseActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001311 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
            }
        }
    };

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.i
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
            this.mSwipeBackLayout = new com.baidu.adp.widget.f(getPageContext().getPageActivity());
            this.mSwipeBackLayout.k(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (TbadkCoreApplication.m10getInst().isExitAppCloseWebSocket()) {
            TbadkCoreApplication.m10getInst().setExitAppCloseWebSocket(false);
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        this.customToast = f.sT();
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
        bg.dB(getClass().getName());
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.BaseActivity.3
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
                        if (TbadkCoreApplication.m10getInst().isKeyboardHeightCanSet(i2) && i2 < (height * 2) / 3 && TbadkCoreApplication.m10getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.m10getInst().setKeyboardHeight(i2);
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
            this.resourcesWrapper = new com.baidu.adp.lib.h.c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = k.n(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = k.a(getPageContext().getPageActivity(), i, z);
        }
    }

    protected void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = k.a(getPageContext().getPageActivity(), z);
        }
    }

    private void adjustResizeForSoftInputOnDestory() {
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.onDestory();
            this.mKeyboardAdjust = null;
        }
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m10getInst().isGpuOpen();
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
            this.mGuidPage.uR();
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
        super.onDestroy();
        this.mSafeHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.adp.lib.util.k.b(getApplicationContext(), getWindow().getDecorView());
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m10getInst().getResources().getDrawable(u.f.progressbar));
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
            this.mProgressBar.setPadding(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), i), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), i2), 0, 0);
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
        if (!isFinishing() && j.a(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.m10getInst().getResources().getString(u.j.Waiting);
            }
            this.mWaitingDialog = new ProgressDialog(getPageContext().getPageActivity());
            this.mWaitingDialog.setTitle("");
            this.mWaitingDialog.setMessage(str);
            this.mWaitingDialog.setIndeterminate(true);
            if (onCancelListener != null) {
                this.mWaitingDialog.setOnCancelListener(onCancelListener);
            }
            this.mWaitingDialog.setCancelable(z);
            j.a(this.mWaitingDialog, getPageContext().getPageActivity());
            Window window = this.mWaitingDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(u.d.common_color_10022);
                if (window.getDecorView() != null) {
                    window.getDecorView().setBackgroundResource(u.d.common_color_10022);
                }
            }
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    j.b(this.mWaitingDialog, getPageContext());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public ProgressDialog getLoadingDialog() {
        return this.mWaitingDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdToast.b(getPageContext().getContext(), str, i).sa();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getPageContext().getContext(), str, i, i2).sa();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon).sa();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon, i).sa();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
            this.customToast.showToast(str, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(String str, int i) {
        this.customToast.b(str, 2000, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.n(i, 2000, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
            this.customToast.showToast(i, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), i);
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), i);
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
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

    protected com.baidu.tbadk.core.dialog.c newListMenu(String[] strArr, c.b bVar) {
        this.mListMenu = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.mListMenu.cA(TbadkCoreApplication.m10getInst().getResources().getString(u.j.operation));
        this.mListMenu.a(strArr, bVar);
        this.mListMenu.d(getPageContext());
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.core.dialog.c createListMenu(String[] strArr, c.b bVar) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.core.dialog.c getListMenu() {
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListMenu() {
        if (this.mListMenu != null) {
            this.mListMenu.rV();
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
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.N(currentTimeMillis);
            e.Es().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        this.customToast.onPause();
        TbadkCoreApplication.m10getInst().DelResumeNum();
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

    public b getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("obj_source");
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (y.t(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Em()) && !StringUtils.isNull(currentPageKey)) {
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

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new d();
            this.pageStayDurationItem.D(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.ga(getCurrentPageKey());
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
        changeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        TbadkCoreApplication.m10getInst().AddResumeNum();
        bg.dB(getClass().getName());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
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

    protected void onResourceRecycle() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.sd();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.sd();
        }
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.onChangeSkinType(i);
        }
        if (this.mKeyboardAdjust != null) {
            this.mKeyboardAdjust.cO(i);
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
    }

    protected void quitDialog() {
        UtilHelper.quitDialog(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
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

    public com.baidu.tbadk.core.c getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(com.baidu.tbadk.core.c cVar) {
        this.mLayoutMode = cVar;
    }

    public com.baidu.tbadk.core.a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(com.baidu.tbadk.core.a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.k
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        aj.a(bdListView, getUniqueId());
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean showDialog(Dialog dialog) {
        if (j.a(dialog, getPageContext())) {
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
        j.b(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                j.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (j.showPopupWindowAsDropDown(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (j.showPopupWindowAsDropDown(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (j.showPopupWindowAtLocation(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        j.a(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                j.a(popupWindow, getPageContext().getPageActivity());
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
        View view;
        if (this.animationList != null) {
            synchronized (this.animationList) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.animationList.size()) {
                        WeakReference<View> weakReference = this.animationList.get(i2);
                        if (weakReference != null && (view = weakReference.get()) != null) {
                            view.clearAnimation();
                        }
                        i = i2 + 1;
                    } else {
                        this.animationList.clear();
                    }
                }
            }
        }
    }

    public void startAnimation(View view, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation != null && !isFinishing()) {
            final WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.BaseActivity.4
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
                view.startAnimation(animation);
            } catch (Throwable th) {
            }
        }
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showLoadingView(View view, boolean z, int i) {
        this.loadingRootView = view;
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new com.baidu.tbadk.g.f(getPageContext().getContext());
            } else {
                this.loadingView = new com.baidu.tbadk.g.f(getPageContext().getContext(), i);
            }
            this.loadingView.sd();
        }
        this.loadingView.c(view, z);
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.Da();
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.K(view);
        }
    }

    public com.baidu.tbadk.g.f getLoadingView() {
        return this.loadingView;
    }

    public h getRefreshView() {
        return this.mRefreshView;
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.setTitle(str);
        this.mRefreshView.fV(str2);
        this.mRefreshView.fW(str3);
        this.mRefreshView.c(view, z);
        this.mRefreshView.Dh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.c(getApplicationContext(), u.e.ds300));
    }

    protected void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.Da()) {
            this.mRefreshView.eF(i);
        }
    }

    @Deprecated
    protected void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.Da() && this.mRefreshView.Dg() != null && (this.mRefreshView.Dg().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.Dg().getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    protected void setNetRefreshLayoutMarginTop(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.Da() && this.mRefreshView.Dg() != null && (this.mRefreshView.Dg().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.Dg().getLayoutParams()).topMargin = z ? BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT, false) : BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.fV(str);
        this.mRefreshView.c(view, z);
        this.mRefreshView.Di();
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public void showNetRefreshViewNoClick(View view, String str) {
        showNetRefreshViewNoClick(view, str, false);
    }

    public void hideNetRefreshView(View view) {
        if (this.mRefreshView != null) {
            this.mRefreshView.K(view);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.eF(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener(this, null);
        }
        return this.netRefreshListener;
    }

    protected void onNetRefreshButtonClicked() {
    }

    public void skipToRegisterActivity() {
        bn.Z(getPageContext().getPageActivity());
    }

    public boolean checkUpIsLogin() {
        return bn.ab(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class NetRefreshListener implements View.OnClickListener {
        private NetRefreshListener() {
        }

        /* synthetic */ NetRefreshListener(BaseActivity baseActivity, NetRefreshListener netRefreshListener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
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
            this.mSwipeBackLayout.ke();
        }
    }

    public void changeSwipeSkinType(int i) {
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.aA(i);
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
}
