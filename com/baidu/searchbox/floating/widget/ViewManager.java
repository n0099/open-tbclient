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
import com.baidu.searchbox.floating.listener.SimpleFloatListener;
import com.baidu.searchbox.floating.service.FloatViewService;
import com.baidu.searchbox.floating.utils.FloatPrefs;
import com.baidu.searchbox.floating.utils.FloatingViewClickUtilKt;
import com.baidu.searchbox.floating.utils.TouchHelper;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.FloatContainer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.view.RoundOutlineProvider;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.R;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ\b\u0010\"\u001a\u00020#H\u0002J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0006\u0010+\u001a\u00020\u001dJ\b\u0010,\u001a\u00020\u001dH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020#H\u0002J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&J\u0006\u00101\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/floating/widget/ViewManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "setConfig", "(Lcom/baidu/searchbox/floating/config/Config;)V", "container", "Lcom/baidu/searchbox/floating/widget/FloatContainer;", "getContainer", "()Lcom/baidu/searchbox/floating/widget/FloatContainer;", "container$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "param", "Landroid/view/WindowManager$LayoutParams;", "touchHelper", "Lcom/baidu/searchbox/floating/utils/TouchHelper;", "getTouchHelper", "()Lcom/baidu/searchbox/floating/utils/TouchHelper;", "touchHelper$delegate", "windowManager", "Landroid/view/WindowManager;", "bindContentView", "", "createView", "destroy", "enterAnim", "exitAnim", "getContentView", "Landroid/view/View;", GameAssistConstKt.METHOD_GET_LOCATION, "Lkotlin/Pair;", "", "getPosition", "Landroid/graphics/Point;", "getSize", "init", "release", "restoreScaleMode", "setCornerRadius", "view", "setVisible", MapBundleKey.MapObjKey.OBJ_SL_VISI, "updateLayoutParams", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewManager {
    public Config config;
    public final Lazy container$delegate;
    public final Context context;
    public WindowManager.LayoutParams param;
    public final Lazy touchHelper$delegate;
    public WindowManager windowManager;

    public ViewManager(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.container$delegate = BdPlayerUtils.lazyNone(new Function0<FloatContainer>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$container$2
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
        this.touchHelper$delegate = BdPlayerUtils.lazyNone(new Function0<TouchHelper>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$touchHelper$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TouchHelper invoke() {
                final TouchHelper touchHelper = new TouchHelper(ViewManager.this.getContext(), ViewManager.this.getConfig());
                final ViewManager viewManager = ViewManager.this;
                touchHelper.setScaleGestureCallback(new Function1<Boolean, Unit>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$touchHelper$2$1$1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        SimpleFloatListener simpleFloatListener;
                        for (FloatViewListener floatViewListener : TouchHelper.this.getConfig().getFloatViewListeners()) {
                            if (floatViewListener instanceof SimpleFloatListener) {
                                simpleFloatListener = (SimpleFloatListener) floatViewListener;
                            } else {
                                simpleFloatListener = null;
                            }
                            if (simpleFloatListener != null) {
                                simpleFloatListener.onScaleGestureCallback(z);
                            }
                        }
                    }
                });
                touchHelper.setSingleTapOnGestureCallback(new Function0<Unit>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$touchHelper$2$1$2
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SimpleFloatListener simpleFloatListener;
                        for (FloatViewListener floatViewListener : TouchHelper.this.getConfig().getFloatViewListeners()) {
                            if (floatViewListener instanceof SimpleFloatListener) {
                                simpleFloatListener = (SimpleFloatListener) floatViewListener;
                            } else {
                                simpleFloatListener = null;
                            }
                            if (simpleFloatListener != null) {
                                simpleFloatListener.onGestureSingleTapConfirmed();
                            }
                        }
                    }
                });
                touchHelper.setDragGestureCallback(new Function0<Unit>() { // from class: com.baidu.searchbox.floating.widget.ViewManager$touchHelper$2$1$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SimpleFloatListener simpleFloatListener;
                        Point position;
                        ArrayList<FloatViewListener> floatViewListeners = TouchHelper.this.getConfig().getFloatViewListeners();
                        ViewManager viewManager2 = viewManager;
                        for (FloatViewListener floatViewListener : floatViewListeners) {
                            if (floatViewListener instanceof SimpleFloatListener) {
                                simpleFloatListener = (SimpleFloatListener) floatViewListener;
                            } else {
                                simpleFloatListener = null;
                            }
                            if (simpleFloatListener != null) {
                                position = viewManager2.getPosition();
                                simpleFloatListener.onDragEnd(position);
                            }
                        }
                    }
                });
                return touchHelper;
            }
        });
    }

    private final void setCornerRadius(View view2) {
        if (this.config.getCornerRadius() > 0.0f && Build.VERSION.SDK_INT >= 21) {
            RoundOutlineProvider roundOutlineProvider = new RoundOutlineProvider();
            roundOutlineProvider.setRadius(BdPlayerUtils.dp2px(view2, this.config.getCornerRadius()));
            view2.setOutlineProvider(roundOutlineProvider);
        }
    }

    public final void setConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        this.config = config;
    }

    private final void bindContentView() {
        View floatingView = this.config.getFloatingView();
        if (floatingView != null) {
            floatingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setCornerRadius(floatingView);
            getContainer().addView(floatingView);
        }
        getContainer().setTouchListener(new FloatContainer.TouchListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$2
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.TouchListener
            public void onTouch(MotionEvent event) {
                TouchHelper touchHelper;
                FloatContainer container;
                WindowManager windowManager;
                WindowManager.LayoutParams layoutParams;
                Intrinsics.checkNotNullParameter(event, "event");
                touchHelper = ViewManager.this.getTouchHelper();
                container = ViewManager.this.getContainer();
                windowManager = ViewManager.this.windowManager;
                WindowManager.LayoutParams layoutParams2 = null;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                layoutParams = ViewManager.this.param;
                if (layoutParams == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    layoutParams2 = layoutParams;
                }
                touchHelper.onTouch(container, event, windowManager, layoutParams2);
            }
        });
        getContainer().setLayoutListener(new FloatContainer.LayoutListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$3
            @Override // com.baidu.searchbox.floating.widget.FloatContainer.LayoutListener
            public void onLayout() {
                ViewManager.this.enterAnim();
            }
        });
        WindowManager windowManager = this.windowManager;
        WindowManager.LayoutParams layoutParams = null;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            windowManager = null;
        }
        FloatContainer container = getContainer();
        WindowManager.LayoutParams layoutParams2 = this.param;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            layoutParams = layoutParams2;
        }
        windowManager.addView(container, layoutParams);
        Point position = getPosition();
        for (FloatViewListener floatViewListener : this.config.getFloatViewListeners()) {
            floatViewListener.onViewCreate(true, this.config.getFloatingView(), this.config.getScaleMode().getSecond(), position);
        }
        final View findViewById = getContainer().findViewById(R.id.obfuscated_res_0x7f090b43);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.floating.widget.ViewManager$bindContentView$$inlined$click$default$1
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
        int dpToPxByScale2;
        Pair<Integer, Integer> location = FloatPrefs.Companion.getLocation();
        if (location.getFirst().intValue() > 0 && location.getSecond().intValue() > 0) {
            return location;
        }
        if (this.config.getLocation().getFirst().intValue() != -1 && this.config.getLocation().getSecond().intValue() != -1) {
            dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getFirst().intValue());
            dpToPxByScale2 = UtilsKt.getStatusBarHeight(this.context) + UtilsKt.dpToPxByScale(this.context, this.config.getLocation().getSecond().intValue());
        } else {
            dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().left);
            int screenHeight = UtilsKt.getScreenHeight(this.context);
            WindowManager.LayoutParams layoutParams = this.param;
            if (layoutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                layoutParams = null;
            }
            dpToPxByScale2 = (screenHeight - layoutParams.height) - UtilsKt.dpToPxByScale(this.context, this.config.getBlockOffset().bottom);
        }
        return new Pair<>(Integer.valueOf(dpToPxByScale), Integer.valueOf(dpToPxByScale2));
    }

    private final Pair<Integer, Integer> getSize() {
        Pair<Integer, Integer> size = FloatPrefs.Companion.getSize();
        if (this.config.getSupportScaleGesture() && size.getFirst().intValue() > 0 && size.getSecond().intValue() > 0) {
            return new Pair<>(size.getFirst(), size.getSecond());
        }
        Pair<Integer, Integer> scale = this.config.getScaleMode().getSecond().scale(UtilsKt.dpToPxByScale(this.context, this.config.getSize().getFirst().intValue()), UtilsKt.dpToPxByScale(this.context, this.config.getSize().getSecond().intValue()));
        int dpToPxByScale = UtilsKt.dpToPxByScale(this.context, this.config.getShadow()) * 2;
        return new Pair<>(Integer.valueOf(scale.getFirst().intValue() + dpToPxByScale), Integer.valueOf(scale.getSecond().intValue() + dpToPxByScale));
    }

    private final void init() {
        int i;
        this.windowManager = UtilsKt.getWindowManager(this.context);
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
        this.param = layoutParams;
        Pair<Integer, Integer> location = getLocation();
        WindowManager.LayoutParams layoutParams2 = this.param;
        WindowManager.LayoutParams layoutParams3 = null;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams2 = null;
        }
        layoutParams2.x = location.getFirst().intValue();
        WindowManager.LayoutParams layoutParams4 = this.param;
        if (layoutParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            layoutParams3 = layoutParams4;
        }
        layoutParams3.y = location.getSecond().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterAnim() {
        FloatViewAnimator animator;
        if (!this.config.isAnimating() && (animator = this.config.getAnimator()) != null) {
            WeakReference<View> weakReference = new WeakReference<>(getContainer());
            WindowManager.LayoutParams layoutParams = this.param;
            WindowManager.LayoutParams layoutParams2 = null;
            if (layoutParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                layoutParams = null;
            }
            WindowManager windowManager = this.windowManager;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            Animator enterAnim = animator.enterAnim(weakReference, layoutParams, windowManager);
            if (enterAnim != null) {
                WindowManager.LayoutParams layoutParams3 = this.param;
                if (layoutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    layoutParams2 = layoutParams3;
                }
                layoutParams2.flags = 552;
                enterAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$enterAnim$1$1
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
                        WindowManager.LayoutParams layoutParams4;
                        layoutParams4 = ViewManager.this.param;
                        if (layoutParams4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            layoutParams4 = null;
                        }
                        layoutParams4.flags = 40;
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
                WeakReference<View> weakReference = new WeakReference<>(getContainer());
                WindowManager.LayoutParams layoutParams = this.param;
                WindowManager.LayoutParams layoutParams2 = null;
                if (layoutParams == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    layoutParams = null;
                }
                WindowManager windowManager = this.windowManager;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                Animator exitAnim = animator.exitAnim(weakReference, layoutParams, windowManager);
                if (exitAnim != null) {
                    WindowManager.LayoutParams layoutParams3 = this.param;
                    if (layoutParams3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    } else {
                        layoutParams2 = layoutParams3;
                    }
                    layoutParams2.flags = 552;
                    exitAnim.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.ViewManager$exitAnim$1$1
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

    /* JADX INFO: Access modifiers changed from: private */
    public final FloatContainer getContainer() {
        return (FloatContainer) this.container$delegate.getValue();
    }

    private final View getContentView() {
        View floatingView = this.config.getFloatingView();
        Intrinsics.checkNotNull(floatingView);
        return floatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point getPosition() {
        WindowManager.LayoutParams layoutParams = this.param;
        WindowManager.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams = null;
        }
        int i = layoutParams.x;
        WindowManager.LayoutParams layoutParams3 = this.param;
        if (layoutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            layoutParams2 = layoutParams3;
        }
        return new Point(i, layoutParams2.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TouchHelper getTouchHelper() {
        return (TouchHelper) this.touchHelper$delegate.getValue();
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

    public final void release() {
        if (getContainer().getParent() == null) {
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
        WindowManager.LayoutParams layoutParams = this.param;
        WindowManager windowManager = null;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams = null;
        }
        Integer valueOf = Integer.valueOf(layoutParams.x);
        WindowManager.LayoutParams layoutParams2 = this.param;
        if (layoutParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams2 = null;
        }
        companion.setLocation(new Pair<>(valueOf, Integer.valueOf(layoutParams2.y)));
        FloatPrefs.Companion.setScaleMode(this.config.getScaleMode());
        if (this.config.getSupportScaleGesture()) {
            WindowManager.LayoutParams layoutParams3 = this.param;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                layoutParams3 = null;
            }
            int i = layoutParams3.width;
            WindowManager.LayoutParams layoutParams4 = this.param;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                layoutParams4 = null;
            }
            int i2 = layoutParams4.height;
            if (this.config.getReverse()) {
                WindowManager.LayoutParams layoutParams5 = this.param;
                if (layoutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    layoutParams5 = null;
                }
                i = layoutParams5.height;
                WindowManager.LayoutParams layoutParams6 = this.param;
                if (layoutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    layoutParams6 = null;
                }
                i2 = layoutParams6.width;
            }
            FloatPrefs.Companion.setSize(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
        }
        getContainer().removeAllViews();
        WindowManager windowManager2 = this.windowManager;
        if (windowManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        } else {
            windowManager = windowManager2;
        }
        windowManager.removeView(getContainer());
        getTouchHelper().cancel();
    }

    public final void updateLayoutParams() {
        Pair<Integer, Integer> size = getSize();
        WindowManager.LayoutParams layoutParams = this.param;
        WindowManager.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams = null;
        }
        int i = layoutParams.width;
        WindowManager.LayoutParams layoutParams3 = this.param;
        if (layoutParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            layoutParams3 = null;
        }
        if (this.config.getReverse()) {
            layoutParams3.width = size.getSecond().intValue();
            layoutParams3.height = size.getFirst().intValue();
        } else {
            layoutParams3.width = size.getFirst().intValue();
            layoutParams3.height = size.getSecond().intValue();
        }
        if (getContainer().getParent() != null) {
            WindowManager windowManager = this.windowManager;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            FloatContainer container = getContainer();
            WindowManager.LayoutParams layoutParams4 = this.param;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                layoutParams4 = null;
            }
            windowManager.updateViewLayout(container, layoutParams4);
        }
        WindowManager.LayoutParams layoutParams5 = this.param;
        if (layoutParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            layoutParams2 = layoutParams5;
        }
        int i2 = layoutParams2.width;
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

    public final void setVisible(int i) {
        if (this.config.getFloatingView() != null && getContainer().getVisibility() != i) {
            getContainer().setVisibility(i);
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
}
