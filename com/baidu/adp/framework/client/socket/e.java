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
    private static Handler oC = new Handler();
    private CoderException oD;
    private SocketMessage oE;
    private h oG;
    private SocketMessageTask oz;
    private volatile int oy = 0;
    private Runnable oF = null;
    private boolean oH = true;
    private int oI = 0;
    private int oJ = 0;
    private long oK = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.oE = null;
        this.oG = null;
        this.oz = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.oz = socketMessageTask;
        this.oE = socketMessage;
        this.oG = hVar;
    }

    public int ec() {
        int retry = this.oz.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void I(int i) {
        if (this.oG != null && this.oH) {
            this.oG.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed() {
        if (this.oG != null && this.oH) {
            this.oG.b(this);
        }
    }

    private void ee() {
        if (this.oG != null && this.oH) {
            this.oG.c(this);
        }
    }

    private void ef() {
        if (this.oG != null && this.oH) {
            this.oG.d(this);
        }
    }

    private Runnable eg() {
        if (this.oF == null) {
            this.oF = new f(this);
        }
        return this.oF;
    }

    public void eh() {
        oC.removeCallbacks(eg());
    }

    public void ei() {
        eh();
        this.oH = false;
    }

    public long ej() {
        return this.oK;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void ek() {
        if (this.oK == 0) {
            this.oK = System.currentTimeMillis();
        }
        k.a("SenderData", this.oE.getCmd(), this.oE.getClientLogID(), this.oy, "StartSend", 0, "SenderData: start send size = " + (jG() != null ? jG().length : 0));
        oC.removeCallbacks(eg());
        if (this.oz.getTimeOut() != null) {
            oC.postDelayed(eg(), this.oz.getTimeOut().fe());
        }
        ef();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void J(int i) {
        oC.removeCallbacks(eg());
        I(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void el() {
        int i;
        int cmd = this.oE.getCmd();
        if (jG() != null) {
            int length = jG().length;
            this.oE.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.oE.getClientLogID(), this.oy, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.oz.fh()) {
            oC.removeCallbacks(eg());
        }
        ee();
    }

    public CoderException em() {
        return this.oD;
    }

    public boolean en() {
        return this.oz.fh();
    }

    public int getPriority() {
        return this.oz.getPriority();
    }

    public SocketMessage eo() {
        return this.oE;
    }

    public SocketMessageTask ep() {
        return this.oz;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] eq() {
        if (this.oK == 0) {
            this.oK = System.currentTimeMillis();
        }
        this.oD = null;
        com.baidu.adp.framework.client.socket.coder.b eO = com.baidu.adp.framework.client.socket.coder.b.eO();
        this.oy = g.ex().er();
        com.baidu.adp.lib.stats.a ht = com.baidu.adp.lib.stats.a.ht();
        long clientLogID = this.oE == null ? -1L : this.oE.getClientLogID();
        String valueOf = String.valueOf(this.oy & 4294967295L);
        Object[] objArr = new Object[2];
        objArr[0] = IntentConfig.CMD;
        objArr[1] = Integer.valueOf(this.oE == null ? -1 : this.oE.getCmd());
        ht.a("seqid", clientLogID, valueOf, objArr);
        try {
            return eO.a(this.oE, this.oy, this.oz.fj(), this.oz.getNeedEncrypt());
        } catch (CoderException e) {
            this.oD = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oE != null) {
            return this.oE.getCmd();
        }
        return 0;
    }

    public int er() {
        return this.oy;
    }

    public boolean es() {
        return this.oz.fk();
    }

    public int et() {
        return this.oJ;
    }

    public int eu() {
        int i = this.oJ + 1;
        this.oJ = i;
        return i;
    }

    public int ev() {
        return this.oI;
    }

    public int ew() {
        int i = this.oI + 1;
        this.oI = i;
        return i;
    }
}
