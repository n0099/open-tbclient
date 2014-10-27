package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler sHandler = new Handler();
    private SocketMessageTask aV;
    private CoderException aY;
    private SocketMessage aZ;
    private j bb;
    private volatile int aU = 0;
    private Runnable ba = null;
    private boolean bc = true;
    private int bd = 0;
    private int be = 0;
    private long bf = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.aZ = null;
        this.bb = null;
        this.aV = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.aV = socketMessageTask;
        this.aZ = socketMessage;
        this.bb = jVar;
    }

    public int Y() {
        int retry = this.aV.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void h(int i) {
        if (this.bb != null && this.bc) {
            this.bb.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.bb != null && this.bc) {
            this.bb.b(this);
        }
    }

    private void aa() {
        if (this.bb != null && this.bc) {
            this.bb.c(this);
        }
    }

    private void ab() {
        if (this.bb != null && this.bc) {
            this.bb.d(this);
        }
    }

    private Runnable ac() {
        if (this.ba == null) {
            this.ba = new h(this);
        }
        return this.ba;
    }

    public void ad() {
        sHandler.removeCallbacks(ac());
    }

    public void ae() {
        ad();
        this.bc = false;
    }

    public long af() {
        return this.bf;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void ag() {
        if (this.bf == 0) {
            this.bf = System.currentTimeMillis();
        }
        m.a("SenderData", this.aZ.getCmd(), this.aU, "StartSend", 0, "SenderData: start send size = " + (fP() != null ? fP().length : 0));
        sHandler.removeCallbacks(ac());
        if (this.aV.getTimeOut() != null) {
            sHandler.postDelayed(ac(), this.aV.getTimeOut().aZ());
        }
        ab();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void i(int i) {
        sHandler.removeCallbacks(ac());
        h(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void ah() {
        m.a("SenderData", this.aZ.getCmd(), this.aU, "FinishSend", 0, "SenderData: finish send  size = " + (fP() != null ? fP().length : 0));
        if (!this.aV.be()) {
            sHandler.removeCallbacks(ac());
        }
        aa();
    }

    public CoderException ai() {
        return this.aY;
    }

    public boolean aj() {
        return this.aV.be();
    }

    public int getPriority() {
        return this.aV.getPriority();
    }

    public SocketMessage ak() {
        return this.aZ;
    }

    public SocketMessageTask al() {
        return this.aV;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] am() {
        this.aY = null;
        com.baidu.adp.framework.client.socket.coder.b aK = com.baidu.adp.framework.client.socket.coder.b.aK();
        this.aU = i.at().an();
        try {
            return aK.a(this.aZ, this.aU, this.aV.bf(), this.aV.getNeedEncrypt());
        } catch (CoderException e) {
            this.aY = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.aZ != null) {
            return this.aZ.getCmd();
        }
        return 0;
    }

    public int an() {
        return this.aU;
    }

    public boolean ao() {
        return this.aV.bg();
    }

    public int ap() {
        return this.be;
    }

    public int aq() {
        int i = this.be + 1;
        this.be = i;
        return i;
    }

    public int ar() {
        return this.bd;
    }

    public int as() {
        int i = this.bd + 1;
        this.bd = i;
        return i;
    }
}
