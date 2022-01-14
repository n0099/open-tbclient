package c.a.r0.i.b.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.q0;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1207040860, "Lc/a/r0/i/b/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1207040860, "Lc/a/r0/i/b/i/c;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, aVar) == null) {
            String l = b.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (a) {
                String str5 = "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b bVar = new b();
            bVar.m(aVar);
            bVar.f7977b = l;
            bVar.f7980e = str3;
            bVar.v = str;
            bVar.l = q0.D();
            if (e.a0() != null) {
                b.a V = e.a0().V();
                bVar.a = n.n(V.G());
                bVar.f7981f = V.H();
                bVar.f7978c = V.T();
            }
            bVar.t = str4;
            n.x("1245", bVar);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            c(str, str2, "");
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            String l = b.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            b bVar = new b();
            bVar.f7977b = l;
            bVar.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            bVar.a("packageName", str3);
            n.x("1245", bVar);
        }
    }

    public static void d(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String d2 = c.a.r0.j.u.a.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c()));
                jSONObject.put("type", i2);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", c.a.r0.a.c1.a.n().a());
                jSONObject.put("version", q0.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) c.a.r0.p.e.a.h(c.a.r0.a.c1.a.c()).postRequest().cookieManager(c.a.r0.a.c1.a.q().a())).url(d2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
