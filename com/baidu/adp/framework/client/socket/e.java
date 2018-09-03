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
    private static Handler sHandler = new Handler();
    private SocketMessageTask sW;
    private CoderException sZ;
    private SocketMessage tb;
    private g td;
    public long ti;
    public long tj;
    private volatile int sV = 0;
    private Runnable tc = null;
    private boolean te = true;
    private int tf = 0;
    private int tg = 0;
    private long th = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.tb = null;
        this.td = null;
        this.sW = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.sW = socketMessageTask;
        this.tb = socketMessage;
        this.td = gVar;
    }

    public int eR() {
        int retry = this.sW.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.td != null && this.te) {
            this.td.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        if (this.td != null && this.te) {
            this.td.b(this);
        }
    }

    private void eT() {
        if (this.td != null && this.te) {
            this.td.c(this);
        }
    }

    private void eU() {
        if (this.td != null && this.te) {
            this.td.d(this);
        }
    }

    private Runnable eV() {
        if (this.tc == null) {
            this.tc = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eS();
                }
            };
        }
        return this.tc;
    }

    public void eW() {
        sHandler.removeCallbacks(eV());
    }

    public void eX() {
        eW();
        this.te = false;
    }

    public long eY() {
        return this.th;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void eZ() {
        if (this.th == 0) {
            this.th = System.currentTimeMillis();
        }
        i.a("SenderData", this.tb.getCmd(), this.tb.getClientLogID(), this.sV, "StartSend", 0, "SenderData: start send size = " + (kl() != null ? kl().length : 0));
        sHandler.removeCallbacks(eV());
        if (this.sW.getTimeOut() != null) {
            sHandler.postDelayed(eV(), this.sW.getTimeOut().fS());
        }
        eU();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void G(int i) {
        sHandler.removeCallbacks(eV());
        F(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fa() {
        int i;
        int cmd = this.tb.getCmd();
        if (kl() != null) {
            int length = kl().length;
            this.tb.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.tb.getClientLogID(), this.sV, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.sW.fV()) {
            sHandler.removeCallbacks(eV());
        }
        eT();
    }

    public CoderException fb() {
        return this.sZ;
    }

    public boolean fc() {
        return this.sW.fV();
    }

    public int getPriority() {
        return this.sW.getPriority();
    }

    public SocketMessage fd() {
        return this.tb;
    }

    public SocketMessageTask fe() {
        return this.sW;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ff() {
        if (this.th == 0) {
            this.th = System.currentTimeMillis();
        }
        this.sZ = null;
        com.baidu.adp.framework.client.socket.coder.b fF = com.baidu.adp.framework.client.socket.coder.b.fF();
        this.sV = f.fl().getSequenceId();
        if (this.tb != null) {
            this.tb.setSquencedId(this.sV);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.tb == null ? -1L : this.tb.getClientLogID();
            String valueOf = String.valueOf(this.sV & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.tb == null ? -1 : this.tb.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fF.a(this.tb, this.sV, this.sW.fW(), this.sW.getNeedEncrypt());
        } catch (CoderException e) {
            this.sZ = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.tb != null) {
            return this.tb.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.sV;
    }

    public boolean fg() {
        return this.sW.fX();
    }

    public int fh() {
        return this.tg;
    }

    public int fi() {
        int i = this.tg + 1;
        this.tg = i;
        return i;
    }

    public int fj() {
        return this.tf;
    }

    public int fk() {
        int i = this.tf + 1;
        this.tf = i;
        return i;
    }
}
