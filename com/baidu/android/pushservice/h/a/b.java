package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: com.baidu.android.pushservice.h.a.b$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1380a = new int[a.e.values().length];

        static {
            try {
                f1380a[a.e.CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1380a[a.e.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1380a[a.e.CONNECTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1380a[a.e.REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1380a[a.e.ACK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f1381a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.a f1382b = new com.baidu.android.pushservice.c.a.a();

        public a(Context context) {
            this.f1381a = context;
            this.f1382b.f1199a = "";
            this.f1382b.f1200b = "";
            this.f1382b.c = -1L;
            this.f1382b.d = "";
            this.f1382b.e = -1L;
        }

        public a a(long j) {
            this.f1382b.c = j;
            return this;
        }

        public a a(String str) {
            this.f1382b.f1199a = str;
            return this;
        }

        public void a() {
            b.b(this.f1381a, a.e.ACK, this.f1382b);
        }

        public a b(long j) {
            this.f1382b.e = j;
            return this;
        }

        public a b(String str) {
            this.f1382b.f1200b = str;
            return this;
        }

        public a c(String str) {
            this.f1382b.d = str;
            return this;
        }
    }

    /* renamed from: com.baidu.android.pushservice.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0058b {

        /* renamed from: a  reason: collision with root package name */
        private Context f1383a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.b f1384b = new com.baidu.android.pushservice.c.a.b();
        private boolean c;

        public C0058b(Context context) {
            this.f1383a = context;
            this.f1384b.f1203a = -1L;
            this.f1384b.f1204b = -1L;
            this.f1384b.c = "";
            this.f1384b.d = -1L;
            this.f1384b.e = -1L;
            this.f1384b.f = "";
            this.f1384b.g = -1L;
        }

        public C0058b a(long j) {
            this.f1384b.f1203a = j;
            return this;
        }

        public C0058b a(String str) {
            this.f1384b.c = str;
            return this;
        }

        public C0058b a(boolean z) {
            this.c = z;
            return this;
        }

        public void a() {
            if (this.c) {
                e.a(this.f1383a).a(this.f1384b);
            } else {
                b.b(this.f1383a, a.e.CONNECTION, this.f1384b);
            }
        }

        public C0058b b(long j) {
            this.f1384b.f1204b = j;
            return this;
        }

        public C0058b b(String str) {
            this.f1384b.f = str;
            return this;
        }

        public C0058b c(long j) {
            this.f1384b.e = j;
            return this;
        }

        public C0058b d(long j) {
            this.f1384b.g = j;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private Context f1385a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.c f1386b = new com.baidu.android.pushservice.c.a.c();

        public c(Context context) {
            this.f1385a = context;
            this.f1386b.f1207a = "";
            this.f1386b.f1208b = System.currentTimeMillis();
            this.f1386b.c = "";
            this.f1386b.d = 201001L;
        }

        public c a(long j) {
            this.f1386b.d = j;
            return this;
        }

        public c a(String str) {
            this.f1386b.f1207a = str;
            return this;
        }

        public void a() {
            if (TextUtils.isEmpty(this.f1386b.f1207a)) {
                return;
            }
            b.b(this.f1385a, a.e.CRASH, this.f1386b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private Context f1387a;

        /* renamed from: b  reason: collision with root package name */
        private com.baidu.android.pushservice.c.a.e f1388b = new com.baidu.android.pushservice.c.a.e();

        public d(Context context) {
            this.f1387a = context;
            this.f1388b.f1213a = "";
            this.f1388b.f1214b = "";
            this.f1388b.c = -1L;
            this.f1388b.d = -1L;
            this.f1388b.e = -1L;
            this.f1388b.f = "";
            this.f1388b.g = -1L;
        }

        public d a(long j) {
            this.f1388b.c = j;
            return this;
        }

        public d a(String str) {
            this.f1388b.f1213a = str;
            return this;
        }

        public void a() {
            b.b(this.f1387a, a.e.REQUEST, this.f1388b);
        }

        public d b(long j) {
            this.f1388b.d = j;
            return this;
        }

        public d b(String str) {
            this.f1388b.f1214b = str;
            return this;
        }

        public d c(long j) {
            this.f1388b.e = j;
            return this;
        }

        public d c(String str) {
            this.f1388b.f = str;
            return this;
        }

        public d d(long j) {
            this.f1388b.g = j;
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
                    synchronized (e.f1239a) {
                        switch (AnonymousClass2.f1380a[eVar.ordinal()]) {
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
