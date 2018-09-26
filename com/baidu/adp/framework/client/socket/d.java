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
    private static final BdUniqueId vr = BdUniqueId.gen();
    private a vs;
    private com.baidu.adp.framework.client.socket.coder.c vt;
    private e vu;
    private int vv;
    private SocketMessageTask vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.vs = null;
        this.vt = null;
        this.vu = null;
        this.vv = 0;
        this.vw = null;
        this.vt = cVar;
        this.vu = eVar;
        this.vs = aVar;
        this.vv = i;
        try {
            if (this.vu != null) {
                this.vw = this.vu.gn();
            }
            if (this.vw == null) {
                this.vw = (SocketMessageTask) MessageManager.getInstance().findTask(this.vt.wW.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(vr);
        setPriority(4);
        if (this.vw != null) {
            setKey(String.valueOf(this.vw.getCmd()));
            setParallel(this.vw.getParallel());
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
        boolean gL;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.vt == null) {
            return null;
        }
        try {
            if (this.vu == null) {
                j2 = 0;
            } else {
                j2 = this.vu.vH;
            }
            if (this.vu == null) {
                j3 = 0;
            } else {
                j3 = this.vu.vI;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.vt.wW.getCommand();
            gL = this.vt.wW.gL();
            i2 = this.vt.wZ;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.gN().a(this.vt);
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
            if (this.vu == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage gm = this.vu.gm();
                long startTime = gm.getStartTime();
                long gh = this.vu.gh();
                long j13 = gh - startTime;
                long j14 = currentTimeMillis - gh;
                if (j2 > 0) {
                    j9 = j2 - gh;
                    if (j3 >= j2) {
                        j14 = j3 - gh;
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
                socketMessage = gm;
            }
            byte[] bArr2 = null;
            if (cVar2.wY == 0 && cVar2.wZ == cVar2.wX.length) {
                bArr = null;
            } else if (cVar2.wZ <= 0) {
                cVar2.wX = null;
                bArr = null;
            } else {
                if (this.vt.wW.gM()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.wX, cVar2.wY, com.baidu.adp.framework.client.socket.coder.a.wK).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.wK + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.wX, cVar2.wY + com.baidu.adp.framework.client.socket.coder.a.wK, s).array();
                        cVar2.wY += i4;
                        cVar2.wZ -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.wb);
                    }
                }
                cVar2.wX = ByteBuffer.allocateDirect(cVar2.wZ).put(cVar2.wX, cVar2.wY, cVar2.wZ).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.gN().a(i3, cVar2.wX, socketMessage, this.vw, gL);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.wb);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.vu != null && this.vt != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.vu.gh());
                        socketResponsedMessage2.setRetry(this.vu.gq());
                        socketResponsedMessage2.performanceData.xA = j5;
                        socketResponsedMessage2.performanceData.xC = j4;
                        socketResponsedMessage2.performanceData.xD = j6;
                        socketResponsedMessage2.performanceData.xE = j7;
                        socketResponsedMessage2.performanceData.xH = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.xG = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.xF = j11;
                    socketResponsedMessage2.sequenceID = this.vt.wW.gK();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.wX);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.vu != null && this.vu.gm() != null) {
                    j = this.vu.gm().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.vv), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.vv));
                i.a("unpacker", i, j, this.vv, "unpacktask", h.wk, "onBinaryMesssage decodebody error");
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
            if (this.vu != null) {
                j = this.vu.gm().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.vv), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.vv));
            i.a("unpacker", i, j, this.vv, "unpacktask", h.wk, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.wX);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.vv != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.gm() == null ? -1L : eVar.gm().getClientLogID(), this.vv, "checkresponsedMessage", h.wl, "ack cont responsed");
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
        if (this.vs != null) {
            boolean a2 = a(socketResponsedMessage, this.vu);
            b bVar = new b();
            bVar.vx = socketResponsedMessage;
            if (!a2) {
                bVar.vy = this.vu;
            }
            this.vs.a(bVar);
        }
    }

    public static BdUniqueId fY() {
        return vr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage vx;
        e vy;

        b() {
        }
    }
}
