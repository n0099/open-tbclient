package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler eV = new Handler();
    private SocketMessageTask eS;
    private CoderException eW;
    private SocketMessage eX;
    private h eZ;
    public long fe;
    public long ff;
    private volatile int eR = 0;
    private Runnable eY = null;
    private boolean fa = true;
    private int fb = 0;
    private int fc = 0;
    private long fd = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.eX = null;
        this.eZ = null;
        this.eS = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.eS = socketMessageTask;
        this.eX = socketMessage;
        this.eZ = hVar;
    }

    public int as() {
        int retry = this.eS.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void z(int i) {
        if (this.eZ != null && this.fa) {
            this.eZ.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (this.eZ != null && this.fa) {
            this.eZ.b(this);
        }
    }

    private void au() {
        if (this.eZ != null && this.fa) {
            this.eZ.c(this);
        }
    }

    private void av() {
        if (this.eZ != null && this.fa) {
            this.eZ.d(this);
        }
    }

    private Runnable aw() {
        if (this.eY == null) {
            this.eY = new f(this);
        }
        return this.eY;
    }

    public void ax() {
        eV.removeCallbacks(aw());
    }

    public void ay() {
        ax();
        this.fa = false;
    }

    public long az() {
        return this.fd;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aA() {
        if (this.fd == 0) {
            this.fd = System.currentTimeMillis();
        }
        k.a("SenderData", this.eX.getCmd(), this.eX.getClientLogID(), this.eR, "StartSend", 0, "SenderData: start send size = " + (fZ() != null ? fZ().length : 0));
        eV.removeCallbacks(aw());
        if (this.eS.getTimeOut() != null) {
            eV.postDelayed(aw(), this.eS.getTimeOut().bu());
        }
        av();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void A(int i) {
        eV.removeCallbacks(aw());
        z(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aB() {
        int i;
        int cmd = this.eX.getCmd();
        if (fZ() != null) {
            int length = fZ().length;
            this.eX.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.eX.getClientLogID(), this.eR, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.eS.bx()) {
            eV.removeCallbacks(aw());
        }
        au();
    }

    public CoderException aC() {
        return this.eW;
    }

    public boolean aD() {
        return this.eS.bx();
    }

    public int getPriority() {
        return this.eS.getPriority();
    }

    public SocketMessage aE() {
        return this.eX;
    }

    public SocketMessageTask aF() {
        return this.eS;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] aG() {
        if (this.fd == 0) {
            this.fd = System.currentTimeMillis();
        }
        this.eW = null;
        com.baidu.adp.framework.client.socket.coder.b bf = com.baidu.adp.framework.client.socket.coder.b.bf();
        this.eR = g.aM().aH();
        if (this.eX != null) {
            this.eX.setSquencedId(this.eR);
            com.baidu.adp.lib.stats.a dN = com.baidu.adp.lib.stats.a.dN();
            long clientLogID = this.eX == null ? -1L : this.eX.getClientLogID();
            String valueOf = String.valueOf(this.eR & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.eX == null ? -1 : this.eX.getCmd());
            dN.a("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return bf.a(this.eX, this.eR, this.eS.by(), this.eS.getNeedEncrypt());
        } catch (CoderException e) {
            this.eW = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.eX != null) {
            return this.eX.getCmd();
        }
        return 0;
    }

    public int aH() {
        return this.eR;
    }

    public boolean canRetry() {
        return this.eS.bz();
    }

    public int aI() {
        return this.fc;
    }

    public int aJ() {
        int i = this.fc + 1;
        this.fc = i;
        return i;
    }

    public int aK() {
        return this.fb;
    }

    public int aL() {
        int i = this.fb + 1;
        this.fb = i;
        return i;
    }
}
