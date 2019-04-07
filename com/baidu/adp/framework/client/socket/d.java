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
    private static final BdUniqueId wc = BdUniqueId.gen();
    private a we;
    private com.baidu.adp.framework.client.socket.coder.c wf;
    private e wg;
    private int wh;
    private SocketMessageTask wi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.we = null;
        this.wf = null;
        this.wg = null;
        this.wh = 0;
        this.wi = null;
        this.wf = cVar;
        this.wg = eVar;
        this.we = aVar;
        this.wh = i;
        try {
            if (this.wg != null) {
                this.wi = this.wg.gC();
            }
            if (this.wi == null) {
                this.wi = (SocketMessageTask) MessageManager.getInstance().findTask(this.wf.xH.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(wc);
        setPriority(4);
        if (this.wi != null) {
            setKey(String.valueOf(this.wi.getCmd()));
            setParallel(this.wi.getParallel());
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
        boolean gZ;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.wf == null) {
            return null;
        }
        try {
            if (this.wg == null) {
                j2 = 0;
            } else {
                j2 = this.wg.wu;
            }
            if (this.wg == null) {
                j3 = 0;
            } else {
                j3 = this.wg.wv;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.wf.xH.getCommand();
            gZ = this.wf.xH.gZ();
            i2 = this.wf.xK;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.hb().a(this.wf);
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
            if (this.wg == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage gB = this.wg.gB();
                long startTime = gB.getStartTime();
                long gw = this.wg.gw();
                long j13 = gw - startTime;
                long j14 = currentTimeMillis - gw;
                if (j2 > 0) {
                    j9 = j2 - gw;
                    if (j3 >= j2) {
                        j14 = j3 - gw;
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
                socketMessage = gB;
            }
            byte[] bArr2 = null;
            if (cVar2.xJ == 0 && cVar2.xK == cVar2.xI.length) {
                bArr = null;
            } else if (cVar2.xK <= 0) {
                cVar2.xI = null;
                bArr = null;
            } else {
                if (this.wf.xH.ha()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.xI, cVar2.xJ, com.baidu.adp.framework.client.socket.coder.a.xw).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.xw + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.xI, cVar2.xJ + com.baidu.adp.framework.client.socket.coder.a.xw, s).array();
                        cVar2.xJ += i4;
                        cVar2.xK -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.wO);
                    }
                }
                cVar2.xI = ByteBuffer.allocateDirect(cVar2.xK).put(cVar2.xI, cVar2.xJ, cVar2.xK).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.hb().a(i3, cVar2.xI, socketMessage, this.wi, gZ);
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
                    if (this.wg != null && this.wf != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.wg.gw());
                        socketResponsedMessage2.setRetry(this.wg.gF());
                        socketResponsedMessage2.performanceData.yl = j5;
                        socketResponsedMessage2.performanceData.yn = j4;
                        socketResponsedMessage2.performanceData.yo = j6;
                        socketResponsedMessage2.performanceData.yp = j7;
                        socketResponsedMessage2.performanceData.ys = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.yr = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.yq = j11;
                    socketResponsedMessage2.sequenceID = this.wf.xH.gY();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.xI);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.wg != null && this.wg.gB() != null) {
                    j = this.wg.gB().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wh), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wh));
                i.a("unpacker", i, j, this.wh, "unpacktask", h.wX, "onBinaryMesssage decodebody error");
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
            if (this.wg != null) {
                j = this.wg.gB().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.wh), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.wh));
            i.a("unpacker", i, j, this.wh, "unpacktask", h.wX, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.xI);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.wh != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.gB() == null ? -1L : eVar.gB().getClientLogID(), this.wh, "checkresponsedMessage", h.wY, "ack cont responsed");
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
        if (this.we != null) {
            boolean a2 = a(socketResponsedMessage, this.wg);
            b bVar = new b();
            bVar.wj = socketResponsedMessage;
            if (!a2) {
                bVar.wk = this.wg;
            }
            this.we.a(bVar);
        }
    }

    public static BdUniqueId go() {
        return wc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage wj;
        e wk;

        b() {
        }
    }
}
