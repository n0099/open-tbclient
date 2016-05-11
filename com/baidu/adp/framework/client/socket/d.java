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
    private static final BdUniqueId el = BdUniqueId.gen();
    private a em;
    private com.baidu.adp.framework.client.socket.coder.c en;
    private e eo;
    private int ep;
    private SocketMessageTask eq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.em = null;
        this.en = null;
        this.eo = null;
        this.ep = 0;
        this.eq = null;
        this.en = cVar;
        this.eo = eVar;
        this.em = aVar;
        this.ep = i;
        try {
            if (this.eo != null) {
                this.eq = this.eo.aF();
            }
            if (this.eq == null) {
                this.eq = (SocketMessageTask) MessageManager.getInstance().findTask(this.en.fM.bb());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(el);
        setPriority(4);
        if (this.eq != null) {
            setKey(String.valueOf(this.eq.getCmd()));
            setParallel(this.eq.getParallel());
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
        if (this.en == null) {
            return null;
        }
        try {
            if (this.eo == null) {
                j = 0;
            } else {
                j = this.eo.eD;
            }
            if (this.eo == null) {
                j2 = 0;
            } else {
                j2 = this.eo.eE;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            i3 = this.en.fM.bb();
            boolean be = this.en.fM.be();
            i2 = this.en.fP;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.bf().a(this.en);
            try {
                currentTimeMillis = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.eo == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage aE = this.eo.aE();
                    long startTime = aE.getStartTime();
                    long az = this.eo.az();
                    long j12 = az - startTime;
                    long j13 = currentTimeMillis2 - az;
                    if (j > 0) {
                        j9 = j - az;
                        if (j2 >= j) {
                            j13 = j2 - az;
                            j10 = j2 - j;
                            j11 = currentTimeMillis2 - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = aE;
                    long j14 = j9;
                    j6 = currentTimeMillis - currentTimeMillis2;
                    j5 = j14;
                }
                if (cVar2.fO != 0 || cVar2.fP != cVar2.fN.length) {
                    if (cVar2.fP <= 0) {
                        cVar2.fN = null;
                    } else {
                        cVar2.fN = ByteBuffer.allocateDirect(cVar2.fP).put(cVar2.fN, cVar2.fO, cVar2.fP).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.bf().a(i3, cVar2.fN, socketMessage, this.eq, be);
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
                if (this.eo != null && this.en != null) {
                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.eo.az());
                    socketResponsedMessage2.setRetry(this.eo.aJ());
                    socketResponsedMessage2.performanceData.gv = j3;
                    socketResponsedMessage2.performanceData.gx = j4;
                    socketResponsedMessage2.performanceData.gy = j5;
                    socketResponsedMessage2.performanceData.gz = j7;
                    socketResponsedMessage2.performanceData.gC = j8;
                }
                socketResponsedMessage2.setDownSize(i2);
                socketResponsedMessage2.performanceData.gB = currentTimeMillis3;
                socketResponsedMessage2.performanceData.gA = j6;
                socketResponsedMessage2.sequenceID = this.en.fM.bd();
                try {
                    socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.fN);
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
            }
        } catch (CoderException e4) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = socketResponsedMessage2;
            long j15 = -100;
            if (this.eo != null && this.eo.aE() != null) {
                j15 = this.eo.aE().getClientLogID();
            }
            com.baidu.adp.lib.stats.a.dN().b("im", j15, String.valueOf(this.ep), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ep));
            k.a("unpacker", i, j15, this.ep, "unpacktask", j.fe, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.fN);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ep != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.aE() == null ? -1L : eVar.aE().getClientLogID(), this.ep, "checkresponsedMessage", j.ff, "ack cont responsed");
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
        if (this.em != null) {
            boolean a2 = a(socketResponsedMessage, this.eo);
            b bVar = new b();
            bVar.er = socketResponsedMessage;
            if (!a2) {
                bVar.es = this.eo;
            }
            this.em.a(bVar);
        }
    }

    public static BdUniqueId ar() {
        return el;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage er;
        e es;

        b() {
        }
    }
}
