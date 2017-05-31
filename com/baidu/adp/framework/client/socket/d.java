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
    private static final BdUniqueId or = BdUniqueId.gen();
    private a ot;
    private com.baidu.adp.framework.client.socket.coder.c ou;
    private e ov;
    private int ow;
    private SocketMessageTask ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.ot = null;
        this.ou = null;
        this.ov = null;
        this.ow = 0;
        this.ox = null;
        this.ou = cVar;
        this.ov = eVar;
        this.ot = aVar;
        this.ow = i;
        try {
            if (this.ov != null) {
                this.ox = this.ov.cI();
            }
            if (this.ox == null) {
                this.ox = (SocketMessageTask) MessageManager.getInstance().findTask(this.ou.qd.de());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(or);
        setPriority(4);
        if (this.ox != null) {
            setKey(String.valueOf(this.ox.getCmd()));
            setParallel(this.ox.getParallel());
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
        if (this.ou == null) {
            return null;
        }
        try {
            if (this.ov == null) {
                j2 = 0;
            } else {
                j2 = this.ov.oJ;
            }
            if (this.ov == null) {
                j3 = 0;
            } else {
                j3 = this.ov.oK;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.ou.qd.de();
            dh = this.ou.qd.dh();
            i2 = this.ou.qg;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(this.ou);
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
            if (this.ov == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
                j9 = 0;
            } else {
                SocketMessage cH = this.ov.cH();
                long startTime = cH.getStartTime();
                long cC = this.ov.cC();
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
            if (cVar2.qf == 0 && cVar2.qg == cVar2.qe.length) {
                bArr = null;
            } else if (cVar2.qg <= 0) {
                cVar2.qe = null;
                bArr = null;
            } else {
                if (this.ou.qd.di()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.qe, cVar2.qf, com.baidu.adp.framework.client.socket.coder.a.pR).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.pR + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.qe, cVar2.qf + com.baidu.adp.framework.client.socket.coder.a.pR, s).array();
                        cVar2.qf += i4;
                        cVar2.qg -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(j.pf);
                    }
                }
                cVar2.qe = ByteBuffer.allocateDirect(cVar2.qg).put(cVar2.qe, cVar2.qf, cVar2.qg).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.dj().a(i3, cVar2.qe, socketMessage, this.ox, dh);
            if (socketResponsedMessage2 != null && bArr != null) {
                try {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(j.pf);
                    }
                } catch (CoderException e4) {
                    i = i3;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    j = -100;
                    if (this.ov != null && this.ov.cH() != null) {
                        j = this.ov.cH().getClientLogID();
                    }
                    BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.ow), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ow));
                    k.a("unpacker", i, j, this.ow, "unpacktask", j.pr, "onBinaryMesssage decodebody error");
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
                if (this.ov != null && this.ou != null) {
                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ov.cC());
                    socketResponsedMessage2.setRetry(this.ov.cL());
                    socketResponsedMessage2.performanceData.qJ = j5;
                    socketResponsedMessage2.performanceData.qL = j4;
                    socketResponsedMessage2.performanceData.qM = j7;
                    socketResponsedMessage2.performanceData.qN = j6;
                    socketResponsedMessage2.performanceData.qQ = j8;
                }
                socketResponsedMessage2.setDownSize(i2);
                socketResponsedMessage2.performanceData.qP = currentTimeMillis3;
                socketResponsedMessage2.performanceData.qO = j9;
                socketResponsedMessage2.sequenceID = this.ou.qd.dg();
                try {
                    socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.qe);
                } catch (Exception e5) {
                    BdLog.e(e5.getMessage());
                }
            }
        } catch (CoderException e6) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = null;
            j = -100;
            if (this.ov != null) {
                j = this.ov.cH().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.ow), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ow));
            k.a("unpacker", i, j, this.ow, "unpacktask", j.pr, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.qe);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ow != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.cH() == null ? -1L : eVar.cH().getClientLogID(), this.ow, "checkresponsedMessage", j.pt, "ack cont responsed");
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
        if (this.ot != null) {
            boolean a2 = a(socketResponsedMessage, this.ov);
            b bVar = new b();
            bVar.oy = socketResponsedMessage;
            if (!a2) {
                bVar.oz = this.ov;
            }
            this.ot.a(bVar);
        }
    }

    public static BdUniqueId cu() {
        return or;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage oy;
        e oz;

        b() {
        }
    }
}
