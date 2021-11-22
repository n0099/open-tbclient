package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NeutralRefreshAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final boolean w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f44834e;

    /* renamed from: f  reason: collision with root package name */
    public int f44835f;

    /* renamed from: g  reason: collision with root package name */
    public int f44836g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f44837h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f44838i;
    public Paint j;
    public Paint k;
    public PointF l;
    public int m;
    public ValueAnimator n;
    public ValueAnimator o;
    public AnimatorSet p;
    public float q;
    public float r;
    public ValueAnimator s;
    public ValueAnimator t;
    public int u;
    public int v;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44841g;

        public a(NeutralRefreshAnimView neutralRefreshAnimView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44841g = neutralRefreshAnimView;
            this.f44839e = i2;
            this.f44840f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44841g.f44837h = Bitmap.createBitmap(this.f44839e, this.f44840f, Bitmap.Config.ARGB_8888);
                this.f44841g.f44838i = new Canvas(this.f44841g.f44837h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44842e;

        public b(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44842e = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f44842e.q = NeutralRefreshAnimView.A * floatValue;
                if (NeutralRefreshAnimView.w) {
                    String str = "mRightBallXPosi=" + this.f44842e.q + ",anim value=" + floatValue;
                }
                this.f44842e.postInvalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44843e;

        public c(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44843e = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f44843e.r = NeutralRefreshAnimView.A * floatValue;
                if (NeutralRefreshAnimView.w) {
                    String str = "mLeftBallXPosi=" + this.f44843e.r + ",anim value=" + floatValue;
                }
                this.f44843e.postInvalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44844e;

        public d(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44844e = neutralRefreshAnimView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f44844e.n(4);
                this.f44844e.postInvalidate();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44845e;

        public e(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44845e = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f44845e.u = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.w) {
                    String str = "Complete anim: mAlpha=" + this.f44845e.u;
                }
                this.f44845e.postInvalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NeutralRefreshAnimView f44846e;

        public f(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44846e = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f44846e.v = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.w) {
                    String str = "Complete anim: mAlpha=" + this.f44846e.u;
                }
                this.f44846e.postInvalidate();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-520603303, "Lcom/baidu/swan/apps/res/ui/pullrefresh/NeutralRefreshAnimView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-520603303, "Lcom/baidu/swan/apps/res/ui/pullrefresh/NeutralRefreshAnimView;");
                return;
            }
        }
        w = k.f6863a;
        x = n0.g(3.5f);
        y = Color.parseColor("#000000");
        int g2 = n0.g(18.0f);
        z = g2;
        A = g2 >> 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NeutralRefreshAnimView(Context context) {
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
        p();
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.m = i2;
            if (w) {
                String str = "curr state:" + this.m;
            }
        }
    }

    public final int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 255) {
                return 255;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            int i2 = this.m;
            if (i2 == 1) {
                r(canvas);
            } else if (i2 == 2) {
                q(canvas);
            } else if (i2 == 3) {
                t(canvas);
            } else if (i2 == 4) {
                q(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f44835f = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f44836g = measuredHeight;
            this.l.set(this.f44835f >> 1, measuredHeight >> 1);
        }
    }

    public void onRefreshCompleteAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z2 = w;
            stopAnim();
            n(3);
            s();
        }
    }

    public void onRefreshingAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z2 = w;
            n(2);
            u();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            q.j(new a(this, i2, i3), "CreateBitmapOnSizeChanged");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.l = new PointF();
            this.j = new Paint(1);
            this.k = new Paint(1);
            this.j.setColor(y);
            this.k.setColor(y);
        }
    }

    public final void q(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) || (bitmap = this.f44837h) == null || this.f44838i == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.k.setAlpha(77);
        Canvas canvas2 = this.f44838i;
        PointF pointF = this.l;
        canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
        this.j.setAlpha(26);
        Canvas canvas3 = this.f44838i;
        PointF pointF2 = this.l;
        canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
        canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
        boolean z2 = w;
    }

    public final void r(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            boolean z2 = w;
            Bitmap bitmap = this.f44837h;
            if (bitmap == null || this.f44838i == null) {
                return;
            }
            bitmap.eraseColor(0);
            float f2 = this.f44834e;
            if (f2 == 0.0f) {
                this.k.setAlpha(0);
                Canvas canvas2 = this.f44838i;
                PointF pointF = this.l;
                canvas2.drawCircle(pointF.x, pointF.y, x, this.k);
                canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
            } else if (f2 <= 0.5f) {
                int i2 = (int) (f2 * 77.0f);
                this.k.setAlpha(i2);
                Canvas canvas3 = this.f44838i;
                PointF pointF2 = this.l;
                canvas3.drawCircle(pointF2.x, pointF2.y, x, this.k);
                canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
                if (w) {
                    String str = "first level,alpha=" + i2;
                }
            } else if (f2 >= 1.0f) {
                if (f2 == 1.0f) {
                    this.j.setAlpha(26);
                    this.k.setAlpha(77);
                    Canvas canvas4 = this.f44838i;
                    PointF pointF3 = this.l;
                    canvas4.drawCircle(pointF3.x + A, pointF3.y, x, this.k);
                    Canvas canvas5 = this.f44838i;
                    PointF pointF4 = this.l;
                    canvas5.drawCircle(pointF4.x - A, pointF4.y, x, this.j);
                    canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
                    if (w) {
                        String str2 = "third level,mAnimPercent=" + this.f44834e;
                    }
                }
            } else {
                int o = o((int) (f2 * 77.0f));
                this.k.setAlpha(o);
                float f3 = (this.f44834e - 0.5f) * 2.0f;
                int o2 = o((int) (26.0f * f3));
                this.j.setAlpha(o2);
                Canvas canvas6 = this.f44838i;
                PointF pointF5 = this.l;
                canvas6.drawCircle(pointF5.x + (A * f3), pointF5.y, x, this.k);
                Canvas canvas7 = this.f44838i;
                PointF pointF6 = this.l;
                canvas7.drawCircle(pointF6.x - (A * f3), pointF6.y, x, this.j);
                canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
                if (w) {
                    String str3 = "second level,mAnimPercent=" + this.f44834e;
                    String str4 = "second level,rightBallAlpha=" + o;
                    String str5 = "second level,leftBallAlpha=" + o2;
                    String str6 = "second level,fraction=" + f3;
                    String str7 = "second level,HALF_MAX_DISTANCE * fraction=" + (A * f3);
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(26, 0);
            this.s = ofInt;
            ofInt.setDuration(300L);
            this.s.addUpdateListener(new e(this));
            if (!this.s.isRunning()) {
                this.s.start();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(77, 0);
            this.t = ofInt2;
            ofInt2.setDuration(300L);
            this.t.addUpdateListener(new f(this));
            if (this.t.isRunning()) {
                return;
            }
            this.t.start();
        }
    }

    public void setAnimPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.f44834e = f2;
            n(1);
            postInvalidate();
            if (w) {
                String str = "setAnimPercent, percent = " + f2;
            }
        }
    }

    public boolean setBackgroundTextStyle(int i2) {
        InterceptResult invokeI;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (this.k == null || (paint = this.j) == null) {
                return false;
            }
            paint.setColor(i2);
            this.k.setColor(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void stopAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            v();
            clearAnimation();
            n(1);
            postInvalidate();
            boolean z2 = w;
        }
    }

    public final void t(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            boolean z2 = w;
            Bitmap bitmap = this.f44837h;
            if (bitmap == null || this.f44838i == null) {
                return;
            }
            bitmap.eraseColor(0);
            this.u = o(this.u);
            int o = o(this.v);
            this.v = o;
            this.k.setAlpha(o);
            this.j.setAlpha(this.u);
            Canvas canvas2 = this.f44838i;
            PointF pointF = this.l;
            canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
            this.j.setAlpha(this.u);
            Canvas canvas3 = this.f44838i;
            PointF pointF2 = this.l;
            canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
            canvas.drawBitmap(this.f44837h, 0.0f, 0.0f, (Paint) null);
            if (w) {
                String str = "Complete:mAlpha=" + this.u;
                String str2 = "Complete:mRightBallXPosi=" + this.q;
                String str3 = "Complete:mLeftBallXPosi=" + this.r;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            v();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, -1.0f);
            this.o = ofFloat;
            ofFloat.setDuration(480L);
            this.o.setRepeatMode(2);
            this.o.setRepeatCount(-1);
            this.o.setInterpolator(new AccelerateDecelerateInterpolator());
            this.o.addUpdateListener(new b(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
            this.n = ofFloat2;
            ofFloat2.setDuration(480L);
            this.n.setRepeatMode(2);
            this.n.setRepeatCount(-1);
            this.n.setInterpolator(new AccelerateDecelerateInterpolator());
            this.n.addUpdateListener(new c(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.p = animatorSet;
            animatorSet.playTogether(this.n, this.o);
            this.p.setDuration(480L);
            this.p.addListener(new d(this));
            if (this.p.isRunning()) {
                return;
            }
            this.p.start();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            w(this.n, true);
            w(this.o, true);
            w(this.s, false);
            w(this.t, false);
            AnimatorSet animatorSet = this.p;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.p.end();
                this.p.cancel();
            }
            boolean z2 = w;
        }
    }

    public final void w(ValueAnimator valueAnimator, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, valueAnimator, z2) == null) || valueAnimator == null) {
            return;
        }
        if (z2) {
            valueAnimator.setRepeatCount(0);
        }
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.removeAllListeners();
        valueAnimator.end();
        valueAnimator.cancel();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
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
        p();
    }
}
