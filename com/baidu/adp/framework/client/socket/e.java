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
    private static Handler ql = new Handler();
    private SocketMessageTask qi;
    private CoderException qm;
    private SocketMessage qn;
    private g qp;
    public long qu;
    public long qv;
    private volatile int qh = 0;
    private Runnable qo = null;
    private boolean qq = true;
    private int qr = 0;
    private int qs = 0;
    private long qt = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.qn = null;
        this.qp = null;
        this.qi = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.qi = socketMessageTask;
        this.qn = socketMessage;
        this.qp = gVar;
    }

    public int cG() {
        int retry = this.qi.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void O(int i) {
        if (this.qp != null && this.qq) {
            this.qp.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH() {
        if (this.qp != null && this.qq) {
            this.qp.b(this);
        }
    }

    private void cI() {
        if (this.qp != null && this.qq) {
            this.qp.c(this);
        }
    }

    private void cJ() {
        if (this.qp != null && this.qq) {
            this.qp.d(this);
        }
    }

    private Runnable cK() {
        if (this.qo == null) {
            this.qo = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cH();
                }
            };
        }
        return this.qo;
    }

    public void cL() {
        ql.removeCallbacks(cK());
    }

    public void cM() {
        cL();
        this.qq = false;
    }

    public long cN() {
        return this.qt;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cO() {
        if (this.qt == 0) {
            this.qt = System.currentTimeMillis();
        }
        i.a("SenderData", this.qn.getCmd(), this.qn.getClientLogID(), this.qh, "StartSend", 0, "SenderData: start send size = " + (hZ() != null ? hZ().length : 0));
        ql.removeCallbacks(cK());
        if (this.qi.getTimeOut() != null) {
            ql.postDelayed(cK(), this.qi.getTimeOut().dG());
        }
        cJ();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void P(int i) {
        ql.removeCallbacks(cK());
        O(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cP() {
        int i;
        int cmd = this.qn.getCmd();
        if (hZ() != null) {
            int length = hZ().length;
            this.qn.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.qn.getClientLogID(), this.qh, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.qi.dJ()) {
            ql.removeCallbacks(cK());
        }
        cI();
    }

    public CoderException cQ() {
        return this.qm;
    }

    public boolean cR() {
        return this.qi.dJ();
    }

    public int getPriority() {
        return this.qi.getPriority();
    }

    public SocketMessage cS() {
        return this.qn;
    }

    public SocketMessageTask cT() {
        return this.qi;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cU() {
        if (this.qt == 0) {
            this.qt = System.currentTimeMillis();
        }
        this.qm = null;
        com.baidu.adp.framework.client.socket.coder.b dt = com.baidu.adp.framework.client.socket.coder.b.dt();
        this.qh = f.da().cV();
        if (this.qn != null) {
            this.qn.setSquencedId(this.qh);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.qn == null ? -1L : this.qn.getClientLogID();
            String valueOf = String.valueOf(this.qh & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.qn == null ? -1 : this.qn.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dt.a(this.qn, this.qh, this.qi.dK(), this.qi.getNeedEncrypt());
        } catch (CoderException e) {
            this.qm = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.qn != null) {
            return this.qn.getCmd();
        }
        return 0;
    }

    public int cV() {
        return this.qh;
    }

    public boolean canRetry() {
        return this.qi.dL();
    }

    public int cW() {
        return this.qs;
    }

    public int cX() {
        int i = this.qs + 1;
        this.qs = i;
        return i;
    }

    public int cY() {
        return this.qr;
    }

    public int cZ() {
        int i = this.qr + 1;
        this.qr = i;
        return i;
    }
}
