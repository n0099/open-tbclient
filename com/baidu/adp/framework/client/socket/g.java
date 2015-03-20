package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.c {
    private static Handler ot = new Handler();
    private SocketMessageTask oq;
    private CoderException ou;
    private SocketMessage ov;
    private j ox;
    private volatile int oo = 0;
    private Runnable ow = null;
    private boolean oy = true;
    private int oz = 0;
    private int oA = 0;
    private long oB = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.ov = null;
        this.ox = null;
        this.oq = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.oq = socketMessageTask;
        this.ov = socketMessage;
        this.ox = jVar;
    }

    public int dV() {
        int retry = this.oq.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void u(int i) {
        if (this.ox != null && this.oy) {
            this.ox.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW() {
        if (this.ox != null && this.oy) {
            this.ox.b(this);
        }
    }

    private void dX() {
        if (this.ox != null && this.oy) {
            this.ox.c(this);
        }
    }

    private void dY() {
        if (this.ox != null && this.oy) {
            this.ox.d(this);
        }
    }

    private Runnable dZ() {
        if (this.ow == null) {
            this.ow = new h(this);
        }
        return this.ow;
    }

    public void ea() {
        ot.removeCallbacks(dZ());
    }

    public void eb() {
        ea();
        this.oy = false;
    }

    public long ec() {
        return this.oB;
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void ed() {
        if (this.oB == 0) {
            this.oB = System.currentTimeMillis();
        }
        m.a("SenderData", this.ov.getCmd(), this.oo, "StartSend", 0, "SenderData: start send size = " + (jm() != null ? jm().length : 0));
        ot.removeCallbacks(dZ());
        if (this.oq.getTimeOut() != null) {
            ot.postDelayed(dZ(), this.oq.getTimeOut().eV());
        }
        dY();
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void v(int i) {
        ot.removeCallbacks(dZ());
        u(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void ee() {
        int i;
        int cmd = this.ov.getCmd();
        if (jm() != null) {
            int length = jm().length;
            this.ov.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        m.a("SenderData", cmd, this.oo, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.oq.fb()) {
            ot.removeCallbacks(dZ());
        }
        dX();
    }

    public CoderException ef() {
        return this.ou;
    }

    public boolean eg() {
        return this.oq.fb();
    }

    public int getPriority() {
        return this.oq.getPriority();
    }

    public SocketMessage eh() {
        return this.ov;
    }

    public SocketMessageTask ei() {
        return this.oq;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ej() {
        this.ou = null;
        com.baidu.adp.framework.client.socket.coder.b eH = com.baidu.adp.framework.client.socket.coder.b.eH();
        this.oo = i.eq().ek();
        try {
            return eH.a(this.ov, this.oo, this.oq.fc(), this.oq.getNeedEncrypt());
        } catch (CoderException e) {
            this.ou = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.ov != null) {
            return this.ov.getCmd();
        }
        return 0;
    }

    public int ek() {
        return this.oo;
    }

    public boolean el() {
        return this.oq.fd();
    }

    public int em() {
        return this.oA;
    }

    public int en() {
        int i = this.oA + 1;
        this.oA = i;
        return i;
    }

    public int eo() {
        return this.oz;
    }

    public int ep() {
        int i = this.oz + 1;
        this.oz = i;
        return i;
    }
}
