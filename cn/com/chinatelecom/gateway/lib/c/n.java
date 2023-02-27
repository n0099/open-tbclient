package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.notification.model.AdvertisementOption;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293515049, "Lcn/com/chinatelecom/gateway/lib/c/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293515049, "Lcn/com/chinatelecom/gateway/lib/c/n;");
                return;
            }
        }
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    }

    public static String a() {
        InterceptResult invokeV;
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
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                                String hostAddress = nextElement2.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (stringBuffer.length() > 0) {
                                        stringBuffer.append(",");
                                    }
                                    stringBuffer.append(hostAddress);
                                }
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
            hashMap.put("rl", "00000");
            hashMap.put("bussinessType", str3);
            hashMap.put("sdkversion", "SDK-JJ-v3.7.5");
            hashMap.put("networkType", cn.com.chinatelecom.gateway.lib.b.a.g(context));
            hashMap.put(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE, cn.com.chinatelecom.gateway.lib.b.a.h(context));
            hashMap.put(AdvertisementOption.AD_INSTALL_PACKAGE, context.getPackageName());
            String a = cn.com.chinatelecom.gateway.lib.a.d.a(str4, cn.com.chinatelecom.gateway.lib.a.d.a());
            String a2 = cn.com.chinatelecom.gateway.lib.a.a.a(a(hashMap, "&"), str4);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            hashMap2.put("clientType", "30020");
            hashMap2.put("format", "json");
            hashMap2.put("paramKey", a);
            hashMap2.put("paramStr", a2);
            hashMap2.put("version", "3.0");
            hashMap2.put("sign", b(hashMap2, str2));
            return a(hashMap2, "&");
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String a(Map map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                if (TextUtils.isEmpty(str)) {
                    str = "&";
                }
                for (Map.Entry entry : map.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(str);
                }
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Map map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, str)) == null) {
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new o());
            Iterator it = arrayList.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + ((String) ((Map.Entry) it.next()).getValue());
            }
            return cn.com.chinatelecom.gateway.lib.a.c.a(cn.com.chinatelecom.gateway.lib.a.c.a(str2, str));
        }
        return (String) invokeLL.objValue;
    }
}
