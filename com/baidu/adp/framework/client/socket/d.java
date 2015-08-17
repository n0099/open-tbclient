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
    private static final BdUniqueId oq = BdUniqueId.gen();
    private a or;
    private com.baidu.adp.framework.client.socket.coder.c os;
    private e ot;
    private int ou;
    private SocketMessageTask ov;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.or = null;
        this.os = null;
        this.ot = null;
        this.ou = 0;
        this.ov = null;
        this.os = cVar;
        this.ot = eVar;
        this.or = aVar;
        this.ou = i;
        try {
            if (this.ot != null) {
                this.ov = this.ot.em();
            }
            if (this.ov == null) {
                this.ov = (SocketMessageTask) MessageManager.getInstance().findTask(this.os.pQ.eI());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(oq);
        setPriority(4);
        if (this.ov != null) {
            setKey(String.valueOf(this.ov.getCmd()));
            setParallel(this.ov.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        int i2 = 0;
        if (this.os == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.os.pQ.eI();
            int i3 = this.os.pT;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eL().a(this.os);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                if (this.ot != null) {
                    socketMessage = this.ot.el();
                    long startTime = socketMessage.getStartTime();
                    j = this.ot.eg() - startTime;
                    j2 = currentTimeMillis - startTime;
                    j3 = currentTimeMillis2 - currentTimeMillis;
                }
                if (cVar2.pS != 0 || cVar2.pT != cVar2.pR.length) {
                    if (cVar2.pT <= 0) {
                        cVar2.pR = null;
                    } else {
                        cVar2.pR = ByteBuffer.allocateDirect(cVar2.pT).put(cVar2.pR, cVar2.pS, cVar2.pT).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eL().a(i2, cVar2.pR, socketMessage, this.ov);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.ot != null && this.os != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ot.eg());
                            socketResponsedMessage2.setRetry(this.ot.eq());
                            socketResponsedMessage2.performanceData.qy = j;
                            socketResponsedMessage2.performanceData.qA = j2;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.qC = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.qB = j3;
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.pR);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j4 = -100;
                    if (this.ot != null && this.ot.el() != null) {
                        j4 = this.ot.el().getClientLogID();
                    }
                    com.baidu.adp.lib.stats.a.hk().b("im", j4, String.valueOf(this.ou), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ou));
                    k.a("unpacker", i, j4, this.ou, "unpacktask", j.ph, "onBinaryMesssage decodebody error");
                    i2 = i;
                    cVar2 = cVar;
                    socketResponsedMessage2 = socketResponsedMessage;
                    publishProgress(socketResponsedMessage2);
                    if (socketResponsedMessage2 != null) {
                    }
                    return null;
                }
            } catch (CoderException e3) {
                i = i2;
                cVar = cVar2;
                socketResponsedMessage = null;
            }
        } catch (CoderException e4) {
            i = i2;
            cVar = null;
            socketResponsedMessage = null;
        }
        publishProgress(socketResponsedMessage2);
        if (socketResponsedMessage2 != null) {
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.pR);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ou != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.el() == null ? -1L : eVar.el().getClientLogID(), this.ou, "checkresponsedMessage", j.pi, "ack cont responsed");
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
        if (this.or != null) {
            boolean a2 = a(socketResponsedMessage, this.ot);
            b bVar = new b();
            bVar.ow = socketResponsedMessage;
            if (!a2) {
                bVar.ox = this.ot;
            }
            this.or.a(bVar);
        }
    }

    public static BdUniqueId dY() {
        return oq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage ow;
        e ox;

        b() {
        }
    }
}
