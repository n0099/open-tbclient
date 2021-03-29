package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3380a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public long f3381b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public a f3382c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3383d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3384e;

    /* renamed from: f  reason: collision with root package name */
    public String f3385f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3386g;

    public c(Context context, Intent intent, String str) {
        this.f3383d = context;
        this.f3384e = intent;
        this.f3385f = str;
    }

    public long a() {
        return this.f3381b;
    }

    public void a(Intent intent) {
        a aVar = this.f3382c;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f3386g = intent;
        synchronized (f3380a) {
            f3380a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.f3384e.putExtra("bd.cross.request.ID", this.f3381b);
        this.f3384e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f3384e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3383d.getPackageName());
        this.f3384e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.f3383d, this.f3384e, this.f3385f);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("timeOutRunnable-" + this.f3381b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f3380a) {
                        c.f3380a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.f3383d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.f3382c == null) {
            synchronized (f3380a) {
                try {
                    f3380a.wait();
                } catch (Exception e2) {
                    new b.c(this.f3383d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            Intent intent = this.f3386g;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f3386g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f3386g.getStringExtra("bd.cross.request.RESULT_DATA");
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
        this.f3382c = null;
        this.f3383d = null;
        b.a(this.f3381b);
    }
}
