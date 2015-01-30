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
    private static final BdUniqueId cX = BdUniqueId.gen();
    private e cY;
    private com.baidu.adp.framework.client.socket.coder.c cZ;
    private g da;
    private int db;
    private SocketMessageTask dc;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.cY = null;
        this.cZ = null;
        this.da = null;
        this.db = 0;
        this.dc = null;
        this.cZ = cVar;
        this.da = gVar;
        this.cY = eVar;
        this.db = i;
        try {
            if (this.da != null) {
                this.dc = this.da.aL();
            }
            if (this.dc == null) {
                this.dc = (SocketMessageTask) MessageManager.getInstance().findTask(this.cZ.es.bh());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(cX);
        setPriority(4);
        if (this.dc != null) {
            setKey(String.valueOf(this.dc.getCmd()));
            setParallel(this.dc.getParallel());
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
        if (this.cZ == null) {
            return null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            i = this.cZ.es.bh();
            int i2 = this.cZ.ew;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.bk().a(this.cZ);
            try {
                currentTimeMillis = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                j = 0;
                j2 = 0;
                j3 = 0;
                if (this.da != null) {
                    socketMessage = this.da.aK();
                    long startTime = socketMessage.getStartTime();
                    j = this.da.aF() - startTime;
                    j2 = currentTimeMillis2 - startTime;
                    j3 = currentTimeMillis - currentTimeMillis2;
                }
                if (cVar2.ev != 0 || cVar2.ew != cVar2.eu.length) {
                    if (cVar2.ew <= 0) {
                        cVar2.eu = null;
                    } else {
                        cVar2.eu = ByteBuffer.allocateDirect(cVar2.ew).put(cVar2.eu, cVar2.ev, cVar2.ew).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.bk().a(i, cVar2.eu, socketMessage, this.dc);
            } catch (CoderException e) {
                cVar = cVar2;
                socketResponsedMessage = null;
            }
            try {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (socketResponsedMessage2 != null) {
                    if (this.da != null && this.cZ != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.da.aF());
                        socketResponsedMessage2.setDownSize(i2);
                        socketResponsedMessage2.setRetry(this.da.aP());
                        socketResponsedMessage2.performanceData.fb = j;
                        socketResponsedMessage2.performanceData.fd = j2;
                        socketResponsedMessage2.performanceData.fe = j3;
                        socketResponsedMessage2.performanceData.ff = currentTimeMillis3;
                    }
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.eu);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            } catch (CoderException e3) {
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                m.a("unpacker", i, this.db, "unpacktask", l.dM, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.eu);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.db == 0 || gVar == null || socketResponsedMessage != null) {
            return true;
        }
        m.a("unpacker", 0, this.db, "checkresponsedMessage", l.dN, "ack cont responsed");
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
        if (this.cY != null) {
            boolean a = a(socketResponsedMessage, this.da);
            f fVar = new f();
            fVar.dd = socketResponsedMessage;
            if (!a) {
                fVar.de = this.da;
            }
            this.cY.a(fVar);
        }
    }

    public static BdUniqueId ax() {
        return cX;
    }
}
