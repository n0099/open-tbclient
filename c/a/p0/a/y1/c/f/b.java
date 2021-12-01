package c.a.p0.a.y1.c.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.p.d.m;
import c.a.p0.a.u1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f8894b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8895c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.p0.a.h0.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y1.c.f.c f8896b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f8897c;

        public a(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f8896b = cVar;
            this.f8897c = bundle;
        }

        @Override // c.a.p0.a.h0.s.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.a;
            }
        }

        @Override // c.a.p0.a.h0.s.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = b.a;
                b.i(this.a, this.f8896b, this.f8897c);
            }
        }
    }

    /* renamed from: c.a.p0.a.y1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0543b implements c.a.p0.a.h0.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y1.c.f.c f8898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f8899c;

        public C0543b(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f8898b = cVar;
            this.f8899c = bundle;
        }

        @Override // c.a.p0.a.h0.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.f8895c = true;
                b.h(this.a, this.f8898b, this.f8899c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.z2.g1.c<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f8900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y1.c.f.c f8901f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f8902g;

        public c(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8900e = context;
            this.f8901f = cVar;
            this.f8902g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.g(this.f8900e, this.f8901f, this.f8902g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1770206862, "Lc/a/p0/a/y1/c/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1770206862, "Lc/a/p0/a/y1/c/f/b;");
                return;
            }
        }
        a = k.a;
        f8895c = false;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", g.U().k0());
                jSONObject.put("slave", g.U().n0());
            } catch (JSONException e2) {
                if (a) {
                    throw new RuntimeException(e2);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                String str = "createPreloadStatus -- preloadStatus : " + jSONObject2;
            }
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, cVar, bundle) == null) {
            boolean u = c.a.p0.a.c1.a.g0() != null ? c.a.p0.a.c1.a.g0().u() : false;
            boolean isMainProcess = ProcessUtils.isMainProcess();
            String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
            long currentTimeMillis = System.currentTimeMillis();
            if (u) {
                if (isMainProcess && TextUtils.isEmpty(f8894b)) {
                    try {
                        f8894b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e2) {
                        f8894b = "exception::" + e2.toString();
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", cVar.f8903f.index);
                    jSONObject.put("ua", f8894b);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                h.d dVar = new h.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                h.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (u) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", cVar.f8903f.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e4) {
                    if (a) {
                        e4.printStackTrace();
                    }
                }
                h.d dVar2 = new h.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                h.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (c.a.p0.a.q2.b.j()) {
                c.a.p0.a.q2.d.a.e();
            }
            bundle.putParcelable("bundle_key_swan_core", c.a.p0.a.q2.b.e(0));
            bundle.putParcelable("bundle_key_extension_core", c.a.p0.a.p0.b.c(0));
            bundle.putInt("bundle_key_preload_switch", c.a.p0.a.c1.a.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", c.a.p0.a.c1.a.g0().y());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", cVar.f8903f.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            cVar.m0(context, bundle);
        }
    }

    public static void h(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, cVar, bundle) == null) {
            SwanLauncher.j().l(new c(context, cVar, bundle));
        }
    }

    public static void i(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, cVar, bundle) == null) {
            if (c.a.p0.a.h0.s.e.a()) {
                h(context, cVar, bundle);
            } else if (f8895c) {
                h(context, cVar, bundle);
            } else {
                c.a.p0.a.p.e.j.c.a().b().a().b(new C0543b(context, cVar, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", c.a.p0.a.c1.a.g0().y());
        }
    }

    public static void k(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, bundle) == null) {
            Intent intent = new Intent(context, SwanAppMessengerService.class);
            intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                context.startService(intent);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            m(context, e.k().f(), bundle);
        }
    }

    public static void m(Context context, c.a.p0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, cVar, bundle) == null) {
            if (a) {
                e.k().u("b4 tryPreload client=" + cVar);
            }
            if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f8903f.isSwanAppProcess() || cVar.D()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (a) {
                String str = "SwanSailor：preloadScene:" + string;
            }
            if (c.a.p0.a.c1.a.w0().c()) {
                i(context, cVar, bundle);
                return;
            }
            c.a.p0.a.h0.s.e eVar = new c.a.p0.a.h0.s.e();
            eVar.a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            c.a.p0.a.c1.a.w0().b(eVar, new a(context, cVar, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            m g0 = c.a.p0.a.c1.a.g0();
            if (!c.a.p0.a.x1.a.a.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
