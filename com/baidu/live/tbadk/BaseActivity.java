package com.baidu.live.tbadk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
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
import com.baidu.live.adp.base.BdBaseActivity;
import com.baidu.live.adp.base.BdBaseApplication;
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
import com.baidu.live.adp.widget.listview.IPreLoadListView;
import com.baidu.live.tbadk.core.BDLayoutInflateFactory;
import com.baidu.live.tbadk.core.BDLayoutMode;
import com.baidu.live.tbadk.core.ICheckPermissionCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdListDialog;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaStaticHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.core.view.KeyboardAdjust;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.loading.NetRefreshView;
import com.baidu.live.tbadk.pagestayduration.IPageStayDuration;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationItem;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationStat;
import com.baidu.live.tbadk.util.BdListViewHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport<T>, IPageStayDuration {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    private static Class<? extends TbPageContext> mClazz4GetPageContext = MainAPKActivityPageContext.class;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private List<Dialog> dialogList;
    private long lastResumeTime;
    private View loadingRootView;
    private LoadingView loadingView;
    private BDLayoutInflateFactory mLayoutInflateFactory;
    private BDLayoutMode mLayoutMode;
    private ICheckPermissionCallback mPermissionCallback;
    private ProgressBar mProgressBar;
    private NetRefreshView mRefreshView;
    protected SwipeBackLayout mSwipeBackLayout;
    private BaseActivity<T>.NetRefreshListener netRefreshListener;
    private TbPageContext<T> pageContext;
    private PageStayDurationItem pageStayDurationItem;
    private List<PopupWindow> popupWindowList;
    private ResourcesWrapper resourcesWrapper;
    protected BlueCircleProgressDialog mWaitingDialog = null;
    private BdListDialog mListMenu = null;
    private final Handler mSafeHandler = new Handler();
    protected int mSkinType = 3;
    private boolean mUseStyleImmersiveSticky = true;
    protected boolean mIsLogin = false;
    private KeyboardAdjust mKeyboardAdjust = null;
    private boolean isAddSwipeBackLayout = true;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int mAboveKeyboardHeight = 0;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.tbadk.BaseActivity.1
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
    };
    private final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.live.tbadk.BaseActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && BaseActivity.this.mLayoutMode != null) {
                BaseActivity.this.mLayoutMode.setPluginRes(null);
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.live.tbadk.BaseActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                UtilHelper.changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 1, BaseActivity.this.getActivity());
            }
        }
    };

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
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
    @Override // com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (BdBaseApplication.getInst() == null && TbConfig.sdkInitCallback != null) {
            TbConfig.sdkInitCallback.initSdk();
        }
        this.mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout.attachToActivity(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        super.onCreate(bundle);
        this.mLayoutMode = new BDLayoutMode();
        this.mLayoutInflateFactory = new BDLayoutInflateFactory();
        this.mLayoutInflateFactory.setViewMode(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
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

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        try {
            return findViewById(16908290);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new ResourcesWrapper(super.getResources());
        }
        return this.resourcesWrapper;
    }

    protected void onKeyboardHeightChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustResizeForSoftInput() {
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

    protected void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = KeyboardAdjust.assistActivity(getPageContext().getPageActivity(), z);
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
    @Override // com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
        closeLoadingDialog();
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
        BdUtilHelper.hideSoftKeyPad(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(a.f.sdk_progressbar));
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
            this.mProgressBar.setPadding(BdUtilHelper.dip2px(getPageContext().getPageActivity(), i), BdUtilHelper.dip2px(getPageContext().getPageActivity(), i2), 0, 0);
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
        if (!getActivity().isFinishing() && ShowUtil.isActivityCanShowDialogOrPopupWindow(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_Waiting);
            }
            this.mWaitingDialog = new BlueCircleProgressDialog(getPageContext());
            this.mWaitingDialog.setTipString(str);
            this.mWaitingDialog.setCancelListener(onCancelListener);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(z);
            this.mWaitingDialog.setDialogVisiable(true);
        }
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

    protected void showToastWithIcon(String str, int i) {
        BdToast.makeTextWithIcon(getPageContext().getContext(), str, i).show();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.makeTextWithIcon(getPageContext().getContext(), str, i, i2).show();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.makeTextWithDefaultIcon(getPageContext().getContext(), str, defaultIcon).show();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.makeTextWithDefaultIcon(getPageContext().getContext(), str, defaultIcon, i).show();
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity
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

    protected BdListDialog newListMenu(String[] strArr, BdListDialog.OnItemClickListener onItemClickListener) {
        this.mListMenu = new BdListDialog(getPageContext().getPageActivity());
        this.mListMenu.setTitle(TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_operation));
        this.mListMenu.setItems(strArr, onItemClickListener);
        this.mListMenu.create(getPageContext());
        return this.mListMenu;
    }

    protected BdListDialog createListMenu(String[] strArr, BdListDialog.OnItemClickListener onItemClickListener) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, onItemClickListener);
    }

    protected BdListDialog getListMenu() {
        return this.mListMenu;
    }

    protected void showListMenu() {
        if (this.mListMenu != null) {
            this.mListMenu.show();
        }
    }

    protected void hideListMenu() {
        if (this.mListMenu != null) {
            this.mListMenu.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
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

    protected void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("obj_source");
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
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
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
        }
        return this.pageStayDurationItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
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
    @Override // com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        onResourceRecycle();
    }

    protected void onResourceRecycle() {
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
            this.mKeyboardAdjust.onSkinTypeChanged(i);
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        if (this.mListMenu != null) {
            this.mListMenu.autoChangeSkinType(getPageContext());
        }
    }

    protected void quitDialog() {
        UtilHelper.quitDialog(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public abstract class LoadDataCallBack {
        public abstract void callback(Object... objArr);

        public LoadDataCallBack() {
        }

        public void onProgressUpdate(Object obj) {
        }
    }

    public BDLayoutMode getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(BDLayoutMode bDLayoutMode) {
        this.mLayoutMode = bDLayoutMode;
    }

    public BDLayoutInflateFactory getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(BDLayoutInflateFactory bDLayoutInflateFactory) {
        this.mLayoutInflateFactory = bDLayoutInflateFactory;
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, com.baidu.live.adp.base.IScrollable
    public void onPreLoad(IPreLoadListView iPreLoadListView) {
        super.onPreLoad(iPreLoadListView);
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
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tbadk.BaseActivity.2
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
                this.loadingView = new LoadingView(getPageContext().getContext());
            } else {
                this.loadingView = new LoadingView(getPageContext().getContext(), i);
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

    public LoadingView getLoadingView() {
        return this.loadingView;
    }

    public NetRefreshView getRefreshView() {
        return this.mRefreshView;
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new NetRefreshView(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.setTitle(str);
        this.mRefreshView.setSubText(str2);
        this.mRefreshView.setButtonText(str3);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.showRefreshButton();
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(getApplicationContext(), a.e.sdk_ds300));
    }

    protected void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.setLayoutMargin(i);
        }
    }

    @Deprecated
    protected void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached() && this.mRefreshView.getAttachedView() != null && (this.mRefreshView.getAttachedView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.getAttachedView().getLayoutParams()).topMargin = BdListViewHelper.getTopMarginWithTypeAndNetworkState(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    protected void setNetRefreshLayoutMarginTop(boolean z) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached() && this.mRefreshView.getAttachedView() != null && (this.mRefreshView.getAttachedView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.getAttachedView().getLayoutParams()).topMargin = z ? BdListViewHelper.getTopMarginWithTypeAndNetworkState(BdListViewHelper.HeadType.DEFAULT, false) : BdListViewHelper.getTopMarginWithType(BdListViewHelper.HeadType.DEFAULT);
        }
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new NetRefreshView(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.setSubText(str);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.hideRefreshButton();
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public void showNetRefreshViewNoClick(View view, String str) {
        showNetRefreshViewNoClick(view, str, false);
    }

    public void hideNetRefreshView(View view) {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(view);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new NetRefreshView(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.setLayoutMargin(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener();
        }
        return this.netRefreshListener;
    }

    protected void onNetRefreshButtonClicked() {
    }

    public void skipToRegisterActivity() {
        ViewHelper.skipToRegisterActivity(getPageContext().getPageActivity());
    }

    public void skipToLoginActivity() {
        ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
    }

    public boolean checkUpIsLogin() {
        return ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class NetRefreshListener implements View.OnClickListener {
        private NetRefreshListener() {
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
            this.mSwipeBackLayout.setBgTransparent();
        }
    }

    public void changeSwipeSkinType(int i) {
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.forceChangeSkinType(i);
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
                WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                getActivity().getWindow().setAttributes(attributes);
                getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = getActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            getActivity().getWindow().setAttributes(attributes2);
            getActivity().getWindow().clearFlags(512);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPermissionCallback != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
            this.mPermissionCallback.onPermissionResult(Settings.canDrawOverlays(getActivity().getBaseContext()));
            this.mPermissionCallback = null;
        }
    }
}
