package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RefreshingAnimView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CIRCULAR_ROTATION_DURATION = 750;
    public static final double G;
    public static final long MAGNIFIER_ROTATION_DURATION = 300;
    public static final int STATE_CIRCULAR_ROTATION = 3;
    public static final int STATE_MAGNIFIER = 1;
    public static final int STATE_MAGNIFIER_ROTATION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap A;
    public Canvas B;
    public Camera C;
    public Matrix D;
    public boolean E;
    public int F;

    /* renamed from: e  reason: collision with root package name */
    public float f46512e;

    /* renamed from: f  reason: collision with root package name */
    public float f46513f;

    /* renamed from: g  reason: collision with root package name */
    public float f46514g;

    /* renamed from: h  reason: collision with root package name */
    public float f46515h;

    /* renamed from: i  reason: collision with root package name */
    public float f46516i;

    /* renamed from: j  reason: collision with root package name */
    public float f46517j;
    public float k;
    public float l;
    public PointF m;
    public Paint n;
    public Paint o;
    public e p;
    public RectF q;
    public PointF r;
    public PointF s;
    public float t;
    public int u;
    public int v;
    public ValueAnimator w;
    public float x;
    public float y;
    public ValueAnimator z;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RefreshingAnimView f46518e;

        public a(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46518e = refreshingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46518e.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RefreshingAnimView f46519e;

        public b(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46519e = refreshingAnimView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f46519e.q(750L);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationRepeat(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RefreshingAnimView f46520e;

        public c(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46520e = refreshingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46520e.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RefreshingAnimView f46521e;

        public d(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46521e = refreshingAnimView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationRepeat(animator);
                RefreshingAnimView.e(this.f46521e);
                if (this.f46521e.v <= this.f46521e.u || this.f46521e.p == null) {
                    return;
                }
                this.f46521e.p.a(true);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1474760358, "Lcom/baidu/swan/apps/res/ui/pullrefresh/RefreshingAnimView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1474760358, "Lcom/baidu/swan/apps/res/ui/pullrefresh/RefreshingAnimView;");
                return;
            }
        }
        G = Math.sqrt(2.0d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshingAnimView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46512e = 0.0f;
        this.f46513f = 0.0f;
        this.f46514g = 0.0f;
        this.f46515h = 0.0f;
        this.f46516i = 0.0f;
        this.f46517j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }

    public static /* synthetic */ int e(RefreshingAnimView refreshingAnimView) {
        int i2 = refreshingAnimView.v;
        refreshingAnimView.v = i2 + 1;
        return i2;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float f2 = this.f46512e;
            this.f46513f = f2;
            if (f2 < 0.5f) {
                this.f46514g = 0.0f;
                this.f46516i = 0.0f;
                return;
            }
            this.f46516i = ((f2 - 0.5f) / 0.5f) * this.f46517j;
            if (f2 < 0.625f) {
                this.f46514g = 0.0f;
                return;
            }
            float f3 = (f2 - 0.625f) / 0.375f;
            this.f46514g = f3;
            PointF pointF = this.r;
            float f4 = pointF.x;
            float f5 = this.t;
            double d2 = G;
            float f6 = pointF.y + ((float) ((f5 * f3) / d2));
            this.s.set(f4 + ((float) ((f5 * f3) / d2)), f6);
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.F = i2;
        }
    }

    public boolean isCircleRotateAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ValueAnimator valueAnimator = this.w;
            if (valueAnimator != null) {
                return valueAnimator.isRunning();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMagnifierRotateAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ValueAnimator valueAnimator = this.z;
            if (valueAnimator != null) {
                return valueAnimator.isRunning();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || (bitmap = this.A) == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        int abs = (int) ((((1.0d - (Math.abs(this.x - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
        if (this.E) {
            abs = (int) ((((1.0d - (Math.abs(this.x - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
        }
        this.n.setAlpha(abs);
        Canvas canvas2 = this.B;
        PointF pointF = this.m;
        canvas2.drawCircle(pointF.x, pointF.y, this.k, this.n);
        this.D.reset();
        this.C.save();
        this.C.setLocation(0.0f, 0.0f, -100.0f);
        this.C.rotateY((this.x * 360.0f) + 90.0f);
        this.C.getMatrix(this.D);
        this.C.restore();
        Matrix matrix = this.D;
        PointF pointF2 = this.m;
        matrix.preTranslate(-pointF2.x, -pointF2.y);
        Matrix matrix2 = this.D;
        PointF pointF3 = this.m;
        matrix2.postTranslate(pointF3.x, pointF3.y);
        canvas.drawBitmap(this.A, this.D, null);
    }

    public final void k(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) || (bitmap = this.A) == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        if (this.E != c.a.p0.a.c1.a.H().a()) {
            this.n.setColor(getResources().getColor(c.a.p0.a.c.aiapps_pull_loading_refresh_anim_color));
            this.E = c.a.p0.a.c1.a.H().a();
        }
        this.n.setAlpha(76);
        RectF rectF = this.q;
        PointF pointF = this.m;
        float f2 = pointF.x;
        float f3 = this.f46515h;
        float f4 = pointF.y;
        rectF.set(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
        this.B.drawArc(this.q, -90.0f, this.f46513f * (-360.0f), true, this.n);
        Canvas canvas2 = this.B;
        PointF pointF2 = this.m;
        canvas2.drawCircle(pointF2.x, pointF2.y, this.f46516i, this.o);
        if (this.f46514g > 0.0f) {
            Canvas canvas3 = this.B;
            PointF pointF3 = this.s;
            canvas3.drawCircle(pointF3.x, pointF3.y, 0.75f, this.n);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setStrokeWidth(n0.f(getContext(), 1.5f));
            Canvas canvas4 = this.B;
            PointF pointF4 = this.r;
            float f5 = pointF4.x;
            float f6 = pointF4.y;
            PointF pointF5 = this.s;
            canvas4.drawLine(f5, f6, pointF5.x, pointF5.y, this.n);
        }
        canvas.drawBitmap(this.A, 0.0f, 0.0f, (Paint) null);
    }

    public final void l(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || (bitmap = this.A) == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setAlpha((int) (((this.y * 0.3d) + 0.3d) * 255.0d));
        float f2 = this.r.x + ((float) (this.t / G));
        Canvas canvas2 = this.B;
        PointF pointF = this.m;
        canvas2.drawCircle(pointF.x, pointF.y, this.f46515h, this.n);
        Canvas canvas3 = this.B;
        PointF pointF2 = this.m;
        canvas3.drawCircle(pointF2.x, pointF2.y, this.f46517j, this.o);
        this.B.drawCircle(f2, f2, 0.75f, this.n);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(n0.f(getContext(), 1.5f));
        Canvas canvas4 = this.B;
        PointF pointF3 = this.r;
        canvas4.drawLine(pointF3.x, pointF3.y, f2, f2, this.n);
        this.D.reset();
        this.C.save();
        this.C.setLocation(0.0f, 0.0f, -100.0f);
        this.C.rotateY(this.y * 90.0f);
        this.C.getMatrix(this.D);
        this.C.restore();
        Matrix matrix = this.D;
        PointF pointF4 = this.m;
        matrix.preTranslate(-pointF4.x, -pointF4.y);
        Matrix matrix2 = this.D;
        PointF pointF5 = this.m;
        matrix2.postTranslate(pointF5.x, pointF5.y);
        canvas.drawBitmap(this.A, this.D, null);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.E = c.a.p0.a.c1.a.H().a();
            Paint paint = new Paint();
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setColor(getResources().getColor(c.a.p0.a.c.aiapps_pull_loading_refresh_anim_color));
            Paint paint2 = new Paint();
            this.o = paint2;
            paint2.setAntiAlias(true);
            this.o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.C = new Camera();
            this.D = new Matrix();
            i(1);
        }
    }

    public final void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            if (f2 < 0.2f) {
                this.x = (f2 / 0.2f) * 0.5f;
            } else {
                this.x = (((f2 - 0.2f) / 0.8f) * 0.5f) + 0.5f;
            }
            postInvalidate();
        }
    }

    public final void o(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.y = f2;
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            p();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            int i2 = this.F;
            if (i2 == 1) {
                k(canvas);
            } else if (i2 == 2) {
                l(canvas);
            } else if (i2 == 3) {
                j(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() > getHeight()) {
                this.l = getMeasuredHeight();
            } else {
                this.l = getMeasuredWidth();
            }
            this.f46515h = n0.f(getContext(), 8.0f);
            this.f46517j = n0.f(getContext(), 6.5f);
            this.t = n0.f(getContext(), 5.0f);
            this.k = n0.f(getContext(), 7.5f);
            float f2 = this.l / 2.0f;
            this.m.set(f2, f2);
            float f3 = f2 + ((float) (this.f46515h / G));
            this.r.set(f3, f3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            this.A = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.B = new Canvas(this.A);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ValueAnimator valueAnimator = this.z;
            if (valueAnimator != null) {
                valueAnimator.setRepeatCount(0);
                this.z.removeAllUpdateListeners();
                this.z.removeAllListeners();
                this.z.end();
                this.z.cancel();
            }
            ValueAnimator valueAnimator2 = this.w;
            if (valueAnimator2 != null) {
                valueAnimator2.setRepeatCount(0);
                this.w.removeAllUpdateListeners();
                this.w.removeAllListeners();
                this.w.end();
                this.w.cancel();
            }
        }
    }

    public final void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            i(3);
            if (this.w != null) {
                p();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.w = ofFloat;
            ofFloat.setDuration(j2);
            this.w.setInterpolator(new LinearInterpolator());
            this.w.setRepeatCount(-1);
            this.w.setRepeatMode(1);
            this.w.addUpdateListener(new c(this));
            if (this.u > 0) {
                this.w.addListener(new d(this));
            } else {
                e eVar = this.p;
                if (eVar != null) {
                    eVar.a(true);
                }
            }
            if (this.w.isRunning()) {
                return;
            }
            this.w.start();
        }
    }

    public final void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            i(2);
            if (this.z != null) {
                p();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.z = ofFloat;
            ofFloat.setDuration(j2);
            this.z.setInterpolator(new LinearInterpolator());
            this.z.addUpdateListener(new a(this));
            this.z.addListener(new b(this));
            if (this.z.isRunning()) {
                return;
            }
            this.z.start();
        }
    }

    public void setAnimPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.f46512e = f2;
            h();
            postInvalidate();
        }
    }

    public void setAtLeastRotateRounds(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setOnLoadingAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.p = eVar;
        }
    }

    public void startCircularRotate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            q(750L);
        }
    }

    public void startMagnifierRotate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            r(300L);
        }
    }

    public void stopAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            p();
            clearAnimation();
            this.f46512e = 0.0f;
            this.v = 1;
            i(1);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46512e = 0.0f;
        this.f46513f = 0.0f;
        this.f46514g = 0.0f;
        this.f46515h = 0.0f;
        this.f46516i = 0.0f;
        this.f46517j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f46512e = 0.0f;
        this.f46513f = 0.0f;
        this.f46514g = 0.0f;
        this.f46515h = 0.0f;
        this.f46516i = 0.0f;
        this.f46517j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }
}
