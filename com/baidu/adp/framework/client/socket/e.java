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
    private SocketMessageTask IZ;
    private CoderException Jc;
    private SocketMessage Jd;
    private g Je;
    public long allDataReadTime;
    public long firstByteReachTime;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.Jd = null;
        this.Je = null;
        this.IZ = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.IZ = socketMessageTask;
        this.Jd = socketMessage;
        this.Je = gVar;
    }

    public int getMaxRetryCount() {
        int retry = this.IZ.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.Je != null && this.mIsValid) {
            this.Je.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.Je != null && this.mIsValid) {
            this.Je.b(this);
        }
    }

    private void reportSendFinish() {
        if (this.Je != null && this.mIsValid) {
            this.Je.c(this);
        }
    }

    private void reportSendStart() {
        if (this.Je != null && this.mIsValid) {
            this.Je.d(this);
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
        i.debug("SenderData", this.Jd.getCmd(), this.Jd.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.IZ.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.IZ.getTimeOut().getTimeOutAuto());
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
        int cmd = this.Jd.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.Jd.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.debug("SenderData", cmd, this.Jd.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.IZ.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException kO() {
        return this.Jc;
    }

    public boolean isNeedAck() {
        return this.IZ.getNeedAck();
    }

    public int getPriority() {
        return this.IZ.getPriority();
    }

    public SocketMessage kP() {
        return this.Jd;
    }

    public SocketMessageTask kQ() {
        return this.IZ;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.Jc = null;
        com.baidu.adp.framework.client.socket.coder.b kT = com.baidu.adp.framework.client.socket.coder.b.kT();
        this.mSequenceId = f.kR().getSequenceId();
        if (this.Jd != null) {
            this.Jd.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.Jd == null ? -1L : this.Jd.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.Jd == null ? -1 : this.Jd.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return kT.a(this.Jd, this.mSequenceId, this.IZ.getNeedCompress(), this.IZ.getNeedEncrypt());
        } catch (CoderException e) {
            this.Jc = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.Jd != null) {
            return this.Jd.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.IZ.isCanRetry();
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
