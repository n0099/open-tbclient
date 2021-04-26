package com.baidu.tbadk;

import android.animation.Animator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
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
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.GuidPageView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.e.p.l;
import d.a.c.j.e.q;
import d.a.i0.a.o;
import d.a.i0.a.r;
import d.a.i0.d0.g;
import d.a.i0.d0.h;
import d.a.i0.f0.i;
import d.a.i0.k0.a;
import d.a.i0.k0.d;
import d.a.i0.r.c;
import d.a.i0.r.e;
import d.a.i0.r.s.a;
import d.a.i0.r.s.b;
import d.a.i0.z0.d0;
import d.a.i0.z0.g0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport, a, IVideoNeedPreload, o, Object {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    public static int flog = 1;
    public static Class<? extends TbPageContext> mClazz4GetPageContext = MainAPKActivityPageContext.class;
    public List<Animatable> animatableList;
    public List<WeakReference<View>> animationList;
    public CustomToast customToast;
    public List<Dialog> dialogList;
    public long lastResumeTime;
    public View loadingRootView;
    public g loadingView;
    public d.a.i0.r.s.g mClickableTextToast;
    public d.a.i0.r.a mLayoutInflateFactory;
    public c mLayoutMode;
    public e mPermissionCallback;
    public ContinuousAnimationView mProgressBar;
    public h mRefreshView;
    public d0 mScreenShotListenManager;
    public SwipeBackLayout mSwipeBackLayout;
    public d.a.i0.i0.c mTbPageExtra;
    public TbPageTag mTbPageTag;
    public BaseActivity<T>.NetRefreshListener netRefreshListener;
    public TbPageContext<T> pageContext;
    public d pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public d.a.c.e.m.c resourcesWrapper;
    public d.a.i0.r.f0.a mWaitingDialog = null;
    public b mListMenu = null;
    public final Handler mSafeHandler = new Handler();
    public int mSkinType = 3;
    public final GuidPageView mGuidPage = null;
    public int mLastScreenWidth = 0;
    public int mLastScreenHeight = 0;
    public int mLastOrientation = 1;
    public boolean mIsHasScreenShotListener = false;
    public boolean mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
    public boolean mIsLogin = false;
    public d.a.i0.r.f0.d mKeyboardAdjust = null;
    public boolean isAddSwipeBackLayout = true;
    public boolean mLayoutHasInit = false;
    public int mMaxHeight = 0;
    public int mPreHeight = 0;
    public int mAboveKeyboardHeight = 0;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy = null;
    public final Animator.AnimatorListener loadViewAnimListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.BaseActivity.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            BaseActivity.this.mProgressBar.setSpeed(1.0f);
            BaseActivity.this.mProgressBar.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    };
    public Runnable setNoTranslucentRunnable = new Runnable() { // from class: com.baidu.tbadk.BaseActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (BaseActivity.this.isFinishing()) {
                return;
            }
            g0.a(BaseActivity.this);
        }
    };
    public final CustomMessageListener nightResourcesChangeListener = new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.BaseActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005017 || BaseActivity.this.mLayoutMode == null) {
                return;
            }
            BaseActivity.this.mLayoutMode.l(null);
            BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    };
    public final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tbadk.BaseActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                BaseActivity.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                boolean z = true;
                if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                    z = false;
                }
                UtilHelper.changeStatusBarIconAndTextColor(z, BaseActivity.this);
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
            if (BaseActivity.this.isFinishing()) {
                return;
            }
            BaseActivity.this.ShowSoftKeyPad((InputMethodManager) BaseActivity.this.getSystemService("input_method"), this.mView);
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
            BaseActivity.this.onNetRefreshButtonClicked();
        }
    }

    private void adjustResizeForSoftInputOnDestory() {
        d.a.i0.r.f0.d dVar = this.mKeyboardAdjust;
        if (dVar != null) {
            dVar.i();
            this.mKeyboardAdjust = null;
        }
    }

    private String getCurrentExtraPageKey() {
        String currentPageKey = getCurrentPageKey();
        return TextUtils.isEmpty(currentPageKey) ? getClass().getSimpleName() : currentPageKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        try {
            return findViewById(16908290);
        } catch (Exception unused) {
            return null;
        }
    }

    private void hideClickableTextToast() {
        d.a.i0.r.s.g gVar = this.mClickableTextToast;
        if (gVar != null) {
            gVar.e();
        }
    }

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        mClazz4GetPageContext = cls;
    }

    private void startScreenShotListen() {
        d0 d0Var;
        if (!PermissionUtil.isAgreePrivacyPolicy() || this.mIsHasScreenShotListener || (d0Var = this.mScreenShotListenManager) == null) {
            return;
        }
        d0Var.i(new d0.b() { // from class: com.baidu.tbadk.BaseActivity.9
            @Override // d.a.i0.z0.d0.b
            public void onShot(String str) {
                if (BaseActivity.this.getCurrentPageKey() != "a001" && BaseActivity.this.getCurrentPageKey() != "a005" && BaseActivity.this.getCurrentPageKey() != "a006") {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 4));
                }
                BaseActivity.this.onScreenShot(str);
            }
        });
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
        new Handler().postDelayed(new DelayRunnable(view), i2);
    }

    public void addGlobalLayoutListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.BaseActivity.1
            private void raiseOnKeyboardVisibilityChanged(int i2) {
                View rootView = BaseActivity.this.getRootView();
                if (rootView instanceof ViewGroup) {
                    boolean z = false;
                    View childAt = ((ViewGroup) rootView).getChildAt(0);
                    if (childAt == null) {
                        return;
                    }
                    Rect rect = new Rect();
                    childAt.getWindowVisibleDisplayFrame(rect);
                    int i3 = rect.bottom - rect.top;
                    if (i3 != BaseActivity.this.mAboveKeyboardHeight) {
                        int i4 = (i2 * 2) / 3;
                        boolean z2 = i3 < i4;
                        if (BaseActivity.this.mAboveKeyboardHeight != 0 && BaseActivity.this.mAboveKeyboardHeight < i4) {
                            z = true;
                        }
                        if (z2 != z) {
                            BaseActivity.this.onKeyboardVisibilityChanged(z2);
                            if (TbSingleton.getInstance().isShowBackLabel && BaseActivity.this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z)));
                            }
                        }
                        BaseActivity.this.mAboveKeyboardHeight = i3;
                    }
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View rootView = BaseActivity.this.getRootView();
                    int height = rootView != null ? rootView.getHeight() : 0;
                    int height2 = BaseActivity.this.getWindow().getDecorView().getRootView().getHeight();
                    if (!BaseActivity.this.mLayoutHasInit) {
                        BaseActivity.this.mLayoutHasInit = true;
                        BaseActivity.this.mMaxHeight = height;
                    } else {
                        BaseActivity.this.mMaxHeight = BaseActivity.this.mMaxHeight < height ? height : BaseActivity.this.mMaxHeight;
                    }
                    if (BaseActivity.this.mLayoutHasInit && BaseActivity.this.mMaxHeight > height && height != BaseActivity.this.mPreHeight) {
                        int i2 = BaseActivity.this.mMaxHeight - height;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                            BaseActivity.this.onKeyboardHeightChanged(i2);
                        }
                    }
                    raiseOnKeyboardVisibilityChanged(height2);
                    BaseActivity.this.mPreHeight = height;
                } catch (Exception unused) {
                }
            }
        });
    }

    public void adjustResizeForSoftInput() {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.i0.r.f0.d.c(getPageContext().getPageActivity());
        }
    }

    public void changeSkinType(int i2) {
        if (i2 != this.mSkinType) {
            this.mSkinType = i2;
            try {
                onChangeSkinType(i2);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void changeSwipeSkinType(int i2) {
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.f(i2);
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

    public void closeActivity() {
        finish();
    }

    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
    }

    public void closeLoadingDialog() {
        d.a.i0.r.f0.a aVar = this.mWaitingDialog;
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

    public b createListMenu(String[] strArr, b.c cVar) {
        b bVar = this.mListMenu;
        return bVar != null ? bVar : newListMenu(strArr, cVar);
    }

    public void destroyWaitingDialog() {
        this.mWaitingDialog = null;
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
        r.a(motionEvent, getPageId(), getMissionTid());
        d.a.j0.i3.a.getInstance().behaviorRecordEvent(motionEvent, this);
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

    @Override // android.app.Activity
    public void finish() {
        l.x(getApplicationContext(), getWindow().getDecorView());
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

    @Override // d.a.i0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // d.a.i0.k0.a
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

    public d.a.i0.r.a getLayoutInflate() {
        return this.mLayoutInflateFactory;
    }

    public c getLayoutMode() {
        return this.mLayoutMode;
    }

    public b getListMenu() {
        return this.mListMenu;
    }

    public d.a.i0.r.f0.a getLoadingDialog() {
        return this.mWaitingDialog;
    }

    public g getLoadingView() {
        return this.loadingView;
    }

    public long getMissionTid() {
        return 0L;
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener();
        }
        return this.netRefreshListener;
    }

    @Override // d.a.i0.k0.a
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

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            d dVar = new d();
            this.pageStayDurationItem = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.p(getCurrentPageKey());
        }
        return this.pageStayDurationItem;
    }

    @Override // d.a.i0.k0.a
    public d.a.i0.k0.b getPageStayFilter() {
        return null;
    }

    public String getPreExtraPageKey() {
        d.a.i0.i0.c tbPageExtra = getTbPageExtra();
        return tbPageExtra != null ? tbPageExtra.d() : "";
    }

    public final TbPageTag getPrePageTag() {
        return d.a.i0.j0.c.m(getIntent());
    }

    public h getRefreshView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        return this.mRefreshView;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null) {
            this.resourcesWrapper = new d.a.c.e.m.c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public Handler getSafeHandler() {
        return this.mSafeHandler;
    }

    public d.a.i0.i0.c getTbPageExtra() {
        if (this.mTbPageExtra == null) {
            this.mTbPageExtra = new d.a.i0.i0.c(getUniqueId(), getCurrentExtraPageKey(), getIntent());
        }
        return this.mTbPageExtra;
    }

    public final d.a.i0.j0.b getTbPageInfo() {
        return new d.a.i0.j0.b(getUniqueId(), getTbPageTag(), getIntent());
    }

    public TbPageTag getTbPageTag() {
        if (this.mTbPageTag == null) {
            TbPageTag tbPageTag = new TbPageTag();
            this.mTbPageTag = tbPageTag;
            tbPageTag.locatePage = getCurrentPageKey();
        }
        return this.mTbPageTag;
    }

    public boolean grantWindowPermission(e eVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(getBaseContext())) {
                this.mPermissionCallback = eVar;
                if (!d.a.i0.r.d0.b.j().g("key_is_window_permission_dialog_shown", false)) {
                    d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.setTitle(R.string.request_permission_default_title);
                    aVar.setMessageId(R.string.request_window_permission_default_text);
                    aVar.setPositiveButton(R.string.isopen, new a.e() { // from class: com.baidu.tbadk.BaseActivity.8
                        @Override // d.a.i0.r.s.a.e
                        public void onClick(d.a.i0.r.s.a aVar2) {
                            aVar2.dismiss();
                            try {
                                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                intent.setData(Uri.parse("package:" + BaseActivity.this.getPackageName()));
                                BaseActivity.this.startActivityForResult(intent, 12016);
                            } catch (Exception unused) {
                                BaseActivity.this.showToast(R.string.request_window_permission_default_text_by_yourself);
                                if (BaseActivity.this.mPermissionCallback != null) {
                                    BaseActivity.this.mPermissionCallback.onPermissionResult(false);
                                }
                            }
                        }
                    }).setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tbadk.BaseActivity.7
                        @Override // d.a.i0.r.s.a.e
                        public void onClick(d.a.i0.r.s.a aVar2) {
                            aVar2.dismiss();
                            if (BaseActivity.this.mPermissionCallback != null) {
                                BaseActivity.this.mPermissionCallback.onPermissionResult(false);
                            }
                        }
                    }).create(getPageContext());
                    aVar.show();
                    d.a.i0.r.d0.b.j().t("key_is_window_permission_dialog_shown", true);
                } else {
                    e eVar2 = this.mPermissionCallback;
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

    public void hideListMenu() {
        b bVar = this.mListMenu;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void hideLoadingView(View view) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.dettachView(view);
        }
    }

    public void hideNetRefreshView(View view) {
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(view);
        }
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView = this.mProgressBar;
        if (continuousAnimationView != null) {
            continuousAnimationView.setVisibility(8);
            this.mProgressBar.cancelAnimation();
        }
    }

    public boolean isLoadingViewAttached() {
        g gVar = this.loadingView;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public boolean isLogin() {
        return this.mIsLogin;
    }

    public boolean isProgressBarShown() {
        ContinuousAnimationView continuousAnimationView = this.mProgressBar;
        return continuousAnimationView != null && continuousAnimationView.getVisibility() == 0;
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

    public b newListMenu(String[] strArr, b.c cVar) {
        b bVar = new b(getPageContext().getPageActivity());
        this.mListMenu = bVar;
        bVar.l(TbadkCoreApplication.getInst().getResources().getString(R.string.operation));
        this.mListMenu.j(strArr, cVar);
        this.mListMenu.c(getPageContext());
        return this.mListMenu;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        e eVar = this.mPermissionCallback;
        if (eVar != null && Build.VERSION.SDK_INT >= 23 && i2 == 12016) {
            eVar.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
            this.mPermissionCallback = null;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onChangeSkinType(int i2) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.l(i2);
        }
        d.a.i0.r.f0.d dVar = this.mKeyboardAdjust;
        if (dVar != null) {
            dVar.j(i2);
        }
        if (this.mUseStyleImmersiveSticky) {
            this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        }
        b bVar = this.mListMenu;
        if (bVar != null) {
            bVar.b(getPageContext());
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
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
                l.f39967a = false;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
            }
        } else {
            this.mLastOrientation = i2;
        }
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
            TbadkCoreApplication.getInst().setExitAppCloseWebSocket(false);
            TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
        this.customToast = CustomToast.newInstance();
        super.onCreate(bundle);
        this.mLayoutMode = new c();
        d.a.i0.r.a aVar = new d.a.i0.r.a();
        this.mLayoutInflateFactory = aVar;
        aVar.a(this.mLayoutMode);
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
        this.mScreenShotListenManager = new d0(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
        adjustResizeForSoftInputOnDestory();
        hideClickableTextToast();
        hideListMenu();
        clearAnimatable();
        clearAnimation();
        unRegisterResponsedEventListener();
        this.pageStayDurationItem = null;
        this.mTbPageTag = null;
        this.mTbPageExtra = null;
        this.mPermissionCallback = null;
        super.onDestroy();
        this.mSafeHandler.removeCallbacksAndMessages(null);
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

    @Override // d.a.i0.a.o
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        hideClickableTextToast();
        this.mClickableTextToast = r.i(completeTaskToastData);
        return true;
    }

    public void onNetRefreshButtonClicked() {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        d.a.j0.i3.a.getInstance().onPause(this);
        super.onPause();
        if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            hideFloatingWindow();
        }
        if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.v(currentTimeMillis);
            d.a.i0.k0.e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
        }
        this.customToast.onPause();
        stopScreenShotListen();
        TbadkCoreApplication.getInst().DelResumeNum();
        TbadkCoreApplication.getInst().setCurrentActivity(null);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
        if (this.isAddSwipeBackLayout) {
            d.a.c.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
            d.a.c.e.m.e.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, d.a.c.a.i
    public void onPreLoad(q qVar) {
        super.onPreLoad(qVar);
        PreLoadImageHelper.load(qVar, getUniqueId());
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        PermissionJudgePolicy permissionJudgePolicy2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
            return;
        }
        boolean z = false;
        if (iArr[0] != 0 && (permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy) != null) {
            permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
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

    public void onResourceRecycle() {
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        flog = 0;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        d.a.j0.i3.a.getInstance().onResume(this);
        this.lastResumeTime = System.currentTimeMillis();
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
        if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
        }
        TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        setCurrentActivityTid();
        startScreenShotListen();
        TbSingleton.getInstance().getClass();
        if (!"BaseActivity".equals(TbSingleton.getInstance().isSwitchActivity)) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            TbSingleton.getInstance().getClass();
            tbSingleton.isSwitchActivity = "BaseActivity";
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

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        flog = 0;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
            flog = 1;
        }
        onResourceRecycle();
    }

    public void onUserChanged(boolean z) {
    }

    public void publishEvent(d.a.i0.f0.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        d.a.i0.f0.h.i(aVar);
    }

    public void quitDialog() {
        UtilHelper.quitDialog(getPageContext().getPageActivity());
    }

    public void registerResponsedEventListener(Class<? extends d.a.i0.f0.a> cls, i iVar) {
        d.a.i0.f0.h.f().m(cls, iVar, getUniqueId());
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
        if (swipeBackLayout != null) {
            swipeBackLayout.setBgTransparent();
        }
    }

    public void setCurrentActivityTid() {
        r.h(getPageId(), getMissionTid());
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
    }

    public void setExcludeHeight(int i2) {
        d.a.i0.r.f0.d dVar = this.mKeyboardAdjust;
        if (dVar != null) {
            dVar.m(i2);
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        this.isAddSwipeBackLayout = z;
    }

    public void setLayoutInflate(d.a.i0.r.a aVar) {
        this.mLayoutInflateFactory = aVar;
    }

    public void setLayoutMode(c cVar) {
        this.mLayoutMode = cVar;
    }

    public void setNetRefreshLayoutMarginTop(boolean z) {
        int a2;
        h hVar = this.mRefreshView;
        if (hVar == null || !hVar.isViewAttached() || this.mRefreshView.b() == null || !(this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        if (z) {
            a2 = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, false);
        } else {
            a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        }
        ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = a2;
    }

    @Deprecated
    public void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        h hVar = this.mRefreshView;
        if (hVar == null || !hVar.isViewAttached() || this.mRefreshView.b() == null || !(this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(l.g(getApplicationContext(), R.dimen.ds300));
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        h hVar = this.mRefreshView;
        if (hVar == null || !hVar.isViewAttached()) {
            return;
        }
        this.mRefreshView.j(i2);
    }

    public void setNetRefreshViewTopMargin(int i2) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
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
        grantWindowPermission(new e() { // from class: com.baidu.tbadk.BaseActivity.10
            @Override // d.a.i0.r.e
            public void onPermissionResult(boolean z) {
                if (z) {
                    TbadkCoreApplication.getInst().setCurrentActivity(BaseActivity.this.getPageContext().getPageActivity());
                    if (KuangFloatingWindowController.getInstance().init()) {
                        TbSingleton.getInstance().isShowBackLabel = true;
                        KuangFloatingWindowController.getInstance().showFloatingView();
                    }
                }
            }
        });
    }

    public void showListMenu() {
        b bVar = this.mListMenu;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void showLoadingDialog(String str) {
        showLoadingDialog(str, (DialogInterface.OnCancelListener) null);
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.l(str);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.e();
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
        showProgressBar(false, i2, i3);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        String name = getClass().getName();
        String str2 = getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            l.M(getPageContext().getContext(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
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

    public void skipToLoginActivity() {
        ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
    }

    public void skipToRegisterActivity() {
        ViewHelper.skipToRegisterActivity(getPageContext().getPageActivity());
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.BaseActivity.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Animation.AnimationListener animationListener2 = animationListener;
                if (animationListener2 != null) {
                    animationListener2.onAnimationEnd(animation2);
                }
                synchronized (BaseActivity.this.animationList) {
                    BaseActivity.this.animationList.remove(weakReference);
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

    public void unRegisterResponsedEventListener() {
        d.a.i0.f0.h.f().n(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseActivity, d.a.c.a.g
    public TbPageContext<T> getPageContext() {
        try {
            if (this.pageContext == null && mClazz4GetPageContext != null) {
                this.pageContext = mClazz4GetPageContext.getConstructor(BaseActivity.class).newInstance(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.pageContext;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        showLoadingDialog(str, onCancelListener, true);
    }

    public void showLoadingView(View view, boolean z, int i2) {
        this.loadingRootView = view;
        if (this.loadingView == null) {
            if (i2 < 0) {
                this.loadingView = new g(getPageContext().getContext());
            } else {
                g gVar = new g(getPageContext().getContext(), i2);
                this.loadingView = gVar;
                gVar.h();
            }
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view, z);
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.m(str);
        this.mRefreshView.l(str2);
        this.mRefreshView.g(str3);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.o();
    }

    public void showLoadingDialog(String str, boolean z) {
        showLoadingDialog(str, null, true);
    }

    public void showProgressBar(boolean z, int i2, int i3) {
        ContinuousAnimationView continuousAnimationView;
        if (this.mProgressBar == null) {
            try {
                this.mProgressBar = new ContinuousAnimationView(getPageContext().getPageActivity());
                FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                int g2 = l.g(getPageContext().getPageActivity(), R.dimen.tbds200);
                frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(g2, g2, 17));
                this.mProgressBar.setRepeatMode(1);
                this.mProgressBar.addAnimatorListener(this.loadViewAnimListener);
            } catch (Throwable unused) {
                return;
            }
        }
        if (z && (continuousAnimationView = this.mProgressBar) != null) {
            continuousAnimationView.bringToFront();
        }
        ContinuousAnimationView continuousAnimationView2 = this.mProgressBar;
        if (continuousAnimationView2 != null) {
            continuousAnimationView2.setPadding(l.e(getPageContext().getPageActivity(), i2), l.e(getPageContext().getPageActivity(), i3), 0, 0);
            this.mProgressBar.setVisibility(0);
            this.mProgressBar.setSpeed(1.3f);
            this.mProgressBar.setMinAndMaxProgress(0.0f, 1.0f);
            this.mProgressBar.playAnimation();
        }
    }

    public void ShowSoftKeyPadDelay(View view) {
        ShowSoftKeyPadDelay(view, 150);
    }

    public void adjustResizeForSoftInput(int i2, boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.i0.r.f0.d.d(getPageContext().getPageActivity(), i2, z);
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        if (!isFinishing() && d.a.c.e.m.g.f(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.Waiting);
            }
            d.a.i0.r.f0.a aVar = new d.a.i0.r.f0.a((TbPageContext<?>) getPageContext());
            this.mWaitingDialog = aVar;
            aVar.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(z);
            this.mWaitingDialog.h(true);
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

    public void showNetRefreshViewNoClick(View view, String str) {
        showNetRefreshViewNoClick(view, str, false);
    }

    public void adjustResizeForSoftInput(boolean z) {
        if (this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.a.i0.r.f0.d.e(getPageContext().getPageActivity(), z);
        }
    }

    public void showToast(String str, int i2) {
        this.customToast.showToast(str, 2000, i2);
    }

    public void showToast(int i2, int i3) {
        this.customToast.showToast(i2, 2000, i3);
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public void showNetRefreshView(View view, String str) {
        showNetRefreshView(view, str, false);
    }

    public void showToast(int i2) {
        l.L(getPageContext().getContext(), i2);
    }

    public void showToast(String str, boolean z) {
        if (z) {
            showToast(str);
        } else {
            l.M(getPageContext().getContext(), str);
        }
    }

    public void showToast(int i2, boolean z) {
        if (z) {
            showToast(i2);
        } else {
            l.L(getPageContext().getContext(), i2);
        }
    }
}
