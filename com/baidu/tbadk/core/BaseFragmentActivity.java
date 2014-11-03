package com.baidu.tbadk.core;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity {
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private List<Dialog> dialogList;
    private d mLayoutMode;
    private ProgressBar mProgressBar;
    private List<PopupWindow> popupWindowList;
    private com.baidu.adp.lib.g.d resourcesWrapper;
    protected ProgressDialog mWaitingDialog = null;
    private DialogInterface.OnCancelListener mDialogListener = null;
    protected int mSkinType = -1;
    private final CustomMessageListener nightResourcesChangeListener = new e(this, 2005017);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onChangeSkinType(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (TbadkApplication.m251getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(this);
        super.onCreate(bundle);
        TbadkApplication.setIsAppRunning(true);
        be.bR(getClass().getName());
        this.mLayoutMode = new d();
        registerListener(this.nightResourcesChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        changeSkinType(TbadkApplication.m251getInst().getSkinType());
        TbadkApplication.m251getInst().AddResumeNum();
        be.bR(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new com.baidu.adp.lib.g.d(super.getResources());
        }
        return this.resourcesWrapper;
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

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkApplication.m251getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        m.b(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
    }

    protected int getSkinType() {
        return TbadkApplication.m251getInst().getSkinType();
    }

    public d getLayoutMode() {
        return this.mLayoutMode;
    }

    public void setLayoutMode(d dVar) {
        this.mLayoutMode = dVar;
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new g(this);
        }
        if (!isFinishing() && com.baidu.adp.lib.g.j.e(this)) {
            if (str != null) {
                this.mWaitingDialog = ProgressDialog.show(this, "", str, true, false, this.mDialogListener);
            } else {
                this.mWaitingDialog = ProgressDialog.show(this, "", TbadkApplication.m251getInst().getResources().getString(y.Waiting), true, false, this.mDialogListener);
            }
        }
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", TbadkApplication.m251getInst().getResources().getString(y.Waiting), true, true, onCancelListener);
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    com.baidu.adp.lib.g.j.b(this.mWaitingDialog, this);
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
        m.showToast(this, str);
    }

    public void showToast(int i) {
        m.showToast(this, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToastWithIcon(String str, int i) {
        BdToast.a(this, str, i).lc();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(this, str, i, i2).lc();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(this, str, defaultIcon).lc();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(this, str, defaultIcon, i).lc();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.mLayoutMode == null) {
            this.mLayoutMode = new d();
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
            this.mProgressBar = new ProgressBar(this);
            this.mProgressBar.setIndeterminateDrawable(TbadkApplication.m251getInst().getResources().getDrawable(u.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.mProgressBar.setPadding(m.dip2px(this, i), m.dip2px(this, i2), 0, 0);
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
        if (com.baidu.adp.lib.g.j.a(dialog, this)) {
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
        com.baidu.adp.lib.g.j.b(dialog, this);
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                com.baidu.adp.lib.g.j.b(dialog, this);
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
        com.baidu.adp.lib.g.j.a(popupWindow, this);
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                com.baidu.adp.lib.g.j.a(popupWindow, this);
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
}
