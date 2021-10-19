package c.p.a.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.i;
import c.p.a.a.a.c.k;
import c.p.a.a.a.c.q;
import c.p.a.a.a.c.u;
import c.p.a.d.b.c;
import c.p.a.d.b.l;
import c.p.a.d.c;
import c.p.a.d.d;
import c.p.a.d.h;
import c.p.a.e.b.a.a;
import c.p.a.e.b.f.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements c.p.a.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f fVar, c.p.a.a.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
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

    /* loaded from: classes4.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.p.a.e.b.f.j
        public boolean a(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadInfo)) == null) {
                c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
                if (d2.m("notification_opt_2") == 1) {
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.a(l.a(), downloadInfo, c.p.a.e.a.e.G().u(), c.p.a.e.b.g.a.H(l.a()).i(downloadInfo.getId()));
                    }
                    return true;
                }
                boolean d3 = d(downloadInfo);
                if (d2.b("disable_delete_dialog", 0) == 1) {
                    return true;
                }
                return d3;
            }
            return invokeL.booleanValue;
        }

        @Override // c.p.a.e.b.f.j
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.p.a.e.b.f.j
        public boolean c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo == null) {
                    return false;
                }
                c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 != null) {
                    c.d.a(c2);
                } else {
                    h.o.g(l.a(), downloadInfo.getPackageName());
                }
                c.p.a.e.b.p.b.a().m(downloadInfo.getId());
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean d(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadInfo)) == null) {
                u E = l.E();
                if (E != null) {
                    c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                    if (c2 != null && c2.c()) {
                        d2 = c.p.a.e.b.j.a.d(downloadInfo.getId()).h("ad_notification_jump_url", null);
                    } else {
                        d2 = c.p.a.d.b.j.d(downloadInfo);
                    }
                    if (TextUtils.isEmpty(d2)) {
                        return false;
                    }
                    return E.a(l.a(), d2);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.p.a.e.a.h.e.b("");
                if (c.p.a.e.a.h.e.r()) {
                    c.p.a.e.b.g.e.Z(true);
                }
                c.p.a.e.a.h.f.b(l.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a implements b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Runnable f34843a;

            public a(Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34843a = runnable;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.p.a.d.f.d.b
            /* renamed from: a */
            public Void b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f34843a.run();
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public interface b<T> {
            T b();
        }

        public static <T> T a(b<T> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) ? (T) b(true, null, bVar) : (T) invokeL.objValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public static <T> T b(boolean z, String str, @NonNull b<T> bVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), str, bVar})) == null) {
                try {
                    return bVar.b();
                } catch (Throwable th) {
                    if (!(th instanceof com.ss.android.downloadlib.e.a)) {
                        e.b().f(z, th, str);
                        if (TextUtils.isEmpty(str)) {
                            throw th;
                        }
                        return null;
                    }
                    throw th;
                }
            }
            return (T) invokeCommon.objValue;
        }

        public static void c(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
                a(new a(runnable));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.p.a.a.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static e f34844a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1182965895, "Lc/p/a/d/f$e$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1182965895, "Lc/p/a/d/f$e$a;");
                        return;
                    }
                }
                f34844a = new e();
            }
        }

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

        public static e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f34844a : (e) invokeV.objValue;
        }

        public static String c(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
                try {
                    return Log.getStackTraceString(th);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // c.p.a.a.a.e.a
        public void a(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                f(true, th, str);
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                e(true, str);
            }
        }

        public void e(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) || j()) {
                return;
            }
            if (z) {
                h(new RuntimeException(str));
            }
            JSONObject jSONObject = new JSONObject();
            h.r.q(jSONObject, "msg", str);
            h.r.q(jSONObject, "stack", c(new Throwable()));
            l.u().a("service_ttdownloader", 2, jSONObject);
        }

        public void f(boolean z, Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), th, str}) == null) || j()) {
                return;
            }
            if (th == null) {
                th = new Throwable();
            }
            if (z) {
                h(th);
            }
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                str = th.getMessage();
            }
            h.r.q(jSONObject, "msg", str);
            h.r.q(jSONObject, "stack", Log.getStackTraceString(th));
            l.u().a("service_ttdownloader", 1, jSONObject);
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                i(true, str);
            }
        }

        public final void h(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, th) == null) && c.p.a.e.a.h.f.e(l.a())) {
                throw new com.ss.android.downloadlib.e.a(th);
            }
        }

        public void i(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) || j()) {
                return;
            }
            if (z) {
                h(new RuntimeException(str));
            }
            JSONObject jSONObject = new JSONObject();
            h.r.q(jSONObject, "msg", str);
            h.r.q(jSONObject, "stack", c(new Throwable()));
            l.u().a("service_ttdownloader", 3, jSONObject);
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l.v().optInt(CyberCfgManager.KEY_INT_ENABLE_MONITOR, 1) != 1 : invokeV.booleanValue;
        }
    }

    public f() {
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

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b a(@NonNull c.p.a.a.a.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            l.d(fVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b b(@NonNull c.p.a.a.a.c.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            l.e(gVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b c(@NonNull c.p.a.a.a.c.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
            l.f(hVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b d(@NonNull i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) {
            l.g(iVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b e(@NonNull k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kVar)) == null) {
            l.h(kVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b f(c.p.a.e.b.g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar.A() == null) {
                bVar.H(new b(this));
            }
            bVar.a(new d.f());
            c.p.a.e.b.g.a.I(bVar, true);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b g(@NonNull c.p.a.a.a.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            l.c(bVar);
            c.p.a.e.b.a.a.c().g(new a(this, bVar));
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b h(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, qVar)) == null) {
            l.i(qVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b i(@NonNull c.p.a.a.a.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            l.k(aVar);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public c.p.a.a.a.b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            l.l(str);
            return this;
        }
        return (c.p.a.a.a.b) invokeL.objValue;
    }

    @Override // c.p.a.a.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!l.I()) {
                e.b().d("ttdownloader init error");
            }
            l.j(e.b());
            try {
                c.p.a.e.a.e.G().x(l.H());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.a.e.G().p(c.p.a.d.a.d());
            c.p.a.d.e.a().f(new c(this));
        }
    }
}
