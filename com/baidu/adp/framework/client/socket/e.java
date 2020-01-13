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
    public long allDataReadTime;
    public long firstByteReachTime;
    private SocketMessageTask nJ;
    private CoderException nM;
    private SocketMessage nN;
    private g nO;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.nN = null;
        this.nO = null;
        this.nJ = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.nJ = socketMessageTask;
        this.nN = socketMessage;
        this.nO = gVar;
    }

    public int getMaxRetryCount() {
        int retry = this.nJ.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.nO != null && this.mIsValid) {
            this.nO.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.nO != null && this.mIsValid) {
            this.nO.b(this);
        }
    }

    private void reportSendFinish() {
        if (this.nO != null && this.mIsValid) {
            this.nO.c(this);
        }
    }

    private void reportSendStart() {
        if (this.nO != null && this.mIsValid) {
            this.nO.d(this);
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
        i.debug("SenderData", this.nN.getCmd(), this.nN.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.nJ.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.nJ.getTimeOut().getTimeOutAuto());
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
        int cmd = this.nN.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.nN.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.debug("SenderData", cmd, this.nN.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.nJ.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException eS() {
        return this.nM;
    }

    public boolean isNeedAck() {
        return this.nJ.getNeedAck();
    }

    public int getPriority() {
        return this.nJ.getPriority();
    }

    public SocketMessage eT() {
        return this.nN;
    }

    public SocketMessageTask eU() {
        return this.nJ;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.nM = null;
        com.baidu.adp.framework.client.socket.coder.b eX = com.baidu.adp.framework.client.socket.coder.b.eX();
        this.mSequenceId = f.eV().getSequenceId();
        if (this.nN != null) {
            this.nN.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.nN == null ? -1L : this.nN.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.nN == null ? -1 : this.nN.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return eX.a(this.nN, this.mSequenceId, this.nJ.getNeedCompress(), this.nJ.getNeedEncrypt());
        } catch (CoderException e) {
            this.nM = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.nN != null) {
            return this.nN.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.nJ.isCanRetry();
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
