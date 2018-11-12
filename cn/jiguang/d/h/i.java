package cn.jiguang.d.h;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public final class i {
    private static HashMap<String, s> a;

    static {
        HashMap<String, s> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("SDK_MAIN", new j());
        a.put("ACTION", new k());
        a.put("BUILD_REPORT", new l());
        a.put("UPLOAD_REPORT", new n());
        a.put("REPORT_HISTORY", new o());
        a.put("ASYNC", new q());
    }

    public static void a(String str, int i, int i2) {
        if (a.containsKey(str)) {
            return;
        }
        a.put(str, new r(str, 4, -1));
    }

    public static void a(String str, Runnable runnable, int i) {
        s sVar = a.get(str);
        if (sVar == null) {
            return;
        }
        ExecutorService executorService = null;
        try {
            executorService = sVar.x(true);
            t.a(executorService, new w(runnable, i));
        } catch (Throwable th) {
            t.a(executorService);
            try {
                t.a(sVar.x(true), new w(runnable, i));
            } catch (Throwable th2) {
            }
        }
    }
}
