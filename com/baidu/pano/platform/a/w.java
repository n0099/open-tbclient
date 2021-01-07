package com.baidu.pano.platform.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static String f3932a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3933b = Log.isLoggable(f3932a, 2);

    public static void a(String str, Object... objArr) {
        if (f3933b) {
            Log.v(f3932a, d(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f3932a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f3932a, d(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f3932a, d(str, objArr), th);
    }

    private static String d(String str, Object... objArr) {
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
            } else if (stackTrace[i].getClass().equals(w.class)) {
                i++;
            } else {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f3934a = w.f3933b;

        /* renamed from: b  reason: collision with root package name */
        private final List<C0279a> f3935b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.pano.platform.a.w$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0279a {

            /* renamed from: a  reason: collision with root package name */
            public final String f3936a;

            /* renamed from: b  reason: collision with root package name */
            public final long f3937b;
            public final long c;

            public C0279a(String str, long j, long j2) {
                this.f3936a = str;
                this.f3937b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f3935b.add(new C0279a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.f3935b.get(0).c;
                w.b("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C0279a c0279a : this.f3935b) {
                    long j3 = c0279a.c;
                    w.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0279a.f3937b), c0279a.f3936a);
                    j2 = j3;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.c) {
                a("Request on the loose");
                w.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.f3935b.size() == 0) {
                return 0L;
            }
            return this.f3935b.get(this.f3935b.size() - 1).c - this.f3935b.get(0).c;
        }
    }
}
