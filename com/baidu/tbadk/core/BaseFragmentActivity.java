package com.baidu.tbadk.core;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.MainAPKFragmentActivityPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements TbPageContextSupport<BaseFragmentActivity> {
    private static Class<? extends TbPageContext<BaseFragmentActivity>> mClazz4GetPageContext = MainAPKFragmentActivityPageContext.class;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private List<Dialog> dialogList;
    private View loadingRootView;
    private com.baidu.tbadk.e.f loadingView;
    private c mLayoutMode;
    private ProgressBar mProgressBar;
    private com.baidu.adp.widget.f mSwipeBackLayout;
    private TbPageContext<BaseFragmentActivity> pageContext;
    private List<PopupWindow> popupWindowList;
    private com.baidu.adp.lib.g.c resourcesWrapper;
    protected ProgressDialog mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;
    protected int mSkinType = 3;
    protected boolean mIsLogin = false;
    private final int SHOW_SOFT_KEYBOARD_DELAY = SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED;
    private boolean isAddSwipeBackLayout = true;
    private boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    private final CustomMessageListener nightResourcesChangeListener = new d(this, CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE);
    private final CustomMessageListener skinTypeChangeListener = new e(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onChangeSkinType(int i);

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        mClazz4GetPageContext = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.i
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

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.isAddSwipeBackLayout) {
            this.mSwipeBackLayout = new com.baidu.adp.widget.f(getPageContext().getPageActivity());
            this.mSwipeBackLayout.n(getPageContext().getPageActivity());
            this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (TbadkCoreApplication.m411getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        if (this.mUseStyleImmersiveSticky) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        super.onCreate(bundle);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        aw.dn(getClass().getName());
        this.mLayoutMode = new c();
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

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    protected void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            com.baidu.tbadk.core.view.i.r(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        TbadkCoreApplication.m411getInst().AddResumeNum();
        aw.dn(getClass().getName());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserChanged(boolean z) {
    }

    protected void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new com.baidu.adp.lib.g.c(super.getResources());
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
                    this.loadingView.tc();
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
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkCoreApplication.m411getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        if (this.loadingRootView != null) {
            hideLoadingView(this.loadingRootView);
        }
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.adp.lib.util.k.c(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    protected int getSkinType() {
        return TbadkCoreApplication.m411getInst().getSkinType();
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new g(this);
        }
        if (!isFinishing() && com.baidu.adp.lib.g.j.a(getPageContext())) {
            if (str != null) {
                this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", str, true, false, this.mDialogListener);
            } else {
                this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", TbadkCoreApplication.m411getInst().getResources().getString(i.h.Waiting), true, false, this.mDialogListener);
            }
        }
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", TbadkCoreApplication.m411getInst().getResources().getString(i.h.Waiting), true, true, onCancelListener);
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), str);
    }

    public void showToast(int i) {
        com.baidu.adp.lib.util.k.showToast(getPageContext().getContext(), i);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdToast.b(getPageContext().getContext(), str, i).sZ();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getPageContext().getContext(), str, i, i2).sZ();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon).sZ();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon, i).sZ();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.mLayoutMode == null) {
            this.mLayoutMode = new c();
        }
        this.mLayoutMode.a(str, context, attributeSet);
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m411getInst().getResources().getDrawable(i.e.progressbar));
                ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
            } catch (Throwable th) {
                return;
            }
        }
        this.mProgressBar.setPadding(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), i), com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), i2), 0, 0);
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
                this.loadingView = new com.baidu.tbadk.e.f(getPageContext().getPageActivity());
            } else {
                this.loadingView = new com.baidu.tbadk.e.f(getPageContext().getPageActivity(), i);
            }
            this.loadingView.tc();
        }
        this.loadingView.b(view, z);
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.Cq();
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.u(view);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
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
        if (com.baidu.adp.lib.g.j.a(dialog, getPageContext())) {
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
        com.baidu.adp.lib.g.j.b(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                com.baidu.adp.lib.g.j.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        com.baidu.adp.lib.g.j.a(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                com.baidu.adp.lib.g.j.a(popupWindow, getPageContext().getPageActivity());
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

    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        if (animation != null && !isFinishing()) {
            WeakReference<View> weakReference = new WeakReference<>(view);
            animation.setAnimationListener(new h(this, animationListener, weakReference));
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
            this.mSwipeBackLayout.oa();
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
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
        ShowSoftKeyPadDelay(view, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }
}
