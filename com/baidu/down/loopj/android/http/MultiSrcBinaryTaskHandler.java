package com.baidu.down.loopj.android.http;

import android.text.TextUtils;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.statistic.MultiSrcStatData;
import com.baidu.down.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class MultiSrcBinaryTaskHandler extends BinaryReqTask.BinaryTaskHandler {
    public static final boolean DEBUG = false;
    public static final int MAX_STATICTIS_PAUSE = 3;
    public static final String TAG = "MultiSrcBinaryTaskHandler";
    public boolean isNeedMultiSrc;
    public boolean isNeedTestSpeed;
    public MultiSrcStatData mMultiSrcStatData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSrcBinaryTaskHandler(BinaryReqTask binaryReqTask) {
        super();
        binaryReqTask.getClass();
        this.isNeedMultiSrc = true;
        this.isNeedTestSpeed = true;
        this.mMultiSrcStatData = new MultiSrcStatData();
        this.mMultiSrcStatData = new MultiSrcStatData();
    }

    public void cleanData() {
        this.isNeedMultiSrc = true;
        this.mTestSpeedStartTime = 0L;
        this.mTestSpeedStage = 0;
        this.isNeedTestSpeed = true;
        this.mMultiSrcStatData = new MultiSrcStatData();
    }

    public void handlerCDNRedirectUrl(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) {
        String noMeasuredUrl;
        setHttpDNSInfoStatus(iCommonRequestHandler.getUrl(), 3);
        if (this.mTestSpeedStage == 0) {
            noMeasuredUrl = ((MultiSrcBinaryReqTask) this.mtask).getNoMeasuredUrl(false);
        } else {
            noMeasuredUrl = ((MultiSrcBinaryReqTask) this.mtask).getNoMeasuredUrl(true);
        }
        if (iCommonRequestHandler.cloneRequest(noMeasuredUrl)) {
            ((MultiSrcAsyncHttpRequest) asyncHttpRequest).resetHttpRequestData(noMeasuredUrl);
        }
    }

    public void handlerReplaceUrl(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) {
        String noMeasuredUrl = ((MultiSrcBinaryReqTask) this.mtask).getNoMeasuredUrl(true);
        if (iCommonRequestHandler.cloneRequest(noMeasuredUrl)) {
            MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = (MultiSrcAsyncHttpRequest) asyncHttpRequest;
            multiSrcAsyncHttpRequest.resetHttpRequestData(noMeasuredUrl);
            multiSrcAsyncHttpRequest.setTestSpeedRequest(Boolean.TRUE);
        }
    }

    public boolean isDownInfoNeedRequest() {
        return ((MultiSrcBinaryReqTask) this.mtask).isDownInfoNeedRequest();
    }

    public boolean isNeedMultiSrc() {
        return this.isNeedMultiSrc;
    }

    public boolean isNeedStat() {
        if (((MultiSrcBinaryReqTask) this.mtask).mPauseNum >= 3 || getTestSpeedStage() != 2) {
            return false;
        }
        ((MultiSrcBinaryReqTask) this.mtask).mPauseNum++;
        return true;
    }

    public boolean isNeedTestSpeed() {
        return this.isNeedTestSpeed;
    }

    public boolean isReTryDownloadInfo() {
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType != 1) {
            return false;
        }
        return isReTryHttpDNSInfo() || isDownInfoNeedRequest();
    }

    public boolean isReTryHttpDNSInfo() {
        String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mtask.mContext);
        return this.isNeedMultiSrc && this.mTestSpeedStage == 2 && !TextUtils.isEmpty(wifiOr2gOr3G) && !this.mMultiSrcStatData.network.equals(wifiOr2gOr3G) && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo() == null;
    }

    public void multiSrcToNormal() {
        ((MultiSrcBinaryReqTask) this.mtask).multiSrcToNormal();
    }

    @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i, AsyncHttpRequest asyncHttpRequest) throws IOException {
        int read;
        long j2 = j;
        InputStream inputStream = iCommonRequestHandler.getInputStream();
        iCommonRequestHandler.getContentLength();
        MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = (MultiSrcAsyncHttpRequest) asyncHttpRequest;
        if (this.isNeedMultiSrc && j2 != 0) {
            if (!multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                ((MultiSrcBinaryReqTask) this.mtask).savePriorityDownloadIpConnectTime(multiSrcAsyncHttpRequest.mRequestUrl, multiSrcAsyncHttpRequest.mRequestConnectedTime);
            }
            HttpDNSInfo downloadIpInfo = ((MultiSrcBinaryReqTask) this.mtask).getDownloadIpInfo(multiSrcAsyncHttpRequest.mRequestUrl);
            if (downloadIpInfo != null) {
                downloadIpInfo.mIsWorking = 1;
            }
            this.mMultiSrcStatData.dbtype = -1;
        }
        setHttpDNSInfoStatus(multiSrcAsyncHttpRequest.mRequestUrl, 2);
        if (inputStream != null) {
            ByteArrayInfo byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
            byteArray.mFilePos = j2;
            byteArray.mByteArrayLength = 0;
            this.mRunning = true;
            multiSrcAsyncHttpRequest.setSegBeginPos(j2);
            long segEndByPos = this.mtask.mProgressInfo.getSegEndByPos(j2);
            if (segEndByPos != 0) {
                multiSrcAsyncHttpRequest.setSegEndPos(segEndByPos);
            }
            int length = byteArray.mByteArray.length;
            byte[] bArr = new byte[length];
            for (int i2 = -1; this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning() && (read = inputStream.read(bArr)) != i2; i2 = -1) {
                int i3 = length - byteArray.mByteArrayLength;
                if (read <= i3) {
                    i3 = read;
                }
                int i4 = byteArray.mByteArrayLength;
                if (i4 + i3 >= length) {
                    System.arraycopy(bArr, 0, byteArray.mByteArray, i4, i3);
                    byteArray.mByteArrayLength += i3;
                    sendDownloadMessage(byteArray);
                    j2 += i3;
                    byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                    byteArray.mFilePos = j2;
                    byteArray.mByteArrayLength = 0;
                } else {
                    System.arraycopy(bArr, 0, byteArray.mByteArray, i4, i3);
                    byteArray.mByteArrayLength += i3;
                    j2 += i3;
                }
                if (i3 < read) {
                    int i5 = read - i3;
                    System.arraycopy(bArr, i3, byteArray.mByteArray, byteArray.mByteArrayLength, i5);
                    byteArray.mByteArrayLength += i5;
                    j2 += i5;
                }
                if (this.isNeedMultiSrc && this.mTestSpeedStage == 1 && multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                    multiSrcAsyncHttpRequest.updateAverageSpeed((MultiSrcBinaryReqTask) this.mtask, j2, read);
                }
                if (j2 > multiSrcAsyncHttpRequest.getSegEndPos()) {
                    break;
                }
            }
            if (this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning() && byteArray.mByteArrayLength > 0) {
                sendDownloadMessage(byteArray);
                if (this.isNeedMultiSrc && this.mTestSpeedStage == 1 && multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                    multiSrcAsyncHttpRequest.updateAverageSpeed((MultiSrcBinaryReqTask) this.mtask, j2, byteArray.mByteArrayLength);
                }
            } else {
                TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArray);
            }
        }
        if (this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning()) {
            sendSuccessMessage(i, null, j2);
        }
        if (this.mTrunked) {
            this.mRunning = false;
        }
        return j2;
    }

    public void retryDownloadInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType != 1) {
            return;
        }
        ((MultiSrcBinaryReqTask) this.mtask).retryServerInfo(onFetchDataRequestListener);
    }

    public void setHttpDNSInfoStatus(String str, int i) {
        ((MultiSrcBinaryReqTask) this.mtask).setHttpDNSInfoStatus(str, i);
    }

    public void setNeedMultiSrc(boolean z) {
        this.isNeedMultiSrc = z;
    }

    public void setNeedTestSpeed(boolean z) {
        this.isNeedTestSpeed = z;
        if (z) {
            this.mTestSpeedStage = 0;
            return;
        }
        this.mTestSpeedStartTime = 0L;
        this.mTestSpeedStage = 2;
    }

    public void updateStatCstatus(int i) {
        this.mMultiSrcStatData.dyuse = i;
    }
}
