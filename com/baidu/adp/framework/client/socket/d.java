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
    private static final BdUniqueId acx = BdUniqueId.gen();
    private e acA;
    private int acB;
    private SocketMessageTask acC;
    private a acy;
    private com.baidu.adp.framework.client.socket.coder.c acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.acy = null;
        this.acz = null;
        this.acA = null;
        this.acB = 0;
        this.acC = null;
        this.acz = cVar;
        this.acA = eVar;
        this.acy = aVar;
        this.acB = i;
        try {
            if (this.acA != null) {
                this.acC = this.acA.kn();
            }
            if (this.acC == null) {
                this.acC = (SocketMessageTask) MessageManager.getInstance().findTask(this.acz.aec.kI());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(acx);
        setPriority(4);
        if (this.acC != null) {
            setKey(String.valueOf(this.acC.getCmd()));
            setParallel(this.acC.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
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
        boolean kL;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.acz == null) {
            return null;
        }
        try {
            if (this.acA == null) {
                j2 = 0;
            } else {
                j2 = this.acA.acN;
            }
            if (this.acA == null) {
                j3 = 0;
            } else {
                j3 = this.acA.acO;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.acz.aec.kI();
            kL = this.acz.aec.kL();
            i2 = this.acz.aef;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.kN().a(this.acz);
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
            if (this.acA == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage km = this.acA.km();
                long startTime = km.getStartTime();
                long kh = this.acA.kh();
                long j13 = kh - startTime;
                long j14 = currentTimeMillis - kh;
                if (j2 > 0) {
                    j9 = j2 - kh;
                    if (j3 >= j2) {
                        j14 = j3 - kh;
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
                socketMessage = km;
            }
            byte[] bArr2 = null;
            if (cVar2.aee == 0 && cVar2.aef == cVar2.aed.length) {
                bArr = null;
            } else if (cVar2.aef <= 0) {
                cVar2.aed = null;
                bArr = null;
            } else {
                if (this.acz.aec.kM()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.aed, cVar2.aee, com.baidu.adp.framework.client.socket.coder.a.adQ).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.adQ + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.aed, cVar2.aee + com.baidu.adp.framework.client.socket.coder.a.adQ, s).array();
                        cVar2.aee += i4;
                        cVar2.aef -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.adi);
                    }
                }
                cVar2.aed = ByteBuffer.allocateDirect(cVar2.aef).put(cVar2.aed, cVar2.aee, cVar2.aef).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.kN().a(i3, cVar2.aed, socketMessage, this.acC, kL);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.adi);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.acA != null && this.acz != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.acA.kh());
                        socketResponsedMessage2.setRetry(this.acA.kq());
                        socketResponsedMessage2.performanceData.aeI = j5;
                        socketResponsedMessage2.performanceData.aeK = j4;
                        socketResponsedMessage2.performanceData.aeL = j6;
                        socketResponsedMessage2.performanceData.aeM = j7;
                        socketResponsedMessage2.performanceData.aeP = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.aeO = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.aeN = j11;
                    socketResponsedMessage2.sequenceID = this.acz.aec.kK();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.aed);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.acA != null && this.acA.km() != null) {
                    j = this.acA.km().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.acB), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.acB));
                i.a("unpacker", i, j, this.acB, "unpacktask", h.adr, "onBinaryMesssage decodebody error");
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
            if (this.acA != null) {
                j = this.acA.km().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.acB), IntentConfig.CMD, Integer.valueOf(i), "seqid", Integer.valueOf(this.acB));
            i.a("unpacker", i, j, this.acB, "unpacktask", h.adr, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.aed);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.acB != 0 && eVar != null && socketResponsedMessage == null) {
            i.a("unpacker", eVar.getCmd(), eVar.km() == null ? -1L : eVar.km().getClientLogID(), this.acB, "checkresponsedMessage", h.ads, "ack cont responsed");
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
        if (this.acy != null) {
            boolean a2 = a(socketResponsedMessage, this.acA);
            b bVar = new b();
            bVar.acD = socketResponsedMessage;
            if (!a2) {
                bVar.acE = this.acA;
            }
            this.acy.a(bVar);
        }
    }

    public static BdUniqueId jZ() {
        return acx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage acD;
        e acE;

        b() {
        }
    }
}
