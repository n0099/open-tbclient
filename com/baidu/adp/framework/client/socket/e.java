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
    private SocketMessageTask If;
    private CoderException Ii;
    private SocketMessage Ij;
    private g Ik;
    public long allDataReadTime;
    public long firstByteReachTime;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.Ij = null;
        this.Ik = null;
        this.If = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.If = socketMessageTask;
        this.Ij = socketMessage;
        this.Ik = gVar;
    }

    public int getMaxRetryCount() {
        int retry = this.If.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.Ik != null && this.mIsValid) {
            this.Ik.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.Ik != null && this.mIsValid) {
            this.Ik.b(this);
        }
    }

    private void reportSendFinish() {
        if (this.Ik != null && this.mIsValid) {
            this.Ik.c(this);
        }
    }

    private void reportSendStart() {
        if (this.Ik != null && this.mIsValid) {
            this.Ik.d(this);
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
        i.debug("SenderData", this.Ij.getCmd(), this.Ij.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.If.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.If.getTimeOut().getTimeOutAuto());
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
        int cmd = this.Ij.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.Ij.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.debug("SenderData", cmd, this.Ij.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.If.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException ln() {
        return this.Ii;
    }

    public boolean isNeedAck() {
        return this.If.getNeedAck();
    }

    public int getPriority() {
        return this.If.getPriority();
    }

    public SocketMessage lo() {
        return this.Ij;
    }

    public SocketMessageTask lp() {
        return this.If;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.Ii = null;
        com.baidu.adp.framework.client.socket.coder.b ls = com.baidu.adp.framework.client.socket.coder.b.ls();
        this.mSequenceId = f.lq().getSequenceId();
        if (this.Ij != null) {
            this.Ij.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.Ij == null ? -1L : this.Ij.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.Ij == null ? -1 : this.Ij.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return ls.a(this.Ij, this.mSequenceId, this.If.getNeedCompress(), this.If.getNeedEncrypt());
        } catch (CoderException e) {
            this.Ii = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.Ij != null) {
            return this.Ij.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.If.isCanRetry();
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
