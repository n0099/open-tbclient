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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jd3;
import com.repackage.zi2;
/* loaded from: classes2.dex */
public class RefreshingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final double C;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public PointF i;
    public Paint j;
    public Paint k;
    public e l;
    public RectF m;
    public PointF n;
    public PointF o;
    public float p;
    public int q;
    public int r;
    public ValueAnimator s;
    public float t;
    public float u;
    public ValueAnimator v;
    public Bitmap w;
    public Canvas x;
    public Camera y;
    public Matrix z;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefreshingAnimView a;

        public a(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refreshingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefreshingAnimView a;

        public b(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refreshingAnimView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.q(750L);
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

    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefreshingAnimView a;

        public c(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refreshingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RefreshingAnimView a;

        public d(RefreshingAnimView refreshingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {refreshingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refreshingAnimView;
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
                RefreshingAnimView.e(this.a);
                if (this.a.r <= this.a.q || this.a.l == null) {
                    return;
                }
                this.a.l.a(true);
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

    /* loaded from: classes2.dex */
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
        C = Math.sqrt(2.0d);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }

    public static /* synthetic */ int e(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.r;
        refreshingAnimView.r = i + 1;
        return i;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float f = this.a;
            this.b = f;
            if (f < 0.5f) {
                this.c = 0.0f;
                this.e = 0.0f;
                return;
            }
            this.e = ((f - 0.5f) / 0.5f) * this.f;
            if (f < 0.625f) {
                this.c = 0.0f;
                return;
            }
            float f2 = (f - 0.625f) / 0.375f;
            this.c = f2;
            PointF pointF = this.n;
            float f3 = pointF.x;
            float f4 = this.p;
            double d2 = C;
            float f5 = pointF.y + ((float) ((f4 * f2) / d2));
            this.o.set(f3 + ((float) ((f4 * f2) / d2)), f5);
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.B = i;
        }
    }

    public final void j(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (bitmap = this.w) == null || this.x == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.j.setStyle(Paint.Style.FILL);
        int abs = (int) ((((1.0d - (Math.abs(this.t - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
        if (this.A) {
            abs = (int) ((((1.0d - (Math.abs(this.t - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
        }
        this.j.setAlpha(abs);
        Canvas canvas2 = this.x;
        PointF pointF = this.i;
        canvas2.drawCircle(pointF.x, pointF.y, this.g, this.j);
        this.z.reset();
        this.y.save();
        this.y.setLocation(0.0f, 0.0f, -100.0f);
        this.y.rotateY((this.t * 360.0f) + 90.0f);
        this.y.getMatrix(this.z);
        this.y.restore();
        Matrix matrix = this.z;
        PointF pointF2 = this.i;
        matrix.preTranslate(-pointF2.x, -pointF2.y);
        Matrix matrix2 = this.z;
        PointF pointF3 = this.i;
        matrix2.postTranslate(pointF3.x, pointF3.y);
        canvas.drawBitmap(this.w, this.z, null);
    }

    public final void k(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || (bitmap = this.w) == null || this.x == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.j.setStyle(Paint.Style.FILL);
        if (this.A != zi2.M().a()) {
            this.j.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0603d3));
            this.A = zi2.M().a();
        }
        this.j.setAlpha(76);
        RectF rectF = this.m;
        PointF pointF = this.i;
        float f = pointF.x;
        float f2 = this.d;
        float f3 = pointF.y;
        rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
        this.x.drawArc(this.m, -90.0f, this.b * (-360.0f), true, this.j);
        Canvas canvas2 = this.x;
        PointF pointF2 = this.i;
        canvas2.drawCircle(pointF2.x, pointF2.y, this.e, this.k);
        if (this.c > 0.0f) {
            Canvas canvas3 = this.x;
            PointF pointF3 = this.o;
            canvas3.drawCircle(pointF3.x, pointF3.y, 0.75f, this.j);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setStrokeWidth(jd3.f(getContext(), 1.5f));
            Canvas canvas4 = this.x;
            PointF pointF4 = this.n;
            float f4 = pointF4.x;
            float f5 = pointF4.y;
            PointF pointF5 = this.o;
            canvas4.drawLine(f4, f5, pointF5.x, pointF5.y, this.j);
        }
        canvas.drawBitmap(this.w, 0.0f, 0.0f, (Paint) null);
    }

    public final void l(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || (bitmap = this.w) == null || this.x == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setAlpha((int) (((this.u * 0.3d) + 0.3d) * 255.0d));
        float f = this.n.x + ((float) (this.p / C));
        Canvas canvas2 = this.x;
        PointF pointF = this.i;
        canvas2.drawCircle(pointF.x, pointF.y, this.d, this.j);
        Canvas canvas3 = this.x;
        PointF pointF2 = this.i;
        canvas3.drawCircle(pointF2.x, pointF2.y, this.f, this.k);
        this.x.drawCircle(f, f, 0.75f, this.j);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(jd3.f(getContext(), 1.5f));
        Canvas canvas4 = this.x;
        PointF pointF3 = this.n;
        canvas4.drawLine(pointF3.x, pointF3.y, f, f, this.j);
        this.z.reset();
        this.y.save();
        this.y.setLocation(0.0f, 0.0f, -100.0f);
        this.y.rotateY(this.u * 90.0f);
        this.y.getMatrix(this.z);
        this.y.restore();
        Matrix matrix = this.z;
        PointF pointF4 = this.i;
        matrix.preTranslate(-pointF4.x, -pointF4.y);
        Matrix matrix2 = this.z;
        PointF pointF5 = this.i;
        matrix2.postTranslate(pointF5.x, pointF5.y);
        canvas.drawBitmap(this.w, this.z, null);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.A = zi2.M().a();
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0603d3));
            Paint paint2 = new Paint();
            this.k = paint2;
            paint2.setAntiAlias(true);
            this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.y = new Camera();
            this.z = new Matrix();
            i(1);
        }
    }

    public final void n(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (f < 0.2f) {
                this.t = (f / 0.2f) * 0.5f;
            } else {
                this.t = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
            }
            postInvalidate();
        }
    }

    public final void o(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.u = f;
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            p();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            int i = this.B;
            if (i == 1) {
                k(canvas);
            } else if (i == 2) {
                l(canvas);
            } else if (i == 3) {
                j(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (getMeasuredWidth() > getHeight()) {
                this.h = getMeasuredHeight();
            } else {
                this.h = getMeasuredWidth();
            }
            this.d = jd3.f(getContext(), 8.0f);
            this.f = jd3.f(getContext(), 6.5f);
            this.p = jd3.f(getContext(), 5.0f);
            this.g = jd3.f(getContext(), 7.5f);
            float f = this.h / 2.0f;
            this.i.set(f, f);
            float f2 = f + ((float) (this.d / C));
            this.n.set(f2, f2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i <= 0 || i2 <= 0) {
                return;
            }
            this.w = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.x = new Canvas(this.w);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null) {
                valueAnimator.setRepeatCount(0);
                this.v.removeAllUpdateListeners();
                this.v.removeAllListeners();
                this.v.end();
                this.v.cancel();
            }
            ValueAnimator valueAnimator2 = this.s;
            if (valueAnimator2 != null) {
                valueAnimator2.setRepeatCount(0);
                this.s.removeAllUpdateListeners();
                this.s.removeAllListeners();
                this.s.end();
                this.s.cancel();
            }
        }
    }

    public final void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            i(3);
            if (this.s != null) {
                p();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.s = ofFloat;
            ofFloat.setDuration(j);
            this.s.setInterpolator(new LinearInterpolator());
            this.s.setRepeatCount(-1);
            this.s.setRepeatMode(1);
            this.s.addUpdateListener(new c(this));
            if (this.q > 0) {
                this.s.addListener(new d(this));
            } else {
                e eVar = this.l;
                if (eVar != null) {
                    eVar.a(true);
                }
            }
            if (this.s.isRunning()) {
                return;
            }
            this.s.start();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            s(300L);
        }
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            i(2);
            if (this.v != null) {
                p();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.v = ofFloat;
            ofFloat.setDuration(j);
            this.v.setInterpolator(new LinearInterpolator());
            this.v.addUpdateListener(new a(this));
            this.v.addListener(new b(this));
            if (this.v.isRunning()) {
                return;
            }
            this.v.start();
        }
    }

    public void setAnimPercent(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            this.a = f;
            h();
            postInvalidate();
        }
    }

    public void setAtLeastRotateRounds(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.q = i;
        }
    }

    public void setOnLoadingAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            p();
            clearAnimation();
            this.a = 0.0f;
            this.r = 1;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }
}
