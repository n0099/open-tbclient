package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3379a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public long f3380b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public a f3381c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3382d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3383e;

    /* renamed from: f  reason: collision with root package name */
    public String f3384f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3385g;

    public c(Context context, Intent intent, String str) {
        this.f3382d = context;
        this.f3383e = intent;
        this.f3384f = str;
    }

    public long a() {
        return this.f3380b;
    }

    public void a(Intent intent) {
        a aVar = this.f3381c;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f3385g = intent;
        synchronized (f3379a) {
            f3379a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.f3383e.putExtra("bd.cross.request.ID", this.f3380b);
        this.f3383e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f3383e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3382d.getPackageName());
        this.f3383e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.f3382d, this.f3383e, this.f3384f);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("timeOutRunnable-" + this.f3380b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f3379a) {
                        c.f3379a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.f3382d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.f3381c == null) {
            synchronized (f3379a) {
                try {
                    f3379a.wait();
                } catch (Exception e2) {
                    new b.c(this.f3382d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            Intent intent = this.f3385g;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f3385g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f3385g.getStringExtra("bd.cross.request.RESULT_DATA");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        gVar.a(stringExtra.getBytes());
                    }
                }
            } else {
                gVar.a(11);
            }
        }
        return gVar;
    }

    public synchronized void c() {
        this.f3381c = null;
        this.f3382d = null;
        b.a(this.f3380b);
    }
}
