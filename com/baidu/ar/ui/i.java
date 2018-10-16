package com.baidu.ar.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.util.MsgConstants;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class i {
    private static i a;
    private a b;
    private r c;
    private Timer d;
    private TimerTask e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private WeakReference<i> a;

        a(i iVar) {
            this.a = new WeakReference<>(iVar);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.a == null || this.a.get() == null || this.a.get().c == null) {
                return;
            }
            this.a.get().c.a(message);
        }
    }

    private i() {
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    private void i() {
        this.e = new TimerTask() { // from class: com.baidu.ar.ui.i.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.this.a(MsgConstants.TRACK_SHOW_RECG_NOTSANNER, 0L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, long j) {
        if (this.b != null) {
            if (j != 0) {
                this.b.sendEmptyMessageDelayed(i, j);
            } else {
                this.b.sendEmptyMessage(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(r rVar) {
        this.c = rVar;
    }

    public void b() {
        this.b = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Log.d("Performance", "createSacnnerTimer");
        if (this.d == null) {
            this.d = new Timer();
            i();
            Log.d("Performance", "time start");
            this.d.schedule(this.e, ErrDef.Feature.WEIGHT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.d != null) {
            this.d.cancel();
            this.d.purge();
            this.d = null;
        }
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.b != null) {
            this.b.removeMessages(MsgConstants.TRACK_SHOW_RECG_NOTSANNER);
            this.b.removeMessages(MsgConstants.TRACK_HIDE_RECG_NOTSANNER);
            this.b.removeMessages(MsgConstants.TRACK_CLOSE_RECG_NOTSANNER);
            this.b.a();
            this.b = null;
        }
    }

    public void f() {
        d();
        b();
    }

    public void g() {
        d();
        e();
    }

    public void h() {
        e();
        this.c = null;
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }
}
