package com.baidu.searchbox.floating.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.floating.IFloating;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.FloatPrefs;
import com.baidu.searchbox.floating.utils.FloatingViewClickUtilKt;
import com.baidu.searchbox.floating.utils.TouchHelper;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.FloatContainer;
import com.baidu.tieba.R;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b7\u00108J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0003R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010(\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/baidu/searchbox/floating/widget/ViewManager;", "", "bindContentView", "()V", "createView", "destroy", "enterAnim", "exitAnim", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "Lkotlin/Pair;", "", "getLocation", "()Lkotlin/Pair;", "Landroid/graphics/Point;", "getPosition", "()Landroid/graphics/Point;", "getSize", "init", "release", "restoreScaleMode", MapBundleKey.MapObjKey.OBJ_SL_VISI, "setVisible", "(I)V", "updateLayoutParams", "Lcom/baidu/searchbox/floating/config/Config;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "setConfig", "(Lcom/baidu/searchbox/floating/config/Config;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/baidu/searchbox/floating/widget/FloatContainer;", "mContainer$delegate", "Lkotlin/Lazy;", "getMContainer", "()Lcom/baidu/searchbox/floating/widget/FloatContainer;", "mContainer", "Landroid/view/WindowManager$LayoutParams;", "mParam", "Landroid/view/WindowManager$LayoutParams;", "Lcom/baidu/searchbox/floating/utils/TouchHelper;", "mTouchHelper$delegate", "getMTouchHelper", "()Lcom/baidu/searchbox/floating/utils/TouchHelper;", "mTouchHelper", "Landroid/view/WindowManager;", "mWindowManager", "Landroid/view/WindowManager;", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ViewManager {
    public Config config;
    public final Context context;
    public final Lazy mContainer$delegate;
    public WindowManager.LayoutParams mParam;
    public final Lazy mTouchHelper$delegate;
    public WindowManager mWindowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final FloatContainer getMContainer() {
        return (FloatContainer) this.mContainer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TouchHelper getMTouchHelper() {
        return (TouchHelper) this.mTouchHelper$delegate.getValue();
    }

    public ViewManager(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.mContainer$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FloatContainer>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$mContainer$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FloatContainer invoke() {
                return new FloatContainer(ViewManager.this.getConfig(), ViewManager.this.getContext(), null, 0, 12, null);
            }
        });
        this.mTouchHelper$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TouchHelper>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$mTouchHelper$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TouchHelper invoke() {
                return new TouchHelper(ViewManager.this.getContext(), ViewManager.this.getConfig());
            }
        });
    }

    public static final /* synthetic */ WindowManager.LayoutParams access$getMParam$p(ViewManager viewManager) {
        WindowManager.LayoutParams layoutParams = viewManager.mParam;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        return layoutParams;
    }

    public static final /* synthetic */ WindowManager access$getMWindowManager$p(ViewManager viewManager) {
        WindowManager windowManager = viewManager.mWindowManager;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
        }
        return windowManager;
    }

    public final void setConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        this.config = config;
    }

    private final void bindContentView() {
        View floatingView = this.config.getFloatingView();
        if (floatingView != null) {
            floatingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        FloatContainer mContainer = getMContainer();
        View floatingView2 = this.config.getFloatingView();
        Intrinsics.checkNotNull(floatingView2);
        mContainer.addView(floatingView2);
        getMContainer().setTouchListener(new FloatContainer.TouchListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$1
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.TouchListener
            public void onTouch(MotionEvent event) {
                TouchHelper mTouchHelper;
                FloatContainer mContainer2;
                Intrinsics.checkNotNullParameter(event, "event");
                mTouchHelper = ViewManager.this.getMTouchHelper();
                mContainer2 = ViewManager.this.getMContainer();
                mTouchHelper.onTouch(mContainer2, event, ViewManager.access$getMWindowManager$p(ViewManager.this), ViewManager.access$getMParam$p(ViewManager.this));
            }
        });
        getMContainer().setLayoutListener(new FloatContainer.LayoutListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$2
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.LayoutListener
            public void onLayout() {
                ViewManager.this.enterAnim();
            }
        });
        WindowManager windowManager = this.mWindowManager;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
        }
        FloatContainer mContainer2 = getMContainer();
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        windowManager.addView(mContainer2, layoutParams);
        Point position = getPosition();
        for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
            floatViewListener.onViewCreate(true, this.config.getFloatingView(), this.config.getScaleMode().getSecond(), position);
        }
        final View findViewById = getMContainer().findViewById(R.id.obfuscated_res_0x7f090afe);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$$inlined$click$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Point position2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(findViewById) > r2) {
                        FloatingViewClickUtilKt.setLastClickTime(findViewById, currentTimeMillis);
                        View view3 = findViewById;
                        position2 = this.getPosition();
                        for (FloatViewListener floatViewListener2 : this.getConfig().getFloatViewListeners()) {
                            floatViewListener2.onClick(view3, this.getConfig().getScaleMode().getSecond(), position2);
                        }
                    }
                }
            });
        }
    }

    private final Pair<Integer, Integer> getLocation() {
        int dpToPxByScale;
        int i;
        int dpToPxByScale2;
        Pair<Integer, Integer> location = FloatPrefs.Companion.getLocation();
        if (location.getFirst().intValue() > 0 && location.getSecond().intValue() > 0) {
            return location;
        }
        if (this.config.getLocation().getFirst().intValue() != -1 && this.config.getLocation().getSecond().intValue() != -1) {
            dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getFirst().intValue());
            int screenHeight = UtilsKt.getScreenHeight(this.context) - UtilsKt.getStatusBarHeight(this.context);
            WindowManager.LayoutParams layoutParams = this.mParam;
            if (layoutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            }
            i = screenHeight - layoutParams.height;
            dpToPxByScale2 = UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getSecond().intValue());
        } else {
            dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().left);
            int screenHeight2 = UtilsKt.getScreenHeight(this.context);
            WindowManager.LayoutParams layoutParams2 = this.mParam;
            if (layoutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            }
            i = screenHeight2 - layoutParams2.height;
            dpToPxByScale2 = UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().bottom);
        }
        return new Pair<>(Integer.valueOf(dpToPxByScale), Integer.valueOf(i - dpToPxByScale2));
    }

    private final void init() {
        int i;
        this.mWindowManager = UtilsKt.getWindowManager(this.context);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = 2002;
        }
        layoutParams.type = i;
        layoutParams.format = 1;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.flags = 40;
        layoutParams.width = -2;
        layoutParams.height = -2;
        Pair<Integer, Integer> size = getSize();
        if (this.config.getReverse()) {
            layoutParams.width = size.getSecond().intValue();
            layoutParams.height = size.getFirst().intValue();
        } else {
            layoutParams.width = size.getFirst().intValue();
            layoutParams.height = size.getSecond().intValue();
        }
        Unit unit = Unit.INSTANCE;
        this.mParam = layoutParams;
        Pair<Integer, Integer> location = getLocation();
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        layoutParams2.x = location.getFirst().intValue();
        WindowManager.LayoutParams layoutParams3 = this.mParam;
        if (layoutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        layoutParams3.y = location.getSecond().intValue();
    }

    public final void release() {
        if (getMContainer().getParent() == null) {
            return;
        }
        Point position = getPosition();
        this.config.setAnimating(false);
        if (this.config.getFloatingView() != null) {
            for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                floatViewListener.onViewDismiss(getContentView(), this.config.getScaleMode().getSecond(), position);
            }
            this.config.getFloatViewListeners().clear();
        }
        IFloating floatingContext = this.config.getFloatingContext();
        if (floatingContext != null) {
            floatingContext.onDestroy();
        }
        FloatPrefs.Companion companion = FloatPrefs.Companion;
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        Integer valueOf = Integer.valueOf(layoutParams.x);
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        companion.setLocation(new Pair<>(valueOf, Integer.valueOf(layoutParams2.y)));
        FloatPrefs.Companion.setScaleMode(this.config.getScaleMode());
        getMContainer().removeAllViews();
        WindowManager windowManager = this.mWindowManager;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
        }
        windowManager.removeView(getMContainer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterAnim() {
        FloatViewAnimator animator;
        if (!this.config.isAnimating() && (animator = this.config.getAnimator()) != null) {
            WeakReference<View> weakReference = new WeakReference<>(getMContainer());
            WindowManager.LayoutParams layoutParams = this.mParam;
            if (layoutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            }
            WindowManager windowManager = this.mWindowManager;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
            }
            Animator enterAnim = animator.enterAnim(weakReference, layoutParams, windowManager);
            if (enterAnim != null) {
                WindowManager.LayoutParams layoutParams2 = this.mParam;
                if (layoutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                }
                layoutParams2.flags = 552;
                enterAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$enterAnim$$inlined$apply$lambda$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                        ViewManager.this.getConfig().setAnimating(false);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                        ViewManager.this.getConfig().setAnimating(true);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2, boolean z) {
                        ViewManager.access$getMParam$p(ViewManager.this).flags = 40;
                        ViewManager.this.getConfig().setAnimating(false);
                    }
                });
                enterAnim.start();
            }
        }
    }

    public final void exitAnim() {
        if (this.config.isAnimating()) {
            return;
        }
        if (this.config.getAnimator() != null) {
            FloatViewAnimator animator = this.config.getAnimator();
            if (animator != null) {
                WeakReference<View> weakReference = new WeakReference<>(getMContainer());
                WindowManager.LayoutParams layoutParams = this.mParam;
                if (layoutParams == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                }
                WindowManager windowManager = this.mWindowManager;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
                }
                Animator exitAnim = animator.exitAnim(weakReference, layoutParams, windowManager);
                if (exitAnim != null) {
                    WindowManager.LayoutParams layoutParams2 = this.mParam;
                    if (layoutParams2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    }
                    layoutParams2.flags = 552;
                    exitAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$exitAnim$$inlined$apply$lambda$1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator2) {
                            ViewManager.this.getConfig().setAnimating(false);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator2) {
                            ViewManager.this.getConfig().setAnimating(true);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2, boolean z) {
                            ViewManager.this.destroy();
                        }
                    });
                    exitAnim.start();
                    return;
                }
                return;
            }
            return;
        }
        destroy();
    }

    private final View getContentView() {
        View floatingView = this.config.getFloatingView();
        Intrinsics.checkNotNull(floatingView);
        return floatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point getPosition() {
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        int i = layoutParams.x;
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        return new Point(i, layoutParams2.y);
    }

    private final void restoreScaleMode() {
        if (FloatPrefs.Companion.getScaleMode().getSecond() != ScaleMode.S) {
            this.config.setScaleMode(FloatPrefs.Companion.getScaleMode());
        }
    }

    public final void createView() {
        restoreScaleMode();
        init();
        bindContentView();
    }

    public final void destroy() {
        release();
        FloatViewService.Companion.stopService$floating_view_release(this.context);
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    private final Pair<Integer, Integer> getSize() {
        Pair<Integer, Integer> scale = this.config.getScaleMode().getSecond().scale(UtilsKt.dpToPxByScale(this.context, this.config.getSize().getFirst().intValue()), UtilsKt.dpToPxByScale(this.context, this.config.getSize().getSecond().intValue()));
        int dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getShadow()) * 2;
        return new Pair<>(Integer.valueOf(scale.getFirst().intValue() + dpToPxByScale), Integer.valueOf(scale.getSecond().intValue() + dpToPxByScale));
    }

    public final void setVisible(int i) {
        if (this.config.getFloatingView() != null && getMContainer().getVisibility() != i) {
            getMContainer().setVisibility(i);
            Point position = getPosition();
            if (i == 0) {
                for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                    floatViewListener.onViewShow(getContentView(), this.config.getScaleMode().getSecond(), position);
                }
                return;
            }
            for (FloatViewListener floatViewListener2 : this.config.getFloatViewListeners()) {
                floatViewListener2.onViewHide(getContentView(), this.config.getScaleMode().getSecond(), position);
            }
        }
    }

    public final void updateLayoutParams() {
        Pair<Integer, Integer> size = getSize();
        WindowManager.LayoutParams layoutParams = this.mParam;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        int i = layoutParams.width;
        WindowManager.LayoutParams layoutParams2 = this.mParam;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        if (this.config.getReverse()) {
            layoutParams2.width = size.getSecond().intValue();
            layoutParams2.height = size.getFirst().intValue();
        } else {
            layoutParams2.width = size.getFirst().intValue();
            layoutParams2.height = size.getSecond().intValue();
        }
        if (getMContainer().getParent() != null) {
            WindowManager windowManager = this.mWindowManager;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWindowManager");
            }
            FloatContainer mContainer = getMContainer();
            WindowManager.LayoutParams layoutParams3 = this.mParam;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            }
            windowManager.updateViewLayout(mContainer, layoutParams3);
        }
        WindowManager.LayoutParams layoutParams4 = this.mParam;
        if (layoutParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        }
        int i2 = layoutParams4.width;
        Point position = getPosition();
        if (i < i2) {
            for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
                floatViewListener.onScale(true, this.config.getScaleMode().getSecond(), position);
            }
        } else if (i > i2) {
            for (FloatViewListener floatViewListener2 : this.config.getFloatViewListeners()) {
                floatViewListener2.onScale(false, this.config.getScaleMode().getSecond(), position);
            }
        }
    }
}
