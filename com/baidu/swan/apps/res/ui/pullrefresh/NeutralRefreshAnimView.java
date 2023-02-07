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
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gp1;
import com.baidu.tieba.nm3;
import com.baidu.tieba.ql3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NeutralRefreshAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public int c;
    public Bitmap d;
    public Canvas e;
    public Paint f;
    public Paint g;
    public PointF h;
    public int i;
    public ValueAnimator j;
    public ValueAnimator k;
    public AnimatorSet l;
    public float m;
    public float n;
    public ValueAnimator o;
    public ValueAnimator p;
    public int q;
    public int r;

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            if (i > 255) {
                return 255;
            }
            return i;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NeutralRefreshAnimView c;

        public a(NeutralRefreshAnimView neutralRefreshAnimView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = neutralRefreshAnimView;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
                this.c.e = new Canvas(this.c.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NeutralRefreshAnimView a;

        public b(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.m = NeutralRefreshAnimView.w * floatValue;
                if (NeutralRefreshAnimView.s) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + this.a.m + ",anim value=" + floatValue);
                }
                this.a.postInvalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NeutralRefreshAnimView a;

        public c(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.n = NeutralRefreshAnimView.w * floatValue;
                if (NeutralRefreshAnimView.s) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + this.a.n + ",anim value=" + floatValue);
                }
                this.a.postInvalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NeutralRefreshAnimView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

        public d(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = neutralRefreshAnimView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.n(4);
            this.a.postInvalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NeutralRefreshAnimView a;

        public e(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.q = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.s) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + this.a.q);
                }
                this.a.postInvalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NeutralRefreshAnimView a;

        public f(NeutralRefreshAnimView neutralRefreshAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {neutralRefreshAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = neutralRefreshAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.r = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.s) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + this.a.q);
                }
                this.a.postInvalidate();
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
        s = gp1.a;
        t = nm3.g(3.5f);
        u = Color.parseColor("#000000");
        int g = nm3.g(18.0f);
        v = g;
        w = g >> 1;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = new PointF();
            this.f = new Paint(1);
            this.g = new Paint(1);
            this.f.setColor(u);
            this.g.setColor(u);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            y(this.j, true);
            y(this.k, true);
            y(this.o, false);
            y(this.p, false);
            AnimatorSet animatorSet = this.l;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.l.end();
                this.l.cancel();
            }
            if (s) {
                Log.e("NeutralRefreshAnimView", "resetAnimator");
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        p();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            int i = this.i;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            s(canvas);
                        }
                    } else {
                        v(canvas);
                    }
                } else {
                    s(canvas);
                }
            } else {
                t(canvas);
            }
            canvas.restore();
        }
    }

    public void setAnimPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.a = f2;
            n(1);
            postInvalidate();
            if (s) {
                Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f2);
            }
        }
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
        p();
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.i = i;
            if (s) {
                Log.i("NeutralRefreshAnimView", "curr state:" + this.i);
            }
        }
    }

    public boolean z(int i) {
        InterceptResult invokeI;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g != null && (paint = this.f) != null) {
                paint.setColor(i);
                this.g.setColor(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.b = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.c = measuredHeight;
            this.h.set(this.b >> 1, measuredHeight >> 1);
        }
    }

    public final void y(ValueAnimator valueAnimator, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, valueAnimator, z) == null) && valueAnimator != null) {
            if (z) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x();
            clearAnimation();
            n(1);
            postInvalidate();
            if (s) {
                Log.e("NeutralRefreshAnimView", "stopAnim");
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (s) {
                Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
            }
            A();
            n(3);
            u();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (s) {
                Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
            }
            n(2);
            w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i > 0 && i2 > 0) {
                ql3.j(new a(this, i, i2), "CreateBitmapOnSizeChanged");
            }
        }
    }

    public final void s(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) && (bitmap = this.d) != null && this.e != null) {
            bitmap.eraseColor(0);
            this.g.setAlpha(77);
            Canvas canvas2 = this.e;
            PointF pointF = this.h;
            canvas2.drawCircle(pointF.x + this.m, pointF.y, t, this.g);
            this.f.setAlpha(26);
            Canvas canvas3 = this.e;
            PointF pointF2 = this.h;
            canvas3.drawCircle(pointF2.x + this.n, pointF2.y, t, this.f);
            canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
            if (s) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public final void t(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            if (s) {
                Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
            }
            Bitmap bitmap = this.d;
            if (bitmap != null && this.e != null) {
                bitmap.eraseColor(0);
                float f2 = this.a;
                if (f2 == 0.0f) {
                    this.g.setAlpha(0);
                    Canvas canvas2 = this.e;
                    PointF pointF = this.h;
                    canvas2.drawCircle(pointF.x, pointF.y, t, this.g);
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                } else if (f2 <= 0.5f) {
                    int i = (int) (f2 * 77.0f);
                    this.g.setAlpha(i);
                    Canvas canvas3 = this.e;
                    PointF pointF2 = this.h;
                    canvas3.drawCircle(pointF2.x, pointF2.y, t, this.g);
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                    if (s) {
                        Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                    }
                } else if (f2 < 1.0f) {
                    int o = o((int) (f2 * 77.0f));
                    this.g.setAlpha(o);
                    float f3 = (this.a - 0.5f) * 2.0f;
                    int o2 = o((int) (26.0f * f3));
                    this.f.setAlpha(o2);
                    Canvas canvas4 = this.e;
                    PointF pointF3 = this.h;
                    canvas4.drawCircle(pointF3.x + (w * f3), pointF3.y, t, this.g);
                    Canvas canvas5 = this.e;
                    PointF pointF4 = this.h;
                    canvas5.drawCircle(pointF4.x - (w * f3), pointF4.y, t, this.f);
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                    if (s) {
                        Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.a);
                        Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + o);
                        Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + o2);
                        Log.e("NeutralRefreshAnimView", "second level,fraction=" + f3);
                        Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (((float) w) * f3));
                    }
                } else if (f2 == 1.0f) {
                    this.f.setAlpha(26);
                    this.g.setAlpha(77);
                    Canvas canvas6 = this.e;
                    PointF pointF5 = this.h;
                    canvas6.drawCircle(pointF5.x + w, pointF5.y, t, this.g);
                    Canvas canvas7 = this.e;
                    PointF pointF6 = this.h;
                    canvas7.drawCircle(pointF6.x - w, pointF6.y, t, this.f);
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                    if (s) {
                        Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.a);
                    }
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(26, 0);
            this.o = ofInt;
            ofInt.setDuration(300L);
            this.o.addUpdateListener(new e(this));
            if (!this.o.isRunning()) {
                this.o.start();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(77, 0);
            this.p = ofInt2;
            ofInt2.setDuration(300L);
            this.p.addUpdateListener(new f(this));
            if (!this.p.isRunning()) {
                this.p.start();
            }
        }
    }

    public final void v(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            if (s) {
                Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
            }
            Bitmap bitmap = this.d;
            if (bitmap != null && this.e != null) {
                bitmap.eraseColor(0);
                this.q = o(this.q);
                int o = o(this.r);
                this.r = o;
                this.g.setAlpha(o);
                this.f.setAlpha(this.q);
                Canvas canvas2 = this.e;
                PointF pointF = this.h;
                canvas2.drawCircle(pointF.x + this.m, pointF.y, t, this.g);
                this.f.setAlpha(this.q);
                Canvas canvas3 = this.e;
                PointF pointF2 = this.h;
                canvas3.drawCircle(pointF2.x + this.n, pointF2.y, t, this.f);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                if (s) {
                    Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.q);
                    Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.m);
                    Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.n);
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, -1.0f);
            this.k = ofFloat;
            ofFloat.setDuration(480L);
            this.k.setRepeatMode(2);
            this.k.setRepeatCount(-1);
            this.k.setInterpolator(new AccelerateDecelerateInterpolator());
            this.k.addUpdateListener(new b(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
            this.j = ofFloat2;
            ofFloat2.setDuration(480L);
            this.j.setRepeatMode(2);
            this.j.setRepeatCount(-1);
            this.j.setInterpolator(new AccelerateDecelerateInterpolator());
            this.j.addUpdateListener(new c(this));
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            animatorSet.playTogether(this.j, this.k);
            this.l.setDuration(480L);
            this.l.addListener(new d(this));
            if (!this.l.isRunning()) {
                this.l.start();
            }
        }
    }
}
