package c.a.p0.y.l.b.a;

import android.text.TextUtils;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.z2.n0;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2110415831, "Lc/a/p0/y/l/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2110415831, "Lc/a/p0/y/l/b/a/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, str3, jSONObject) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                    jSONObject2.put("vtype", str3);
                    jSONObject.putOpt("videoId", str);
                    jSONObject2.put("data", jSONObject.toString());
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                d.b("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
                c.a.p0.a.a3.g.c.a.d(str2, str, "video", str3, jSONObject2);
            } else if (a) {
                String str4 = "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str;
            }
        }
    }

    public static void b(String str, String str2, String str3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            String format = TextUtils.isEmpty(str3) ? "0" : new DecimalFormat("#.###").format(Double.parseDouble(str3) / 1000.0d);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Float.valueOf(Float.parseFloat(format)));
                jSONObject.putOpt("width", Integer.valueOf(n0.P(i2)));
                jSONObject.putOpt("height", Integer.valueOf(n0.P(i3)));
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            a(str, str2, "loadedmetadata", jSONObject);
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("fullscreen", z ? "1" : "0");
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            a(str, str2, "fullscreenchange", jSONObject);
        }
    }
}
