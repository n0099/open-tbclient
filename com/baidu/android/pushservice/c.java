package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.pushservice.d.g;
import com.baidu.android.pushservice.d.j;
import java.util.List;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f2761a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2762b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f2763c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f2764d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f2765e;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<String> list);
    }

    public c(Context context) {
        this.f2762b = context.getApplicationContext();
        this.f2763c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        if (f2761a == null) {
            synchronized (c.class) {
                if (f2761a == null) {
                    f2761a = new c(context);
                }
            }
        }
        return f2761a;
    }

    private com.baidu.android.pushservice.h.c a(final a aVar, String str) {
        return new com.baidu.android.pushservice.d.g(this.f2762b, str, new g.a() { // from class: com.baidu.android.pushservice.c.2
            @Override // com.baidu.android.pushservice.d.g.a
            public void a(List<String> list) {
                if (c.this.f2763c != null) {
                    c.this.f2763c.removeCallbacksAndMessages(null);
                }
                if (c.this.f2765e) {
                    c.this.f2765e = false;
                } else {
                    aVar.a(0, list);
                }
            }
        });
    }

    private com.baidu.android.pushservice.h.c b(final a aVar, String str) {
        return new com.baidu.android.pushservice.d.j(this.f2762b, str, new j.a() { // from class: com.baidu.android.pushservice.c.3
            @Override // com.baidu.android.pushservice.d.j.a
            public void a(int i, List<String> list) {
                aVar.a(i, list);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, final a aVar) {
        com.baidu.android.pushservice.h.c a2;
        String c2;
        if (aVar == null) {
            return;
        }
        if (i == 0) {
            c2 = h.d(this.f2762b);
        } else if (i != 1) {
            if (i == 2) {
                if (this.f2764d == null) {
                    this.f2764d = new Runnable() { // from class: com.baidu.android.pushservice.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.f2765e = true;
                            aVar.a(-1, null);
                        }
                    };
                }
                this.f2763c.postDelayed(this.f2764d, 5000L);
                a2 = a(aVar, h.c(this.f2762b));
                if (a2 == null) {
                    com.baidu.android.pushservice.h.d.a().a(a2);
                    return;
                }
                return;
            }
            return;
        } else {
            c2 = h.c(this.f2762b);
        }
        a2 = b(aVar, c2);
        if (a2 == null) {
        }
    }
}
