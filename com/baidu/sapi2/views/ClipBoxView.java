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
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public Paint f10034a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f10035b;

    /* renamed from: c  reason: collision with root package name */
    public int f10036c;

    /* renamed from: d  reason: collision with root package name */
    public int f10037d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f10038e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f10039f;

    /* renamed from: g  reason: collision with root package name */
    public float f10040g;

    /* renamed from: h  reason: collision with root package name */
    public float f10041h;

    /* renamed from: i  reason: collision with root package name */
    public int f10042i;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ClipBoxView f10043a;

        public a(ClipBoxView clipBoxView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clipBoxView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10043a = clipBoxView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f10043a.n = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
                this.f10043a.invalidate();
                this.f10043a.c();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = this.l;
            if (i2 == 1) {
                float x = motionEvent.getX() - this.f10038e.left;
                float y = motionEvent.getY();
                RectF rectF = this.f10038e;
                float f2 = rectF.top;
                float f3 = (x + (y - f2)) / 2.0f;
                b(rectF.left + f3, f2 + f3, rectF.right, rectF.bottom);
            } else if (i2 == 2) {
                float x2 = this.f10038e.right - motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF2 = this.f10038e;
                float f4 = rectF2.top;
                float f5 = (x2 + (y2 - f4)) / 2.0f;
                b(rectF2.left, f4 + f5, rectF2.right - f5, rectF2.bottom);
            } else if (i2 == 3) {
                float x3 = motionEvent.getX();
                RectF rectF3 = this.f10038e;
                float y3 = ((x3 - rectF3.left) + (rectF3.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF4 = this.f10038e;
                b(rectF4.left + y3, rectF4.top, rectF4.right, rectF4.bottom - y3);
            } else if (i2 != 4) {
                return false;
            } else {
                float x4 = ((this.f10038e.right - motionEvent.getX()) + (this.f10038e.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF5 = this.f10038e;
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
            this.f10034a = new Paint();
            this.f10035b = new Paint();
            this.f10034a.setColor(-1);
            this.f10034a.setStyle(Paint.Style.STROKE);
            this.f10034a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
            this.f10034a.setAntiAlias(true);
            this.f10035b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.f10035b.setAntiAlias(true);
            this.f10036c = SapiUtils.dip2px(getContext(), 20.0f);
            this.f10037d = SapiUtils.dip2px(getContext(), 4.0f);
            this.f10042i = SapiUtils.dip2px(getContext(), this.f10042i);
            this.k = SapiUtils.dip2px(getContext(), this.k);
            this.m = SapiUtils.dip2px(getContext(), this.m);
            this.f10038e = new RectF();
            this.f10039f = new RectF();
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
            RectF rectF = this.f10038e;
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
            this.f10034a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
            canvas.drawColor(argb);
            b(canvas);
            if (this.n == 1.0f) {
                this.t = false;
                this.D = false;
                this.n = 0.0f;
            }
            canvas.drawRect(this.f10038e, this.f10035b);
            if (this.D) {
                a(canvas);
            }
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            int i6 = this.f10042i;
            int i7 = i2 - (i6 * 2);
            int i8 = (i3 - i7) / 2;
            this.j = i8;
            RectF rectF = this.f10038e;
            float f2 = i6;
            rectF.left = f2;
            float f3 = i8;
            rectF.top = f3;
            float f4 = i7;
            rectF.right = f2 + f4;
            rectF.bottom = f3 + f4;
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
                int i2 = this.l;
                if (i2 >= 1 && i2 <= 4 && this.F) {
                    a();
                } else {
                    this.D = false;
                    invalidate();
                }
                this.l = -1;
                return false;
            }
            this.D = true;
            this.f10039f.set(motionEvent.getX() - this.f10036c, motionEvent.getY() - this.f10036c, motionEvent.getX() + this.f10036c, motionEvent.getY() + this.f10036c);
            RectF rectF = this.f10039f;
            RectF rectF2 = this.f10038e;
            if (rectF.contains(rectF2.left, rectF2.top)) {
                this.l = 1;
                return true;
            }
            RectF rectF3 = this.f10039f;
            RectF rectF4 = this.f10038e;
            if (rectF3.contains(rectF4.right, rectF4.top)) {
                this.l = 2;
                return true;
            }
            RectF rectF5 = this.f10039f;
            RectF rectF6 = this.f10038e;
            if (rectF5.contains(rectF6.left, rectF6.bottom)) {
                this.l = 3;
                return true;
            }
            RectF rectF7 = this.f10039f;
            RectF rectF8 = this.f10038e;
            if (rectF7.contains(rectF8.right, rectF8.bottom)) {
                this.l = 4;
                return true;
            }
            RectF rectF9 = this.f10039f;
            RectF rectF10 = this.f10038e;
            float f2 = rectF10.left;
            float f3 = rectF10.top;
            if (rectF9.intersect(f2, f3, rectF10.right, f3)) {
                this.l = 5;
                return true;
            }
            RectF rectF11 = this.f10039f;
            RectF rectF12 = this.f10038e;
            float f4 = rectF12.left;
            if (rectF11.intersect(f4, rectF12.top, f4, rectF12.bottom)) {
                this.l = 6;
                return true;
            }
            RectF rectF13 = this.f10039f;
            RectF rectF14 = this.f10038e;
            float f5 = rectF14.right;
            if (rectF13.intersect(f5, rectF14.top, f5, rectF14.bottom)) {
                this.l = 7;
                return true;
            }
            RectF rectF15 = this.f10039f;
            RectF rectF16 = this.f10038e;
            float f6 = rectF16.left;
            float f7 = rectF16.bottom;
            if (rectF15.intersect(f6, f7, rectF16.right, f7)) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    RectF rectF = this.f10038e;
                    b(x, y, rectF.right, rectF.bottom);
                    return true;
                case 2:
                    b(this.f10038e.left, motionEvent.getY(), motionEvent.getX(), this.f10038e.bottom);
                    return true;
                case 3:
                    float x2 = motionEvent.getX();
                    RectF rectF2 = this.f10038e;
                    b(x2, rectF2.top, rectF2.right, motionEvent.getY());
                    return true;
                case 4:
                    RectF rectF3 = this.f10038e;
                    b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                    return true;
                case 5:
                    float f2 = this.f10038e.left;
                    float y2 = motionEvent.getY();
                    RectF rectF4 = this.f10038e;
                    b(f2, y2, rectF4.right, rectF4.bottom);
                    return true;
                case 6:
                    float x3 = motionEvent.getX();
                    RectF rectF5 = this.f10038e;
                    b(x3, rectF5.top, rectF5.right, rectF5.bottom);
                    return true;
                case 7:
                    RectF rectF6 = this.f10038e;
                    b(rectF6.left, rectF6.top, motionEvent.getX(), this.f10038e.bottom);
                    return true;
                case 8:
                    RectF rectF7 = this.f10038e;
                    b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                    return true;
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipBoxView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f10042i = 22;
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
            RectF rectF = this.f10038e;
            float f2 = rectF.left;
            float f3 = rectF.top;
            float f4 = rectF.right;
            float f5 = rectF.bottom;
            float f6 = (f5 - f3) / 3.0f;
            float f7 = f3 + f6;
            canvas.drawLine(f2, f7, f4, f7, this.f10034a);
            float f8 = f3 + (f6 * 2.0f);
            canvas.drawLine(f2, f8, f4, f8, this.f10034a);
            float f9 = (f4 - f2) / 3.0f;
            float f10 = f2 + f9;
            canvas.drawLine(f10, f3, f10, f5, this.f10034a);
            float f11 = f2 + (f9 * 2.0f);
            canvas.drawLine(f11, f3, f11, f5, this.f10034a);
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            ZoomImageView zoomImageView = ZoomImageView.getInstance();
            if (zoomImageView != null) {
                RectF matrixRectF = zoomImageView.getMatrixRectF();
                f2 = Math.max(Math.max(this.m, f2), matrixRectF.left);
                f3 = Math.max(Math.max(this.m, f3), matrixRectF.top);
                f4 = Math.min(Math.min(getWidth() - this.m, f4), matrixRectF.right);
                f5 = Math.min(Math.min(getHeight() - this.m, f5), matrixRectF.bottom);
            }
            this.q = this.u - f3;
            this.s = f5 - this.v;
            this.p = this.w - f2;
            this.r = f4 - this.x;
            this.f10038e.set(f2, f3, f4, f5);
        }
    }

    private void b(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (f5 - f3 < 50.0f) {
                RectF rectF = this.f10038e;
                float f6 = rectF.top;
                f5 = rectF.bottom;
                f3 = f6;
            }
            if (f4 - f2 < 50.0f) {
                RectF rectF2 = this.f10038e;
                float f7 = rectF2.left;
                f4 = rectF2.right;
                f2 = f7;
            }
            a(f2, f3, f4, f5);
            invalidate();
        }
    }

    private void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, canvas) == null) {
            this.f10034a.setStrokeWidth(this.f10037d);
            RectF rectF = this.f10038e;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.drawLine(f2 - this.k, f3, f2 + this.f10036c, f3, this.f10034a);
            RectF rectF2 = this.f10038e;
            float f4 = rectF2.left;
            float f5 = rectF2.top;
            canvas.drawLine(f4, f5, f4, f5 + this.f10036c, this.f10034a);
            RectF rectF3 = this.f10038e;
            float f6 = rectF3.right;
            float f7 = rectF3.top;
            canvas.drawLine(f6 + this.k, f7, f6 - this.f10036c, f7, this.f10034a);
            RectF rectF4 = this.f10038e;
            float f8 = rectF4.right;
            float f9 = rectF4.top;
            canvas.drawLine(f8, f9, f8, f9 + this.f10036c, this.f10034a);
            RectF rectF5 = this.f10038e;
            float f10 = rectF5.left;
            float f11 = rectF5.bottom;
            canvas.drawLine(f10 - this.k, f11, f10 + this.f10036c, f11, this.f10034a);
            RectF rectF6 = this.f10038e;
            float f12 = rectF6.left;
            float f13 = rectF6.bottom;
            canvas.drawLine(f12, f13, f12, f13 - this.f10036c, this.f10034a);
            RectF rectF7 = this.f10038e;
            float f14 = rectF7.right;
            float f15 = rectF7.bottom;
            canvas.drawLine(f14 + this.k, f15, f14 - this.f10036c, f15, this.f10034a);
            RectF rectF8 = this.f10038e;
            float f16 = rectF8.right;
            float f17 = rectF8.bottom;
            canvas.drawLine(f16, f17, f16, f17 - this.f10036c, this.f10034a);
        }
    }

    private void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, canvas) == null) {
            if (this.t) {
                RectF rectF = this.f10038e;
                float f2 = this.w;
                float f3 = this.n;
                rectF.left = f2 - (this.p * f3);
                rectF.top = this.u - (this.q * f3);
                rectF.right = this.x + (this.r * f3);
                rectF.bottom = this.v + (f3 * this.s);
                canvas.drawRect(rectF, this.f10034a);
                return;
            }
            canvas.drawRect(this.f10038e, this.f10034a);
        }
    }

    private void a(float f2, float f3, float f4, float f5, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            ZoomImageView zoomImageView = ZoomImageView.getInstance();
            if (zoomImageView != null) {
                RectF matrixRectF = zoomImageView.getMatrixRectF();
                f2 = Math.max(Math.max(this.m, f2), matrixRectF.left);
                f3 = Math.max(Math.max(this.m, f3), matrixRectF.top);
                f4 = Math.min(Math.min(getWidth() - this.m, f4), matrixRectF.right);
                f5 = Math.min(Math.min(getHeight() - this.m, f5), matrixRectF.bottom);
            }
            float f7 = f4 - f2;
            float f8 = f5 - f3;
            float f9 = f7 / f8;
            if (f9 > f6) {
                while (f9 / f6 > 1.01f) {
                    f4 -= 1.0f;
                    f2 += 1.0f;
                    f9 = (f4 - f2) / f8;
                }
            } else {
                while (f9 / f6 < 0.99f) {
                    f5 -= 1.0f;
                    f3 += 1.0f;
                    f9 = f7 / (f5 - f3);
                }
            }
            this.q = this.u - f3;
            this.s = f5 - this.v;
            this.p = this.w - f2;
            this.r = f4 - this.x;
            this.f10038e.set(f2, f3, f4, f5);
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
            float f2 = ((this.y - 1.0f) / 20.0f) + 1.0f;
            zoomImageView.f10104e.postTranslate(this.B / 20.0f, this.C / 20.0f);
            Matrix matrix = zoomImageView.f10104e;
            RectF rectF = this.f10038e;
            matrix.postScale(f2, f2, (rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f);
            RectF rectF2 = this.f10038e;
            zoomImageView.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
            zoomImageView.setImageMatrix(zoomImageView.f10104e);
        }
    }

    @TargetApi(11)
    private void a() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int width = getWidth() - (this.f10042i * 2);
            RectF rectF = this.f10038e;
            float f2 = rectF.right;
            float f3 = rectF.left;
            float f4 = f2 - f3;
            float f5 = width;
            if (f4 < f5) {
                float f6 = rectF.top;
                this.u = f6;
                float f7 = rectF.bottom;
                this.v = f7;
                this.w = f3;
                this.x = f2;
                float f8 = (f2 - f3) / (f7 - f6);
                this.z = f5 / f4;
                RectF rectF2 = this.f10038e;
                float height = (getHeight() - (this.m * 2)) / (rectF2.bottom - rectF2.top);
                this.A = height;
                float min = Math.min(this.z, height);
                this.y = min;
                float f9 = min - 1.0f;
                float f10 = f9 <= 1.0f ? f9 : 1.0f;
                RectF rectF3 = this.f10038e;
                this.B = ((getWidth() / 2) - ((rectF3.left + rectF3.right) / 2.0f)) * f10;
                RectF rectF4 = this.f10038e;
                float f11 = rectF4.top;
                float f12 = rectF4.bottom;
                this.C = ((getHeight() / 2) - ((f11 + f12) / 2.0f)) * f10;
                float f13 = rectF4.left;
                float f14 = this.y;
                float f15 = f13 / f14;
                rectF4.left = f15;
                float f16 = f11 / f14;
                rectF4.top = f16;
                float f17 = rectF4.right * f14;
                rectF4.right = f17;
                float f18 = f12 * f14;
                rectF4.bottom = f18;
                if (this.E == G) {
                    a(f15, f16, f17, f18, f8);
                } else {
                    a(this.f10042i, this.j, i2 + width, i3 + width);
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
            int width = getWidth() - (this.f10042i * 2);
            RectF rectF = this.f10038e;
            float f2 = width;
            if (rectF.right - rectF.left < f2 || rectF.bottom - rectF.top < f2) {
                return false;
            }
            return motionEvent.getX() < ((float) this.f10042i) || motionEvent.getX() > ((float) (this.f10042i + width)) || motionEvent.getY() < ((float) this.j) || motionEvent.getY() > ((float) (this.j + width));
        }
        return invokeL.booleanValue;
    }
}
