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
    private static final BdUniqueId gZ = BdUniqueId.gen();
    private a ha;
    private com.baidu.adp.framework.client.socket.coder.c hb;
    private e hc;
    private int hd;
    private SocketMessageTask hf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.ha = null;
        this.hb = null;
        this.hc = null;
        this.hd = 0;
        this.hf = null;
        this.hb = cVar;
        this.hc = eVar;
        this.ha = aVar;
        this.hd = i;
        try {
            if (this.hc != null) {
                this.hf = this.hc.bA();
            }
            if (this.hf == null) {
                this.hf = (SocketMessageTask) MessageManager.getInstance().findTask(this.hb.iG.bW());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(gZ);
        setPriority(4);
        if (this.hf != null) {
            setKey(String.valueOf(this.hf.getCmd()));
            setParallel(this.hf.getParallel());
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
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        int i2 = 0;
        if (this.hb == null) {
            return null;
        }
        try {
            if (this.hc == null) {
                j = 0;
            } else {
                j = this.hc.hr;
            }
            if (this.hc == null) {
                j2 = 0;
            } else {
                j2 = this.hc.hs;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.hb.iG.bW();
            boolean bZ = this.hb.iG.bZ();
            int i3 = this.hb.iJ;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.ca().a(this.hb);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                if (this.hc == null) {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                    j6 = 0;
                    j7 = 0;
                    j8 = 0;
                    socketMessage = null;
                } else {
                    SocketMessage bz = this.hc.bz();
                    long startTime = bz.getStartTime();
                    long bu = this.hc.bu();
                    long j12 = bu - startTime;
                    long j13 = currentTimeMillis - bu;
                    if (j > 0) {
                        j9 = j - bu;
                        if (j2 >= j) {
                            j13 = j2 - bu;
                            j10 = j2 - j;
                            j11 = currentTimeMillis - j2;
                        }
                    }
                    j3 = j12;
                    j4 = j13;
                    j7 = j10;
                    j8 = j11;
                    socketMessage = bz;
                    long j14 = j9;
                    j6 = currentTimeMillis2 - currentTimeMillis;
                    j5 = j14;
                }
                if (cVar2.iI != 0 || cVar2.iJ != cVar2.iH.length) {
                    if (cVar2.iJ <= 0) {
                        cVar2.iH = null;
                    } else {
                        cVar2.iH = ByteBuffer.allocateDirect(cVar2.iJ).put(cVar2.iH, cVar2.iI, cVar2.iJ).array();
                    }
                }
                socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.ca().a(i2, cVar2.iH, socketMessage, this.hf, bZ);
                try {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (socketResponsedMessage2 != null) {
                        if (this.hc != null && this.hb != null) {
                            socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.hc.bu());
                            socketResponsedMessage2.setRetry(this.hc.bD());
                            socketResponsedMessage2.performanceData.jp = j3;
                            socketResponsedMessage2.performanceData.jr = j4;
                            socketResponsedMessage2.performanceData.js = j5;
                            socketResponsedMessage2.performanceData.jt = j7;
                            socketResponsedMessage2.performanceData.jw = j8;
                        }
                        socketResponsedMessage2.setDownSize(i3);
                        socketResponsedMessage2.performanceData.jv = currentTimeMillis3;
                        socketResponsedMessage2.performanceData.ju = j6;
                        socketResponsedMessage2.sequenceID = this.hb.iG.bY();
                        try {
                            socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.iH);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                } catch (CoderException e2) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = socketResponsedMessage2;
                    long j15 = -100;
                    if (this.hc != null && this.hc.bz() != null) {
                        j15 = this.hc.bz().getClientLogID();
                    }
                    com.baidu.adp.lib.stats.a.eI().b("im", j15, String.valueOf(this.hd), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.hd));
                    k.a("unpacker", i, j15, this.hd, "unpacktask", j.hS, "onBinaryMesssage decodebody error");
                    i2 = i;
                    cVar2 = cVar;
                    socketResponsedMessage2 = socketResponsedMessage;
                    if (socketResponsedMessage2 != null) {
                    }
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
        if (socketResponsedMessage2 != null) {
            socketResponsedMessage2.setStartTime(System.currentTimeMillis());
        }
        publishProgress(socketResponsedMessage2);
        if (socketResponsedMessage2 != null) {
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.iH);
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.hd != 0 && eVar != null && socketResponsedMessage == null) {
            k.a("unpacker", eVar.getCmd(), eVar.bz() == null ? -1L : eVar.bz().getClientLogID(), this.hd, "checkresponsedMessage", j.hT, "ack cont responsed");
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
        if (this.ha != null) {
            boolean a2 = a(socketResponsedMessage, this.hc);
            b bVar = new b();
            bVar.hg = socketResponsedMessage;
            if (!a2) {
                bVar.hh = this.hc;
            }
            this.ha.a(bVar);
        }
    }

    public static BdUniqueId bm() {
        return gZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage hg;
        e hh;

        b() {
        }
    }
}
