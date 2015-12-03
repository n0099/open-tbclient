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
    private static Handler oz = new Handler();
    private CoderException oA;
    private SocketMessage oB;
    private h oD;
    private SocketMessageTask ow;
    private volatile int ov = 0;
    private Runnable oC = null;
    private boolean oE = true;
    private int oF = 0;
    private int oG = 0;
    private long oH = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.oB = null;
        this.oD = null;
        this.ow = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ow = socketMessageTask;
        this.oB = socketMessage;
        this.oD = hVar;
    }

    public int dZ() {
        int retry = this.ow.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void y(int i) {
        if (this.oD != null && this.oE) {
            this.oD.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        if (this.oD != null && this.oE) {
            this.oD.b(this);
        }
    }

    private void eb() {
        if (this.oD != null && this.oE) {
            this.oD.c(this);
        }
    }

    private void ec() {
        if (this.oD != null && this.oE) {
            this.oD.d(this);
        }
    }

    private Runnable ed() {
        if (this.oC == null) {
            this.oC = new f(this);
        }
        return this.oC;
    }

    public void ee() {
        oz.removeCallbacks(ed());
    }

    public void onRemove() {
        ee();
        this.oE = false;
    }

    public long ef() {
        return this.oH;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void eg() {
        if (this.oH == 0) {
            this.oH = System.currentTimeMillis();
        }
        k.a("SenderData", this.oB.getCmd(), this.oB.getClientLogID(), this.ov, "StartSend", 0, "SenderData: start send size = " + (jw() != null ? jw().length : 0));
        oz.removeCallbacks(ed());
        if (this.ow.getTimeOut() != null) {
            oz.postDelayed(ed(), this.ow.getTimeOut().eX());
        }
        ec();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void z(int i) {
        oz.removeCallbacks(ed());
        y(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void eh() {
        int i;
        int cmd = this.oB.getCmd();
        if (jw() != null) {
            int length = jw().length;
            this.oB.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.oB.getClientLogID(), this.ov, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ow.fa()) {
            oz.removeCallbacks(ed());
        }
        eb();
    }

    public CoderException ei() {
        return this.oA;
    }

    public boolean ej() {
        return this.ow.fa();
    }

    public int getPriority() {
        return this.ow.getPriority();
    }

    public SocketMessage ek() {
        return this.oB;
    }

    public SocketMessageTask el() {
        return this.ow;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] em() {
        if (this.oH == 0) {
            this.oH = System.currentTimeMillis();
        }
        this.oA = null;
        com.baidu.adp.framework.client.socket.coder.b eK = com.baidu.adp.framework.client.socket.coder.b.eK();
        this.ov = g.et().en();
        com.baidu.adp.lib.stats.a hl = com.baidu.adp.lib.stats.a.hl();
        long clientLogID = this.oB == null ? -1L : this.oB.getClientLogID();
        String valueOf = String.valueOf(this.ov & 4294967295L);
        Object[] objArr = new Object[2];
        objArr[0] = IntentConfig.CMD;
        objArr[1] = Integer.valueOf(this.oB == null ? -1 : this.oB.getCmd());
        hl.a("seqid", clientLogID, valueOf, objArr);
        try {
            return eK.a(this.oB, this.ov, this.ow.fb(), this.ow.getNeedEncrypt());
        } catch (CoderException e) {
            this.oA = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oB != null) {
            return this.oB.getCmd();
        }
        return 0;
    }

    public int en() {
        return this.ov;
    }

    public boolean eo() {
        return this.ow.fc();
    }

    public int ep() {
        return this.oG;
    }

    public int eq() {
        int i = this.oG + 1;
        this.oG = i;
        return i;
    }

    public int er() {
        return this.oF;
    }

    public int es() {
        int i = this.oF + 1;
        this.oF = i;
        return i;
    }
}
