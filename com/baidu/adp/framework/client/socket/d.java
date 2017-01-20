package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId gX = BdUniqueId.gen();
    private a gY;
    private com.baidu.adp.framework.client.socket.coder.c gZ;
    private e ha;
    private int hb;
    private SocketMessageTask hc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.gY = null;
        this.gZ = null;
        this.ha = null;
        this.hb = 0;
        this.hc = null;
        this.gZ = cVar;
        this.ha = eVar;
        this.gY = aVar;
        this.hb = i;
        try {
            if (this.ha != null) {
                this.hc = this.ha.bA();
            }
            if (this.hc == null) {
                this.hc = (SocketMessageTask) MessageManager.getInstance().findTask(this.gZ.iD.bW());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(gX);
        setPriority(4);
        if (this.hc != null) {
            setKey(String.valueOf(this.hc.getCmd()));
            setParallel(this.hc.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        int i2 = 0;
        if (this.gZ == null) {
            return null;
        }
        try {
            if (this.ha == null) {
                j = 0;
            } else {
                j = this.ha.hp;
            }
            if (this.ha == null) {
                j2 = 0;
            } else {
                j2 = this.ha.hq;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.gZ.iD.bW();
            boolean bZ = this.gZ.iD.bZ();
            int i3 = this.gZ.iG;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.ca().a(this.gZ);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.ha == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage bz = this.ha.bz();
                    long startTime = bz.getStartTime();
                    long bu = this.ha.bu();
                    long j12 = bu - startTime;
                    long j13 = currentTimeMillis - bu;
                    if (j > 0) {
                        j9 = j - bu;
                        if (j2 >= j) {
                            j13 = j2 - bu;
                            j10 = j2 - j;
                            j11 = currentTimeMillis - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = bz;
                    long j14 = j9;
                    j6 = currentTimeMillis2 - currentTimeMillis;
                    j5 = j14;
                }
                if (cVar2.iF != 0 || cVar2.iG != cVar2.iE.length) {
                    if (cVar2.iG <= 0) {
                        cVar2.iE = null;
                    } else {
                        cVar2.iE = ByteBuffer.allocateDirect(cVar2.iG).put(cVar2.iE, cVar2.iF, cVar2.iG).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.ca().a(i2, cVar2.iE, socketMessage, this.hc, bZ);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.ha != null && this.gZ != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ha.bu());
                            socketResponsedMessage2.setRetry(this.ha.bD());
                            socketResponsedMessage2.performanceData.jj = j3;
                            socketResponsedMessage2.performanceData.jl = j4;
                            socketResponsedMessage2.performanceData.jm = j5;
                            socketResponsedMessage2.performanceData.jn = j7;
                            socketResponsedMessage2.performanceData.jq = j8;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.jp = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.jo = j6;
                        socketResponsedMessage2.sequenceID = this.gZ.iD.bY();
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.iE);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j15 = -100;
                    if (this.ha != null && this.ha.bz() != null) {
                        j15 = this.ha.bz().getClientLogID();
                    }
                    com.baidu.adp.lib.stats.a.eG().b("im", j15, String.valueOf(this.hb), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.hb));
                    k.a("unpacker", i, j15, this.hb, "unpacktask", j.hQ, "onBinaryMesssage decodebody error");
                    i2 = i;
                    cVar2 = cVar;
                    socketResponsedMessage2 = socketResponsedMessage;
                    if (socketResponsedMessage2 != null) {
                    }
                    publishProgress(socketResponsedMessage2);
                    if (socketResponsedMessage2 != null) {
                    }
                    return null;
                }
            } catch (CoderException e3) {
                i = i2;
                cVar = cVar2;
                socketResponsedMessage = null;
            }
        } catch (CoderException e4) {
            i = i2;
            cVar = null;
            socketResponsedMessage = null;
        }
        if (socketResponsedMessage2 != null) {
            socketResponsedMessage2.setStartTime(System.currentTimeMillis());
        }
        publishProgress(socketResponsedMessage2);
        if (socketResponsedMessage2 != null) {
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.iE);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.hb != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.bz() == null ? -1L : eVar.bz().getClientLogID(), this.hb, "checkresponsedMessage", j.hR, "ack cont responsed");
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
            a(socketResponsedMessageArr[0]);
        } else {
            a((SocketResponsedMessage) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        a((SocketResponsedMessage) null);
    }

    private void a(SocketResponsedMessage socketResponsedMessage) {
        if (this.gY != null) {
            boolean a2 = a(socketResponsedMessage, this.ha);
            b bVar = new b();
            bVar.hd = socketResponsedMessage;
            if (!a2) {
                bVar.hf = this.ha;
            }
            this.gY.a(bVar);
        }
    }

    public static BdUniqueId bm() {
        return gX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage hd;
        e hf;

        b() {
        }
    }
}
