package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler sHandler = new Handler();
    private SocketMessageTask HA;
    private CoderException HD;
    private SocketMessage HE;
    private g HF;
    public long allDataReadTime;
    public long firstByteReachTime;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.HE = null;
        this.HF = null;
        this.HA = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.HA = socketMessageTask;
        this.HE = socketMessage;
        this.HF = gVar;
    }

    public int getMaxRetryCount() {
        int retry = this.HA.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.HF != null && this.mIsValid) {
            this.HF.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.HF != null && this.mIsValid) {
            this.HF.b(this);
        }
    }

    private void reportSendFinish() {
        if (this.HF != null && this.mIsValid) {
            this.HF.c(this);
        }
    }

    private void reportSendStart() {
        if (this.HF != null && this.mIsValid) {
            this.HF.d(this);
        }
    }

    private Runnable getTimeOutChecker() {
        if (this.mTimeOutChecker == null) {
            this.mTimeOutChecker = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.reportSendTimeOut();
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

    @Override // com.baidu.adp.lib.webSocket.n
    public void onStartSend() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        i.debug("SenderData", this.HE.getCmd(), this.HE.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.HA.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.HA.getTimeOut().getTimeOutAuto());
        }
        reportSendStart();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void onSendError(int i) {
        sHandler.removeCallbacks(getTimeOutChecker());
        reportSendError(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void onFinishSend() {
        int i;
        int cmd = this.HE.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.HE.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.debug("SenderData", cmd, this.HE.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.HA.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException jO() {
        return this.HD;
    }

    public boolean isNeedAck() {
        return this.HA.getNeedAck();
    }

    public int getPriority() {
        return this.HA.getPriority();
    }

    public SocketMessage jP() {
        return this.HE;
    }

    public SocketMessageTask jQ() {
        return this.HA;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.HD = null;
        com.baidu.adp.framework.client.socket.coder.b jT = com.baidu.adp.framework.client.socket.coder.b.jT();
        this.mSequenceId = f.jR().getSequenceId();
        if (this.HE != null) {
            this.HE.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.HE == null ? -1L : this.HE.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.HE == null ? -1 : this.HE.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return jT.a(this.HE, this.mSequenceId, this.HA.getNeedCompress(), this.HA.getNeedEncrypt());
        } catch (CoderException e) {
            this.HD = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.HE != null) {
            return this.HE.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.HA.isCanRetry();
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
