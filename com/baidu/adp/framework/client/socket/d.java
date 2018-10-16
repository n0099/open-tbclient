package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId we = BdUniqueId.gen();
    private a wf;
    private com.baidu.adp.framework.client.socket.coder.c wg;
    private e wh;
    private int wi;
    private SocketMessageTask wj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.wf = null;
        this.wg = null;
        this.wh = null;
        this.wi = 0;
        this.wj = null;
        this.wg = cVar;
        this.wh = eVar;
        this.wf = aVar;
        this.wi = i;
        try {
            if (this.wh != null) {
                this.wj = this.wh.gG();
            }
            if (this.wj == null) {
                this.wj = (SocketMessageTask) MessageManager.getInstance().findTask(this.wg.xI.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(we);
        setPriority(4);
        if (this.wj != null) {
            setKey(String.valueOf(this.wj.getCmd()));
            setParallel(this.wj.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        long j;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        long j2;
        long j3;
        long currentTimeMillis;
        boolean hd;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.wg == null) {
            return null;
        }
        try {
            if (this.wh == null) {
                j2 = 0;
            } else {
                j2 = this.wh.wu;
            }
            if (this.wh == null) {
                j3 = 0;
            } else {
                j3 = this.wh.wv;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.wg.xI.getCommand();
            hd = this.wg.xI.hd();
            i2 = this.wg.xL;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.hf().a(this.wg);
        } catch (CoderException e) {
            i = i3;
            cVar = null;
            socketResponsedMessage = null;
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            if (this.wh == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage gF = this.wh.gF();
                long startTime = gF.getStartTime();
                long gA = this.wh.gA();
                long j13 = gA - startTime;
                long j14 = currentTimeMillis - gA;
                if (j2 > 0) {
                    j9 = j2 - gA;
                    if (j3 >= j2) {
                        j14 = j3 - gA;
                        j10 = j3 - j2;
                        j12 = currentTimeMillis - j3;
                    }
                }
                j4 = j14;
                j5 = j13;
                j6 = j9;
                j11 = currentTimeMillis2 - currentTimeMillis;
                j8 = j12;
                j7 = j10;
                socketMessage = gF;
            }
            byte[] bArr2 = null;
            if (cVar2.xK == 0 && cVar2.xL == cVar2.xJ.length) {
                bArr = null;
            } else if (cVar2.xL <= 0) {
                cVar2.xJ = null;
                bArr = null;
            } else {
                if (this.wg.xI.he()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.xJ, cVar2.xK, com.baidu.adp.framework.client.socket.coder.a.xw).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.xw + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.xJ, cVar2.xK + com.baidu.adp.framework.client.socket.coder.a.xw, s).array();
                        cVar2.xK += i4;
                        cVar2.xL -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.wO);
                    }
                }
                cVar2.xJ = ByteBuffer.allocateDirect(cVar2.xL).put(cVar2.xJ, cVar2.xK, cVar2.xL).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.hf().a(i3, cVar2.xJ, socketMessage, this.wj, hd);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.wO);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.wh != null && this.wg != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.wh.gA());
                        socketResponsedMessage2.setRetry(this.wh.gJ());
                        socketResponsedMessage2.performanceData.ym = j5;
                        socketResponsedMessage2.performanceData.yo = j4;
                        socketResponsedMessage2.performanceData.yp = j6;
                        socketResponsedMessage2.performanceData.yq = j7;
                        socketResponsedMessage2.performanceData.yt = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.ys = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.yr = j11;
                    socketResponsedMessage2.sequenceID = this.wg.xI.hc();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.xJ);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.wh != null && this.wh.gF() != null) {
                    j = this.wh.gF().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wi), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wi));
                i.a("unpacker", i, j, this.wi, "unpacktask", h.wX, "onBinaryMesssage decodebody error");
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
        } catch (CoderException e6) {
            i = i3;
            cVar = cVar2;
            socketResponsedMessage = null;
            j = -100;
            if (this.wh != null) {
                j = this.wh.gF().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wi), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wi));
            i.a("unpacker", i, j, this.wi, "unpacktask", h.wX, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.xJ);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.wi != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.gF() == null ? -1L : eVar.gF().getClientLogID(), this.wi, "checkresponsedMessage", h.wY, "ack cont responsed");
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
        if (this.wf != null) {
            boolean a2 = a(socketResponsedMessage, this.wh);
            b bVar = new b();
            bVar.wk = socketResponsedMessage;
            if (!a2) {
                bVar.wl = this.wh;
            }
            this.wf.a(bVar);
        }
    }

    public static BdUniqueId gr() {
        return we;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage wk;
        e wl;

        b() {
        }
    }
}
