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
    private SocketMessageTask tg;
    private CoderException tj;
    private SocketMessage tk;
    private g tm;
    public long tt;
    public long tu;
    private volatile int tf = 0;
    private Runnable tl = null;
    private boolean tp = true;
    private int tq = 0;
    private int tr = 0;
    private long ts = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.tk = null;
        this.tm = null;
        this.tg = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.tg = socketMessageTask;
        this.tk = socketMessage;
        this.tm = gVar;
    }

    public int eS() {
        int retry = this.tg.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tm != null && this.tp) {
            this.tm.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT() {
        if (this.tm != null && this.tp) {
            this.tm.b(this);
        }
    }

    private void eU() {
        if (this.tm != null && this.tp) {
            this.tm.c(this);
        }
    }

    private void eV() {
        if (this.tm != null && this.tp) {
            this.tm.d(this);
        }
    }

    private Runnable eW() {
        if (this.tl == null) {
            this.tl = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eT();
                }
            };
        }
        return this.tl;
    }

    public void eX() {
        sHandler.removeCallbacks(eW());
    }

    public void eY() {
        eX();
        this.tp = false;
    }

    public long eZ() {
        return this.ts;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fa() {
        if (this.ts == 0) {
            this.ts = System.currentTimeMillis();
        }
        i.a("SenderData", this.tk.getCmd(), this.tk.getClientLogID(), this.tf, "StartSend", 0, "SenderData: start send size = " + (kk() != null ? kk().length : 0));
        sHandler.removeCallbacks(eW());
        if (this.tg.getTimeOut() != null) {
            sHandler.postDelayed(eW(), this.tg.getTimeOut().fT());
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
        int cmd = this.tk.getCmd();
        if (kk() != null) {
            int length = kk().length;
            this.tk.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.tk.getClientLogID(), this.tf, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.tg.fW()) {
            sHandler.removeCallbacks(eW());
        }
        eU();
    }

    public CoderException fc() {
        return this.tj;
    }

    public boolean fd() {
        return this.tg.fW();
    }

    public int getPriority() {
        return this.tg.getPriority();
    }

    public SocketMessage fe() {
        return this.tk;
    }

    public SocketMessageTask ff() {
        return this.tg;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] fg() {
        if (this.ts == 0) {
            this.ts = System.currentTimeMillis();
        }
        this.tj = null;
        com.baidu.adp.framework.client.socket.coder.b fG = com.baidu.adp.framework.client.socket.coder.b.fG();
        this.tf = f.fm().getSequenceId();
        if (this.tk != null) {
            this.tk.setSquencedId(this.tf);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.tk == null ? -1L : this.tk.getClientLogID();
            String valueOf = String.valueOf(this.tf & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.tk == null ? -1 : this.tk.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fG.a(this.tk, this.tf, this.tg.fX(), this.tg.getNeedEncrypt());
        } catch (CoderException e) {
            this.tj = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.tk != null) {
            return this.tk.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.tf;
    }

    public boolean fh() {
        return this.tg.fY();
    }

    public int fi() {
        return this.tr;
    }

    public int fj() {
        int i = this.tr + 1;
        this.tr = i;
        return i;
    }

    public int fk() {
        return this.tq;
    }

    public int fl() {
        int i = this.tq + 1;
        this.tq = i;
        return i;
    }
}
