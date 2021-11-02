package b.a.p0.h.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.v2.k;
import b.a.p0.a.v2.q0;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10408b;

    /* renamed from: c  reason: collision with root package name */
    public static d f10409c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10410a;

    /* loaded from: classes4.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f10411a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f10412b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f10413c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f10414d;

        public a(d dVar, File file, b.a.p0.a.v2.e1.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, file, bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10414d = dVar;
            this.f10411a = file;
            this.f10412b = bVar;
            this.f10413c = z;
        }

        @Override // b.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10412b.onCallback(Boolean.FALSE);
                this.f10414d.f10410a = this.f10413c;
            }
        }

        @Override // b.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // b.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k = this.f10414d.k();
                if (k.exists()) {
                    b.a.p0.t.d.i(k);
                }
                boolean T = b.a.p0.t.d.T(this.f10411a.getAbsolutePath(), k.getAbsolutePath());
                if (T) {
                    this.f10414d.r();
                    Date date = new Date();
                    this.f10414d.q(k.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                b.a.p0.t.d.i(this.f10411a);
                this.f10412b.onCallback(Boolean.valueOf(T));
                this.f10414d.f10410a = this.f10413c;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f10415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f10416f;

        public b(d dVar, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10416f = dVar;
            this.f10415e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10415e.onCallback(Boolean.valueOf(this.f10416f.n()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.p0.h.f.k.a {
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

        @Override // b.a.p0.h.f.k.a
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.m().k() : (File) invokeV.objValue;
        }

        @Override // b.a.p0.h.f.k.a
        public void b(@NonNull String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                d.m().q(str, j);
            }
        }
    }

    /* renamed from: b.a.p0.h.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0564d implements b.a.p0.h.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f10417a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f10418b;

        /* renamed from: b.a.p0.h.f.d$d$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0564d f10419e;

            public a(C0564d c0564d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0564d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10419e = c0564d;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0564d c0564d = this.f10419e;
                    c0564d.f10417a.onCallback(Boolean.valueOf(c0564d.f10418b.n()));
                }
            }
        }

        public C0564d(d dVar, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10418b = dVar;
            this.f10417a = bVar;
        }

        @Override // b.a.p0.h.f.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f10418b.r();
                q0.b0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865305617, "Lb/a/p0/h/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865305617, "Lb/a/p0/h/f/d;");
                return;
            }
        }
        f10408b = b.a.p0.a.k.f6397a;
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
        this.f10410a = f10408b && b.a.p0.a.u1.a.a.u();
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f10409c == null) {
                synchronized (d.class) {
                    if (f10409c == null) {
                        f10409c = new d();
                    }
                }
            }
            return f10409c;
        }
        return (d) invokeV.objValue;
    }

    public void c(String str, b.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) && f10408b) {
            boolean z = this.f10410a;
            this.f10410a = true;
            e.d dVar = new e.d();
            dVar.f3902a = str;
            File g2 = g();
            new b.a.p0.a.k0.a().e(dVar, g2.getAbsolutePath(), new a(this, g2, bVar, z));
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.p0.a.k2.g.h.a().getLong("swan-game-sconsole-version-code", -1L) : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = b.a.p0.a.k2.g.h.a().getString("swan-game-sconsole-version-name", "");
            return !TextUtils.isEmpty(string) ? string : b.a.p0.t.d.D(l());
        }
        return (String) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(b.a.p0.h.s.a.d(), "game_core_console");
            if (f10408b && this.f10410a) {
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
                if (f10408b) {
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

    public void o(@NonNull b.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (f10408b && this.f10410a) {
                q0.b0(new b(this, bVar));
            } else {
                b.a.p0.n.b.e(new b.a.p0.n.i.m.a(e(), d()), new b.a.p0.h.f.j.a(new c(this), new C0564d(this, bVar)));
            }
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.U(b.a.p0.a.h.aiapps_debug_switch_title);
            aVar.v(b.a.p0.f.g.aiapps_sconsole_load_error);
            aVar.n(new b.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(b.a.p0.f.g.aiapps_ok, onClickListener);
            aVar.X();
        }
    }

    public void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            File l = l();
            if (l.exists()) {
                b.a.p0.t.d.i(l);
            }
            b.a.p0.a.k2.g.h.a().putString("swan-game-sconsole-version-name", str);
            b.a.p0.a.k2.g.h.a().putLong("swan-game-sconsole-version-code", j);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            File j = j();
            File h2 = h();
            if (h2.exists() || !j.exists()) {
                return;
            }
            String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
            String C = b.a.p0.t.d.C(b.a.p0.a.c1.a.b(), "aigames/sConsole.html");
            if (C != null) {
                b.a.p0.t.d.M(String.format(C, format), h2);
            }
        }
    }
}
