package com.baidu.android.pushservice.h;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e {
    private static int c = 1000;
    private static final Object f = new Object();
    private long a = System.currentTimeMillis();
    private c b;
    private Context d;
    private Intent e;
    private Intent g;

    public e(Context context, Intent intent) {
        this.d = context;
        this.e = intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.a;
    }

    public void a(Intent intent) {
        if (this.b != null) {
            this.b.a(0, intent);
        }
        this.g = intent;
        synchronized (f) {
            f.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.d.getPackageName());
        this.e.putExtra("bd.cross.request.ID", this.a);
        this.e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.e.putExtra("bd.cross.request.SENDING", true);
        d.a(this);
        try {
            this.d.startService(this.e);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("CrossAppRequest", e);
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.e.a.c("CrossAppRequest", "send crossapprequest: " + this.e.toUri(0));
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("timeOutRunnable-" + this.a, (short) 50) { // from class: com.baidu.android.pushservice.h.e.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                try {
                    Thread.sleep(e.c);
                    synchronized (e.f) {
                        e.f.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    com.baidu.android.pushservice.e.a.a("CrossAppRequest", "result return, interrupted by callback");
                }
            }
        });
        if (this.b == null) {
            synchronized (f) {
                try {
                    f.wait();
                } catch (Exception e2) {
                    com.baidu.android.pushservice.e.a.a("CrossAppRequest", "wait exception: " + e2);
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
        this.b = null;
        this.d = null;
        d.a(this.a);
    }
}
