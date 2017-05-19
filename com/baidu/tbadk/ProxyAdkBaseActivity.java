package com.baidu.tbadk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.i.f;
import com.baidu.tbadk.i.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ProxyAdkBaseActivity<T> extends PluginAdpBaseActivity {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private e customToast;
    private List<Dialog> dialogList;
    private View loadingRootView;
    private f loadingView;
    private a mLayoutInflateFactory;
    private c mLayoutMode;
    private ProgressBar mProgressBar;
    protected com.baidu.adp.widget.f mSwipeBackLayout;
    private ProxyAdkBaseActivity<T>.NetRefreshListener netRefreshListener;
    private TbPageContext<T> pageContext;
    private List<PopupWindow> popupWindowList;
    private h refreshView;
    protected ProgressDialog mWaitingDialog = null;
    private AlertDialog mListMenu = null;
    protected int mSkinType = 3;
    private final com.baidu.tbadk.core.view.c mGuidPage = null;
    private DialogInterface.OnCancelListener mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ProxyAdkBaseActivity.this.mWaitingDialog = null;
        }
    };
    protected boolean mIsLogin = false;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                ProxyAdkBaseActivity.this.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        this.mSwipeBackLayout = new com.baidu.adp.widget.f(getActivity());
        this.mSwipeBackLayout.o(getActivity());
        this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            this.mSwipeBackLayout.setSwipeBackEnabled(false);
        }
        if (TbadkCoreApplication.m9getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getActivity());
        this.customToast = e.ud();
        super.onCreate(bundle);
        this.mLayoutMode = new c();
        this.mLayoutInflateFactory = new a();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getActivity());
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        ba.dC(getClass().getName());
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, com.baidu.adp.base.h
    public TbPageContext<T> getPageContext() {
        if (this.pageContext == null) {
            this.pageContext = new ProxyAdkBaseActivityPageContext(this);
        }
        return this.pageContext;
    }

    protected void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i = 0;
                try {
                    View rootView = ProxyAdkBaseActivity.this.getRootView();
                    if (rootView != null) {
                        i = rootView.getHeight();
                    }
                    int height = ProxyAdkBaseActivity.this.getWindow().getDecorView().getRootView().getHeight();
                    if (!ProxyAdkBaseActivity.this.mLayoutHasInit) {
                        ProxyAdkBaseActivity.this.mLayoutHasInit = true;
                        ProxyAdkBaseActivity.this.mMaxHeight = i;
                    } else {
                        ProxyAdkBaseActivity.this.mMaxHeight = ProxyAdkBaseActivity.this.mMaxHeight < i ? i : ProxyAdkBaseActivity.this.mMaxHeight;
                    }
                    if (ProxyAdkBaseActivity.this.mLayoutHasInit && ProxyAdkBaseActivity.this.mMaxHeight > i && i != ProxyAdkBaseActivity.this.mPreHeight) {
                        int i2 = ProxyAdkBaseActivity.this.mMaxHeight - i;
                        if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (height * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                            ProxyAdkBaseActivity.this.onKeyboardHeightChanged(i2);
                        }
                    }
                    ProxyAdkBaseActivity.this.mPreHeight = i;
                } catch (Exception e) {
                }
            }
        });
    }

    public void setActivityBgTransparent() {
        this.mSwipeBackLayout.ly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        try {
            return findViewById(16908290);
        } catch (Exception e) {
            return null;
        }
    }

    protected void onKeyboardHeightChanged(int i) {
    }

    protected void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            k.r(getPageContext().getPageActivity());
        }
    }

    protected void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            k.a(getPageContext().getPageActivity(), i, z);
        }
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
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

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
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

    protected void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        closeLoadingDialog();
        if (this.mGuidPage != null) {
            this.mGuidPage.vV();
        }
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        if (this.loadingRootView != null) {
            hideLoadingView(this.loadingRootView);
        }
        hideListMenu();
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void finish() {
        com.baidu.adp.lib.util.k.b(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity
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
            this.mProgressBar = new ProgressBar(getActivity());
            this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m9getInst().getResources().getDrawable(w.g.progressbar));
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(-2, -2, 17));
        }
        if (z && this.mProgressBar != null) {
            this.mProgressBar.bringToFront();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setPadding(com.baidu.adp.lib.util.k.dip2px(getActivity(), i), com.baidu.adp.lib.util.k.dip2px(getActivity(), i2), 0, 0);
            this.mProgressBar.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
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
        showLoadingDialog(str, null);
    }

    public void destroyWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (!isFinishing() && j.l(getActivity())) {
            String string = str != null ? str : TbadkCoreApplication.m9getInst().getResources().getString(w.l.Waiting);
            if (onCancelListener != null) {
                this.mWaitingDialog = ProgressDialog.show(getActivity(), "", string, true, true, onCancelListener);
            } else {
                this.mWaitingDialog = ProgressDialog.show(getActivity(), "", string, true, false, this.mDialogListener);
            }
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    j.b(this.mWaitingDialog, getActivity());
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

    protected void showToastWithIcon(String str, int i) {
        BdToast.b(getActivity(), str, i).tl();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getActivity(), str, i, i2).tl();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getActivity(), str, defaultIcon).tl();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getActivity(), str, defaultIcon, i).tl();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
            this.customToast.showToast(str, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(getActivity(), str);
        }
    }

    public void showToast(String str, int i) {
        this.customToast.b(str, 2000, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.m(i, 2000, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
            this.customToast.showToast(i, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(getActivity(), i);
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            com.baidu.adp.lib.util.k.showToast(getActivity(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            com.baidu.adp.lib.util.k.showToast(getActivity(), i);
        }
    }

    protected void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
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

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new DelayRunnable(view), i);
    }

    protected AlertDialog newListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(TbadkCoreApplication.m9getInst().getResources().getString(w.l.operation));
        builder.setItems(strArr, onClickListener);
        this.mListMenu = builder.create();
        this.mListMenu.setCanceledOnTouchOutside(true);
        return this.mListMenu;
    }

    protected AlertDialog createListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, onClickListener);
    }

    protected AlertDialog getListMenu() {
        return this.mListMenu;
    }

    protected void showListMenu() {
        if (this.mListMenu != null && !this.mListMenu.isShowing()) {
            j.a(this.mListMenu, getActivity());
        }
    }

    protected void hideListMenu() {
        if (this.mListMenu != null && this.mListMenu.isShowing()) {
            j.b(this.mListMenu, getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        super.onPause();
        this.customToast.onPause();
        TbadkCoreApplication.m9getInst().DelResumeNum();
    }

    protected void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        this.customToast.onResume();
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        TbadkCoreApplication.m9getInst().AddResumeNum();
        ba.dC(getClass().getName());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
    }

    protected void onUserChanged(boolean z) {
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            try {
                if (this.mUseStyleImmersiveSticky) {
                    this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
                }
                onChangeSkinType(this.mSkinType);
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onStop() {
        super.onStop();
        onResourceRecycle();
    }

    protected void onResourceRecycle() {
    }

    protected void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mSwipeBackLayout != null) {
            this.mSwipeBackLayout.onChangeSkinType(i);
        }
    }

    protected void quitDialog() {
        UtilHelper.quitDialog(getActivity());
    }

    /* loaded from: classes.dex */
    class DelayRunnable implements Runnable {
        private View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ProxyAdkBaseActivity.this.isFinishing()) {
                ProxyAdkBaseActivity.this.ShowSoftKeyPad((InputMethodManager) ProxyAdkBaseActivity.this.getSystemService("input_method"), this.mView);
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

    public a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity, com.baidu.adp.base.j
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        ag.a(bdListView, getUniqueId());
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean showDialog(Dialog dialog) {
        if (j.a(dialog, getActivity())) {
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
        j.b(dialog, getActivity());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                j.b(dialog, getActivity());
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
        j.a(popupWindow, getActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                j.a(popupWindow, getActivity());
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
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.4
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
                    synchronized (ProxyAdkBaseActivity.this.animationList) {
                        ProxyAdkBaseActivity.this.animationList.remove(weakReference);
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
                this.loadingView = new f(getPageContext().getContext());
            } else {
                this.loadingView = new f(getPageContext().getContext(), i);
            }
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
        return this.loadingView.DX();
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.H(view);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.refreshView.fQ(str);
        this.refreshView.c(view, z);
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public void hideNetRefreshView(View view) {
        if (this.refreshView != null) {
            this.refreshView.H(view);
        }
    }

    protected void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        if (this.refreshView != null && this.refreshView.DX() && this.refreshView.Ed() != null && (this.refreshView.Ed().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.refreshView.Ed().getLayoutParams()).topMargin = z ? BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT, false) : BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener(this, null);
        }
        return this.netRefreshListener;
    }

    protected void onNetRefreshButtonClicked() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class NetRefreshListener implements View.OnClickListener {
        private NetRefreshListener() {
        }

        /* synthetic */ NetRefreshListener(ProxyAdkBaseActivity proxyAdkBaseActivity, NetRefreshListener netRefreshListener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProxyAdkBaseActivity.this.onNetRefreshButtonClicked();
        }
    }

    public boolean isSwipeBackEnabled() {
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            return this.mSwipeBackLayout.isSwipeBackEnabled();
        }
        return false;
    }

    public void setSwipeBackEnabled(boolean z) {
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            this.mSwipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        this.mSwipeBackLayout.setIsSupportNight(z);
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }
}
