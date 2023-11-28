package com.baidu.searchbox.floating.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.baidu.searchbox.floating.config.DoubleTapScaleSize;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$tapOnGestureListener$2;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00011\u0018\u0000 V2\u00020\u0001:\u0001VB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020\rJ\b\u0010>\u001a\u00020$H\u0002J\b\u0010?\u001a\u00020$H\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002J\u0006\u0010C\u001a\u00020\nJ\u0010\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u000208H\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u001eH\u0016J\u0012\u0010H\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010I\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010\u001eH\u0016J*\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020L2\u0006\u00105\u001a\u0002062\b\b\u0002\u0010M\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020\nJ\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0006H\u0002J\b\u0010Q\u001a\u00020\rH\u0002J\b\u0010R\u001a\u00020\rH\u0002J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b)\u0010&R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatingScaleGestureDetector;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "doubleTabScaleSize", "Lcom/baidu/searchbox/floating/config/DoubleTapScaleSize;", "floatContainer", "Landroid/view/ViewGroup;", "inProgress", "", "onDoubleTapOnGestureCallback", "Lkotlin/Function1;", "", "getOnDoubleTapOnGestureCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDoubleTapOnGestureCallback", "(Lkotlin/jvm/functions/Function1;)V", "onScaleGestureCallback", "getOnScaleGestureCallback", "setOnScaleGestureCallback", "onSingleTapOnGestureCallback", "Lkotlin/Function0;", "getOnSingleTapOnGestureCallback", "()Lkotlin/jvm/functions/Function0;", "setOnSingleTapOnGestureCallback", "(Lkotlin/jvm/functions/Function0;)V", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector$delegate", "Lkotlin/Lazy;", "screenHeight", "", "getScreenHeight", "()I", "screenHeight$delegate", "screenWidth", "getScreenWidth", "screenWidth$delegate", "tapGestureDetector", "Landroid/view/GestureDetector;", "getTapGestureDetector", "()Landroid/view/GestureDetector;", "tapGestureDetector$delegate", "tapOnGestureListener", "com/baidu/searchbox/floating/widget/FloatingScaleGestureDetector$tapOnGestureListener$2$1", "getTapOnGestureListener", "()Lcom/baidu/searchbox/floating/widget/FloatingScaleGestureDetector$tapOnGestureListener$2$1;", "tapOnGestureListener$delegate", "view", "Landroid/view/View;", "whRatio", "", "windowLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "windowManager", "Landroid/view/WindowManager;", "cancelAnimator", "getMaxHeight", "getMaxWidth", "getMinHeight", "getMinScreenWH", "getMinWidth", "isInProgress", "isNeedScale", "scaleFactor", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "doubleTapEnabled", "scaleGestureEnabled", "startDoubleTapScaleAnimation", "scaleSize", "updateLayoutOnScaleBegin", "updateLayoutOnScaleEnd", "updateWindowLayout", "width", "height", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingScaleGestureDetector implements ScaleGestureDetector.OnScaleGestureListener {
    public static final Companion Companion = new Companion(null);
    public static final float RATIO_16_9 = 1.7777778f;
    public static final float RATIO_9_16 = 0.5625f;
    public static final String TAG = "FloatingScaleGestureDetector";
    public final Context context;
    public DoubleTapScaleSize doubleTabScaleSize;
    public ViewGroup floatContainer;
    public boolean inProgress;
    public Function1<? super Boolean, Unit> onDoubleTapOnGestureCallback;
    public Function1<? super Boolean, Unit> onScaleGestureCallback;
    public Function0<Unit> onSingleTapOnGestureCallback;
    public ValueAnimator scaleAnimator;
    public final Lazy scaleGestureDetector$delegate;
    public final Lazy screenHeight$delegate;
    public final Lazy screenWidth$delegate;
    public final Lazy tapGestureDetector$delegate;
    public final Lazy tapOnGestureListener$delegate;

    /* renamed from: view  reason: collision with root package name */
    public View f1056view;
    public float whRatio;
    public WindowManager.LayoutParams windowLayoutParams;
    public WindowManager windowManager;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatingScaleGestureDetector$Companion;", "", "()V", "RATIO_16_9", "", "RATIO_9_16", "TAG", "", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public FloatingScaleGestureDetector(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.scaleGestureDetector$delegate = BdPlayerUtils.lazyNone(new Function0<ScaleGestureDetector>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$scaleGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScaleGestureDetector invoke() {
                Context context2;
                context2 = FloatingScaleGestureDetector.this.context;
                return new ScaleGestureDetector(context2, FloatingScaleGestureDetector.this);
            }
        });
        this.tapGestureDetector$delegate = BdPlayerUtils.lazyNone(new Function0<GestureDetector>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$tapGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetector invoke() {
                Context context2;
                FloatingScaleGestureDetector$tapOnGestureListener$2.AnonymousClass1 tapOnGestureListener;
                context2 = FloatingScaleGestureDetector.this.context;
                tapOnGestureListener = FloatingScaleGestureDetector.this.getTapOnGestureListener();
                return new GestureDetector(context2, tapOnGestureListener);
            }
        });
        this.tapOnGestureListener$delegate = BdPlayerUtils.lazyNone(new Function0<FloatingScaleGestureDetector$tapOnGestureListener$2.AnonymousClass1>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$tapOnGestureListener$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$tapOnGestureListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final FloatingScaleGestureDetector floatingScaleGestureDetector = FloatingScaleGestureDetector.this;
                return new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$tapOnGestureListener$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTap(MotionEvent event) {
                        DoubleTapScaleSize doubleTapScaleSize;
                        Intrinsics.checkNotNullParameter(event, "event");
                        doubleTapScaleSize = FloatingScaleGestureDetector.this.doubleTabScaleSize;
                        if (doubleTapScaleSize != null) {
                            FloatingScaleGestureDetector floatingScaleGestureDetector2 = FloatingScaleGestureDetector.this;
                            floatingScaleGestureDetector2.startDoubleTapScaleAnimation(doubleTapScaleSize);
                            BdVideoLog.d(FloatingScaleGestureDetector.TAG, "onDoubleTap");
                            Function1<Boolean, Unit> onDoubleTapOnGestureCallback = floatingScaleGestureDetector2.getOnDoubleTapOnGestureCallback();
                            if (onDoubleTapOnGestureCallback != null) {
                                onDoubleTapOnGestureCallback.invoke(Boolean.TRUE);
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTapEvent(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        BdVideoLog.d(FloatingScaleGestureDetector.TAG, "onDoubleTapEvent " + event.getAction());
                        return false;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onSingleTapConfirmed(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        Function0<Unit> onSingleTapOnGestureCallback = FloatingScaleGestureDetector.this.getOnSingleTapOnGestureCallback();
                        if (onSingleTapOnGestureCallback != null) {
                            onSingleTapOnGestureCallback.invoke();
                        }
                        BdVideoLog.d(FloatingScaleGestureDetector.TAG, "onSingleTapConfirmed");
                        return false;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(MotionEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        BdVideoLog.d(FloatingScaleGestureDetector.TAG, "onSingleTapUp");
                        return false;
                    }
                };
            }
        });
        this.whRatio = 1.7777778f;
        this.screenWidth$delegate = BdPlayerUtils.lazyNone(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$screenWidth$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(VideoSystemHelper.getDisplayWidth());
            }
        });
        this.screenHeight$delegate = BdPlayerUtils.lazyNone(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$screenHeight$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(VideoSystemHelper.getDisplayHeight());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDoubleTapScaleAnimation(DoubleTapScaleSize doubleTapScaleSize) {
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator doubleTapAnimator = UtilsKt.doubleTapAnimator(doubleTapScaleSize.getCurSize(), doubleTapScaleSize.reverse(), new Function2<Integer, Integer, Unit>() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$startDoubleTapScaleAnimation$1
            {
                super(2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, int i2) {
                FloatingScaleGestureDetector.this.updateWindowLayout(i, i2);
            }
        });
        doubleTapAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector$startDoubleTapScaleAnimation$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FloatingScaleGestureDetector.this.updateLayoutOnScaleEnd();
                Function1<Boolean, Unit> onDoubleTapOnGestureCallback = FloatingScaleGestureDetector.this.getOnDoubleTapOnGestureCallback();
                if (onDoubleTapOnGestureCallback != null) {
                    onDoubleTapOnGestureCallback.invoke(Boolean.FALSE);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FloatingScaleGestureDetector.this.updateLayoutOnScaleBegin();
            }
        });
        doubleTapAnimator.start();
        this.scaleAnimator = doubleTapAnimator;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        updateLayoutOnScaleBegin();
        Function1<? super Boolean, Unit> function1 = this.onScaleGestureCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        this.inProgress = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        DoubleTapScaleSize doubleTapScaleSize;
        updateLayoutOnScaleEnd();
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        if (layoutParams != null && (doubleTapScaleSize = this.doubleTabScaleSize) != null) {
            doubleTapScaleSize.update(layoutParams.width, layoutParams.height, UtilsKt.dpToPxByScale(this.context, 10));
        }
    }

    public final void setOnDoubleTapOnGestureCallback(Function1<? super Boolean, Unit> function1) {
        this.onDoubleTapOnGestureCallback = function1;
    }

    public final void setOnScaleGestureCallback(Function1<? super Boolean, Unit> function1) {
        this.onScaleGestureCallback = function1;
    }

    public final void setOnSingleTapOnGestureCallback(Function0<Unit> function0) {
        this.onSingleTapOnGestureCallback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWindowLayout(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view2 = this.f1056view;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
        } else {
            layoutParams = null;
        }
        View view3 = this.f1056view;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
    }

    private final int getMaxHeight() {
        return (int) (getMaxWidth() / this.whRatio);
    }

    private final int getMaxWidth() {
        if (this.whRatio >= 1.0f) {
            return getMinScreenWH();
        }
        return getMinScreenWH() / 2;
    }

    private final int getMinHeight() {
        return (int) (getMinWidth() / this.whRatio);
    }

    private final int getMinScreenWH() {
        return RangesKt___RangesKt.coerceAtMost(getScreenWidth(), getScreenHeight());
    }

    private final int getMinWidth() {
        Context context;
        int i;
        if (this.whRatio >= 1.0f) {
            context = this.context;
            i = 187;
        } else {
            context = this.context;
            i = 105;
        }
        return UtilsKt.dpToPxByScale(context, i);
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        return (ScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    private final int getScreenHeight() {
        return ((Number) this.screenHeight$delegate.getValue()).intValue();
    }

    private final int getScreenWidth() {
        return ((Number) this.screenWidth$delegate.getValue()).intValue();
    }

    private final GestureDetector getTapGestureDetector() {
        return (GestureDetector) this.tapGestureDetector$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FloatingScaleGestureDetector$tapOnGestureListener$2.AnonymousClass1 getTapOnGestureListener() {
        return (FloatingScaleGestureDetector$tapOnGestureListener$2.AnonymousClass1) this.tapOnGestureListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayoutOnScaleBegin() {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        if (layoutParams != null) {
            int maxWidth = getMaxWidth();
            layoutParams.width = maxWidth;
            float f = this.whRatio;
            layoutParams.height = (int) (maxWidth / f);
            if (f >= 1.0f) {
                layoutParams.x = 0;
            }
        }
        WindowManager windowManager = this.windowManager;
        if (windowManager != null) {
            windowManager.updateViewLayout(this.floatContainer, this.windowLayoutParams);
        }
    }

    public final void cancelAnimator() {
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator.removeAllListeners();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnDoubleTapOnGestureCallback() {
        return this.onDoubleTapOnGestureCallback;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnScaleGestureCallback() {
        return this.onScaleGestureCallback;
    }

    public final Function0<Unit> getOnSingleTapOnGestureCallback() {
        return this.onSingleTapOnGestureCallback;
    }

    public final boolean isInProgress() {
        if (!this.inProgress && !getScaleGestureDetector().isInProgress()) {
            return false;
        }
        return true;
    }

    private final boolean isNeedScale(float f) {
        int i;
        View view2 = this.f1056view;
        if (view2 != null) {
            i = view2.getWidth();
        } else {
            i = 0;
        }
        if (this.whRatio >= 1.0f) {
            if (i >= getMinScreenWH() && f > 1.0f) {
                return false;
            }
            if (i <= UtilsKt.dpToPxByScale(this.context, 187) && f < 1.0f) {
                return false;
            }
            return true;
        } else if (i >= getMinScreenWH() / 2 && f > 1.0f) {
            return false;
        } else {
            if (i <= UtilsKt.dpToPxByScale(this.context, 105) && f < 1.0f) {
                return false;
            }
            return true;
        }
    }

    public static /* synthetic */ boolean onTouchEvent$default(FloatingScaleGestureDetector floatingScaleGestureDetector, MotionEvent motionEvent, View view2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return floatingScaleGestureDetector.onTouchEvent(motionEvent, view2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayoutOnScaleEnd() {
        ViewParent viewParent;
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup viewGroup = this.floatContainer;
        if (viewGroup != null) {
            viewParent = viewGroup.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            WindowManager.LayoutParams layoutParams3 = this.windowLayoutParams;
            if (layoutParams3 != null) {
                View view2 = this.f1056view;
                if (view2 != null && (layoutParams2 = view2.getLayoutParams()) != null) {
                    i = layoutParams2.width;
                } else {
                    i = layoutParams3.width;
                }
                layoutParams3.width = i;
                View view3 = this.f1056view;
                if (view3 != null && (layoutParams = view3.getLayoutParams()) != null) {
                    i2 = layoutParams.height;
                } else {
                    i2 = layoutParams3.height;
                }
                layoutParams3.height = i2;
                BdVideoLog.d(TAG, "onScaleEnd: window width= " + layoutParams3.width + " height= " + layoutParams3.height);
            }
            WindowManager windowManager = this.windowManager;
            if (windowManager != null) {
                windowManager.updateViewLayout(this.floatContainer, this.windowLayoutParams);
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        Intrinsics.checkNotNullParameter(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        if (!isNeedScale(scaleFactor)) {
            return false;
        }
        View view2 = this.f1056view;
        ViewGroup.LayoutParams layoutParams2 = null;
        Integer num = null;
        layoutParams2 = null;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            View view3 = this.f1056view;
            if (view3 != null) {
                i = (int) (view3.getWidth() * scaleFactor);
            } else {
                i = -1;
            }
            layoutParams.width = i;
            int minScreenWH = getMinScreenWH() / 2;
            if (layoutParams.width > getMinScreenWH()) {
                layoutParams.width = getMinScreenWH();
            } else if (this.whRatio < 1.0f && layoutParams.width > minScreenWH) {
                layoutParams.width = minScreenWH;
            }
            layoutParams.height = (int) (layoutParams.width / this.whRatio);
            StringBuilder sb = new StringBuilder();
            sb.append("scaleFactor: ");
            sb.append(scaleFactor);
            sb.append(" width= ");
            sb.append(layoutParams.width);
            sb.append(" ratio= ");
            sb.append(layoutParams.width / layoutParams.height);
            sb.append(" windowWidth=  ");
            WindowManager.LayoutParams layoutParams3 = this.windowLayoutParams;
            if (layoutParams3 != null) {
                num = Integer.valueOf(layoutParams3.width);
            }
            sb.append(num);
            BdVideoLog.d(TAG, sb.toString());
            layoutParams2 = layoutParams;
        }
        View view4 = this.f1056view;
        if (view4 != null) {
            view4.setLayoutParams(layoutParams2);
            return true;
        }
        return true;
    }

    public final boolean onTouchEvent(MotionEvent event, View view2, boolean z, boolean z2) {
        Function1<? super Boolean, Unit> function1;
        ViewGroup viewGroup;
        View view3;
        Pair pair;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(view2, "view");
        if (this.floatContainer == null) {
            WindowManager.LayoutParams layoutParams = null;
            if (view2 instanceof ViewGroup) {
                viewGroup = (ViewGroup) view2;
            } else {
                viewGroup = null;
            }
            this.floatContainer = viewGroup;
            if (viewGroup != null) {
                view3 = viewGroup.getChildAt(0);
            } else {
                view3 = null;
            }
            this.f1056view = view3;
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            this.windowManager = UtilsKt.getWindowManager(context);
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof WindowManager.LayoutParams) {
                layoutParams = (WindowManager.LayoutParams) layoutParams2;
            }
            this.windowLayoutParams = layoutParams;
            if (view2.getWidth() > view2.getHeight()) {
                this.whRatio = 1.7777778f;
            } else {
                this.whRatio = 0.5625f;
            }
            if (z) {
                Pair pair2 = new Pair(Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()));
                if (view2.getWidth() == getMaxWidth()) {
                    pair = new Pair(Integer.valueOf(getMinWidth()), Integer.valueOf(getMinHeight()));
                } else {
                    pair = new Pair(Integer.valueOf(getMaxWidth()), Integer.valueOf(getMaxHeight()));
                }
                this.doubleTabScaleSize = new DoubleTapScaleSize(pair, pair2);
            }
            Unit unit = Unit.INSTANCE;
        }
        int action = event.getAction() & 255;
        if (action != 1 && action != 3) {
            if (action == 6) {
                this.inProgress = true;
            }
        } else {
            if (this.inProgress && (function1 = this.onScaleGestureCallback) != null) {
                function1.invoke(Boolean.FALSE);
            }
            this.inProgress = false;
        }
        getTapGestureDetector().onTouchEvent(event);
        if (!z2 || event.getPointerCount() < 2 || !getScaleGestureDetector().onTouchEvent(event)) {
            return false;
        }
        return true;
    }
}
