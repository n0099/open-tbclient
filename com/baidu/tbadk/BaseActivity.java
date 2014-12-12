package com.baidu.tbadk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
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
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.d.f;
import com.baidu.tbadk.d.h;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
import com.compatible.menukey.MenuKeyUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport<T> {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    private List<Animatable> animatableList;
    private List<WeakReference<View>> animationList;
    private k customToast;
    private List<Dialog> dialogList;
    private f loadingView;
    private a mLayoutInflateFactory;
    private c mLayoutMode;
    private ProgressBar mProgressBar;
    private BaseActivity<T>.NetRefreshListener netRefreshListener;
    private TbPageContext<T> pageContext;
    private List<PopupWindow> popupWindowList;
    private h refreshView;
    private d resourcesWrapper;
    protected ProgressDialog mWaitingDialog = null;
    private AlertDialog mListMenu = null;
    protected int mSkinType = -1;
    private final o mGuidPage = null;
    private DialogInterface.OnCancelListener mDialogListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tbadk.BaseActivity.1
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BaseActivity.this.mWaitingDialog = null;
        }
    };
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.BaseActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && BaseActivity.this.mLayoutMode != null) {
                BaseActivity.this.mLayoutMode.a(null);
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            }
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.k
    public TbPageContext<T> getPageContext() {
        if (this.pageContext == null) {
            if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
                this.pageContext = new KuangAPKActivityPageContext(this);
            } else {
                this.pageContext = new MainAPKActivityPageContext(this);
            }
        }
        return this.pageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (TbadkCoreApplication.m255getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        this.customToast = k.oo();
        super.onCreate(bundle);
        this.mLayoutMode = new c();
        this.mLayoutInflateFactory = new a();
        this.mLayoutInflateFactory.a(this.mLayoutMode);
        getLayoutInflater().setFactory(this.mLayoutInflateFactory);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        bf.cJ(getClass().getName());
        registerListener(this.nightResourcesChangeListener);
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
                        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanSet(i2) && i2 < (height * 2) / 3 && TbadkCoreApplication.m255getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.m255getInst().setKeyboardHeight(i2);
                            BaseActivity.this.onKeyboardHeightChanged(i2);
                        }
                    }
                    BaseActivity.this.mPreHeight = i;
                } catch (Exception e) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new d(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public boolean getGpuSwitch() {
        return false;
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
            this.mGuidPage.qt();
        }
        if (this.mLayoutMode != null) {
            this.mLayoutMode.destroy();
        }
        hideListMenu();
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        l.c(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
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
            this.mProgressBar = new ProgressBar(getPageContext().getContext());
            this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m255getInst().getResources().getDrawable(v.progressbar));
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(-2, -2, 17));
        }
        if (z && this.mProgressBar != null) {
            this.mProgressBar.bringToFront();
        }
        this.mProgressBar.setPadding(l.dip2px(getPageContext().getPageActivity(), i), l.dip2px(getPageContext().getPageActivity(), i2), 0, 0);
        this.mProgressBar.setVisibility(0);
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
        showLoadingDialog(str, null);
    }

    public void destroyWaitingDialog() {
        this.mWaitingDialog = null;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (!isFinishing() && com.baidu.adp.lib.g.k.a(getPageContext())) {
            String string = str != null ? str : TbadkCoreApplication.m255getInst().getResources().getString(z.Waiting);
            if (onCancelListener != null) {
                this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", string, true, true, onCancelListener);
            } else {
                this.mWaitingDialog = ProgressDialog.show(getPageContext().getContext(), "", string, true, false, this.mDialogListener);
            }
        }
    }

    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    com.baidu.adp.lib.g.k.b(this.mWaitingDialog, getPageContext());
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
        BdToast.a(getPageContext().getContext(), str, i).nY();
    }

    protected void showToastWithIconDuration(String str, int i, int i2) {
        BdToast.a(getPageContext().getContext(), str, i, i2).nY();
    }

    protected void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon).nY();
    }

    protected void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        BdToast.a(getPageContext().getContext(), str, defaultIcon, i).nY();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
            this.customToast.showToast(str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
        } else {
            l.showToast(getPageContext().getContext(), str);
        }
    }

    public void showToast(String str, int i) {
        this.customToast.c(str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI, i);
    }

    public void showToast(int i, int i2) {
        this.customToast.p(i, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI, i2);
    }

    public void showToast(int i) {
        String name = getClass().getName();
        String str = String.valueOf(getApplicationContext().getPackageName()) + ".chat";
        if (name.startsWith(String.valueOf(getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
            this.customToast.showToast(i, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
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

    /* JADX INFO: Access modifiers changed from: protected */
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

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new DelayRunnable(view), i);
    }

    protected AlertDialog newListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getContext());
        builder.setTitle(TbadkCoreApplication.m255getInst().getResources().getString(z.operation));
        builder.setItems(strArr, onClickListener);
        this.mListMenu = builder.create();
        this.mListMenu.setCanceledOnTouchOutside(true);
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog createListMenu(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return this.mListMenu != null ? this.mListMenu : newListMenu(strArr, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog getListMenu() {
        return this.mListMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListMenu() {
        if (this.mListMenu != null && !this.mListMenu.isShowing()) {
            com.baidu.adp.lib.g.k.a(this.mListMenu, getPageContext().getPageActivity());
        }
    }

    protected void hideListMenu() {
        if (this.mListMenu != null && this.mListMenu.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.mListMenu, getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.customToast.onPause();
        TbadkCoreApplication.m255getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        this.customToast.onResume();
        changeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
        TbadkCoreApplication.m255getInst().AddResumeNum();
        bf.cJ(getClass().getName());
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
            this.loadingView.wc();
        }
        if (this.refreshView != null) {
            this.refreshView.wc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void quitDialog() {
        UtilHelper.quitDialog(getPageContext().getPageActivity());
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

    public a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public void setLayoutInflate(a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.l
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        as.a(bdListView, getUniqueId());
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean showDialog(Dialog dialog) {
        if (com.baidu.adp.lib.g.k.a(dialog, getPageContext())) {
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
        com.baidu.adp.lib.g.k.b(dialog, getPageContext());
    }

    public void dismissAllDialog() {
        if (this.dialogList != null) {
            for (Dialog dialog : this.dialogList) {
                com.baidu.adp.lib.g.k.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        if (com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(popupWindow, view, i, i2)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, view, i, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        com.baidu.adp.lib.g.k.a(popupWindow, getPageContext().getPageActivity());
        if (this.popupWindowList != null) {
            this.popupWindowList.remove(popupWindow);
        }
    }

    public void dismissAllPopupWindow() {
        if (this.popupWindowList != null) {
            for (PopupWindow popupWindow : this.popupWindowList) {
                com.baidu.adp.lib.g.k.a(popupWindow, getPageContext().getPageActivity());
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
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new f(getPageContext().getContext());
            } else {
                this.loadingView = new f(getPageContext().getContext(), i);
            }
            this.loadingView.wc();
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
        return this.loadingView.vW();
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.p(view);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.refreshView.es(str);
        this.refreshView.b(view, z);
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public void hideNetRefreshView(View view) {
        if (this.refreshView != null) {
            this.refreshView.p(view);
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

    /* JADX INFO: Access modifiers changed from: package-private */
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
}
