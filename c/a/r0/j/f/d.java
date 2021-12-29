package c.a.r0.j.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.z2.k;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.Date;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11223b;

    /* renamed from: c  reason: collision with root package name */
    public static d f11224c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f11225b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11226c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f11227d;

        public a(d dVar, File file, c.a.r0.a.z2.g1.c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, file, cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11227d = dVar;
            this.a = file;
            this.f11225b = cVar;
            this.f11226c = z;
        }

        @Override // c.a.r0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11225b.onCallback(Boolean.FALSE);
                this.f11227d.a = this.f11226c;
            }
        }

        @Override // c.a.r0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.r0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k2 = this.f11227d.k();
                if (k2.exists()) {
                    c.a.r0.w.d.j(k2);
                }
                boolean U = c.a.r0.w.d.U(this.a.getAbsolutePath(), k2.getAbsolutePath());
                if (U) {
                    this.f11227d.r();
                    Date date = new Date();
                    this.f11227d.q(k.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                c.a.r0.w.d.j(this.a);
                this.f11225b.onCallback(Boolean.valueOf(U));
                this.f11227d.a = this.f11226c;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f11228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f11229f;

        public b(d dVar, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11229f = dVar;
            this.f11228e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11228e.onCallback(Boolean.valueOf(this.f11229f.n()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.r0.j.f.k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.j.f.k.a
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.m().k() : (File) invokeV.objValue;
        }

        @Override // c.a.r0.j.f.k.a
        public void b(@NonNull String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                d.m().q(str, j2);
            }
        }
    }

    /* renamed from: c.a.r0.j.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0736d implements c.a.r0.j.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.z2.g1.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f11230b;

        /* renamed from: c.a.r0.j.f.d$d$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0736d f11231e;

            public a(C0736d c0736d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0736d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11231e = c0736d;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0736d c0736d = this.f11231e;
                    c0736d.a.onCallback(Boolean.valueOf(c0736d.f11230b.n()));
                }
            }
        }

        public C0736d(d dVar, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11230b = dVar;
            this.a = cVar;
        }

        @Override // c.a.r0.j.f.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f11230b.r();
                q0.e0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421391952, "Lc/a/r0/j/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421391952, "Lc/a/r0/j/f/d;");
                return;
            }
        }
        f11223b = c.a.r0.a.k.a;
    }

    public d() {
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
        this.a = f11223b && c.a.r0.a.x1.a.a.v();
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f11224c == null) {
                synchronized (d.class) {
                    if (f11224c == null) {
                        f11224c = new d();
                    }
                }
            }
            return f11224c;
        }
        return (d) invokeV.objValue;
    }

    public void c(String str, c.a.r0.a.z2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && f11223b) {
            boolean z = this.a;
            this.a = true;
            d.C0251d c0251d = new d.C0251d();
            c0251d.a = str;
            File g2 = g();
            new c.a.r0.a.k0.b().e(c0251d, g2.getAbsolutePath(), new a(this, g2, cVar, z));
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.r0.a.o2.g.h.a().getLong("swan-game-sconsole-version-code", -1L) : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = c.a.r0.a.o2.g.h.a().getString("swan-game-sconsole-version-name", "");
            return !TextUtils.isEmpty(string) ? string : c.a.r0.w.d.E(l());
        }
        return (String) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(c.a.r0.j.t.a.d(), "game_core_console");
            if (f11223b && this.a) {
                file = new File(file, "debug");
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public final File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new File(f(), "debugGameSconsole.zip") : (File) invokeV.objValue;
    }

    public final File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new File(f(), "swan-game-sconsole.html") : (File) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return h().toURI().toURL().toString();
            } catch (Exception e2) {
                if (f11223b) {
                    String str = "getGameConsoleHtmlUrl:" + e2;
                    return "";
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new File(k(), "swan-game-sconsole.js") : (File) invokeV.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new File(f(), UriUtil.LOCAL_RESOURCE_SCHEME) : (File) invokeV.objValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new File(k(), "swan-game-sconsole.version") : (File) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? j().exists() && h().exists() : invokeV.booleanValue;
    }

    public void o(@NonNull c.a.r0.a.z2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            if (f11223b && this.a) {
                q0.e0(new b(this, cVar));
            } else {
                c.a.r0.q.b.g(new c.a.r0.q.j.m.b(e(), d()), new c.a.r0.j.f.j.a(new c(this), new C0736d(this, cVar)));
            }
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.U(c.a.r0.a.h.aiapps_debug_switch_title);
            aVar.v(c.a.r0.h.g.aiapps_sconsole_load_error);
            aVar.n(new c.a.r0.a.a3.h.a());
            aVar.m(false);
            aVar.O(c.a.r0.h.g.aiapps_ok, onClickListener);
            aVar.X();
        }
    }

    public void q(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j2) == null) {
            File l = l();
            if (l.exists()) {
                c.a.r0.w.d.j(l);
            }
            c.a.r0.a.o2.g.h.a().putString("swan-game-sconsole-version-name", str);
            c.a.r0.a.o2.g.h.a().putLong("swan-game-sconsole-version-code", j2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            File j2 = j();
            File h2 = h();
            if (h2.exists() || !j2.exists()) {
                return;
            }
            String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
            String D = c.a.r0.w.d.D(c.a.r0.a.c1.a.c(), "aigames/sConsole.html");
            if (D != null) {
                c.a.r0.w.d.N(String.format(D, format), h2);
            }
        }
    }
}
