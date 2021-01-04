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
    private static final BdUniqueId IX = BdUniqueId.gen();
    private a IY;
    private com.baidu.adp.framework.client.socket.coder.c IZ;
    private e Ja;
    private SocketMessageTask Jb;
    private int mSequenceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.IY = null;
        this.IZ = null;
        this.Ja = null;
        this.mSequenceId = 0;
        this.Jb = null;
        this.IZ = cVar;
        this.Ja = eVar;
        this.IY = aVar;
        this.mSequenceId = i;
        try {
            if (this.Ja != null) {
                this.Jb = this.Ja.kQ();
            }
            if (this.Jb == null) {
                this.Jb = (SocketMessageTask) MessageManager.getInstance().findTask(this.IZ.Jp.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(IX);
        setPriority(4);
        if (this.Jb != null) {
            setKey(String.valueOf(this.Jb.getCmd()));
            setParallel(this.Jb.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018e  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        String str;
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage;
        long j;
        long j2;
        long j3;
        long currentTimeMillis;
        boolean lcsSwitchHttp;
        int i2;
        long currentTimeMillis2;
        SocketMessage socketMessage;
        String str2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        byte[] bArr;
        long j13;
        SocketResponsedMessage socketResponsedMessage2 = null;
        int i3 = 0;
        if (this.IZ == null) {
            return null;
        }
        try {
            if (this.Ja == null) {
                j2 = 0;
            } else {
                j2 = this.Ja.firstByteReachTime;
            }
            if (this.Ja == null) {
                j3 = 0;
            } else {
                j3 = this.Ja.allDataReadTime;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.IZ.Jp.getCommand();
            lcsSwitchHttp = this.IZ.Jp.getLcsSwitchHttp();
            i2 = this.IZ.bodyLength;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.kT().a(this.IZ);
            try {
                currentTimeMillis2 = System.currentTimeMillis();
                socketMessage = null;
                if (i3 == 301001) {
                    str2 = "frs";
                } else if (i3 == 302001) {
                    str2 = "pb";
                } else if (i3 == 309264) {
                    str2 = "home_page";
                } else if (i3 == 303011) {
                    str2 = "enter_forum";
                } else if (i3 == 303012) {
                    str2 = "user_center";
                } else if (i3 == 303002) {
                    str2 = "person_center_post";
                } else if (i3 != 309647) {
                    str2 = "other";
                } else {
                    str2 = "person_center_dynamic";
                }
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
            } catch (CoderException e) {
                str = "other";
                i = i3;
                cVar = cVar2;
            }
        } catch (CoderException e2) {
            str = "other";
            i = i3;
            cVar = null;
        }
        try {
            if (this.Ja == null) {
                j9 = 0;
                j10 = 0;
                j11 = 0;
                j12 = 0;
            } else {
                SocketMessage kP = this.Ja.kP();
                long startTime = kP.getStartTime();
                long startSendTime = this.Ja.getStartSendTime();
                j4 = startSendTime - startTime;
                long j14 = currentTimeMillis - startSendTime;
                if (j2 > 0) {
                    long j15 = j2 - startSendTime;
                    if (j3 >= j2) {
                        j8 = currentTimeMillis - j3;
                        j7 = j3 - j2;
                        j6 = j15;
                        j13 = j3 - startSendTime;
                    } else {
                        j6 = j15;
                        j13 = j14;
                    }
                } else {
                    j13 = j14;
                }
                j10 = currentTimeMillis2 - currentTimeMillis;
                j9 = j8;
                j5 = j13;
                socketMessage = kP;
                j11 = j7;
                j12 = j6;
            }
            byte[] bArr2 = null;
            if (cVar2.bodyOffset == 0 && cVar2.bodyLength == cVar2.body.length) {
                bArr = null;
            } else if (cVar2.bodyLength <= 0) {
                cVar2.body = null;
                bArr = null;
            } else {
                if (this.IZ.Jp.getHasExtraData()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.body, cVar2.bodyOffset, com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.body, cVar2.bodyOffset + com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN, s).array();
                        cVar2.bodyOffset += i4;
                        cVar2.bodyLength -= i4;
                    } catch (Exception e3) {
                        throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                    }
                }
                cVar2.body = ByteBuffer.allocateDirect(cVar2.bodyLength).put(cVar2.body, cVar2.bodyOffset, cVar2.bodyLength).array();
                bArr = bArr2;
            }
            socketResponsedMessage = com.baidu.adp.framework.client.socket.coder.b.kT().a(i3, cVar2.body, socketMessage, this.Jb, lcsSwitchHttp);
            if (socketResponsedMessage != null && bArr != null) {
                try {
                    try {
                        socketResponsedMessage.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e4) {
                        com.baidu.adp.lib.stats.b.a.a(str2, i3, com.baidu.adp.lib.webSocket.h.od().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.od().oj(), 0L, 0L, 0L, 0L, 0);
                        throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                    }
                } catch (CoderException e5) {
                    str = str2;
                    i = i3;
                    cVar = cVar2;
                    socketResponsedMessage2 = socketResponsedMessage;
                    j = -100;
                    if (this.Ja != null && this.Ja.kP() != null) {
                        j = this.Ja.kP().getClientLogID();
                    }
                    BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
                    i.debug("unpacker", i, j, this.mSequenceId, "unpacktask", h.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
                    com.baidu.adp.lib.stats.b.a.a(str, i, com.baidu.adp.lib.webSocket.h.od().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.od().oj(), 0L, 0L, 0L, 0L, 0);
                    i3 = i;
                    cVar2 = cVar;
                    socketResponsedMessage = socketResponsedMessage2;
                    if (socketResponsedMessage != null) {
                    }
                    publishProgress(socketResponsedMessage);
                    if (socketResponsedMessage != null) {
                    }
                    return null;
                }
            }
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (socketResponsedMessage != null) {
                if (this.Ja != null && this.IZ != null) {
                    socketResponsedMessage.setCostTime(System.currentTimeMillis() - this.Ja.getStartSendTime());
                    socketResponsedMessage.setRetry(this.Ja.getRetryConnectTimes());
                    socketResponsedMessage.performanceData.mQueneTime = j4;
                    socketResponsedMessage.performanceData.mNetRWTime = j5;
                    socketResponsedMessage.performanceData.mFirstByteReachTime = j12;
                    socketResponsedMessage.performanceData.mAllDataReadTime = j11;
                    socketResponsedMessage.performanceData.mTaskWaitTime = j9;
                }
                socketResponsedMessage.setDownSize(i2);
                socketResponsedMessage.performanceData.mAnalysisTime = currentTimeMillis3;
                socketResponsedMessage.performanceData.mCompressTime = j10;
                socketResponsedMessage.sequenceID = this.IZ.Jp.getSequenceID();
                try {
                    socketResponsedMessage.beforeDispatchInBackGround(i3, cVar2.body);
                } catch (Exception e6) {
                    BdLog.e(e6.getMessage());
                }
                com.baidu.adp.lib.stats.b.a.a(str2, i3, com.baidu.adp.lib.webSocket.h.od().getUrl(), true, false, com.baidu.adp.lib.webSocket.h.od().oj(), j5, currentTimeMillis3, j12, j11, 0);
            } else {
                com.baidu.adp.lib.stats.b.a.a(str2, i3, com.baidu.adp.lib.webSocket.h.od().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.od().oj(), 0L, 0L, 0L, 0L, 0);
            }
        } catch (CoderException e7) {
            str = str2;
            i = i3;
            cVar = cVar2;
            j = -100;
            if (this.Ja != null) {
                j = this.Ja.kP().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
            i.debug("unpacker", i, j, this.mSequenceId, "unpacktask", h.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
            com.baidu.adp.lib.stats.b.a.a(str, i, com.baidu.adp.lib.webSocket.h.od().getUrl(), false, false, com.baidu.adp.lib.webSocket.h.od().oj(), 0L, 0L, 0L, 0L, 0);
            i3 = i;
            cVar2 = cVar;
            socketResponsedMessage = socketResponsedMessage2;
            if (socketResponsedMessage != null) {
            }
            publishProgress(socketResponsedMessage);
            if (socketResponsedMessage != null) {
            }
            return null;
        }
        if (socketResponsedMessage != null) {
            socketResponsedMessage.setStartTime(System.currentTimeMillis());
        }
        publishProgress(socketResponsedMessage);
        if (socketResponsedMessage != null) {
            try {
                socketResponsedMessage.afterDispatchInBackGround(i3, cVar2.body);
            } catch (Exception e8) {
                BdLog.e(e8.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.mSequenceId != 0 && eVar != null && socketResponsedMessage == null) {
            i.debug("unpacker", eVar.getCmd(), eVar.kP() == null ? -1L : eVar.kP().getClientLogID(), this.mSequenceId, "checkresponsedMessage", h.CODEC_UNPACK_EMPTY, "ack cont responsed");
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
        if (this.IY != null) {
            boolean a2 = a(socketResponsedMessage, this.Ja);
            b bVar = new b();
            bVar.Jc = socketResponsedMessage;
            if (!a2) {
                bVar.Jd = this.Ja;
            }
            this.IY.a(bVar);
        }
    }

    public static BdUniqueId kN() {
        return IX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage Jc;
        e Jd;

        b() {
        }
    }
}
