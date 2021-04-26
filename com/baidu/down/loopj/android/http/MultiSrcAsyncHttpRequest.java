package com.baidu.down.loopj.android.http;

import android.os.SystemClock;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.MultiSrcTaskMsg;
import com.baidu.down.request.taskmanager.TaskFacade;
/* loaded from: classes2.dex */
public class MultiSrcAsyncHttpRequest extends AsyncHttpRequest {
    public static final boolean DEBUG = false;
    public static final int NOTIFY_TIME_INTERVAL = 100;
    public static final String TAG = "MultiSrcAsyncHttpRequest";
    public long mAverageSpeed;
    public long mCurFilePos;
    public boolean mIsTestSpeedRequest;
    public long mRequestBytes;
    public boolean mRequestIsRunning;
    public long mRequestLastNotifyTimes;
    public long mRequestStartTime;
    public String mRequestUrl;
    public long mSegBeginPos;
    public long mSegEndPos;

    public MultiSrcAsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler, String str, MultiSrcRequestParams multiSrcRequestParams) {
        super(iCommonRequestHandler, asyncHttpResponseHandler);
        this.mRequestBytes = 0L;
        this.mRequestIsRunning = true;
        this.mSegEndPos = 2147483647L;
        this.mIsTestSpeedRequest = false;
        this.mRequestLastNotifyTimes = 0L;
        this.mRequestUrl = str;
        this.mIsTestSpeedRequest = ((BinaryHttpResponseHandler) asyncHttpResponseHandler).getTestSpeedStage() == 1;
        long j = multiSrcRequestParams.mSegBeginPos;
        this.mCurFilePos = j;
        this.mSegBeginPos = j;
        this.mSegEndPos = multiSrcRequestParams.mSegEndPos;
    }

    public long getSegBeginPos() {
        return this.mSegBeginPos;
    }

    public long getSegEndPos() {
        return this.mSegEndPos;
    }

    public boolean isTestSpeedRequest() {
        return this.mIsTestSpeedRequest;
    }

    public boolean requestIsRunning() {
        return this.mRequestIsRunning;
    }

    public void resetHttpRequestData(String str) {
        this.mRequestUrl = str;
        this.mRequestStartTime = SystemClock.elapsedRealtime();
        this.mRequestLastNotifyTimes = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpRequest, java.lang.Runnable
    public void run() {
        this.mRequestStartTime = SystemClock.elapsedRealtime();
        super.run();
    }

    public void setSegBeginPos(long j) {
        this.mSegBeginPos = j;
    }

    public void setSegEndPos(long j) {
        this.mSegEndPos = j;
    }

    public void setTestSpeedRequest(Boolean bool) {
        this.mIsTestSpeedRequest = bool.booleanValue();
    }

    public void stopRequestRunning() {
        this.mRequestIsRunning = false;
    }

    public void updateAverageSpeed(MultiSrcBinaryReqTask multiSrcBinaryReqTask, long j, int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mCurFilePos = j;
        long j2 = this.mRequestBytes + i2;
        this.mRequestBytes = j2;
        this.mAverageSpeed = (j2 * 1000) / (elapsedRealtime - this.mRequestStartTime);
        if (elapsedRealtime - this.mRequestLastNotifyTimes > 100) {
            this.mRequestLastNotifyTimes = SystemClock.elapsedRealtime();
            MultiSrcTaskMsg multiSrcTaskMsg = new MultiSrcTaskMsg();
            multiSrcTaskMsg.mTask = multiSrcBinaryReqTask;
            multiSrcTaskMsg.mUrl = this.mRequestUrl;
            multiSrcTaskMsg.mTotalBytes = this.mRequestBytes;
            multiSrcTaskMsg.mTotalTimes = (elapsedRealtime - this.mRequestStartTime) - this.mRequestConnectedTime;
            TaskFacade.getInstance(null).getBinaryTaskMng().sendMessage(8, multiSrcTaskMsg);
        }
    }
}
