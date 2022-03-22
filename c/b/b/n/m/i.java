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
/* loaded from: classes3.dex */
public class i implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic = null;
    public static String s = "";
    public static String t = "";
    public static final w<Application, c.b.b.q.a<i>> u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22684b;

    /* renamed from: c  reason: collision with root package name */
    public final v<String> f22685c;

    /* renamed from: d  reason: collision with root package name */
    public final v<String> f22686d;

    /* renamed from: e  reason: collision with root package name */
    public final v<String> f22687e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f22688f;

    /* renamed from: g  reason: collision with root package name */
    public final v<String> f22689g;

    /* renamed from: h  reason: collision with root package name */
    public final v<String> f22690h;
    public final v<String> i;
    public String[] j;
    public int k;
    public int l;
    public int m;
    public final String n;
    public final String o;
    public boolean p;
    public IntBuffer q;
    public IntBuffer r;

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
        u = new w<>();
        BufferUtils.d(1);
    }

    public i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f22685c = new v<>();
        this.f22686d = new v<>();
        this.f22687e = new v<>();
        this.f22689g = new v<>();
        this.f22690h = new v<>();
        this.i = new v<>();
        this.q = BufferUtils.d(1);
        this.r = BufferUtils.d(1);
        if (str == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        }
        if (str2 != null) {
            String str3 = s;
            if (str3 != null && str3.length() > 0) {
                str = s + str;
            }
            String str4 = t;
            if (str4 != null && str4.length() > 0) {
                str2 = t + str2;
            }
            this.n = str;
            this.o = str2;
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
            u.k(application);
        }
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed shaders/app: { ");
            w.c<Application> f2 = u.f();
            f2.d();
            while (f2.hasNext()) {
                sb.append(u.c(f2.next()).f22717b);
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
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, application) == null) || c.b.b.f.f22335f == null || (c2 = u.c(application)) == null) {
            return;
        }
        for (int i = 0; i < c2.f22717b; i++) {
            c2.get(i).p = true;
            c2.get(i).f();
        }
    }

    public final void a(Application application, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, application, iVar) == null) {
            c.b.b.q.a<i> c2 = u.c(application);
            if (c2 == null) {
                c2 = new c.b.b.q.a<>();
            }
            c2.a(iVar);
            u.i(application, c2);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            cVar.d(0);
            cVar.K(this.l);
            cVar.K(this.m);
            cVar.H(this.k);
            if (u.c(c.b.b.f.a) != null) {
                u.c(c.b.b.f.a).j(this, true);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.p) {
            h(this.n, this.o);
            this.p = false;
        }
    }

    public final void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.l = q(35633, str);
            int q = q(35632, str2);
            this.m = q;
            if (this.l != -1 && q != -1) {
                int p = p(i());
                this.k = p;
                if (p == -1) {
                    this.f22684b = false;
                    return;
                } else {
                    this.f22684b = true;
                    return;
                }
            }
            this.f22684b = false;
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int M = c.b.b.f.f22335f.M();
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
            this.q.clear();
            c.b.b.f.f22335f.l(this.k, 35721, this.q);
            int i = this.q.get(0);
            this.j = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.q.clear();
                this.q.put(0, 1);
                this.r.clear();
                String D = c.b.b.f.f22335f.D(this.k, i2, this.q, this.r);
                this.f22689g.h(D, c.b.b.f.f22335f.R(this.k, D));
                this.f22690h.h(D, this.r.get(0));
                this.i.h(D, this.q.get(0));
                this.j[i2] = D;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q.clear();
            c.b.b.f.f22335f.l(this.k, 35718, this.q);
            int i = this.q.get(0);
            this.f22688f = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.q.clear();
                this.q.put(0, 1);
                this.r.clear();
                String z = c.b.b.f.f22335f.z(this.k, i2, this.q, this.r);
                this.f22685c.h(z, c.b.b.f.f22335f.w(this.k, z));
                this.f22686d.h(z, this.r.get(0));
                this.f22687e.h(z, this.q.get(0));
                this.f22688f[i2] = z;
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22684b) {
                String J = c.b.b.f.f22335f.J(this.k);
                this.a = J;
                return J;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22684b : invokeV.booleanValue;
    }

    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            if (i == -1) {
                return -1;
            }
            cVar.L(i, this.l);
            cVar.L(i, this.m);
            cVar.G(i);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
            allocateDirect.order(ByteOrder.nativeOrder());
            IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
            cVar.l(i, 35714, asIntBuffer);
            if (asIntBuffer.get(0) == 0) {
                this.a = c.b.b.f.f22335f.J(i);
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final int q(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, str)) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            IntBuffer d2 = BufferUtils.d(1);
            int T = cVar.T(i);
            if (T == 0) {
                return -1;
            }
            cVar.y(T, str);
            cVar.s(T);
            cVar.I(T, 35713, d2);
            if (d2.get(0) == 0) {
                String x = cVar.x(T);
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(i == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
                this.a = sb.toString();
                this.a += x;
                return -1;
            }
            return T;
        }
        return invokeIL.intValue;
    }
}
