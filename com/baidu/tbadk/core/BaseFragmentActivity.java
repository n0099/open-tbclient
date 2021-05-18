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
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.KuangFloatingWindowController;
import com.baidu.tbadk.MainAPKFragmentActivityPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.j.e.q;
import d.a.j0.a.p;
import d.a.j0.a.s;
import d.a.j0.r.s.a;
import d.a.j0.z0.d0;
import d.a.j0.z0.g0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements TbPageContextSupport, d.a.j0.k0.a, p, Object, d.a.j0.j0.a {
    public static int flog = 1;
    public static Class<? extends TbPageContext<BaseFragmentActivity>> mClazz4GetPageContext = MainAPKFragmentActivityPageContext.class;
    public final int SHOW_SOFT_KEYBOARD_DELAY;
    public List<Animatable> animatableList;
    public List<WeakReference<View>> animationList;
    public List<Dialog> dialogList;
    public String fromPageName;
    public boolean isAddSwipeBackLayout;
    public long lastResumeTime;
    public View loadingRootView;
    public d.a.j0.d0.g loadingView;
    public int mAboveKeyboardHeight;
    public ViewGroup mActivityRootView;
    public d.a.j0.r.s.g mClickableTextToast;
    public String mCurAccountId;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public boolean mHideStatusImmersiveStyle;
    public boolean mIsHasScreenShotListener;
    public d.a.j0.r.f0.d mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public d.a.j0.r.c mLayoutMode;
    public int mMaxHeight;
    public d.a.j0.i0.c mPageExtra;
    public d.a.j0.r.e mPermissionCallback;
    public int mPreHeight;
    public ProgressBar mProgressBar;
    public d.a.j0.d0.h mRefreshView;
    public d0 mScreenShotListenManager;
    public SwipeBackLayout mSwipeBackLayout;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public VirtualBarAssist mVirtualBarAssist;
    public l netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<BaseFragmentActivity> pageContext;
    public d.a.j0.k0.d pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public d.a.c.e.m.c resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;
    public d.a.j0.r.f0.a mWaitingDialog = null;
    public DialogInterface.OnCancelListener mDialogListener = null;
    public int mSkinType = 3;
    public boolean mIsLogin = false;

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.r.e {
        public a() {
        }

        @Override // d.a.j0.r.e
        public void onPermissionResult(boolean z) {
            if (z) {
                TbadkCoreApplication.getInst().setCurrentActivity(BaseFragmentActivity.this.getPageContext().getPageActivity());
                if (KuangFloatingWindowController.getInstance().init()) {
                    TbSingleton.getInstance().isShowBackLabel = true;
                    KuangFloatingWindowController.getInstance().showFloatingView();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public final void a(int i2) {
            int height;
            View findViewById = BaseFragmentActivity.this.findViewById(16908290);
            if (findViewById instanceof ViewGroup) {
                boolean z = false;
                View childAt = ((ViewGroup) findViewById).getChildAt(0);
                if (childAt == null || (height = childAt.getHeight()) == BaseFragmentActivity.this.mAboveKeyboardHeight) {
                    return;
                }
                int i3 = (i2 * 2) / 3;
                boolean z2 = height < i3;
                if (BaseFragmentActivity.this.mAboveKeyboardHeight != 0 && BaseFragmentActivity.this.mAboveKeyboardHeight < i3) {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View findViewById = BaseFragmentActivity.this.findViewById(16908290);
                int height = findViewById != null ? findViewById.getHeight() : 0;
                int height2 = BaseFragmentActivity.this.getWindow().getDecorView().getRootView().getHeight();
                if (!BaseFragmentActivity.this.mLayoutHasInit) {
                    BaseFragmentActivity.this.mLayoutHasInit = true;
                    BaseFragmentActivity.this.mMaxHeight = height;
                } else {
                    BaseFragmentActivity.this.mMaxHeight = BaseFragmentActivity.this.mMaxHeight < height ? height : BaseFragmentActivity.this.mMaxHeight;
                }
                if (BaseFragmentActivity.this.mLayoutHasInit && BaseFragmentActivity.this.mMaxHeight > height && height != BaseFragmentActivity.this.mPreHeight) {
                    int i2 = BaseFragmentActivity.this.mMaxHeight - height;
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                        BaseFragmentActivity.this.onKeyboardHeightChanged(i2);
                    }
                }
                a(height2);
                BaseFragmentActivity.this.mPreHeight = height;
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseFragmentActivity.this.isFinishing()) {
                return;
            }
            g0.a(BaseFragmentActivity.this);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BaseFragmentActivity.this.mWaitingDialog = null;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f12087a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeakReference f12088b;

        public e(Animation.AnimationListener animationListener, WeakReference weakReference) {
            this.f12087a = animationListener;
            this.f12088b = weakReference;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f12087a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            synchronized (BaseFragmentActivity.this.animationList) {
                BaseFragmentActivity.this.animationList.remove(this.f12088b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f12087a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f12087a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005017 || BaseFragmentActivity.this.mLayoutMode == null) {
                return;
            }
            BaseFragmentActivity.this.mLayoutMode.l(null);
            if (BaseFragmentActivity.this.mKeyboardAdjust != null) {
                BaseFragmentActivity.this.mKeyboardAdjust.j(TbadkCoreApplication.getInst().getSkinType());
            }
            BaseFragmentActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseFragmentActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (BaseFragmentActivity.this.shouldChangeStatusBarIconAndTextColor()) {
                    boolean z = true;
                    if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        z = false;
                    }
                    UtilHelper.changeStatusBarIconAndTextColor(z, BaseFragmentActivity.this);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.e {
        public h() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            if (BaseFragmentActivity.this.mPermissionCallback != null) {
                BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.e {
        public i() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            try {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setData(Uri.parse("package:" + BaseFragmentActivity.this.getPackageName()));
                BaseFragmentActivity.this.startActivityForResult(intent, 12016);
            } catch (Exception unused) {
                BaseFragmentActivity.this.showToast(R.string.request_window_permission_default_text_by_yourself);
                if (BaseFragmentActivity.this.mPermissionCallback != null) {
                    BaseFragmentActivity.this.mPermissionCallback.onPermissionResult(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d0.b {
        public j() {
        }

        @Override // d.a.j0.z0.d0.b
        public void onShot(String str) {
            if (BaseFragmentActivity.this.getCurrentPageKey() != "a001" && BaseFragmentActivity.this.getCurrentPageKey() != "a005" && BaseFragmentActivity.this.getCurrentPageKey() != "a006") {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 4));
            }
            BaseFragmentActivity.this.onScreenShot(str);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public View f12095e;

        public k(View view) {
            this.f12095e = null;
            this.f12095e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseFragmentActivity.this.isFinishing()) {
                return;
            }
            BaseFragmentActivity.this.ShowSoftKeyPad((InputMethodManager) BaseFragmentActivity.this.getSystemService("input_method"), this.f12095e);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragmentActivity.this.onNetRefreshButtonClicked();
        }

        public /* synthetic */ l(BaseFragmentActivity baseFragmentActivity, b bVar) {
            this();
        }
    }

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
        this.setNoTranslucentRunnable = new c();
        this.nightResourcesChangeListener = new f(2005017);
        this.skinTypeChangeListener = new g(2001304);
    }

    private String getCurrentExtraPageKey() {
        String currentPageKey = getCurrentPageKey();
        return TextUtils.isEmpty(currentPageKey) ? getClass().getSimpleName() : currentPageKey;
    }

    private void hideClickableTextToast() {
        d.a.j0.r.s.g gVar = this.mClickableTextToast;
        if (gVar != null) {
            gVar.e();
        }
    }

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        mClazz4GetPageContext = cls;
    }

    private void startScreenShotListen() {
        d0 d0Var;
        if (this.mIsHasScreenShotListener || (d0Var = this.mScreenShotListenManager) == null) {
            return;
        }
        d0Var.i(new j());
        this.mScreenShotListenManager.j();
        this.mIsHasScreenShotListener = true;
    }

    private void stopScreenShotListen() {
        d0 d0Var;
        if (!this.mIsHasScreenShotListener || (d0Var = this.mScreenShotListenManager) == null) {
            return;
        }
        d0Var.k();
        this.mIsHasScreenShotListener = false;
    }

    public void DeinitWaitingDialog() {
        this.mWaitingDialog = null;
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

    @Deprecated
    public void ShowSoftKeyPadDelay(View view, int i2) {
        new Handler().postDelayed(new k(view), i2);
    }

    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void adjustResizeBottomVirtualBar() {
        if (this.mVirtualBarAssist == null) {
            this.mVirtualBarAssist = VirtualBarAssist.assistActivity(getActivity());
        }
    }

    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.j0.r.f0.d.c(getPageContext().getPageActivity());
        }
    }

    public void adjustResizeForSoftInputOnDestory() {
        d.a.j0.r.f0.d dVar = this.mKeyboardAdjust;
        if (dVar != null) {
            dVar.i();
            this.mKeyboardAdjust = null;
        }
    }

    public void adjustResizeForSoftInputOnSkinTypeChanged(int i2) {
        d.a.j0.r.f0.d dVar = this.mKeyboardAdjust;
        if (dVar != null) {
            dVar.j(i2);
        }
    }

    public void changeSkinType(int i2) {
        if (i2 != this.mSkinType) {
            this.mSkinType = i2;
            try {
                if (this.mSwipeBackLayout != null) {
                    this.mSwipeBackLayout.l(i2);
                }
                if (this.loadingView != null) {
                    this.loadingView.onChangeSkinType();
                }
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

    public boolean checkUpIsLogin() {
        return ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
    }

    public void clearAnimatable() {
        List<Animatable> list = this.animatableList;
        if (list != null) {
            try {
                synchronized (list) {
                    for (int i2 = 0; i2 < this.animatableList.size(); i2++) {
                        Animatable animatable = this.animatableList.get(i2);
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
                for (int i2 = 0; i2 < this.animationList.size(); i2++) {
                    try {
                        WeakReference<View> weakReference = this.animationList.get(i2);
                        if (weakReference != null && (view = weakReference.get()) != null) {
                            view.clearAnimation();
                        }
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
    }

    public void closeLoadingDialog() {
        d.a.j0.r.f0.a aVar = this.mWaitingDialog;
        if (aVar != null) {
            try {
                if (aVar.c()) {
                    this.mWaitingDialog.h(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    public void disableSwipeJustOnce() {
        SwipeBackLayout swipeBackLayout;
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.d();
    }

    public void dismissAllDialog() {
        List<Dialog> list = this.dialogList;
        if (list != null) {
            for (Dialog dialog : list) {
                d.a.c.e.m.g.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public void dismissAllPopupWindow() {
        List<PopupWindow> list = this.popupWindowList;
        if (list != null) {
            for (PopupWindow popupWindow : list) {
                d.a.c.e.m.g.d(popupWindow, getPageContext().getPageActivity());
            }
            this.popupWindowList.clear();
        }
    }

    public void dismissDialog(Dialog dialog) {
        List<Dialog> list = this.dialogList;
        if (list != null) {
            list.remove(dialog);
        }
        d.a.c.e.m.g.b(dialog, getPageContext());
    }

    public void dismissDialogInteface(DialogInterface dialogInterface) {
        if (dialogInterface instanceof Dialog) {
            dismissDialog((Dialog) dialogInterface);
        }
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        d.a.c.e.m.g.d(popupWindow, getPageContext().getPageActivity());
        List<PopupWindow> list = this.popupWindowList;
        if (list != null) {
            list.remove(popupWindow);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        s.a(motionEvent, getPageId(), getMissionTid());
        d.a.k0.i3.a.getInstance().behaviorRecordEvent(motionEvent, this);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
    }

    @Override // android.app.Activity
    public void finish() {
        d.a.c.e.p.l.x(getApplicationContext(), getWindow().getDecorView());
        dismissAllDialog();
        dismissAllPopupWindow();
        super.finish();
        closeAnimation();
    }

    public void fullScreen(boolean z) {
        if (getWindow() == null) {
            return;
        }
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

    public ViewGroup getActivityRootView() {
        return this.mActivityRootView;
    }

    @Override // d.a.j0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // d.a.j0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getStringArrayListExtra("obj_source");
        }
        return null;
    }

    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public d.a.j0.r.c getLayoutMode() {
        return this.mLayoutMode;
    }

    public d.a.j0.r.f0.a getLoadingDialog() {
        return this.mWaitingDialog;
    }

    public long getMissionTid() {
        return 0L;
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new l(this, null);
        }
        return this.netRefreshListener;
    }

    @Override // d.a.j0.k0.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.addAll(arrayList2);
        }
        if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
            if (!StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            Fragment visibleFragment = getVisibleFragment();
            if (visibleFragment instanceof d.a.j0.k0.a) {
                String currentPageKey2 = ((d.a.j0.k0.a) visibleFragment).getCurrentPageKey();
                if (!StringUtils.isNull(currentPageKey2)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(currentPageKey2);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public int getPageId() {
        BdUniqueId uniqueId = getUniqueId();
        if (uniqueId != null) {
            return uniqueId.getId();
        }
        return 0;
    }

    public d.a.j0.k0.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            d.a.j0.k0.d dVar = new d.a.j0.k0.d();
            this.pageStayDurationItem = dVar;
            dVar.p(getCurrentPageKey());
        }
        this.pageStayDurationItem.u(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    @Override // d.a.j0.k0.a
    public d.a.j0.k0.b getPageStayFilter() {
        return null;
    }

    public String getPreExtraPageKey() {
        d.a.j0.i0.c tbPageExtra = getTbPageExtra();
        return tbPageExtra != null ? tbPageExtra.d() : "";
    }

    public final TbPageTag getPrePageTag() {
        return d.a.j0.j0.c.m(getIntent());
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new d.a.c.e.m.c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public int getSkinType() {
        return TbadkCoreApplication.getInst().getSkinType();
    }

    public d.a.j0.i0.c getTbPageExtra() {
        if (this.mPageExtra == null) {
            this.mPageExtra = new d.a.j0.i0.c(getUniqueId(), getCurrentExtraPageKey(), getIntent());
        }
        return this.mPageExtra;
    }

    @Override // d.a.j0.j0.a
    public final d.a.j0.j0.b getTbPageInfo() {
        return new d.a.j0.j0.b(getUniqueId(), getTbPageTag(), getIntent());
    }

    public TbPageTag getTbPageTag() {
        if (this.mTbPageTag == null) {
            TbPageTag tbPageTag = new TbPageTag();
            this.mTbPageTag = tbPageTag;
            tbPageTag.locatePage = getCurrentPageKey();
        }
        return this.mTbPageTag;
    }

    public Fragment getVisibleFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
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

    public boolean grantWindowPermission(d.a.j0.r.e eVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(getBaseContext())) {
                this.mPermissionCallback = eVar;
                boolean g2 = d.a.j0.r.d0.b.j().g("key_is_window_permission_dialog_shown", false);
                if (z) {
                    g2 = false;
                }
                if (!g2) {
                    d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.setTitle(R.string.request_permission_default_title);
                    aVar.setMessageId(R.string.request_window_permission_default_text);
                    aVar.setPositiveButton(R.string.isopen, new i()).setNegativeButton(R.string.cancel, new h()).create(getPageContext());
                    aVar.show();
                    d.a.j0.r.d0.b.j().t("key_is_window_permission_dialog_shown", true);
                } else {
                    d.a.j0.r.e eVar2 = this.mPermissionCallback;
                    if (eVar2 != null) {
                        eVar2.onPermissionResult(false);
                    }
                }
                return false;
            } else if (eVar != null) {
                eVar.onPermissionResult(true);
            }
        } else if (eVar != null) {
            eVar.onPermissionResult(true);
        }
        return true;
    }

    public void hideFloatingWindow() {
        KuangFloatingWindowController.getInstance().hideFloatingView();
    }

    public void hideLoadingView(View view) {
        d.a.j0.d0.g gVar = this.loadingView;
        if (gVar != null) {
            gVar.dettachView(view);
        }
    }

    public void hideNetRefreshView(View view) {
        d.a.j0.d0.h hVar = this.mRefreshView;
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
        d.a.j0.d0.g gVar = this.loadingView;
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
        SwipeBackLayout swipeBackLayout;
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return false;
        }
        return swipeBackLayout.k();
    }

    public boolean isUseStyleImmersiveSticky() {
        return this.mUseStyleImmersiveSticky;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        d.a.j0.r.e eVar = this.mPermissionCallback;
        if (eVar != null && Build.VERSION.SDK_INT >= 23 && i2 == 12016) {
            eVar.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
            this.mPermissionCallback = null;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public abstract void onChangeSkinType(int i2);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration == null) {
            return;
        }
        int i2 = configuration.orientation;
        if (i2 == this.mLastOrientation) {
            if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                this.mLastScreenWidth = configuration.screenWidthDp;
                this.mLastScreenHeight = configuration.screenHeightDp;
                d.a.c.e.p.l.f39212a = false;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
            }
        } else {
            this.mLastOrientation = i2;
        }
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        if (this.isAddSwipeBackLayout) {
            SwipeBackLayout swipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
            this.mSwipeBackLayout = swipeBackLayout;
            swipeBackLayout.a(getPageContext().getPageActivity());
            this.mSwipeBackLayout.l(TbadkCoreApplication.getInst().getSkinType());
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                this.mSwipeBackLayout.setSwipeBackEnabled(false);
            }
        }
        if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity(), this.mHideStatusImmersiveStyle);
            UtilHelper.changeStatusBarIconAndTextColor((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true, this);
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        super.onCreate(bundle);
        if (getGpuSwitch()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        TbadkCoreApplication.setIsAppRunning(true);
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        this.mLayoutMode = new d.a.j0.r.c();
        registerListener(this.nightResourcesChangeListener);
        registerListener(this.skinTypeChangeListener);
        enterExitAnimation();
        this.mIsLogin = TbadkCoreApplication.isLogin();
        this.mScreenShotListenManager = new d0(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.mLayoutMode == null) {
            this.mLayoutMode = new d.a.j0.r.c();
        }
        this.mLayoutMode.i(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d.a.j0.r.c cVar = this.mLayoutMode;
        if (cVar != null) {
            cVar.c();
        }
        View view = this.loadingRootView;
        if (view != null) {
            hideLoadingView(view);
        }
        VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
        if (virtualBarAssist != null) {
            virtualBarAssist.onDestroy();
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
        d.a.c.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            try {
                if (keyEvent.isLongPress()) {
                    return true;
                }
            } catch (IllegalStateException unused) {
                if (i2 == 4) {
                    finish();
                    return true;
                }
                return false;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i2, keyEvent);
        } catch (IllegalStateException unused) {
            if (i2 == 4) {
                finish();
                return true;
            }
            return true;
        }
    }

    public void onKeyboardHeightChanged(int i2) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    @Override // d.a.j0.a.p
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        hideClickableTextToast();
        this.mClickableTextToast = s.i(completeTaskToastData);
        return true;
    }

    public void onNetRefreshButtonClicked() {
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        d.a.k0.i3.a.getInstance().onPause(this);
        super.onPause();
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            hideFloatingWindow();
        }
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d.a.j0.k0.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.v(currentTimeMillis);
            d.a.j0.k0.e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        stopScreenShotListen();
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
        VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
        if (virtualBarAssist != null) {
            virtualBarAssist.onPause();
        }
        if (this.isAddSwipeBackLayout) {
            d.a.c.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
            d.a.c.e.m.e.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, d.a.c.a.i
    public void onPreLoad(q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId());
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
            return;
        }
        boolean z = false;
        if (iArr[0] != 0) {
            PermissionJudgePolicy permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy;
            if (permissionJudgePolicy2 != null) {
                permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= strArr.length) {
                z = true;
                break;
            } else if (iArr[i3] != 0) {
                break;
            } else {
                i3++;
            }
        }
        if (!z || (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) == null) {
            return;
        }
        permissionJudgePolicy.onPermissionsGranted();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        flog = 0;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        d.a.k0.i3.a.getInstance().onResume(this);
        this.lastResumeTime = System.currentTimeMillis();
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TbadkCoreApplication.getInst().AddResumeNum();
        TiebaStaticHelper.setCurrentActivity(getClass().getName());
        TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
        boolean isLogin = TbadkCoreApplication.isLogin();
        String currentAccount = TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount();
        if (this.mIsLogin != isLogin || !StringHelper.equals(currentAccount, this.mCurAccountId)) {
            this.mCurAccountId = currentAccount;
            this.mIsLogin = isLogin;
            onUserChanged(isLogin);
        }
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
        }
        TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        setCurrentActivityTid();
        startScreenShotListen();
        VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
        if (virtualBarAssist != null) {
            virtualBarAssist.onResume();
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
        if (this.isAddSwipeBackLayout) {
            d.a.c.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
            g0.b(this);
        }
    }

    public void onScreenShot(String str) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        flog = 0;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            flog = 1;
        }
    }

    public void onUserChanged(boolean z) {
    }

    public void publishEvent(d.a.j0.f0.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        d.a.j0.f0.h.i(aVar);
    }

    public void registerResponsedEventListener(Class<? extends d.a.j0.f0.a> cls, d.a.j0.f0.i iVar) {
        d.a.j0.f0.h.f().m(cls, iVar, getUniqueId());
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.setBgTransparent();
        }
    }

    public void setCurrentActivityTid() {
        s.h(getPageId(), getMissionTid());
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
    }

    public void setHideStatusImmersiveStyle(boolean z) {
        this.mHideStatusImmersiveStyle = z;
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    public void setLayoutMode(d.a.j0.r.c cVar) {
        this.mLayoutMode = cVar;
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        d.a.j0.d0.h hVar = this.mRefreshView;
        if (hVar == null || !hVar.isViewAttached()) {
            return;
        }
        this.mRefreshView.j(i2);
    }

    public void setSkinType(int i2) {
        this.mSkinType = i2;
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setSwipeBackEnabled(z);
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.setIsSupportNight(z);
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        this.mUseStyleImmersiveSticky = z;
    }

    public boolean shouldChangeStatusBarIconAndTextColor() {
        return true;
    }

    public boolean showDialog(Dialog dialog) {
        if (d.a.c.e.m.g.j(dialog, getPageContext())) {
            if (this.dialogList == null) {
                this.dialogList = new LinkedList();
            }
            this.dialogList.add(dialog);
            return true;
        }
        return false;
    }

    public void showFloatingWindow() {
        grantWindowPermission(new a(), false);
    }

    public void showLoadingDialog(String str) {
        if (this.mDialogListener == null) {
            this.mDialogListener = new d();
        }
        if (!isFinishing() && d.a.c.e.m.g.f(getPageContext())) {
            d.a.j0.r.f0.a aVar = new d.a.j0.r.f0.a(getPageContext());
            this.mWaitingDialog = aVar;
            if (str != null) {
                aVar.j(str);
            } else {
                aVar.i(R.string.Waiting);
            }
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(false);
            this.mWaitingDialog.e(this.mDialogListener);
            this.mWaitingDialog.h(true);
        }
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        if (d.a.c.e.m.g.k(popupWindow, view)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        if (d.a.c.e.m.g.m(popupWindow, view, i2, i3, i4)) {
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

    public void showProgressBarWithOffset(int i2, int i3) {
        if (this.mProgressBar == null) {
            try {
                this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
            } catch (Throwable unused) {
                return;
            }
        }
        this.mProgressBar.setPadding(d.a.c.e.p.l.e(getPageContext().getContext(), i2), d.a.c.e.p.l.e(getPageContext().getContext(), i3), 0, 0);
        this.mProgressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        d.a.c.e.p.l.M(getPageContext().getContext(), str);
    }

    public void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i2) {
        BdToast.g(getPageContext().getContext(), str, defaultIcon, i2).q();
    }

    public void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        BdToast.f(getPageContext().getContext(), str, defaultIcon).q();
    }

    public void showToastWithIcon(String str, int i2) {
        BdToast.i(getPageContext().getContext(), str, i2, false).q();
    }

    public void showToastWithIconDuration(String str, int i2, int i3) {
        BdToast.h(getPageContext().getContext(), str, i2, i3, false).q();
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

    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        if (animation == null || isFinishing()) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(view);
        animation.setAnimationListener(new e(animationListener, weakReference));
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

    public void unRegisterResponsedEventListener() {
        d.a.j0.f0.h.f().n(getUniqueId());
    }

    public boolean videoNeedPreload() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, d.a.c.a.g
    public TbPageContext<BaseFragmentActivity> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(BaseFragmentActivity.class).newInstance(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.pageContext;
    }

    public void showLoadingView(View view, boolean z, int i2) {
        this.loadingRootView = view;
        if (this.loadingView == null) {
            if (i2 < 0) {
                this.loadingView = new d.a.j0.d0.g(getPageContext().getPageActivity());
            } else {
                d.a.j0.d0.g gVar = new d.a.j0.d0.g(getPageContext().getPageActivity(), i2);
                this.loadingView = gVar;
                gVar.h();
            }
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view, z);
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mRefreshView == null) {
            this.mRefreshView = new d.a.j0.d0.h(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.m(str);
        this.mRefreshView.l(str2);
        this.mRefreshView.g(str3);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.o();
    }

    public void showToast(int i2) {
        d.a.c.e.p.l.L(getPageContext().getContext(), i2);
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            d.a.c.e.p.l.M(getPageContext().getContext(), str);
        }
    }

    public void ShowSoftKeyPadDelay(View view) {
        ShowSoftKeyPadDelay(view, 150);
    }

    public void adjustResizeForSoftInput(int i2, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.j0.r.f0.d.d(getPageContext().getPageActivity(), i2, z);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i2, int i3) {
        if (d.a.c.e.m.g.l(popupWindow, view, i2, i3)) {
            if (this.popupWindowList == null) {
                this.popupWindowList = new LinkedList();
            }
            this.popupWindowList.add(popupWindow);
            return true;
        }
        return false;
    }

    public void showToast(int i2, boolean z) {
        if (z) {
            showToast(i2);
        } else {
            d.a.c.e.p.l.L(getPageContext().getContext(), i2);
        }
    }

    private void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.j0.r.f0.d.e(getPageContext().getPageActivity(), z);
        }
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        d.a.j0.r.f0.a aVar = new d.a.j0.r.f0.a(getPageContext());
        this.mWaitingDialog = aVar;
        if (str != null) {
            aVar.j(str);
        } else {
            aVar.i(R.string.Waiting);
        }
        this.mWaitingDialog.d(false);
        this.mWaitingDialog.f(true);
        this.mWaitingDialog.e(onCancelListener);
        this.mWaitingDialog.h(true);
    }
}
