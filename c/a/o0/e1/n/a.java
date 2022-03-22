package c.a.o0.e1.n;

import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
    public float f10146b;

    /* renamed from: c  reason: collision with root package name */
    public int f10147c;

    /* renamed from: d  reason: collision with root package name */
    public int f10148d;

    /* renamed from: e  reason: collision with root package name */
    public float f10149e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10150f;

    /* renamed from: g  reason: collision with root package name */
    public int f10151g;

    /* renamed from: h  reason: collision with root package name */
    public int f10152h;
    public int i;
    public int j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(277032566, "Lc/a/o0/e1/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(277032566, "Lc/a/o0/e1/n/a;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.f10146b = 0.0f;
        this.f10147c = 0;
        this.f10148d = 0;
        this.f10149e = 15.0f;
        this.f10150f = false;
        this.f10151g = -1;
        this.f10152h = -1;
        this.i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.v = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.x = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.y = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.z = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
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
            this.f10146b = aVar.f10146b;
            this.f10147c = aVar.f10147c;
            this.f10148d = aVar.f10148d;
            this.f10149e = aVar.f10149e;
            this.f10151g = aVar.f10151g;
            this.f10152h = aVar.f10152h;
            this.i = aVar.i;
            this.j = aVar.j;
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
            this.C = aVar.f10148d;
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
            this.f10148d = typedArray.getDimensionPixelSize(6, 0);
            this.f10147c = typedArray.getDimensionPixelSize(10, 0);
            this.a = typedArray.getFloat(8, 1.12f);
            this.f10149e = typedArray.getDimensionPixelSize(11, (int) this.f10149e);
            this.i = typedArray.getColor(9, this.i);
            this.j = typedArray.getDimensionPixelSize(5, this.j);
            this.k = typedArray.getDimensionPixelSize(4, this.k);
            this.l = typedArray.getResourceId(0, 0);
            this.f10151g = typedArray.getDimensionPixelSize(2, this.f10151g);
            this.f10152h = typedArray.getDimensionPixelSize(1, this.f10152h);
            this.m = typedArray.getResourceId(12, 0);
            this.n = typedArray.getBoolean(7, false);
            this.C = this.f10148d;
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

    public int[] e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i, i2, i3, i4)) == null) {
            int[] l = n.l(i, i2, i3, i4);
            if (l == null) {
                return null;
            }
            int[] iArr = {l[0], l[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (this.s && i3 > i5) {
                float f2 = J;
                if (f2 > 1.0f) {
                    float f3 = i5;
                    float f4 = i3;
                    if (f3 * f2 <= f4) {
                        float f5 = f4 * 0.68f;
                        i3 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i6 = (iArr[1] * i3) / iArr[0];
                    }
                    i5 = i3;
                }
            }
            return new int[]{i5, i6};
        }
        return (int[]) invokeIIII.objValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.v = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.l = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.E = i;
        }
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.f10151g = i;
            this.f10152h = i2;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.D = i;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.B = i;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.C = i;
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
            this.f10146b = f2;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.k = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void r(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            this.t = i;
            this.u = i2;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.f10148d = i;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.q = true;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.z = i;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.f10149e = i;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.F = z;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.m = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.A = i;
        }
    }

    public a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.f10146b = 0.0f;
        this.f10147c = 0;
        this.f10148d = 0;
        this.f10149e = 15.0f;
        this.f10150f = false;
        this.f10151g = -1;
        this.f10152h = -1;
        this.i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.v = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.x = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.y = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.z = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
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
