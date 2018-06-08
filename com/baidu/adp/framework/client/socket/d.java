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
    private static final BdUniqueId tb = BdUniqueId.gen();
    private a tc;
    private com.baidu.adp.framework.client.socket.coder.c td;
    private e te;
    private int tf;
    private SocketMessageTask tg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.tc = null;
        this.td = null;
        this.te = null;
        this.tf = 0;
        this.tg = null;
        this.td = cVar;
        this.te = eVar;
        this.tc = aVar;
        this.tf = i;
        try {
            if (this.te != null) {
                this.tg = this.te.ff();
            }
            if (this.tg == null) {
                this.tg = (SocketMessageTask) MessageManager.getInstance().findTask(this.td.uM.fB());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(tb);
        setPriority(4);
        if (this.tg != null) {
            setKey(String.valueOf(this.tg.getCmd()));
            setParallel(this.tg.getParallel());
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
        boolean fE;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.td == null) {
            return null;
        }
        try {
            if (this.te == null) {
                j2 = 0;
            } else {
                j2 = this.te.tt;
            }
            if (this.te == null) {
                j3 = 0;
            } else {
                j3 = this.te.tu;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.td.uM.fB();
            fE = this.td.uM.fE();
            i2 = this.td.uP;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.fG().a(this.td);
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
            if (this.te == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage fe = this.te.fe();
                long startTime = fe.getStartTime();
                long eZ = this.te.eZ();
                long j13 = eZ - startTime;
                long j14 = currentTimeMillis - eZ;
                if (j2 > 0) {
                    j9 = j2 - eZ;
                    if (j3 >= j2) {
                        j14 = j3 - eZ;
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
                socketMessage = fe;
            }
            byte[] bArr2 = null;
            if (cVar2.uO == 0 && cVar2.uP == cVar2.uN.length) {
                bArr = null;
            } else if (cVar2.uP <= 0) {
                cVar2.uN = null;
                bArr = null;
            } else {
                if (this.td.uM.fF()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.uN, cVar2.uO, com.baidu.adp.framework.client.socket.coder.a.uA).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.uA + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.uN, cVar2.uO + com.baidu.adp.framework.client.socket.coder.a.uA, s).array();
                        cVar2.uO += i4;
                        cVar2.uP -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.tP);
                    }
                }
                cVar2.uN = ByteBuffer.allocateDirect(cVar2.uP).put(cVar2.uN, cVar2.uO, cVar2.uP).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.fG().a(i3, cVar2.uN, socketMessage, this.tg, fE);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.tP);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.te != null && this.td != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.te.eZ());
                        socketResponsedMessage2.setRetry(this.te.fi());
                        socketResponsedMessage2.performanceData.vq = j5;
                        socketResponsedMessage2.performanceData.vs = j4;
                        socketResponsedMessage2.performanceData.vt = j6;
                        socketResponsedMessage2.performanceData.vu = j7;
                        socketResponsedMessage2.performanceData.vx = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.vw = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.vv = j11;
                    socketResponsedMessage2.sequenceID = this.td.uM.fD();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.uN);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.te != null && this.te.fe() != null) {
                    j = this.te.fe().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tf), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tf));
                i.a("unpacker", i, j, this.tf, "unpacktask", h.tY, "onBinaryMesssage decodebody error");
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
            if (this.te != null) {
                j = this.te.fe().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.tf), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.tf));
            i.a("unpacker", i, j, this.tf, "unpacktask", h.tY, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.uN);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.tf != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.fe() == null ? -1L : eVar.fe().getClientLogID(), this.tf, "checkresponsedMessage", h.tZ, "ack cont responsed");
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
        if (this.tc != null) {
            boolean a2 = a(socketResponsedMessage, this.te);
            b bVar = new b();
            bVar.th = socketResponsedMessage;
            if (!a2) {
                bVar.ti = this.te;
            }
            this.tc.a(bVar);
        }
    }

    public static BdUniqueId eR() {
        return tb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage th;
        e ti;

        b() {
        }
    }
}
