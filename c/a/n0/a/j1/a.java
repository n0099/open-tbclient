package c.a.n0.a.j1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.h0.g.g;
import c.a.n0.a.k;
import c.a.n0.a.v2.e0;
import c.a.n0.a.v2.q0;
import c.a.n0.a.v2.r0;
import c.a.n0.k.n;
import c.a.n0.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
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
    public static final boolean f6662e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public n f6663a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f6664b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.h0.g.d f6665c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6666d;

    /* renamed from: c.a.n0.a.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0264a implements c.a.n0.k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6667e;

        public C0264a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6667e = aVar;
        }

        @Override // c.a.n0.k.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) ? this.f6667e.v(oVar) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6668a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6668a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6668a.f6663a.d();
                this.f6668a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6669a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6669a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6669a.f6663a.d();
                this.f6669a.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6670a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6670a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f6670a.f6663a.d();
                return this.f6670a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6671a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6671a = aVar;
        }

        @Override // c.a.n0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6671a.f6666d, c.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.n0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6671a.f6666d.getApplicationContext(), c.a.n0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.n0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6671a.f6666d.getApplicationContext(), c.a.n0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
                this.f6671a.C();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6672a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6673b;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6673b = aVar;
            this.f6672a = str;
        }

        @Override // c.a.n0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6673b.f6666d, c.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.n0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6673b.f6666d.getApplicationContext(), c.a.n0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.n0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.j0.b.a.t();
                if (!a.k(this.f6673b.f6665c.h())) {
                    c.a.n0.a.z1.b.f.e g2 = c.a.n0.a.z1.b.f.e.g(this.f6673b.f6666d, c.a.n0.a.c1.a.e0().f(this.f6673b.f6666d));
                    g2.l(2);
                    g2.p(2);
                    g2.F();
                    this.f6673b.C();
                    return;
                }
                a.p("addmyswan", this.f6672a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements c.a.n0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6674a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f6675b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6674a = activity;
            this.f6675b = hVar;
        }

        @Override // c.a.n0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6674a.getApplicationContext(), c.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
                h hVar = this.f6675b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.n0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(this.f6674a.getApplicationContext(), c.a.n0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
                h hVar = this.f6675b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.n0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.n0.a.j0.b.a.t();
                if (a.k(this.f6674a)) {
                    h hVar = this.f6675b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.f6674a.getApplicationContext();
                c.a.n0.a.z1.b.f.e g2 = c.a.n0.a.z1.b.f.e.g(applicationContext, c.a.n0.a.c1.a.e0().f(applicationContext));
                g2.l(2);
                g2.p(2);
                g2.F();
                h hVar2 = this.f6675b;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213910829, "Lc/a/n0/a/j1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213910829, "Lc/a/n0/a/j1/a;");
                return;
            }
        }
        f6662e = k.f6803a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(n nVar, c.a.n0.a.h0.g.d dVar) {
        this(nVar, dVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((n) objArr2[0], (c.a.n0.a.h0.g.d) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String D = c.a.n0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D) && hVar != null) {
                hVar.onFail();
            }
            if (!c.a.n0.a.j0.b.a.n(D)) {
                SwanFavorDataManager.h().b(D, new g(activity, hVar));
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
        boolean z = f6662e;
        boolean a2 = c.a.n0.a.c1.a.H().a();
        c.a.n0.a.c1.a.H().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(c.a.n0.a.c1.a.H().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            c.a.n0.a.z1.b.f.e f2 = c.a.n0.a.z1.b.f.e.f(activity.getApplicationContext(), c.a.n0.a.h.aiapps_browser_menu_toast_day_mode);
            f2.m(c.a.n0.a.e.aiapps_day_mode_toast_icon);
            f2.l(2);
            f2.A();
        } else {
            c.a.n0.a.z1.b.f.e f3 = c.a.n0.a.z1.b.f.e.f(activity.getApplicationContext(), c.a.n0.a.h.aiapps_browser_menu_toast_night_mode);
            f3.m(c.a.n0.a.e.aiapps_night_mode_toast_icon);
            f3.l(2);
            f3.A();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? c.a.n0.a.c1.a.e0().a(activity) : invokeL.booleanValue;
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
        c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
        fVar.f6793e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f6795g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f6790b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = c.a.n0.a.g1.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().C());
            if (activity != null) {
                c.a.n0.a.v2.f.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f6662e;
            c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
            if (W == null) {
                c.a.n0.a.z1.b.f.e.f(this.f6666d, c.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(c.a.n0.a.h0.g.g.f5654g, c.a.n0.a.h0.g.g.f5656i);
            i2.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f6662e;
            c.a.n0.a.h0.g.g H1 = this.f6665c.H1();
            if (H1 == null) {
                c.a.n0.a.z1.b.f.e.f(this.f6666d, c.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = H1.i("navigateTo");
            i2.n(c.a.n0.a.h0.g.g.f5654g, c.a.n0.a.h0.g.g.f5656i);
            i2.k("authority", null).a();
            o("permission");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f6664b.setAttentionBtnStates(c.a.n0.a.j0.b.a.n(c.a.n0.a.a2.d.g().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r0.b(this.f6666d).c(c.a.n0.a.l1.b.e(q0.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        b.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c.a.n0.a.u1.a.a.G()) {
                boolean z = f6662e;
                c.a.n0.a.z1.b.f.e.f(this.f6666d.getApplicationContext(), c.a.n0.a.h.aiapps_debug_forbid_shortcut).F();
                return;
            }
            boolean z2 = f6662e;
            if (c.a.n0.a.a2.e.Q() != null) {
                launchInfo = c.a.n0.a.a2.e.Q().L();
            } else {
                launchInfo = ((SwanAppActivity) this.f6665c.h()).getLaunchInfo();
            }
            c.a.n0.a.f2.a.i(this.f6665c.q(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (c.a.n0.a.u1.a.a.G()) {
                boolean z = f6662e;
                c.a.n0.a.z1.b.f.e.f(this.f6666d.getApplicationContext(), c.a.n0.a.h.aiapps_debug_forbid_favor).F();
                return;
            }
            String h2 = q0.n().h();
            SwanFavorDataManager.h().b(str, new f(this, h2));
            p("addmyswan", h2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            c.a.n0.a.n0.l.c l = c.a.n0.a.n0.l.c.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f6665c.A2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.n0.a.h0.g.g H1 = this.f6665c.H1();
            if (H1 == null) {
                c.a.n0.a.z1.b.f.e.f(this.f6666d, c.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = H1.i("navigateTo");
            i2.n(c.a.n0.a.h0.g.g.f5654g, c.a.n0.a.h0.g.g.f5656i);
            i2.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String D = c.a.n0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            if (c.a.n0.a.j0.b.a.n(D)) {
                m(D);
            } else {
                l(D);
            }
        }
    }

    public boolean v(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, oVar)) == null) {
            if (this.f6665c == null || this.f6666d == null) {
                return false;
            }
            int c2 = oVar.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.f6665c.h());
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
                        return c.a.n0.a.c1.a.G().h(oVar);
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
            if (this.f6665c == null || this.f6666d == null) {
                return false;
            }
            if (D()) {
                string = this.f6666d.getString(c.a.n0.a.h.swanapp_write_to_clipborad_succ);
            } else {
                string = this.f6666d.getString(c.a.n0.a.h.swanapp_write_to_clipborad_fail);
            }
            c.a.n0.a.z1.b.f.e g2 = c.a.n0.a.z1.b.f.e.g(this.f6666d, string);
            g2.l(2);
            g2.F();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o("refresh");
            e0.a(c.a.n0.a.g1.f.V().getActivity());
            c.a.n0.a.e0.d.h("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = f6662e;
            Context context = this.f6666d;
            if (context == null) {
                return;
            }
            e0.a((SwanAppActivity) context);
        }
    }

    public void z() {
        c.a.n0.a.a2.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f6663a == null || this.f6665c == null || this.f6666d == null || (r = c.a.n0.a.a2.d.g().r()) == null) {
            return;
        }
        r.x();
        this.f6663a.l(new C0264a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f6664b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.f6664b.setAttentionBtnShow(true);
            this.f6664b.setOnAttentionBtnClickListener(new c(this));
            if (r.m0()) {
                return;
            }
            this.f6664b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public a(n nVar, c.a.n0.a.h0.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, dVar, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f6663a = nVar;
        this.f6664b = swanAppMenuHeaderView;
        this.f6665c = dVar;
        if (dVar != null) {
            this.f6666d = dVar.q();
        }
    }
}
