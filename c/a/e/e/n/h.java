package c.a.e.e.n;

import android.os.Build;
import android.text.TextUtils;
import c.a.e.e.p.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f2450a;

    /* renamed from: b  reason: collision with root package name */
    public String f2451b;

    /* renamed from: c  reason: collision with root package name */
    public String f2452c;

    /* renamed from: d  reason: collision with root package name */
    public String f2453d;

    /* renamed from: e  reason: collision with root package name */
    public String f2454e;

    /* renamed from: f  reason: collision with root package name */
    public String f2455f;

    /* renamed from: g  reason: collision with root package name */
    public String f2456g;

    /* renamed from: h  reason: collision with root package name */
    public String f2457h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f2458i;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? "3G" : (j.v() || j.z()) ? "4G" : "NONE" : (String) invokeV.objValue;
    }

    public void a(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f2458i == null) {
                this.f2458i = new HashMap();
            }
            String[] split2 = str.split("&");
            if (split2 == null || split2.length == 0) {
                return;
            }
            for (String str2 : split2) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                    try {
                        this.f2458i.put(split[0], URLDecoder.decode(split[1], "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        BdLog.e(e2);
                    }
                }
            }
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (this.f2458i == null) {
                this.f2458i = new HashMap();
            }
            this.f2458i.put(str, str2);
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (this.f2450a != null) {
                    jSONObject2.put("app_version", this.f2450a.f2426c);
                    jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                    jSONObject2.put("cuid", this.f2450a.f2430g);
                    jSONObject2.put("shoubai_cuid", this.f2450a.f2431h);
                    jSONObject2.put("from", this.f2450a.f2427d);
                    jSONObject2.put("uid", this.f2450a.l);
                }
                jSONObject2.put("client_ip", g.b());
                jSONObject2.put("network", d());
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put("brand", Build.BRAND);
                jSONObject2.put("os_type", "AND");
                jSONObject2.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject2.put("active_id", g.a());
                jSONObject2.put("mission_id", g.c());
                jSONObject.put("base_info", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                if (this.f2451b != null) {
                    jSONObject3.put("module", this.f2451b);
                }
                if (this.f2452c != null) {
                    jSONObject3.put("action", this.f2452c);
                }
                if (this.f2453d != null) {
                    jSONObject3.put("error_code", this.f2453d);
                }
                if (this.f2454e != null) {
                    jSONObject3.put("error_message", this.f2454e);
                }
                if (this.f2458i != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry : this.f2458i.entrySet()) {
                        sb.append(entry.getKey());
                        sb.append(":");
                        sb.append(entry.getValue());
                        sb.append("|");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    jSONObject3.put("ext1", sb);
                }
                if (this.f2455f != null) {
                    jSONObject3.put("id", this.f2455f);
                }
                if (this.f2456g != null) {
                    jSONObject3.put("title", this.f2456g);
                }
                if (this.f2457h != null) {
                    jSONObject3.put("abstract", this.f2457h);
                }
                jSONObject.put("debug_info", jSONObject3);
                jSONObject.put("kpi", new JSONObject());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f2452c = str;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f2450a = dVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f2453d = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f2454e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f2451b = str;
        }
    }
}
