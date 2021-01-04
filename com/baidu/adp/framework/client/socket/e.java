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
    private SocketMessageTask Jb;
    private CoderException Je;
    private SocketMessage Jf;
    private g Jg;
    public long allDataReadTime;
    public long firstByteReachTime;
    private volatile int mSequenceId = 0;
    private Runnable mTimeOutChecker = null;
    private boolean mIsValid = true;
    private int mRetrySendTimes = 0;
    private int mRetryConnectTimes = 0;
    private long mStartSendTime = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.Jf = null;
        this.Jg = null;
        this.Jb = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.Jb = socketMessageTask;
        this.Jf = socketMessage;
        this.Jg = gVar;
    }

    public int getMaxRetryCount() {
        int retry = this.Jb.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void reportSendError(int i) {
        if (this.Jg != null && this.mIsValid) {
            this.Jg.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSendTimeOut() {
        if (this.Jg != null && this.mIsValid) {
            this.Jg.b(this);
        }
    }

    private void reportSendFinish() {
        if (this.Jg != null && this.mIsValid) {
            this.Jg.c(this);
        }
    }

    private void reportSendStart() {
        if (this.Jg != null && this.mIsValid) {
            this.Jg.d(this);
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
        i.debug("SenderData", this.Jf.getCmd(), this.Jf.getClientLogID(), this.mSequenceId, "StartSend", 0, "SenderData: start send size = " + (getBinaryData() != null ? getBinaryData().length : 0));
        sHandler.removeCallbacks(getTimeOutChecker());
        if (this.Jb.getTimeOut() != null) {
            sHandler.postDelayed(getTimeOutChecker(), this.Jb.getTimeOut().getTimeOutAuto());
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
        int cmd = this.Jf.getCmd();
        if (getBinaryData() != null) {
            int length = getBinaryData().length;
            this.Jf.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.debug("SenderData", cmd, this.Jf.getClientLogID(), this.mSequenceId, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.Jb.getNeedAck()) {
            sHandler.removeCallbacks(getTimeOutChecker());
        }
        reportSendFinish();
    }

    public CoderException kO() {
        return this.Je;
    }

    public boolean isNeedAck() {
        return this.Jb.getNeedAck();
    }

    public int getPriority() {
        return this.Jb.getPriority();
    }

    public SocketMessage kP() {
        return this.Jf;
    }

    public SocketMessageTask kQ() {
        return this.Jb;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] genBinaryData() {
        if (this.mStartSendTime == 0) {
            this.mStartSendTime = System.currentTimeMillis();
        }
        this.Je = null;
        com.baidu.adp.framework.client.socket.coder.b kT = com.baidu.adp.framework.client.socket.coder.b.kT();
        this.mSequenceId = f.kR().getSequenceId();
        if (this.Jf != null) {
            this.Jf.setSquencedId(this.mSequenceId);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.Jf == null ? -1L : this.Jf.getClientLogID();
            String valueOf = String.valueOf(this.mSequenceId & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = "cmd";
            objArr[1] = Integer.valueOf(this.Jf == null ? -1 : this.Jf.getCmd());
            bdStatisticsManager.newDebug(BdStatsConstant.SubType.SEQID, clientLogID, valueOf, objArr);
        }
        try {
            return kT.a(this.Jf, this.mSequenceId, this.Jb.getNeedCompress(), this.Jb.getNeedEncrypt());
        } catch (CoderException e) {
            this.Je = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.Jf != null) {
            return this.Jf.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mSequenceId;
    }

    public boolean canRetry() {
        return this.Jb.isCanRetry();
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
