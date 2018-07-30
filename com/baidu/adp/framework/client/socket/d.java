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
    private static final BdUniqueId sQ = BdUniqueId.gen();
    private a sR;
    private com.baidu.adp.framework.client.socket.coder.c sS;
    private e sT;
    private int sU;
    private SocketMessageTask sV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.sR = null;
        this.sS = null;
        this.sT = null;
        this.sU = 0;
        this.sV = null;
        this.sS = cVar;
        this.sT = eVar;
        this.sR = aVar;
        this.sU = i;
        try {
            if (this.sT != null) {
                this.sV = this.sT.fe();
            }
            if (this.sV == null) {
                this.sV = (SocketMessageTask) MessageManager.getInstance().findTask(this.sS.uC.fA());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(sQ);
        setPriority(4);
        if (this.sV != null) {
            setKey(String.valueOf(this.sV.getCmd()));
            setParallel(this.sV.getParallel());
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
        boolean fD;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.sS == null) {
            return null;
        }
        try {
            if (this.sT == null) {
                j2 = 0;
            } else {
                j2 = this.sT.th;
            }
            if (this.sT == null) {
                j3 = 0;
            } else {
                j3 = this.sT.ti;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.sS.uC.fA();
            fD = this.sS.uC.fD();
            i2 = this.sS.uF;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.fF().a(this.sS);
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
            if (this.sT == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage fd = this.sT.fd();
                long startTime = fd.getStartTime();
                long eY = this.sT.eY();
                long j13 = eY - startTime;
                long j14 = currentTimeMillis - eY;
                if (j2 > 0) {
                    j9 = j2 - eY;
                    if (j3 >= j2) {
                        j14 = j3 - eY;
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
                socketMessage = fd;
            }
            byte[] bArr2 = null;
            if (cVar2.uE == 0 && cVar2.uF == cVar2.uD.length) {
                bArr = null;
            } else if (cVar2.uF <= 0) {
                cVar2.uD = null;
                bArr = null;
            } else {
                if (this.sS.uC.fE()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.uD, cVar2.uE, com.baidu.adp.framework.client.socket.coder.a.uq).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.uq + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.uD, cVar2.uE + com.baidu.adp.framework.client.socket.coder.a.uq, s).array();
                        cVar2.uE += i4;
                        cVar2.uF -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.tF);
                    }
                }
                cVar2.uD = ByteBuffer.allocateDirect(cVar2.uF).put(cVar2.uD, cVar2.uE, cVar2.uF).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.fF().a(i3, cVar2.uD, socketMessage, this.sV, fD);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.tF);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.sT != null && this.sS != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.sT.eY());
                        socketResponsedMessage2.setRetry(this.sT.fh());
                        socketResponsedMessage2.performanceData.vg = j5;
                        socketResponsedMessage2.performanceData.vi = j4;
                        socketResponsedMessage2.performanceData.vj = j6;
                        socketResponsedMessage2.performanceData.vk = j7;
                        socketResponsedMessage2.performanceData.vn = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.vm = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.vl = j11;
                    socketResponsedMessage2.sequenceID = this.sS.uC.fC();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.uD);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.sT != null && this.sT.fd() != null) {
                    j = this.sT.fd().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.sU), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.sU));
                i.a("unpacker", i, j, this.sU, "unpacktask", h.tO, "onBinaryMesssage decodebody error");
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
            if (this.sT != null) {
                j = this.sT.fd().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.sU), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.sU));
            i.a("unpacker", i, j, this.sU, "unpacktask", h.tO, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.uD);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.sU != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.fd() == null ? -1L : eVar.fd().getClientLogID(), this.sU, "checkresponsedMessage", h.tP, "ack cont responsed");
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
        if (this.sR != null) {
            boolean a2 = a(socketResponsedMessage, this.sT);
            b bVar = new b();
            bVar.sW = socketResponsedMessage;
            if (!a2) {
                bVar.sX = this.sT;
            }
            this.sR.a(bVar);
        }
    }

    public static BdUniqueId eQ() {
        return sQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage sW;
        e sX;

        b() {
        }
    }
}
