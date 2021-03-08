package a.a.a.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class k {
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;
    public static final a zO = new a();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f967a;
        public long b;
        public long c;
        public long e;
        public long g;
        public long d = -1;
        public long f = -1;
        public final Map<String, Long> h = new HashMap();
        public final Map<String, Long> i = new HashMap();

        public synchronized boolean a() {
            boolean z = false;
            synchronized (this) {
                if (!this.f967a) {
                    if (this.d >= 0 && this.f >= 0) {
                        z = true;
                    }
                    this.f967a = z;
                }
            }
            return z;
        }
    }

    public static void a() {
        b = System.currentTimeMillis();
        f = SystemClock.currentThreadTimeMillis();
    }

    public static void b() {
        e = System.currentTimeMillis();
        i = SystemClock.currentThreadTimeMillis();
    }
}
