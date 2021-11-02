package b.a.p0.a.e0.f.e;

import android.text.TextUtils;
import b.a.p0.a.j2.p.f;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4657a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f4658b;

    /* renamed from: c  reason: collision with root package name */
    public static b.a.p0.a.j2.a f4659c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f4660d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4661e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4662e;

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
            this.f4662e = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.f4657a;
                this.f4662e.e();
                this.f4662e.n();
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

        @Override // b.a.p0.a.e0.f.e.d
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f4657a) {
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
                b.a.p0.a.j2.b.d(d.f4659c, str, f());
            } else if (c2 == 1) {
                b.a.p0.a.j2.a aVar = d.f4659c;
                if (aVar != null) {
                    b.a.p0.a.j2.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                b.a.p0.a.j2.a aVar2 = d.f4659c;
                if (aVar2 != null) {
                    b.a.p0.a.j2.b.d(aVar2, str, f());
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

        @Override // b.a.p0.a.e0.f.e.d
        public void h(String str) {
            SwanAppActivity x;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.f4657a) {
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
                    b.a.p0.a.j2.a aVar = d.f4659c;
                    if (aVar != null) {
                        b.a.p0.a.j2.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                b.a.p0.a.j2.a aVar2 = d.f4659c;
                if (aVar2 != null) {
                    b.a.p0.a.j2.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (b.a.p0.a.a2.e.P() != null && (x = b.a.p0.a.a2.e.P().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f4661e) {
                    b.a.p0.a.j2.b.d(d.f4659c, str + "-preload", f());
                    boolean unused = d.f4661e = false;
                    return;
                }
                b.a.p0.a.j2.b.d(d.f4659c, str, f());
                return;
            }
            b.a.p0.a.j2.b.d(d.f4659c, str + "-destroy", f());
            boolean unused2 = d.f4661e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1395289800, "Lb/a/p0/a/e0/f/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1395289800, "Lb/a/p0/a/e0/f/e/d;");
                return;
            }
        }
        f4657a = k.f6397a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f fVar = new f();
            fVar.f6383a = "swan";
            fVar.f6384b = "launch";
            fVar.f6385c = "remote-debug";
            fVar.f6387e = "appready";
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f4658b == null) {
                synchronized (b.a.p0.a.g1.f.class) {
                    if (f4658b == null) {
                        if (b.a.h0.b.a.a.g()) {
                            f4658b = new b(null);
                        } else {
                            f4658b = new c(null);
                        }
                    }
                }
            }
            return f4658b;
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
        if (TextUtils.isEmpty(optString) || f4658b == null) {
            return;
        }
        f4658b.h(optString);
    }

    public static void j(b.a.p0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cVar) == null) {
            cVar.q0().putString("aiapp_extra_need_download", "1");
            cVar.q0().putString("aiapp_extra_pkg_downloading", "0");
            cVar.q0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            f fVar = new f();
            fVar.f6383a = b.a.p0.a.j2.k.m(cVar.F());
            fVar.j(cVar);
            fVar.f6384b = "launch";
            fVar.o = "1";
            fVar.f6385c = "remote-debug";
            JSONObject k = b.a.p0.a.j2.k.k(cVar.V());
            fVar.d(cVar.q0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(k);
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f fVar = new f();
            fVar.f6383a = "swan";
            fVar.f6384b = "launch";
            fVar.f6385c = "remote-debug";
            fVar.f6387e = "loadmaster";
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f fVar = new f();
            fVar.f6383a = "swan";
            fVar.f6384b = "launch";
            fVar.f6385c = "remote-debug";
            fVar.f6387e = "downloadstart";
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public static void m(b.a.p0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, cVar) == null) {
            f fVar = new f();
            fVar.j(cVar);
            fVar.f6383a = b.a.p0.a.j2.k.m(cVar.F());
            fVar.f6384b = "launch";
            fVar.f6385c = "remote-debug";
            fVar.f6387e = "downloadsuccess";
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f4659c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            jSONObject2.putOpt("appid", P == null ? "" : P.k());
            jSONObject2.putOpt("from", "remote-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            boolean z = f4657a;
        }
        b.a.p0.a.j2.b.f(f4659c, jSONObject.toString());
        b.a.p0.a.j2.b.c(f4659c);
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException unused) {
                boolean z = f4657a;
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public abstract void h(String str);

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = f4660d;
            if (timer != null) {
                timer.cancel();
                f4660d = null;
            }
            f4658b = null;
            f4659c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f4661e = true;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && f4659c == null) {
            b.a.p0.a.j2.a c2 = b.a.p0.a.j2.k.c("1153");
            f4659c = c2;
            if (!z) {
                b.a.p0.a.j2.b.d(c2, "downloadstart", f());
                b.a.p0.a.j2.b.d(f4659c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            f4660d = timer;
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
