package com.baidu.live.adp.framework.client.socket;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.coder.CoderException;
import com.baidu.live.adp.framework.client.socket.coder.CoderHeaderInfo;
import com.baidu.live.adp.framework.client.socket.coder.CoderManager;
import com.baidu.live.adp.framework.client.socket.coder.CoderPackInfo;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
class MessageUnPackTask extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    private static final String MODULE_NAME = "unpacker";
    private static final BdUniqueId sTags = BdUniqueId.gen();
    private ISingleRunnableCallback mCallBack;
    private CoderPackInfo mData;
    private SenderData mSender;
    private int mSequenceId;
    private SocketMessageTask mTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ISingleRunnableCallback {
        void onReturnDataInUI(UnpackData unpackData);
    }

    public MessageUnPackTask(CoderPackInfo coderPackInfo, SenderData senderData, ISingleRunnableCallback iSingleRunnableCallback, int i) {
        this.mCallBack = null;
        this.mData = null;
        this.mSender = null;
        this.mSequenceId = 0;
        this.mTask = null;
        this.mData = coderPackInfo;
        this.mSender = senderData;
        this.mCallBack = iSingleRunnableCallback;
        this.mSequenceId = i;
        try {
            if (this.mSender != null) {
                this.mTask = this.mSender.getTask();
            }
            if (this.mTask == null) {
                this.mTask = (SocketMessageTask) MessageManager.getInstance().findTask(this.mData.headerInfo.getCommand());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        setTag(sTags);
        setPriority(4);
        if (this.mTask != null) {
            setKey(String.valueOf(this.mTask.getCmd()));
            setParallel(this.mTask.getParallel());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150 A[ADDED_TO_REGION] */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        CoderPackInfo coderPackInfo;
        SocketResponsedMessage socketResponsedMessage;
        long j;
        CoderPackInfo coderPackInfo2;
        SocketResponsedMessage socketResponsedMessage2;
        long j2;
        long j3;
        long currentTimeMillis;
        boolean lcsSwitchHttp;
        int i2;
        long currentTimeMillis2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        SocketMessage socketMessage;
        byte[] bArr;
        int i3 = 0;
        if (this.mData == null) {
            return null;
        }
        try {
            if (this.mSender == null) {
                j2 = 0;
            } else {
                j2 = this.mSender.firstByteReachTime;
            }
            if (this.mSender == null) {
                j3 = 0;
            } else {
                j3 = this.mSender.allDataReadTime;
            }
            currentTimeMillis = System.currentTimeMillis();
            i3 = this.mData.headerInfo.getCommand();
            lcsSwitchHttp = this.mData.headerInfo.getLcsSwitchHttp();
            i2 = this.mData.bodyLength;
            coderPackInfo2 = CoderManager.getInstance().decodeRaw(this.mData);
        } catch (CoderException e) {
            i = i3;
            coderPackInfo = null;
            socketResponsedMessage = null;
        }
        try {
            currentTimeMillis2 = System.currentTimeMillis();
            long j10 = 0;
            long j11 = 0;
            j4 = 0;
            long j12 = 0;
            if (this.mSender == null) {
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
                socketMessage = null;
            } else {
                SocketMessage message = this.mSender.getMessage();
                long startTime = message.getStartTime();
                long startSendTime = this.mSender.getStartSendTime();
                long j13 = startSendTime - startTime;
                long j14 = currentTimeMillis - startSendTime;
                if (j2 > 0) {
                    j10 = j2 - startSendTime;
                    if (j3 >= j2) {
                        j14 = j3 - startSendTime;
                        j11 = j3 - j2;
                        j12 = currentTimeMillis - j3;
                    }
                }
                j5 = j14;
                j6 = j13;
                j7 = j10;
                j4 = currentTimeMillis2 - currentTimeMillis;
                j9 = j12;
                j8 = j11;
                socketMessage = message;
            }
            byte[] bArr2 = null;
            if (coderPackInfo2.bodyOffset == 0 && coderPackInfo2.bodyLength == coderPackInfo2.body.length) {
                bArr = null;
            } else if (coderPackInfo2.bodyLength <= 0) {
                coderPackInfo2.body = null;
                bArr = null;
            } else {
                if (this.mData.headerInfo.getHasExtraData()) {
                    try {
                        short s = ByteBuffer.wrap(coderPackInfo2.body, coderPackInfo2.bodyOffset, CoderHeaderInfo.EXTRA_DATA_HEADER_LEN).getShort();
                        int i4 = CoderHeaderInfo.EXTRA_DATA_HEADER_LEN + s;
                        bArr2 = ByteBuffer.allocateDirect(s).put(coderPackInfo2.body, coderPackInfo2.bodyOffset + CoderHeaderInfo.EXTRA_DATA_HEADER_LEN, s).array();
                        coderPackInfo2.bodyOffset += i4;
                        coderPackInfo2.bodyLength -= i4;
                    } catch (Exception e2) {
                        throw new CoderException(SocketConfig.CODEC_UNPACK_EXTRA_DATA_FAILED);
                    }
                }
                coderPackInfo2.body = ByteBuffer.allocateDirect(coderPackInfo2.bodyLength).put(coderPackInfo2.body, coderPackInfo2.bodyOffset, coderPackInfo2.bodyLength).array();
                bArr = bArr2;
            }
            socketResponsedMessage2 = CoderManager.getInstance().decodeBody(i3, coderPackInfo2.body, socketMessage, this.mTask, lcsSwitchHttp);
        } catch (CoderException e3) {
            i = i3;
            coderPackInfo = coderPackInfo2;
            socketResponsedMessage = null;
            j = -100;
            if (this.mSender != null && this.mSender.getMessage() != null) {
                j = this.mSender.getMessage().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
            SocketLog.debug(MODULE_NAME, i, j, this.mSequenceId, "unpacktask", SocketConfig.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
            i3 = i;
            coderPackInfo2 = coderPackInfo;
            socketResponsedMessage2 = socketResponsedMessage;
            if (socketResponsedMessage2 != null) {
            }
            publishProgress(socketResponsedMessage2);
            if (socketResponsedMessage2 != null) {
                try {
                    socketResponsedMessage2.afterDispatchInBackGround(i3, coderPackInfo2.body);
                } catch (Exception e4) {
                    BdLog.e(e4.getMessage());
                }
            }
            return null;
        }
        try {
            if (socketResponsedMessage2 != null && bArr != null) {
                try {
                    socketResponsedMessage2.decodeExtraDataInBackGround(i3, bArr);
                } catch (Exception e5) {
                    throw new CoderException(SocketConfig.CODEC_UNPACK_EXTRA_DATA_FAILED);
                }
            }
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (socketResponsedMessage2 != null) {
                if (this.mSender != null && this.mData != null) {
                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.mSender.getStartSendTime());
                    socketResponsedMessage2.setRetry(this.mSender.getRetryConnectTimes());
                    socketResponsedMessage2.performanceData.mQueneTime = j6;
                    socketResponsedMessage2.performanceData.mNetRWTime = j5;
                    socketResponsedMessage2.performanceData.mFirstByteReachTime = j7;
                    socketResponsedMessage2.performanceData.mAllDataReadTime = j8;
                    socketResponsedMessage2.performanceData.mTaskWaitTime = j9;
                }
                socketResponsedMessage2.setDownSize(i2);
                socketResponsedMessage2.performanceData.mAnalysisTime = currentTimeMillis3;
                socketResponsedMessage2.performanceData.mCompressTime = j4;
                socketResponsedMessage2.sequenceID = this.mData.headerInfo.getSequenceID();
                try {
                    socketResponsedMessage2.beforeDispatchInBackGround(i3, coderPackInfo2.body);
                } catch (Exception e6) {
                    BdLog.e(e6.getMessage());
                }
            }
        } catch (CoderException e7) {
            i = i3;
            coderPackInfo = coderPackInfo2;
            socketResponsedMessage = socketResponsedMessage2;
            j = -100;
            if (this.mSender != null) {
                j = this.mSender.getMessage().getClientLogID();
            }
            BdStatisticsManager.getInstance().error("im", j, String.valueOf(this.mSequenceId), "cmd", Integer.valueOf(i), BdStatsConstant.SubType.SEQID, Integer.valueOf(this.mSequenceId));
            SocketLog.debug(MODULE_NAME, i, j, this.mSequenceId, "unpacktask", SocketConfig.CODEC_UNPACK_BODY_FAILED, "onBinaryMesssage decodebody error");
            i3 = i;
            coderPackInfo2 = coderPackInfo;
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
        if (socketResponsedMessage2 != null && coderPackInfo2 != null) {
            socketResponsedMessage2.afterDispatchInBackGround(i3, coderPackInfo2.body);
        }
        return null;
    }

    private boolean check(SocketResponsedMessage socketResponsedMessage, SenderData senderData) {
        if (this.mSequenceId != 0 && senderData != null && socketResponsedMessage == null) {
            SocketLog.debug(MODULE_NAME, senderData.getCmd(), senderData.getMessage() == null ? -1L : senderData.getMessage().getClientLogID(), this.mSequenceId, "checkresponsedMessage", SocketConfig.CODEC_UNPACK_EMPTY, "ack cont responsed");
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
            callback(socketResponsedMessageArr[0]);
        } else {
            callback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        callback(null);
    }

    private void callback(SocketResponsedMessage socketResponsedMessage) {
        if (this.mCallBack != null) {
            boolean check = check(socketResponsedMessage, this.mSender);
            UnpackData unpackData = new UnpackData();
            unpackData.mMessages = socketResponsedMessage;
            if (!check) {
                unpackData.mSenderData = this.mSender;
            }
            this.mCallBack.onReturnDataInUI(unpackData);
        }
    }

    public static BdUniqueId getTags() {
        return sTags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class UnpackData {
        SocketResponsedMessage mMessages;
        SenderData mSenderData;

        UnpackData() {
        }
    }
}
