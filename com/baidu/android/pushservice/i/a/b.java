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
        public static final /* synthetic */ int[] f3314a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3314a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3314a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3314a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3314a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3314a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3315a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3316b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3316b = aVar;
            this.f3315a = context;
            aVar.f2741a = "";
            aVar.f2742b = "";
            aVar.f2743c = -1L;
            aVar.f2744d = "";
            aVar.f2745e = -1L;
        }

        public a a(long j) {
            this.f3316b.f2743c = j;
            return this;
        }

        public a a(String str) {
            this.f3316b.f2741a = str;
            return this;
        }

        public void a() {
            b.b(this.f3315a, a.e.ACK, this.f3316b);
        }

        public a b(long j) {
            this.f3316b.f2745e = j;
            return this;
        }

        public a b(String str) {
            this.f3316b.f2742b = str;
            return this;
        }

        public a c(String str) {
            this.f3316b.f2744d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0053b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3317a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3318b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3319c;

        public C0053b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3318b = bVar;
            this.f3317a = context;
            bVar.f2754a = -1L;
            bVar.f2755b = -1L;
            bVar.f2756c = "";
            bVar.f2757d = -1L;
            bVar.f2758e = -1L;
            bVar.f2759f = "";
            bVar.f2760g = -1L;
        }

        public C0053b a(long j) {
            this.f3318b.f2754a = j;
            return this;
        }

        public C0053b a(String str) {
            this.f3318b.f2756c = str;
            return this;
        }

        public C0053b a(boolean z) {
            this.f3319c = z;
            return this;
        }

        public void a() {
            if (this.f3319c) {
                e.a(this.f3317a).a(this.f3318b);
            } else {
                b.b(this.f3317a, a.e.CONNECTION, this.f3318b);
            }
        }

        public C0053b b(long j) {
            this.f3318b.f2755b = j;
            return this;
        }

        public C0053b b(String str) {
            this.f3318b.f2759f = str;
            return this;
        }

        public C0053b c(long j) {
            this.f3318b.f2758e = j;
            return this;
        }

        public C0053b d(long j) {
            this.f3318b.f2760g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3320a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3321b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3321b = cVar;
            this.f3320a = context;
            cVar.f2769a = "";
            cVar.f2770b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3321b;
            cVar2.f2771c = "";
            cVar2.f2772d = 201001L;
        }

        public c a(long j) {
            this.f3321b.f2772d = j;
            return this;
        }

        public c a(String str) {
            this.f3321b.f2769a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3321b.f2769a)) {
                return;
            }
            b.b(this.f3320a, a.e.CRASH, this.f3321b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3322a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3323b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3323b = eVar;
            this.f3322a = context;
            eVar.f2789a = "";
            eVar.f2790b = "";
            eVar.f2791c = -1L;
            eVar.f2792d = -1L;
            eVar.f2793e = -1L;
            eVar.f2794f = "";
            eVar.f2795g = -1L;
        }

        public d a(long j) {
            this.f3323b.f2791c = j;
            return this;
        }

        public d a(String str) {
            this.f3323b.f2789a = str;
            return this;
        }

        public void a() {
            b.b(this.f3322a, a.e.REQUEST, this.f3323b);
        }

        public d b(long j) {
            this.f3323b.f2792d = j;
            return this;
        }

        public d b(String str) {
            this.f3323b.f2790b = str;
            return this;
        }

        public d c(long j) {
            this.f3323b.f2793e = j;
            return this;
        }

        public d c(String str) {
            this.f3323b.f2794f = str;
            return this;
        }

        public d d(long j) {
            this.f3323b.f2795g = j;
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
                    synchronized (e.f2888a) {
                        int i = AnonymousClass2.f3314a[eVar.ordinal()];
                        if (i == 1) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.c) obj);
                        } else if (i == 2) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.d) obj);
                        } else if (i == 3) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.b) obj);
                        } else if (i == 4) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.e) obj);
                        } else if (i == 5) {
                            e.a(applicationContext).a((com.baidu.android.pushservice.c.a.a) obj);
                        }
                    }
                }
            });
        }
    }
}
