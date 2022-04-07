package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ClipBoxView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static int G = 0;
    public static int H = 1;
    public static final int I = 1;
    public static final int J = 20;
    public static final int K = 4;
    public static final int L = -1;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 4;
    public static final int Q = 5;
    public static final int R = 6;
    public static final int S = 7;
    public static final int T = 8;
    public static final float U = 50.0f;
    public static final float V = 50.0f;
    public static final float W = 1.01f;
    public static final float a0 = 0.99f;
    public static ClipBoxView b0;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public boolean D;
    public int E;
    public boolean F;
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public RectF e;
    public RectF f;
    public float g;
    public float h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public ValueAnimator o;
    public float p;
    public float q;
    public float r;
    public float s;
    public boolean t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClipBoxView a;

        public a(ClipBoxView clipBoxView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clipBoxView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clipBoxView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.n = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
                this.a.invalidate();
                this.a.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(953039374, "Lcom/baidu/sapi2/views/ClipBoxView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(953039374, "Lcom/baidu/sapi2/views/ClipBoxView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipBoxView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b0 = null;
        }
    }

    private boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, motionEvent)) == null) {
            if (a(motionEvent)) {
                return true;
            }
            int i = this.l;
            if (i == 1) {
                float x = motionEvent.getX() - this.e.left;
                float y = motionEvent.getY();
                RectF rectF = this.e;
                float f = rectF.top;
                float f2 = (x + (y - f)) / 2.0f;
                b(rectF.left + f2, f + f2, rectF.right, rectF.bottom);
            } else if (i == 2) {
                float x2 = this.e.right - motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF2 = this.e;
                float f3 = rectF2.top;
                float f4 = (x2 + (y2 - f3)) / 2.0f;
                b(rectF2.left, f3 + f4, rectF2.right - f4, rectF2.bottom);
            } else if (i == 3) {
                float x3 = motionEvent.getX();
                RectF rectF3 = this.e;
                float y3 = ((x3 - rectF3.left) + (rectF3.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF4 = this.e;
                b(rectF4.left + y3, rectF4.top, rectF4.right, rectF4.bottom - y3);
            } else if (i != 4) {
                return false;
            } else {
                float x4 = ((this.e.right - motionEvent.getX()) + (this.e.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF5 = this.e;
                b(rectF5.left, rectF5.top, rectF5.right - x4, rectF5.bottom - x4);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(11)
    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            setLayerType(1, null);
            this.a = new Paint();
            this.b = new Paint();
            this.a.setColor(-1);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
            this.a.setAntiAlias(true);
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.b.setAntiAlias(true);
            this.c = SapiUtils.dip2px(getContext(), 20.0f);
            this.d = SapiUtils.dip2px(getContext(), 4.0f);
            this.i = SapiUtils.dip2px(getContext(), this.i);
            this.k = SapiUtils.dip2px(getContext(), this.k);
            this.m = SapiUtils.dip2px(getContext(), this.m);
            this.e = new RectF();
            this.f = new RectF();
            this.E = H;
            this.F = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.o = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.o.addUpdateListener(new a(this));
        }
    }

    public static ClipBoxView getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            ClipBoxView clipBoxView = b0;
            if (clipBoxView != null) {
                return clipBoxView;
            }
            return null;
        }
        return (ClipBoxView) invokeV.objValue;
    }

    public Rect getmFrameRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Rect rect = new Rect();
            RectF rectF = this.e;
            rect.left = (int) rectF.left;
            rect.right = (int) rectF.right;
            rect.top = (int) rectF.top;
            rect.bottom = (int) rectF.bottom;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int argb = Color.argb(180, 0, 0, 0);
            this.a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
            canvas.drawColor(argb);
            b(canvas);
            if (this.n == 1.0f) {
                this.t = false;
                this.D = false;
                this.n = 0.0f;
            }
            canvas.drawRect(this.e, this.b);
            if (this.D) {
                a(canvas);
            }
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            int i5 = this.i;
            int i6 = i - (i5 * 2);
            int i7 = (i2 - i6) / 2;
            this.j = i7;
            RectF rectF = this.e;
            float f = i5;
            rectF.left = f;
            float f2 = i7;
            rectF.top = f2;
            float f3 = i6;
            rectF.right = f + f3;
            rectF.bottom = f2 + f3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.E == G) {
                            return b(motionEvent);
                        }
                        return c(motionEvent);
                    }
                }
                int i = this.l;
                if (i >= 1 && i <= 4 && this.F) {
                    a();
                } else {
                    this.D = false;
                    invalidate();
                }
                this.l = -1;
                return false;
            }
            this.D = true;
            this.f.set(motionEvent.getX() - this.c, motionEvent.getY() - this.c, motionEvent.getX() + this.c, motionEvent.getY() + this.c);
            RectF rectF = this.f;
            RectF rectF2 = this.e;
            if (rectF.contains(rectF2.left, rectF2.top)) {
                this.l = 1;
                return true;
            }
            RectF rectF3 = this.f;
            RectF rectF4 = this.e;
            if (rectF3.contains(rectF4.right, rectF4.top)) {
                this.l = 2;
                return true;
            }
            RectF rectF5 = this.f;
            RectF rectF6 = this.e;
            if (rectF5.contains(rectF6.left, rectF6.bottom)) {
                this.l = 3;
                return true;
            }
            RectF rectF7 = this.f;
            RectF rectF8 = this.e;
            if (rectF7.contains(rectF8.right, rectF8.bottom)) {
                this.l = 4;
                return true;
            }
            RectF rectF9 = this.f;
            RectF rectF10 = this.e;
            float f = rectF10.left;
            float f2 = rectF10.top;
            if (rectF9.intersect(f, f2, rectF10.right, f2)) {
                this.l = 5;
                return true;
            }
            RectF rectF11 = this.f;
            RectF rectF12 = this.e;
            float f3 = rectF12.left;
            if (rectF11.intersect(f3, rectF12.top, f3, rectF12.bottom)) {
                this.l = 6;
                return true;
            }
            RectF rectF13 = this.f;
            RectF rectF14 = this.e;
            float f4 = rectF14.right;
            if (rectF13.intersect(f4, rectF14.top, f4, rectF14.bottom)) {
                this.l = 7;
                return true;
            }
            RectF rectF15 = this.f;
            RectF rectF16 = this.e;
            float f5 = rectF16.left;
            float f6 = rectF16.bottom;
            if (rectF15.intersect(f5, f6, rectF16.right, f6)) {
                this.l = 8;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, motionEvent)) == null) {
            switch (this.l) {
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    RectF rectF = this.e;
                    b(x, y, rectF.right, rectF.bottom);
                    return true;
                case 2:
                    b(this.e.left, motionEvent.getY(), motionEvent.getX(), this.e.bottom);
                    return true;
                case 3:
                    float x2 = motionEvent.getX();
                    RectF rectF2 = this.e;
                    b(x2, rectF2.top, rectF2.right, motionEvent.getY());
                    return true;
                case 4:
                    RectF rectF3 = this.e;
                    b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                    return true;
                case 5:
                    float f = this.e.left;
                    float y2 = motionEvent.getY();
                    RectF rectF4 = this.e;
                    b(f, y2, rectF4.right, rectF4.bottom);
                    return true;
                case 6:
                    float x3 = motionEvent.getX();
                    RectF rectF5 = this.e;
                    b(x3, rectF5.top, rectF5.right, rectF5.bottom);
                    return true;
                case 7:
                    RectF rectF6 = this.e;
                    b(rectF6.left, rectF6.top, motionEvent.getX(), this.e.bottom);
                    return true;
                case 8:
                    RectF rectF7 = this.e;
                    b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                    return true;
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipBoxView(Context context, AttributeSet attributeSet, int i) {
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
        this.i = 22;
        this.k = 2;
        this.l = -1;
        this.m = 20;
        this.n = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.D = false;
        if (b0 == null) {
            b0 = this;
        }
        d();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            RectF rectF = this.e;
            float f = rectF.left;
            float f2 = rectF.top;
            float f3 = rectF.right;
            float f4 = rectF.bottom;
            float f5 = (f4 - f2) / 3.0f;
            float f6 = f2 + f5;
            canvas.drawLine(f, f6, f3, f6, this.a);
            float f7 = f2 + (f5 * 2.0f);
            canvas.drawLine(f, f7, f3, f7, this.a);
            float f8 = (f3 - f) / 3.0f;
            float f9 = f + f8;
            canvas.drawLine(f9, f2, f9, f4, this.a);
            float f10 = f + (f8 * 2.0f);
            canvas.drawLine(f10, f2, f10, f4, this.a);
        }
    }

    private void a(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            ZoomImageView zoomImageView = ZoomImageView.getInstance();
            if (zoomImageView != null) {
                RectF matrixRectF = zoomImageView.getMatrixRectF();
                f = Math.max(Math.max(this.m, f), matrixRectF.left);
                f2 = Math.max(Math.max(this.m, f2), matrixRectF.top);
                f3 = Math.min(Math.min(getWidth() - this.m, f3), matrixRectF.right);
                f4 = Math.min(Math.min(getHeight() - this.m, f4), matrixRectF.bottom);
            }
            this.q = this.u - f2;
            this.s = f4 - this.v;
            this.p = this.w - f;
            this.r = f3 - this.x;
            this.e.set(f, f2, f3, f4);
        }
    }

    private void b(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f4 - f2 < 50.0f) {
                RectF rectF = this.e;
                float f5 = rectF.top;
                f4 = rectF.bottom;
                f2 = f5;
            }
            if (f3 - f < 50.0f) {
                RectF rectF2 = this.e;
                float f6 = rectF2.left;
                f3 = rectF2.right;
                f = f6;
            }
            a(f, f2, f3, f4);
            invalidate();
        }
    }

    private void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, canvas) == null) {
            this.a.setStrokeWidth(this.d);
            RectF rectF = this.e;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.drawLine(f - this.k, f2, f + this.c, f2, this.a);
            RectF rectF2 = this.e;
            float f3 = rectF2.left;
            float f4 = rectF2.top;
            canvas.drawLine(f3, f4, f3, f4 + this.c, this.a);
            RectF rectF3 = this.e;
            float f5 = rectF3.right;
            float f6 = rectF3.top;
            canvas.drawLine(f5 + this.k, f6, f5 - this.c, f6, this.a);
            RectF rectF4 = this.e;
            float f7 = rectF4.right;
            float f8 = rectF4.top;
            canvas.drawLine(f7, f8, f7, f8 + this.c, this.a);
            RectF rectF5 = this.e;
            float f9 = rectF5.left;
            float f10 = rectF5.bottom;
            canvas.drawLine(f9 - this.k, f10, f9 + this.c, f10, this.a);
            RectF rectF6 = this.e;
            float f11 = rectF6.left;
            float f12 = rectF6.bottom;
            canvas.drawLine(f11, f12, f11, f12 - this.c, this.a);
            RectF rectF7 = this.e;
            float f13 = rectF7.right;
            float f14 = rectF7.bottom;
            canvas.drawLine(f13 + this.k, f14, f13 - this.c, f14, this.a);
            RectF rectF8 = this.e;
            float f15 = rectF8.right;
            float f16 = rectF8.bottom;
            canvas.drawLine(f15, f16, f15, f16 - this.c, this.a);
        }
    }

    private void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, canvas) == null) {
            if (this.t) {
                RectF rectF = this.e;
                float f = this.w;
                float f2 = this.n;
                rectF.left = f - (this.p * f2);
                rectF.top = this.u - (this.q * f2);
                rectF.right = this.x + (this.r * f2);
                rectF.bottom = this.v + (f2 * this.s);
                canvas.drawRect(rectF, this.a);
                return;
            }
            canvas.drawRect(this.e, this.a);
        }
    }

    private void a(float f, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            ZoomImageView zoomImageView = ZoomImageView.getInstance();
            if (zoomImageView != null) {
                RectF matrixRectF = zoomImageView.getMatrixRectF();
                f = Math.max(Math.max(this.m, f), matrixRectF.left);
                f2 = Math.max(Math.max(this.m, f2), matrixRectF.top);
                f3 = Math.min(Math.min(getWidth() - this.m, f3), matrixRectF.right);
                f4 = Math.min(Math.min(getHeight() - this.m, f4), matrixRectF.bottom);
            }
            float f6 = f3 - f;
            float f7 = f4 - f2;
            float f8 = f6 / f7;
            if (f8 > f5) {
                while (f8 / f5 > 1.01f) {
                    f3 -= 1.0f;
                    f += 1.0f;
                    f8 = (f3 - f) / f7;
                }
            } else {
                while (f8 / f5 < 0.99f) {
                    f4 -= 1.0f;
                    f2 += 1.0f;
                    f8 = f6 / (f4 - f2);
                }
            }
            this.q = this.u - f2;
            this.s = f4 - this.v;
            this.p = this.w - f;
            this.r = f3 - this.x;
            this.e.set(f, f2, f3, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            ZoomImageView zoomImageView = ZoomImageView.getInstance();
            if (!this.t || zoomImageView == null || zoomImageView.getScale() > 12.0f) {
                return;
            }
            float f = ((this.y - 1.0f) / 20.0f) + 1.0f;
            zoomImageView.e.postTranslate(this.B / 20.0f, this.C / 20.0f);
            Matrix matrix = zoomImageView.e;
            RectF rectF = this.e;
            matrix.postScale(f, f, (rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f);
            RectF rectF2 = this.e;
            zoomImageView.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
            zoomImageView.setImageMatrix(zoomImageView.e);
        }
    }

    @TargetApi(11)
    private void a() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int width = getWidth() - (this.i * 2);
            RectF rectF = this.e;
            float f = rectF.right;
            float f2 = rectF.left;
            float f3 = f - f2;
            float f4 = width;
            if (f3 < f4) {
                float f5 = rectF.top;
                this.u = f5;
                float f6 = rectF.bottom;
                this.v = f6;
                this.w = f2;
                this.x = f;
                float f7 = (f - f2) / (f6 - f5);
                this.z = f4 / f3;
                RectF rectF2 = this.e;
                float height = (getHeight() - (this.m * 2)) / (rectF2.bottom - rectF2.top);
                this.A = height;
                float min = Math.min(this.z, height);
                this.y = min;
                float f8 = min - 1.0f;
                float f9 = f8 <= 1.0f ? f8 : 1.0f;
                RectF rectF3 = this.e;
                this.B = ((getWidth() / 2) - ((rectF3.left + rectF3.right) / 2.0f)) * f9;
                RectF rectF4 = this.e;
                float f10 = rectF4.top;
                float f11 = rectF4.bottom;
                this.C = ((getHeight() / 2) - ((f10 + f11) / 2.0f)) * f9;
                float f12 = rectF4.left;
                float f13 = this.y;
                float f14 = f12 / f13;
                rectF4.left = f14;
                float f15 = f10 / f13;
                rectF4.top = f15;
                float f16 = rectF4.right * f13;
                rectF4.right = f16;
                float f17 = f11 * f13;
                rectF4.bottom = f17;
                if (this.E == G) {
                    a(f14, f15, f16, f17, f7);
                } else {
                    a(this.i, this.j, i + width, i2 + width);
                }
                this.o.setDuration(500L).start();
                this.t = true;
                return;
            }
            this.D = false;
            invalidate();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, motionEvent)) == null) {
            int width = getWidth() - (this.i * 2);
            RectF rectF = this.e;
            float f = width;
            if (rectF.right - rectF.left < f || rectF.bottom - rectF.top < f) {
                return false;
            }
            return motionEvent.getX() < ((float) this.i) || motionEvent.getX() > ((float) (this.i + width)) || motionEvent.getY() < ((float) this.j) || motionEvent.getY() > ((float) (this.j + width));
        }
        return invokeL.booleanValue;
    }
}
