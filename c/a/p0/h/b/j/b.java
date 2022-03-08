package c.a.p0.h.b.j;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.d2.s.e;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1236804293, "Lc/a/p0/h/b/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1236804293, "Lc/a/p0/h/b/j/b;");
                return;
            }
        }
        a = new b();
    }

    public b() {
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

    public static b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (b) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            e eVar = new e();
            eVar.f4947b = "beforeConfigRequest";
            eVar.f4950e = str;
            n.g(eVar);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str5 = z != null ? z.configName : "";
            String str6 = z != null ? z.targetAppPackageId : "";
            String str7 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = str;
            eVar.f4952g = "gbview";
            eVar.f4950e = str2;
            eVar.a("gameAppkey", str3);
            eVar.a("gamePosition", str4);
            eVar.a("configName", str5);
            eVar.a("targetPackageName", str6);
            eVar.a("targetDownloadUrl", str7);
            n.g(eVar);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = str;
            eVar.f4952g = "gbview";
            eVar.a("configName", str2);
            eVar.a("targetPackageName", str3);
            eVar.a("targetDownloadUrl", str4);
            if (str3.equals(c.a.p0.h.b.e.c.a)) {
                if (q0.F(c.a.p0.a.s0.a.c(), str3)) {
                    eVar.a("isGamenowInstalled", "1");
                } else {
                    eVar.a("isGamenowInstalled", "2");
                }
            }
            n.g(eVar);
        }
    }

    public void d(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            e eVar = new e();
            eVar.f4947b = "request";
            eVar.f4952g = "wdview";
            eVar.a("requestStatus", str);
            eVar.a("isFromNet", z ? "0" : "1");
            eVar.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            n.g(eVar);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str7 = z != null ? z.configName : "";
            String str8 = z != null ? z.targetAppPackageId : "";
            String str9 = z != null ? z.targetAppDownloadUrl : "";
            if (!TextUtils.equals(str8, c.a.p0.h.b.e.c.a)) {
                str6 = str9;
            }
            e eVar = new e();
            eVar.f4947b = str;
            eVar.f4952g = str2;
            eVar.f4950e = str3;
            eVar.a("gameAppkey", str4);
            eVar.a("gamePosition", str5);
            eVar.a("configName", str7);
            eVar.a("targetPackageName", str8);
            eVar.a("targetDownloadUrl", str6);
            n.g(eVar);
        }
    }

    public void f(String str, a aVar, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, aVar, str2, str3, str4) == null) {
            JSONObject d2 = w.d(str3);
            c cVar = new c();
            cVar.g(aVar);
            cVar.f4947b = str;
            cVar.f4952g = d2.optString("from_view");
            cVar.f4950e = d2.optString("from_value");
            cVar.a("configName", d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            cVar.a("targetPackageName", str2);
            cVar.a("targetDownloadUrl", str4);
            n.g(cVar);
        }
    }

    public void g(String str, a aVar, String str2, String str3, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, aVar, str2, str3, Integer.valueOf(i2), str4}) == null) {
            JSONObject d2 = w.d(str3);
            long optLong = d2.optLong("download_finish_time");
            long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
            c cVar = new c();
            cVar.g(aVar);
            cVar.f4950e = d2.optString("from_value");
            cVar.f4947b = str;
            cVar.f4952g = d2.optString("from_view");
            cVar.a("error_code", Integer.valueOf(i2));
            cVar.a("configName", d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (elapsedRealtime != 0) {
                cVar.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
            }
            cVar.a("targetPackageName", str2);
            cVar.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                cVar.a("downloadStatus", d2.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d2.optLong("download_current_bytes");
                long optLong3 = d2.optLong("download_total_bytes");
                cVar.a("downloadCurrentBytes", Long.valueOf(optLong2));
                cVar.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            n.x("936", cVar);
        }
    }

    public void h(String str, a aVar, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, aVar, str2, str3, str4) == null) {
            g(str, aVar, str2, str3, 0, str4);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = "guideClick";
            eVar.f4952g = "wdview";
            eVar.a("guideViewNum", String.valueOf(i2));
            eVar.a("configName", str);
            eVar.a("targetPackageName", str2);
            eVar.a("targetDownloadUrl", str3);
            n.g(eVar);
        }
    }

    public void j(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i2, i3) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = "wdDialogClick";
            eVar.f4952g = "wdview";
            eVar.f4950e = str;
            eVar.a("coinsThisTime", String.valueOf(i2));
            eVar.a("coinsTotal", String.valueOf(i3));
            eVar.a("configName", str2);
            eVar.a("targetPackageName", str3);
            eVar.a("targetDownloadUrl", str4);
            n.g(eVar);
        }
    }

    public void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = "wdDialogShow";
            eVar.f4952g = "wdview";
            eVar.a("coinsThisTime", String.valueOf(i2));
            eVar.a("coinsTotal", String.valueOf(i3));
            eVar.a("configName", str);
            eVar.a("targetPackageName", str2);
            eVar.a("targetDownloadUrl", str3);
            if (str2.equals(c.a.p0.h.b.e.c.a)) {
                if (q0.F(c.a.p0.a.s0.a.c(), str2)) {
                    eVar.a("isGamenowInstalled", "1");
                } else {
                    eVar.a("isGamenowInstalled", "2");
                }
            }
            n.g(eVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4947b = "guideShow";
            eVar.f4952g = "wdview";
            eVar.a("configName", str);
            eVar.a("targetPackageName", str2);
            eVar.a("targetDownloadUrl", str3);
            n.g(eVar);
        }
    }

    public void m(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i2) == null) {
            GameGuideConfigInfo z = c.a.p0.h.b.b.o.z();
            String str3 = z != null ? z.configName : "";
            String str4 = z != null ? z.targetAppPackageId : "";
            String str5 = z != null ? z.targetAppDownloadUrl : "";
            e eVar = new e();
            eVar.f4952g = str;
            eVar.f4950e = str2;
            eVar.a("configName", str3);
            eVar.a("targetPackageName", str4);
            eVar.a("targetDownloadUrl", str5);
            eVar.a("GamenowDownloadStatus", Integer.valueOf(i2));
            n.g(eVar);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.a.x.c.a.b.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void p(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String d2 = c.a.p0.j.u.a.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", c.a.p0.a.s0.a.h0().i(c.a.p0.a.s0.a.c()));
                jSONObject.put("type", i2);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", c.a.p0.a.s0.a.n().a());
                jSONObject.put("version", q0.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) c.a.p0.p.e.a.h(c.a.p0.a.s0.a.c()).postRequest().cookieManager(c.a.p0.a.s0.a.q().a())).url(d2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i2, String str, String str2, int i3, String str3, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String d2 = c.a.p0.j.u.a.b().d();
            JSONObject jSONObject = new JSONObject();
            String str4 = TextUtils.equals(str, c.a.p0.h.b.e.c.a) ? "2101000000" : "";
            c.a.p0.h.b.b bVar = c.a.p0.h.b.b.o;
            if (bVar != null && bVar.z() != null && !TextUtils.isEmpty(c.a.p0.h.b.b.o.z().gamenowChannel)) {
                str4 = c.a.p0.h.b.b.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i2);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j2);
                jSONObject.put("totalBytes", j3);
                jSONObject.put("errorReason", i3);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) c.a.p0.p.e.a.h(c.a.p0.a.s0.a.c()).postRequest().cookieManager(c.a.p0.a.s0.a.q().a())).url(d2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
