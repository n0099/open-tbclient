package com.baidu.down.loopj.android.http;

import android.os.SystemClock;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.MultiSrcTaskMsg;
import com.baidu.down.request.taskmanager.TaskFacade;
/* loaded from: classes4.dex */
public class MultiSrcAsyncHttpRequest extends AsyncHttpRequest {
    private static final boolean DEBUG = false;
    private static final int NOTIFY_TIME_INTERVAL = 100;
    private static final String TAG = "MultiSrcAsyncHttpRequest";
    public long mAverageSpeed;
    public long mCurFilePos;
    private boolean mIsTestSpeedRequest;
    public long mRequestBytes;
    private boolean mRequestIsRunning;
    public long mRequestLastNotifyTimes;
    public long mRequestStartTime;
    public String mRequestUrl;
    private long mSegBeginPos;
    private long mSegEndPos;

    public MultiSrcAsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler, String str, MultiSrcRequestParams multiSrcRequestParams) {
        super(iCommonRequestHandler, asyncHttpResponseHandler);
        this.mRequestBytes = 0L;
        this.mRequestIsRunning = true;
        this.mSegEndPos = 2147483647L;
        this.mIsTestSpeedRequest = false;
        this.mRequestLastNotifyTimes = 0L;
        this.mRequestUrl = str;
        this.mIsTestSpeedRequest = ((BinaryHttpResponseHandler) asyncHttpResponseHandler).getTestSpeedStage() == 1;
        this.mCurFilePos = multiSrcRequestParams.mSegBeginPos;
        this.mSegBeginPos = multiSrcRequestParams.mSegBeginPos;
        this.mSegEndPos = multiSrcRequestParams.mSegEndPos;
    }

    public void updateAverageSpeed(MultiSrcBinaryReqTask multiSrcBinaryReqTask, long j, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mCurFilePos = j;
        this.mRequestBytes += i;
        this.mAverageSpeed = (this.mRequestBytes * 1000) / (elapsedRealtime - this.mRequestStartTime);
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

    @Override // com.baidu.down.loopj.android.http.AsyncHttpRequest, java.lang.Runnable
    public void run() {
        this.mRequestStartTime = SystemClock.elapsedRealtime();
        super.run();
    }

    public void stopRequestRunning() {
        this.mRequestIsRunning = false;
    }

    public boolean requestIsRunning() {
        return this.mRequestIsRunning;
    }

    public void resetHttpRequestData(String str) {
        this.mRequestUrl = str;
        this.mRequestStartTime = SystemClock.elapsedRealtime();
        this.mRequestLastNotifyTimes = SystemClock.elapsedRealtime();
    }

    public long getSegEndPos() {
        return this.mSegEndPos;
    }

    public void setSegEndPos(long j) {
        this.mSegEndPos = j;
    }

    public long getSegBeginPos() {
        return this.mSegBeginPos;
    }

    public void setSegBeginPos(long j) {
        this.mSegBeginPos = j;
    }

    public boolean isTestSpeedRequest() {
        return this.mIsTestSpeedRequest;
    }

    public void setTestSpeedRequest(Boolean bool) {
        this.mIsTestSpeedRequest = bool.booleanValue();
    }
}
