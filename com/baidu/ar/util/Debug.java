package com.baidu.ar.util;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class Debug {
    private static final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private static final SimpleDateFormat b = new SimpleDateFormat("mm:ss.SSS", Locale.getDefault());
    private static final Map<String, a> c = new HashMap();
    private static long d = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public long e;
        public long f;

        private a() {
        }

        private String e() {
            String str = this.b;
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
        }

        public long a() {
            return this.f - this.e;
        }

        public String b() {
            return this.a + SystemInfoUtil.COLON + this.b + SystemInfoUtil.COLON + this.d + SystemInfoUtil.COLON + this.c;
        }

        public void c() {
            StringBuilder sb = new StringBuilder();
            sb.append(e()).append("::");
            sb.append(this.c).append("--");
            sb.append(IntentConfig.START);
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(SystemInfoUtil.COLON).append(this.d);
            }
            Debug.print(sb.toString(), this.e);
        }

        public void d() {
            StringBuilder sb = new StringBuilder();
            sb.append(e()).append("::");
            sb.append(this.c).append("--");
            sb.append("end");
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(SystemInfoUtil.COLON).append(this.d);
            }
            sb.append(",cost:").append(a());
            Debug.print(sb.toString(), this.f);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return TextUtils.equals(b(), ((a) obj).b());
        }

        public String toString() {
            return b();
        }
    }

    private static a a() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = Debug.class.getName();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i];
            if (!name.equals(stackTraceElement.getClassName())) {
                break;
            }
            i++;
        }
        if (stackTraceElement == null) {
            return null;
        }
        String fileName = stackTraceElement.getFileName();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        a aVar = new a();
        aVar.a = fileName;
        aVar.b = className;
        aVar.c = methodName;
        return aVar;
    }

    private static String a(long j) {
        return b.format(new Date(j));
    }

    private static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void a(String str) {
        a a2 = a();
        if (a2 == null) {
            return;
        }
        a2.e = System.currentTimeMillis();
        a2.d = str;
        c.put(a2.b(), a2);
        a2.c();
    }

    private static String b() {
        return a.format(new Date());
    }

    private static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        a a2 = a();
        if (a2 == null) {
            return;
        }
        a2.d = str;
        a remove = c.remove(a2.b());
        if (remove == null) {
            Log.d("Performance", "miss start method:" + a2);
            return;
        }
        remove.f = currentTimeMillis;
        remove.d();
    }

    public static void onMethodEnd() {
        b(null);
    }

    public static void onMethodEnd(Object obj) {
        b(obj == null ? null : String.valueOf(obj.hashCode()));
    }

    public static void onMethodStart() {
        a((String) null);
    }

    public static void onMethodStart(Object obj) {
        a(obj == null ? null : String.valueOf(obj.hashCode()));
    }

    public static void print(String str) {
        print(str, System.currentTimeMillis());
    }

    public static void print(String str, long j) {
        Log.e("Performance", "[" + (d > 0 ? a(j - d) : b()) + "]" + str);
    }

    public static void printStackTrace() {
        printStackTrace(null);
    }

    public static void printStackTrace(Object obj) {
        printStackTrace(obj, 10);
    }

    public static void printStackTrace(Object obj, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = Debug.class.getName();
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!name.equals(stackTraceElement.getClassName())) {
                arrayList.add(stackTraceElement);
            }
        }
        int min = Math.min(i, arrayList.size());
        String a2 = a((StackTraceElement[]) arrayList.subList(0, min).toArray(new StackTraceElement[min]));
        String valueOf = obj == null ? null : String.valueOf(obj.hashCode());
        String str = "=========begin=========\n" + a2 + "=========end=========\n";
        Log.e("Performance", !TextUtils.isEmpty(valueOf) ? "[object:" + valueOf + "]" + str : str);
    }

    public static void resetBaseTime() {
        d = System.currentTimeMillis();
    }
}
