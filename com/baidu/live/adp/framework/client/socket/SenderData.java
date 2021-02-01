package com.baidu.live.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.live.adp.framework.client.socket.coder.CoderException;
import com.baidu.live.adp.framework.client.socket.coder.CoderManager;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.websocket.IWebSocketDataGenerator;
import java.security.InvalidParameterException;
/* loaded from: classes11.dex */
public class SenderData extends IWebSocketDataGenerator {
    private static final String MODULE_NAME = "SenderData";
    private static Handler sHandler = new Handler();
    public long allDataReadTime;
    public long firstByteReachTime;
    private SocketMessage mMessage;
    private SocketClient mMessageQueueManager;
    private CoderException mSocketDataError;
    private SocketMessageTask mTask;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public SenderData(SocketMessage socketMessage, SocketMessageTask socketMessageTask, SocketClient socketClient) {
        this.mMessage = null;
        this.mMessageQueueManager = null;
        this.mTask = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.mTask = socketMessageTask;
        this.mMessage = socketMessage;
        this.mMessageQueueManager = socketClient;
    }

    public int getMaxRetryCount() {
        int retry = this.mTask.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.mMessageQueueManager != null && this.mIsValid) {
            this.mMessageQueueManager.onSendError(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.mMessageQueueManager != null && this.mIsValid) {
            this.mMessageQueueManager.onSendTimeOut(this);
        }
    }

    private void reportSendFinish() {
        if (this.mMessageQueueManager != null && this.mIsValid) {
            this.mMessageQueueManager.onSendFinish(this);
        }
    }

    private void reportSendStart() {
        if (this.mMessageQueueManager != null && this.mIsValid) {
            this.mMessageQueueManager.onSendStart(this);
        }
    }

    private Runnable getTimeOutChecker() {
        if (this.mTimeOutChecker == null) {
            this.mTimeOutChecker = new Runnable() { // from class: com.baidu.live.adp.framework.client.socket.SenderData.1
                @Override // java.lang.Runnable
                public void run() {
                    SenderData.this.reportSendTimeOut();
                }
            };
        }
        return this.mTimeOutChecker;
    }

    public void clearTimeOutTimer() {
        sHandler.removeCallbacks(getTimeOutChecker());
    }

    public void onRemove() {
        clearTimeOutTimer();
        this.mIsValid = false;
    }

    public long getStartSendTime() {
        return this.mStartSendTime;
    }

    @Override // com.baidu.live.adp.lib.websocket.WebSocketSendListener
    public void onStartSend() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        SocketLog.debug(MODULE_NAME, this.mMessage.getCmd(), this.mMessage.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.mTask.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.mTask.getTimeOut().getTimeOutAuto());
        }
        reportSendStart();
    }

    @Override // com.baidu.live.adp.lib.websocket.WebSocketSendListener
    public void onSendError(int i) {
        sHandler.removeCallbacks(getTimeOutChecker());
        reportSendError(i);
    }

    @Override // com.baidu.live.adp.lib.websocket.WebSocketSendListener
    public void onFinishSend() {
        int i;
        int cmd = this.mMessage.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.mMessage.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        SocketLog.debug(MODULE_NAME, cmd, this.mMessage.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.mTask.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException getSocketErrorData() {
        return this.mSocketDataError;
    }

    public boolean isNeedAck() {
        return this.mTask.getNeedAck();
    }

    public boolean getCompressType() {
        return this.mTask.getNeedCompress();
    }

    public int getPriority() {
        return this.mTask.getPriority();
    }

    public SocketMessage getMessage() {
        return this.mMessage;
    }

    public SocketMessageTask getTask() {
        return this.mTask;
    }

    @Override // com.baidu.live.adp.lib.websocket.IWebSocketDataGenerator
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.mSocketDataError = null;
        CoderManager coderManager = CoderManager.getInstance();
        this.mSequenceId = SequenceManager.getInstance().getSequenceId();
        if (this.mMessage != null) {
            this.mMessage.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.mMessage == null ? -1L : this.mMessage.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.mMessage == null ? -1 : this.mMessage.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return coderManager.encode(this.mMessage, this.mSequenceId, this.mTask.getNeedCompress(), this.mTask.getNeedEncrypt());
        } catch (CoderException e) {
            this.mSocketDataError = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.mMessage != null) {
            return this.mMessage.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.mTask.isCanRetry();
    }

    public int getRetryConnectTimes() {
        return this.mRetryConnectTimes;
    }

    public int addRetryConnectTimes() {
        int i = this.mRetryConnectTimes + 1;
        this.mRetryConnectTimes = i;
        return i;
    }

    public int getRetrySendTimes() {
        return this.mRetrySendTimes;
    }

    public int addRetrySendTimes() {
        int i = this.mRetrySendTimes + 1;
        this.mRetrySendTimes = i;
        return i;
    }
}
