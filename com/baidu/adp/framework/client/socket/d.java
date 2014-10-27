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
    private static final BdUniqueId aQ = BdUniqueId.gen();
    private e aR;
    private com.baidu.adp.framework.client.socket.coder.c aS;
    private g aT;
    private int aU;
    private SocketMessageTask aV;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.aR = null;
        this.aS = null;
        this.aT = null;
        this.aU = 0;
        this.aV = null;
        this.aS = cVar;
        this.aT = gVar;
        this.aR = eVar;
        this.aU = i;
        try {
            if (this.aT != null) {
                this.aV = this.aT.al();
            }
            if (this.aV == null) {
                this.aV = (SocketMessageTask) MessageManager.getInstance().findTask(this.aS.ck.aH());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(aQ);
        setPriority(4);
        if (this.aV != null) {
            setParallel(this.aV.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
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
        if (this.aS == null) {
            return null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            i = this.aS.ck.aH();
            int i2 = this.aS.cn;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.aK().a(this.aS);
            try {
                currentTimeMillis = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                j = 0;
                j2 = 0;
                j3 = 0;
                if (this.aT != null) {
                    socketMessage = this.aT.ak();
                    long startTime = socketMessage.getStartTime();
                    j = this.aT.af() - startTime;
                    j2 = currentTimeMillis2 - startTime;
                    j3 = currentTimeMillis - currentTimeMillis2;
                }
                if (cVar2.cm != 0 || cVar2.cn != cVar2.cl.length) {
                    if (cVar2.cn <= 0) {
                        cVar2.cl = null;
                    } else {
                        cVar2.cl = ByteBuffer.allocateDirect(cVar2.cn).put(cVar2.cl, cVar2.cm, cVar2.cn).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.aK().a(i, cVar2.cl, socketMessage, this.aV);
            } catch (CoderException e) {
                cVar = cVar2;
                socketResponsedMessage = null;
            }
            try {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (socketResponsedMessage2 != null) {
                    if (this.aT != null && this.aS != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.aT.af());
                        socketResponsedMessage2.setDownSize(i2);
                        socketResponsedMessage2.setRetry(this.aT.ap());
                        socketResponsedMessage2.performanceData.cT = j;
                        socketResponsedMessage2.performanceData.cV = j2;
                        socketResponsedMessage2.performanceData.cW = j3;
                        socketResponsedMessage2.performanceData.cX = currentTimeMillis3;
                    }
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.cl);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            } catch (CoderException e3) {
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                m.a("unpacker", i, this.aU, "unpacktask", l.bF, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.cl);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.aU == 0 || gVar == null || socketResponsedMessage != null) {
            return true;
        }
        m.a("unpacker", 0, this.aU, "checkresponsedMessage", l.bG, "ack cont responsed");
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
        if (this.aR != null) {
            boolean a = a(socketResponsedMessage, this.aT);
            f fVar = new f();
            fVar.aW = socketResponsedMessage;
            if (!a) {
                fVar.aX = this.aT;
            }
            this.aR.a(fVar);
        }
    }

    public static BdUniqueId X() {
        return aQ;
    }
}
