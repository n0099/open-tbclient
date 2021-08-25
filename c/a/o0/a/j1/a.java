package c.a.o0.a.j1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.k;
import c.a.o0.a.v2.e0;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.r0;
import c.a.o0.k.n;
import c.a.o0.k.o;
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
    public static final boolean f6908e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public n f6909a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f6910b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.a.h0.g.d f6911c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6912d;

    /* renamed from: c.a.o0.a.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0272a implements c.a.o0.k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6913e;

        public C0272a(a aVar) {
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
            this.f6913e = aVar;
        }

        @Override // c.a.o0.k.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) ? this.f6913e.v(oVar) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6914a;

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
            this.f6914a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6914a.f6909a.d();
                this.f6914a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6915a;

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
            this.f6915a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6915a.f6909a.d();
                this.f6915a.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6916a;

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
            this.f6916a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f6916a.f6909a.d();
                return this.f6916a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.o0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6917a;

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
            this.f6917a = aVar;
        }

        @Override // c.a.o0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6917a.f6912d, c.a.o0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.o0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6917a.f6912d.getApplicationContext(), c.a.o0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.o0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6917a.f6912d.getApplicationContext(), c.a.o0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
                this.f6917a.C();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6919b;

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
            this.f6919b = aVar;
            this.f6918a = str;
        }

        @Override // c.a.o0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6919b.f6912d, c.a.o0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.o0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6919b.f6912d.getApplicationContext(), c.a.o0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // c.a.o0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.o0.a.j0.b.a.t();
                if (!a.k(this.f6919b.f6911c.h())) {
                    c.a.o0.a.z1.b.f.e g2 = c.a.o0.a.z1.b.f.e.g(this.f6919b.f6912d, c.a.o0.a.c1.a.e0().f(this.f6919b.f6912d));
                    g2.l(2);
                    g2.p(2);
                    g2.F();
                    this.f6919b.C();
                    return;
                }
                a.p("addmyswan", this.f6918a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements c.a.o0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6920a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f6921b;

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
            this.f6920a = activity;
            this.f6921b = hVar;
        }

        @Override // c.a.o0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6920a.getApplicationContext(), c.a.o0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
                h hVar = this.f6921b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.o0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f6920a.getApplicationContext(), c.a.o0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
                h hVar = this.f6921b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // c.a.o0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.o0.a.j0.b.a.t();
                if (a.k(this.f6920a)) {
                    h hVar = this.f6921b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.f6920a.getApplicationContext();
                c.a.o0.a.z1.b.f.e g2 = c.a.o0.a.z1.b.f.e.g(applicationContext, c.a.o0.a.c1.a.e0().f(applicationContext));
                g2.l(2);
                g2.p(2);
                g2.F();
                h hVar2 = this.f6921b;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1017397324, "Lc/a/o0/a/j1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1017397324, "Lc/a/o0/a/j1/a;");
                return;
            }
        }
        f6908e = k.f7049a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(n nVar, c.a.o0.a.h0.g.d dVar) {
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
                this((n) objArr2[0], (c.a.o0.a.h0.g.d) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String D = c.a.o0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D) && hVar != null) {
                hVar.onFail();
            }
            if (!c.a.o0.a.j0.b.a.n(D)) {
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
        boolean z = f6908e;
        boolean a2 = c.a.o0.a.c1.a.H().a();
        c.a.o0.a.c1.a.H().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(c.a.o0.a.c1.a.H().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(activity.getApplicationContext(), c.a.o0.a.h.aiapps_browser_menu_toast_day_mode);
            f2.m(c.a.o0.a.e.aiapps_day_mode_toast_icon);
            f2.l(2);
            f2.A();
        } else {
            c.a.o0.a.z1.b.f.e f3 = c.a.o0.a.z1.b.f.e.f(activity.getApplicationContext(), c.a.o0.a.h.aiapps_browser_menu_toast_night_mode);
            f3.m(c.a.o0.a.e.aiapps_night_mode_toast_icon);
            f3.l(2);
            f3.A();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? c.a.o0.a.c1.a.e0().a(activity) : invokeL.booleanValue;
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
        c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
        fVar.f7039e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f7041g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f7036b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = c.a.o0.a.g1.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().C());
            if (activity != null) {
                c.a.o0.a.v2.f.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f6908e;
            c.a.o0.a.h0.g.g W = c.a.o0.a.g1.f.V().W();
            if (W == null) {
                c.a.o0.a.z1.b.f.e.f(this.f6912d, c.a.o0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
            i2.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f6908e;
            c.a.o0.a.h0.g.g H1 = this.f6911c.H1();
            if (H1 == null) {
                c.a.o0.a.z1.b.f.e.f(this.f6912d, c.a.o0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = H1.i("navigateTo");
            i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
            i2.k("authority", null).a();
            o("permission");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f6910b.setAttentionBtnStates(c.a.o0.a.j0.b.a.n(c.a.o0.a.a2.d.g().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r0.b(this.f6912d).c(c.a.o0.a.l1.b.e(q0.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        b.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c.a.o0.a.u1.a.a.G()) {
                boolean z = f6908e;
                c.a.o0.a.z1.b.f.e.f(this.f6912d.getApplicationContext(), c.a.o0.a.h.aiapps_debug_forbid_shortcut).F();
                return;
            }
            boolean z2 = f6908e;
            if (c.a.o0.a.a2.e.Q() != null) {
                launchInfo = c.a.o0.a.a2.e.Q().L();
            } else {
                launchInfo = ((SwanAppActivity) this.f6911c.h()).getLaunchInfo();
            }
            c.a.o0.a.f2.a.i(this.f6911c.q(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (c.a.o0.a.u1.a.a.G()) {
                boolean z = f6908e;
                c.a.o0.a.z1.b.f.e.f(this.f6912d.getApplicationContext(), c.a.o0.a.h.aiapps_debug_forbid_favor).F();
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
            c.a.o0.a.n0.l.c l = c.a.o0.a.n0.l.c.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f6911c.A2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.o0.a.h0.g.g H1 = this.f6911c.H1();
            if (H1 == null) {
                c.a.o0.a.z1.b.f.e.f(this.f6912d, c.a.o0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = H1.i("navigateTo");
            i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
            i2.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String D = c.a.o0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            if (c.a.o0.a.j0.b.a.n(D)) {
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
            if (this.f6911c == null || this.f6912d == null) {
                return false;
            }
            int c2 = oVar.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.f6911c.h());
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
                        return c.a.o0.a.c1.a.G().h(oVar);
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
            if (this.f6911c == null || this.f6912d == null) {
                return false;
            }
            if (D()) {
                string = this.f6912d.getString(c.a.o0.a.h.swanapp_write_to_clipborad_succ);
            } else {
                string = this.f6912d.getString(c.a.o0.a.h.swanapp_write_to_clipborad_fail);
            }
            c.a.o0.a.z1.b.f.e g2 = c.a.o0.a.z1.b.f.e.g(this.f6912d, string);
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
            e0.a(c.a.o0.a.g1.f.V().getActivity());
            c.a.o0.a.e0.d.h("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = f6908e;
            Context context = this.f6912d;
            if (context == null) {
                return;
            }
            e0.a((SwanAppActivity) context);
        }
    }

    public void z() {
        c.a.o0.a.a2.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f6909a == null || this.f6911c == null || this.f6912d == null || (r = c.a.o0.a.a2.d.g().r()) == null) {
            return;
        }
        r.x();
        this.f6909a.l(new C0272a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f6910b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.f6910b.setAttentionBtnShow(true);
            this.f6910b.setOnAttentionBtnClickListener(new c(this));
            if (r.m0()) {
                return;
            }
            this.f6910b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public a(n nVar, c.a.o0.a.h0.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
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
        this.f6909a = nVar;
        this.f6910b = swanAppMenuHeaderView;
        this.f6911c = dVar;
        if (dVar != null) {
            this.f6912d = dVar.q();
        }
    }
}
