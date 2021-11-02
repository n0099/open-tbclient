package b.a.p0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.v2.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5360a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5361b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5362c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597462479, "Lb/a/p0/a/h0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597462479, "Lb/a/p0/a/h0/i/c;");
                return;
            }
        }
        f5360a = String.format("框架加载后%s秒无内容绘制；", 3);
        f5361b = "检测到白屏区域超过" + a(0.7d) + "；";
        f5362c = "检测到白屏区域超过" + a(0.5d) + "且正在loading；";
    }

    public static String a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) {
            return ((int) (d2 * 100.0d)) + "%";
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(String str, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, gVar)) == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(gVar.b());
            int f2 = gVar.f();
            if (f2 == 0) {
                sb.append("业务请求：无异常；");
            } else if (f2 == 4) {
                sb.append("业务请求：失败率超");
                sb.append(a(0.5d));
                sb.append("；");
            } else if (f2 != 8) {
                sb.append("业务请求：未知；");
            } else {
                sb.append("业务请求：响应缓慢；");
            }
            int i2 = gVar.f5370b;
            if (i2 > 0) {
                sb.append(String.format("共发起请求%s个，失败%s个，缓慢%s个；", Integer.valueOf(i2), Integer.valueOf(gVar.f5371c.size()), Integer.valueOf(gVar.f5372d.size())));
            }
            int d2 = gVar.d();
            if (d2 == 0) {
                sb.append("网络：正常；");
            } else if (d2 == 1) {
                sb.append("网络：弱网；");
            } else if (d2 != 2) {
                sb.append("网络：未知；");
            } else {
                sb.append("网络：离线；");
            }
            String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
            for (Map.Entry<String, Integer> entry : gVar.f5372d.entrySet()) {
                try {
                    sb.append(String.format("\n%s请求%s耗时较长：%s ms", g2, new URL(entry.getKey()).getPath(), entry.getValue()));
                } catch (MalformedURLException e2) {
                    if (b.a.p0.a.k.f6397a) {
                        e2.printStackTrace();
                    }
                }
            }
            for (String str2 : gVar.f5371c) {
                try {
                    sb.append(String.format("\n%s请求%s请求失败；", g2, new URL(str2).getPath()));
                } catch (MalformedURLException e3) {
                    if (b.a.p0.a.k.f6397a) {
                        e3.printStackTrace();
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, @NonNull g gVar, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, gVar, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append(String.format(Locale.getDefault(), "%d秒截屏; ", Long.valueOf(j / 1000)));
            sb.append(z ? "框架预加载：已完成; " : "框架预加载：未完成; ");
            return b(sb.toString(), gVar);
        }
        return (String) invokeCommon.objValue;
    }
}
