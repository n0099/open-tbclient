package c.a.q0.a.n2.t;

import android.text.TextUtils;
import c.a.q0.a.d2.d;
import c.a.q0.a.d2.e;
import c.a.q0.a.n2.b;
import c.a.q0.a.n2.n;
import c.a.q0.a.z2.q;
import c.a.q0.a.z2.w;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.a.n2.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0422a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7432f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7433g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7434h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f7435i;

        public RunnableC0422a(int i2, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, str3, swanInterfaceType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7431e = i2;
            this.f7432f = str;
            this.f7433g = str2;
            this.f7434h = str3;
            this.f7435i = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f7431e;
                boolean z = (i2 == 2000 || i2 == 0) ? false : true;
                String n = n.n(d.J().l());
                JSONObject jSONObject = new JSONObject();
                w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.J().getAppId());
                w.f(jSONObject, "hostName", c.a.q0.a.c1.a.n().a());
                w.f(jSONObject, "network", c.a.q0.w.a.e());
                w.f(jSONObject, "launchid", d.J().r().V().V());
                if (z) {
                    w.f(jSONObject, "response", this.f7432f);
                    w.f(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, this.f7433g);
                    w.f(jSONObject, "request_url", this.f7434h);
                }
                a.d(n, this.f7435i.getClassify(), this.f7435i.getInterfaceName(), this.f7431e, jSONObject, z);
            }
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, swanInterfaceType) == null) {
            c(swanInterfaceType, 2000, null, null);
        }
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{swanInterfaceType, Integer.valueOf(i2), str, str2, str3}) == null) {
            q.j(new RunnableC0422a(i2, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
        }
    }

    public static void c(SwanInterfaceType swanInterfaceType, int i2, String str, Response response) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, null, swanInterfaceType, i2, str, response) == null) {
            String str3 = null;
            if (response != null) {
                String valueOf = String.valueOf(response.code());
                str3 = response.request().url().toString();
                str2 = valueOf;
            } else {
                str2 = null;
            }
            b(swanInterfaceType, i2, str3, str2, str);
        }
    }

    public static void d(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", str);
                jSONObject2.put("type", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("page", str3);
                }
                jSONObject2.put("value", String.valueOf(i2));
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                b.k("874", jSONObject2);
                if (z) {
                    b.i("2486", "86", jSONObject2);
                }
            } catch (JSONException e2) {
                if (e.z) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
