package c.a.n0.a.d2.u;

import android.text.TextUtils;
import c.a.n0.a.d2.b;
import c.a.n0.a.d2.n;
import c.a.n0.a.d2.s.e;
import c.a.n0.a.p2.q;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.f;
import c.a.n0.q.c;
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
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.d2.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0247a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public RunnableC0247a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1631331168, "Lc/a/n0/a/d2/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1631331168, "Lc/a/n0/a/d2/u/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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
                if (a) {
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
                if (a) {
                    e3.printStackTrace();
                }
            }
            return jSONObject == null ? "" : jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) || TextUtils.equals(str, "getLocation")) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        f H;
        c.a.n0.a.f.e.b m3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            e eVar = new e();
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null || (H = c.a.n0.a.w0.f.U().H()) == null || (m3 = H.m3()) == null) {
                return;
            }
            String o = m3.o();
            b.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            String W = V.W();
            String v1 = V.v1();
            String i3 = c.a.n0.a.g2.b.i(c.a.n0.a.w0.f.U().M(), V.G());
            String a2 = a(response);
            String d2 = NetworkUtils.d();
            eVar.a = n.n(V.G());
            eVar.f4189c = a0.V().T();
            eVar.f4190d = a0.V().V();
            eVar.f4192f = appId;
            eVar.a("name", Y);
            eVar.a("apiName", str);
            eVar.a("errorCode", String.valueOf(i));
            eVar.a("errorMsg", str2);
            eVar.a("pagePath", o);
            if (i2 != -1) {
                eVar.a("oldErrorCode", String.valueOf(i2));
            }
            eVar.a("oldErrorMsg", str3);
            eVar.a("scheme", W);
            eVar.a("appVersion", v1);
            eVar.a("swan", i3);
            eVar.a(BaseJsonData.TAG_REQUESTID, a2);
            eVar.a("net", d2);
            if (c.b() != null) {
                eVar.a("SDKVersion", c.b().b());
                eVar.a("hostName", c.b().c());
            }
            q.j(new RunnableC0247a(eVar), "monitor");
        }
    }
}
