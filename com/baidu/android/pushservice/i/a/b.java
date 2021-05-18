package com.baidu.android.pushservice.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.a.a.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: com.baidu.android.pushservice.i.a.b$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3384a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3384a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3384a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3384a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3384a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3384a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3385a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3386b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3386b = aVar;
            this.f3385a = context;
            aVar.f2778a = "";
            aVar.f2779b = "";
            aVar.f2780c = -1L;
            aVar.f2781d = "";
            aVar.f2782e = -1L;
        }

        public a a(long j) {
            this.f3386b.f2780c = j;
            return this;
        }

        public a a(String str) {
            this.f3386b.f2778a = str;
            return this;
        }

        public void a() {
            b.b(this.f3385a, a.e.ACK, this.f3386b);
        }

        public a b(long j) {
            this.f3386b.f2782e = j;
            return this;
        }

        public a b(String str) {
            this.f3386b.f2779b = str;
            return this;
        }

        public a c(String str) {
            this.f3386b.f2781d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0051b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3387a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3388b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3389c;

        public C0051b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3388b = bVar;
            this.f3387a = context;
            bVar.f2791a = -1L;
            bVar.f2792b = -1L;
            bVar.f2793c = "";
            bVar.f2794d = -1L;
            bVar.f2795e = -1L;
            bVar.f2796f = "";
            bVar.f2797g = -1L;
        }

        public C0051b a(long j) {
            this.f3388b.f2791a = j;
            return this;
        }

        public C0051b a(String str) {
            this.f3388b.f2793c = str;
            return this;
        }

        public C0051b a(boolean z) {
            this.f3389c = z;
            return this;
        }

        public void a() {
            if (this.f3389c) {
                e.a(this.f3387a).a(this.f3388b);
            } else {
                b.b(this.f3387a, a.e.CONNECTION, this.f3388b);
            }
        }

        public C0051b b(long j) {
            this.f3388b.f2792b = j;
            return this;
        }

        public C0051b b(String str) {
            this.f3388b.f2796f = str;
            return this;
        }

        public C0051b c(long j) {
            this.f3388b.f2795e = j;
            return this;
        }

        public C0051b d(long j) {
            this.f3388b.f2797g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3390a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3391b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3391b = cVar;
            this.f3390a = context;
            cVar.f2807a = "";
            cVar.f2808b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3391b;
            cVar2.f2809c = "";
            cVar2.f2810d = 201001L;
        }

        public c a(long j) {
            this.f3391b.f2810d = j;
            return this;
        }

        public c a(String str) {
            this.f3391b.f2807a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3391b.f2807a)) {
                return;
            }
            b.b(this.f3390a, a.e.CRASH, this.f3391b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3392a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3393b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3393b = eVar;
            this.f3392a = context;
            eVar.f2829a = "";
            eVar.f2830b = "";
            eVar.f2831c = -1L;
            eVar.f2832d = -1L;
            eVar.f2833e = -1L;
            eVar.f2834f = "";
            eVar.f2835g = -1L;
        }

        public d a(long j) {
            this.f3393b.f2831c = j;
            return this;
        }

        public d a(String str) {
            this.f3393b.f2829a = str;
            return this;
        }

        public void a() {
            b.b(this.f3392a, a.e.REQUEST, this.f3393b);
        }

        public d b(long j) {
            this.f3393b.f2832d = j;
            return this;
        }

        public d b(String str) {
            this.f3393b.f2830b = str;
            return this;
        }

        public d c(long j) {
            this.f3393b.f2833e = j;
            return this;
        }

        public d c(String str) {
            this.f3393b.f2834f = str;
            return this;
        }

        public d d(long j) {
            this.f3393b.f2835g = j;
            return this;
        }
    }

    public static void b(Context context, final a.e eVar, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        if (com.baidu.android.pushservice.b.d.g(applicationContext)) {
            com.baidu.android.pushservice.h.d a2 = com.baidu.android.pushservice.h.d.a();
            a2.a(new com.baidu.android.pushservice.h.c("reportTracker - " + eVar.name(), (short) 90) { // from class: com.baidu.android.pushservice.i.a.b.1
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    synchronized (e.f2934a) {
                        int i2 = AnonymousClass2.f3384a[eVar.ordinal()];
                        if (i2 == 1) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.c) obj);
                        } else if (i2 == 2) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.d) obj);
                        } else if (i2 == 3) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.b) obj);
                        } else if (i2 == 4) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.e) obj);
                        } else if (i2 == 5) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.a) obj);
                        }
                    }
                }
            });
        }
    }
}
