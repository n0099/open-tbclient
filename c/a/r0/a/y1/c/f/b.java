package c.a.r0.a.y1.c.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
import c.a.r0.a.p.d.m;
import c.a.r0.a.u1.h;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9864b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9865c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.r0.a.h0.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y1.c.f.c f9866b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f9867c;

        public a(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
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
            this.f9866b = cVar;
            this.f9867c = bundle;
        }

        @Override // c.a.r0.a.h0.s.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.a;
            }
        }

        @Override // c.a.r0.a.h0.s.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = b.a;
                b.i(this.a, this.f9866b, this.f9867c);
            }
        }
    }

    /* renamed from: c.a.r0.a.y1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0645b implements c.a.r0.a.h0.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y1.c.f.c f9868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f9869c;

        public C0645b(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
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
            this.f9868b = cVar;
            this.f9869c = bundle;
        }

        @Override // c.a.r0.a.h0.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.f9865c = true;
                b.h(this.a, this.f9868b, this.f9869c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.r0.a.z2.g1.c<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9870e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y1.c.f.c f9871f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f9872g;

        public c(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
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
            this.f9870e = context;
            this.f9871f = cVar;
            this.f9872g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.g(this.f9870e, this.f9871f, this.f9872g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(759089612, "Lc/a/r0/a/y1/c/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(759089612, "Lc/a/r0/a/y1/c/f/b;");
                return;
            }
        }
        a = k.a;
        f9865c = false;
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

    public static void g(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, cVar, bundle) == null) {
            boolean u = c.a.r0.a.c1.a.g0() != null ? c.a.r0.a.c1.a.g0().u() : false;
            boolean isMainProcess = ProcessUtils.isMainProcess();
            String str = isMainProcess ? "main" : "aiapp";
            long currentTimeMillis = System.currentTimeMillis();
            if (u) {
                if (isMainProcess && TextUtils.isEmpty(f9864b)) {
                    try {
                        f9864b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e2) {
                        f9864b = "exception::" + e2.toString();
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", cVar.f9873f.index);
                    jSONObject.put("ua", f9864b);
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
                    jSONObject2.put("process", cVar.f9873f.index);
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
            if (c.a.r0.a.q2.b.j()) {
                c.a.r0.a.q2.d.a.e();
            }
            bundle.putParcelable("bundle_key_swan_core", c.a.r0.a.q2.b.e(0));
            bundle.putParcelable("bundle_key_extension_core", c.a.r0.a.p0.b.c(0));
            bundle.putInt("bundle_key_preload_switch", c.a.r0.a.c1.a.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", c.a.r0.a.c1.a.g0().y());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", cVar.f9873f.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            cVar.m0(context, bundle);
        }
    }

    public static void h(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, cVar, bundle) == null) {
            SwanLauncher.j().l(new c(context, cVar, bundle));
        }
    }

    public static void i(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, cVar, bundle) == null) {
            if (c.a.r0.a.h0.s.e.a()) {
                h(context, cVar, bundle);
            } else if (f9865c) {
                h(context, cVar, bundle);
            } else {
                c.a.r0.a.p.e.j.c.a().b().a().b(new C0645b(context, cVar, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", c.a.r0.a.c1.a.g0().y());
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

    public static void m(Context context, c.a.r0.a.y1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, cVar, bundle) == null) {
            if (a) {
                e.k().u("b4 tryPreload client=" + cVar);
            }
            if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f9873f.isSwanAppProcess() || cVar.D()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (a) {
                String str = "SwanSailor：preloadScene:" + string;
            }
            if (c.a.r0.a.c1.a.w0().c()) {
                i(context, cVar, bundle);
                return;
            }
            c.a.r0.a.h0.s.e eVar = new c.a.r0.a.h0.s.e();
            eVar.a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            c.a.r0.a.c1.a.w0().b(eVar, new a(context, cVar, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            m g0 = c.a.r0.a.c1.a.g0();
            if (!c.a.r0.a.x1.a.a.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
