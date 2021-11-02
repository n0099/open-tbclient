package b.a.p0.a.j2.q;

import android.text.TextUtils;
import b.a.p0.a.a2.d;
import b.a.p0.a.a2.e;
import b.a.p0.a.j2.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.w;
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

    /* renamed from: b.a.p0.a.j2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0272a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6393f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6394g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6395h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f6396i;

        public RunnableC0272a(int i2, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
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
            this.f6392e = i2;
            this.f6393f = str;
            this.f6394g = str2;
            this.f6395h = str3;
            this.f6396i = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f6392e;
                boolean z = (i2 == 2000 || i2 == 0) ? false : true;
                String m = k.m(d.g().l());
                JSONObject jSONObject = new JSONObject();
                w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.g().getAppId());
                w.f(jSONObject, "hostName", b.a.p0.a.c1.a.m().a());
                w.f(jSONObject, "network", b.a.p0.t.a.e());
                w.f(jSONObject, "launchid", d.g().r().K().U());
                if (z) {
                    w.f(jSONObject, "response", this.f6393f);
                    w.f(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, this.f6394g);
                    w.f(jSONObject, "request_url", this.f6395h);
                }
                a.d(m, this.f6396i.getClassify(), this.f6396i.getInterfaceName(), this.f6392e, jSONObject, z);
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
            q.i(new RunnableC0272a(i2, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
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
                if (e.y) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
