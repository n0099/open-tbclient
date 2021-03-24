package com.baidu.android.pushservice.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.a.a.a;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: com.baidu.android.pushservice.i.a.b$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3313a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3313a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3313a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3313a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3313a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3313a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3314a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3315b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3315b = aVar;
            this.f3314a = context;
            aVar.f2740a = "";
            aVar.f2741b = "";
            aVar.f2742c = -1L;
            aVar.f2743d = "";
            aVar.f2744e = -1L;
        }

        public a a(long j) {
            this.f3315b.f2742c = j;
            return this;
        }

        public a a(String str) {
            this.f3315b.f2740a = str;
            return this;
        }

        public void a() {
            b.b(this.f3314a, a.e.ACK, this.f3315b);
        }

        public a b(long j) {
            this.f3315b.f2744e = j;
            return this;
        }

        public a b(String str) {
            this.f3315b.f2741b = str;
            return this;
        }

        public a c(String str) {
            this.f3315b.f2743d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0052b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3316a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3317b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3318c;

        public C0052b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3317b = bVar;
            this.f3316a = context;
            bVar.f2753a = -1L;
            bVar.f2754b = -1L;
            bVar.f2755c = "";
            bVar.f2756d = -1L;
            bVar.f2757e = -1L;
            bVar.f2758f = "";
            bVar.f2759g = -1L;
        }

        public C0052b a(long j) {
            this.f3317b.f2753a = j;
            return this;
        }

        public C0052b a(String str) {
            this.f3317b.f2755c = str;
            return this;
        }

        public C0052b a(boolean z) {
            this.f3318c = z;
            return this;
        }

        public void a() {
            if (this.f3318c) {
                e.a(this.f3316a).a(this.f3317b);
            } else {
                b.b(this.f3316a, a.e.CONNECTION, this.f3317b);
            }
        }

        public C0052b b(long j) {
            this.f3317b.f2754b = j;
            return this;
        }

        public C0052b b(String str) {
            this.f3317b.f2758f = str;
            return this;
        }

        public C0052b c(long j) {
            this.f3317b.f2757e = j;
            return this;
        }

        public C0052b d(long j) {
            this.f3317b.f2759g = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3319a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3320b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3320b = cVar;
            this.f3319a = context;
            cVar.f2768a = "";
            cVar.f2769b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3320b;
            cVar2.f2770c = "";
            cVar2.f2771d = 201001L;
        }

        public c a(long j) {
            this.f3320b.f2771d = j;
            return this;
        }

        public c a(String str) {
            this.f3320b.f2768a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3320b.f2768a)) {
                return;
            }
            b.b(this.f3319a, a.e.CRASH, this.f3320b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3321a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3322b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3322b = eVar;
            this.f3321a = context;
            eVar.f2788a = "";
            eVar.f2789b = "";
            eVar.f2790c = -1L;
            eVar.f2791d = -1L;
            eVar.f2792e = -1L;
            eVar.f2793f = "";
            eVar.f2794g = -1L;
        }

        public d a(long j) {
            this.f3322b.f2790c = j;
            return this;
        }

        public d a(String str) {
            this.f3322b.f2788a = str;
            return this;
        }

        public void a() {
            b.b(this.f3321a, a.e.REQUEST, this.f3322b);
        }

        public d b(long j) {
            this.f3322b.f2791d = j;
            return this;
        }

        public d b(String str) {
            this.f3322b.f2789b = str;
            return this;
        }

        public d c(long j) {
            this.f3322b.f2792e = j;
            return this;
        }

        public d c(String str) {
            this.f3322b.f2793f = str;
            return this;
        }

        public d d(long j) {
            this.f3322b.f2794g = j;
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
                    synchronized (e.f2887a) {
                        int i = AnonymousClass2.f3313a[eVar.ordinal()];
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
