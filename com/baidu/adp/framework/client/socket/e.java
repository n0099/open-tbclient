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
    private SocketMessage vA;
    private g vC;
    public long vH;
    public long vI;
    private SocketMessageTask vw;
    private CoderException vz;
    private volatile int vv = 0;
    private Runnable vB = null;
    private boolean vD = true;
    private int vE = 0;
    private int vF = 0;
    private long vG = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.vA = null;
        this.vC = null;
        this.vw = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.vw = socketMessageTask;
        this.vA = socketMessage;
        this.vC = gVar;
    }

    public int fZ() {
        int retry = this.vw.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void N(int i) {
        if (this.vC != null && this.vD) {
            this.vC.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        if (this.vC != null && this.vD) {
            this.vC.b(this);
        }
    }

    private void gb() {
        if (this.vC != null && this.vD) {
            this.vC.c(this);
        }
    }

    private void gd() {
        if (this.vC != null && this.vD) {
            this.vC.d(this);
        }
    }

    private Runnable ge() {
        if (this.vB == null) {
            this.vB = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ga();
                }
            };
        }
        return this.vB;
    }

    public void gf() {
        sHandler.removeCallbacks(ge());
    }

    public void gg() {
        gf();
        this.vD = false;
    }

    public long gh() {
        return this.vG;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gi() {
        if (this.vG == 0) {
            this.vG = System.currentTimeMillis();
        }
        i.a("SenderData", this.vA.getCmd(), this.vA.getClientLogID(), this.vv, "StartSend", 0, "SenderData: start send size = " + (lr() != null ? lr().length : 0));
        sHandler.removeCallbacks(ge());
        if (this.vw.getTimeOut() != null) {
            sHandler.postDelayed(ge(), this.vw.getTimeOut().ha());
        }
        gd();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void O(int i) {
        sHandler.removeCallbacks(ge());
        N(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gj() {
        int i;
        int cmd = this.vA.getCmd();
        if (lr() != null) {
            int length = lr().length;
            this.vA.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.vA.getClientLogID(), this.vv, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.vw.hd()) {
            sHandler.removeCallbacks(ge());
        }
        gb();
    }

    public CoderException gk() {
        return this.vz;
    }

    public boolean gl() {
        return this.vw.hd();
    }

    public int getPriority() {
        return this.vw.getPriority();
    }

    public SocketMessage gm() {
        return this.vA;
    }

    public SocketMessageTask gn() {
        return this.vw;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] go() {
        if (this.vG == 0) {
            this.vG = System.currentTimeMillis();
        }
        this.vz = null;
        com.baidu.adp.framework.client.socket.coder.b gN = com.baidu.adp.framework.client.socket.coder.b.gN();
        this.vv = f.gu().getSequenceId();
        if (this.vA != null) {
            this.vA.setSquencedId(this.vv);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.vA == null ? -1L : this.vA.getClientLogID();
            String valueOf = String.valueOf(this.vv & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.vA == null ? -1 : this.vA.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return gN.a(this.vA, this.vv, this.vw.he(), this.vw.getNeedEncrypt());
        } catch (CoderException e) {
            this.vz = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.vA != null) {
            return this.vA.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.vv;
    }

    public boolean gp() {
        return this.vw.hf();
    }

    public int gq() {
        return this.vF;
    }

    public int gr() {
        int i = this.vF + 1;
        this.vF = i;
        return i;
    }

    public int gs() {
        return this.vE;
    }

    public int gt() {
        int i = this.vE + 1;
        this.vE = i;
        return i;
    }
}
