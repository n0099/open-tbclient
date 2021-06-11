package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3473a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public long f3474b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public a f3475c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3476d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3477e;

    /* renamed from: f  reason: collision with root package name */
    public String f3478f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3479g;

    public c(Context context, Intent intent, String str) {
        this.f3476d = context;
        this.f3477e = intent;
        this.f3478f = str;
    }

    public long a() {
        return this.f3474b;
    }

    public void a(Intent intent) {
        a aVar = this.f3475c;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f3479g = intent;
        synchronized (f3473a) {
            f3473a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.f3477e.putExtra("bd.cross.request.ID", this.f3474b);
        this.f3477e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f3477e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3476d.getPackageName());
        this.f3477e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.f3476d, this.f3477e, this.f3478f);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("timeOutRunnable-" + this.f3474b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f3473a) {
                        c.f3473a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.f3476d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.f3475c == null) {
            synchronized (f3473a) {
                try {
                    f3473a.wait();
                } catch (Exception e2) {
                    new b.c(this.f3476d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            Intent intent = this.f3479g;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f3479g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f3479g.getStringExtra("bd.cross.request.RESULT_DATA");
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
        this.f3475c = null;
        this.f3476d = null;
        b.a(this.f3474b);
    }
}
