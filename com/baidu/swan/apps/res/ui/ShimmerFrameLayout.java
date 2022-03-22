package com.baidu.swan.apps.res.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
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
/* loaded from: classes4.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final PorterDuffXfermode r;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f29121b;

    /* renamed from: c  reason: collision with root package name */
    public d f29122c;

    /* renamed from: d  reason: collision with root package name */
    public e f29123d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f29124e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f29125f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29126g;

    /* renamed from: h  reason: collision with root package name */
    public int f29127h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public ViewTreeObserver.OnGlobalLayoutListener o;
    public ValueAnimator p;
    public Bitmap q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class MaskAngle {
        public static final /* synthetic */ MaskAngle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskAngle CW_0;
        public static final MaskAngle CW_180;
        public static final MaskAngle CW_270;
        public static final MaskAngle CW_90;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-968570781, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$MaskAngle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-968570781, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$MaskAngle;");
                    return;
                }
            }
            CW_0 = new MaskAngle("CW_0", 0);
            CW_90 = new MaskAngle("CW_90", 1);
            CW_180 = new MaskAngle("CW_180", 2);
            MaskAngle maskAngle = new MaskAngle("CW_270", 3);
            CW_270 = maskAngle;
            $VALUES = new MaskAngle[]{CW_0, CW_90, CW_180, maskAngle};
        }

        public MaskAngle(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MaskAngle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskAngle) Enum.valueOf(MaskAngle.class, str) : (MaskAngle) invokeL.objValue;
        }

        public static MaskAngle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskAngle[]) $VALUES.clone() : (MaskAngle[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class MaskShape {
        public static final /* synthetic */ MaskShape[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskShape LINEAR;
        public static final MaskShape RADIAL;
        public static final MaskShape WHITE_LINEAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458962091, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$MaskShape;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-458962091, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$MaskShape;");
                    return;
                }
            }
            LINEAR = new MaskShape("LINEAR", 0);
            RADIAL = new MaskShape("RADIAL", 1);
            MaskShape maskShape = new MaskShape("WHITE_LINEAR", 2);
            WHITE_LINEAR = maskShape;
            $VALUES = new MaskShape[]{LINEAR, RADIAL, maskShape};
        }

        public MaskShape(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MaskShape valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskShape) Enum.valueOf(MaskShape.class, str) : (MaskShape) invokeL.objValue;
        }

        public static MaskShape[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskShape[]) $VALUES.clone() : (MaskShape[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShimmerFrameLayout a;

        public a(ShimmerFrameLayout shimmerFrameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shimmerFrameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shimmerFrameLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = this.a.n;
                this.a.l();
                if (this.a.f29126g || z) {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShimmerFrameLayout a;

        public b(ShimmerFrameLayout shimmerFrameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shimmerFrameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shimmerFrameLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = this.a;
                float f2 = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f29123d.a * f2) + (this.a.f29123d.f29137c * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = this.a;
                shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f29123d.f29136b * f2) + (this.a.f29123d.f29138d * max)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f29128b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-233888857, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-233888857, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout$c;");
                    return;
                }
            }
            int[] iArr = new int[MaskAngle.values().length];
            f29128b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29128b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29128b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29128b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MaskAngle a;

        /* renamed from: b  reason: collision with root package name */
        public float f29129b;

        /* renamed from: c  reason: collision with root package name */
        public float f29130c;

        /* renamed from: d  reason: collision with root package name */
        public int f29131d;

        /* renamed from: e  reason: collision with root package name */
        public int f29132e;

        /* renamed from: f  reason: collision with root package name */
        public float f29133f;

        /* renamed from: g  reason: collision with root package name */
        public float f29134g;

        /* renamed from: h  reason: collision with root package name */
        public float f29135h;
        public MaskShape i;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = c.a[this.i.ordinal()];
                return i != 2 ? i != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
            }
            return (int[]) invokeV.objValue;
        }

        public float[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a[this.i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f29133f) - this.f29130c) / 2.0f, 0.0f), Math.max((1.0f - this.f29133f) / 2.0f, 0.0f), Math.min((this.f29133f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f29133f + 1.0f) + this.f29130c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f29133f, 1.0f), Math.min(this.f29133f + this.f29130c, 1.0f)} : (float[]) invokeV.objValue;
        }

        public int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                int i2 = this.f29132e;
                return i2 > 0 ? i2 : (int) (i * this.f29135h);
            }
            return invokeI.intValue;
        }

        public int d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = this.f29131d;
                return i2 > 0 ? i2 : (int) (i * this.f29134g);
            }
            return invokeI.intValue;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f29136b;

        /* renamed from: c  reason: collision with root package name */
        public int f29137c;

        /* renamed from: d  reason: collision with root package name */
        public int f29138d;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a = i;
                this.f29136b = i2;
                this.f29137c = i3;
                this.f29138d = i4;
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(545007430, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(545007430, "Lcom/baidu/swan/apps/res/ui/ShimmerFrameLayout;");
                return;
            }
        }
        r = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float g(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.min(f3, Math.max(f2, f4)) : invokeCommon.floatValue;
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new a(this) : (ViewTreeObserver.OnGlobalLayoutListener) invokeV.objValue;
    }

    private Bitmap getMaskBitmap() {
        InterceptResult invokeV;
        Shader radialGradient;
        int sqrt;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                return bitmap;
            }
            int d2 = this.f29122c.d(getWidth());
            int c2 = this.f29122c.c(getHeight());
            this.q = h(d2, c2);
            Canvas canvas = new Canvas(this.q);
            if (c.a[this.f29122c.i.ordinal()] != 2) {
                int i4 = c.f29128b[this.f29122c.a.ordinal()];
                int i5 = 0;
                if (i4 != 2) {
                    if (i4 == 3) {
                        i5 = d2;
                        i2 = 0;
                    } else if (i4 != 4) {
                        i3 = d2;
                        i2 = 0;
                        i = 0;
                    } else {
                        i2 = c2;
                    }
                    i3 = 0;
                    i = 0;
                } else {
                    i = c2;
                    i2 = 0;
                    i3 = 0;
                }
                radialGradient = new LinearGradient(i5, i2, i3, i, this.f29122c.a(), this.f29122c.b(), Shader.TileMode.REPEAT);
            } else {
                radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.f29122c.a(), this.f29122c.b(), Shader.TileMode.REPEAT);
            }
            canvas.rotate(this.f29122c.f29129b, d2 / 2, c2 / 2);
            Paint paint = new Paint();
            paint.setShader(radialGradient);
            float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(d2, c2))) / 2);
            canvas.drawRect(f2, f2, d2 + sqrt, c2 + sqrt, paint);
            return this.q;
        }
        return (Bitmap) invokeV.objValue;
    }

    private Animator getShimmerAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                return valueAnimator;
            }
            int width = getWidth();
            int height = getHeight();
            int i = c.a[this.f29122c.i.ordinal()];
            int i2 = c.f29128b[this.f29122c.a.ordinal()];
            if (i2 == 2) {
                this.f29123d.a(0, -height, 0, height);
            } else if (i2 == 3) {
                this.f29123d.a(width, 0, -width, 0);
            } else if (i2 != 4) {
                this.f29123d.a(-width, 0, width, 0);
            } else {
                this.f29123d.a(0, height, 0, -height);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.j / this.f29127h) + 1.0f);
            this.p = ofFloat;
            ofFloat.setDuration(this.f29127h + this.j);
            this.p.setRepeatCount(this.i);
            this.p.setRepeatMode(this.k);
            this.p.addUpdateListener(new b(this));
            return this.p;
        }
        return (Animator) invokeV.objValue;
    }

    public static Bitmap h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i, i2)) == null) {
            try {
                return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65551, this, i) == null) || this.l == i) {
            return;
        }
        this.l = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, this, i) == null) || this.m == i) {
            return;
        }
        this.m = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.n && getWidth() > 0 && getHeight() > 0) {
                i(canvas);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    public MaskAngle getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29122c.a : (MaskAngle) invokeV.objValue;
    }

    public float getBaseAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getAlpha() / 255.0f : invokeV.floatValue;
    }

    public float getDropoff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29122c.f29130c : invokeV.floatValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29127h : invokeV.intValue;
    }

    public int getFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29122c.f29132e : invokeV.intValue;
    }

    public int getFixedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29122c.f29131d : invokeV.intValue;
    }

    public float getIntensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29122c.f29133f : invokeV.floatValue;
    }

    public MaskShape getMaskShape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29122c.i : (MaskShape) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29122c.f29135h : invokeV.floatValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29122c.f29134g : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : invokeV.intValue;
    }

    public int getRepeatDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.intValue;
    }

    public float getTilt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29122c.f29129b : invokeV.floatValue;
    }

    public final boolean i(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, canvas)) == null) {
            Bitmap s = s();
            Bitmap r2 = r();
            if (s == null || r2 == null) {
                return false;
            }
            k(new Canvas(s));
            canvas.drawBitmap(s, 0.0f, 0.0f, this.a);
            j(new Canvas(r2));
            canvas.drawBitmap(r2, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j(Canvas canvas) {
        Bitmap maskBitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) || (maskBitmap = getMaskBitmap()) == null) {
            return;
        }
        int i = this.l;
        canvas.clipRect(i, this.m, maskBitmap.getWidth() + i, this.m + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.l, this.m, this.f29121b);
    }

    public final void k(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, canvas) == null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            p();
            m();
            n();
        }
    }

    public final void m() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bitmap = this.q) == null) {
            return;
        }
        bitmap.recycle();
        this.q = null;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Bitmap bitmap = this.f29125f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f29125f = null;
            }
            Bitmap bitmap2 = this.f29124e;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f29124e = null;
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.n) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onAttachedToWindow();
            if (this.o == null) {
                this.o = getLayoutListener();
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            p();
            if (this.o != null) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.o);
                this.o = null;
            }
            super.onDetachedFromWindow();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.end();
                this.p.removeAllUpdateListeners();
                this.p.cancel();
            }
            this.p = null;
            this.n = false;
        }
    }

    @SuppressLint({"SwanDebugLog"})
    public final Bitmap q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            try {
                return h(width, height);
            } catch (OutOfMemoryError unused) {
                StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
                sb.append(" (width = ");
                sb.append(width);
                sb.append(", height = ");
                sb.append(height);
                sb.append(")\n\n");
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                Log.d("ShimmerFrameLayout", sb.toString());
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final Bitmap r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f29124e == null) {
                this.f29124e = q();
            }
            return this.f29124e;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final Bitmap s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f29125f == null) {
                this.f29125f = q();
            }
            return this.f29125f;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void setAngle(MaskAngle maskAngle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, maskAngle) == null) {
            this.f29122c.a = maskAngle;
            l();
        }
    }

    public void setAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f29126g = z;
            l();
        }
    }

    public void setBaseAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.a.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
            l();
        }
    }

    public void setDropoff(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
            this.f29122c.f29130c = f2;
            l();
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.f29127h = i;
            l();
        }
    }

    public void setFixedHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.f29122c.f29132e = i;
            l();
        }
    }

    public void setFixedWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.f29122c.f29131d = i;
            l();
        }
    }

    public void setIntensity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048611, this, f2) == null) {
            this.f29122c.f29133f = f2;
            l();
        }
    }

    public void setMaskShape(MaskShape maskShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, maskShape) == null) {
            this.f29122c.i = maskShape;
            l();
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.f29122c.f29135h = i;
            l();
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.f29122c.f29134g = i;
            l();
        }
    }

    public void setRepeatCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.i = i;
            l();
        }
    }

    public void setRepeatDelay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.j = i;
            l();
        }
    }

    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.k = i;
            l();
        }
    }

    public void setTilt(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            this.f29122c.f29129b = f2;
            l();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            setDuration(1200);
            setRepeatCount(-1);
            setRepeatDelay(0);
            setRepeatMode(1);
            d dVar = this.f29122c;
            dVar.a = MaskAngle.CW_0;
            dVar.i = MaskShape.LINEAR;
            dVar.f29130c = 0.5f;
            dVar.f29131d = 0;
            dVar.f29132e = 0;
            dVar.f29133f = 0.0f;
            dVar.f29134g = 1.0f;
            dVar.f29135h = 1.0f;
            dVar.f29129b = 340.0f;
            this.f29123d = new e(null);
            setBaseAlpha(1.0f);
            l();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
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
        setWillNotDraw(false);
        this.f29122c = new d(null);
        this.a = new Paint();
        Paint paint = new Paint();
        this.f29121b = paint;
        paint.setAntiAlias(true);
        this.f29121b.setDither(true);
        this.f29121b.setFilterBitmap(true);
        this.f29121b.setXfermode(r);
        t();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04008a, R.attr.obfuscated_res_0x7f0400a4, R.attr.obfuscated_res_0x7f0400c0, R.attr.obfuscated_res_0x7f0401cf, R.attr.obfuscated_res_0x7f0401d1, R.attr.obfuscated_res_0x7f040212, R.attr.obfuscated_res_0x7f040213, R.attr.obfuscated_res_0x7f0402c2, R.attr.obfuscated_res_0x7f0404ee, R.attr.obfuscated_res_0x7f0404ef, R.attr.obfuscated_res_0x7f0404f2, R.attr.obfuscated_res_0x7f0404f3, R.attr.obfuscated_res_0x7f0404f4, R.attr.obfuscated_res_0x7f040551, R.attr.obfuscated_res_0x7f04063e}, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setDuration(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    setRepeatCount(obtainStyledAttributes.getInt(10, 0));
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(11, 0));
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    setRepeatMode(obtainStyledAttributes.getInt(12, 0));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    int i4 = obtainStyledAttributes.getInt(0, 0);
                    if (i4 == 90) {
                        this.f29122c.a = MaskAngle.CW_90;
                    } else if (i4 == 180) {
                        this.f29122c.a = MaskAngle.CW_180;
                    } else if (i4 != 270) {
                        this.f29122c.a = MaskAngle.CW_0;
                    } else {
                        this.f29122c.a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        this.f29122c.i = MaskShape.LINEAR;
                    } else {
                        this.f29122c.i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.f29122c.f29130c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.f29122c.f29131d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.f29122c.f29132e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f29122c.f29133f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f29122c.f29134g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f29122c.f29135h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f29122c.f29129b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
