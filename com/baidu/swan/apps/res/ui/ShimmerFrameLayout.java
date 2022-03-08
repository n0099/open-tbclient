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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final PorterDuffXfermode t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f37757e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f37758f;

    /* renamed from: g  reason: collision with root package name */
    public d f37759g;

    /* renamed from: h  reason: collision with root package name */
    public e f37760h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f37761i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f37762j;
    public boolean k;
    public int l;
    public int m;
    public ValueAnimator mAnimator;
    public Bitmap mMaskBitmap;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public ViewTreeObserver.OnGlobalLayoutListener s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

        public MaskAngle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
    /* loaded from: classes5.dex */
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

        public MaskShape(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShimmerFrameLayout f37763e;

        public a(ShimmerFrameLayout shimmerFrameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shimmerFrameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37763e = shimmerFrameLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = this.f37763e.r;
                this.f37763e.k();
                if (this.f37763e.k || z) {
                    this.f37763e.startShimmerAnimation();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShimmerFrameLayout f37764e;

        public b(ShimmerFrameLayout shimmerFrameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shimmerFrameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37764e = shimmerFrameLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = this.f37764e;
                float f2 = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f37760h.a * f2) + (this.f37764e.f37760h.f37775c * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = this.f37764e;
                shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f37760h.f37774b * f2) + (this.f37764e.f37760h.f37776d * max)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37765b;
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
            f37765b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37765b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37765b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37765b[MaskAngle.CW_270.ordinal()] = 4;
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

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MaskAngle a;

        /* renamed from: b  reason: collision with root package name */
        public float f37766b;

        /* renamed from: c  reason: collision with root package name */
        public float f37767c;

        /* renamed from: d  reason: collision with root package name */
        public int f37768d;

        /* renamed from: e  reason: collision with root package name */
        public int f37769e;

        /* renamed from: f  reason: collision with root package name */
        public float f37770f;

        /* renamed from: g  reason: collision with root package name */
        public float f37771g;

        /* renamed from: h  reason: collision with root package name */
        public float f37772h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f37773i;

        public d() {
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

        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = c.a[this.f37773i.ordinal()];
                return i2 != 2 ? i2 != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
            }
            return (int[]) invokeV.objValue;
        }

        public float[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a[this.f37773i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f37770f) - this.f37767c) / 2.0f, 0.0f), Math.max((1.0f - this.f37770f) / 2.0f, 0.0f), Math.min((this.f37770f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f37770f + 1.0f) + this.f37767c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f37770f, 1.0f), Math.min(this.f37770f + this.f37767c, 1.0f)} : (float[]) invokeV.objValue;
        }

        public int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f37769e;
                return i3 > 0 ? i3 : (int) (i2 * this.f37772h);
            }
            return invokeI.intValue;
        }

        public int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f37768d;
                return i3 > 0 ? i3 : (int) (i2 * this.f37771g);
            }
            return invokeI.intValue;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f37774b;

        /* renamed from: c  reason: collision with root package name */
        public int f37775c;

        /* renamed from: d  reason: collision with root package name */
        public int f37776d;

        public e() {
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

        public void a(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.a = i2;
                this.f37774b = i3;
                this.f37775c = i4;
                this.f37776d = i5;
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
        t = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static Bitmap createBitmapAndGcIfNecessary(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) {
            try {
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    public static float g(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.min(f3, Math.max(f2, f4)) : invokeCommon.floatValue;
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? new a(this) : (ViewTreeObserver.OnGlobalLayoutListener) invokeV.objValue;
    }

    private Bitmap getMaskBitmap() {
        InterceptResult invokeV;
        Shader radialGradient;
        int sqrt;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Bitmap bitmap = this.mMaskBitmap;
            if (bitmap != null) {
                return bitmap;
            }
            int d2 = this.f37759g.d(getWidth());
            int c2 = this.f37759g.c(getHeight());
            this.mMaskBitmap = createBitmapAndGcIfNecessary(d2, c2);
            Canvas canvas = new Canvas(this.mMaskBitmap);
            if (c.a[this.f37759g.f37773i.ordinal()] != 2) {
                int i5 = c.f37765b[this.f37759g.a.ordinal()];
                int i6 = 0;
                if (i5 != 2) {
                    if (i5 == 3) {
                        i6 = d2;
                        i3 = 0;
                    } else if (i5 != 4) {
                        i4 = d2;
                        i3 = 0;
                        i2 = 0;
                    } else {
                        i3 = c2;
                    }
                    i4 = 0;
                    i2 = 0;
                } else {
                    i2 = c2;
                    i3 = 0;
                    i4 = 0;
                }
                radialGradient = new LinearGradient(i6, i3, i4, i2, this.f37759g.a(), this.f37759g.b(), Shader.TileMode.REPEAT);
            } else {
                radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.f37759g.a(), this.f37759g.b(), Shader.TileMode.REPEAT);
            }
            canvas.rotate(this.f37759g.f37766b, d2 / 2, c2 / 2);
            Paint paint = new Paint();
            paint.setShader(radialGradient);
            float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(d2, c2))) / 2);
            canvas.drawRect(f2, f2, d2 + sqrt, c2 + sqrt, paint);
            return this.mMaskBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    private Animator getShimmerAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                return valueAnimator;
            }
            int width = getWidth();
            int height = getHeight();
            int i2 = c.a[this.f37759g.f37773i.ordinal()];
            int i3 = c.f37765b[this.f37759g.a.ordinal()];
            if (i3 == 2) {
                this.f37760h.a(0, -height, 0, height);
            } else if (i3 == 3) {
                this.f37760h.a(width, 0, -width, 0);
            } else if (i3 != 4) {
                this.f37760h.a(-width, 0, width, 0);
            } else {
                this.f37760h.a(0, height, 0, -height);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.n / this.l) + 1.0f);
            this.mAnimator = ofFloat;
            ofFloat.setDuration(this.l + this.n);
            this.mAnimator.setRepeatCount(this.m);
            this.mAnimator.setRepeatMode(this.o);
            this.mAnimator.addUpdateListener(new b(this));
            return this.mAnimator;
        }
        return (Animator) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65551, this, i2) == null) || this.p == i2) {
            return;
        }
        this.p = i2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, this, i2) == null) || this.q == i2) {
            return;
        }
        this.q = i2;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.r && getWidth() > 0 && getHeight() > 0) {
                h(canvas);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    public MaskAngle getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37759g.a : (MaskAngle) invokeV.objValue;
    }

    public float getBaseAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37757e.getAlpha() / 255.0f : invokeV.floatValue;
    }

    public float getDropoff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37759g.f37767c : invokeV.floatValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : invokeV.intValue;
    }

    public int getFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37759g.f37769e : invokeV.intValue;
    }

    public int getFixedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37759g.f37768d : invokeV.intValue;
    }

    public float getIntensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37759g.f37770f : invokeV.floatValue;
    }

    public MaskShape getMaskShape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37759g.f37773i : (MaskShape) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37759g.f37772h : invokeV.floatValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37759g.f37771g : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getRepeatDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : invokeV.intValue;
    }

    public float getTilt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37759g.f37766b : invokeV.floatValue;
    }

    public final boolean h(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, canvas)) == null) {
            Bitmap p = p();
            Bitmap o = o();
            if (p == null || o == null) {
                return false;
            }
            j(new Canvas(p));
            canvas.drawBitmap(p, 0.0f, 0.0f, this.f37757e);
            i(new Canvas(o));
            canvas.drawBitmap(o, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void i(Canvas canvas) {
        Bitmap maskBitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) || (maskBitmap = getMaskBitmap()) == null) {
            return;
        }
        int i2 = this.p;
        canvas.clipRect(i2, this.q, maskBitmap.getWidth() + i2, this.q + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.p, this.q, this.f37758f);
    }

    public boolean isAnimationStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean isAutoStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final void j(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, canvas) == null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            stopShimmerAnimation();
            l();
            m();
        }
    }

    public final void l() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bitmap = this.mMaskBitmap) == null) {
            return;
        }
        bitmap.recycle();
        this.mMaskBitmap = null;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Bitmap bitmap = this.f37762j;
            if (bitmap != null) {
                bitmap.recycle();
                this.f37762j = null;
            }
            Bitmap bitmap2 = this.f37761i;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f37761i = null;
            }
        }
    }

    @SuppressLint({"SwanDebugLog"})
    public final Bitmap n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            try {
                return createBitmapAndGcIfNecessary(width, height);
            } catch (OutOfMemoryError unused) {
                StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
                sb.append(" (width = ");
                sb.append(width);
                sb.append(", height = ");
                sb.append(height);
                sb.append(")\n\n");
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    sb.append(stackTraceElement.toString());
                    sb.append(StringUtils.LF);
                }
                sb.toString();
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final Bitmap o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f37761i == null) {
                this.f37761i = n();
            }
            return this.f37761i;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            if (this.s == null) {
                this.s = getLayoutListener();
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this.s);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            stopShimmerAnimation();
            if (this.s != null) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.s);
                this.s = null;
            }
            super.onDetachedFromWindow();
        }
    }

    public final Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f37762j == null) {
                this.f37762j = n();
            }
            return this.f37762j;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void setAngle(MaskAngle maskAngle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, maskAngle) == null) {
            this.f37759g.a = maskAngle;
            k();
        }
    }

    public void setAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.k = z;
            k();
        }
    }

    public void setBaseAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.f37757e.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
            k();
        }
    }

    public void setDropoff(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
            this.f37759g.f37767c = f2;
            k();
        }
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.l = i2;
            k();
        }
    }

    public void setFixedHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f37759g.f37769e = i2;
            k();
        }
    }

    public void setFixedWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.f37759g.f37768d = i2;
            k();
        }
    }

    public void setIntensity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048611, this, f2) == null) {
            this.f37759g.f37770f = f2;
            k();
        }
    }

    public void setMaskShape(MaskShape maskShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, maskShape) == null) {
            this.f37759g.f37773i = maskShape;
            k();
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.f37759g.f37772h = i2;
            k();
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.f37759g.f37771g = i2;
            k();
        }
    }

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.m = i2;
            k();
        }
    }

    public void setRepeatDelay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.n = i2;
            k();
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.o = i2;
            k();
        }
    }

    public void setTilt(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            this.f37759g.f37766b = f2;
            k();
        }
    }

    public void startShimmerAnimation() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || this.r) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.r = true;
    }

    public void stopShimmerAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.end();
                this.mAnimator.removeAllUpdateListeners();
                this.mAnimator.cancel();
            }
            this.mAnimator = null;
            this.r = false;
        }
    }

    public void useDefaults() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            setDuration(1200);
            setRepeatCount(-1);
            setRepeatDelay(0);
            setRepeatMode(1);
            d dVar = this.f37759g;
            dVar.a = MaskAngle.CW_0;
            dVar.f37773i = MaskShape.LINEAR;
            dVar.f37767c = 0.5f;
            dVar.f37768d = 0;
            dVar.f37769e = 0;
            dVar.f37770f = 0.0f;
            dVar.f37771g = 1.0f;
            dVar.f37772h = 1.0f;
            dVar.f37766b = 340.0f;
            this.f37760h = new e(null);
            setBaseAlpha(1.0f);
            k();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
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
        setWillNotDraw(false);
        this.f37759g = new d(null);
        this.f37757e = new Paint();
        Paint paint = new Paint();
        this.f37758f = paint;
        paint.setAntiAlias(true);
        this.f37758f.setDither(true);
        this.f37758f.setFilterBitmap(true);
        this.f37758f.setXfermode(t);
        useDefaults();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.angle, R.attr.auto_start, R.attr.base_alpha, R.attr.dropoff, R.attr.duration, R.attr.fixed_height, R.attr.fixed_width, R.attr.intensity, R.attr.relative_height, R.attr.relative_width, R.attr.repeat_count, R.attr.repeat_delay, R.attr.repeat_mode, R.attr.shimmer_shape, R.attr.tilt}, 0, 0);
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
                    int i5 = obtainStyledAttributes.getInt(0, 0);
                    if (i5 == 90) {
                        this.f37759g.a = MaskAngle.CW_90;
                    } else if (i5 == 180) {
                        this.f37759g.a = MaskAngle.CW_180;
                    } else if (i5 != 270) {
                        this.f37759g.a = MaskAngle.CW_0;
                    } else {
                        this.f37759g.a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        this.f37759g.f37773i = MaskShape.LINEAR;
                    } else {
                        this.f37759g.f37773i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.f37759g.f37767c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.f37759g.f37768d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.f37759g.f37769e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f37759g.f37770f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f37759g.f37771g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f37759g.f37772h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f37759g.f37766b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void startShimmerAnimation(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) || this.r) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(j2);
        this.r = true;
    }
}
