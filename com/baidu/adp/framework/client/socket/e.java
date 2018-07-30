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
    private SocketMessageTask sV;
    private CoderException sY;
    private SocketMessage sZ;
    private g tc;
    public long th;
    public long ti;
    private volatile int sU = 0;
    private Runnable tb = null;
    private boolean td = true;
    private int te = 0;
    private int tf = 0;
    private long tg = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.sZ = null;
        this.tc = null;
        this.sV = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.sV = socketMessageTask;
        this.sZ = socketMessage;
        this.tc = gVar;
    }

    public int eR() {
        int retry = this.sV.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tc != null && this.td) {
            this.tc.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        if (this.tc != null && this.td) {
            this.tc.b(this);
        }
    }

    private void eT() {
        if (this.tc != null && this.td) {
            this.tc.c(this);
        }
    }

    private void eU() {
        if (this.tc != null && this.td) {
            this.tc.d(this);
        }
    }

    private Runnable eV() {
        if (this.tb == null) {
            this.tb = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eS();
                }
            };
        }
        return this.tb;
    }

    public void eW() {
        sHandler.removeCallbacks(eV());
    }

    public void eX() {
        eW();
        this.td = false;
    }

    public long eY() {
        return this.tg;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void eZ() {
        if (this.tg == 0) {
            this.tg = System.currentTimeMillis();
        }
        i.a("SenderData", this.sZ.getCmd(), this.sZ.getClientLogID(), this.sU, "StartSend", 0, "SenderData: start send size = " + (kl() != null ? kl().length : 0));
        sHandler.removeCallbacks(eV());
        if (this.sV.getTimeOut() != null) {
            sHandler.postDelayed(eV(), this.sV.getTimeOut().fS());
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
        int cmd = this.sZ.getCmd();
        if (kl() != null) {
            int length = kl().length;
            this.sZ.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.sZ.getClientLogID(), this.sU, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.sV.fV()) {
            sHandler.removeCallbacks(eV());
        }
        eT();
    }

    public CoderException fb() {
        return this.sY;
    }

    public boolean fc() {
        return this.sV.fV();
    }

    public int getPriority() {
        return this.sV.getPriority();
    }

    public SocketMessage fd() {
        return this.sZ;
    }

    public SocketMessageTask fe() {
        return this.sV;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ff() {
        if (this.tg == 0) {
            this.tg = System.currentTimeMillis();
        }
        this.sY = null;
        com.baidu.adp.framework.client.socket.coder.b fF = com.baidu.adp.framework.client.socket.coder.b.fF();
        this.sU = f.fl().getSequenceId();
        if (this.sZ != null) {
            this.sZ.setSquencedId(this.sU);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.sZ == null ? -1L : this.sZ.getClientLogID();
            String valueOf = String.valueOf(this.sU & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.sZ == null ? -1 : this.sZ.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fF.a(this.sZ, this.sU, this.sV.fW(), this.sV.getNeedEncrypt());
        } catch (CoderException e) {
            this.sY = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.sZ != null) {
            return this.sZ.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.sU;
    }

    public boolean fg() {
        return this.sV.fX();
    }

    public int fh() {
        return this.tf;
    }

    public int fi() {
        int i = this.tf + 1;
        this.tf = i;
        return i;
    }

    public int fj() {
        return this.te;
    }

    public int fk() {
        int i = this.te + 1;
        this.te = i;
        return i;
    }
}
