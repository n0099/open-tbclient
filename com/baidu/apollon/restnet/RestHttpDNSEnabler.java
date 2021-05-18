package com.baidu.apollon.restnet;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobstat.Config;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class RestHttpDNSEnabler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3795a = "RestHttpDNSEnabler";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3796b = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    /* renamed from: c  reason: collision with root package name */
    public static Pattern f3797c = Pattern.compile(f3796b);

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f3798d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public static long f3799e = 86400;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3802a;

        /* renamed from: b  reason: collision with root package name */
        public long f3803b;

        /* renamed from: c  reason: collision with root package name */
        public long f3804c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3805d;

        public a(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.f3799e);
        }

        public a(String str, long j, long j2) {
            this.f3802a = str;
            this.f3803b = j;
            this.f3804c = j2;
        }
    }

    public static boolean c(String str) {
        for (Map.Entry<String, a> entry : f3798d.entrySet()) {
            if (entry.getValue().f3802a.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void enableHttpDns(final Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (f3798d.containsKey(str)) {
                return;
            }
            new Thread(new Runnable() { // from class: com.baidu.apollon.restnet.RestHttpDNSEnabler.1
                @Override // java.lang.Runnable
                public void run() {
                    RestTemplate restTemplate = new RestTemplate(context.getApplicationContext());
                    restTemplate.setMessageConverter(new b());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new RestNameValuePair(Config.DEVICE_NAME, str));
                    try {
                        String str2 = (String) restTemplate.a("http://180.76.76.112/", arrayList, "utf-8", String.class);
                        if (str2 instanceof String) {
                            String trim = str2.trim();
                            if (trim.contains(" ")) {
                                String[] split = trim.split(" ");
                                trim = split[new Random().nextInt(split.length)];
                            }
                            LogUtil.v("apollon_rest", "result: " + trim);
                            if (TextUtils.isEmpty(trim) || !RestHttpDNSEnabler.a(trim)) {
                                return;
                            }
                            synchronized (RestHttpDNSEnabler.f3798d) {
                                RestHttpDNSEnabler.f3798d.put(str, new a(trim));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
            return;
        }
        String str2 = f3795a;
        LogUtil.w(str2, f3795a + " enableHttpDns params context is null or hostName is null.");
    }

    public static boolean a(String str) {
        return f3797c.matcher(str).matches();
    }

    public static void b(String str) {
        if (a(str)) {
            Iterator<Map.Entry<String, a>> it = f3798d.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().f3802a.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public static String a(URL url) {
        String replaceFirst;
        String host = url.getHost();
        String url2 = url.toString();
        for (Map.Entry<String, a> entry : f3798d.entrySet()) {
            String key = entry.getKey();
            if (key.equals(host) || (ApollonConstants.WALLET_SPECIFIC && key.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                synchronized (f3798d) {
                    replaceFirst = url2.replaceFirst(host, f3798d.get(key).f3802a);
                }
                return replaceFirst;
            }
        }
        return url2;
    }
}
