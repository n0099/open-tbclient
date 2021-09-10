package c.a.p0.h.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.v2.k;
import c.a.p0.a.v2.q0;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11202b;

    /* renamed from: c  reason: collision with root package name */
    public static d f11203c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11204a;

    /* loaded from: classes3.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f11205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f11206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11207c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f11208d;

        public a(d dVar, File file, c.a.p0.a.v2.e1.b bVar, boolean z) {
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
            this.f11208d = dVar;
            this.f11205a = file;
            this.f11206b = bVar;
            this.f11207c = z;
        }

        @Override // c.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11206b.onCallback(Boolean.FALSE);
                this.f11208d.f11204a = this.f11207c;
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k = this.f11208d.k();
                if (k.exists()) {
                    c.a.p0.t.d.i(k);
                }
                boolean T = c.a.p0.t.d.T(this.f11205a.getAbsolutePath(), k.getAbsolutePath());
                if (T) {
                    this.f11208d.r();
                    Date date = new Date();
                    this.f11208d.q(k.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                c.a.p0.t.d.i(this.f11205a);
                this.f11206b.onCallback(Boolean.valueOf(T));
                this.f11208d.f11204a = this.f11207c;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f11209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f11210f;

        public b(d dVar, c.a.p0.a.v2.e1.b bVar) {
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
            this.f11210f = dVar;
            this.f11209e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11209e.onCallback(Boolean.valueOf(this.f11210f.n()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.p0.h.f.k.a {
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

        @Override // c.a.p0.h.f.k.a
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.m().k() : (File) invokeV.objValue;
        }

        @Override // c.a.p0.h.f.k.a
        public void b(@NonNull String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                d.m().q(str, j2);
            }
        }
    }

    /* renamed from: c.a.p0.h.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0569d implements c.a.p0.h.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f11211a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f11212b;

        /* renamed from: c.a.p0.h.f.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0569d f11213e;

            public a(C0569d c0569d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0569d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11213e = c0569d;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0569d c0569d = this.f11213e;
                    c0569d.f11211a.onCallback(Boolean.valueOf(c0569d.f11212b.n()));
                }
            }
        }

        public C0569d(d dVar, c.a.p0.a.v2.e1.b bVar) {
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
            this.f11212b = dVar;
            this.f11211a = bVar;
        }

        @Override // c.a.p0.h.f.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f11212b.r();
                q0.b0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158708624, "Lc/a/p0/h/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158708624, "Lc/a/p0/h/f/d;");
                return;
            }
        }
        f11202b = c.a.p0.a.k.f7077a;
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
        this.f11204a = f11202b && c.a.p0.a.u1.a.a.u();
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f11203c == null) {
                synchronized (d.class) {
                    if (f11203c == null) {
                        f11203c = new d();
                    }
                }
            }
            return f11203c;
        }
        return (d) invokeV.objValue;
    }

    public void c(String str, c.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) && f11202b) {
            boolean z = this.f11204a;
            this.f11204a = true;
            e.d dVar = new e.d();
            dVar.f4497a = str;
            File g2 = g();
            new c.a.p0.a.k0.a().e(dVar, g2.getAbsolutePath(), new a(this, g2, bVar, z));
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.a.k2.g.h.a().getLong("swan-game-sconsole-version-code", -1L) : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = c.a.p0.a.k2.g.h.a().getString("swan-game-sconsole-version-name", "");
            return !TextUtils.isEmpty(string) ? string : c.a.p0.t.d.D(l());
        }
        return (String) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(c.a.p0.h.s.a.d(), "game_core_console");
            if (f11202b && this.f11204a) {
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
                if (f11202b) {
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

    public void o(@NonNull c.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (f11202b && this.f11204a) {
                q0.b0(new b(this, bVar));
            } else {
                c.a.p0.n.b.e(new c.a.p0.n.i.m.a(e(), d()), new c.a.p0.h.f.j.a(new c(this), new C0569d(this, bVar)));
            }
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.U(c.a.p0.a.h.aiapps_debug_switch_title);
            aVar.v(c.a.p0.f.g.aiapps_sconsole_load_error);
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.m(false);
            aVar.O(c.a.p0.f.g.aiapps_ok, onClickListener);
            aVar.X();
        }
    }

    public void q(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j2) == null) {
            File l = l();
            if (l.exists()) {
                c.a.p0.t.d.i(l);
            }
            c.a.p0.a.k2.g.h.a().putString("swan-game-sconsole-version-name", str);
            c.a.p0.a.k2.g.h.a().putLong("swan-game-sconsole-version-code", j2);
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
            String C = c.a.p0.t.d.C(c.a.p0.a.c1.a.b(), "aigames/sConsole.html");
            if (C != null) {
                c.a.p0.t.d.M(String.format(C, format), h2);
            }
        }
    }
}
