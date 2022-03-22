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
/* loaded from: classes4.dex */
public abstract class BdImageViewTouchBase extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public Matrix f29414b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f29415c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f29416d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f29417e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f29418f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29419g;

    /* renamed from: h  reason: collision with root package name */
    public float f29420h;
    public float i;
    public boolean j;
    public boolean k;
    public final Matrix l;
    public final float[] m;
    public int n;
    public int o;
    public PointF p;
    public DisplayType q;
    public boolean r;
    public boolean s;
    public RectF t;
    public RectF u;
    public RectF v;
    public f w;
    public g x;
    public boolean y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public DisplayType(String str, int i) {
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Drawable a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Matrix f29421b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f29422c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f29423d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f29424e;

        public a(BdImageViewTouchBase bdImageViewTouchBase, Drawable drawable, Matrix matrix, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29424e = bdImageViewTouchBase;
            this.a = drawable;
            this.f29421b = matrix;
            this.f29422c = f2;
            this.f29423d = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29424e.setImageDrawable(this.a, this.f29421b, this.f29422c, this.f29423d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public double f29425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ double f29426c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f29427d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ double f29428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ double f29429f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f29430g;

        public b(BdImageViewTouchBase bdImageViewTouchBase, double d2, long j, double d3, double d4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Double.valueOf(d2), Long.valueOf(j), Double.valueOf(d3), Double.valueOf(d4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29430g = bdImageViewTouchBase;
            this.f29426c = d2;
            this.f29427d = j;
            this.f29428e = d3;
            this.f29429f = d4;
            this.a = 0.0d;
            this.f29425b = 0.0d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                double min = Math.min(this.f29426c, System.currentTimeMillis() - this.f29427d);
                double a = this.f29430g.a.a(min, 0.0d, this.f29428e, this.f29426c);
                double a2 = this.f29430g.a.a(min, 0.0d, this.f29429f, this.f29426c);
                this.f29430g.t(a - this.a, a2 - this.f29425b);
                this.a = a;
                this.f29425b = a2;
                if (min < this.f29426c) {
                    this.f29430g.f29417e.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.f29430g;
                RectF h2 = bdImageViewTouchBase.h(bdImageViewTouchBase.f29415c, true, true);
                if (h2.left == 0.0f && h2.top == 0.0f) {
                    return;
                }
                this.f29430g.w(h2.left, h2.top);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f29431b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f29432c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f29433d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f29434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f29435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f29436g;

        public c(BdImageViewTouchBase bdImageViewTouchBase, float f2, long j, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Float.valueOf(f2), Long.valueOf(j), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29436g = bdImageViewTouchBase;
            this.a = f2;
            this.f29431b = j;
            this.f29432c = f3;
            this.f29433d = f4;
            this.f29434e = f5;
            this.f29435f = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float min = Math.min(this.a, (float) (System.currentTimeMillis() - this.f29431b));
                this.f29436g.B(this.f29433d + ((float) this.f29436g.a.b(min, 0.0d, this.f29432c, this.a)), this.f29434e, this.f29435f);
                if (min < this.a) {
                    this.f29436g.f29417e.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.f29436g;
                bdImageViewTouchBase.s(bdImageViewTouchBase.getScale());
                this.f29436g.a(true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdImageViewTouchBase a;

        public d(BdImageViewTouchBase bdImageViewTouchBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdImageViewTouchBase;
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

    /* loaded from: classes4.dex */
    public interface e {
        double a(double d2, double d3, double d4, double d5);

        double b(double d2, double d3, double d4, double d5);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(Drawable drawable);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(boolean z, int i, int i2, int i3, int i4);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            Matrix matrix = new Matrix(this.f29415c);
            matrix.postScale(f2, f2, f3, f4);
            RectF h2 = h(matrix, true, true);
            this.f29417e.post(new c(this, f5, currentTimeMillis, f2 - scale, scale, f3 + (h2.left * f2), f4 + (h2.top * f2)));
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || getDrawable() == null) {
            return;
        }
        RectF h2 = h(this.f29415c, z, z2);
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
            return Math.max(drawable.getIntrinsicWidth() / this.n, drawable.getIntrinsicHeight() / this.o) * 8.0f;
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
            return Math.min(1.0f, 1.0f / l(this.f29414b));
        }
        return invokeV.floatValue;
    }

    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (drawable != null) {
                super.setImageDrawable(drawable);
            } else {
                this.f29414b.reset();
                super.setImageDrawable(null);
            }
            if (f2 != -1.0f && f3 != -1.0f) {
                float min = Math.min(f2, f3);
                float max = Math.max(min, f3);
                this.i = min;
                this.f29420h = max;
                this.k = true;
                this.j = true;
            } else {
                this.i = -1.0f;
                this.f29420h = -1.0f;
                this.k = false;
                this.j = false;
            }
            if (matrix != null) {
                this.f29416d = new Matrix(matrix);
            }
            this.s = true;
            requestLayout();
        }
    }

    public void e(Drawable drawable) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) || (fVar = this.w) == null) {
            return;
        }
        fVar.a(drawable);
    }

    public void f(int i, int i2, int i3, int i4) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) || (gVar = this.x) == null) {
            return;
        }
        gVar.a(true, i, i2, i3, i4);
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
            this.t.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            j.mapRect(this.t);
            return this.t;
        }
        return (RectF) invokeL.objValue;
    }

    public RectF getBitmapRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? g(this.f29415c) : (RectF) invokeV.objValue;
    }

    public PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (PointF) invokeV.objValue;
    }

    public Matrix getDisplayMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new Matrix(this.f29415c) : (Matrix) invokeV.objValue;
    }

    public DisplayType getDisplayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.q : (DisplayType) invokeV.objValue;
    }

    public Matrix getImageViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? j(this.f29415c) : (Matrix) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f29420h == -1.0f) {
                this.f29420h = b();
            }
            return this.f29420h;
        }
        return invokeV.floatValue;
    }

    public float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.i == -1.0f) {
                this.i = c();
            }
            return this.i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? l(this.f29415c) : invokeV.floatValue;
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
            this.u.set(0.0f, 0.0f, 0.0f, 0.0f);
            RectF g2 = g(matrix);
            float height = g2.height();
            float width = g2.width();
            if (z2) {
                int i = this.o;
                float f5 = i;
                if (height < f5) {
                    f2 = ((f5 - height) / 2.0f) - g2.top;
                } else {
                    float f6 = g2.top;
                    if (f6 > 0.0f) {
                        f2 = -f6;
                    } else {
                        float f7 = g2.bottom;
                        if (f7 < f5) {
                            f2 = i - f7;
                        }
                    }
                }
                if (z) {
                    float f8 = this.n;
                    if (width < f8) {
                        f8 = (f8 - width) / 2.0f;
                        f4 = g2.left;
                    } else {
                        float f9 = g2.left;
                        if (f9 <= 0.0f) {
                            f4 = g2.right;
                        } else {
                            f3 = -f9;
                            this.u.set(f3, f2, 0.0f, 0.0f);
                            return this.u;
                        }
                    }
                    f3 = f8 - f4;
                    this.u.set(f3, f2, 0.0f, 0.0f);
                    return this.u;
                }
                f3 = 0.0f;
                this.u.set(f3, f2, 0.0f, 0.0f);
                return this.u;
            }
            f2 = 0.0f;
            if (z) {
            }
            f3 = 0.0f;
            this.u.set(f3, f2, 0.0f, 0.0f);
            return this.u;
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
                return Math.max(1.0f, 1.0f / l(this.f29414b));
            }
            return 1.0f / l(this.f29414b);
        }
        return invokeL.floatValue;
    }

    public Matrix j(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, matrix)) == null) {
            this.l.set(this.f29414b);
            this.l.postConcat(matrix);
            return this.l;
        }
        return (Matrix) invokeL.objValue;
    }

    public void k(Drawable drawable, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, drawable, matrix) == null) {
            float f2 = this.n;
            float f3 = this.o;
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

    public float m(Matrix matrix, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, matrix, i)) == null) {
            matrix.getValues(this.m);
            return this.m[i];
        }
        return invokeLI.floatValue;
    }

    public void n(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, context, attributeSet, i) == null) {
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                int i7 = this.n;
                int i8 = this.o;
                int i9 = i3 - i;
                this.n = i9;
                int i10 = i4 - i2;
                this.o = i10;
                i5 = i9 - i7;
                i6 = i10 - i8;
                PointF pointF = this.p;
                pointF.x = i9 / 2.0f;
                pointF.y = i10 / 2.0f;
            } else {
                i5 = 0;
                i6 = 0;
            }
            Runnable runnable = this.f29418f;
            if (runnable != null) {
                this.f29418f = null;
                runnable.run();
            }
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (z || this.r || this.s) {
                    float l = l(this.f29414b);
                    float scale = getScale();
                    float min = Math.min(1.0f, 1.0f / l);
                    if (this.y) {
                        k(drawable, this.f29414b);
                    }
                    float l2 = l(this.f29414b);
                    if (this.s || this.r) {
                        Matrix matrix = this.f29416d;
                        if (matrix != null) {
                            this.f29415c.set(matrix);
                            this.f29416d = null;
                            r12 = getScale();
                        } else {
                            this.f29415c.reset();
                        }
                        setImageMatrix(getImageViewMatrix());
                        if (r12 != getScale()) {
                            z(r12);
                        }
                    } else if (z) {
                        if (!this.k) {
                            this.i = -1.0f;
                        }
                        if (!this.j) {
                            this.f29420h = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        v(-i5, -i6);
                        if (!this.f29419g) {
                            r12 = i(this.q);
                            z(r12);
                        } else {
                            r12 = ((double) Math.abs(scale - min)) > 0.001d ? (l / l2) * scale : 1.0f;
                            z(r12);
                        }
                    }
                    this.f29419g = false;
                    if (r12 > getMaxScale() || r12 < getMinScale()) {
                        z(r12);
                    }
                    a(true, true);
                    if (this.s) {
                        o(drawable);
                    }
                    if (z || this.s || this.r) {
                        q(i, i2, i3, i4);
                    }
                    if (this.r) {
                        this.r = false;
                    }
                    if (this.s) {
                        this.s = false;
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.s) {
                o(null);
            }
            if (z || this.s || this.r) {
                q(i, i2, i3, i4);
            }
            this.s = false;
            this.r = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void q(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) {
            f(i, i2, i3, i4);
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
            this.y = z;
        }
    }

    public void setDisplayType(DisplayType displayType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, displayType) == null) || displayType == this.q) {
            return;
        }
        this.f29419g = false;
        this.q = displayType;
        this.r = true;
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
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            setImageDrawable(getContext().getResources().getDrawable(i));
        }
    }

    public void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f2) == null) {
            this.f29420h = f2;
        }
    }

    public void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.i = f2;
        }
    }

    public void setOnDrawableChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            this.w = fVar;
        }
    }

    public void setOnLayoutChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, gVar) == null) {
            this.x = gVar;
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
            this.v.set((float) d2, (float) d3, 0.0f, 0.0f);
            y(bitmapRect, this.v);
            RectF rectF = this.v;
            v(rectF.left, rectF.top);
            a(true, true);
        }
    }

    public void u(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.f29415c.postScale(f2, f2, f3, f4);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 == 0.0f && f3 == 0.0f) {
                return;
            }
            this.f29415c.postTranslate(f2, f3);
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
            this.f29417e.post(new b(this, d2, System.currentTimeMillis(), f2, f3));
        }
    }

    public void y(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048626, this, rectF, rectF2) == null) || rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.o) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.n) {
            rectF2.left = 0.0f;
        }
        float f2 = rectF.top;
        if (rectF2.top + f2 >= 0.0f && rectF.bottom > this.o) {
            rectF2.top = (int) (0.0f - f2);
        }
        float f3 = rectF.bottom;
        int i = this.o;
        if (rectF2.top + f3 <= i + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i + 0) - f3);
        }
        float f4 = rectF.left;
        if (rectF2.left + f4 >= 0.0f) {
            rectF2.left = (int) (0.0f - f4);
        }
        float f5 = rectF.right;
        int i2 = this.n;
        if (rectF2.left + f5 <= i2 + 0) {
            rectF2.left = (int) ((i2 + 0) - f5);
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
                this.f29418f = new a(this, drawable, matrix, f2, f3);
            } else {
                d(drawable, matrix, f2, f3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new d(this);
        this.f29414b = new Matrix();
        this.f29415c = new Matrix();
        this.f29417e = new Handler();
        this.f29418f = null;
        this.f29419g = false;
        this.f29420h = -1.0f;
        this.i = -1.0f;
        this.l = new Matrix();
        this.m = new float[9];
        this.n = -1;
        this.o = -1;
        this.p = new PointF();
        this.q = DisplayType.NONE;
        this.t = new RectF();
        this.u = new RectF();
        this.v = new RectF();
        this.y = true;
        n(context, attributeSet, i);
    }
}
