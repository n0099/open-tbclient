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
        public static final /* synthetic */ int[] f3387a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3387a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3387a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3387a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3387a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3387a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3388a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3389b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3389b = aVar;
            this.f3388a = context;
            aVar.f2781a = "";
            aVar.f2782b = "";
            aVar.f2783c = -1L;
            aVar.f2784d = "";
            aVar.f2785e = -1L;
        }

        public a a(long j) {
            this.f3389b.f2783c = j;
            return this;
        }

        public a a(String str) {
            this.f3389b.f2781a = str;
            return this;
        }

        public void a() {
            b.b(this.f3388a, a.e.ACK, this.f3389b);
        }

        public a b(long j) {
            this.f3389b.f2785e = j;
            return this;
        }

        public a b(String str) {
            this.f3389b.f2782b = str;
            return this;
        }

        public a c(String str) {
            this.f3389b.f2784d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0052b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3390a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3391b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3392c;

        public C0052b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3391b = bVar;
            this.f3390a = context;
            bVar.f2794a = -1L;
            bVar.f2795b = -1L;
            bVar.f2796c = "";
            bVar.f2797d = -1L;
            bVar.f2798e = -1L;
            bVar.f2799f = "";
            bVar.f2800g = -1L;
        }

        public C0052b a(long j) {
            this.f3391b.f2794a = j;
            return this;
        }

        public C0052b a(String str) {
            this.f3391b.f2796c = str;
            return this;
        }

        public C0052b a(boolean z) {
            this.f3392c = z;
            return this;
        }

        public void a() {
            if (this.f3392c) {
                e.a(this.f3390a).a(this.f3391b);
            } else {
                b.b(this.f3390a, a.e.CONNECTION, this.f3391b);
            }
        }

        public C0052b b(long j) {
            this.f3391b.f2795b = j;
            return this;
        }

        public C0052b b(String str) {
            this.f3391b.f2799f = str;
            return this;
        }

        public C0052b c(long j) {
            this.f3391b.f2798e = j;
            return this;
        }

        public C0052b d(long j) {
            this.f3391b.f2800g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3393a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3394b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3394b = cVar;
            this.f3393a = context;
            cVar.f2810a = "";
            cVar.f2811b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3394b;
            cVar2.f2812c = "";
            cVar2.f2813d = 201001L;
        }

        public c a(long j) {
            this.f3394b.f2813d = j;
            return this;
        }

        public c a(String str) {
            this.f3394b.f2810a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3394b.f2810a)) {
                return;
            }
            b.b(this.f3393a, a.e.CRASH, this.f3394b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3395a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3396b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3396b = eVar;
            this.f3395a = context;
            eVar.f2832a = "";
            eVar.f2833b = "";
            eVar.f2834c = -1L;
            eVar.f2835d = -1L;
            eVar.f2836e = -1L;
            eVar.f2837f = "";
            eVar.f2838g = -1L;
        }

        public d a(long j) {
            this.f3396b.f2834c = j;
            return this;
        }

        public d a(String str) {
            this.f3396b.f2832a = str;
            return this;
        }

        public void a() {
            b.b(this.f3395a, a.e.REQUEST, this.f3396b);
        }

        public d b(long j) {
            this.f3396b.f2835d = j;
            return this;
        }

        public d b(String str) {
            this.f3396b.f2833b = str;
            return this;
        }

        public d c(long j) {
            this.f3396b.f2836e = j;
            return this;
        }

        public d c(String str) {
            this.f3396b.f2837f = str;
            return this;
        }

        public d d(long j) {
            this.f3396b.f2838g = j;
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
                    synchronized (e.f2937a) {
                        int i2 = AnonymousClass2.f3387a[eVar.ordinal()];
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
