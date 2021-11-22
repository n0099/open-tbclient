package b.a.p0.a.n2.u;

import android.text.TextUtils;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.f;
import b.a.p0.a.k;
import b.a.p0.a.n2.b;
import b.a.p0.a.n2.n;
import b.a.p0.a.n2.s.e;
import b.a.p0.a.z2.q;
import com.alipay.sdk.cons.c;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7393a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.n2.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0333a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7394e;

        public RunnableC0333a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7394e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("4165", this.f7394e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1609834295, "Lb/a/p0/a/n2/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1609834295, "Lb/a/p0/a/n2/u/a;");
                return;
            }
        }
        f7393a = k.f6863a;
    }

    public static String a(Response response) {
        InterceptResult invokeL;
        ResponseBody body;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, response)) == null) {
            if (response == null || (body = response.body()) == null) {
                return "";
            }
            JSONObject jSONObject = null;
            try {
                str = body.string();
            } catch (IOException e2) {
                if (f7393a) {
                    e2.printStackTrace();
                }
                str = null;
            }
            if (str == null) {
                return "";
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e3) {
                if (f7393a) {
                    e3.printStackTrace();
                }
            }
            return jSONObject == null ? "" : jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) || TextUtils.equals(str, "getLocation")) {
            return;
        }
        c(str, i2, str2, i3, str3, null);
    }

    public static void c(String str, int i2, String str2, int i3, String str3, Response response) {
        f H;
        b.a.p0.a.p.e.b l3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, response}) == null) {
            e eVar = new e();
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null || (H = b.a.p0.a.g1.f.U().H()) == null || (l3 = H.l3()) == null) {
                return;
            }
            String n = l3.n();
            b.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            String W = V.W();
            String v1 = V.v1();
            String i4 = b.a.p0.a.q2.b.i(b.a.p0.a.g1.f.U().M(), V.G());
            String a2 = a(response);
            String d2 = NetworkUtils.d();
            eVar.f7379a = n.n(V.G());
            eVar.f7381c = a0.V().T();
            eVar.f7382d = a0.V().V();
            eVar.f7384f = appId;
            eVar.a("name", Y);
            eVar.a(c.n, str);
            eVar.a("errorCode", String.valueOf(i2));
            eVar.a("errorMsg", str2);
            eVar.a("pagePath", n);
            if (i3 != -1) {
                eVar.a("oldErrorCode", String.valueOf(i3));
            }
            eVar.a("oldErrorMsg", str3);
            eVar.a("scheme", W);
            eVar.a("appVersion", v1);
            eVar.a("swan", i4);
            eVar.a(BaseJsonData.TAG_REQUESTID, a2);
            eVar.a("net", d2);
            if (b.a.p0.q.c.b() != null) {
                eVar.a("SDKVersion", b.a.p0.q.c.b().b());
                eVar.a("hostName", b.a.p0.q.c.b().c());
            }
            q.j(new RunnableC0333a(eVar), "monitor");
        }
    }
}
