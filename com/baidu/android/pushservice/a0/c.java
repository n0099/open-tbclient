package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class c {
    public static final Object g = new Object();
    public long a = System.currentTimeMillis();
    public com.baidu.android.pushservice.a0.a b;
    public Context c;
    public Intent d;
    public String e;
    public Intent f;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public a(c cVar, String str, short s) {
            super(str, s);
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            try {
                Thread.sleep(1000L);
                synchronized (c.g) {
                    c.g.notifyAll();
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public c(Context context, Intent intent, String str) {
        this.c = context;
        this.d = intent;
        this.e = str;
    }

    public void a(Intent intent) {
        com.baidu.android.pushservice.a0.a aVar = this.b;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f = intent;
        synchronized (g) {
            g.notifyAll();
        }
    }

    public synchronized void b() {
        this.b = null;
        this.c = null;
        b.a(this.a);
    }

    public long c() {
        return this.a;
    }

    public com.baidu.android.pushservice.w.g d() {
        this.d.putExtra("bd.cross.request.ID", this.a);
        this.d.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.d.putExtra("bd.cross.request.SOURCE_PACKAGE", this.c.getPackageName());
        this.d.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            Utility.a(this.c, this.d, this.e);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        com.baidu.android.pushservice.z.e.a().a(new a(this, "timeOutRunnable-" + this.a, (short) 50));
        if (this.b == null) {
            synchronized (g) {
                try {
                    g.wait();
                } catch (Exception unused2) {
                }
            }
            b();
            Intent intent = this.f;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f.getStringExtra("bd.cross.request.RESULT_DATA");
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
}
