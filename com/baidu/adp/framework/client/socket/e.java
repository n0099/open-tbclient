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
    private static Handler qk = new Handler();
    private SocketMessageTask qh;
    private CoderException ql;
    private SocketMessage qm;
    private g qo;
    public long qt;
    public long qu;
    private volatile int qg = 0;
    private Runnable qn = null;
    private boolean qp = true;
    private int qq = 0;
    private int qr = 0;
    private long qs = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.qm = null;
        this.qo = null;
        this.qh = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.qh = socketMessageTask;
        this.qm = socketMessage;
        this.qo = gVar;
    }

    public int cG() {
        int retry = this.qh.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void O(int i) {
        if (this.qo != null && this.qp) {
            this.qo.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH() {
        if (this.qo != null && this.qp) {
            this.qo.b(this);
        }
    }

    private void cI() {
        if (this.qo != null && this.qp) {
            this.qo.c(this);
        }
    }

    private void cJ() {
        if (this.qo != null && this.qp) {
            this.qo.d(this);
        }
    }

    private Runnable cK() {
        if (this.qn == null) {
            this.qn = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cH();
                }
            };
        }
        return this.qn;
    }

    public void cL() {
        qk.removeCallbacks(cK());
    }

    public void cM() {
        cL();
        this.qp = false;
    }

    public long cN() {
        return this.qs;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cO() {
        if (this.qs == 0) {
            this.qs = System.currentTimeMillis();
        }
        i.a("SenderData", this.qm.getCmd(), this.qm.getClientLogID(), this.qg, "StartSend", 0, "SenderData: start send size = " + (hZ() != null ? hZ().length : 0));
        qk.removeCallbacks(cK());
        if (this.qh.getTimeOut() != null) {
            qk.postDelayed(cK(), this.qh.getTimeOut().dG());
        }
        cJ();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void P(int i) {
        qk.removeCallbacks(cK());
        O(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cP() {
        int i;
        int cmd = this.qm.getCmd();
        if (hZ() != null) {
            int length = hZ().length;
            this.qm.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.qm.getClientLogID(), this.qg, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.qh.dJ()) {
            qk.removeCallbacks(cK());
        }
        cI();
    }

    public CoderException cQ() {
        return this.ql;
    }

    public boolean cR() {
        return this.qh.dJ();
    }

    public int getPriority() {
        return this.qh.getPriority();
    }

    public SocketMessage cS() {
        return this.qm;
    }

    public SocketMessageTask cT() {
        return this.qh;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cU() {
        if (this.qs == 0) {
            this.qs = System.currentTimeMillis();
        }
        this.ql = null;
        com.baidu.adp.framework.client.socket.coder.b dt = com.baidu.adp.framework.client.socket.coder.b.dt();
        this.qg = f.da().cV();
        if (this.qm != null) {
            this.qm.setSquencedId(this.qg);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.qm == null ? -1L : this.qm.getClientLogID();
            String valueOf = String.valueOf(this.qg & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.qm == null ? -1 : this.qm.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dt.a(this.qm, this.qg, this.qh.dK(), this.qh.getNeedEncrypt());
        } catch (CoderException e) {
            this.ql = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.qm != null) {
            return this.qm.getCmd();
        }
        return 0;
    }

    public int cV() {
        return this.qg;
    }

    public boolean canRetry() {
        return this.qh.dL();
    }

    public int cW() {
        return this.qr;
    }

    public int cX() {
        int i = this.qr + 1;
        this.qr = i;
        return i;
    }

    public int cY() {
        return this.qq;
    }

    public int cZ() {
        int i = this.qq + 1;
        this.qq = i;
        return i;
    }
}
