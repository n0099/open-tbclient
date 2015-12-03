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
    private com.baidu.adp.framework.client.socket.coder.c ot;
    private e ou;
    private int ov;
    private SocketMessageTask ow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.or = null;
        this.ot = null;
        this.ou = null;
        this.ov = 0;
        this.ow = null;
        this.ot = cVar;
        this.ou = eVar;
        this.or = aVar;
        this.ov = i;
        try {
            if (this.ou != null) {
                this.ow = this.ou.el();
            }
            if (this.ow == null) {
                this.ow = (SocketMessageTask) MessageManager.getInstance().findTask(this.ot.pR.eH());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(oq);
        setPriority(4);
        if (this.ow != null) {
            setKey(String.valueOf(this.ow.getCmd()));
            setParallel(this.ow.getParallel());
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
        if (this.ot == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.ot.pR.eH();
            int i3 = this.ot.pU;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eK().a(this.ot);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                if (this.ou != null) {
                    socketMessage = this.ou.ek();
                    long startTime = socketMessage.getStartTime();
                    long ef = this.ou.ef();
                    j = ef - startTime;
                    j2 = currentTimeMillis - ef;
                    j3 = currentTimeMillis2 - currentTimeMillis;
                }
                if (cVar2.pT != 0 || cVar2.pU != cVar2.pS.length) {
                    if (cVar2.pU <= 0) {
                        cVar2.pS = null;
                    } else {
                        cVar2.pS = ByteBuffer.allocateDirect(cVar2.pU).put(cVar2.pS, cVar2.pT, cVar2.pU).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eK().a(i2, cVar2.pS, socketMessage, this.ow);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.ou != null && this.ot != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ou.ef());
                            socketResponsedMessage2.setRetry(this.ou.ep());
                            socketResponsedMessage2.performanceData.qx = j;
                            socketResponsedMessage2.performanceData.qz = j2;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.qB = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.qA = j3;
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.pS);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j4 = -100;
                    if (this.ou != null && this.ou.ek() != null) {
                        j4 = this.ou.ek().getClientLogID();
                    }
                    com.baidu.adp.lib.stats.a.hl().b("im", j4, String.valueOf(this.ov), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.ov));
                    k.a("unpacker", i, j4, this.ov, "unpacktask", j.pi, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.pS);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.ov != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.ek() == null ? -1L : eVar.ek().getClientLogID(), this.ov, "checkresponsedMessage", j.pj, "ack cont responsed");
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
            boolean a2 = a(socketResponsedMessage, this.ou);
            b bVar = new b();
            bVar.ox = socketResponsedMessage;
            if (!a2) {
                bVar.oy = this.ou;
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
        SocketResponsedMessage ox;
        e oy;

        b() {
        }
    }
}
