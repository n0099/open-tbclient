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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.fluency.R;
import com.baidu.searchbox.fluency.listener.FrameRateListener;
import com.baidu.searchbox.fluency.tracer.DropLevel;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.fluency.utils.FpsHandlerThread;
import com.baidu.searchbox.fluency.view.FpsDecorator;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\bU\u0010VJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004JO\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\f¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004JG\u0010-\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00100R\u0018\u0010@\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00100R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010CR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010CR\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010AR\u0016\u0010J\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010>R\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00100R\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u00100R\u0016\u0010M\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010>R\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "", "dismiss", "()V", "", "topPage", "", "startNs", "endNs", "", "dropFrame", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "doFrameAsync", "(Ljava/lang/String;JJIZJJJ)V", FpsConstants.REPORT_FPS, "getColor", "(I)I", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Landroid/content/Context;", "context", "initLayoutParams", "(Landroid/content/Context;)V", "isEnable", "()Z", "isShowing", c.l, "setEnable", "(Z)V", "show", "Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "floatView", "normal", "middle", "high", "frozen", "updateView", "(Lcom/baidu/searchbox/fluency/view/FpsFloatView;ILjava/lang/String;IIII)V", "belongColor", "I", "bestColor", "Landroid/content/Context;", "Landroid/util/DisplayMetrics;", "displayMetrics", "Landroid/util/DisplayMetrics;", "", FpsConstants.REPORT_DROP_LEVEL, "[I", "executor", "Ljava/util/concurrent/Executor;", "Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "", "frameIntervalMs", "F", "frozenColor", "handler", "Landroid/os/Handler;", "highColor", "Z", "lastCost", "lastFrames", "J", "lastTopPage", "Ljava/lang/String;", "mainHandler", "maxFps", "middleColor", "normalColor", "sumFrameCost", "sumFrames", "Landroid/view/WindowManager$LayoutParams;", "windowLp", "Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/fluency/view/FpsFloatView;)V", "Companion", "FloatOnTouchListener", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class FpsDecorator extends FrameRateListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static FpsDecorator INSTANCE = null;
    public static final String TAG = "FpsDecorator";
    public static Object lock;
    public transient /* synthetic */ FieldHolder $fh;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator$Companion;", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "getInstance", "(Landroid/content/Context;)Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "INSTANCE", "Lcom/baidu/searchbox/fluency/view/FpsDecorator;", "", "TAG", "Ljava/lang/String;", "", "lock", "Ljava/lang/Object;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final FpsDecorator getInstance(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
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
            return (FpsDecorator) invokeL.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsDecorator$FloatOnTouchListener;", "android/view/View$OnTouchListener", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", MissionEvent.MESSAGE_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "downOffsetX", "I", "getDownOffsetX", "()I", "setDownOffsetX", "(I)V", "downOffsetY", "getDownOffsetY", "setDownOffsetY", "", "downX", "F", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "<init>", "(Lcom/baidu/searchbox/fluency/view/FpsDecorator;)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final class FloatOnTouchListener implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int downOffsetX;
        public int downOffsetY;
        public float downX;
        public float downY;
        public final /* synthetic */ FpsDecorator this$0;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public FloatOnTouchListener(FpsDecorator fpsDecorator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fpsDecorator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fpsDecorator;
        }

        public final int getDownOffsetX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.downOffsetX : invokeV.intValue;
        }

        public final int getDownOffsetY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.downOffsetY : invokeV.intValue;
        }

        public final float getDownX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.downX : invokeV.floatValue;
        }

        public final float getDownY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.downY : invokeV.floatValue;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(final View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, motionEvent)) == null) {
                Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    this.downX = motionEvent.getX();
                    this.downY = motionEvent.getY();
                    this.downOffsetX = FpsDecorator.access$getWindowLp$p(this.this$0).x;
                    this.downOffsetY = FpsDecorator.access$getWindowLp$p(this.this$0).y;
                } else {
                    if (valueOf != null && valueOf.intValue() == 2) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float f2 = 3;
                        FpsDecorator.access$getWindowLp$p(this.this$0).x += (int) ((x - this.downX) / f2);
                        FpsDecorator.access$getWindowLp$p(this.this$0).y += (int) ((y - this.downY) / f2);
                        FpsDecorator.access$getWindowLp$p(this.this$0).y = FpsDecorator.access$getWindowLp$p(this.this$0).y < 0 ? 0 : FpsDecorator.access$getWindowLp$p(this.this$0).y;
                        FpsDecorator.access$getWindowLp$p(this.this$0).x = FpsDecorator.access$getWindowLp$p(this.this$0).x >= 0 ? FpsDecorator.access$getWindowLp$p(this.this$0).x : 0;
                        int i3 = this.this$0.displayMetrics.widthPixels;
                        Intrinsics.checkNotNull(view);
                        int width = i3 - view.getWidth();
                        WindowManager.LayoutParams access$getWindowLp$p = FpsDecorator.access$getWindowLp$p(this.this$0);
                        if (FpsDecorator.access$getWindowLp$p(this.this$0).x <= width) {
                            width = FpsDecorator.access$getWindowLp$p(this.this$0).x;
                        }
                        access$getWindowLp$p.x = width;
                        FpsDecorator.access$getWindowManager$p(this.this$0).updateViewLayout(view, FpsDecorator.access$getWindowLp$p(this.this$0));
                    } else if (valueOf != null && valueOf.intValue() == 1) {
                        int i4 = FpsDecorator.access$getWindowLp$p(this.this$0).x;
                        if (FpsDecorator.access$getWindowLp$p(this.this$0).x > this.this$0.displayMetrics.widthPixels / 2) {
                            int i5 = this.this$0.displayMetrics.widthPixels;
                            Intrinsics.checkNotNull(view);
                            i2 = i5 - view.getWidth();
                        } else {
                            i2 = 0;
                        }
                        ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("trans", i4, i2));
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$FloatOnTouchListener$onTouch$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ View $v;
                            public final /* synthetic */ FpsDecorator.FloatOnTouchListener this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i6 = newInitContext.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.$v = view;
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                boolean z;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                                    z = this.this$0.this$0.isShowing;
                                    if (z) {
                                        Object animatedValue = valueAnimator.getAnimatedValue("trans");
                                        if (animatedValue != null) {
                                            FpsDecorator.access$getWindowLp$p(this.this$0.this$0).x = ((Integer) animatedValue).intValue();
                                            FpsDecorator.access$getWindowManager$p(this.this$0.this$0).updateViewLayout(this.$v, FpsDecorator.access$getWindowLp$p(this.this$0.this$0));
                                            return;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                    }
                                }
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(animator, "animator");
                        animator.setInterpolator(new AccelerateInterpolator());
                        animator.setDuration(180L).start();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public final void setDownOffsetX(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.downOffsetX = i2;
            }
        }

        public final void setDownOffsetY(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.downOffsetY = i2;
            }
        }

        public final void setDownX(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
                this.downX = f2;
            }
        }

        public final void setDownY(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
                this.downY = f2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1929021818, "Lcom/baidu/searchbox/fluency/view/FpsDecorator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1929021818, "Lcom/baidu/searchbox/fluency/view/FpsDecorator;");
                return;
            }
        }
        Companion = new Companion(null);
        lock = new Object();
    }

    public FpsDecorator(Context context, FpsFloatView floatView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, floatView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(floatView, "floatView");
        this.context = context;
        this.floatView = floatView;
        this.frameIntervalMs = 16.666668f;
        this.maxFps = 1000.0f / 16.666668f;
        this.displayMetrics = new DisplayMetrics();
        this.isEnable = true;
        this.mainHandler = FpsHandlerThread.INSTANCE.getDefaultMainHandler();
        this.bestColor = this.context.getResources().getColor(R.color.level_best_color);
        this.normalColor = this.context.getResources().getColor(R.color.level_normal_color);
        this.middleColor = this.context.getResources().getColor(R.color.level_middle_color);
        this.highColor = this.context.getResources().getColor(R.color.level_high_color);
        this.frozenColor = this.context.getResources().getColor(R.color.level_frozen_color);
        this.belongColor = this.bestColor;
        this.dropLevel = new int[DropLevel.values().length];
        this.lastTopPage = "default";
        this.executor = new Executor(this) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$executor$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FpsDecorator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Handler handler;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    handler = this.this$0.getHandler();
                    handler.post(runnable);
                }
            }
        };
        TextView fpsView = this.floatView.getFpsView();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.0f FPS", Arrays.copyOf(new Object[]{Float.valueOf(this.maxFps)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        fpsView.setText(format);
        this.floatView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this, BdTracesManager.INSTANCE.getFpsTracer()) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FpsTracer $fpsTracer;
            public final /* synthetic */ FpsDecorator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.$fpsTracer = r7;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.$fpsTracer.addListener(this.this$0);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    this.$fpsTracer.removeListener(this.this$0);
                }
            }
        });
        initLayoutParams(this.context);
        this.floatView.setOnTouchListener(new FloatOnTouchListener(this));
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

    private final int getColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, this, i2)) == null) {
            if (i2 > 57) {
                return this.bestColor;
            }
            if (i2 > 50) {
                return this.normalColor;
            }
            if (i2 > 35) {
                return this.middleColor;
            }
            if (i2 > 20) {
                return this.highColor;
            }
            return this.frozenColor;
        }
        return invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r0.isAlive() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
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
        return (Handler) invokeV.objValue;
    }

    private final void initLayoutParams(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
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
    }

    private final void updateView(final FpsFloatView fpsFloatView, final int i2, final String str, final int i3, final int i4, final int i5, final int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{fpsFloatView, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = i3 + i4 + i5 + i6;
            float f2 = i7 <= 0 ? 0.0f : ((i6 * 1.0f) / i7) * 60;
            float f3 = i7 <= 0 ? 0.0f : ((i5 * 1.0f) / i7) * 30;
            float f4 = i7 <= 0 ? 0.0f : ((i4 * 1.0f) / i7) * 15;
            float f5 = i7 <= 0 ? 0.0f : ((i3 * 1.0f) / i7) * 5;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String format = String.format("平均丢帧: %.1f", Arrays.copyOf(new Object[]{Float.valueOf(f2 + f3 + f4 + f5)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            float f6 = i7 <= 0 ? 0.0f : (i6 * 1.0f) / i7;
            float f7 = i7 <= 0 ? 0.0f : (i5 * 1.0f) / i7;
            float f8 = i7 <= 0 ? 0.0f : (i4 * 1.0f) / i7;
            float f9 = i7 > 0 ? (i3 * 1.0f) / i7 : 0.0f;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            final String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f6)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            final String format3 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f7)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            final String format4 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f8)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            final String format5 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f9)}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "java.lang.String.format(format, *args)");
            this.belongColor = getColor(i2);
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            final String format6 = String.format("%d FPS", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format6, "java.lang.String.format(format, *args)");
            this.mainHandler.post(new Runnable(this, fpsFloatView, i2, format6, format, str, i6, i5, i4, i3, format2, format3, format4, format5) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$updateView$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ String $expectStr;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FpsFloatView $floatView;
                public final /* synthetic */ int $fps;
                public final /* synthetic */ String $fpsStr;
                public final /* synthetic */ int $frozen;
                public final /* synthetic */ int $high;
                public final /* synthetic */ int $middle;
                public final /* synthetic */ int $normal;
                public final /* synthetic */ String $ratioFrozen;
                public final /* synthetic */ String $ratioHigh;
                public final /* synthetic */ String $ratioMiddle;
                public final /* synthetic */ String $ratioNormal;
                public final /* synthetic */ String $topPage;
                public final /* synthetic */ FpsDecorator this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, fpsFloatView, Integer.valueOf(i2), format6, format, str, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3), format2, format3, format4, format5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i8 = newInitContext.flag;
                        if ((i8 & 1) != 0) {
                            int i9 = i8 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$floatView = fpsFloatView;
                    this.$fps = i2;
                    this.$fpsStr = format6;
                    this.$expectStr = format;
                    this.$topPage = str;
                    this.$frozen = i6;
                    this.$high = i5;
                    this.$middle = i4;
                    this.$normal = i3;
                    this.$ratioFrozen = format2;
                    this.$ratioHigh = format3;
                    this.$ratioMiddle = format4;
                    this.$ratioNormal = format5;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i8;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.$floatView.getChartView().addFps(this.$fps);
                        this.$floatView.getFpsView().setText(this.$fpsStr);
                        TextView fpsView = this.$floatView.getFpsView();
                        i8 = this.this$0.belongColor;
                        fpsView.setTextColor(i8);
                        this.$floatView.getDropExpectView().setText(this.$expectStr);
                        this.$floatView.getTopPageView().setText(this.$topPage);
                        this.$floatView.getLevelFrozensView().setText(String.valueOf(this.$frozen));
                        this.$floatView.getLevelHighsView().setText(String.valueOf(this.$high));
                        this.$floatView.getLevelMiddlesView().setText(String.valueOf(this.$middle));
                        this.$floatView.getLevelNormalsView().setText(String.valueOf(this.$normal));
                        this.$floatView.getLevelFrozenView().setText(this.$ratioFrozen);
                        this.$floatView.getLevelHighView().setText(this.$ratioHigh);
                        this.$floatView.getLevelMiddleView().setText(this.$ratioMiddle);
                        this.$floatView.getLevelNormalView().setText(this.$ratioNormal);
                    }
                }
            });
        }
    }

    public final void dismiss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.isEnable) {
            this.mainHandler.post(new Runnable(this) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$dismiss$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FpsDecorator this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    FpsFloatView fpsFloatView;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        z = this.this$0.isShowing;
                        if (z) {
                            this.this$0.isShowing = false;
                            WindowManager access$getWindowManager$p = FpsDecorator.access$getWindowManager$p(this.this$0);
                            fpsFloatView = this.this$0.floatView;
                            access$getWindowManager$p.removeView(fpsFloatView);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
    public void doFrameAsync(String topPage, long j2, long j3, int i2, boolean z, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{topPage, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) {
            Intrinsics.checkNotNullParameter(topPage, "topPage");
            super.doFrameAsync(topPage, j2, j3, i2, z, j4, j5, j6);
            if (!TextUtils.equals(topPage, this.lastTopPage)) {
                this.lastTopPage = topPage;
                ArraysKt___ArraysJvmKt.fill$default(this.dropLevel, 0, 0, 0, 6, (Object) null);
            }
            float f2 = this.sumFrameCost + ((i2 + 1) * this.frameIntervalMs);
            this.sumFrameCost = f2;
            long j7 = this.sumFrames + 1;
            this.sumFrames = j7;
            float f3 = f2 - this.lastCost;
            long j8 = j7 - this.lastFrames;
            if (i2 >= 40) {
                int[] iArr = this.dropLevel;
                int index = DropLevel.DROPPED_FROZEN.getIndex();
                iArr[index] = iArr[index] + 1;
            } else if (i2 >= 25) {
                int[] iArr2 = this.dropLevel;
                int index2 = DropLevel.DROPPED_HIGH.getIndex();
                iArr2[index2] = iArr2[index2] + 1;
            } else if (i2 >= 10) {
                int[] iArr3 = this.dropLevel;
                int index3 = DropLevel.DROPPED_MIDDLE.getIndex();
                iArr3[index3] = iArr3[index3] + 1;
            } else if (i2 >= 3) {
                int[] iArr4 = this.dropLevel;
                int index4 = DropLevel.DROPPED_NORMAL.getIndex();
                iArr4[index4] = iArr4[index4] + 1;
            } else {
                int[] iArr5 = this.dropLevel;
                int index5 = DropLevel.DROPPED_BEST.getIndex();
                iArr5[index5] = iArr5[index5] + 1;
            }
            if (f3 >= 200) {
                updateView(this.floatView, MathKt__MathJVMKt.roundToInt(Math.min(this.maxFps, (((float) j8) * 1000.0f) / f3)), topPage, this.dropLevel[DropLevel.DROPPED_NORMAL.getIndex()], this.dropLevel[DropLevel.DROPPED_MIDDLE.getIndex()], this.dropLevel[DropLevel.DROPPED_HIGH.getIndex()], this.dropLevel[DropLevel.DROPPED_FROZEN.getIndex()]);
                this.lastCost = this.sumFrameCost;
                this.lastFrames = this.sumFrames;
            }
        }
    }

    @Override // com.baidu.searchbox.fluency.listener.FrameRateListener
    public Executor getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.executor : (Executor) invokeV.objValue;
    }

    public final boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isEnable : invokeV.booleanValue;
    }

    public final boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isShowing : invokeV.booleanValue;
    }

    public final void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isEnable = z;
        }
    }

    public final void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.isEnable) {
            this.mainHandler.post(new Runnable(this) { // from class: com.baidu.searchbox.fluency.view.FpsDecorator$show$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FpsDecorator this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    FpsFloatView fpsFloatView;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        z = this.this$0.isShowing;
                        if (z) {
                            return;
                        }
                        this.this$0.isShowing = true;
                        WindowManager access$getWindowManager$p = FpsDecorator.access$getWindowManager$p(this.this$0);
                        fpsFloatView = this.this$0.floatView;
                        access$getWindowManager$p.addView(fpsFloatView, FpsDecorator.access$getWindowLp$p(this.this$0));
                    }
                }
            });
        }
    }
}
