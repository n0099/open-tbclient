package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
/* loaded from: classes14.dex */
public class b {

    /* renamed from: com.baidu.android.pushservice.h.a.b$2  reason: invalid class name */
    /* loaded from: classes14.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1387a = new int[a.e.values().length];

        static {
            try {
                f1387a[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1387a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1387a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1387a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1387a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f1388a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.a f1389b = new com.baidu.android.pushservice.c.a.a();

        public a(Context context) {
            this.f1388a = context;
            this.f1389b.f1206a = "";
            this.f1389b.f1207b = "";
            this.f1389b.c = -1L;
            this.f1389b.d = "";
            this.f1389b.e = -1L;
        }

        public a a(long j) {
            this.f1389b.c = j;
            return this;
        }

        public a a(String str) {
            this.f1389b.f1206a = str;
            return this;
        }

        public void a() {
            b.b(this.f1388a, a.e.ACK, this.f1389b);
        }

        public a b(long j) {
            this.f1389b.e = j;
            return this;
        }

        public a b(String str) {
            this.f1389b.f1207b = str;
            return this;
        }

        public a c(String str) {
            this.f1389b.d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C0059b {

        /* renamed from: a  reason: collision with root package name */
        private Context f1390a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.b f1391b = new com.baidu.android.pushservice.c.a.b();
        private boolean c;

        public C0059b(Context context) {
            this.f1390a = context;
            this.f1391b.f1210a = -1L;
            this.f1391b.f1211b = -1L;
            this.f1391b.c = "";
            this.f1391b.d = -1L;
            this.f1391b.e = -1L;
            this.f1391b.f = "";
            this.f1391b.g = -1L;
        }

        public C0059b a(long j) {
            this.f1391b.f1210a = j;
            return this;
        }

        public C0059b a(String str) {
            this.f1391b.c = str;
            return this;
        }

        public C0059b a(boolean z) {
            this.c = z;
            return this;
        }

        public void a() {
            if (this.c) {
                e.a(this.f1390a).a(this.f1391b);
            } else {
                b.b(this.f1390a, a.e.CONNECTION, this.f1391b);
            }
        }

        public C0059b b(long j) {
            this.f1391b.f1211b = j;
            return this;
        }

        public C0059b b(String str) {
            this.f1391b.f = str;
            return this;
        }

        public C0059b c(long j) {
            this.f1391b.e = j;
            return this;
        }

        public C0059b d(long j) {
            this.f1391b.g = j;
            return this;
        }
    }

    /* loaded from: classes14.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private Context f1392a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.c f1393b = new com.baidu.android.pushservice.c.a.c();

        public c(Context context) {
            this.f1392a = context;
            this.f1393b.f1214a = "";
            this.f1393b.f1215b = System.currentTimeMillis();
            this.f1393b.c = "";
            this.f1393b.d = 201001L;
        }

        public c a(long j) {
            this.f1393b.d = j;
            return this;
        }

        public c a(String str) {
            this.f1393b.f1214a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f1393b.f1214a)) {
                return;
            }
            b.b(this.f1392a, a.e.CRASH, this.f1393b);
        }
    }

    /* loaded from: classes14.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private Context f1394a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.e f1395b = new com.baidu.android.pushservice.c.a.e();

        public d(Context context) {
            this.f1394a = context;
            this.f1395b.f1220a = "";
            this.f1395b.f1221b = "";
            this.f1395b.c = -1L;
            this.f1395b.d = -1L;
            this.f1395b.e = -1L;
            this.f1395b.f = "";
            this.f1395b.g = -1L;
        }

        public d a(long j) {
            this.f1395b.c = j;
            return this;
        }

        public d a(String str) {
            this.f1395b.f1220a = str;
            return this;
        }

        public void a() {
            b.b(this.f1394a, a.e.REQUEST, this.f1395b);
        }

        public d b(long j) {
            this.f1395b.d = j;
            return this;
        }

        public d b(String str) {
            this.f1395b.f1221b = str;
            return this;
        }

        public d c(long j) {
            this.f1395b.e = j;
            return this;
        }

        public d c(String str) {
            this.f1395b.f = str;
            return this;
        }

        public d d(long j) {
            this.f1395b.g = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, final a.e eVar, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        if (com.baidu.android.pushservice.b.d.g(applicationContext)) {
            com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("reportTracker - " + eVar.name(), (short) 90) { // from class: com.baidu.android.pushservice.h.a.b.1
                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    synchronized (e.f1246a) {
                        switch (AnonymousClass2.f1387a[eVar.ordinal()]) {
                            case 1:
                                e.a(applicationContext).a((com.baidu.android.pushservice.c.a.c) obj);
                                break;
                            case 2:
                                e.a(applicationContext).a((com.baidu.android.pushservice.c.a.d) obj);
                                break;
                            case 3:
                                e.a(applicationContext).a((com.baidu.android.pushservice.c.a.b) obj);
                                break;
                            case 4:
                                e.a(applicationContext).a((com.baidu.android.pushservice.c.a.e) obj);
                                break;
                            case 5:
                                e.a(applicationContext).a((com.baidu.android.pushservice.c.a.a) obj);
                                break;
                        }
                    }
                }
            });
        }
    }
}
