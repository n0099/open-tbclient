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
    private static Handler qi = new Handler();
    private SocketMessageTask qf;
    private CoderException qj;
    private SocketMessage qk;
    private g qm;
    public long qr;
    public long qs;
    private volatile int qe = 0;
    private Runnable ql = null;
    private boolean qn = true;
    private int qo = 0;
    private int qp = 0;
    private long qq = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.qk = null;
        this.qm = null;
        this.qf = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.qf = socketMessageTask;
        this.qk = socketMessage;
        this.qm = gVar;
    }

    public int cG() {
        int retry = this.qf.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void O(int i) {
        if (this.qm != null && this.qn) {
            this.qm.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH() {
        if (this.qm != null && this.qn) {
            this.qm.b(this);
        }
    }

    private void cI() {
        if (this.qm != null && this.qn) {
            this.qm.c(this);
        }
    }

    private void cJ() {
        if (this.qm != null && this.qn) {
            this.qm.d(this);
        }
    }

    private Runnable cK() {
        if (this.ql == null) {
            this.ql = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cH();
                }
            };
        }
        return this.ql;
    }

    public void cL() {
        qi.removeCallbacks(cK());
    }

    public void cM() {
        cL();
        this.qn = false;
    }

    public long cN() {
        return this.qq;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cO() {
        if (this.qq == 0) {
            this.qq = System.currentTimeMillis();
        }
        i.a("SenderData", this.qk.getCmd(), this.qk.getClientLogID(), this.qe, "StartSend", 0, "SenderData: start send size = " + (hZ() != null ? hZ().length : 0));
        qi.removeCallbacks(cK());
        if (this.qf.getTimeOut() != null) {
            qi.postDelayed(cK(), this.qf.getTimeOut().dG());
        }
        cJ();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void P(int i) {
        qi.removeCallbacks(cK());
        O(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cP() {
        int i;
        int cmd = this.qk.getCmd();
        if (hZ() != null) {
            int length = hZ().length;
            this.qk.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.qk.getClientLogID(), this.qe, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.qf.dJ()) {
            qi.removeCallbacks(cK());
        }
        cI();
    }

    public CoderException cQ() {
        return this.qj;
    }

    public boolean cR() {
        return this.qf.dJ();
    }

    public int getPriority() {
        return this.qf.getPriority();
    }

    public SocketMessage cS() {
        return this.qk;
    }

    public SocketMessageTask cT() {
        return this.qf;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cU() {
        if (this.qq == 0) {
            this.qq = System.currentTimeMillis();
        }
        this.qj = null;
        com.baidu.adp.framework.client.socket.coder.b dt = com.baidu.adp.framework.client.socket.coder.b.dt();
        this.qe = f.da().cV();
        if (this.qk != null) {
            this.qk.setSquencedId(this.qe);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.qk == null ? -1L : this.qk.getClientLogID();
            String valueOf = String.valueOf(this.qe & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.qk == null ? -1 : this.qk.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dt.a(this.qk, this.qe, this.qf.dK(), this.qf.getNeedEncrypt());
        } catch (CoderException e) {
            this.qj = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.qk != null) {
            return this.qk.getCmd();
        }
        return 0;
    }

    public int cV() {
        return this.qe;
    }

    public boolean canRetry() {
        return this.qf.dL();
    }

    public int cW() {
        return this.qp;
    }

    public int cX() {
        int i = this.qp + 1;
        this.qp = i;
        return i;
    }

    public int cY() {
        return this.qo;
    }

    public int cZ() {
        int i = this.qo + 1;
        this.qo = i;
        return i;
    }
}
