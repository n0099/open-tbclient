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
        public static final /* synthetic */ int[] f3349a;

        static {
            int[] iArr = new int[a.e.values().length];
            f3349a = iArr;
            try {
                iArr[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3349a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3349a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3349a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3349a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f3350a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.a f3351b;

        public a(Context context) {
            com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
            this.f3351b = aVar;
            this.f3350a = context;
            aVar.f2776a = "";
            aVar.f2777b = "";
            aVar.f2778c = -1L;
            aVar.f2779d = "";
            aVar.f2780e = -1L;
        }

        public a a(long j) {
            this.f3351b.f2778c = j;
            return this;
        }

        public a a(String str) {
            this.f3351b.f2776a = str;
            return this;
        }

        public void a() {
            b.b(this.f3350a, a.e.ACK, this.f3351b);
        }

        public a b(long j) {
            this.f3351b.f2780e = j;
            return this;
        }

        public a b(String str) {
            this.f3351b.f2777b = str;
            return this;
        }

        public a c(String str) {
            this.f3351b.f2779d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0052b {

        /* renamed from: a  reason: collision with root package name */
        public Context f3352a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.b f3353b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3354c;

        public C0052b(Context context) {
            com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
            this.f3353b = bVar;
            this.f3352a = context;
            bVar.f2789a = -1L;
            bVar.f2790b = -1L;
            bVar.f2791c = "";
            bVar.f2792d = -1L;
            bVar.f2793e = -1L;
            bVar.f2794f = "";
            bVar.f2795g = -1L;
        }

        public C0052b a(long j) {
            this.f3353b.f2789a = j;
            return this;
        }

        public C0052b a(String str) {
            this.f3353b.f2791c = str;
            return this;
        }

        public C0052b a(boolean z) {
            this.f3354c = z;
            return this;
        }

        public void a() {
            if (this.f3354c) {
                e.a(this.f3352a).a(this.f3353b);
            } else {
                b.b(this.f3352a, a.e.CONNECTION, this.f3353b);
            }
        }

        public C0052b b(long j) {
            this.f3353b.f2790b = j;
            return this;
        }

        public C0052b b(String str) {
            this.f3353b.f2794f = str;
            return this;
        }

        public C0052b c(long j) {
            this.f3353b.f2793e = j;
            return this;
        }

        public C0052b d(long j) {
            this.f3353b.f2795g = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Context f3355a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.c f3356b;

        public c(Context context) {
            com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
            this.f3356b = cVar;
            this.f3355a = context;
            cVar.f2804a = "";
            cVar.f2805b = System.currentTimeMillis();
            com.baidu.android.pushservice.c.a.c cVar2 = this.f3356b;
            cVar2.f2806c = "";
            cVar2.f2807d = 201001L;
        }

        public c a(long j) {
            this.f3356b.f2807d = j;
            return this;
        }

        public c a(String str) {
            this.f3356b.f2804a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f3356b.f2804a)) {
                return;
            }
            b.b(this.f3355a, a.e.CRASH, this.f3356b);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Context f3357a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.android.pushservice.c.a.e f3358b;

        public d(Context context) {
            com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
            this.f3358b = eVar;
            this.f3357a = context;
            eVar.f2824a = "";
            eVar.f2825b = "";
            eVar.f2826c = -1L;
            eVar.f2827d = -1L;
            eVar.f2828e = -1L;
            eVar.f2829f = "";
            eVar.f2830g = -1L;
        }

        public d a(long j) {
            this.f3358b.f2826c = j;
            return this;
        }

        public d a(String str) {
            this.f3358b.f2824a = str;
            return this;
        }

        public void a() {
            b.b(this.f3357a, a.e.REQUEST, this.f3358b);
        }

        public d b(long j) {
            this.f3358b.f2827d = j;
            return this;
        }

        public d b(String str) {
            this.f3358b.f2825b = str;
            return this;
        }

        public d c(long j) {
            this.f3358b.f2828e = j;
            return this;
        }

        public d c(String str) {
            this.f3358b.f2829f = str;
            return this;
        }

        public d d(long j) {
            this.f3358b.f2830g = j;
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
                    synchronized (e.f2923a) {
                        int i = AnonymousClass2.f3349a[eVar.ordinal()];
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
