package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.pushservice.p.g;
import com.baidu.android.pushservice.p.j;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static volatile c e;
    public Context a;
    public Handler b;
    public Runnable c;
    public volatile boolean d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d = true;
            this.a.a(-1, null);
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.a {
        public final /* synthetic */ d a;

        public b(d dVar) {
            this.a = dVar;
        }

        @Override // com.baidu.android.pushservice.p.g.a
        public void a(List<String> list) {
            if (c.this.b != null) {
                c.this.b.removeCallbacksAndMessages(null);
            }
            if (c.this.d) {
                c.this.d = false;
            } else {
                this.a.a(0, list);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0026c implements j.a {
        public final /* synthetic */ d a;

        public C0026c(c cVar, d dVar) {
            this.a = dVar;
        }

        @Override // com.baidu.android.pushservice.p.j.a
        public void a(int i, List<String> list) {
            this.a.a(i, list);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i, List<String> list);
    }

    public c(Context context) {
        this.a = context.getApplicationContext();
        this.b = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c(context);
                }
            }
        }
        return e;
    }

    public final com.baidu.android.pushservice.z.c a(d dVar, String str) {
        return new com.baidu.android.pushservice.p.g(this.a, str, new b(dVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, d dVar) {
        com.baidu.android.pushservice.z.c a2;
        String b2;
        if (dVar == null) {
            return;
        }
        if (i == 0) {
            b2 = g.a(this.a);
        } else if (i != 1) {
            if (i == 2) {
                if (this.c == null) {
                    this.c = new a(dVar);
                }
                this.b.postDelayed(this.c, 5000L);
                a2 = a(dVar, g.b(this.a));
                if (a2 == null) {
                    com.baidu.android.pushservice.z.e.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            b2 = g.b(this.a);
        }
        a2 = b(dVar, b2);
        if (a2 == null) {
        }
    }

    public final com.baidu.android.pushservice.z.c b(d dVar, String str) {
        return new com.baidu.android.pushservice.p.j(this.a, str, new C0026c(this, dVar));
    }
}
