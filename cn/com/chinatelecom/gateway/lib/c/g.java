package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwai.video.player.KsMediaMeta;
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
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1576a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    public static String a() {
        String hostAddress;
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
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress() && (hostAddress = nextElement2.getHostAddress()) != null && f1576a.matcher(hostAddress).matches()) {
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

    public static String a(Context context, String str, String str2, String str3, String str4) {
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

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        String a2 = cn.com.chinatelecom.gateway.lib.a.d.a(str3, cn.com.chinatelecom.gateway.lib.a.d.a());
        String a3 = cn.com.chinatelecom.gateway.lib.a.a.a(a(map, "&"), str3);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        hashMap.put("clientType", "30020");
        hashMap.put(KsMediaMeta.KSM_KEY_FORMAT, "json");
        hashMap.put("paramKey", a2);
        hashMap.put("paramStr", a3);
        hashMap.put("version", "3.0");
        hashMap.put("sign", b(hashMap, str2));
        return a(hashMap, "&");
    }

    public static String a(Map<String, String> map, String str) {
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

    public static String b(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: cn.com.chinatelecom.gateway.lib.c.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        Iterator it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + ((String) ((Map.Entry) it.next()).getValue());
        }
        return cn.com.chinatelecom.gateway.lib.a.c.b(cn.com.chinatelecom.gateway.lib.a.c.a(str2, str));
    }
}
