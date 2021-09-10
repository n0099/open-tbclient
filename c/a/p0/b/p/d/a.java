package c.a.p0.b.p.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
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

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10232b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f10233a;

    /* renamed from: c.a.p0.b.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0501a implements c.a.p0.b.p.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f10234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m.a f10235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10236c;

        /* renamed from: c.a.p0.b.p.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0502a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0501a f10237e;

            public RunnableC0502a(C0501a c0501a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0501a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10237e = c0501a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.z1.b.d.a.c(this.f10237e.f10234a);
                }
            }
        }

        public C0501a(a aVar, ViewGroup viewGroup, c.a.p0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10236c = aVar;
            this.f10234a = viewGroup;
            this.f10235b = aVar2;
        }

        @Override // c.a.p0.b.p.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                ViewGroup viewGroup = this.f10234a;
                if (viewGroup != null) {
                    viewGroup.post(new RunnableC0502a(this));
                }
                if (this.f10236c.i(quickLoginInfo)) {
                    this.f10236c.f10233a.putParcelable("quick_login_info", quickLoginInfo);
                }
                String T = c.a.p0.a.a2.d.g().r().L().T();
                String appId = c.a.p0.a.a2.d.g().getAppId();
                this.f10236c.f10233a.putString("app_name", c.a.p0.a.a2.d.g().r().O());
                this.f10236c.f10233a.putString("appid", appId);
                this.f10236c.f10233a.putString("launch_from", T);
                if (a.f10232b) {
                    String str = "onQueryResult: mParams: " + this.f10236c.f10233a.toString();
                }
                d.a("show", "login", null, T, appId);
                this.f10236c.f(this.f10235b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m.a f10238a;

        public b(a aVar, c.a.p0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10238a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (delegateResult.isOk()) {
                    this.f10238a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                    return;
                }
                this.f10238a.onResult(-2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1591864922, "Lc/a/p0/b/p/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1591864922, "Lc/a/p0/b/p/d/a;");
                return;
            }
        }
        f10232b = k.f7077a;
    }

    public a() {
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
        this.f10233a = new Bundle();
    }

    public final void e(c.a.p0.a.m.a aVar) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (activity = f.V().getActivity()) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f10233a);
        activity.startActivity(intent);
        activity.overridePendingTransition(c.a.p0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(c.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                e(aVar);
            } else {
                g(aVar);
            }
        }
    }

    public final void g(c.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, c.a.p0.b.p.d.b.class, this.f10233a, new b(this, aVar));
        }
    }

    public void h(c.a.p0.a.m.a aVar) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            SwanAppActivity x = c.a.p0.a.a2.d.g().x();
            if (x == null || x.isFinishing()) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) x.findViewById(16908290);
                c.a.p0.a.z1.b.d.a.f(x, viewGroup, x.getResources().getString(h.swanapp_login_loading));
            }
            c.a.p0.b.p.g.f.b(new C0501a(this, viewGroup, aVar));
        }
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, quickLoginInfo)) == null) ? quickLoginInfo != null && quickLoginInfo.supportQuickLogin : invokeL.booleanValue;
    }
}
