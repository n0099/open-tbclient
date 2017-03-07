package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler pa = new Handler();
    private SocketMessageTask oX;
    private CoderException pd;
    private SocketMessage pe;
    private h pg;
    public long po;
    public long pp;
    private volatile int oW = 0;
    private Runnable pf = null;
    private boolean ph = true;
    private int pi = 0;
    private int pj = 0;
    private long pl = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.pe = null;
        this.pg = null;
        this.oX = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.oX = socketMessageTask;
        this.pe = socketMessage;
        this.pg = hVar;
    }

    public int cw() {
        int retry = this.oX.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void N(int i) {
        if (this.pg != null && this.ph) {
            this.pg.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx() {
        if (this.pg != null && this.ph) {
            this.pg.b(this);
        }
    }

    private void cy() {
        if (this.pg != null && this.ph) {
            this.pg.c(this);
        }
    }

    private void cz() {
        if (this.pg != null && this.ph) {
            this.pg.d(this);
        }
    }

    private Runnable cA() {
        if (this.pf == null) {
            this.pf = new f(this);
        }
        return this.pf;
    }

    public void cB() {
        pa.removeCallbacks(cA());
    }

    public void cC() {
        cB();
        this.ph = false;
    }

    public long cD() {
        return this.pl;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void cE() {
        if (this.pl == 0) {
            this.pl = System.currentTimeMillis();
        }
        k.a("SenderData", this.pe.getCmd(), this.pe.getClientLogID(), this.oW, "StartSend", 0, "SenderData: start send size = " + (hN() != null ? hN().length : 0));
        pa.removeCallbacks(cA());
        if (this.oX.getTimeOut() != null) {
            pa.postDelayed(cA(), this.oX.getTimeOut().dw());
        }
        cz();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void O(int i) {
        pa.removeCallbacks(cA());
        N(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void cF() {
        int i;
        int cmd = this.pe.getCmd();
        if (hN() != null) {
            int length = hN().length;
            this.pe.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.pe.getClientLogID(), this.oW, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.oX.dz()) {
            pa.removeCallbacks(cA());
        }
        cy();
    }

    public CoderException cG() {
        return this.pd;
    }

    public boolean cH() {
        return this.oX.dz();
    }

    public int getPriority() {
        return this.oX.getPriority();
    }

    public SocketMessage cI() {
        return this.pe;
    }

    public SocketMessageTask cJ() {
        return this.oX;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cK() {
        if (this.pl == 0) {
            this.pl = System.currentTimeMillis();
        }
        this.pd = null;
        com.baidu.adp.framework.client.socket.coder.b dj = com.baidu.adp.framework.client.socket.coder.b.dj();
        this.oW = g.cQ().cL();
        if (this.pe != null) {
            this.pe.setSquencedId(this.oW);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.pe == null ? -1L : this.pe.getClientLogID();
            String valueOf = String.valueOf(this.oW & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.pe == null ? -1 : this.pe.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dj.a(this.pe, this.oW, this.oX.dA(), this.oX.getNeedEncrypt());
        } catch (CoderException e) {
            this.pd = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.pe != null) {
            return this.pe.getCmd();
        }
        return 0;
    }

    public int cL() {
        return this.oW;
    }

    public boolean canRetry() {
        return this.oX.dB();
    }

    public int cM() {
        return this.pj;
    }

    public int cN() {
        int i = this.pj + 1;
        this.pj = i;
        return i;
    }

    public int cO() {
        return this.pi;
    }

    public int cP() {
        int i = this.pi + 1;
        this.pi = i;
        return i;
    }
}
