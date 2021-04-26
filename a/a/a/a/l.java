package a.a.a.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1076a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static long f1077b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1078c;

    /* renamed from: d  reason: collision with root package name */
    public static long f1079d;

    /* renamed from: e  reason: collision with root package name */
    public static long f1080e;

    /* renamed from: f  reason: collision with root package name */
    public static long f1081f;

    /* renamed from: g  reason: collision with root package name */
    public static long f1082g;

    /* renamed from: h  reason: collision with root package name */
    public static long f1083h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1084i;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1085a;

        /* renamed from: b  reason: collision with root package name */
        public long f1086b;

        /* renamed from: c  reason: collision with root package name */
        public long f1087c;

        /* renamed from: e  reason: collision with root package name */
        public long f1089e;

        /* renamed from: g  reason: collision with root package name */
        public long f1091g;

        /* renamed from: d  reason: collision with root package name */
        public long f1088d = -1;

        /* renamed from: f  reason: collision with root package name */
        public long f1090f = -1;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, Long> f1092h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        public final Map<String, Long> f1093i = new HashMap();

        public synchronized boolean a() {
            boolean z = false;
            if (this.f1085a) {
                return false;
            }
            if (this.f1088d >= 0 && this.f1090f >= 0) {
                z = true;
            }
            this.f1085a = z;
            return z;
        }
    }

    public static void a() {
        f1077b = System.currentTimeMillis();
        f1081f = SystemClock.currentThreadTimeMillis();
    }

    public static void b() {
        f1080e = System.currentTimeMillis();
        f1084i = SystemClock.currentThreadTimeMillis();
    }
}
