package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3564a = "qrlogin_enter";
    private static final Map<String, String> b = new HashMap();
    private static List<String> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpHashMapWrap f3565a;

        a(HttpHashMapWrap httpHashMapWrap) {
            this.f3565a = httpHashMapWrap;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.b(this.f3565a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b extends HttpHandlerWrap {
        b(boolean z) {
            super(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
        }
    }

    static {
        b.put("pid", "111");
        b.put("type", "1023");
        b.put(Config.DEVICE_PART, Build.MODEL);
        c = new ArrayList();
        c.add("share_read");
        c.add("share_silent_account");
        c.add("share_silent_account_success");
        c.add("load_login");
        c.add("share_account_open");
        c.add("pass_sdk_init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(f.a(f.k), httpHashMapWrap, null, null, new b(true));
    }

    public static void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.putAll(b);
                httpHashMapWrap.put("name", str);
                httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
                httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                            httpHashMapWrap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (c.contains(str) && a()) {
                    NetworkRequestScheduler.execute(new a(httpHashMapWrap), "pass_sdk_".concat(str), 60000L, false);
                    return;
                }
                b(httpHashMapWrap);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    private static boolean a() {
        try {
            Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("name", str);
        a(linkedHashMap);
    }

    public static void a(LinkedHashMap<String, String> linkedHashMap) {
        a(linkedHashMap, (Map<String, String>) null);
    }

    @TargetApi(8)
    public static void a(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String str : linkedHashMap.keySet()) {
            sb.append(str).append(":").append(linkedHashMap.get(str));
        }
        sb.append("}");
        map.put("auto_statistic", Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put("source", "native");
        map.put("data_source", "client");
        a("auto_statistic", map);
    }
}
