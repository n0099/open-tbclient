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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final BdUniqueId Jx = BdUniqueId.gen();
    private e JA;
    private SocketMessageTask JB;
    private a Jy;
    private com.baidu.adp.framework.client.socket.coder.c Jz;
    private int mSequenceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.Jy = null;
        this.Jz = null;
        this.JA = null;
        this.mSequenceId = 0;
        this.JB = null;
        this.Jz = cVar;
        this.JA = eVar;
        this.Jy = aVar;
        this.mSequenceId = i;
        try {
            if (this.JA != null) {
                this.JB = this.JA.lu();
            }
            if (this.JB == null) {
                this.JB = (SocketMessageTask) MessageManager.getInstance().findTask(this.Jz.JP.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(Jx);
        setPriority(4);
        if (this.JB != null) {
            setKey(String.valueOf(this.JB.getCmd()));
            setParallel(this.JB.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0187  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        String str;
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        long j;
        long j2;
        String str2;
        long j3;
        long j4;
        long j5;
        SocketMessage socketMessage;
        long j6;
        long j7;
        long j8;
        byte[] bArr;
        int i2 = 0;
        if (this.Jz == null) {
            return null;
        }
        try {
            if (this.JA == null) {
                j = 0;
            } else {
                j = this.JA.firstByteReachTime;
            }
            if (this.JA == null) {
                j2 = 0;
            } else {
                j2 = this.JA.allDataReadTime;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i2 = this.Jz.JP.getCommand();
            boolean lcsSwitchHttp = this.Jz.JP.getLcsSwitchHttp();
            int i3 = this.Jz.bodyLength;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.lx().a(this.Jz);
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (i2 == 301001) {
                    str2 = "frs";
                } else if (i2 == 302001) {
                    str2 = "pb";
                } else if (i2 == 309264) {
                    str2 = "home_page";
                } else if (i2 == 303011) {
                    str2 = "enter_forum";
                } else if (i2 == 303012) {
                    str2 = "user_center";
                } else if (i2 == 303002) {
                    str2 = "person_center_post";
                } else if (i2 != 309647) {
                    str2 = "other";
                } else {
                    str2 = "person_center_dynamic";
                }
                long j9 = 0;
                long j10 = 0;
                long j11 = 0;
                try {
                    if (this.JA == null) {
                        j3 = 0;
                        j4 = 0;
                        j5 = 0;
                        socketMessage = null;
                        j6 = 0;
                        j7 = 0;
                        j8 = 0;
                    } else {
                        SocketMessage lt = this.JA.lt();
                        long startTime = lt.getStartTime();
                        long startSendTime = this.JA.getStartSendTime();
                        long j12 = startSendTime - startTime;
                        long j13 = currentTimeMillis - startSendTime;
                        if (j > 0) {
                            j9 = j - startSendTime;
                            if (j2 >= j) {
                                j13 = j2 - startSendTime;
                                j10 = j2 - j;
                                j11 = currentTimeMillis - j2;
                            }
                        }
                        j3 = j11;
                        j4 = currentTimeMillis2 - currentTimeMillis;
                        j5 = j12;
                        j6 = j10;
                        socketMessage = lt;
                        j8 = j13;
                        j7 = j9;
                    }
                    byte[] bArr2 = null;
                    if (cVar2.bodyOffset == 0 && cVar2.bodyLength == cVar2.body.length) {
                        bArr = null;
                    } else if (cVar2.bodyLength <= 0) {
                        cVar2.body = null;
                        bArr = null;
                    } else {
                        if (this.Jz.JP.getHasExtraData()) {
                            try {
                                short s = ByteBuffer.wrap(cVar2.body, cVar2.bodyOffset, com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN).getShort();
                                int i4 = com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN + s;
                                bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.body, cVar2.bodyOffset + com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN, s).array();
                                cVar2.bodyOffset += i4;
                                cVar2.bodyLength -= i4;
                            } catch (Exception e) {
                                throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                            }
                        }
                        cVar2.body = ByteBuffer.allocateDirect(cVar2.bodyLength).put(cVar2.body, cVar2.bodyOffset, cVar2.bodyLength).array();
                        bArr = bArr2;
                    }
                    socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.lx().a(i2, cVar2.body, socketMessage, this.JB, lcsSwitchHttp);
                    try {
                        if (socketResponsedMessage2 != null && bArr != null) {
                            try {
                                socketResponsedMessage2.decodeExtraDataInBackGround(i2, bArr);
                            } catch (Exception e2) {
                                com.baidu.adp.lib.stats.b.a.a(str2, i2, com.baidu.adp.lib.webSocket.h.oC().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.oC().oI(), 0L, 0L, 0L, 0L, 0);
                                throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                            }
                        }
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                        if (socketResponsedMessage2 != null) {
                            if (this.JA != null && this.Jz != null) {
                                socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.JA.getStartSendTime());
                                socketResponsedMessage2.setRetry(this.JA.getRetryConnectTimes());
                                socketResponsedMessage2.performanceData.mQueneTime = j5;
                                socketResponsedMessage2.performanceData.mNetRWTime = j8;
                                socketResponsedMessage2.performanceData.mFirstByteReachTime = j7;
                                socketResponsedMessage2.performanceData.mAllDataReadTime = j6;
                                socketResponsedMessage2.performanceData.mTaskWaitTime = j3;
                            }
                            socketResponsedMessage2.setDownSize(i3);
                            socketResponsedMessage2.performanceData.mAnalysisTime = currentTimeMillis3;
                            socketResponsedMessage2.performanceData.mCompressTime = j4;
                            socketResponsedMessage2.sequenceID = this.Jz.JP.getSequenceID();
                            try {
                                socketResponsedMessage2.beforeDispatchInBackGround(i2, cVar2.body);
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                            com.baidu.adp.lib.stats.b.a.a(str2, i2, com.baidu.adp.lib.webSocket.h.oC().getUrl(), true, false, com.baidu.adp.lib.webSocket.h.oC().oI(), j8, currentTimeMillis3, j7, j6, 0);
                        } else {
                            com.baidu.adp.lib.stats.b.a.a(str2, i2, com.baidu.adp.lib.webSocket.h.oC().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.oC().oI(), 0L, 0L, 0L, 0L, 0);
                        }
                    } catch (CoderException e4) {
                        cVar = cVar2;
                        socketResponsedMessage = socketResponsedMessage2;
                        str = str2;
                        i = i2;
                        long j14 = -100;
                        if (this.JA != null && this.JA.lt() != null) {
                            j14 = this.JA.lt().getClientLogID();
                        }
                        BdStatisticsManager.getInstance().error("im", j14, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
                        i.debug("unpacker", i, j14, this.mSequenceId, "unpacktask", h.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
                        com.baidu.adp.lib.stats.b.a.a(str, i, com.baidu.adp.lib.webSocket.h.oC().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.oC().oI(), 0L, 0L, 0L, 0L, 0);
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
                } catch (CoderException e5) {
                    i = i2;
                    cVar = cVar2;
                    socketResponsedMessage = null;
                    str = str2;
                }
            } catch (CoderException e6) {
                i = i2;
                cVar = cVar2;
                socketResponsedMessage = null;
                str = "other";
            }
        } catch (CoderException e7) {
            str = "other";
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
                socketResponsedMessage2.afterDispatchInBackGround(i2, cVar2.body);
            } catch (Exception e8) {
                BdLog.e(e8.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.mSequenceId != 0 && eVar != null && socketResponsedMessage == null) {
            i.debug("unpacker", eVar.getCmd(), eVar.lt() == null ? -1L : eVar.lt().getClientLogID(), this.mSequenceId, "checkresponsedMessage", h.CODEC_UNPACK_EMPTY, "ack cont responsed");
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
        if (this.Jy != null) {
            boolean a2 = a(socketResponsedMessage, this.JA);
            b bVar = new b();
            bVar.JC = socketResponsedMessage;
            if (!a2) {
                bVar.JD = this.JA;
            }
            this.Jy.a(bVar);
        }
    }

    public static BdUniqueId lr() {
        return Jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage JC;
        e JD;

        b() {
        }
    }
}
