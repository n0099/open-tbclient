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
    private static final BdUniqueId tJ = BdUniqueId.gen();
    private a tK;
    private com.baidu.adp.framework.client.socket.coder.c tL;
    private e tM;
    private int tN;
    private SocketMessageTask tO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.tK = null;
        this.tL = null;
        this.tM = null;
        this.tN = 0;
        this.tO = null;
        this.tL = cVar;
        this.tM = eVar;
        this.tK = aVar;
        this.tN = i;
        try {
            if (this.tM != null) {
                this.tO = this.tM.fv();
            }
            if (this.tO == null) {
                this.tO = (SocketMessageTask) MessageManager.getInstance().findTask(this.tL.vp.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(tJ);
        setPriority(4);
        if (this.tO != null) {
            setKey(String.valueOf(this.tO.getCmd()));
            setParallel(this.tO.getParallel());
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
        boolean fS;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.tL == null) {
            return null;
        }
        try {
            if (this.tM == null) {
                j2 = 0;
            } else {
                j2 = this.tM.tZ;
            }
            if (this.tM == null) {
                j3 = 0;
            } else {
                j3 = this.tM.ub;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.tL.vp.getCommand();
            fS = this.tL.vp.fS();
            i2 = this.tL.vs;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.fU().a(this.tL);
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
            if (this.tM == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage fu = this.tM.fu();
                long startTime = fu.getStartTime();
                long fo = this.tM.fo();
                long j13 = fo - startTime;
                long j14 = currentTimeMillis - fo;
                if (j2 > 0) {
                    j9 = j2 - fo;
                    if (j3 >= j2) {
                        j14 = j3 - fo;
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
                socketMessage = fu;
            }
            byte[] bArr2 = null;
            if (cVar2.vr == 0 && cVar2.vs == cVar2.vq.length) {
                bArr = null;
            } else if (cVar2.vs <= 0) {
                cVar2.vq = null;
                bArr = null;
            } else {
                if (this.tL.vp.fT()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.vq, cVar2.vr, com.baidu.adp.framework.client.socket.coder.a.ve).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.ve + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.vq, cVar2.vr + com.baidu.adp.framework.client.socket.coder.a.ve, s).array();
                        cVar2.vr += i4;
                        cVar2.vs -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.uw);
                    }
                }
                cVar2.vq = ByteBuffer.allocateDirect(cVar2.vs).put(cVar2.vq, cVar2.vr, cVar2.vs).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.fU().a(i3, cVar2.vq, socketMessage, this.tO, fS);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.uw);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.tM != null && this.tL != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.tM.fo());
                        socketResponsedMessage2.setRetry(this.tM.fy());
                        socketResponsedMessage2.performanceData.vT = j5;
                        socketResponsedMessage2.performanceData.vV = j4;
                        socketResponsedMessage2.performanceData.vW = j6;
                        socketResponsedMessage2.performanceData.vX = j7;
                        socketResponsedMessage2.performanceData.wa = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.vZ = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.vY = j11;
                    socketResponsedMessage2.sequenceID = this.tL.vp.fR();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.vq);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.tM != null && this.tM.fu() != null) {
                    j = this.tM.fu().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tN), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tN));
                i.a("unpacker", i, j, this.tN, "unpacktask", h.uF, "onBinaryMesssage decodebody error");
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
            if (this.tM != null) {
                j = this.tM.fu().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tN), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tN));
            i.a("unpacker", i, j, this.tN, "unpacktask", h.uF, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.vq);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.tN != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.fu() == null ? -1L : eVar.fu().getClientLogID(), this.tN, "checkresponsedMessage", h.uG, "ack cont responsed");
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
        if (this.tK != null) {
            boolean a2 = a(socketResponsedMessage, this.tM);
            b bVar = new b();
            bVar.tP = socketResponsedMessage;
            if (!a2) {
                bVar.tQ = this.tM;
            }
            this.tK.a(bVar);
        }
    }

    public static BdUniqueId fg() {
        return tJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage tP;
        e tQ;

        b() {
        }
    }
}
