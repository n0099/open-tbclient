package b.a.p0.a.k1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.a.z2.e0;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.r0;
import b.a.p0.n.n;
import b.a.p0.n.o;
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
    public static final boolean f6876e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public n f6877a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f6878b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.h0.g.d f6879c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6880d;

    /* renamed from: b.a.p0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0300a implements b.a.p0.n.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6881e;

        public C0300a(a aVar) {
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
            this.f6881e = aVar;
        }

        @Override // b.a.p0.n.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) ? this.f6881e.v(oVar) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6882a;

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
            this.f6882a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6882a.f6877a.f();
                this.f6882a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6883a;

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
            this.f6883a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6883a.f6877a.f();
                this.f6883a.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6884a;

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
            this.f6884a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f6884a.f6877a.f();
                return this.f6884a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6885a;

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
            this.f6885a = aVar;
        }

        @Override // b.a.p0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6885a.f6880d, b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6885a.f6880d.getApplicationContext(), b.a.p0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.G();
                this.f6885a.C();
            }
        }

        @Override // b.a.p0.a.q0.b.b
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6885a.f6880d.getApplicationContext(), b.a.p0.a.h.aiapps_cancel_fav_fail);
            f2.l(2);
            f2.G();
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6886a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6887b;

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
            this.f6887b = aVar;
            this.f6886a = str;
        }

        @Override // b.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6887b.f6880d, b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6887b.f6880d.getApplicationContext(), b.a.p0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.G();
        }

        @Override // b.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.p0.a.j0.b.a.t();
                if (!a.k(this.f6887b.f6879c.getActivity())) {
                    b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(this.f6887b.f6880d, b.a.p0.a.c1.a.l0().f(this.f6887b.f6880d));
                    g2.l(2);
                    g2.q(2);
                    g2.G();
                    this.f6887b.C();
                    return;
                }
                a.p("addmyswan", this.f6886a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements b.a.p0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f6889b;

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
            this.f6888a = activity;
            this.f6889b = hVar;
        }

        @Override // b.a.p0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6888a.getApplicationContext(), b.a.p0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.G();
                h hVar = this.f6889b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(this.f6888a.getApplicationContext(), b.a.p0.a.h.aiapps_fav_fail);
                    f2.l(2);
                    f2.G();
                }
                h hVar = this.f6889b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // b.a.p0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.p0.a.j0.b.a.t();
                if (a.k(this.f6888a)) {
                    h hVar = this.f6889b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.f6888a.getApplicationContext();
                b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(applicationContext, b.a.p0.a.c1.a.l0().f(applicationContext));
                g2.l(2);
                g2.q(2);
                g2.G();
                h hVar2 = this.f6889b;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1327365965, "Lb/a/p0/a/k1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1327365965, "Lb/a/p0/a/k1/a;");
                return;
            }
        }
        f6876e = k.f6863a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(n nVar, b.a.p0.a.h0.g.d dVar) {
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
                this((n) objArr2[0], (b.a.p0.a.h0.g.d) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String N = b.a.p0.a.d2.d.J().r().N();
            if (TextUtils.isEmpty(N) && hVar != null) {
                hVar.onFail();
            }
            if (!b.a.p0.a.j0.b.a.n(N)) {
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
        boolean z = f6876e;
        boolean a2 = b.a.p0.a.c1.a.M().a();
        b.a.p0.a.c1.a.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(b.a.p0.a.c1.a.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            b.a.p0.a.c2.b.f.e f2 = b.a.p0.a.c2.b.f.e.f(activity.getApplicationContext(), b.a.p0.a.h.aiapps_browser_menu_toast_day_mode);
            f2.m(b.a.p0.a.e.aiapps_day_mode_toast_icon);
            f2.l(2);
            f2.B();
        } else {
            b.a.p0.a.c2.b.f.e f3 = b.a.p0.a.c2.b.f.e.f(activity.getApplicationContext(), b.a.p0.a.h.aiapps_browser_menu_toast_night_mode);
            f3.m(b.a.p0.a.e.aiapps_night_mode_toast_icon);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? b.a.p0.a.c1.a.l0().a(activity) : invokeL.booleanValue;
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
        b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
        fVar.f7383e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f7385g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f7380b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = b.a.p0.a.g1.f.U().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().D());
            if (activity != null) {
                b.a.p0.a.z2.f.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f6876e;
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null) {
                b.a.p0.a.c2.b.f.e.f(this.f6880d, b.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = V.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = f6876e;
            b.a.p0.a.h0.g.g J1 = this.f6879c.J1();
            if (J1 == null) {
                b.a.p0.a.c2.b.f.e.f(this.f6880d, b.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = J1.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("authority", null).a();
            o("permission");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f6878b.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r0.b(this.f6880d).c(b.a.p0.a.m1.b.b(q0.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        b.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (b.a.p0.a.x1.a.a.H()) {
                boolean z = f6876e;
                b.a.p0.a.c2.b.f.e.f(this.f6880d.getApplicationContext(), b.a.p0.a.h.aiapps_debug_forbid_shortcut).G();
                return;
            }
            boolean z2 = f6876e;
            if (b.a.p0.a.d2.e.a0() != null) {
                launchInfo = b.a.p0.a.d2.e.a0().V();
            } else {
                launchInfo = ((SwanAppActivity) this.f6879c.getActivity()).getLaunchInfo();
            }
            b.a.p0.a.i2.a.i(this.f6879c.getContext(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (b.a.p0.a.x1.a.a.H()) {
                boolean z = f6876e;
                b.a.p0.a.c2.b.f.e.f(this.f6880d.getApplicationContext(), b.a.p0.a.h.aiapps_debug_forbid_favor).G();
                return;
            }
            String f2 = q0.n().f();
            SwanFavorDataManager.h().b(str, new f(this, f2));
            p("addmyswan", f2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f6879c.J2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.p0.a.h0.g.g J1 = this.f6879c.J1();
            if (J1 == null) {
                b.a.p0.a.c2.b.f.e.f(this.f6880d, b.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = J1.i("navigateTo");
            i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
            i2.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String N = b.a.p0.a.d2.d.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (b.a.p0.a.j0.b.a.n(N)) {
                m(N);
            } else {
                l(N);
            }
        }
    }

    public boolean v(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, oVar)) == null) {
            if (this.f6879c == null || this.f6880d == null) {
                return false;
            }
            int c2 = oVar.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.f6879c.getActivity());
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
                        return b.a.p0.a.c1.a.K().j(oVar);
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
            if (this.f6879c == null || this.f6880d == null) {
                return false;
            }
            if (D()) {
                string = this.f6880d.getString(b.a.p0.a.h.swanapp_write_to_clipborad_succ);
            } else {
                string = this.f6880d.getString(b.a.p0.a.h.swanapp_write_to_clipborad_fail);
            }
            b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(this.f6880d, string);
            g2.l(2);
            g2.G();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o("refresh");
            e0.a(b.a.p0.a.g1.f.U().getActivity());
            b.a.p0.a.e0.d.k("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = f6876e;
            Context context = this.f6880d;
            if (context == null) {
                return;
            }
            e0.a((SwanAppActivity) context);
        }
    }

    public void z() {
        b.a.p0.a.d2.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f6877a == null || this.f6879c == null || this.f6880d == null || (r = b.a.p0.a.d2.d.J().r()) == null) {
            return;
        }
        r.x();
        this.f6877a.n(new C0300a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f6878b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.f6878b.setAttentionBtnShow(b.a.p0.a.c1.a.t().b());
            this.f6878b.setOnAttentionBtnClickListener(new c(this));
            if (r.v0()) {
                return;
            }
            this.f6878b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public a(n nVar, b.a.p0.a.h0.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
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
        this.f6877a = nVar;
        this.f6878b = swanAppMenuHeaderView;
        this.f6879c = dVar;
        if (dVar != null) {
            this.f6880d = dVar.getContext();
        }
    }
}
