package cn.jiguang.d.h;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class c {
    private static final Object b = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> c = new ConcurrentHashMap<>();
    public static String a = "yyyyMMdd_HHmm";

    public static String a() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = c.get(str);
        if (threadLocal == null) {
            synchronized (b) {
                threadLocal = c.get(str);
                if (threadLocal == null) {
                    threadLocal = new d(str);
                    c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static String b() {
        return a("yyyyMMddHHmmss").format(new Date());
    }
}
