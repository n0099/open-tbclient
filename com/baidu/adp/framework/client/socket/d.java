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
    private static final BdUniqueId qc = BdUniqueId.gen();
    private a qd;
    private com.baidu.adp.framework.client.socket.coder.c qe;
    private e qf;
    private int qg;
    private SocketMessageTask qh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.qd = null;
        this.qe = null;
        this.qf = null;
        this.qg = 0;
        this.qh = null;
        this.qe = cVar;
        this.qf = eVar;
        this.qd = aVar;
        this.qg = i;
        try {
            if (this.qf != null) {
                this.qh = this.qf.cT();
            }
            if (this.qh == null) {
                this.qh = (SocketMessageTask) MessageManager.getInstance().findTask(this.qe.rI.m2do());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(qc);
        setPriority(4);
        if (this.qh != null) {
            setKey(String.valueOf(this.qh.getCmd()));
            setParallel(this.qh.getParallel());
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
        boolean dr;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.qe == null) {
            return null;
        }
        try {
            if (this.qf == null) {
                j2 = 0;
            } else {
                j2 = this.qf.qt;
            }
            if (this.qf == null) {
                j3 = 0;
            } else {
                j3 = this.qf.qu;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.qe.rI.m2do();
            dr = this.qe.rI.dr();
            i2 = this.qe.rL;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dt().a(this.qe);
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
            if (this.qf == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage cS = this.qf.cS();
                long startTime = cS.getStartTime();
                long cN = this.qf.cN();
                long j13 = cN - startTime;
                long j14 = currentTimeMillis - cN;
                if (j2 > 0) {
                    j9 = j2 - cN;
                    if (j3 >= j2) {
                        j14 = j3 - cN;
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
                socketMessage = cS;
            }
            byte[] bArr2 = null;
            if (cVar2.rK == 0 && cVar2.rL == cVar2.rJ.length) {
                bArr = null;
            } else if (cVar2.rL <= 0) {
                cVar2.rJ = null;
                bArr = null;
            } else {
                if (this.qe.rI.ds()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.rJ, cVar2.rK, com.baidu.adp.framework.client.socket.coder.a.rw).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.rw + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.rJ, cVar2.rK + com.baidu.adp.framework.client.socket.coder.a.rw, s).array();
                        cVar2.rK += i4;
                        cVar2.rL -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.qN);
                    }
                }
                cVar2.rJ = ByteBuffer.allocateDirect(cVar2.rL).put(cVar2.rJ, cVar2.rK, cVar2.rL).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dt().a(i3, cVar2.rJ, socketMessage, this.qh, dr);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.qN);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.qf != null && this.qe != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.qf.cN());
                        socketResponsedMessage2.setRetry(this.qf.cW());
                        socketResponsedMessage2.performanceData.sq = j5;
                        socketResponsedMessage2.performanceData.ss = j4;
                        socketResponsedMessage2.performanceData.su = j6;
                        socketResponsedMessage2.performanceData.sv = j7;
                        socketResponsedMessage2.performanceData.sy = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.sx = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.sw = j11;
                    socketResponsedMessage2.sequenceID = this.qe.rI.dq();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.rJ);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.qf != null && this.qf.cS() != null) {
                    j = this.qf.cS().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.qg), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.qg));
                i.a("unpacker", i, j, this.qg, "unpacktask", h.qW, "onBinaryMesssage decodebody error");
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
            if (this.qf != null) {
                j = this.qf.cS().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.qg), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.qg));
            i.a("unpacker", i, j, this.qg, "unpacktask", h.qW, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.rJ);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.qg != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.cS() == null ? -1L : eVar.cS().getClientLogID(), this.qg, "checkresponsedMessage", h.qX, "ack cont responsed");
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
        if (this.qd != null) {
            boolean a2 = a(socketResponsedMessage, this.qf);
            b bVar = new b();
            bVar.qi = socketResponsedMessage;
            if (!a2) {
                bVar.qj = this.qf;
            }
            this.qd.a(bVar);
        }
    }

    public static BdUniqueId cF() {
        return qc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage qi;
        e qj;

        b() {
        }
    }
}
