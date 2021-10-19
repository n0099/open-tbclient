package c.b.a.u1;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.embedapplog.util.UriConfig;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final UriConfig f31462a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-315903430, "Lc/b/a/u1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-315903430, "Lc/b/a/u1/a;");
                return;
            }
        }
        UriConfig.b bVar = new UriConfig.b();
        bVar.a("https://log.snssdk.com/service/2/device_register_only/");
        bVar.e("https://ichannel.snssdk.com/service/2/app_alert_check/");
        bVar.b(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"});
        bVar.f(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"});
        bVar.h("https://log.snssdk.com/service/2/log_settings/");
        bVar.c();
        UriConfig.b bVar2 = new UriConfig.b();
        bVar2.a("https://toblog.ctobsnssdk.com/service/2/device_register_only/");
        bVar2.e("https://toblog.ctobsnssdk.com/service/2/app_alert_check/");
        bVar2.b(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"});
        bVar2.h("https://toblog.ctobsnssdk.com/service/2/log_settings/");
        bVar2.j("https://toblog.ctobsnssdk.com/service/2/abtest_config/");
        bVar2.l("https://success.ctobsnssdk.com/service/2/app_log/");
        f31462a = bVar2.c();
    }

    public static final UriConfig a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? f31462a : (UriConfig) invokeI.objValue;
    }
}
