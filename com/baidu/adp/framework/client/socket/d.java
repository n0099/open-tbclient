package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId ou = BdUniqueId.gen();
    private a ov;
    private com.baidu.adp.framework.client.socket.coder.c ow;
    private e ox;
    private int oy;
    private SocketMessageTask oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.ov = null;
        this.ow = null;
        this.ox = null;
        this.oy = 0;
        this.oz = null;
        this.ow = cVar;
        this.ox = eVar;
        this.ov = aVar;
        this.oy = i;
        try {
            if (this.ox != null) {
                this.oz = this.ox.ep();
            }
            if (this.oz == null) {
                this.oz = (SocketMessageTask) MessageManager.getInstance().findTask(this.ow.pY.eL());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(ou);
        setPriority(4);
        if (this.oz != null) {
            setKey(String.valueOf(this.oz.getCmd()));
            setParallel(this.oz.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        int i2;
        long currentTimeMillis;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        int i3 = 0;
        if (this.ow == null) {
            return null;
        }
        try {
            if (this.ox == null) {
                j = 0;
            } else {
                j = this.ox.oL;
            }
            if (this.ox == null) {
                j2 = 0;
            } else {
                j2 = this.ox.oM;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            i3 = this.ow.pY.eL();
            boolean eO = this.ow.pY.eO();
            i2 = this.ow.qb;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eP().a(this.ow);
            try {
                currentTimeMillis = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.ox == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage eo = this.ox.eo();
                    long startTime = eo.getStartTime();
                    long ej = this.ox.ej();
                    long j12 = ej - startTime;
                    long j13 = currentTimeMillis2 - ej;
                    if (j > 0) {
                        j9 = j - ej;
                        if (j2 >= j) {
                            j13 = j2 - ej;
                            j10 = j2 - j;
                            j11 = currentTimeMillis2 - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = eo;
                    long j14 = j9;
                    j6 = currentTimeMillis - currentTimeMillis2;
                    j5 = j14;
                }
                if (cVar2.qa != 0 || cVar2.qb != cVar2.pZ.length) {
                    if (cVar2.qb <= 0) {
                        cVar2.pZ = null;
                    } else {
                        cVar2.pZ = ByteBuffer.allocateDirect(cVar2.qb).put(cVar2.pZ, cVar2.qa, cVar2.qb).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eP().a(i3, cVar2.pZ, socketMessage, this.oz, eO);
            } catch (CoderException e) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = null;
            }
        } catch (CoderException e2) {
            i = i3;
            cVar = null;
            socketResponsedMessage = null;
        }
        try {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (socketResponsedMessage2 != null) {
                if (this.ox != null && this.ow != null) {
                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ox.ej());
                    socketResponsedMessage2.setRetry(this.ox.et());
                    socketResponsedMessage2.performanceData.qH = j3;
                    socketResponsedMessage2.performanceData.qJ = j4;
                    socketResponsedMessage2.performanceData.qK = j5;
                    socketResponsedMessage2.performanceData.qL = j7;
                    socketResponsedMessage2.performanceData.qO = j8;
                }
                socketResponsedMessage2.setDownSize(i2);
                socketResponsedMessage2.performanceData.qN = currentTimeMillis3;
                socketResponsedMessage2.performanceData.qM = j6;
                socketResponsedMessage2.sequenceID = this.ow.pY.eN();
                try {
                    socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.pZ);
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
            }
        } catch (CoderException e4) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = socketResponsedMessage2;
            long j15 = -100;
            if (this.ox != null && this.ox.eo() != null) {
                j15 = this.ox.eo().getClientLogID();
            }
            com.baidu.adp.lib.stats.a.hz().b("im", j15, String.valueOf(this.oy), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.oy));
            k.a("unpacker", i, j15, this.oy, "unpacktask", j.pq, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.pZ);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.oy != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.eo() == null ? -1L : eVar.eo().getClientLogID(), this.oy, "checkresponsedMessage", j.pr, "ack cont responsed");
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
        if (this.ov != null) {
            boolean a2 = a(socketResponsedMessage, this.ox);
            b bVar = new b();
            bVar.oA = socketResponsedMessage;
            if (!a2) {
                bVar.oB = this.ox;
            }
            this.ov.a(bVar);
        }
    }

    public static BdUniqueId eb() {
        return ou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage oA;
        e oB;

        b() {
        }
    }
}
