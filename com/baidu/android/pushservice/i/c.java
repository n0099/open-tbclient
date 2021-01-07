package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1416a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private long f1417b = System.currentTimeMillis();
    private a c;
    private Context d;
    private Intent e;
    private String f;
    private Intent g;

    public c(Context context, Intent intent, String str) {
        this.d = context;
        this.e = intent;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f1417b;
    }

    public void a(Intent intent) {
        if (this.c != null) {
            this.c.a(0, intent);
        }
        this.g = intent;
        synchronized (f1416a) {
            f1416a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.e.putExtra("bd.cross.request.ID", this.f1417b);
        this.e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.d.getPackageName());
        this.e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.d, this.e, this.f);
        } catch (Exception e) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("timeOutRunnable-" + this.f1417b, (short) 50) { // from class: com.baidu.android.pushservice.i.c.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f1416a) {
                        c.f1416a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.c == null) {
            synchronized (f1416a) {
                try {
                    f1416a.wait();
                } catch (Exception e2) {
                    new b.c(this.d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            if (this.g != null) {
                gVar.a(this.g.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.g.getStringExtra("bd.cross.request.RESULT_DATA");
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

    synchronized void c() {
        this.c = null;
        this.d = null;
        b.a(this.f1417b);
    }
}
