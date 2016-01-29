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
                this.oz = (SocketMessageTask) MessageManager.getInstance().findTask(this.ow.pU.eL());
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
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        int i2 = 0;
        if (this.ow == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.ow.pU.eL();
            int i3 = this.ow.pX;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eO().a(this.ow);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                SocketMessage socketMessage = null;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                if (this.ox != null) {
                    socketMessage = this.ox.eo();
                    long startTime = socketMessage.getStartTime();
                    long ej = this.ox.ej();
                    j = ej - startTime;
                    j2 = currentTimeMillis - ej;
                    j3 = currentTimeMillis2 - currentTimeMillis;
                }
                if (cVar2.pW != 0 || cVar2.pX != cVar2.pV.length) {
                    if (cVar2.pX <= 0) {
                        cVar2.pV = null;
                    } else {
                        cVar2.pV = ByteBuffer.allocateDirect(cVar2.pX).put(cVar2.pV, cVar2.pW, cVar2.pX).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eO().a(i2, cVar2.pV, socketMessage, this.oz);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.ox != null && this.ow != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.ox.ej());
                            socketResponsedMessage2.setRetry(this.ox.et());
                            socketResponsedMessage2.performanceData.qD = j;
                            socketResponsedMessage2.performanceData.qF = j2;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.qH = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.qG = j3;
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.pV);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j4 = -100;
                    if (this.ox != null && this.ox.eo() != null) {
                        j4 = this.ox.eo().getClientLogID();
                    }
                    com.baidu.adp.lib.stats.a.ht().b("im", j4, String.valueOf(this.oy), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.oy));
                    k.a("unpacker", i, j4, this.oy, "unpacktask", j.po, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.pV);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.oy != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.eo() == null ? -1L : eVar.eo().getClientLogID(), this.oy, "checkresponsedMessage", j.pp, "ack cont responsed");
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
