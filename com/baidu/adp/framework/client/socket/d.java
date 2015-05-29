package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId oq = BdUniqueId.gen();
    private e or;
    private com.baidu.adp.framework.client.socket.coder.c os;
    private g ot;
    private int ou;
    private SocketMessageTask ov;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.or = null;
        this.os = null;
        this.ot = null;
        this.ou = 0;
        this.ov = null;
        this.os = cVar;
        this.ot = gVar;
        this.or = eVar;
        this.ou = i;
        try {
            if (this.ot != null) {
                this.ov = this.ot.el();
            }
            if (this.ov == null) {
                this.ov = (SocketMessageTask) MessageManager.getInstance().findTask(this.os.pQ.eH());
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
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        long currentTimeMillis;
        long j;
        long j2;
        long j3;
        int i = 0;
        if (this.os == null) {
            return null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            i = this.os.pQ.eH();
            int i2 = this.os.pT;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eK().a(this.os);
            try {
                currentTimeMillis = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                j = 0;
                j2 = 0;
                j3 = 0;
                if (this.ot != null) {
                    socketMessage = this.ot.ek();
                    long startTime = socketMessage.getStartTime();
                    j = this.ot.ef() - startTime;
                    j2 = currentTimeMillis2 - startTime;
                    j3 = currentTimeMillis - currentTimeMillis2;
                }
                if (cVar2.pS != 0 || cVar2.pT != cVar2.pR.length) {
                    if (cVar2.pT <= 0) {
                        cVar2.pR = null;
                    } else {
                        cVar2.pR = ByteBuffer.allocateDirect(cVar2.pT).put(cVar2.pR, cVar2.pS, cVar2.pT).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eK().a(i, cVar2.pR, socketMessage, this.ov);
            } catch (CoderException e) {
                cVar = cVar2;
                socketResponsedMessage = null;
            }
            try {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (socketResponsedMessage2 != null) {
                    if (this.ot != null && this.os != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ot.ef());
                        socketResponsedMessage2.setRetry(this.ot.ep());
                        socketResponsedMessage2.performanceData.qx = j;
                        socketResponsedMessage2.performanceData.qz = j2;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.qB = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.qA = j3;
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.pR);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            } catch (CoderException e3) {
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                long j4 = -100;
                if (this.ot != null && this.ot.ek() != null) {
                    j4 = this.ot.ek().getClientLogID();
                }
                m.a("unpacker", i, j4, this.ou, "unpacktask", l.ph, "onBinaryMesssage decodebody error");
                cVar2 = cVar;
                socketResponsedMessage2 = socketResponsedMessage;
                publishProgress(socketResponsedMessage2);
                if (socketResponsedMessage2 != null) {
                }
                return null;
            }
        } catch (CoderException e4) {
            cVar = null;
            socketResponsedMessage = null;
        }
        publishProgress(socketResponsedMessage2);
        if (socketResponsedMessage2 != null) {
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.pR);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.ou != 0 && gVar != null && socketResponsedMessage == null) {
            m.a("unpacker", gVar.getCmd(), gVar.ek() == null ? -1L : gVar.ek().getClientLogID(), this.ou, "checkresponsedMessage", l.pi, "ack cont responsed");
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
            boolean a = a(socketResponsedMessage, this.ot);
            f fVar = new f();
            fVar.ow = socketResponsedMessage;
            if (!a) {
                fVar.ox = this.ot;
            }
            this.or.a(fVar);
        }
    }

    public static BdUniqueId dX() {
        return oq;
    }
}
