package a.a.a.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1063a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static long f1064b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1065c;

    /* renamed from: d  reason: collision with root package name */
    public static long f1066d;

    /* renamed from: e  reason: collision with root package name */
    public static long f1067e;

    /* renamed from: f  reason: collision with root package name */
    public static long f1068f;

    /* renamed from: g  reason: collision with root package name */
    public static long f1069g;

    /* renamed from: h  reason: collision with root package name */
    public static long f1070h;
    public static long i;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1071a;

        /* renamed from: b  reason: collision with root package name */
        public long f1072b;

        /* renamed from: c  reason: collision with root package name */
        public long f1073c;

        /* renamed from: e  reason: collision with root package name */
        public long f1075e;

        /* renamed from: g  reason: collision with root package name */
        public long f1077g;

        /* renamed from: d  reason: collision with root package name */
        public long f1074d = -1;

        /* renamed from: f  reason: collision with root package name */
        public long f1076f = -1;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, Long> f1078h = new HashMap();
        public final Map<String, Long> i = new HashMap();

        public synchronized boolean a() {
            boolean z = false;
            if (this.f1071a) {
                return false;
            }
            if (this.f1074d >= 0 && this.f1076f >= 0) {
                z = true;
            }
            this.f1071a = z;
            return z;
        }
    }

    public static void a() {
        f1064b = System.currentTimeMillis();
        f1068f = SystemClock.currentThreadTimeMillis();
    }

    public static void b() {
        f1067e = System.currentTimeMillis();
        i = SystemClock.currentThreadTimeMillis();
    }
}
