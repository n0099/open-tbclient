package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
class p {
    private static p qb;
    private b qc;
    private b qd;
    private final Object mLock = new Object();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.p.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    p.this.b((b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void K(int i);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p ch() {
        if (qb == null) {
            qb = new p();
        }
        return qb;
    }

    private p() {
    }

    public void a(int i, a aVar) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                this.qc.duration = i;
                this.mHandler.removeCallbacksAndMessages(this.qc);
                a(this.qc);
                return;
            }
            if (h(aVar)) {
                this.qd.duration = i;
            } else {
                this.qd = new b(i, aVar);
            }
            if (this.qc == null || !a(this.qc, 4)) {
                this.qc = null;
                ci();
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                a(this.qc, i);
            } else if (h(aVar)) {
                a(this.qd, i);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                this.qc = null;
                if (this.qd != null) {
                    ci();
                }
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                a(this.qc);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                this.mHandler.removeCallbacksAndMessages(this.qc);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.mLock) {
            if (g(aVar)) {
                a(this.qc);
            }
        }
    }

    public boolean e(a aVar) {
        boolean g;
        synchronized (this.mLock) {
            g = g(aVar);
        }
        return g;
    }

    public boolean f(a aVar) {
        boolean z;
        synchronized (this.mLock) {
            z = g(aVar) || h(aVar);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        int duration;
        final WeakReference<a> qf;

        b(int i, a aVar) {
            this.qf = new WeakReference<>(aVar);
            this.duration = i;
        }

        boolean i(a aVar) {
            return aVar != null && this.qf.get() == aVar;
        }
    }

    private void ci() {
        if (this.qd != null) {
            this.qc = this.qd;
            this.qd = null;
            a aVar = this.qc.qf.get();
            if (aVar != null) {
                aVar.show();
            } else {
                this.qc = null;
            }
        }
    }

    private boolean a(b bVar, int i) {
        a aVar = bVar.qf.get();
        if (aVar != null) {
            this.mHandler.removeCallbacksAndMessages(bVar);
            aVar.K(i);
            return true;
        }
        return false;
    }

    private boolean g(a aVar) {
        return this.qc != null && this.qc.i(aVar);
    }

    private boolean h(a aVar) {
        return this.qd != null && this.qd.i(aVar);
    }

    private void a(b bVar) {
        if (bVar.duration != -2) {
            int i = 2750;
            if (bVar.duration > 0) {
                i = bVar.duration;
            } else if (bVar.duration == -1) {
                i = TbConfig.POST_IMAGE_SMALL;
            }
            this.mHandler.removeCallbacksAndMessages(bVar);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, bVar), i);
        }
    }

    void b(b bVar) {
        synchronized (this.mLock) {
            if (this.qc == bVar || this.qd == bVar) {
                a(bVar, 2);
            }
        }
    }
}
