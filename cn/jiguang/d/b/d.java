package cn.jiguang.d.b;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import cn.jiguang.d.d.o;
import cn.jpush.android.service.PushService;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.util.Constants;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class d {
    private static boolean d = false;
    private static final Object j = new Object();
    private static volatile d kS;
    private HandlerThread c;
    private long g;
    private Context h;
    private g kP;
    private f kQ;
    private WeakReference<Service> kR;
    private int m;
    private int n;
    private int e = 0;
    private int f = 0;
    private boolean i = false;
    private final AtomicBoolean kT = new AtomicBoolean(false);

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(d dVar, long j2) {
        cn.jiguang.e.c.a("JiguangTcpManager", "Action - onLoggedIn - connection:" + j2);
        if (!d) {
            cn.jiguang.d.d.g.a(dVar.h.getApplicationContext(), true);
        }
        b(true);
        dVar.j();
        dVar.e = 0;
        dVar.f = 0;
        h.bz().c();
        dVar.kQ.sendEmptyMessageDelayed(Constants.HTTP_ERRCODE_NOT_FIND, 2000L);
        cn.jiguang.d.f.a.bO().a(dVar.h);
        cn.jiguang.a.c.c.a(dVar.h, 2);
        cn.jiguang.d.d.e.bD();
        cn.jiguang.d.d.e.a(dVar.h, j2, 1);
        o.bJ().b(dVar.h, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(d dVar, boolean z) {
        if (dVar.kT.get()) {
            return;
        }
        if (!z) {
            if (System.currentTimeMillis() - dVar.g < 18000) {
                return;
            }
        }
        cn.jiguang.e.c.a("JiguangTcpManager", "Send heart beat");
        dVar.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
        if (g.kV.get() || !d) {
            return;
        }
        dVar.kT.set(true);
        dVar.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES);
        Long valueOf = Long.valueOf(cn.jiguang.d.a.a.f());
        int a = cn.jiguang.d.a.d.a();
        long c = cn.jiguang.d.a.d.c(dVar.h);
        short bH = cn.jiguang.d.d.i.bG().bH();
        long longValue = valueOf.longValue();
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.l(0);
        bVar.k(4);
        bVar.k(2);
        bVar.h(longValue);
        bVar.g(a);
        bVar.h(c);
        bVar.k(bH);
        bVar.l(bVar.current(), 0);
        byte[] a2 = cn.jiguang.d.e.a.a.b.a(bVar.toByteArray(), 1);
        if (a2 != null) {
            cn.jiguang.d.g.c.bP().bQ().j(a2);
        } else {
            cn.jiguang.e.c.c("JiguangTcpManager", "send hb failed:sendData is null");
        }
        dVar.kQ.sendEmptyMessageDelayed(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES, 10000L);
    }

    public static void a(byte[] bArr, String str, int i) {
        h.bz().a(bArr, str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(d dVar) {
        if (dVar.kR != null && dVar.kR.get() != null) {
            dVar.kR.get().stopSelf();
        }
        o.bJ().b(dVar.h);
        dVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(d dVar, long j2) {
        cn.jiguang.e.c.a("JiguangTcpManager", "Action - onDisconnected - connection:" + j2);
        h.bz().b();
        if (g.a.get() == 0 && cn.jiguang.d.a.d.i(dVar.h)) {
            return;
        }
        cn.jiguang.d.d.e.bD();
        cn.jiguang.d.d.e.a(dVar.h, j2, -1);
        if (d) {
            cn.jiguang.d.d.g.a(dVar.h.getApplicationContext(), false);
        }
        b(false);
        dVar.f = 0;
        if (dVar.kP != null) {
            dVar.kP.c();
        }
        if (cn.jiguang.g.a.d(dVar.h.getApplicationContext())) {
            dVar.k();
        }
        dVar.e++;
    }

    private static void b(boolean z) {
        d = z;
        cn.jiguang.d.a.d.c(cn.jiguang.d.a.d, z);
    }

    public static d bx() {
        if (kS == null) {
            synchronized (j) {
                if (kS == null) {
                    kS = new d();
                }
            }
        }
        return kS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(d dVar, long j2) {
        cn.jiguang.e.c.a("JiguangTcpManager", "Action - onHeartbeatSucceed - connection:" + j2);
        if (j2 == g.a.get()) {
            cn.jiguang.d.d.e.bD();
            cn.jiguang.d.d.e.a(dVar.h, j2, 19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(d dVar) {
        if (cn.jiguang.d.d.i.bG().f()) {
            dVar.kT.set(false);
            dVar.f++;
            cn.jiguang.e.c.a("JiguangTcpManager", "Action - onHeartbeatTimeout - timeoutTimes:" + dVar.f);
            if (i()) {
                cn.jiguang.e.c.a("JiguangTcpManager", "Is connecting now. Give up to retry.");
                dVar.kQ.sendEmptyMessageDelayed(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC, 10000L);
            } else if (d && !dVar.h()) {
                cn.jiguang.e.c.a("JiguangTcpManager", "Already logged in. Give up to retry.");
                dVar.kQ.sendEmptyMessageDelayed(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC, 5000L);
            } else {
                if (dVar.kP != null) {
                    dVar.kP.a();
                }
                dVar.k();
            }
        }
    }

    public static boolean d() {
        return d;
    }

    public static long g() {
        return g.a.get();
    }

    private boolean h() {
        return this.f > 1;
    }

    private static boolean i() {
        return (g.a.get() == 0 || d) ? false : true;
    }

    private void j() {
        this.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES);
        this.g = System.currentTimeMillis();
        this.f = 0;
        this.kT.set(false);
    }

    private void k() {
        cn.jiguang.e.c.a("JiguangTcpManager", "Action - retryConnect - disconnectedTimes:" + this.e);
        if (!cn.jiguang.g.a.d(this.h.getApplicationContext()) || cn.jiguang.d.a.a.j()) {
            cn.jiguang.e.c.a("JiguangTcpManager", "network is not connect or hb is one day(user stop service) ");
            return;
        }
        int f = cn.jiguang.g.a.f(this.h.getApplicationContext());
        int pow = (int) (Math.pow(2.0d, this.e) * 3.0d * 1000.0d);
        int g = cn.jiguang.d.a.a.g();
        if (pow > (g * 1000) / 2) {
            pow = (g * 1000) / 2;
        }
        if ((this.e < 5 || f == 1) && !this.kQ.hasMessages(1011)) {
            cn.jiguang.e.c.a("JiguangTcpManager", "onDisconnected and retry restart conn - delay:" + pow);
            this.kQ.sendEmptyMessageDelayed(1011, pow);
        }
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(Service service) {
        if (service != null) {
            this.kR = new WeakReference<>(service);
        }
    }

    public final synchronized void a(Context context) {
        if (!this.i && context != null) {
            this.h = context.getApplicationContext();
            try {
                if (this.c == null || !this.c.isAlive()) {
                    this.c = new e(this, "JCore");
                    this.c.start();
                }
                this.kQ = new f(this, this.c.getLooper() == null ? Looper.getMainLooper() : this.c.getLooper());
            } catch (Exception e) {
                this.kQ = new f(this, Looper.getMainLooper());
            }
            o.bJ().a(this.h);
            h.bz().a(this.h, this.kQ);
            cn.jiguang.d.i.f.bT().a(this.h);
            this.i = true;
        }
    }

    public final void a(Bundle bundle) {
        if (cn.jiguang.d.a.d.i(this.h)) {
            return;
        }
        this.kQ.removeMessages(1006);
        this.kQ.removeMessages(1007);
        if (!bundle.getBoolean("connection-state", false)) {
            this.kQ.sendEmptyMessageDelayed(1007, 3000L);
        } else if (g.a.get() == 0) {
            e();
        } else {
            this.kQ.sendEmptyMessageDelayed(1006, 3000L);
        }
    }

    public final void a(cn.jiguang.api.h hVar, long j2) {
        int a = ((cn.jiguang.d.e.a.a) hVar).a();
        if (a == 2) {
            cn.jiguang.d.d.g.a(Message.obtain(this.kQ, 7303), j2);
        } else if (a == 10) {
            hVar.getHead().b((Long) (-1L));
        }
    }

    public final void a(String str, Bundle bundle) {
        cn.jiguang.d.d.e.bD();
        cn.jiguang.d.d.e.a(this.h, str, g.a.get(), bundle, this.kQ);
        if (!cn.jiguang.d.a.d.i(this.h)) {
            cn.jiguang.e.c.a("JiguangTcpManager", "jiguang service already started");
            return;
        }
        a.a(this.h, true);
        cn.jiguang.d.a.d.b(this.h, false);
        if (g.a.get() == 0) {
            f();
        }
    }

    public final void a(String str, Object obj) {
        j();
        h.bz().a(str, obj);
    }

    public final void a(boolean z) {
        cn.jiguang.d.a.d.h(this.h, z);
        if (this.kR == null || this.kR.get() == null || !(this.kR.get() instanceof PushService)) {
            return;
        }
        ((PushService) this.kR.get()).setDozePowerReceiver();
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void b(String str, Bundle bundle) {
        cn.jiguang.d.d.e.bD();
        cn.jiguang.d.d.e.a(this.h, str, g.a.get(), bundle, this.kQ);
        if (cn.jiguang.d.a.d.i(this.h)) {
            cn.jiguang.e.c.a("JiguangTcpManager", "jiguang service already stoped");
            return;
        }
        cn.jiguang.d.d.i.bG();
        if (cn.jiguang.d.d.i.e()) {
            a.a(this.h, false);
            cn.jiguang.d.a.d.b(this.h, true);
            if (this.kR != null && this.kR.get() != null) {
                this.kR.get().stopSelf();
            }
            c();
        }
    }

    public final void b(boolean z, long j2) {
        if (cn.jiguang.d.a.d.i(this.h)) {
            cn.jiguang.e.c.a("JiguangTcpManager", "tcp has close by active");
        } else if (g.a.get() == 0) {
            e();
        } else if (j2 > 0) {
            if (z) {
                this.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
            }
            this.kQ.sendEmptyMessageDelayed(z ? 1004 : 1005, j2);
        } else {
            this.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
            if (z) {
                this.kQ.removeMessages(1004);
            }
            this.kQ.sendEmptyMessage(z ? 1004 : 1005);
        }
    }

    public final Handler by() {
        return this.kQ;
    }

    public final void c() {
        if (d) {
            cn.jiguang.d.d.g.a(this.h, false);
        }
        b(false);
        this.e = 0;
        this.f = 0;
        if (this.kP != null) {
            this.kP.c();
        }
    }

    public final void e() {
        if (i()) {
            cn.jiguang.e.c.a("JiguangTcpManager", "Is connecting now. Give up to restart.");
        } else if (d && !h()) {
            cn.jiguang.e.c.a("JiguangTcpManager", "Already logged in. Give up to restart.");
        } else {
            this.kQ.removeMessages(1011);
            this.kQ.removeMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r3.kP.e() == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void f() {
        cn.jiguang.e.c.a("JiguangTcpManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!cn.jiguang.g.a.d(this.h.getApplicationContext())) {
            cn.jiguang.e.c.b("JiguangTcpManager", "No network connection. Give up to start connection thread.");
        } else if (cn.jiguang.d.a.d.i(this.h)) {
            cn.jiguang.e.c.a("JiguangTcpManager", "tcp has close by active");
        } else if (this.m == 102) {
            cn.jiguang.e.c.c("JiguangTcpManager", "login failed:102,give up start connection thread.reset from next app start");
        } else {
            if (this.kP != null) {
                cn.jiguang.e.c.a("JiguangTcpManager", "isRunning:" + this.kP.e());
            }
            if (this.kP != null) {
                this.kP.c();
                this.kP = null;
            }
            this.kP = new g(this.h.getApplicationContext(), this.kQ);
            this.kP.b();
        }
    }
}
