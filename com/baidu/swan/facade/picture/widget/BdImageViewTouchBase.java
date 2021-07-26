package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class BdImageViewTouchBase extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f A;
    public g B;
    public boolean C;

    /* renamed from: e  reason: collision with root package name */
    public e f11730e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f11731f;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f11732g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f11733h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f11734i;
    public Runnable j;
    public boolean k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public final Matrix p;
    public final float[] q;
    public int r;
    public int s;
    public PointF t;
    public DisplayType u;
    public boolean v;
    public boolean w;
    public RectF x;
    public RectF y;
    public RectF z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DisplayType {
        public static final /* synthetic */ DisplayType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DisplayType FIT_IF_BIGGER;
        public static final DisplayType FIT_TO_SCREEN;
        public static final DisplayType NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1680356732, "Lcom/baidu/swan/facade/picture/widget/BdImageViewTouchBase$DisplayType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1680356732, "Lcom/baidu/swan/facade/picture/widget/BdImageViewTouchBase$DisplayType;");
                    return;
                }
            }
            NONE = new DisplayType("NONE", 0);
            FIT_TO_SCREEN = new DisplayType("FIT_TO_SCREEN", 1);
            DisplayType displayType = new DisplayType("FIT_IF_BIGGER", 2);
            FIT_IF_BIGGER = displayType;
            $VALUES = new DisplayType[]{NONE, FIT_TO_SCREEN, displayType};
        }

        public DisplayType(String str, int i2) {
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

        public static DisplayType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DisplayType) Enum.valueOf(DisplayType.class, str) : (DisplayType) invokeL.objValue;
        }

        public static DisplayType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DisplayType[]) $VALUES.clone() : (DisplayType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Drawable f11735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Matrix f11736f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f11737g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f11738h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f11739i;

        public a(BdImageViewTouchBase bdImageViewTouchBase, Drawable drawable, Matrix matrix, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11739i = bdImageViewTouchBase;
            this.f11735e = drawable;
            this.f11736f = matrix;
            this.f11737g = f2;
            this.f11738h = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11739i.setImageDrawable(this.f11735e, this.f11736f, this.f11737g, this.f11738h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f11740e;

        /* renamed from: f  reason: collision with root package name */
        public double f11741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f11742g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f11743h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ double f11744i;
        public final /* synthetic */ double j;
        public final /* synthetic */ BdImageViewTouchBase k;

        public b(BdImageViewTouchBase bdImageViewTouchBase, double d2, long j, double d3, double d4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Double.valueOf(d2), Long.valueOf(j), Double.valueOf(d3), Double.valueOf(d4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bdImageViewTouchBase;
            this.f11742g = d2;
            this.f11743h = j;
            this.f11744i = d3;
            this.j = d4;
            this.f11740e = 0.0d;
            this.f11741f = 0.0d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                double min = Math.min(this.f11742g, System.currentTimeMillis() - this.f11743h);
                double a2 = this.k.f11730e.a(min, 0.0d, this.f11744i, this.f11742g);
                double a3 = this.k.f11730e.a(min, 0.0d, this.j, this.f11742g);
                this.k.t(a2 - this.f11740e, a3 - this.f11741f);
                this.f11740e = a2;
                this.f11741f = a3;
                if (min < this.f11742g) {
                    this.k.f11734i.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.k;
                RectF h2 = bdImageViewTouchBase.h(bdImageViewTouchBase.f11732g, true, true);
                if (h2.left == 0.0f && h2.top == 0.0f) {
                    return;
                }
                this.k.w(h2.left, h2.top);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f11745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f11746f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f11747g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f11748h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f11749i;
        public final /* synthetic */ float j;
        public final /* synthetic */ BdImageViewTouchBase k;

        public c(BdImageViewTouchBase bdImageViewTouchBase, float f2, long j, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Float.valueOf(f2), Long.valueOf(j), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bdImageViewTouchBase;
            this.f11745e = f2;
            this.f11746f = j;
            this.f11747g = f3;
            this.f11748h = f4;
            this.f11749i = f5;
            this.j = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float min = Math.min(this.f11745e, (float) (System.currentTimeMillis() - this.f11746f));
                this.k.B(this.f11748h + ((float) this.k.f11730e.b(min, 0.0d, this.f11747g, this.f11745e)), this.f11749i, this.j);
                if (min < this.f11745e) {
                    this.k.f11734i.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.k;
                bdImageViewTouchBase.s(bdImageViewTouchBase.getScale());
                this.k.a(true, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f11750a;

        public d(BdImageViewTouchBase bdImageViewTouchBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11750a = bdImageViewTouchBase;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double a(double d2, double d3, double d4, double d5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
                double d6 = (d2 / d5) - 1.0d;
                return (d4 * ((d6 * d6 * d6) + 1.0d)) + d3;
            }
            return invokeCommon.doubleValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double b(double d2, double d3, double d4, double d5) {
            InterceptResult invokeCommon;
            double d6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
                double d7 = d2 / (d5 / 2.0d);
                if (d7 < 1.0d) {
                    d6 = (d4 / 2.0d) * d7 * d7 * d7;
                } else {
                    double d8 = d7 - 2.0d;
                    d6 = (d4 / 2.0d) * ((d8 * d8 * d8) + 2.0d);
                }
                return d6 + d3;
            }
            return invokeCommon.doubleValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        double a(double d2, double d3, double d4, double d5);

        double b(double d2, double d3, double d4, double d5);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(Drawable drawable);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(boolean z, int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            PointF center = getCenter();
            C(f2, center.x, center.y, f3);
        }
    }

    public void B(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            u(f2 / getScale(), f3, f4);
            r(getScale());
            a(true, true);
        }
    }

    public void C(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            long currentTimeMillis = System.currentTimeMillis();
            float scale = getScale();
            Matrix matrix = new Matrix(this.f11732g);
            matrix.postScale(f2, f2, f3, f4);
            RectF h2 = h(matrix, true, true);
            this.f11734i.post(new c(this, f5, currentTimeMillis, f2 - scale, scale, f3 + (h2.left * f2), f4 + (h2.top * f2)));
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || getDrawable() == null) {
            return;
        }
        RectF h2 = h(this.f11732g, z, z2);
        if (h2.left == 0.0f && h2.top == 0.0f) {
            return;
        }
        v(h2.left, h2.top);
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return 1.0f;
            }
            return Math.max(drawable.getIntrinsicWidth() / this.r, drawable.getIntrinsicHeight() / this.s) * 8.0f;
        }
        return invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getDrawable() == null) {
                return 1.0f;
            }
            return Math.min(1.0f, 1.0f / l(this.f11731f));
        }
        return invokeV.floatValue;
    }

    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (drawable != null) {
                super.setImageDrawable(drawable);
            } else {
                this.f11731f.reset();
                super.setImageDrawable(null);
            }
            if (f2 != -1.0f && f3 != -1.0f) {
                float min = Math.min(f2, f3);
                float max = Math.max(min, f3);
                this.m = min;
                this.l = max;
                this.o = true;
                this.n = true;
            } else {
                this.m = -1.0f;
                this.l = -1.0f;
                this.o = false;
                this.n = false;
            }
            if (matrix != null) {
                this.f11733h = new Matrix(matrix);
            }
            this.w = true;
            requestLayout();
        }
    }

    public void e(Drawable drawable) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) || (fVar = this.A) == null) {
            return;
        }
        fVar.a(drawable);
    }

    public void f(int i2, int i3, int i4, int i5) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) || (gVar = this.B) == null) {
            return;
        }
        gVar.a(true, i2, i3, i4, i5);
    }

    public RectF g(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, matrix)) == null) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return null;
            }
            Matrix j = j(matrix);
            this.x.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            j.mapRect(this.x);
            return this.x;
        }
        return (RectF) invokeL.objValue;
    }

    public RectF getBitmapRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? g(this.f11732g) : (RectF) invokeV.objValue;
    }

    public PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t : (PointF) invokeV.objValue;
    }

    public Matrix getDisplayMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new Matrix(this.f11732g) : (Matrix) invokeV.objValue;
    }

    public DisplayType getDisplayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.u : (DisplayType) invokeV.objValue;
    }

    public Matrix getImageViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? j(this.f11732g) : (Matrix) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.l == -1.0f) {
                this.l = b();
            }
            return this.l;
        }
        return invokeV.floatValue;
    }

    public float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.m == -1.0f) {
                this.m = c();
            }
            return this.m;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? l(this.f11732g) : invokeV.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
        if (r7 < r8) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectF h(Matrix matrix, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{matrix, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (getDrawable() == null) {
                return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
            RectF g2 = g(matrix);
            float height = g2.height();
            float width = g2.width();
            if (z2) {
                int i2 = this.s;
                float f5 = i2;
                if (height < f5) {
                    f2 = ((f5 - height) / 2.0f) - g2.top;
                } else {
                    float f6 = g2.top;
                    if (f6 > 0.0f) {
                        f2 = -f6;
                    } else {
                        float f7 = g2.bottom;
                        if (f7 < f5) {
                            f2 = i2 - f7;
                        }
                    }
                }
                if (z) {
                    float f8 = this.r;
                    if (width < f8) {
                        f8 = (f8 - width) / 2.0f;
                        f4 = g2.left;
                    } else {
                        float f9 = g2.left;
                        if (f9 <= 0.0f) {
                            f4 = g2.right;
                        } else {
                            f3 = -f9;
                            this.y.set(f3, f2, 0.0f, 0.0f);
                            return this.y;
                        }
                    }
                    f3 = f8 - f4;
                    this.y.set(f3, f2, 0.0f, 0.0f);
                    return this.y;
                }
                f3 = 0.0f;
                this.y.set(f3, f2, 0.0f, 0.0f);
                return this.y;
            }
            f2 = 0.0f;
            if (z) {
            }
            f3 = 0.0f;
            this.y.set(f3, f2, 0.0f, 0.0f);
            return this.y;
        }
        return (RectF) invokeCommon.objValue;
    }

    public float i(DisplayType displayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, displayType)) == null) {
            if (displayType == DisplayType.FIT_TO_SCREEN) {
                return 1.0f;
            }
            if (displayType == DisplayType.FIT_IF_BIGGER) {
                return Math.max(1.0f, 1.0f / l(this.f11731f));
            }
            return 1.0f / l(this.f11731f);
        }
        return invokeL.floatValue;
    }

    public Matrix j(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, matrix)) == null) {
            this.p.set(this.f11731f);
            this.p.postConcat(matrix);
            return this.p;
        }
        return (Matrix) invokeL.objValue;
    }

    public void k(Drawable drawable, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, drawable, matrix) == null) {
            float f2 = this.r;
            float f3 = this.s;
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            matrix.reset();
            float min = Math.min(f2 / intrinsicWidth, f3 / intrinsicHeight);
            matrix.postScale(min, min);
            matrix.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (f3 - (intrinsicHeight * min)) / 2.0f);
        }
    }

    public float l(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, matrix)) == null) ? m(matrix, 0) : invokeL.floatValue;
    }

    public float m(Matrix matrix, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, matrix, i2)) == null) {
            matrix.getValues(this.q);
            return this.q[i2];
        }
        return invokeLI.floatValue;
    }

    public void n(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, context, attributeSet, i2) == null) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public void o(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            e(drawable);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                int i8 = this.r;
                int i9 = this.s;
                int i10 = i4 - i2;
                this.r = i10;
                int i11 = i5 - i3;
                this.s = i11;
                i6 = i10 - i8;
                i7 = i11 - i9;
                PointF pointF = this.t;
                pointF.x = i10 / 2.0f;
                pointF.y = i11 / 2.0f;
            } else {
                i6 = 0;
                i7 = 0;
            }
            Runnable runnable = this.j;
            if (runnable != null) {
                this.j = null;
                runnable.run();
            }
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (z || this.v || this.w) {
                    float l = l(this.f11731f);
                    float scale = getScale();
                    float min = Math.min(1.0f, 1.0f / l);
                    if (this.C) {
                        k(drawable, this.f11731f);
                    }
                    float l2 = l(this.f11731f);
                    if (this.w || this.v) {
                        Matrix matrix = this.f11733h;
                        if (matrix != null) {
                            this.f11732g.set(matrix);
                            this.f11733h = null;
                            r12 = getScale();
                        } else {
                            this.f11732g.reset();
                        }
                        setImageMatrix(getImageViewMatrix());
                        if (r12 != getScale()) {
                            z(r12);
                        }
                    } else if (z) {
                        if (!this.o) {
                            this.m = -1.0f;
                        }
                        if (!this.n) {
                            this.l = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        v(-i6, -i7);
                        if (!this.k) {
                            r12 = i(this.u);
                            z(r12);
                        } else {
                            r12 = ((double) Math.abs(scale - min)) > 0.001d ? (l / l2) * scale : 1.0f;
                            z(r12);
                        }
                    }
                    this.k = false;
                    if (r12 > getMaxScale() || r12 < getMinScale()) {
                        z(r12);
                    }
                    a(true, true);
                    if (this.w) {
                        o(drawable);
                    }
                    if (z || this.w || this.v) {
                        q(i2, i3, i4, i5);
                    }
                    if (this.v) {
                        this.v = false;
                    }
                    if (this.w) {
                        this.w = false;
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.w) {
                o(null);
            }
            if (z || this.w || this.v) {
                q(i2, i3, i4, i5);
            }
            this.w = false;
            this.v = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void q(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i2, i3, i4, i5) == null) {
            f(i2, i3, i4, i5);
        }
    }

    public void r(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
        }
    }

    public void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
        }
    }

    public void setCalcBaseMatrix(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.C = z;
        }
    }

    public void setDisplayType(DisplayType displayType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, displayType) == null) || displayType == this.u) {
            return;
        }
        this.k = false;
        this.u = displayType;
        this.v = true;
        requestLayout();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bitmap) == null) {
            setImageBitmap(bitmap, null, -1.0f, -1.0f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, drawable) == null) {
            setImageDrawable(drawable, null, -1.0f, -1.0f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, matrix) == null) {
            Matrix imageMatrix = getImageMatrix();
            boolean z = (matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix));
            super.setImageMatrix(matrix);
            if (z) {
                p();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            setImageDrawable(getContext().getResources().getDrawable(i2));
        }
    }

    public void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            this.l = f2;
        }
    }

    public void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.m = f2;
        }
    }

    public void setOnDrawableChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            this.A = fVar;
        }
    }

    public void setOnLayoutChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, gVar) == null) {
            this.B = gVar;
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, scaleType) == null) && scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void t(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            RectF bitmapRect = getBitmapRect();
            this.z.set((float) d2, (float) d3, 0.0f, 0.0f);
            y(bitmapRect, this.z);
            RectF rectF = this.z;
            v(rectF.left, rectF.top);
            a(true, true);
        }
    }

    public void u(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.f11732g.postScale(f2, f2, f3, f4);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 == 0.0f && f3 == 0.0f) {
                return;
            }
            this.f11732g.postTranslate(f2, f3);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void w(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            t(f2, f3);
        }
    }

    public void x(float f2, float f3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(d2)}) == null) {
            this.f11734i.post(new b(this, d2, System.currentTimeMillis(), f2, f3));
        }
    }

    public void y(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048626, this, rectF, rectF2) == null) || rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.s) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.r) {
            rectF2.left = 0.0f;
        }
        float f2 = rectF.top;
        if (rectF2.top + f2 >= 0.0f && rectF.bottom > this.s) {
            rectF2.top = (int) (0.0f - f2);
        }
        float f3 = rectF.bottom;
        int i2 = this.s;
        if (rectF2.top + f3 <= i2 + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i2 + 0) - f3);
        }
        float f4 = rectF.left;
        if (rectF2.left + f4 >= 0.0f) {
            rectF2.left = (int) (0.0f - f4);
        }
        float f5 = rectF.right;
        int i3 = this.r;
        if (rectF2.left + f5 <= i3 + 0) {
            rectF2.left = (int) ((i3 + 0) - f5);
        }
    }

    public void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f2) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            if (f2 < getMinScale()) {
                f2 = getMinScale();
            }
            PointF center = getCenter();
            B(f2, center.x, center.y);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{bitmap, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (bitmap != null) {
                setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap), matrix, f2, f3);
            } else {
                setImageDrawable(null, matrix, f2, f3);
            }
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (getWidth() <= 0) {
                this.j = new a(this, drawable, matrix, f2, f3);
            } else {
                d(drawable, matrix, f2, f3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11730e = new d(this);
        this.f11731f = new Matrix();
        this.f11732g = new Matrix();
        this.f11734i = new Handler();
        this.j = null;
        this.k = false;
        this.l = -1.0f;
        this.m = -1.0f;
        this.p = new Matrix();
        this.q = new float[9];
        this.r = -1;
        this.s = -1;
        this.t = new PointF();
        this.u = DisplayType.NONE;
        this.x = new RectF();
        this.y = new RectF();
        this.z = new RectF();
        this.C = true;
        n(context, attributeSet, i2);
    }
}
