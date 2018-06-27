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
    private SocketMessageTask te;
    private CoderException th;
    private SocketMessage ti;
    private g tk;
    public long tr;
    public long ts;
    private volatile int td = 0;
    private Runnable tj = null;
    private boolean tl = true;
    private int tm = 0;
    private int tp = 0;
    private long tq = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.ti = null;
        this.tk = null;
        this.te = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.te = socketMessageTask;
        this.ti = socketMessage;
        this.tk = gVar;
    }

    public int eS() {
        int retry = this.te.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tk != null && this.tl) {
            this.tk.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT() {
        if (this.tk != null && this.tl) {
            this.tk.b(this);
        }
    }

    private void eU() {
        if (this.tk != null && this.tl) {
            this.tk.c(this);
        }
    }

    private void eV() {
        if (this.tk != null && this.tl) {
            this.tk.d(this);
        }
    }

    private Runnable eW() {
        if (this.tj == null) {
            this.tj = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eT();
                }
            };
        }
        return this.tj;
    }

    public void eX() {
        sHandler.removeCallbacks(eW());
    }

    public void eY() {
        eX();
        this.tl = false;
    }

    public long eZ() {
        return this.tq;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fa() {
        if (this.tq == 0) {
            this.tq = System.currentTimeMillis();
        }
        i.a("SenderData", this.ti.getCmd(), this.ti.getClientLogID(), this.td, "StartSend", 0, "SenderData: start send size = " + (kk() != null ? kk().length : 0));
        sHandler.removeCallbacks(eW());
        if (this.te.getTimeOut() != null) {
            sHandler.postDelayed(eW(), this.te.getTimeOut().fT());
        }
        eV();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void G(int i) {
        sHandler.removeCallbacks(eW());
        F(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fb() {
        int i;
        int cmd = this.ti.getCmd();
        if (kk() != null) {
            int length = kk().length;
            this.ti.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.ti.getClientLogID(), this.td, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.te.fW()) {
            sHandler.removeCallbacks(eW());
        }
        eU();
    }

    public CoderException fc() {
        return this.th;
    }

    public boolean fd() {
        return this.te.fW();
    }

    public int getPriority() {
        return this.te.getPriority();
    }

    public SocketMessage fe() {
        return this.ti;
    }

    public SocketMessageTask ff() {
        return this.te;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] fg() {
        if (this.tq == 0) {
            this.tq = System.currentTimeMillis();
        }
        this.th = null;
        com.baidu.adp.framework.client.socket.coder.b fG = com.baidu.adp.framework.client.socket.coder.b.fG();
        this.td = f.fm().getSequenceId();
        if (this.ti != null) {
            this.ti.setSquencedId(this.td);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.ti == null ? -1L : this.ti.getClientLogID();
            String valueOf = String.valueOf(this.td & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.ti == null ? -1 : this.ti.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fG.a(this.ti, this.td, this.te.fX(), this.te.getNeedEncrypt());
        } catch (CoderException e) {
            this.th = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.ti != null) {
            return this.ti.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.td;
    }

    public boolean fh() {
        return this.te.fY();
    }

    public int fi() {
        return this.tp;
    }

    public int fj() {
        int i = this.tp + 1;
        this.tp = i;
        return i;
    }

    public int fk() {
        return this.tm;
    }

    public int fl() {
        int i = this.tm + 1;
        this.tm = i;
        return i;
    }
}
