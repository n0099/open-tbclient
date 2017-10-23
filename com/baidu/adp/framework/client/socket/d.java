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
    private static final BdUniqueId nM = BdUniqueId.gen();
    private a nN;
    private com.baidu.adp.framework.client.socket.coder.c nO;
    private e nP;
    private int nQ;
    private SocketMessageTask nR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.nN = null;
        this.nO = null;
        this.nP = null;
        this.nQ = 0;
        this.nR = null;
        this.nO = cVar;
        this.nP = eVar;
        this.nN = aVar;
        this.nQ = i;
        try {
            if (this.nP != null) {
                this.nR = this.nP.cI();
            }
            if (this.nR == null) {
                this.nR = (SocketMessageTask) MessageManager.getInstance().findTask(this.nO.pB.de());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(nM);
        setPriority(4);
        if (this.nR != null) {
            setKey(String.valueOf(this.nR.getCmd()));
            setParallel(this.nR.getParallel());
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
        boolean dh;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.nO == null) {
            return null;
        }
        try {
            if (this.nP == null) {
                j2 = 0;
            } else {
                j2 = this.nP.od;
            }
            if (this.nP == null) {
                j3 = 0;
            } else {
                j3 = this.nP.oe;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.nO.pB.de();
            dh = this.nO.pB.dh();
            i2 = this.nO.pE;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(this.nO);
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
            if (this.nP == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage cH = this.nP.cH();
                long startTime = cH.getStartTime();
                long cC = this.nP.cC();
                long j13 = cC - startTime;
                long j14 = currentTimeMillis - cC;
                if (j2 > 0) {
                    j9 = j2 - cC;
                    if (j3 >= j2) {
                        j14 = j3 - cC;
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
                socketMessage = cH;
            }
            byte[] bArr2 = null;
            if (cVar2.pD == 0 && cVar2.pE == cVar2.pC.length) {
                bArr = null;
            } else if (cVar2.pE <= 0) {
                cVar2.pC = null;
                bArr = null;
            } else {
                if (this.nO.pB.di()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.pC, cVar2.pD, com.baidu.adp.framework.client.socket.coder.a.po).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.po + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.pC, cVar2.pD + com.baidu.adp.framework.client.socket.coder.a.po, s).array();
                        cVar2.pD += i4;
                        cVar2.pE -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.oB);
                    }
                }
                cVar2.pC = ByteBuffer.allocateDirect(cVar2.pE).put(cVar2.pC, cVar2.pD, cVar2.pE).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(i3, cVar2.pC, socketMessage, this.nR, dh);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.oB);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.nP != null && this.nO != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.nP.cC());
                        socketResponsedMessage2.setRetry(this.nP.cM());
                        socketResponsedMessage2.performanceData.qh = j5;
                        socketResponsedMessage2.performanceData.qj = j4;
                        socketResponsedMessage2.performanceData.qk = j6;
                        socketResponsedMessage2.performanceData.ql = j7;
                        socketResponsedMessage2.performanceData.qo = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.qn = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.qm = j11;
                    socketResponsedMessage2.sequenceID = this.nO.pB.dg();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.pC);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.nP != null && this.nP.cH() != null) {
                    j = this.nP.cH().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.nQ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.nQ));
                i.a("unpacker", i, j, this.nQ, "unpacktask", h.oK, "onBinaryMesssage decodebody error");
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
            if (this.nP != null) {
                j = this.nP.cH().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.nQ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.nQ));
            i.a("unpacker", i, j, this.nQ, "unpacktask", h.oK, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.pC);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.nQ != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.cH() == null ? -1L : eVar.cH().getClientLogID(), this.nQ, "checkresponsedMessage", h.oL, "ack cont responsed");
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
        if (this.nN != null) {
            boolean a2 = a(socketResponsedMessage, this.nP);
            b bVar = new b();
            bVar.nS = socketResponsedMessage;
            if (!a2) {
                bVar.nT = this.nP;
            }
            this.nN.a(bVar);
        }
    }

    public static BdUniqueId cu() {
        return nM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage nS;
        e nT;

        b() {
        }
    }
}
