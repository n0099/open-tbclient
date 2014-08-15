package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private CoderException b;
    private SocketMessage c;
    private j f;
    private SocketMessageTask k;
    private volatile int d = 0;
    private Runnable e = null;
    private boolean g = true;
    private int h = 0;
    private int i = 0;
    private long j = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.c = null;
        this.f = null;
        this.k = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.k = socketMessageTask;
        this.c = socketMessage;
        this.f = jVar;
    }

    public int a() {
        int retry = this.k.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void b(int i) {
        if (this.f != null && this.g) {
            this.f.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f != null && this.g) {
            this.f.a(this);
        }
    }

    private void v() {
        if (this.f != null && this.g) {
            this.f.b(this);
        }
    }

    private void w() {
        if (this.f != null && this.g) {
            this.f.c(this);
        }
    }

    private Runnable x() {
        if (this.e == null) {
            this.e = new h(this);
        }
        return this.e;
    }

    public void b() {
        a.removeCallbacks(x());
    }

    public void c() {
        b();
        this.g = false;
    }

    public long d() {
        return this.j;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void e() {
        if (this.j == 0) {
            this.j = System.currentTimeMillis();
        }
        m.a("SenderData", this.c.getCmd(), this.d, "StartSend", 0, "SenderData: start send size = " + (t() != null ? t().length : 0));
        a.removeCallbacks(x());
        if (this.k.getTimeOut() != null) {
            a.postDelayed(x(), this.k.getTimeOut().b());
        }
        w();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void a(int i) {
        a.removeCallbacks(x());
        b(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void f() {
        m.a("SenderData", this.c.getCmd(), this.d, "FinishSend", 0, "SenderData: finish send  size = " + (t() != null ? t().length : 0));
        if (!this.k.a()) {
            a.removeCallbacks(x());
        }
        v();
    }

    public CoderException g() {
        return this.b;
    }

    public boolean h() {
        return this.k.a();
    }

    public int i() {
        return this.k.getPriority();
    }

    public SocketMessage j() {
        return this.c;
    }

    public SocketMessageTask k() {
        return this.k;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] l() {
        this.b = null;
        com.baidu.adp.framework.client.socket.coder.b a2 = com.baidu.adp.framework.client.socket.coder.b.a();
        this.d = i.a().b();
        try {
            return a2.a(this.c, this.d, this.k.b(), this.k.getNeedEncrypt());
        } catch (CoderException e) {
            this.b = e;
            return null;
        }
    }

    public int m() {
        if (this.c != null) {
            return this.c.getCmd();
        }
        return 0;
    }

    public int n() {
        return this.d;
    }

    public boolean o() {
        return this.k.d();
    }

    public int p() {
        return this.i;
    }

    public int q() {
        int i = this.i + 1;
        this.i = i;
        return i;
    }

    public int r() {
        return this.h;
    }

    public int s() {
        int i = this.h + 1;
        this.h = i;
        return i;
    }
}
