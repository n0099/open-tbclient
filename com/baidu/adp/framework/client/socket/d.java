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
    private static final BdUniqueId lN = BdUniqueId.gen();
    private a lO;
    private com.baidu.adp.framework.client.socket.coder.c lP;
    private e lQ;
    private SocketMessageTask lR;
    private int mSequenceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, e eVar, a aVar, int i) {
        this.lO = null;
        this.lP = null;
        this.lQ = null;
        this.mSequenceId = 0;
        this.lR = null;
        this.lP = cVar;
        this.lQ = eVar;
        this.lO = aVar;
        this.mSequenceId = i;
        try {
            if (this.lQ != null) {
                this.lR = this.lQ.eA();
            }
            if (this.lR == null) {
                this.lR = (SocketMessageTask) MessageManager.getInstance().findTask(this.lP.mg.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(lN);
        setPriority(4);
        if (this.lR != null) {
            setKey(String.valueOf(this.lR.getCmd()));
            setParallel(this.lR.getParallel());
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
        boolean lcsSwitchHttp;
        int i2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.lP == null) {
            return null;
        }
        try {
            if (this.lQ == null) {
                j2 = 0;
            } else {
                j2 = this.lQ.firstByteReachTime;
            }
            if (this.lQ == null) {
                j3 = 0;
            } else {
                j3 = this.lQ.allDataReadTime;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.lP.mg.getCommand();
            lcsSwitchHttp = this.lP.mg.getLcsSwitchHttp();
            i2 = this.lP.bodyLength;
            cVar2 = com.baidu.adp.framework.client.socket.coder.b.eD().a(this.lP);
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
            if (this.lQ == null) {
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                socketMessage = null;
            } else {
                SocketMessage ez = this.lQ.ez();
                long startTime = ez.getStartTime();
                long startSendTime = this.lQ.getStartSendTime();
                long j13 = startSendTime - startTime;
                long j14 = currentTimeMillis - startSendTime;
                if (j2 > 0) {
                    j9 = j2 - startSendTime;
                    if (j3 >= j2) {
                        j14 = j3 - startSendTime;
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
                socketMessage = ez;
            }
            byte[] bArr2 = null;
            if (cVar2.bodyOffset == 0 && cVar2.bodyLength == cVar2.body.length) {
                bArr = null;
            } else if (cVar2.bodyLength <= 0) {
                cVar2.body = null;
                bArr = null;
            } else {
                if (this.lP.mg.getHasExtraData()) {
                    try {
                        short s = ByteBuffer.wrap(cVar2.body, cVar2.bodyOffset, com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN).getShort();
                        int i4 = com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(cVar2.body, cVar2.bodyOffset + com.baidu.adp.framework.client.socket.coder.a.EXTRA_DATA_HEADER_LEN, s).array();
                        cVar2.bodyOffset += i4;
                        cVar2.bodyLength -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                    }
                }
                cVar2.body = ByteBuffer.allocateDirect(cVar2.bodyLength).put(cVar2.body, cVar2.bodyOffset, cVar2.bodyLength).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.eD().a(i3, cVar2.body, socketMessage, this.lR, lcsSwitchHttp);
            try {
                if (socketResponsedMessage2 != null && bArr != null) {
                    try {
                        socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                    } catch (Exception e3) {
                        throw new CoderException(h.CODEC_UNPACK_EXTRA_DATA_FAILED);
                    }
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (socketResponsedMessage2 != null) {
                    if (this.lQ != null && this.lP != null) {
                        socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.lQ.getStartSendTime());
                        socketResponsedMessage2.setRetry(this.lQ.getRetryConnectTimes());
                        socketResponsedMessage2.performanceData.mQueneTime = j5;
                        socketResponsedMessage2.performanceData.mNetRWTime = j4;
                        socketResponsedMessage2.performanceData.mFirstByteReachTime = j6;
                        socketResponsedMessage2.performanceData.mAllDataReadTime = j7;
                        socketResponsedMessage2.performanceData.mTaskWaitTime = j8;
                    }
                    socketResponsedMessage2.setDownSize(i2);
                    socketResponsedMessage2.performanceData.mAnalysisTime = currentTimeMillis3;
                    socketResponsedMessage2.performanceData.mCompressTime = j11;
                    socketResponsedMessage2.sequenceID = this.lP.mg.getSequenceID();
                    try {
                        socketResponsedMessage2.beforeDispatchInBackGround(i3, cVar2.body);
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                    }
                }
            } catch (CoderException e5) {
                i = i3;
                cVar = cVar2;
                socketResponsedMessage = socketResponsedMessage2;
                j = -100;
                if (this.lQ != null && this.lQ.ez() != null) {
                    j = this.lQ.ez().getClientLogID();
                }
                BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
                i.debug("unpacker", i, j, this.mSequenceId, "unpacktask", h.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
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
            if (this.lQ != null) {
                j = this.lQ.ez().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
            i.debug("unpacker", i, j, this.mSequenceId, "unpacktask", h.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
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
                socketResponsedMessage2.afterDispatchInBackGround(i3, cVar2.body);
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
        return null;
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.mSequenceId != 0 && eVar != null && socketResponsedMessage == null) {
            i.debug("unpacker", eVar.getCmd(), eVar.ez() == null ? -1L : eVar.ez().getClientLogID(), this.mSequenceId, "checkresponsedMessage", h.CODEC_UNPACK_EMPTY, "ack cont responsed");
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
        if (this.lO != null) {
            boolean a2 = a(socketResponsedMessage, this.lQ);
            b bVar = new b();
            bVar.lS = socketResponsedMessage;
            if (!a2) {
                bVar.lT = this.lQ;
            }
            this.lO.a(bVar);
        }
    }

    public static BdUniqueId ex() {
        return lN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        SocketResponsedMessage lS;
        e lT;

        b() {
        }
    }
}
