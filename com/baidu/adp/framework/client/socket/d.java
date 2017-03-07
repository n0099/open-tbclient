package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId oS = BdUniqueId.gen();
    private a oT;
    private com.baidu.adp.framework.client.socket.coder.c oU;
    private e oV;
    private int oW;
    private SocketMessageTask oX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.oT = null;
        this.oU = null;
        this.oV = null;
        this.oW = 0;
        this.oX = null;
        this.oU = cVar;
        this.oV = eVar;
        this.oT = aVar;
        this.oW = i;
        try {
            if (this.oV != null) {
                this.oX = this.oV.cJ();
            }
            if (this.oX == null) {
                this.oX = (SocketMessageTask) MessageManager.getInstance().findTask(this.oU.qy.df());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(oS);
        setPriority(4);
        if (this.oX != null) {
            setKey(String.valueOf(this.oX.getCmd()));
            setParallel(this.oX.getParallel());
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
        if (this.oU == null) {
            return null;
        }
        try {
            if (this.oV == null) {
                j = 0;
            } else {
                j = this.oV.po;
            }
            if (this.oV == null) {
                j2 = 0;
            } else {
                j2 = this.oV.pp;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.oU.qy.df();
            boolean di = this.oU.qy.di();
            int i3 = this.oU.qB;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(this.oU);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.oV == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage cI = this.oV.cI();
                    long startTime = cI.getStartTime();
                    long cD = this.oV.cD();
                    long j12 = cD - startTime;
                    long j13 = currentTimeMillis - cD;
                    if (j > 0) {
                        j9 = j - cD;
                        if (j2 >= j) {
                            j13 = j2 - cD;
                            j10 = j2 - j;
                            j11 = currentTimeMillis - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = cI;
                    long j14 = j9;
                    j6 = currentTimeMillis2 - currentTimeMillis;
                    j5 = j14;
                }
                if (cVar2.qA != 0 || cVar2.qB != cVar2.qz.length) {
                    if (cVar2.qB <= 0) {
                        cVar2.qz = null;
                    } else {
                        cVar2.qz = ByteBuffer.allocateDirect(cVar2.qB).put(cVar2.qz, cVar2.qA, cVar2.qB).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(i2, cVar2.qz, socketMessage, this.oX, di);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.oV != null && this.oU != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.oV.cD());
                            socketResponsedMessage2.setRetry(this.oV.cM());
                            socketResponsedMessage2.performanceData.re = j3;
                            socketResponsedMessage2.performanceData.rg = j4;
                            socketResponsedMessage2.performanceData.rh = j5;
                            socketResponsedMessage2.performanceData.ri = j7;
                            socketResponsedMessage2.performanceData.rl = j8;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.rk = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.rj = j6;
                        socketResponsedMessage2.sequenceID = this.oU.qy.dh();
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.qz);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j15 = -100;
                    if (this.oV != null && this.oV.cI() != null) {
                        j15 = this.oV.cI().getClientLogID();
                    }
                    BdStatisticsManager.getInstance().error("im", j15, String.valueOf(this.oW), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.oW));
                    k.a("unpacker", i, j15, this.oW, "unpacktask", j.pQ, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.qz);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.oW != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.cI() == null ? -1L : eVar.cI().getClientLogID(), this.oW, "checkresponsedMessage", j.pR, "ack cont responsed");
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
        if (this.oT != null) {
            boolean a2 = a(socketResponsedMessage, this.oV);
            b bVar = new b();
            bVar.oY = socketResponsedMessage;
            if (!a2) {
                bVar.oZ = this.oV;
            }
            this.oT.a(bVar);
        }
    }

    public static BdUniqueId cv() {
        return oS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage oY;
        e oZ;

        b() {
        }
    }
}
