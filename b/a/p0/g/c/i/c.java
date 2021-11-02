package b.a.p0.g.c.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10140a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163599750, "Lb/a/p0/g/c/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163599750, "Lb/a/p0/g/c/i/c;");
                return;
            }
        }
        f10140a = k.f6397a;
    }

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, aVar) == null) {
            String l = b.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (f10140a) {
                String str5 = "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b bVar = new b();
            bVar.m(aVar);
            bVar.f6384b = l;
            bVar.f6387e = str3;
            bVar.v = str;
            bVar.l = q0.D();
            if (e.P() != null) {
                b.a K = e.P().K();
                bVar.f6383a = b.a.p0.a.j2.k.m(K.F());
                bVar.f6388f = K.G();
                bVar.f6385c = K.S();
            }
            bVar.t = str4;
            b.a.p0.a.j2.k.u("1245", bVar);
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
            bVar.f6384b = l;
            bVar.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            bVar.a("packageName", str3);
            b.a.p0.a.j2.k.u("1245", bVar);
        }
    }

    public static void d(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String c2 = b.a.p0.h.t.a.b().c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()));
                jSONObject.put("type", i2);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", b.a.p0.a.c1.a.m().a());
                jSONObject.put("version", q0.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) b.a.p0.m.e.a.h(b.a.p0.a.c1.a.b()).postRequest().cookieManager(b.a.p0.a.c1.a.p().a())).url(c2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
