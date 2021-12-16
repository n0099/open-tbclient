package c.a.q0.a.e0.f.e;

import android.text.TextUtils;
import c.a.q0.a.k;
import c.a.q0.a.n2.m;
import c.a.q0.a.n2.n;
import c.a.q0.a.n2.s.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f5059b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.q0.a.n2.a f5060c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f5061d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f5062e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5063e;

        public a(d dVar) {
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
                    return;
                }
            }
            this.f5063e = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.a;
                this.f5063e.e();
                this.f5063e.n();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.q0.a.e0.f.e.d
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (d.a) {
                String str2 = "remote-debug statistic event name is : " + str;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c2 = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c2 = 2;
                }
            } else if (str.equals("downloadstart")) {
                c2 = 0;
            }
            if (c2 == 0) {
                p(true);
                c.a.q0.a.n2.b.d(d.f5060c, str, f());
            } else if (c2 == 1) {
                c.a.q0.a.n2.a aVar = d.f5060c;
                if (aVar != null) {
                    c.a.q0.a.n2.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                c.a.q0.a.n2.a aVar2 = d.f5060c;
                if (aVar2 != null) {
                    c.a.q0.a.n2.b.d(aVar2, str, f());
                }
            } else {
                e();
                n();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.q0.a.e0.f.e.d
        public void h(String str) {
            SwanAppActivity x;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.a) {
                String str2 = "remote-debug statistic event name is : " + str;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 511060680) {
                if (hashCode == 900970612 && str.equals("pageready")) {
                    c2 = 1;
                }
            } else if (str.equals("loadmaster")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    c.a.q0.a.n2.a aVar = d.f5060c;
                    if (aVar != null) {
                        c.a.q0.a.n2.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                c.a.q0.a.n2.a aVar2 = d.f5060c;
                if (aVar2 != null) {
                    c.a.q0.a.n2.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (c.a.q0.a.d2.e.a0() != null && (x = c.a.q0.a.d2.e.a0().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f5062e) {
                    c.a.q0.a.n2.b.d(d.f5060c, str + "-preload", f());
                    boolean unused = d.f5062e = false;
                    return;
                }
                c.a.q0.a.n2.b.d(d.f5060c, str, f());
                return;
            }
            c.a.q0.a.n2.b.d(d.f5060c, str + "-destroy", f());
            boolean unused2 = d.f5062e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1397046518, "Lc/a/q0/a/e0/f/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1397046518, "Lc/a/q0/a/e0/f/e/d;");
                return;
            }
        }
        a = k.a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            f fVar = new f();
            fVar.a = "swan";
            fVar.f7422b = "launch";
            fVar.f7423c = "remote-debug";
            fVar.f7425e = "appready";
            n.onEvent(fVar);
        }
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f5059b == null) {
                synchronized (c.a.q0.a.g1.f.class) {
                    if (f5059b == null) {
                        if (c.a.j0.b.a.a.g()) {
                            f5059b = new b(null);
                        } else {
                            f5059b = new c(null);
                        }
                    }
                }
            }
            return f5059b;
        }
        return (d) invokeV.objValue;
    }

    public static void i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f5059b == null) {
            return;
        }
        f5059b.h(optString);
    }

    public static void j(c.a.q0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cVar) == null) {
            cVar.s0().putString("aiapp_extra_need_download", "1");
            cVar.s0().putString("aiapp_extra_pkg_downloading", "0");
            cVar.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            f fVar = new f();
            fVar.a = n.n(cVar.G());
            fVar.j(cVar);
            fVar.f7422b = "launch";
            fVar.o = "1";
            fVar.f7423c = "remote-debug";
            JSONObject k2 = n.k(cVar.W());
            fVar.d(cVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(k2);
            n.onEvent(fVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f fVar = new f();
            fVar.a = "swan";
            fVar.f7422b = "launch";
            fVar.f7423c = "remote-debug";
            fVar.f7425e = "loadmaster";
            n.onEvent(fVar);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f fVar = new f();
            fVar.a = "swan";
            fVar.f7422b = "launch";
            fVar.f7423c = "remote-debug";
            fVar.f7425e = "downloadstart";
            n.onEvent(fVar);
        }
    }

    public static void m(c.a.q0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, cVar) == null) {
            f fVar = new f();
            fVar.j(cVar);
            fVar.a = n.n(cVar.G());
            fVar.f7422b = "launch";
            fVar.f7423c = "remote-debug";
            fVar.f7425e = "downloadsuccess";
            n.onEvent(fVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f5060c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            jSONObject2.putOpt("appid", a0 == null ? "" : a0.N());
            jSONObject2.putOpt("from", "remote-debug");
            m.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            boolean z = a;
        }
        c.a.q0.a.n2.b.f(f5060c, jSONObject.toString());
        c.a.q0.a.n2.b.c(f5060c);
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException unused) {
                boolean z = a;
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public abstract void h(String str);

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = f5061d;
            if (timer != null) {
                timer.cancel();
                f5061d = null;
            }
            f5059b = null;
            f5060c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f5062e = true;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && f5060c == null) {
            c.a.q0.a.n2.a c2 = n.c("1153");
            f5060c = c2;
            if (!z) {
                c.a.q0.a.n2.b.d(c2, "downloadstart", f());
                c.a.q0.a.n2.b.d(f5060c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            f5061d = timer;
            timer.schedule(new a(this), 40000L);
        }
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
            }
        }
    }
}
