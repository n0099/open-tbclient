package c.a.n0.a.a1;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.e0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.r0;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3854e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.n.f a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f3855b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.x.g.d f3856c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3857d;

    /* renamed from: c.a.n0.a.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0214a implements c.a.n0.n.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0214a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.n.e
        public boolean b(View view, c.a.n0.n.g gVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, gVar)) == null) ? this.a.v(gVar) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a.f();
                this.a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a.f();
                this.a.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.a.f();
                return this.a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.g0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.g0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.f3857d, R.string.obfuscated_res_0x7f0f12dd);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.n0.a.g0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.f3857d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0109);
                f2.l(2);
                f2.G();
                this.a.C();
            }
        }

        @Override // c.a.n0.a.g0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.f3857d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0108);
            f2.l(2);
            f2.G();
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.g0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3858b;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3858b = aVar;
            this.a = str;
        }

        @Override // c.a.n0.a.g0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.f3858b.f3857d, R.string.obfuscated_res_0x7f0f12dd);
                f2.l(2);
                f2.G();
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.f3858b.f3857d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0151);
            f2.l(2);
            f2.G();
        }

        @Override // c.a.n0.a.g0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.z.b.a.t();
                if (!a.k(this.f3858b.f3856c.getActivity())) {
                    c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(this.f3858b.f3857d, c.a.n0.a.s0.a.l0().f(this.f3858b.f3857d));
                    g2.l(2);
                    g2.q(2);
                    g2.G();
                    this.f3858b.C();
                    return;
                }
                a.p("addmyswan", this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements c.a.n0.a.g0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f3859b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.f3859b = hVar;
        }

        @Override // c.a.n0.a.g0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f12dd);
                f2.l(2);
                f2.G();
                h hVar = this.f3859b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0151);
                    f2.l(2);
                    f2.G();
                }
                h hVar = this.f3859b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.n0.a.g0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.z.b.a.t();
                if (a.k(this.a)) {
                    h hVar = this.f3859b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(applicationContext, c.a.n0.a.s0.a.l0().f(applicationContext));
                g2.l(2);
                g2.q(2);
                g2.G();
                h hVar2 = this.f3859b;
                if (hVar2 != null) {
                    hVar2.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1205599140, "Lc/a/n0/a/a1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1205599140, "Lc/a/n0/a/a1/a;");
                return;
            }
        }
        f3854e = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.n.f fVar, c.a.n0.a.x.g.d dVar) {
        this(fVar, dVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.a.n0.n.f) objArr2[0], (c.a.n0.a.x.g.d) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String N = c.a.n0.a.t1.d.J().r().N();
            if (TextUtils.isEmpty(N) && hVar != null) {
                hVar.onFail();
            }
            if (!c.a.n0.a.z.b.a.n(N)) {
                SwanFavorDataManager.h().b(N, new g(activity, hVar));
            } else if (hVar != null) {
                hVar.onSuccess();
            }
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, activity) == null) || activity == null) {
            return;
        }
        if (f3854e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a = c.a.n0.a.s0.a.M().a();
        c.a.n0.a.s0.a.M().e(!a);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(c.a.n0.a.s0.a.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a) {
            c.a.n0.a.s1.b.f.e f2 = c.a.n0.a.s1.b.f.e.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0104);
            f2.m(R.drawable.obfuscated_res_0x7f08013e);
            f2.l(2);
            f2.B();
        } else {
            c.a.n0.a.s1.b.f.e f3 = c.a.n0.a.s1.b.f.e.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0105);
            f3.m(R.drawable.obfuscated_res_0x7f0801a2);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? c.a.n0.a.s0.a.l0().a(activity) : invokeL.booleanValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            p(str, null);
        }
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            q(str, str2, null);
        }
    }

    public static void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            r(str, str2, str3, null, null);
        }
    }

    public static void r(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65552, null, str, str2, str3, str4, str5) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.f4191e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f4193g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f4188b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().D());
            if (activity != null) {
                c.a.n0.a.p2.f.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f3854e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.s1.b.f.e.f(this.f3857d, R.string.obfuscated_res_0x7f0f019b).G();
                return;
            }
            g.b i = V.i("navigateTo");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f3854e) {
                Log.d("SwanAppMenuHelper", "startSettingFragment");
            }
            c.a.n0.a.x.g.g K1 = this.f3856c.K1();
            if (K1 == null) {
                c.a.n0.a.s1.b.f.e.f(this.f3857d, R.string.obfuscated_res_0x7f0f019b).G();
                return;
            }
            g.b i = K1.i("navigateTo");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3855b.setAttentionBtnStates(c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r0.b(this.f3857d).c(c.a.n0.a.c1.b.b(q0.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        b.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c.a.n0.a.n1.a.a.H()) {
                if (f3854e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                c.a.n0.a.s1.b.f.e.f(this.f3857d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0124).G();
                return;
            }
            if (f3854e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (c.a.n0.a.t1.e.a0() != null) {
                launchInfo = c.a.n0.a.t1.e.a0().V();
            } else {
                launchInfo = ((SwanAppActivity) this.f3856c.getActivity()).getLaunchInfo();
            }
            c.a.n0.a.y1.a.i(this.f3856c.getContext(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (c.a.n0.a.n1.a.a.H()) {
                if (f3854e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                c.a.n0.a.s1.b.f.e.f(this.f3857d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0123).G();
                return;
            }
            String e2 = q0.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            c.a.n0.a.d0.l.c l = c.a.n0.a.d0.l.c.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f3856c.K2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.n0.a.x.g.g K1 = this.f3856c.K1();
            if (K1 == null) {
                c.a.n0.a.s1.b.f.e.f(this.f3857d, R.string.obfuscated_res_0x7f0f019b).G();
                return;
            }
            g.b i = K1.i("navigateTo");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String N = c.a.n0.a.t1.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (c.a.n0.a.z.b.a.n(N)) {
                m(N);
            } else {
                l(N);
            }
        }
    }

    public boolean v(c.a.n0.n.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, gVar)) == null) {
            if (this.f3856c == null || this.f3857d == null) {
                return false;
            }
            int c2 = gVar.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.f3856c.getActivity());
                return true;
            } else if (c2 == 35) {
                i();
                return true;
            } else if (c2 == 49) {
                s();
                return true;
            } else if (c2 == 42) {
                y();
                return true;
            } else if (c2 != 43) {
                switch (c2) {
                    case 37:
                        B();
                        return true;
                    case 38:
                        u();
                        return true;
                    case 39:
                        x();
                        return true;
                    default:
                        return c.a.n0.a.s0.a.K().j(gVar);
                }
            } else {
                q0.d();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f3856c == null || this.f3857d == null) {
                return false;
            }
            if (D()) {
                string = this.f3857d.getString(R.string.obfuscated_res_0x7f0f12fe);
            } else {
                string = this.f3857d.getString(R.string.obfuscated_res_0x7f0f12fd);
            }
            c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(this.f3857d, string);
            g2.l(2);
            g2.G();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o(Headers.REFRESH);
            e0.a(c.a.n0.a.w0.f.U().getActivity());
            c.a.n0.a.u.d.k("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (f3854e) {
                Log.d("SwanAppMenuHelper", "restart");
            }
            Context context = this.f3857d;
            if (context == null) {
                return;
            }
            e0.a((SwanAppActivity) context);
        }
    }

    public void z() {
        c.a.n0.a.t1.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.a == null || this.f3856c == null || this.f3857d == null || (r = c.a.n0.a.t1.d.J().r()) == null) {
            return;
        }
        r.x();
        this.a.o(new C0214a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f3855b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.f3855b.setAttentionBtnShow(c.a.n0.a.s0.a.t().b());
            this.f3855b.setOnAttentionBtnClickListener(new c(this));
            if (r.v0()) {
                return;
            }
            this.f3855b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public a(c.a.n0.n.f fVar, c.a.n0.a.x.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, dVar, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f3855b = swanAppMenuHeaderView;
        this.f3856c = dVar;
        if (dVar != null) {
            this.f3857d = dVar.getContext();
        }
    }
}
