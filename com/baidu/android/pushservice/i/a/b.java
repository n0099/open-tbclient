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
        public static final /* synthetic */ int[] f3406a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3406a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3406a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3406a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3406a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3406a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3407a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3408b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3408b = aVar;
            this.f3407a = context;
            aVar.f2800a = "";
            aVar.f2801b = "";
            aVar.f2802c = -1L;
            aVar.f2803d = "";
            aVar.f2804e = -1L;
        }

        public a a(long j) {
            this.f3408b.f2802c = j;
            return this;
        }

        public a a(String str) {
            this.f3408b.f2800a = str;
            return this;
        }

        public void a() {
            b.b(this.f3407a, a.e.ACK, this.f3408b);
        }

        public a b(long j) {
            this.f3408b.f2804e = j;
            return this;
        }

        public a b(String str) {
            this.f3408b.f2801b = str;
            return this;
        }

        public a c(String str) {
            this.f3408b.f2803d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0053b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3409a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3410b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3411c;

        public C0053b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3410b = bVar;
            this.f3409a = context;
            bVar.f2813a = -1L;
            bVar.f2814b = -1L;
            bVar.f2815c = "";
            bVar.f2816d = -1L;
            bVar.f2817e = -1L;
            bVar.f2818f = "";
            bVar.f2819g = -1L;
        }

        public C0053b a(long j) {
            this.f3410b.f2813a = j;
            return this;
        }

        public C0053b a(String str) {
            this.f3410b.f2815c = str;
            return this;
        }

        public C0053b a(boolean z) {
            this.f3411c = z;
            return this;
        }

        public void a() {
            if (this.f3411c) {
                e.a(this.f3409a).a(this.f3410b);
            } else {
                b.b(this.f3409a, a.e.CONNECTION, this.f3410b);
            }
        }

        public C0053b b(long j) {
            this.f3410b.f2814b = j;
            return this;
        }

        public C0053b b(String str) {
            this.f3410b.f2818f = str;
            return this;
        }

        public C0053b c(long j) {
            this.f3410b.f2817e = j;
            return this;
        }

        public C0053b d(long j) {
            this.f3410b.f2819g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3412a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3413b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3413b = cVar;
            this.f3412a = context;
            cVar.f2829a = "";
            cVar.f2830b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3413b;
            cVar2.f2831c = "";
            cVar2.f2832d = 201001L;
        }

        public c a(long j) {
            this.f3413b.f2832d = j;
            return this;
        }

        public c a(String str) {
            this.f3413b.f2829a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3413b.f2829a)) {
                return;
            }
            b.b(this.f3412a, a.e.CRASH, this.f3413b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3414a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3415b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3415b = eVar;
            this.f3414a = context;
            eVar.f2851a = "";
            eVar.f2852b = "";
            eVar.f2853c = -1L;
            eVar.f2854d = -1L;
            eVar.f2855e = -1L;
            eVar.f2856f = "";
            eVar.f2857g = -1L;
        }

        public d a(long j) {
            this.f3415b.f2853c = j;
            return this;
        }

        public d a(String str) {
            this.f3415b.f2851a = str;
            return this;
        }

        public void a() {
            b.b(this.f3414a, a.e.REQUEST, this.f3415b);
        }

        public d b(long j) {
            this.f3415b.f2854d = j;
            return this;
        }

        public d b(String str) {
            this.f3415b.f2852b = str;
            return this;
        }

        public d c(long j) {
            this.f3415b.f2855e = j;
            return this;
        }

        public d c(String str) {
            this.f3415b.f2856f = str;
            return this;
        }

        public d d(long j) {
            this.f3415b.f2857g = j;
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
                    synchronized (e.f2956a) {
                        int i2 = AnonymousClass2.f3406a[eVar.ordinal()];
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
