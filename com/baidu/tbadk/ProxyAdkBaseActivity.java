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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.GuidPageView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import d.b.c.e.p.l;
import d.b.c.j.e.q;
import d.b.i0.d0.g;
import d.b.i0.d0.h;
import d.b.i0.r.a;
import d.b.i0.r.c;
import d.b.i0.r.f0.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ProxyAdkBaseActivity<T> extends PluginAdpBaseActivity implements IVideoNeedPreload {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public List<Animatable> animatableList;
    public List<WeakReference<View>> animationList;
    public CustomToast customToast;
    public List<Dialog> dialogList;
    public View loadingRootView;
    public g loadingView;
    public a mLayoutInflateFactory;
    public c mLayoutMode;
    public ProgressBar mProgressBar;
    public SwipeBackLayout mSwipeBackLayout;
    public ProxyAdkBaseActivity<T>.NetRefreshListener netRefreshListener;
    public TbPageContext<T> pageContext;
    public List<PopupWindow> popupWindowList;
    public h refreshView;
    public ProgressDialog mWaitingDialog = null;
    public AlertDialog mListMenu = null;
    public int mSkinType = 3;
    public final GuidPageView mGuidPage = null;
    public DialogInterface.OnCancelListener mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ProxyAdkBaseActivity.this.mWaitingDialog = null;
        }
    };
    public boolean mIsLogin = false;
    public boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    public boolean mLayoutHasInit = false;
    public int mMaxHeight = 0;
    public int mPreHeight = 0;
    public final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                ProxyAdkBaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    };

    /* loaded from: classes3.dex */
    public class DelayRunnable implements Runnable {
        public View mView;

        public DelayRunnable(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ProxyAdkBaseActivity.this.isFinishing()) {
                return;
            }
            ProxyAdkBaseActivity.this.ShowSoftKeyPad((InputMethodManager) ProxyAdkBaseActivity.this.getSystemService("input_method"), this.mView);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class LoadDataCallBack {
        public LoadDataCallBack() {
        }

        public abstract void callback(Object... objArr);

        public void onProgressUpdate(Object obj) {
        }
    }

    /* loaded from: classes3.dex */
    public class NetRefreshListener implements View.OnClickListener {
        public NetRefreshListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProxyAdkBaseActivity.this.onNetRefreshButtonClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        try {
            return findViewById(16908290);
        } catch (Exception unused) {
            return null;
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        if (view == null || inputMethodManager == null) {
            return;
        }
        try {
            inputMethodManager.showSoftInput(view, 0);
        } catch (Exception unused) {
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new DelayRunnable(view), i);
    }

    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View rootView = ProxyAdkBaseActivity.this.getRootView();
                    int height = rootView != null ? rootView.getHeight() : 0;
                    int height2 = ProxyAdkBaseActivity.this.getWindow().getDecorView().getRootView().getHeight();
                    if (!ProxyAdkBaseActivity.this.mLayoutHasInit) {
                        ProxyAdkBaseActivity.this.mLayoutHasInit = true;
                        ProxyAdkBaseActivity.this.mMaxHeight = height;
                    } else {
                        ProxyAdkBaseActivity.this.mMaxHeight = ProxyAdkBaseActivity.this.mMaxHeight < height ? height : ProxyAdkBaseActivity.this.mMaxHeight;
                    }
                    if (ProxyAdkBaseActivity.this.mLayoutHasInit && ProxyAdkBaseActivity.this.mMaxHeight > height && height != ProxyAdkBaseActivity.this.mPreHeight) {
                        int i = ProxyAdkBaseActivity.this.mMaxHeight - height;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i) && i < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i);
                            ProxyAdkBaseActivity.this.onKeyboardHeightChanged(i);
                        }
                    }
                    ProxyAdkBaseActivity.this.mPreHeight = height;
                } catch (Exception unused) {
                }
            }
        });
    }

    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            d.c(getPageContext().getPageActivity());
        }
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            try {
                if (this.mUseStyleImmersiveSticky) {
                    this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
                }
                onChangeSkinType(this.mSkinType);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public void clearAnimatable() {
        List<Animatable> list = this.animatableList;
        if (list != null) {
            try {
                synchronized (list) {
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

    public void clearAnimation() {
        View view;
        List<WeakReference<View>> list = this.animationList;
        if (list != null) {
            synchronized (list) {
                for (int i = 0; i < this.animationList.size(); i++) {
                    try {
                        WeakReference<View> weakReference = this.animationList.get(i);
                        if (weakReference != null && (view = weakReference.get()) != null) {
                            view.clearAnimation();
                        }
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void closeActivity() {
        finish();
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
    }

    public void closeLoadingDialog() {
        ProgressDialog progressDialog = this.mWaitingDialog;
        if (progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    d.b.c.e.m.g.a(this.mWaitingDialog, getActivity());
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public AlertDialog createListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog alertDialog = this.mListMenu;
        return alertDialog != null ? alertDialog : newListMenu(strArr, onClickListener);
    }

    public void destroyWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void dismissAllDialog() {
        List<Dialog> list = this.dialogList;
        if (list != null) {
            for (Dialog dialog : list) {
                d.b.c.e.m.g.a(dialog, getActivity());
            }
            this.dialogList.clear();
        }
    }

    public void dismissAllPopupWindow() {
        List<PopupWindow> list = this.popupWindowList;
        if (list != null) {
            for (PopupWindow popupWindow : list) {
                d.b.c.e.m.g.d(popupWindow, getActivity());
            }
            this.popupWindowList.clear();
        }
    }

    public void dismissDialog(Dialog dialog) {
        List<Dialog> list = this.dialogList;
        if (list != null) {
            list.remove(dialog);
        }
        d.b.c.e.m.g.a(dialog, getActivity());
    }

    public void dismissDialogInteface(DialogInterface dialogInterface) {
        if (dialogInterface instanceof Dialog) {
            dismissDialog((Dialog) dialogInterface);
        }
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        d.b.c.e.m.g.d(popupWindow, getActivity());
        List<PopupWindow> list = this.popupWindowList;
        if (list != null) {
            list.remove(popupWindow);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mProgressBar == null || !this.mProgressBar.isShown()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void finish() {
        l.w(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public AlertDialog getListMenu() {
        return this.mListMenu;
    }

    public ProgressDialog getLoadingDialog() {
        return this.mWaitingDialog;
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener();
        }
        return this.netRefreshListener;
    }

    public void hideListMenu() {
        AlertDialog alertDialog = this.mListMenu;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        d.b.c.e.m.g.a(this.mListMenu, getActivity());
    }

    public void hideLoadingView(View view) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.dettachView(view);
        }
    }

    public void hideNetRefreshView(View view) {
        h hVar = this.refreshView;
        if (hVar != null) {
            hVar.dettachView(view);
        }
    }

    public void hideProgressBar() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean isLoadingViewAttached() {
        g gVar = this.loadingView;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public boolean isProgressBarShown() {
        ProgressBar progressBar = this.mProgressBar;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public boolean isSwipeBackEnabled() {
        if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            return this.mSwipeBackLayout.k();
        }
        return false;
    }

    public AlertDialog newListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.operation));
        builder.setItems(strArr, onClickListener);
        AlertDialog create = builder.create();
        this.mListMenu = create;
        create.setCanceledOnTouchOutside(true);
        return this.mListMenu;
    }

    public void onChangeSkinType(int i) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.refreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.l(i);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        SwipeBackLayout swipeBackLayout = new SwipeBackLayout(getActivity());
        this.mSwipeBackLayout = swipeBackLayout;
        swipeBackLayout.a(getActivity());
        this.mSwipeBackLayout.l(TbadkCoreApplication.getInst().getSkinType());
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
            this.mSwipeBackLayout.setSwipeBackEnabled(false);
        }
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getActivity());
        this.customToast = CustomToast.newInstance();
        super.onCreate(bundle);
        this.mLayoutMode = new c();
        a aVar = new a();
        this.mLayoutInflateFactory = aVar;
        aVar.a(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getActivity());
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        closeLoadingDialog();
        GuidPageView guidPageView = this.mGuidPage;
        if (guidPageView != null) {
            guidPageView.b();
        }
        c cVar = this.mLayoutMode;
        if (cVar != null) {
            cVar.c();
        }
        View view = this.loadingRootView;
        if (view != null) {
            hideLoadingView(view);
        }
        hideListMenu();
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            try {
                if (keyEvent.isLongPress()) {
                    return true;
                }
            } catch (IllegalStateException unused) {
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
        } catch (IllegalStateException unused) {
            if (i == 4) {
                finish();
                return true;
            }
            return true;
        }
    }

    public void onKeyboardHeightChanged(int i) {
    }

    public void onNetRefreshButtonClicked() {
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        super.onPause();
        this.customToast.onPause();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        TbadkCoreApplication.getInst().DelResumeNum();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.b.c.a.i
    public void onPreLoad(q qVar) {
        super.onPreLoad(qVar);
        PreLoadImageHelper.load(qVar, getUniqueId());
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    public void onResourceRecycle() {
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        this.customToast.onResume();
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TbadkCoreApplication.getInst().AddResumeNum();
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(isLogin);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onStop() {
        super.onStop();
        onResourceRecycle();
    }

    public void onUserChanged(boolean z) {
    }

    public void quitDialog() {
        UtilHelper.quitDialog(getActivity());
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity
    public void releaseResouce() {
    }

    public void setActivityBgTransparent() {
        this.mSwipeBackLayout.setBgTransparent();
    }

    public void setLayoutInflate(a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        int a2;
        h hVar = this.refreshView;
        if (hVar == null || !hVar.isViewAttached() || this.refreshView.b() == null || !(this.refreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        if (z) {
            a2 = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, false);
        } else {
            a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
        ((ViewGroup.MarginLayoutParams) this.refreshView.b().getLayoutParams()).topMargin = a2;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
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

    public boolean showDialog(Dialog dialog) {
        if (d.b.c.e.m.g.i(dialog, getActivity())) {
            if (this.dialogList == null) {
                this.dialogList = new LinkedList();
            }
            this.dialogList.add(dialog);
            return true;
        }
        return false;
    }

    public void showListMenu() {
        AlertDialog alertDialog = this.mListMenu;
        if (alertDialog == null || alertDialog.isShowing()) {
            return;
        }
        d.b.c.e.m.g.i(this.mListMenu, getActivity());
    }

    public void showLoadingDialog(String str) {
        showLoadingDialog(str, null);
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.refreshView.l(str);
        this.refreshView.attachView(view, z);
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (d.b.c.e.m.g.k(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (d.b.c.e.m.g.m(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void showProgressBar() {
        try {
            showProgressBarWithOffset(0, 0);
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        showProgressBar(false, i, i2);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            l.L(getActivity(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
    }

    public void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.g(getActivity(), str, defaultIcon, i).q();
    }

    public void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.f(getActivity(), str, defaultIcon).q();
    }

    public void showToastWithIcon(String str, int i) {
        BdToast.i(getActivity(), str, i, false).q();
    }

    public void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.h(getActivity(), str, i, i2, false).q();
    }

    public void startAnimatable(Animatable animatable) {
        if (animatable == null || isFinishing()) {
            return;
        }
        if (this.animatableList == null) {
            this.animatableList = new ArrayList();
        }
        synchronized (this.animatableList) {
            this.animatableList.add(animatable);
        }
        try {
            animatable.start();
        } catch (Throwable unused) {
        }
    }

    public void startAnimation(View view, Animation animation, final Animation.AnimationListener animationListener) {
        if (animation == null || isFinishing()) {
            return;
        }
        final WeakReference<View> weakReference = new WeakReference<>(view);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.ProxyAdkBaseActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(animation2);
                }
                synchronized (ProxyAdkBaseActivity.this.animationList) {
                    ProxyAdkBaseActivity.this.animationList.remove(weakReference);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationRepeat(animation2);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationStart(animation2);
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
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.b.c.a.g
    public TbPageContext<T> getPageContext() {
        if (this.pageContext == null) {
            this.pageContext = new ProxyAdkBaseActivityPageContext(this);
        }
        return this.pageContext;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (!isFinishing() && d.b.c.e.m.g.e(getActivity())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.Waiting);
            }
            String str2 = str;
            if (onCancelListener != null) {
                this.mWaitingDialog = ProgressDialog.show(getActivity(), "", str2, true, true, onCancelListener);
            } else {
                this.mWaitingDialog = ProgressDialog.show(getActivity(), "", str2, true, false, this.mDialogListener);
            }
        }
    }

    public void showLoadingView(View view, boolean z, int i) {
        this.loadingRootView = view;
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new g(getPageContext().getContext());
            } else {
                this.loadingView = new g(getPageContext().getContext(), i);
            }
        }
        this.loadingView.attachView(view, z);
    }

    public void adjustResizeForSoftInput(int i, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            d.d(getPageContext().getPageActivity(), i, z);
        }
    }

    public void showProgressBar(boolean z, int i, int i2) {
        ProgressBar progressBar;
        if (this.mProgressBar == null) {
            ProgressBar progressBar2 = new ProgressBar(getActivity());
            this.mProgressBar = progressBar2;
            progressBar2.setIndeterminateDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.progressbar));
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(-2, -2, 17));
        }
        if (z && (progressBar = this.mProgressBar) != null) {
            progressBar.bringToFront();
        }
        ProgressBar progressBar3 = this.mProgressBar;
        if (progressBar3 != null) {
            progressBar3.setPadding(l.e(getActivity(), i), l.e(getActivity(), i2), 0, 0);
            this.mProgressBar.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (d.b.c.e.m.g.l(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public void showToast(String str, int i) {
        this.customToast.showToast(str, 2000, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.showToast(i, 2000, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str)) {
            l.K(getActivity(), i);
        } else {
            this.customToast.showToast(i, 2000);
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            l.L(getActivity(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            showToast(i);
        } else {
            l.K(getActivity(), i);
        }
    }
}
