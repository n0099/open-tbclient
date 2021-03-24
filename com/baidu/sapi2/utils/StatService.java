package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class StatService implements NoProguard {
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";

    /* renamed from: a  reason: collision with root package name */
    public static final String f11428a = "StatService";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11429b = "auto_statistic";

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, String> f11430c;

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f11431d;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpHashMapWrap f11432a;

        public a(HttpHashMapWrap httpHashMapWrap) {
            this.f11432a = httpHashMapWrap;
        }

        @Override // java.lang.Runnable
        public void run() {
            StatService.b(this.f11432a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends HttpHandlerWrap {
        public b(boolean z) {
            super(z);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f11430c = hashMap;
        hashMap.put("pid", "111");
        f11430c.put("type", "1023");
        f11430c.put("device", Build.MODEL);
        ArrayList arrayList = new ArrayList();
        f11431d = arrayList;
        arrayList.add("share_read");
        f11431d.add("share_silent_account");
        f11431d.add("share_silent_account_success");
        f11431d.add("load_login");
        f11431d.add("share_account_open");
        f11431d.add("pass_sdk_init");
    }

    public static void b(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(h.a(h.k), httpHashMapWrap, null, null, new b(true));
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.putAll(f11430c);
            httpHashMapWrap.put("name", str);
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            StringBuilder sb = new StringBuilder();
            sb.append("eventType=");
            sb.append(str);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        httpHashMapWrap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            Log.d("StatService", sb.toString());
            if (f11431d.contains(str) && a()) {
                NetworkRequestScheduler.execute(new a(httpHashMapWrap), "pass_sdk_".concat(str), 60000L, false);
            } else {
                b(httpHashMapWrap);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void onEventAutoStat(String str) {
        onEventAutoStat(str, null);
    }

    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap) {
        onEventAutoStatistic(linkedHashMap, null);
    }

    public static boolean a() {
        try {
            Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void onEventAutoStat(String str, Map<String, String> map) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(f11429b, Base64.encodeToString(a(str).getBytes(), 0));
        httpHashMapWrap.putAll(f11430c);
        httpHashMapWrap.put("source", "native");
        httpHashMapWrap.put("data_source", "client");
        httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        if (map != null) {
            for (String str2 : map.keySet()) {
                httpHashMapWrap.put(str2, map.get(str2));
            }
        }
        try {
            b(httpHashMapWrap);
        } catch (Exception unused) {
        }
    }

    @TargetApi(8)
    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.ARRAY_START);
        for (String str : linkedHashMap.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append(linkedHashMap.get(str));
            sb.append(",");
        }
        int lastIndexOf = sb.lastIndexOf(",");
        if (lastIndexOf > 0) {
            sb = new StringBuilder(sb.substring(0, lastIndexOf));
        }
        sb.append("}");
        Log.d("StatService", "onEventAutoStatistic content=" + sb.toString());
        map.put(f11429b, Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put("source", "native");
        map.put("data_source", "client");
        onEvent(f11429b, map);
    }

    public static String a(String str) {
        return "{eventType=" + str + "}";
    }
}
