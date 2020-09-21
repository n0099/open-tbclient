package com.baidu.down.request.taskmanager;

import com.baidu.down.loopj.android.http.MultiSrcAsyncHttpRequest;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.task.ProgressInfo;
/* loaded from: classes14.dex */
public class MultiSrcTaskMsg {
    public ProgressInfo.Segment mSegment;
    public MultiSrcBinaryReqTask mTask;
    public long mTotalBytes;
    public long mTotalTimes;
    public String mUrl;
    public MultiSrcAsyncHttpRequest request;

    public void addAsyncRequest() {
        this.mTask.addAsyncRequest(this.mSegment);
    }

    public void cancelAsyncRequest() {
        this.mTask.cancelAsyncRequest(this.request);
    }

    public void updateAsyncRequestData() {
        this.mTask.updateAverageSpeed(this);
    }
}
