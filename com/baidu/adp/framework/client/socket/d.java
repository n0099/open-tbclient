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
    private static final BdUniqueId oi = BdUniqueId.gen();
    private e oj;
    private com.baidu.adp.framework.client.socket.coder.c ol;
    private g om;
    private int oo;
    private SocketMessageTask oq;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.oj = null;
        this.ol = null;
        this.om = null;
        this.oo = 0;
        this.oq = null;
        this.ol = cVar;
        this.om = gVar;
        this.oj = eVar;
        this.oo = i;
        try {
            if (this.om != null) {
                this.oq = this.om.ei();
            }
            if (this.oq == null) {
                this.oq = (SocketMessageTask) MessageManager.getInstance().findTask(this.ol.pL.eE());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(oi);
        setPriority(4);
        if (this.oq != null) {
            setKey(String.valueOf(this.oq.getCmd()));
            setParallel(this.oq.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        if (this.ol == null) {
            return null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            i = this.ol.pL.eE();
            int i2 = this.ol.pO;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eH().a(this.ol);
            try {
                currentTimeMillis = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                j = 0;
                j2 = 0;
                j3 = 0;
                if (this.om != null) {
                    socketMessage = this.om.eh();
                    long startTime = socketMessage.getStartTime();
                    j = this.om.ec() - startTime;
                    j2 = currentTimeMillis2 - startTime;
                    j3 = currentTimeMillis - currentTimeMillis2;
                }
                if (cVar2.pN != 0 || cVar2.pO != cVar2.pM.length) {
                    if (cVar2.pO <= 0) {
                        cVar2.pM = null;
                    } else {
                        cVar2.pM = ByteBuffer.allocateDirect(cVar2.pO).put(cVar2.pM, cVar2.pN, cVar2.pO).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eH().a(i, cVar2.pM, socketMessage, this.oq);
            } catch (CoderException e) {
                cVar = cVar2;
                socketResponsedMessage = null;
            }
            try {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (socketResponsedMessage2 != null) {
                    if (this.om != null && this.ol != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.om.ec());
                        socketResponsedMessage2.setDownSize(i2);
                        socketResponsedMessage2.setRetry(this.om.em());
                        socketResponsedMessage2.performanceData.qt = j;
                        socketResponsedMessage2.performanceData.qv = j2;
                        socketResponsedMessage2.performanceData.qw = j3;
                        socketResponsedMessage2.performanceData.qx = currentTimeMillis3;
                    }
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.pM);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            } catch (CoderException e3) {
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                m.a("unpacker", i, this.oo, "unpacktask", l.pa, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.pM);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.oo == 0 || gVar == null || socketResponsedMessage != null) {
            return true;
        }
        m.a("unpacker", 0, this.oo, "checkresponsedMessage", l.pd, "ack cont responsed");
        return false;
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
        if (this.oj != null) {
            boolean a = a(socketResponsedMessage, this.om);
            f fVar = new f();
            fVar.or = socketResponsedMessage;
            if (!a) {
                fVar.os = this.om;
            }
            this.oj.a(fVar);
        }
    }

    public static BdUniqueId dU() {
        return oi;
    }
}
