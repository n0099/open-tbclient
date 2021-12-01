package c.a.p0.a.h2.b;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.n2.n;
import c.a.p0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static b f6213b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.n2.s.e f6214e;

        public a(c.a.p0.a.n2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6214e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.n2.b.k("4178", this.f6214e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.p0.a.n2.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: k  reason: collision with root package name */
        public String f6215k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7116e = this.f6215k;
                a("isAuthorized", this.l);
                a("isUserLogin", this.m);
                a("isCompleteLogin", this.n);
                a("isUserCertificated", this.o);
                a("isAuthorizeBtnConfirm", this.q);
                a("isCompleteCertificated", this.p);
                j.c(this);
            }
        }

        public b h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.q = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.l = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.p = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.n = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.o = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.m = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b n(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f6215k = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                j.e();
                g();
                j.f(this);
            }
        }

        public b() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1143978284, "Lc/a/p0/a/h2/b/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1143978284, "Lc/a/p0/a/h2/b/j;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
    }

    public static void c(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            bVar.a = n.n(c.a.p0.a.d2.d.J().r().V().G());
            bVar.f7113b = "trigger";
            bVar.f7118g = "multiAuthorize";
        }
    }

    public static synchronized b d() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (j.class) {
                if (f6213b == null) {
                    f6213b = new b(null);
                    boolean z = a;
                }
                bVar = f6213b;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (j.class) {
                f6213b = null;
            }
        }
    }

    public static void f(c.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, eVar) == null) {
            q.j(new a(eVar), "SwanAppUBCOnEvent");
        }
    }
}
