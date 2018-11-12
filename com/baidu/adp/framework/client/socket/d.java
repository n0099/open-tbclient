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
    private static final BdUniqueId wh = BdUniqueId.gen();
    private a wi;
    private com.baidu.adp.framework.client.socket.coder.c wj;
    private e wk;
    private int wl;
    private SocketMessageTask wn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.wi = null;
        this.wj = null;
        this.wk = null;
        this.wl = 0;
        this.wn = null;
        this.wj = cVar;
        this.wk = eVar;
        this.wi = aVar;
        this.wl = i;
        try {
            if (this.wk != null) {
                this.wn = this.wk.gF();
            }
            if (this.wn == null) {
                this.wn = (SocketMessageTask) MessageManager.getInstance().findTask(this.wj.xL.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(wh);
        setPriority(4);
        if (this.wn != null) {
            setKey(String.valueOf(this.wn.getCmd()));
            setParallel(this.wn.getParallel());
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
        boolean hc;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.wj == null) {
            return null;
        }
        try {
            if (this.wk == null) {
                j2 = 0;
            } else {
                j2 = this.wk.wx;
            }
            if (this.wk == null) {
                j3 = 0;
            } else {
                j3 = this.wk.wy;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.wj.xL.getCommand();
            hc = this.wj.xL.hc();
            i2 = this.wj.xO;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.he().a(this.wj);
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
            if (this.wk == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage gE = this.wk.gE();
                long startTime = gE.getStartTime();
                long gz = this.wk.gz();
                long j13 = gz - startTime;
                long j14 = currentTimeMillis - gz;
                if (j2 > 0) {
                    j9 = j2 - gz;
                    if (j3 >= j2) {
                        j14 = j3 - gz;
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
                socketMessage = gE;
            }
            byte[] bArr2 = null;
            if (cVar2.xN == 0 && cVar2.xO == cVar2.xM.length) {
                bArr = null;
            } else if (cVar2.xO <= 0) {
                cVar2.xM = null;
                bArr = null;
            } else {
                if (this.wj.xL.hd()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.xM, cVar2.xN, com.baidu.adp.framework.client.socket.coder.a.xz).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.xz + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.xM, cVar2.xN + com.baidu.adp.framework.client.socket.coder.a.xz, s).array();
                        cVar2.xN += i4;
                        cVar2.xO -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.wR);
                    }
                }
                cVar2.xM = ByteBuffer.allocateDirect(cVar2.xO).put(cVar2.xM, cVar2.xN, cVar2.xO).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.he().a(i3, cVar2.xM, socketMessage, this.wn, hc);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.wR);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.wk != null && this.wj != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.wk.gz());
                        socketResponsedMessage2.setRetry(this.wk.gI());
                        socketResponsedMessage2.performanceData.yp = j5;
                        socketResponsedMessage2.performanceData.yr = j4;
                        socketResponsedMessage2.performanceData.ys = j6;
                        socketResponsedMessage2.performanceData.yt = j7;
                        socketResponsedMessage2.performanceData.yw = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.yv = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.yu = j11;
                    socketResponsedMessage2.sequenceID = this.wj.xL.hb();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.xM);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.wk != null && this.wk.gE() != null) {
                    j = this.wk.gE().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wl), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wl));
                i.a("unpacker", i, j, this.wl, "unpacktask", h.xa, "onBinaryMesssage decodebody error");
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
            if (this.wk != null) {
                j = this.wk.gE().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wl), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wl));
            i.a("unpacker", i, j, this.wl, "unpacktask", h.xa, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.xM);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.wl != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.gE() == null ? -1L : eVar.gE().getClientLogID(), this.wl, "checkresponsedMessage", h.xb, "ack cont responsed");
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
        if (this.wi != null) {
            boolean a2 = a(socketResponsedMessage, this.wk);
            b bVar = new b();
            bVar.wo = socketResponsedMessage;
            if (!a2) {
                bVar.wp = this.wk;
            }
            this.wi.a(bVar);
        }
    }

    public static BdUniqueId gr() {
        return wh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage wo;
        e wp;

        b() {
        }
    }
}
