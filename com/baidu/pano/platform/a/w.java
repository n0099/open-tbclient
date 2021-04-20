package com.baidu.pano.platform.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static String f8972a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8973b = Log.isLoggable("Volley", 2);

    public static void a(String str, Object... objArr) {
        if (f8973b) {
            Log.v(f8972a, d(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f8972a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f8972a, d(str, objArr));
    }

    public static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(w.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f8972a, d(str, objArr), th);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f8974a = w.f8973b;

        /* renamed from: b  reason: collision with root package name */
        public final List<C0113a> f8975b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f8976c = false;

        /* renamed from: com.baidu.pano.platform.a.w$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0113a {

            /* renamed from: a  reason: collision with root package name */
            public final String f8977a;

            /* renamed from: b  reason: collision with root package name */
            public final long f8978b;

            /* renamed from: c  reason: collision with root package name */
            public final long f8979c;

            public C0113a(String str, long j, long j2) {
                this.f8977a = str;
                this.f8978b = j;
                this.f8979c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f8976c) {
                this.f8975b.add(new C0113a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (this.f8976c) {
                return;
            }
            a("Request on the loose");
            w.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f8976c = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f8975b.get(0).f8979c;
            w.b("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C0113a c0113a : this.f8975b) {
                long j2 = c0113a.f8979c;
                w.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0113a.f8978b), c0113a.f8977a);
                j = j2;
            }
        }

        private long a() {
            if (this.f8975b.size() == 0) {
                return 0L;
            }
            long j = this.f8975b.get(0).f8979c;
            List<C0113a> list = this.f8975b;
            return list.get(list.size() - 1).f8979c - j;
        }
    }
}
