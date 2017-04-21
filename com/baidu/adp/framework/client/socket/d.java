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
                this.ow = (SocketMessageTask) MessageManager.getInstance().findTask(this.ot.qc.de());
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
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        long currentTimeMillis;
        boolean dh;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        long j9;
        byte[] bArr;
        int i3 = 0;
        if (this.ot == null) {
            return null;
        }
        try {
            if (this.ou == null) {
                j2 = 0;
            } else {
                j2 = this.ou.oI;
            }
            if (this.ou == null) {
                j3 = 0;
            } else {
                j3 = this.ou.oJ;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.ot.qc.de();
            dh = this.ot.qc.dh();
            i2 = this.ot.qf;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(this.ot);
        } catch (CoderException e) {
            i = i3;
            cVar = null;
            socketResponsedMessage = null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            if (this.ou == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
                j9 = 0;
            } else {
                SocketMessage cH = this.ou.cH();
                long startTime = cH.getStartTime();
                long cC = this.ou.cC();
                long j13 = cC - startTime;
                long j14 = currentTimeMillis - cC;
                if (j2 > 0) {
                    j10 = j2 - cC;
                    if (j3 >= j2) {
                        j14 = j3 - cC;
                        j11 = j3 - j2;
                        j12 = currentTimeMillis - j3;
                    }
                }
                j4 = j14;
                j5 = j13;
                j7 = j10;
                j9 = currentTimeMillis2 - currentTimeMillis;
                j6 = j11;
                j8 = j12;
                socketMessage = cH;
            }
            byte[] bArr2 = null;
            if (cVar2.qe == 0 && cVar2.qf == cVar2.qd.length) {
                bArr = null;
            } else if (cVar2.qf <= 0) {
                cVar2.qd = null;
                bArr = null;
            } else {
                if (this.ot.qc.di()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.qd, cVar2.qe, com.baidu.adp.framework.client.socket.coder.a.pQ).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.pQ + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.qd, cVar2.qe + com.baidu.adp.framework.client.socket.coder.a.pQ, s).array();
                        cVar2.qe += i4;
                        cVar2.qf -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(j.pe);
                    }
                }
                cVar2.qd = ByteBuffer.allocateDirect(cVar2.qf).put(cVar2.qd, cVar2.qe, cVar2.qf).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(i3, cVar2.qd, socketMessage, this.ow, dh);
            if (socketResponsedMessage2 != null && bArr != null) {
                try {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(j.pe);
                    }
                } catch (CoderException e4) {
                    i = i3;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    j = -100;
                    if (this.ou != null && this.ou.cH() != null) {
                        j = this.ou.cH().getClientLogID();
                    }
                    BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.ov), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ov));
                    k.a("unpacker", i, j, this.ov, "unpacktask", j.pq, "onBinaryMesssage decodebody error");
                    i3 = i;
                    cVar2 = cVar;
                    socketResponsedMessage2 = socketResponsedMessage;
                    if (socketResponsedMessage2 != null) {
                    }
                    publishProgress(socketResponsedMessage2);
                    if (socketResponsedMessage2 != null) {
                    }
                    return null;
                }
            }
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (socketResponsedMessage2 != null) {
                if (this.ou != null && this.ot != null) {
                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ou.cC());
                    socketResponsedMessage2.setRetry(this.ou.cL());
                    socketResponsedMessage2.performanceData.qI = j5;
                    socketResponsedMessage2.performanceData.qK = j4;
                    socketResponsedMessage2.performanceData.qL = j7;
                    socketResponsedMessage2.performanceData.qM = j6;
                    socketResponsedMessage2.performanceData.qP = j8;
                }
                socketResponsedMessage2.setDownSize(i2);
                socketResponsedMessage2.performanceData.qO = currentTimeMillis3;
                socketResponsedMessage2.performanceData.qN = j9;
                socketResponsedMessage2.sequenceID = this.ot.qc.dg();
                try {
                    socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.qd);
                } catch (Exception e5) {
                    BdLog.e(e5.getMessage());
                }
            }
        } catch (CoderException e6) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = null;
            j = -100;
            if (this.ou != null) {
                j = this.ou.cH().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.ov), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ov));
            k.a("unpacker", i, j, this.ov, "unpacktask", j.pq, "onBinaryMesssage decodebody error");
            i3 = i;
            cVar2 = cVar;
            socketResponsedMessage2 = socketResponsedMessage;
            if (socketResponsedMessage2 != null) {
            }
            publishProgress(socketResponsedMessage2);
            if (socketResponsedMessage2 != null) {
            }
            return null;
        }
        if (socketResponsedMessage2 != null) {
            socketResponsedMessage2.setStartTime(System.currentTimeMillis());
        }
        publishProgress(socketResponsedMessage2);
        if (socketResponsedMessage2 != null) {
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.qd);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ov != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.cH() == null ? -1L : eVar.cH().getClientLogID(), this.ov, "checkresponsedMessage", j.pr, "ack cont responsed");
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
