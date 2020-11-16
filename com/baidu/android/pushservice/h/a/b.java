package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: com.baidu.android.pushservice.h.a.b$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1130a = new int[a.e.values().length];

        static {
            try {
                f1130a[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1130a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1130a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1130a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1130a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f1131a;
        private com.baidu.android.pushservice.c.a.a b = new com.baidu.android.pushservice.c.a.a();

        public a(Context context) {
            this.f1131a = context;
            this.b.f1029a = "";
            this.b.b = "";
            this.b.c = -1L;
            this.b.d = "";
            this.b.e = -1L;
        }

        public a a(long j) {
            this.b.c = j;
            return this;
        }

        public a a(String str) {
            this.b.f1029a = str;
            return this;
        }

        public void a() {
            b.b(this.f1131a, a.e.ACK, this.b);
        }

        public a b(long j) {
            this.b.e = j;
            return this;
        }

        public a b(String str) {
            this.b.b = str;
            return this;
        }

        public a c(String str) {
            this.b.d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0064b {

        /* renamed from: a  reason: collision with root package name */
        private Context f1132a;
        private com.baidu.android.pushservice.c.a.b b = new com.baidu.android.pushservice.c.a.b();
        private boolean c;

        public C0064b(Context context) {
            this.f1132a = context;
            this.b.f1031a = -1L;
            this.b.b = -1L;
            this.b.c = "";
            this.b.d = -1L;
            this.b.e = -1L;
            this.b.f = "";
            this.b.g = -1L;
        }

        public C0064b a(long j) {
            this.b.f1031a = j;
            return this;
        }

        public C0064b a(String str) {
            this.b.c = str;
            return this;
        }

        public C0064b a(boolean z) {
            this.c = z;
            return this;
        }

        public void a() {
            if (this.c) {
                e.a(this.f1132a).a(this.b);
            } else {
                b.b(this.f1132a, a.e.CONNECTION, this.b);
            }
        }

        public C0064b b(long j) {
            this.b.b = j;
            return this;
        }

        public C0064b b(String str) {
            this.b.f = str;
            return this;
        }

        public C0064b c(long j) {
            this.b.e = j;
            return this;
        }

        public C0064b d(long j) {
            this.b.g = j;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private Context f1133a;
        private com.baidu.android.pushservice.c.a.c b = new com.baidu.android.pushservice.c.a.c();

        public c(Context context) {
            this.f1133a = context;
            this.b.f1033a = "";
            this.b.b = System.currentTimeMillis();
            this.b.c = "";
            this.b.d = 201001L;
        }

        public c a(long j) {
            this.b.d = j;
            return this;
        }

        public c a(String str) {
            this.b.f1033a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.b.f1033a)) {
                return;
            }
            b.b(this.f1133a, a.e.CRASH, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private Context f1134a;
        private com.baidu.android.pushservice.c.a.e b = new com.baidu.android.pushservice.c.a.e();

        public d(Context context) {
            this.f1134a = context;
            this.b.f1036a = "";
            this.b.b = "";
            this.b.c = -1L;
            this.b.d = -1L;
            this.b.e = -1L;
            this.b.f = "";
            this.b.g = -1L;
        }

        public d a(long j) {
            this.b.c = j;
            return this;
        }

        public d a(String str) {
            this.b.f1036a = str;
            return this;
        }

        public void a() {
            b.b(this.f1134a, a.e.REQUEST, this.b);
        }

        public d b(long j) {
            this.b.d = j;
            return this;
        }

        public d b(String str) {
            this.b.b = str;
            return this;
        }

        public d c(long j) {
            this.b.e = j;
            return this;
        }

        public d c(String str) {
            this.b.f = str;
            return this;
        }

        public d d(long j) {
            this.b.g = j;
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
                    synchronized (e.f1049a) {
                        switch (AnonymousClass2.f1130a[eVar.ordinal()]) {
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
