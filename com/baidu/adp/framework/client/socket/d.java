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
    private static final BdUniqueId mF = BdUniqueId.gen();
    private a mG;
    private com.baidu.adp.framework.client.socket.coder.c mH;
    private e mI;
    private int mJ;
    private SocketMessageTask mK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.mG = null;
        this.mH = null;
        this.mI = null;
        this.mJ = 0;
        this.mK = null;
        this.mH = cVar;
        this.mI = eVar;
        this.mG = aVar;
        this.mJ = i;
        try {
            if (this.mI != null) {
                this.mK = this.mI.cr();
            }
            if (this.mK == null) {
                this.mK = (SocketMessageTask) MessageManager.getInstance().findTask(this.mH.oq.cM());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(mF);
        setPriority(4);
        if (this.mK != null) {
            setKey(String.valueOf(this.mK.getCmd()));
            setParallel(this.mK.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        long j;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        long j2;
        long j3;
        long currentTimeMillis;
        boolean cP;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.mH == null) {
            return null;
        }
        try {
            if (this.mI == null) {
                j2 = 0;
            } else {
                j2 = this.mI.mW;
            }
            if (this.mI == null) {
                j3 = 0;
            } else {
                j3 = this.mI.mZ;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.mH.oq.cM();
            cP = this.mH.oq.cP();
            i2 = this.mH.ou;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.cR().a(this.mH);
        } catch (CoderException e) {
            i = i3;
            cVar = null;
            socketResponsedMessage = null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            if (this.mI == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage cq = this.mI.cq();
                long startTime = cq.getStartTime();
                long cl = this.mI.cl();
                long j13 = cl - startTime;
                long j14 = currentTimeMillis - cl;
                if (j2 > 0) {
                    j9 = j2 - cl;
                    if (j3 >= j2) {
                        j14 = j3 - cl;
                        j10 = j3 - j2;
                        j12 = currentTimeMillis - j3;
                    }
                }
                j4 = j14;
                j5 = j13;
                j6 = j9;
                j11 = currentTimeMillis2 - currentTimeMillis;
                j8 = j12;
                j7 = j10;
                socketMessage = cq;
            }
            byte[] bArr2 = null;
            if (cVar2.ot == 0 && cVar2.ou == cVar2.or.length) {
                bArr = null;
            } else if (cVar2.ou <= 0) {
                cVar2.or = null;
                bArr = null;
            } else {
                if (this.mH.oq.cQ()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.or, cVar2.ot, com.baidu.adp.framework.client.socket.coder.a.ob).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.ob + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.or, cVar2.ot + com.baidu.adp.framework.client.socket.coder.a.ob, s).array();
                        cVar2.ot += i4;
                        cVar2.ou -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.nt);
                    }
                }
                cVar2.or = ByteBuffer.allocateDirect(cVar2.ou).put(cVar2.or, cVar2.ot, cVar2.ou).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.cR().a(i3, cVar2.or, socketMessage, this.mK, cP);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.nt);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.mI != null && this.mH != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.mI.cl());
                        socketResponsedMessage2.setRetry(this.mI.cu());
                        socketResponsedMessage2.performanceData.oV = j5;
                        socketResponsedMessage2.performanceData.oX = j4;
                        socketResponsedMessage2.performanceData.oY = j6;
                        socketResponsedMessage2.performanceData.oZ = j7;
                        socketResponsedMessage2.performanceData.pe = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.pd = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.pa = j11;
                    socketResponsedMessage2.sequenceID = this.mH.oq.cO();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.or);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.mI != null && this.mI.cq() != null) {
                    j = this.mI.cq().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mJ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.mJ));
                i.a("unpacker", i, j, this.mJ, "unpacktask", h.nC, "onBinaryMesssage decodebody error");
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
        } catch (CoderException e6) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = null;
            j = -100;
            if (this.mI != null) {
                j = this.mI.cq().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mJ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.mJ));
            i.a("unpacker", i, j, this.mJ, "unpacktask", h.nC, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.or);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.mJ != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.cq() == null ? -1L : eVar.cq().getClientLogID(), this.mJ, "checkresponsedMessage", h.nD, "ack cont responsed");
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
        if (this.mG != null) {
            boolean a2 = a(socketResponsedMessage, this.mI);
            b bVar = new b();
            bVar.mL = socketResponsedMessage;
            if (!a2) {
                bVar.mM = this.mI;
            }
            this.mG.a(bVar);
        }
    }

    public static BdUniqueId cd() {
        return mF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage mL;
        e mM;

        b() {
        }
    }
}
