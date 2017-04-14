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
    private static final BdUniqueId oq = BdUniqueId.gen();
    private a or;
    private com.baidu.adp.framework.client.socket.coder.c ot;
    private e ou;
    private int ov;
    private SocketMessageTask ow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.or = null;
        this.ot = null;
        this.ou = null;
        this.ov = 0;
        this.ow = null;
        this.ot = cVar;
        this.ou = eVar;
        this.or = aVar;
        this.ov = i;
        try {
            if (this.ou != null) {
                this.ow = this.ou.cI();
            }
            if (this.ow == null) {
                this.ow = (SocketMessageTask) MessageManager.getInstance().findTask(this.ot.pX.de());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(oq);
        setPriority(4);
        if (this.ow != null) {
            setKey(String.valueOf(this.ow.getCmd()));
            setParallel(this.ow.getParallel());
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
        if (this.ot == null) {
            return null;
        }
        try {
            if (this.ou == null) {
                j = 0;
            } else {
                j = this.ou.oI;
            }
            if (this.ou == null) {
                j2 = 0;
            } else {
                j2 = this.ou.oJ;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.ot.pX.de();
            boolean dh = this.ot.pX.dh();
            int i3 = this.ot.qa;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.di().a(this.ot);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.ou == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage cH = this.ou.cH();
                    long startTime = cH.getStartTime();
                    long cC = this.ou.cC();
                    long j12 = cC - startTime;
                    long j13 = currentTimeMillis - cC;
                    if (j > 0) {
                        j9 = j - cC;
                        if (j2 >= j) {
                            j13 = j2 - cC;
                            j10 = j2 - j;
                            j11 = currentTimeMillis - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = cH;
                    long j14 = j9;
                    j6 = currentTimeMillis2 - currentTimeMillis;
                    j5 = j14;
                }
                if (cVar2.pZ != 0 || cVar2.qa != cVar2.pY.length) {
                    if (cVar2.qa <= 0) {
                        cVar2.pY = null;
                    } else {
                        cVar2.pY = ByteBuffer.allocateDirect(cVar2.qa).put(cVar2.pY, cVar2.pZ, cVar2.qa).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.di().a(i2, cVar2.pY, socketMessage, this.ow, dh);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.ou != null && this.ot != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ou.cC());
                            socketResponsedMessage2.setRetry(this.ou.cL());
                            socketResponsedMessage2.performanceData.qD = j3;
                            socketResponsedMessage2.performanceData.qF = j4;
                            socketResponsedMessage2.performanceData.qG = j5;
                            socketResponsedMessage2.performanceData.qH = j7;
                            socketResponsedMessage2.performanceData.qK = j8;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.qJ = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.qI = j6;
                        socketResponsedMessage2.sequenceID = this.ot.pX.dg();
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.pY);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j15 = -100;
                    if (this.ou != null && this.ou.cH() != null) {
                        j15 = this.ou.cH().getClientLogID();
                    }
                    BdStatisticsManager.getInstance().error("im", j15, String.valueOf(this.ov), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ov));
                    k.a("unpacker", i, j15, this.ov, "unpacktask", j.po, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.pY);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ov != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.cH() == null ? -1L : eVar.cH().getClientLogID(), this.ov, "checkresponsedMessage", j.pp, "ack cont responsed");
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
        if (this.or != null) {
            boolean a2 = a(socketResponsedMessage, this.ou);
            b bVar = new b();
            bVar.ox = socketResponsedMessage;
            if (!a2) {
                bVar.oy = this.ou;
            }
            this.or.a(bVar);
        }
    }

    public static BdUniqueId cu() {
        return oq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage ox;
        e oy;

        b() {
        }
    }
}
