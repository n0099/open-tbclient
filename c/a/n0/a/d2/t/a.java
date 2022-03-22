package c.a.n0.a.d2.t;

import android.text.TextUtils;
import c.a.n0.a.d2.b;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.w;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.d2.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0246a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4195b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4196c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4197d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f4198e;

        public RunnableC0246a(int i, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, str3, swanInterfaceType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f4195b = str;
            this.f4196c = str2;
            this.f4197d = str3;
            this.f4198e = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                boolean z = (i == 2000 || i == 0) ? false : true;
                String n = n.n(d.J().l());
                JSONObject jSONObject = new JSONObject();
                w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.J().getAppId());
                w.f(jSONObject, "hostName", c.a.n0.a.s0.a.n().a());
                w.f(jSONObject, "network", c.a.n0.w.a.e());
                w.f(jSONObject, "launchid", d.J().r().V().V());
                if (z) {
                    w.f(jSONObject, "response", this.f4195b);
                    w.f(jSONObject, "statusCode", this.f4196c);
                    w.f(jSONObject, "request_url", this.f4197d);
                }
                a.d(n, this.f4198e.getClassify(), this.f4198e.getInterfaceName(), this.a, jSONObject, z);
            }
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, swanInterfaceType) == null) {
            c(swanInterfaceType, 2000, null, null);
        }
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{swanInterfaceType, Integer.valueOf(i), str, str2, str3}) == null) {
            q.j(new RunnableC0246a(i, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
        }
    }

    public static void c(SwanInterfaceType swanInterfaceType, int i, String str, Response response) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, null, swanInterfaceType, i, str, response) == null) {
            String str3 = null;
            if (response != null) {
                String valueOf = String.valueOf(response.code());
                str3 = response.request().url().toString();
                str2 = valueOf;
            } else {
                str2 = null;
            }
            b(swanInterfaceType, i, str3, str2, str);
        }
    }

    public static void d(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", str);
                jSONObject2.put("type", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("page", str3);
                }
                jSONObject2.put("value", String.valueOf(i));
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                b.k("874", jSONObject2);
                if (z) {
                    b.i("2486", AddressEditActivity.CHINA_REGION_CODE, jSONObject2);
                }
            } catch (JSONException e2) {
                if (e.v) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
