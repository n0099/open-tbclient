package c.a.d.f.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static h f2409h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<BasicNameValuePair> f2410b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f2411c;

    /* renamed from: d  reason: collision with root package name */
    public String f2412d;

    /* renamed from: e  reason: collision with root package name */
    public i f2413e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f2414f;

    /* renamed from: g  reason: collision with root package name */
    public g f2415g;

    /* loaded from: classes.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // c.a.d.f.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a(str);
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.f2413e = null;
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).b(i, str);
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).c(cVar);
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).d(bArr);
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).e();
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).f(kVar);
                }
            }
        }

        @Override // c.a.d.f.r.g
        public void g(int i, c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, cVar) == null) || cVar == null) {
                return;
            }
            cVar.a(i);
        }

        @Override // c.a.d.f.r.g
        public void h(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null) {
                return;
            }
            cVar.c();
        }

        @Override // c.a.d.f.r.g
        public void i(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null) {
                return;
            }
            cVar.b();
        }

        @Override // c.a.d.f.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f2414f.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).onOpen(map);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-502429430, "Lc/a/d/f/r/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-502429430, "Lc/a/d/f/r/h;");
        }
    }

    public h() {
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
        this.a = null;
        this.f2410b = null;
        this.f2412d = null;
        this.f2413e = null;
        this.f2414f = new ArrayList<>();
        this.f2415g = null;
        this.f2415g = new a(this);
    }

    public static h j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f2409h == null) {
                synchronized (h.class) {
                    if (f2409h == null) {
                        f2409h = new h();
                    }
                }
            }
            return f2409h;
        }
        return (h) invokeV.objValue;
    }

    public boolean c(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar != null) {
                synchronized (h.class) {
                    if (this.f2414f.contains(gVar)) {
                        return false;
                    }
                    return this.f2414f.add(gVar);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iVar = this.f2413e) == null) {
            return;
        }
        iVar.o();
    }

    public void e() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f2413e) == null) {
            return;
        }
        iVar.p();
    }

    public void f(int i, String str) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (iVar = this.f2413e) == null) {
            return;
        }
        this.f2413e = null;
        iVar.q(i, str);
        if (this.f2413e != null) {
            BdLog.e("close is opened and thread is leaded!!!");
            this.f2413e = null;
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (t()) {
                c.a.d.f.p.n.c();
            }
            i iVar = this.f2413e;
            return (iVar == null || !iVar.E() || this.f2413e.F()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                c.a.d.f.p.n.c();
            }
            i iVar = this.f2413e;
            return iVar != null && iVar.E();
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            i iVar = this.f2413e;
            if (iVar != null) {
                return iVar.y();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.f2412d = str2;
            this.f2411c = strArr;
            this.f2410b = list;
            t();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (t()) {
                c.a.d.f.p.n.c();
            }
            i iVar = this.f2413e;
            return iVar != null && iVar.C();
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? BdBaseApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (t()) {
                c.a.d.f.p.n.c();
            }
            i iVar = this.f2413e;
            if (iVar != null) {
                if (!iVar.C() && !this.f2413e.E()) {
                    this.f2413e.q(1, null);
                    this.f2413e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.f2413e = new i();
            try {
                d0 d0Var = new d0();
                d0Var.j(this.f2412d);
                this.f2413e.r(this.a, this.f2411c, this.f2415g, d0Var, this.f2410b);
                return true;
            } catch (WebSocketException unused) {
                this.f2413e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cVar)) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return false;
                }
                c.a.d.f.p.n.c();
                if (this.f2413e != null) {
                    return this.f2413e.I(cVar);
                }
                if (cVar != null) {
                    cVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void w(List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.f2410b = list;
        }
    }
}
