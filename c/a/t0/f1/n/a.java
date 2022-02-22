package c.a.t0.f1.n;

import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.a4.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final float J;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public TbImageView.h I;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f13007b;

    /* renamed from: c  reason: collision with root package name */
    public int f13008c;

    /* renamed from: d  reason: collision with root package name */
    public int f13009d;

    /* renamed from: e  reason: collision with root package name */
    public float f13010e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13011f;

    /* renamed from: g  reason: collision with root package name */
    public int f13012g;

    /* renamed from: h  reason: collision with root package name */
    public int f13013h;

    /* renamed from: i  reason: collision with root package name */
    public int f13014i;

    /* renamed from: j  reason: collision with root package name */
    public int f13015j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public ImageView.ScaleType p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(181968722, "Lc/a/t0/f1/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(181968722, "Lc/a/t0/f1/n/a;");
                return;
            }
        }
        J = n.h(TbadkCoreApplication.getInst());
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.f13007b = 0.0f;
        this.f13008c = 0;
        this.f13009d = 0;
        this.f13010e = 15.0f;
        this.f13011f = false;
        this.f13012g = -1;
        this.f13013h = -1;
        this.f13014i = -16777216;
        this.f13015j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds16);
        this.u = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds20);
        this.v = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.tbds18);
        this.w = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_H_X004);
        this.x = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_W_X003);
        this.y = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_H_X006);
        this.z = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds20);
        this.A = 0;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = 0;
        this.F = false;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.a = aVar.a;
            this.f13007b = aVar.f13007b;
            this.f13008c = aVar.f13008c;
            this.f13009d = aVar.f13009d;
            this.f13010e = aVar.f13010e;
            this.f13012g = aVar.f13012g;
            this.f13013h = aVar.f13013h;
            this.f13014i = aVar.f13014i;
            this.f13015j = aVar.f13015j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.r = aVar.r;
            this.o = aVar.o;
            this.q = aVar.q;
            this.s = aVar.s;
            this.t = aVar.t;
            this.u = aVar.u;
            this.z = aVar.z;
            this.A = aVar.A;
            this.B = aVar.B;
            this.C = aVar.f13009d;
            this.D = aVar.D;
            this.w = aVar.w;
            this.x = aVar.x;
            this.y = aVar.y;
            this.F = aVar.F;
        }
    }

    public void b(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typedArray) == null) {
            this.f13009d = typedArray.getDimensionPixelSize(l.TbRichTextView_segmentMargin, 0);
            this.f13008c = typedArray.getDimensionPixelSize(l.TbRichTextView_textPadding, 0);
            this.a = typedArray.getFloat(l.TbRichTextView_tbLineSpacing, 1.12f);
            this.f13010e = typedArray.getDimensionPixelSize(l.TbRichTextView_textSize, (int) this.f13010e);
            this.f13014i = typedArray.getColor(l.TbRichTextView_textColor, this.f13014i);
            this.f13015j = typedArray.getDimensionPixelSize(l.TbRichTextView_maxImageWidth, this.f13015j);
            this.k = typedArray.getDimensionPixelSize(l.TbRichTextView_maxImageHeight, this.k);
            this.l = typedArray.getResourceId(l.TbRichTextView_defaultImage, 0);
            this.f13012g = typedArray.getDimensionPixelSize(l.TbRichTextView_faceWidth, this.f13012g);
            this.f13013h = typedArray.getDimensionPixelSize(l.TbRichTextView_faceHeight, this.f13013h);
            this.m = typedArray.getResourceId(l.TbRichTextView_videoImage, 0);
            this.n = typedArray.getBoolean(l.TbRichTextView_singleLine, false);
            this.C = this.f13009d;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public int[] e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i2, i3, i4, i5)) == null) {
            int[] l = n.l(i2, i3, i4, i5);
            if (l == null) {
                return null;
            }
            int[] iArr = {l[0], l[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.s && i4 > i6) {
                float f2 = J;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 <= f4) {
                        float f5 = f4 * 0.68f;
                        i4 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i4) / iArr[0];
                    }
                    i6 = i4;
                }
            }
            return new int[]{i6, i7};
        }
        return (int[]) invokeIIII.objValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.v = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.E = i2;
        }
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.f13012g = i2;
            this.f13013h = i3;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.D = i2;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.B = i2;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.C = i2;
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.a = f2;
        }
    }

    public void o(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.a = f3;
            this.f13007b = f2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.k = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f13015j = i2;
        }
    }

    public void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            this.t = i2;
            this.u = i3;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f13009d = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.q = true;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.z = i2;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f13010e = i2;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.F = z;
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.m = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.A = i2;
        }
    }

    public a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.f13007b = 0.0f;
        this.f13008c = 0;
        this.f13009d = 0;
        this.f13010e = 15.0f;
        this.f13011f = false;
        this.f13012g = -1;
        this.f13013h = -1;
        this.f13014i = -16777216;
        this.f13015j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds16);
        this.u = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds20);
        this.v = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.tbds18);
        this.w = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_H_X004);
        this.x = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_W_X003);
        this.y = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.M_H_X006);
        this.z = n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a4.e.ds20);
        this.A = 0;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = 0;
        this.F = false;
        if (aVar != null) {
            a(aVar);
        }
    }
}
