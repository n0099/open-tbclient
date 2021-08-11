package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f35469a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293515266, "Lcn/com/chinatelecom/gateway/lib/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293515266, "Lcn/com/chinatelecom/gateway/lib/c/g;");
                return;
            }
        }
        f35469a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    }

    public static String a() {
        InterceptResult invokeV;
        String hostAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    String name = nextElement.getName();
                    if (name == null || (!name.contains("wlan") && !name.equals("eth0"))) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && (hostAddress = nextElement2.getHostAddress()) != null && f35469a.matcher(hostAddress).matches()) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(",");
                                }
                                stringBuffer.append(hostAddress);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, context, str, str2, str3, str4)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pipl", a());
            hashMap.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, Long.toString(System.currentTimeMillis()));
            hashMap.put("bussinessType", str3);
            hashMap.put("rl", "00000");
            hashMap.put(CommandMessage.SDK_VERSION, "SDK-JJ-v3.6.2");
            hashMap.put("networkType", f.f(context));
            hashMap.put("onlineType", f.g(context));
            return a(str, str2, hashMap, str4);
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, map, str3)) == null) {
            String a2 = cn.com.chinatelecom.gateway.lib.a.d.a(str3, cn.com.chinatelecom.gateway.lib.a.d.a());
            String a3 = cn.com.chinatelecom.gateway.lib.a.a.a(a(map, "&"), str3);
            HashMap hashMap = new HashMap();
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            hashMap.put("clientType", "30020");
            hashMap.put("format", "json");
            hashMap.put("paramKey", a2);
            hashMap.put("paramStr", a3);
            hashMap.put("version", "3.0");
            hashMap.put("sign", b(hashMap, str2));
            return a(hashMap, "&");
        }
        return (String) invokeLLLL.objValue;
    }

    public static String a(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                if (TextUtils.isEmpty(str)) {
                    str = "&";
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(str);
                }
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, map, str)) == null) {
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: cn.com.chinatelecom.gateway.lib.c.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL2.intValue;
                }
            });
            Iterator it = arrayList.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + ((String) ((Map.Entry) it.next()).getValue());
            }
            return cn.com.chinatelecom.gateway.lib.a.c.b(cn.com.chinatelecom.gateway.lib.a.c.a(str2, str));
        }
        return (String) invokeLL.objValue;
    }
}
