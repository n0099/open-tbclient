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
    private static final BdUniqueId qd = BdUniqueId.gen();
    private a qe;
    private com.baidu.adp.framework.client.socket.coder.c qf;
    private e qg;
    private int qh;
    private SocketMessageTask qi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.qe = null;
        this.qf = null;
        this.qg = null;
        this.qh = 0;
        this.qi = null;
        this.qf = cVar;
        this.qg = eVar;
        this.qe = aVar;
        this.qh = i;
        try {
            if (this.qg != null) {
                this.qi = this.qg.cT();
            }
            if (this.qi == null) {
                this.qi = (SocketMessageTask) MessageManager.getInstance().findTask(this.qf.rJ.m2do());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(qd);
        setPriority(4);
        if (this.qi != null) {
            setKey(String.valueOf(this.qi.getCmd()));
            setParallel(this.qi.getParallel());
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
        if (this.qf == null) {
            return null;
        }
        try {
            if (this.qg == null) {
                j2 = 0;
            } else {
                j2 = this.qg.qu;
            }
            if (this.qg == null) {
                j3 = 0;
            } else {
                j3 = this.qg.qv;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.qf.rJ.m2do();
            dr = this.qf.rJ.dr();
            i2 = this.qf.rM;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dt().a(this.qf);
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
            if (this.qg == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage cS = this.qg.cS();
                long startTime = cS.getStartTime();
                long cN = this.qg.cN();
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
            if (cVar2.rL == 0 && cVar2.rM == cVar2.rK.length) {
                bArr = null;
            } else if (cVar2.rM <= 0) {
                cVar2.rK = null;
                bArr = null;
            } else {
                if (this.qf.rJ.ds()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.rK, cVar2.rL, com.baidu.adp.framework.client.socket.coder.a.rx).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.rx + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.rK, cVar2.rL + com.baidu.adp.framework.client.socket.coder.a.rx, s).array();
                        cVar2.rL += i4;
                        cVar2.rM -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.qO);
                    }
                }
                cVar2.rK = ByteBuffer.allocateDirect(cVar2.rM).put(cVar2.rK, cVar2.rL, cVar2.rM).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dt().a(i3, cVar2.rK, socketMessage, this.qi, dr);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.qO);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.qg != null && this.qf != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.qg.cN());
                        socketResponsedMessage2.setRetry(this.qg.cW());
                        socketResponsedMessage2.performanceData.sr = j5;
                        socketResponsedMessage2.performanceData.su = j4;
                        socketResponsedMessage2.performanceData.sv = j6;
                        socketResponsedMessage2.performanceData.sw = j7;
                        socketResponsedMessage2.performanceData.sz = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.sy = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.sx = j11;
                    socketResponsedMessage2.sequenceID = this.qf.rJ.dq();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.rK);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.qg != null && this.qg.cS() != null) {
                    j = this.qg.cS().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.qh), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.qh));
                i.a("unpacker", i, j, this.qh, "unpacktask", h.qX, "onBinaryMesssage decodebody error");
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
            if (this.qg != null) {
                j = this.qg.cS().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.qh), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.qh));
            i.a("unpacker", i, j, this.qh, "unpacktask", h.qX, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.rK);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.qh != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.cS() == null ? -1L : eVar.cS().getClientLogID(), this.qh, "checkresponsedMessage", h.qY, "ack cont responsed");
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
        if (this.qe != null) {
            boolean a2 = a(socketResponsedMessage, this.qg);
            b bVar = new b();
            bVar.qj = socketResponsedMessage;
            if (!a2) {
                bVar.qk = this.qg;
            }
            this.qe.a(bVar);
        }
    }

    public static BdUniqueId cF() {
        return qd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage qj;
        e qk;

        b() {
        }
    }
}
