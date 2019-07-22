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
    private static final BdUniqueId tM = BdUniqueId.gen();
    private a tN;
    private com.baidu.adp.framework.client.socket.coder.c tO;
    private e tP;
    private int tQ;
    private SocketMessageTask tR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.tN = null;
        this.tO = null;
        this.tP = null;
        this.tQ = 0;
        this.tR = null;
        this.tO = cVar;
        this.tP = eVar;
        this.tN = aVar;
        this.tQ = i;
        try {
            if (this.tP != null) {
                this.tR = this.tP.fC();
            }
            if (this.tR == null) {
                this.tR = (SocketMessageTask) MessageManager.getInstance().findTask(this.tO.vs.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(tM);
        setPriority(4);
        if (this.tR != null) {
            setKey(String.valueOf(this.tR.getCmd()));
            setParallel(this.tR.getParallel());
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
        boolean ga;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.tO == null) {
            return null;
        }
        try {
            if (this.tP == null) {
                j2 = 0;
            } else {
                j2 = this.tP.ud;
            }
            if (this.tP == null) {
                j3 = 0;
            } else {
                j3 = this.tP.ue;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.tO.vs.getCommand();
            ga = this.tO.vs.ga();
            i2 = this.tO.vv;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.gd().a(this.tO);
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
            if (this.tP == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage fB = this.tP.fB();
                long startTime = fB.getStartTime();
                long fw = this.tP.fw();
                long j13 = fw - startTime;
                long j14 = currentTimeMillis - fw;
                if (j2 > 0) {
                    j9 = j2 - fw;
                    if (j3 >= j2) {
                        j14 = j3 - fw;
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
                socketMessage = fB;
            }
            byte[] bArr2 = null;
            if (cVar2.vu == 0 && cVar2.vv == cVar2.vt.length) {
                bArr = null;
            } else if (cVar2.vv <= 0) {
                cVar2.vt = null;
                bArr = null;
            } else {
                if (this.tO.vs.gb()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.vt, cVar2.vu, com.baidu.adp.framework.client.socket.coder.a.vh).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.vh + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.vt, cVar2.vu + com.baidu.adp.framework.client.socket.coder.a.vh, s).array();
                        cVar2.vu += i4;
                        cVar2.vv -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.uz);
                    }
                }
                cVar2.vt = ByteBuffer.allocateDirect(cVar2.vv).put(cVar2.vt, cVar2.vu, cVar2.vv).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.gd().a(i3, cVar2.vt, socketMessage, this.tR, ga);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.uz);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.tP != null && this.tO != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.tP.fw());
                        socketResponsedMessage2.setRetry(this.tP.fG());
                        socketResponsedMessage2.performanceData.vW = j5;
                        socketResponsedMessage2.performanceData.vY = j4;
                        socketResponsedMessage2.performanceData.vZ = j6;
                        socketResponsedMessage2.performanceData.wa = j7;
                        socketResponsedMessage2.performanceData.we = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.wc = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.wb = j11;
                    socketResponsedMessage2.sequenceID = this.tO.vs.fZ();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.vt);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.tP != null && this.tP.fB() != null) {
                    j = this.tP.fB().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tQ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tQ));
                i.a("unpacker", i, j, this.tQ, "unpacktask", h.uI, "onBinaryMesssage decodebody error");
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
            if (this.tP != null) {
                j = this.tP.fB().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tQ), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tQ));
            i.a("unpacker", i, j, this.tQ, "unpacktask", h.uI, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.vt);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.tQ != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.fB() == null ? -1L : eVar.fB().getClientLogID(), this.tQ, "checkresponsedMessage", h.uJ, "ack cont responsed");
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
        if (this.tN != null) {
            boolean a2 = a(socketResponsedMessage, this.tP);
            b bVar = new b();
            bVar.tS = socketResponsedMessage;
            if (!a2) {
                bVar.tT = this.tP;
            }
            this.tN.a(bVar);
        }
    }

    public static BdUniqueId fn() {
        return tM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage tS;
        e tT;

        b() {
        }
    }
}
