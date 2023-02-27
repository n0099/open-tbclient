package com.baidu.searchbox.fluency.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.fluency.listener.FrameRateListener;
import com.baidu.searchbox.fluency.tracer.DropLevel;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.fluency.utils.FpsHandlerThread;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\bU\u0010VJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004JO\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\f¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004JG\u0010-\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00100R\u0018\u0010@\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00100R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010CR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010CR\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010AR\u0016\u0010J\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010>R\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00100R\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u00100R\u0016\u0010M\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010>R\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "", "dismiss", "()V", "", "topPage", "", "startNs", "endNs", "", "dropFrame", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "doFrameAsync", "(Ljava/lang/String;JJIZJJJ)V", FpsConstants.REPORT_FPS, "getColor", "(I)I", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Landroid/content/Context;", "context", "initLayoutParams", "(Landroid/content/Context;)V", "isEnable", "()Z", "isShowing", "enable", "setEnable", "(Z)V", "show", "Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "floatView", "normal", NativeConstants.MIDDLE, "high", "frozen", "updateView", "(Lcom/baidu/searchbox/fluency/view/FpsFloatView;ILjava/lang/String;IIII)V", "belongColor", "I", "bestColor", "Landroid/content/Context;", "Landroid/util/DisplayMetrics;", "displayMetrics", "Landroid/util/DisplayMetrics;", "", FpsConstants.REPORT_DROP_LEVEL, "[I", "executor", "Ljava/util/concurrent/Executor;", "Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "", "frameIntervalMs", "F", "frozenColor", "handler", "Landroid/os/Handler;", "highColor", "Z", "lastCost", "lastFrames", "J", "lastTopPage", "Ljava/lang/String;", "mainHandler", "maxFps", "middleColor", "normalColor", "sumFrameCost", "sumFrames", "Landroid/view/WindowManager$LayoutParams;", "windowLp", "Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/fluency/view/FpsFloatView;)V", "Companion", "FloatOnTouchListener", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FpsDecorator extends FrameRateListener {
    public static FpsDecorator INSTANCE = null;
    public static final String TAG = "FpsDecorator";
    public int belongColor;
    public final int bestColor;
    public final Context context;
    public final DisplayMetrics displayMetrics;
    public int[] dropLevel;
    public final Executor executor;
    public final FpsFloatView floatView;
    public float frameIntervalMs;
    public final int frozenColor;
    public Handler handler;
    public final int highColor;
    public boolean isEnable;
    public boolean isShowing;
    public float lastCost;
    public long lastFrames;
    public String lastTopPage;
    public final Handler mainHandler;
    public float maxFps;
    public final int middleColor;
    public final int normalColor;
    public float sumFrameCost;
    public long sumFrames;
    public WindowManager.LayoutParams windowLp;
    public WindowManager windowManager;
    public static final Companion Companion = new Companion(null);
    public static Object lock = new Object();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator$Companion;", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "getInstance", "(Landroid/content/Context;)Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "INSTANCE", "Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "", "TAG", "Ljava/lang/String;", "", "lock", "Ljava/lang/Object;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FpsDecorator getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (FpsDecorator.INSTANCE == null) {
                synchronized (FpsDecorator.lock) {
                    if (FpsDecorator.INSTANCE == null) {
                        FpsDecorator.INSTANCE = new FpsDecorator(context, new FpsFloatView(context));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            FpsDecorator fpsDecorator = FpsDecorator.INSTANCE;
            Intrinsics.checkNotNull(fpsDecorator);
            return fpsDecorator;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator$FloatOnTouchListener;", "android/view/View$OnTouchListener", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", MissionEvent.MESSAGE_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "downOffsetX", "I", "getDownOffsetX", "()I", "setDownOffsetX", "(I)V", "downOffsetY", "getDownOffsetY", "setDownOffsetY", "", "downX", "F", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "<init>", "(Lcom/baidu/searchbox/fluency/view/FpsDecorator;)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class FloatOnTouchListener implements View.OnTouchListener {
        public int downOffsetX;
        public int downOffsetY;
        public float downX;
        public float downY;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public FloatOnTouchListener() {
        }

        public final void setDownOffsetX(int i) {
            this.downOffsetX = i;
        }

        public final void setDownOffsetY(int i) {
            this.downOffsetY = i;
        }

        public final void setDownX(float f) {
            this.downX = f;
        }

        public final void setDownY(float f) {
            this.downY = f;
        }

        public final int getDownOffsetX() {
            return this.downOffsetX;
        }

        public final int getDownOffsetY() {
            return this.downOffsetY;
        }

        public final float getDownX() {
            return this.downX;
        }

        public final float getDownY() {
            return this.downY;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(final View view2, MotionEvent motionEvent) {
            Integer num;
            int i;
            int i2;
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
                this.downOffsetX = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x;
                this.downOffsetY = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).y;
            } else {
                int i3 = 0;
                if (num != null && num.intValue() == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = 3;
                    FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x += (int) ((x - this.downX) / f);
                    FpsDecorator.access$getWindowLp$p(FpsDecorator.this).y += (int) ((y - this.downY) / f);
                    WindowManager.LayoutParams access$getWindowLp$p = FpsDecorator.access$getWindowLp$p(FpsDecorator.this);
                    if (FpsDecorator.access$getWindowLp$p(FpsDecorator.this).y < 0) {
                        i2 = 0;
                    } else {
                        i2 = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).y;
                    }
                    access$getWindowLp$p.y = i2;
                    WindowManager.LayoutParams access$getWindowLp$p2 = FpsDecorator.access$getWindowLp$p(FpsDecorator.this);
                    if (FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x >= 0) {
                        i3 = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x;
                    }
                    access$getWindowLp$p2.x = i3;
                    int i4 = FpsDecorator.this.displayMetrics.widthPixels;
                    Intrinsics.checkNotNull(view2);
                    int width = i4 - view2.getWidth();
                    WindowManager.LayoutParams access$getWindowLp$p3 = FpsDecorator.access$getWindowLp$p(FpsDecorator.this);
                    if (FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x <= width) {
                        width = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x;
                    }
                    access$getWindowLp$p3.x = width;
                    FpsDecorator.access$getWindowManager$p(FpsDecorator.this).updateViewLayout(view2, FpsDecorator.access$getWindowLp$p(FpsDecorator.this));
                } else if (num != null && num.intValue() == 1) {
                    int i5 = FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x;
                    if (FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x > FpsDecorator.this.displayMetrics.widthPixels / 2) {
                        int i6 = FpsDecorator.this.displayMetrics.widthPixels;
                        Intrinsics.checkNotNull(view2);
                        i = i6 - view2.getWidth();
                    } else {
                        i = 0;
                    }
                    ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("trans", i5, i));
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$FloatOnTouchListener$onTouch$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            boolean z;
                            z = FpsDecorator.this.isShowing;
                            if (!z) {
                                return;
                            }
                            Object animatedValue = valueAnimator.getAnimatedValue("trans");
                            if (animatedValue != null) {
                                FpsDecorator.access$getWindowLp$p(FpsDecorator.this).x = ((Integer) animatedValue).intValue();
                                FpsDecorator.access$getWindowManager$p(FpsDecorator.this).updateViewLayout(view2, FpsDecorator.access$getWindowLp$p(FpsDecorator.this));
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(animator, "animator");
                    animator.setInterpolator(new AccelerateInterpolator());
                    animator.setDuration(180L).start();
                }
            }
            return true;
        }
    }

    public final void dismiss() {
        if (!this.isEnable) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$dismiss$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                FpsFloatView fpsFloatView;
                z = FpsDecorator.this.isShowing;
                if (!z) {
                    return;
                }
                FpsDecorator.this.isShowing = false;
                WindowManager access$getWindowManager$p = FpsDecorator.access$getWindowManager$p(FpsDecorator.this);
                fpsFloatView = FpsDecorator.this.floatView;
                access$getWindowManager$p.removeView(fpsFloatView);
            }
        });
    }

    @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
    public Executor getExecutor() {
        return this.executor;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void show() {
        if (!this.isEnable) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$show$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                FpsFloatView fpsFloatView;
                z = FpsDecorator.this.isShowing;
                if (z) {
                    return;
                }
                FpsDecorator.this.isShowing = true;
                WindowManager access$getWindowManager$p = FpsDecorator.access$getWindowManager$p(FpsDecorator.this);
                fpsFloatView = FpsDecorator.this.floatView;
                access$getWindowManager$p.addView(fpsFloatView, FpsDecorator.access$getWindowLp$p(FpsDecorator.this));
            }
        });
    }

    public FpsDecorator(Context context, FpsFloatView floatView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(floatView, "floatView");
        this.context = context;
        this.floatView = floatView;
        this.frameIntervalMs = 16.666668f;
        this.maxFps = 1000.0f / 16.666668f;
        this.displayMetrics = new DisplayMetrics();
        this.isEnable = true;
        this.mainHandler = FpsHandlerThread.INSTANCE.getDefaultMainHandler();
        this.bestColor = this.context.getResources().getColor(R.color.obfuscated_res_0x7f06062d);
        this.normalColor = this.context.getResources().getColor(R.color.obfuscated_res_0x7f060631);
        this.middleColor = this.context.getResources().getColor(R.color.obfuscated_res_0x7f060630);
        this.highColor = this.context.getResources().getColor(R.color.obfuscated_res_0x7f06062f);
        this.frozenColor = this.context.getResources().getColor(R.color.obfuscated_res_0x7f06062e);
        this.belongColor = this.bestColor;
        this.dropLevel = new int[DropLevel.values().length];
        this.lastTopPage = "default";
        this.executor = new Executor() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$executor$1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Handler handler;
                handler = FpsDecorator.this.getHandler();
                handler.post(runnable);
            }
        };
        TextView fpsView = this.floatView.getFpsView();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.0f FPS", Arrays.copyOf(new Object[]{Float.valueOf(this.maxFps)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        fpsView.setText(format);
        final FpsTracer fpsTracer = BdTracesManager.INSTANCE.getFpsTracer();
        this.floatView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                fpsTracer.addListener(FpsDecorator.this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                fpsTracer.removeListener(FpsDecorator.this);
            }
        });
        initLayoutParams(this.context);
        this.floatView.setOnTouchListener(new FloatOnTouchListener());
    }

    public static final /* synthetic */ WindowManager.LayoutParams access$getWindowLp$p(FpsDecorator fpsDecorator) {
        WindowManager.LayoutParams layoutParams = fpsDecorator.windowLp;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowLp");
        }
        return layoutParams;
    }

    public static final /* synthetic */ WindowManager access$getWindowManager$p(FpsDecorator fpsDecorator) {
        WindowManager windowManager = fpsDecorator.windowManager;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        }
        return windowManager;
    }

    private final int getColor(int i) {
        if (i > 57) {
            return this.bestColor;
        }
        if (i > 50) {
            return this.normalColor;
        }
        if (i > 35) {
            return this.middleColor;
        }
        if (i > 20) {
            return this.highColor;
        }
        return this.frozenColor;
    }

    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.isAlive() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Handler getHandler() {
        Handler handler = this.handler;
        if (handler != null) {
            Intrinsics.checkNotNull(handler);
            Looper looper = handler.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "handler!!.looper");
            Thread thread = looper.getThread();
            Intrinsics.checkNotNullExpressionValue(thread, "handler!!.looper.thread");
        }
        if (FpsHandlerThread.INSTANCE.getDefaultHandlerThread() != null) {
            this.handler = new Handler(FpsHandlerThread.INSTANCE.getDefaultHandlerThread().getLooper());
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        return handler2;
    }

    private final void initLayoutParams(Context context) {
        Object systemService = context.getApplicationContext().getSystemService("window");
        if (systemService != null) {
            this.windowManager = (WindowManager) systemService;
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = this.windowManager;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                }
                if (windowManager.getDefaultDisplay() != null) {
                    WindowManager windowManager2 = this.windowManager;
                    if (windowManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    }
                    windowManager2.getDefaultDisplay().getMetrics(displayMetrics);
                    WindowManager windowManager3 = this.windowManager;
                    if (windowManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    }
                    windowManager3.getDefaultDisplay().getMetrics(this.displayMetrics);
                }
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                this.windowLp = layoutParams;
                if (Build.VERSION.SDK_INT >= 26) {
                    if (layoutParams == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                    }
                    layoutParams.type = 2038;
                } else {
                    if (layoutParams == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                    }
                    layoutParams.type = 2002;
                }
                WindowManager.LayoutParams layoutParams2 = this.windowLp;
                if (layoutParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams2.flags = 40;
                WindowManager.LayoutParams layoutParams3 = this.windowLp;
                if (layoutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams3.gravity = BadgeDrawable.TOP_START;
                WindowManager.LayoutParams layoutParams4 = this.windowLp;
                if (layoutParams4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams4.x = 0;
                WindowManager.LayoutParams layoutParams5 = this.windowLp;
                if (layoutParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams5.y = 0;
                WindowManager.LayoutParams layoutParams6 = this.windowLp;
                if (layoutParams6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams6.width = -2;
                WindowManager.LayoutParams layoutParams7 = this.windowLp;
                if (layoutParams7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams7.height = -2;
                WindowManager.LayoutParams layoutParams8 = this.windowLp;
                if (layoutParams8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowLp");
                }
                layoutParams8.format = -2;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final void updateView(final FpsFloatView fpsFloatView, final int i, final String str, final int i2, final int i3, final int i4, final int i5) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i6 = i2 + i3 + i4 + i5;
        float f8 = 0.0f;
        if (i6 <= 0) {
            f = 0.0f;
        } else {
            f = ((i5 * 1.0f) / i6) * 60;
        }
        if (i6 <= 0) {
            f2 = 0.0f;
        } else {
            f2 = ((i4 * 1.0f) / i6) * 30;
        }
        if (i6 <= 0) {
            f3 = 0.0f;
        } else {
            f3 = ((i3 * 1.0f) / i6) * 15;
        }
        if (i6 <= 0) {
            f4 = 0.0f;
        } else {
            f4 = ((i2 * 1.0f) / i6) * 5;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        final String format = String.format("平均丢帧: %.1f", Arrays.copyOf(new Object[]{Float.valueOf(f + f2 + f3 + f4)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        if (i6 <= 0) {
            f5 = 0.0f;
        } else {
            f5 = (i5 * 1.0f) / i6;
        }
        if (i6 <= 0) {
            f6 = 0.0f;
        } else {
            f6 = (i4 * 1.0f) / i6;
        }
        if (i6 <= 0) {
            f7 = 0.0f;
        } else {
            f7 = (i3 * 1.0f) / i6;
        }
        if (i6 > 0) {
            f8 = (i2 * 1.0f) / i6;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        final String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f5)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        final String format3 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f6)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        final String format4 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f7)}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        final String format5 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f8)}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "java.lang.String.format(format, *args)");
        this.belongColor = getColor(i);
        StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
        final String format6 = String.format("%d FPS", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format6, "java.lang.String.format(format, *args)");
        this.mainHandler.post(new Runnable() { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$updateView$1
            @Override // java.lang.Runnable
            public final void run() {
                int i7;
                fpsFloatView.getChartView().addFps(i);
                fpsFloatView.getFpsView().setText(format6);
                TextView fpsView = fpsFloatView.getFpsView();
                i7 = FpsDecorator.this.belongColor;
                fpsView.setTextColor(i7);
                fpsFloatView.getDropExpectView().setText(format);
                fpsFloatView.getTopPageView().setText(str);
                fpsFloatView.getLevelFrozensView().setText(String.valueOf(i5));
                fpsFloatView.getLevelHighsView().setText(String.valueOf(i4));
                fpsFloatView.getLevelMiddlesView().setText(String.valueOf(i3));
                fpsFloatView.getLevelNormalsView().setText(String.valueOf(i2));
                fpsFloatView.getLevelFrozenView().setText(format2);
                fpsFloatView.getLevelHighView().setText(format3);
                fpsFloatView.getLevelMiddleView().setText(format4);
                fpsFloatView.getLevelNormalView().setText(format5);
            }
        });
    }

    @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
    public void doFrameAsync(String topPage, long j, long j2, int i, boolean z, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(topPage, "topPage");
        super.doFrameAsync(topPage, j, j2, i, z, j3, j4, j5);
        if (!TextUtils.equals(topPage, this.lastTopPage)) {
            this.lastTopPage = topPage;
            ArraysKt___ArraysJvmKt.fill$default(this.dropLevel, 0, 0, 0, 6, (Object) null);
        }
        float f = this.sumFrameCost + ((i + 1) * this.frameIntervalMs);
        this.sumFrameCost = f;
        long j6 = this.sumFrames + 1;
        this.sumFrames = j6;
        float f2 = f - this.lastCost;
        long j7 = j6 - this.lastFrames;
        if (i >= 40) {
            int[] iArr = this.dropLevel;
            int index = DropLevel.DROPPED_FROZEN.getIndex();
            iArr[index] = iArr[index] + 1;
        } else if (i >= 25) {
            int[] iArr2 = this.dropLevel;
            int index2 = DropLevel.DROPPED_HIGH.getIndex();
            iArr2[index2] = iArr2[index2] + 1;
        } else if (i >= 10) {
            int[] iArr3 = this.dropLevel;
            int index3 = DropLevel.DROPPED_MIDDLE.getIndex();
            iArr3[index3] = iArr3[index3] + 1;
        } else if (i >= 3) {
            int[] iArr4 = this.dropLevel;
            int index4 = DropLevel.DROPPED_NORMAL.getIndex();
            iArr4[index4] = iArr4[index4] + 1;
        } else {
            int[] iArr5 = this.dropLevel;
            int index5 = DropLevel.DROPPED_BEST.getIndex();
            iArr5[index5] = iArr5[index5] + 1;
        }
        if (f2 >= 200) {
            updateView(this.floatView, MathKt__MathJVMKt.roundToInt(Math.min(this.maxFps, (((float) j7) * 1000.0f) / f2)), topPage, this.dropLevel[DropLevel.DROPPED_NORMAL.getIndex()], this.dropLevel[DropLevel.DROPPED_MIDDLE.getIndex()], this.dropLevel[DropLevel.DROPPED_HIGH.getIndex()], this.dropLevel[DropLevel.DROPPED_FROZEN.getIndex()]);
            this.lastCost = this.sumFrameCost;
            this.lastFrames = this.sumFrames;
        }
    }
}
