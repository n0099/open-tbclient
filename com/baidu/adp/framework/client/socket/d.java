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
    private static final BdUniqueId cW = BdUniqueId.gen();
    private e cX;
    private com.baidu.adp.framework.client.socket.coder.c cY;
    private g cZ;
    private int da;
    private SocketMessageTask db;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.cX = null;
        this.cY = null;
        this.cZ = null;
        this.da = 0;
        this.db = null;
        this.cY = cVar;
        this.cZ = gVar;
        this.cX = eVar;
        this.da = i;
        try {
            if (this.cZ != null) {
                this.db = this.cZ.aL();
            }
            if (this.db == null) {
                this.db = (SocketMessageTask) MessageManager.getInstance().findTask(this.cY.eq.bh());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(cW);
        setPriority(4);
        if (this.db != null) {
            setParallel(this.db.getParallel());
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
        if (this.cY == null) {
            return null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            i = this.cY.eq.bh();
            int i2 = this.cY.eu;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.bk().a(this.cY);
            try {
                currentTimeMillis = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                j = 0;
                j2 = 0;
                j3 = 0;
                if (this.cZ != null) {
                    socketMessage = this.cZ.aK();
                    long startTime = socketMessage.getStartTime();
                    j = this.cZ.aF() - startTime;
                    j2 = currentTimeMillis2 - startTime;
                    j3 = currentTimeMillis - currentTimeMillis2;
                }
                if (cVar2.es != 0 || cVar2.eu != cVar2.er.length) {
                    if (cVar2.eu <= 0) {
                        cVar2.er = null;
                    } else {
                        cVar2.er = ByteBuffer.allocateDirect(cVar2.eu).put(cVar2.er, cVar2.es, cVar2.eu).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.bk().a(i, cVar2.er, socketMessage, this.db);
            } catch (CoderException e) {
                cVar = cVar2;
                socketResponsedMessage = null;
            }
            try {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (socketResponsedMessage2 != null) {
                    if (this.cZ != null && this.cY != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.cZ.aF());
                        socketResponsedMessage2.setDownSize(i2);
                        socketResponsedMessage2.setRetry(this.cZ.aP());
                        socketResponsedMessage2.performanceData.eZ = j;
                        socketResponsedMessage2.performanceData.fb = j2;
                        socketResponsedMessage2.performanceData.fc = j3;
                        socketResponsedMessage2.performanceData.fd = currentTimeMillis3;
                    }
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.er);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            } catch (CoderException e3) {
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                m.a("unpacker", i, this.da, "unpacktask", l.dL, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.er);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.da == 0 || gVar == null || socketResponsedMessage != null) {
            return true;
        }
        m.a("unpacker", 0, this.da, "checkresponsedMessage", l.dM, "ack cont responsed");
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
        if (this.cX != null) {
            boolean a = a(socketResponsedMessage, this.cZ);
            f fVar = new f();
            fVar.dc = socketResponsedMessage;
            if (!a) {
                fVar.dd = this.cZ;
            }
            this.cX.a(fVar);
        }
    }

    public static BdUniqueId ax() {
        return cW;
    }
}
