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
        public static final /* synthetic */ int[] f3383a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3383a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3383a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3383a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3383a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3383a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3384a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3385b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3385b = aVar;
            this.f3384a = context;
            aVar.f2777a = "";
            aVar.f2778b = "";
            aVar.f2779c = -1L;
            aVar.f2780d = "";
            aVar.f2781e = -1L;
        }

        public a a(long j) {
            this.f3385b.f2779c = j;
            return this;
        }

        public a a(String str) {
            this.f3385b.f2777a = str;
            return this;
        }

        public void a() {
            b.b(this.f3384a, a.e.ACK, this.f3385b);
        }

        public a b(long j) {
            this.f3385b.f2781e = j;
            return this;
        }

        public a b(String str) {
            this.f3385b.f2778b = str;
            return this;
        }

        public a c(String str) {
            this.f3385b.f2780d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0052b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3386a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3387b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3388c;

        public C0052b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3387b = bVar;
            this.f3386a = context;
            bVar.f2790a = -1L;
            bVar.f2791b = -1L;
            bVar.f2792c = "";
            bVar.f2793d = -1L;
            bVar.f2794e = -1L;
            bVar.f2795f = "";
            bVar.f2796g = -1L;
        }

        public C0052b a(long j) {
            this.f3387b.f2790a = j;
            return this;
        }

        public C0052b a(String str) {
            this.f3387b.f2792c = str;
            return this;
        }

        public C0052b a(boolean z) {
            this.f3388c = z;
            return this;
        }

        public void a() {
            if (this.f3388c) {
                e.a(this.f3386a).a(this.f3387b);
            } else {
                b.b(this.f3386a, a.e.CONNECTION, this.f3387b);
            }
        }

        public C0052b b(long j) {
            this.f3387b.f2791b = j;
            return this;
        }

        public C0052b b(String str) {
            this.f3387b.f2795f = str;
            return this;
        }

        public C0052b c(long j) {
            this.f3387b.f2794e = j;
            return this;
        }

        public C0052b d(long j) {
            this.f3387b.f2796g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3389a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3390b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3390b = cVar;
            this.f3389a = context;
            cVar.f2806a = "";
            cVar.f2807b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3390b;
            cVar2.f2808c = "";
            cVar2.f2809d = 201001L;
        }

        public c a(long j) {
            this.f3390b.f2809d = j;
            return this;
        }

        public c a(String str) {
            this.f3390b.f2806a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3390b.f2806a)) {
                return;
            }
            b.b(this.f3389a, a.e.CRASH, this.f3390b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3391a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3392b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3392b = eVar;
            this.f3391a = context;
            eVar.f2828a = "";
            eVar.f2829b = "";
            eVar.f2830c = -1L;
            eVar.f2831d = -1L;
            eVar.f2832e = -1L;
            eVar.f2833f = "";
            eVar.f2834g = -1L;
        }

        public d a(long j) {
            this.f3392b.f2830c = j;
            return this;
        }

        public d a(String str) {
            this.f3392b.f2828a = str;
            return this;
        }

        public void a() {
            b.b(this.f3391a, a.e.REQUEST, this.f3392b);
        }

        public d b(long j) {
            this.f3392b.f2831d = j;
            return this;
        }

        public d b(String str) {
            this.f3392b.f2829b = str;
            return this;
        }

        public d c(long j) {
            this.f3392b.f2832e = j;
            return this;
        }

        public d c(String str) {
            this.f3392b.f2833f = str;
            return this;
        }

        public d d(long j) {
            this.f3392b.f2834g = j;
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
                    synchronized (e.f2933a) {
                        int i2 = AnonymousClass2.f3383a[eVar.ordinal()];
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
