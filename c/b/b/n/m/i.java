package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.v;
import c.b.b.q.w;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
/* loaded from: classes7.dex */
public class i implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic = null;
    public static String w = "";
    public static String x = "";
    public static final w<Application, c.b.b.q.a<i>> y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f27729e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27730f;

    /* renamed from: g  reason: collision with root package name */
    public final v<String> f27731g;

    /* renamed from: h  reason: collision with root package name */
    public final v<String> f27732h;

    /* renamed from: i  reason: collision with root package name */
    public final v<String> f27733i;

    /* renamed from: j  reason: collision with root package name */
    public String[] f27734j;

    /* renamed from: k  reason: collision with root package name */
    public final v<String> f27735k;
    public final v<String> l;
    public final v<String> m;
    public String[] n;
    public int o;
    public int p;
    public int q;
    public final String r;
    public final String s;
    public boolean t;
    public IntBuffer u;
    public IntBuffer v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339287975, "Lc/b/b/n/m/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339287975, "Lc/b/b/n/m/i;");
                return;
            }
        }
        y = new w<>();
        BufferUtils.d(1);
    }

    public i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27729e = "";
        this.f27731g = new v<>();
        this.f27732h = new v<>();
        this.f27733i = new v<>();
        this.f27735k = new v<>();
        this.l = new v<>();
        this.m = new v<>();
        this.u = BufferUtils.d(1);
        this.v = BufferUtils.d(1);
        if (str == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        }
        if (str2 != null) {
            String str3 = w;
            if (str3 != null && str3.length() > 0) {
                str = w + str;
            }
            String str4 = x;
            if (str4 != null && str4.length() > 0) {
                str2 = x + str2;
            }
            this.r = str;
            this.s = str2;
            BufferUtils.c(16);
            h(str, str2);
            if (o()) {
                j();
                k();
                a(c.b.b.f.a, this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("fragment shader must not be null");
    }

    public static void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, application) == null) {
            y.k(application);
        }
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed shaders/app: { ");
            w.c<Application> f2 = y.f();
            f2.d();
            while (f2.hasNext()) {
                sb.append(y.c(f2.next()).f27768f);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void n(Application application) {
        c.b.b.q.a<i> c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, application) == null) || c.b.b.f.f27324f == null || (c2 = y.c(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < c2.f27768f; i2++) {
            c2.get(i2).t = true;
            c2.get(i2).f();
        }
    }

    public final void a(Application application, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, application, iVar) == null) {
            c.b.b.q.a<i> c2 = y.c(application);
            if (c2 == null) {
                c2 = new c.b.b.q.a<>();
            }
            c2.a(iVar);
            y.i(application, c2);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27324f;
            cVar.d(0);
            cVar.K(this.p);
            cVar.K(this.q);
            cVar.H(this.o);
            if (y.c(c.b.b.f.a) != null) {
                y.c(c.b.b.f.a).i(this, true);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.t) {
            h(this.r, this.s);
            this.t = false;
        }
    }

    public final void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.p = q(35633, str);
            int q = q(35632, str2);
            this.q = q;
            if (this.p != -1 && q != -1) {
                int p = p(i());
                this.o = p;
                if (p == -1) {
                    this.f27730f = false;
                    return;
                } else {
                    this.f27730f = true;
                    return;
                }
            }
            this.f27730f = false;
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int M = c.b.b.f.f27324f.M();
            if (M != 0) {
                return M;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u.clear();
            c.b.b.f.f27324f.l(this.o, 35721, this.u);
            int i2 = this.u.get(0);
            this.n = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.u.clear();
                this.u.put(0, 1);
                this.v.clear();
                String D = c.b.b.f.f27324f.D(this.o, i3, this.u, this.v);
                this.f27735k.h(D, c.b.b.f.f27324f.R(this.o, D));
                this.l.h(D, this.v.get(0));
                this.m.h(D, this.u.get(0));
                this.n[i3] = D;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u.clear();
            c.b.b.f.f27324f.l(this.o, 35718, this.u);
            int i2 = this.u.get(0);
            this.f27734j = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.u.clear();
                this.u.put(0, 1);
                this.v.clear();
                String z = c.b.b.f.f27324f.z(this.o, i3, this.u, this.v);
                this.f27731g.h(z, c.b.b.f.f27324f.w(this.o, z));
                this.f27732h.h(z, this.v.get(0));
                this.f27733i.h(z, this.u.get(0));
                this.f27734j[i3] = z;
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27730f) {
                String J = c.b.b.f.f27324f.J(this.o);
                this.f27729e = J;
                return J;
            }
            return this.f27729e;
        }
        return (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27730f : invokeV.booleanValue;
    }

    public final int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27324f;
            if (i2 == -1) {
                return -1;
            }
            cVar.L(i2, this.p);
            cVar.L(i2, this.q);
            cVar.G(i2);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
            allocateDirect.order(ByteOrder.nativeOrder());
            IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
            cVar.l(i2, 35714, asIntBuffer);
            if (asIntBuffer.get(0) == 0) {
                this.f27729e = c.b.b.f.f27324f.J(i2);
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final int q(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, str)) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27324f;
            IntBuffer d2 = BufferUtils.d(1);
            int T = cVar.T(i2);
            if (T == 0) {
                return -1;
            }
            cVar.y(T, str);
            cVar.s(T);
            cVar.I(T, 35713, d2);
            if (d2.get(0) == 0) {
                String x2 = cVar.x(T);
                StringBuilder sb = new StringBuilder();
                sb.append(this.f27729e);
                sb.append(i2 == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
                this.f27729e = sb.toString();
                this.f27729e += x2;
                return -1;
            }
            return T;
        }
        return invokeIL.intValue;
    }
}
