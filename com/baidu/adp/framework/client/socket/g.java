package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.c {
    private static Handler oy = new Handler();
    private SocketMessage oA;
    private j oC;
    private SocketMessageTask ov;
    private CoderException oz;
    private volatile int ou = 0;
    private Runnable oB = null;
    private boolean oD = true;
    private int oE = 0;
    private int oF = 0;
    private long oG = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.oA = null;
        this.oC = null;
        this.ov = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ov = socketMessageTask;
        this.oA = socketMessage;
        this.oC = jVar;
    }

    public int dY() {
        int retry = this.ov.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void v(int i) {
        if (this.oC != null && this.oD) {
            this.oC.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ() {
        if (this.oC != null && this.oD) {
            this.oC.b(this);
        }
    }

    private void ea() {
        if (this.oC != null && this.oD) {
            this.oC.c(this);
        }
    }

    private void eb() {
        if (this.oC != null && this.oD) {
            this.oC.d(this);
        }
    }

    private Runnable ec() {
        if (this.oB == null) {
            this.oB = new h(this);
        }
        return this.oB;
    }

    public void ed() {
        oy.removeCallbacks(ec());
    }

    public void ee() {
        ed();
        this.oD = false;
    }

    public long ef() {
        return this.oG;
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void eg() {
        if (this.oG == 0) {
            this.oG = System.currentTimeMillis();
        }
        m.a("SenderData", this.oA.getCmd(), this.oA.getClientLogID(), this.ou, "StartSend", 0, "SenderData: start send size = " + (jD() != null ? jD().length : 0));
        oy.removeCallbacks(ec());
        if (this.ov.getTimeOut() != null) {
            oy.postDelayed(ec(), this.ov.getTimeOut().eZ());
        }
        eb();
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void w(int i) {
        oy.removeCallbacks(ec());
        v(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public void eh() {
        int i;
        int cmd = this.oA.getCmd();
        if (jD() != null) {
            int length = jD().length;
            this.oA.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        m.a("SenderData", cmd, this.oA.getClientLogID(), this.ou, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ov.fg()) {
            oy.removeCallbacks(ec());
        }
        ea();
    }

    public CoderException ei() {
        return this.oz;
    }

    public boolean ej() {
        return this.ov.fg();
    }

    public int getPriority() {
        return this.ov.getPriority();
    }

    public SocketMessage ek() {
        return this.oA;
    }

    public SocketMessageTask el() {
        return this.ov;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] em() {
        this.oz = null;
        com.baidu.adp.framework.client.socket.coder.b eK = com.baidu.adp.framework.client.socket.coder.b.eK();
        this.ou = i.et().en();
        com.baidu.adp.lib.h.a iB = com.baidu.adp.lib.h.a.iB();
        long clientLogID = this.oA == null ? -1L : this.oA.getClientLogID();
        String valueOf = String.valueOf(this.ou);
        Object[] objArr = new Object[2];
        objArr[0] = com.baidu.tbadk.core.frameworkData.c.CMD;
        objArr[1] = Integer.valueOf(this.oA == null ? -1 : this.oA.getCmd());
        iB.a("seqid", clientLogID, valueOf, objArr);
        try {
            return eK.a(this.oA, this.ou, this.ov.fh(), this.ov.getNeedEncrypt());
        } catch (CoderException e) {
            this.oz = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oA != null) {
            return this.oA.getCmd();
        }
        return 0;
    }

    public int en() {
        return this.ou;
    }

    public boolean eo() {
        return this.ov.fi();
    }

    public int ep() {
        return this.oF;
    }

    public int eq() {
        int i = this.oF + 1;
        this.oF = i;
        return i;
    }

    public int er() {
        return this.oE;
    }

    public int es() {
        int i = this.oE + 1;
        this.oE = i;
        return i;
    }
}
