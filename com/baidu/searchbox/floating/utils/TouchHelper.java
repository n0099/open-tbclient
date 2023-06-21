package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.widget.FloatingScaleGestureDetector;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0018\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0012H\u0002J\u0006\u0010A\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u001eH\u0002J&\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020\u00172\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010G\u001a\u00020HH\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0017\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b2\u0010$R\"\u00104\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001b\u00107\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b8\u0010$¨\u0006M"}, d2 = {"Lcom/baidu/searchbox/floating/utils/TouchHelper;", "", "context", "Landroid/content/Context;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "blockOffset", "Landroid/graphics/Rect;", "getBlockOffset", "()Landroid/graphics/Rect;", "blockOffset$delegate", "Lkotlin/Lazy;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "getContext", "()Landroid/content/Context;", "displayHeight", "", "displayRect", "displayWidth", "dragGestureCallback", "Lkotlin/Function0;", "", "getDragGestureCallback", "()Lkotlin/jvm/functions/Function0;", "setDragGestureCallback", "(Lkotlin/jvm/functions/Function0;)V", "emptyHeight", "hasStatusBar", "", "lastX", "", "lastY", "navigationBarHeight", "getNavigationBarHeight", "()I", "navigationBarHeight$delegate", "scaleGestureCallback", "Lkotlin/Function1;", "getScaleGestureCallback", "()Lkotlin/jvm/functions/Function1;", "setScaleGestureCallback", "(Lkotlin/jvm/functions/Function1;)V", "scaleGestureDetector", "Lcom/baidu/searchbox/floating/widget/FloatingScaleGestureDetector;", "getScaleGestureDetector", "()Lcom/baidu/searchbox/floating/widget/FloatingScaleGestureDetector;", "scaleGestureDetector$delegate", "screenHeight", "getScreenHeight", "screenHeight$delegate", "singleTapOnGestureCallback", "getSingleTapOnGestureCallback", "setSingleTapOnGestureCallback", "touchSlop", "getTouchSlop", "touchSlop$delegate", "calculateX", "originX", "width", LoginConstants.DX_ONE_KEY_LOGIN, "calculateY", "originY", "dy", "cancel", MissionEvent.MESSAGE_TOUCH, "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "windowManager", "Landroid/view/WindowManager;", "params", "Landroid/view/WindowManager$LayoutParams;", "recordLocation", "updateDisplayInfo", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TouchHelper {
    public final Lazy blockOffset$delegate;
    public final Config config;
    public final Context context;
    public int displayHeight;
    public Rect displayRect;
    public int displayWidth;
    public Function0<Unit> dragGestureCallback;
    public int emptyHeight;
    public boolean hasStatusBar;
    public float lastX;
    public float lastY;
    public final Lazy navigationBarHeight$delegate;
    public Function1<? super Boolean, Unit> scaleGestureCallback;
    public final Lazy scaleGestureDetector$delegate;
    public final Lazy screenHeight$delegate;
    public Function0<Unit> singleTapOnGestureCallback;
    public final Lazy touchSlop$delegate;

    public TouchHelper(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.displayRect = new Rect();
        this.screenHeight$delegate = BdPlayerUtils.lazyNone(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$screenHeight$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(UtilsKt.getScreenHeight(TouchHelper.this.getContext()));
            }
        });
        this.navigationBarHeight$delegate = BdPlayerUtils.lazyNone(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$navigationBarHeight$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(UtilsKt.getNavBarHeight(TouchHelper.this.getContext()));
            }
        });
        this.touchSlop$delegate = BdPlayerUtils.lazyNone(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$touchSlop$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(TouchHelper.this.getContext()).getScaledTouchSlop());
            }
        });
        this.hasStatusBar = true;
        this.blockOffset$delegate = BdPlayerUtils.lazyNone(new Function0<Rect>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$blockOffset$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                return new Rect(UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().left), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().top), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().right), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().bottom));
            }
        });
        this.scaleGestureDetector$delegate = BdPlayerUtils.lazyNone(new Function0<FloatingScaleGestureDetector>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$scaleGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FloatingScaleGestureDetector invoke() {
                FloatingScaleGestureDetector floatingScaleGestureDetector = new FloatingScaleGestureDetector(TouchHelper.this.getContext());
                final TouchHelper touchHelper = TouchHelper.this;
                floatingScaleGestureDetector.setOnScaleGestureCallback(new Function1<Boolean, Unit>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$scaleGestureDetector$2$1$1
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
                        TouchHelper.this.getConfig().setDragging(z);
                        Function1<Boolean, Unit> scaleGestureCallback = TouchHelper.this.getScaleGestureCallback();
                        if (scaleGestureCallback != null) {
                            scaleGestureCallback.invoke(Boolean.valueOf(z));
                        }
                    }
                });
                floatingScaleGestureDetector.setOnDoubleTapOnGestureCallback(new Function1<Boolean, Unit>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$scaleGestureDetector$2$1$2
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
                        TouchHelper.this.getConfig().setDragging(z);
                        Function1<Boolean, Unit> scaleGestureCallback = TouchHelper.this.getScaleGestureCallback();
                        if (scaleGestureCallback != null) {
                            scaleGestureCallback.invoke(Boolean.valueOf(z));
                        }
                    }
                });
                floatingScaleGestureDetector.setOnSingleTapOnGestureCallback(new Function0<Unit>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$scaleGestureDetector$2$1$3
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
                        Function0<Unit> singleTapOnGestureCallback = TouchHelper.this.getSingleTapOnGestureCallback();
                        if (singleTapOnGestureCallback != null) {
                            singleTapOnGestureCallback.invoke();
                        }
                    }
                });
                return floatingScaleGestureDetector;
            }
        });
    }

    private final int calculateX(int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = getBlockOffset().left;
        int i6 = (this.displayWidth - i2) - getBlockOffset().right;
        if (i4 < i5) {
            return i5;
        }
        if (i4 > i6) {
            return i6;
        }
        return i4;
    }

    private final int calculateY(int i, int i2) {
        int i3 = i + i2;
        int i4 = getBlockOffset().top;
        int i5 = this.emptyHeight - getBlockOffset().bottom;
        if (i3 < i4) {
            return i4;
        }
        if (i3 > i5) {
            return i5;
        }
        return i3;
    }

    private final Rect getBlockOffset() {
        return (Rect) this.blockOffset$delegate.getValue();
    }

    private final int getNavigationBarHeight() {
        return ((Number) this.navigationBarHeight$delegate.getValue()).intValue();
    }

    private final FloatingScaleGestureDetector getScaleGestureDetector() {
        return (FloatingScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    private final int getScreenHeight() {
        return ((Number) this.screenHeight$delegate.getValue()).intValue();
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    private final boolean hasStatusBar() {
        if (this.displayHeight != getScreenHeight() && this.displayHeight + getNavigationBarHeight() != getScreenHeight()) {
            return false;
        }
        return true;
    }

    public final void cancel() {
        getScaleGestureDetector().cancelAnimator();
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function0<Unit> getDragGestureCallback() {
        return this.dragGestureCallback;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getScaleGestureCallback() {
        return this.scaleGestureCallback;
    }

    public final Function0<Unit> getSingleTapOnGestureCallback() {
        return this.singleTapOnGestureCallback;
    }

    private final void recordLocation(MotionEvent motionEvent) {
        this.lastX = motionEvent.getRawX();
        this.lastY = motionEvent.getRawY();
    }

    private final void updateDisplayInfo(WindowManager windowManager) {
        windowManager.getDefaultDisplay().getRectSize(this.displayRect);
        this.displayWidth = this.displayRect.width();
        this.displayHeight = this.displayRect.height();
    }

    public final void setDragGestureCallback(Function0<Unit> function0) {
        this.dragGestureCallback = function0;
    }

    public final void setScaleGestureCallback(Function1<? super Boolean, Unit> function1) {
        this.scaleGestureCallback = function1;
    }

    public final void setSingleTapOnGestureCallback(Function0<Unit> function0) {
        this.singleTapOnGestureCallback = function0;
    }

    public final void onTouch(View view2, MotionEvent event, WindowManager windowManager, WindowManager.LayoutParams params) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (getScaleGestureDetector().onTouchEvent(event, view2, this.config.getSupportScaleDoubleTap(), this.config.getSupportScaleGesture())) {
            return;
        }
        if (this.config.getCanDrag() && !this.config.isAnimating() && !getScaleGestureDetector().isInProgress()) {
            int action = event.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return;
                    }
                    float rawX = event.getRawX() - this.lastX;
                    float rawY = event.getRawY() - this.lastY;
                    if (!this.config.isDragging() && (rawX * rawX) + (rawY * rawY) < getTouchSlop()) {
                        return;
                    }
                    this.config.setDragging(true);
                    params.x = calculateX(params.x, view2.getWidth(), (int) rawX);
                    params.y = calculateY(params.y, (int) rawY);
                    windowManager.updateViewLayout(view2, params);
                    recordLocation(event);
                    return;
                }
                if (this.config.isDragging() && (function0 = this.dragGestureCallback) != null) {
                    function0.invoke();
                }
                this.config.setDragging(false);
                return;
            }
            this.config.setDragging(false);
            recordLocation(event);
            updateDisplayInfo(windowManager);
            this.hasStatusBar = hasStatusBar();
            this.emptyHeight = this.displayHeight - view2.getHeight();
            return;
        }
        this.config.setDragging(false);
    }
}
