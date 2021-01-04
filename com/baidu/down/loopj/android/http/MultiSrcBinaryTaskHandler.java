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
/* loaded from: classes15.dex */
public class MultiSrcBinaryTaskHandler extends BinaryReqTask.BinaryTaskHandler {
    private static final boolean DEBUG = false;
    public static final int MAX_STATICTIS_PAUSE = 3;
    private static final String TAG = "MultiSrcBinaryTaskHandler";
    private boolean isNeedMultiSrc;
    private boolean isNeedTestSpeed;
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

    @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i, AsyncHttpRequest asyncHttpRequest) throws IOException {
        ByteArrayInfo byteArrayInfo;
        int read;
        InputStream inputStream = iCommonRequestHandler.getInputStream();
        iCommonRequestHandler.getContentLength();
        MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = (MultiSrcAsyncHttpRequest) asyncHttpRequest;
        if (this.isNeedMultiSrc && j != 0) {
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
            byteArray.mFilePos = j;
            byteArray.mByteArrayLength = 0;
            this.mRunning = true;
            multiSrcAsyncHttpRequest.setSegBeginPos(j);
            long segEndByPos = this.mtask.mProgressInfo.getSegEndByPos(j);
            if (segEndByPos != 0) {
                multiSrcAsyncHttpRequest.setSegEndPos(segEndByPos);
            }
            int length = byteArray.mByteArray.length;
            byte[] bArr = new byte[length];
            while (this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning() && (read = inputStream.read(bArr)) != -1) {
                int i2 = length - byteArray.mByteArrayLength;
                int i3 = read <= i2 ? read : i2;
                if (byteArray.mByteArrayLength + i3 >= length) {
                    System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                    byteArray.mByteArrayLength += i3;
                    sendDownloadMessage(byteArray);
                    j += i3;
                    byteArrayInfo = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                    byteArrayInfo.mFilePos = j;
                    byteArrayInfo.mByteArrayLength = 0;
                } else {
                    System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                    byteArray.mByteArrayLength += i3;
                    j += i3;
                    byteArrayInfo = byteArray;
                }
                if (i3 < read) {
                    int i4 = read - i3;
                    System.arraycopy(bArr, i3, byteArrayInfo.mByteArray, byteArrayInfo.mByteArrayLength, i4);
                    byteArrayInfo.mByteArrayLength += i4;
                    j += i4;
                }
                if (this.isNeedMultiSrc && this.mTestSpeedStage == 1 && multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                    multiSrcAsyncHttpRequest.updateAverageSpeed((MultiSrcBinaryReqTask) this.mtask, j, read);
                }
                if (j > multiSrcAsyncHttpRequest.getSegEndPos()) {
                    break;
                }
                byteArray = byteArrayInfo;
            }
            byteArrayInfo = byteArray;
            if (this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning() && byteArrayInfo.mByteArrayLength > 0) {
                sendDownloadMessage(byteArrayInfo);
                if (this.isNeedMultiSrc && this.mTestSpeedStage == 1 && multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                    multiSrcAsyncHttpRequest.updateAverageSpeed((MultiSrcBinaryReqTask) this.mtask, j, byteArrayInfo.mByteArrayLength);
                }
            } else {
                TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArrayInfo);
            }
        }
        if (this.mRunning && ((MultiSrcAsyncHttpRequest) asyncHttpRequest).requestIsRunning()) {
            sendSuccessMessage(i, null, j);
        }
        if (this.mTrunked) {
            this.mRunning = false;
        }
        return j;
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
            ((MultiSrcAsyncHttpRequest) asyncHttpRequest).resetHttpRequestData(noMeasuredUrl);
            ((MultiSrcAsyncHttpRequest) asyncHttpRequest).setTestSpeedRequest(true);
        }
    }

    public boolean isNeedMultiSrc() {
        return this.isNeedMultiSrc;
    }

    public void multiSrcToNormal() {
        ((MultiSrcBinaryReqTask) this.mtask).multiSrcToNormal();
    }

    public boolean isNeedStat() {
        if (((MultiSrcBinaryReqTask) this.mtask).mPauseNum >= 3 || getTestSpeedStage() != 2) {
            return false;
        }
        ((MultiSrcBinaryReqTask) this.mtask).mPauseNum++;
        return true;
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

    public boolean isNeedTestSpeed() {
        return this.isNeedTestSpeed;
    }

    public void cleanData() {
        this.isNeedMultiSrc = true;
        this.mTestSpeedStartTime = 0L;
        this.mTestSpeedStage = 0;
        this.isNeedTestSpeed = true;
        this.mMultiSrcStatData = new MultiSrcStatData();
    }

    public void setHttpDNSInfoStatus(String str, int i) {
        ((MultiSrcBinaryReqTask) this.mtask).setHttpDNSInfoStatus(str, i);
    }

    public void updateStatCstatus(int i) {
        this.mMultiSrcStatData.dyuse = i;
    }

    public boolean isReTryDownloadInfo() {
        switch (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType) {
            case 1:
                return isReTryHttpDNSInfo() || isDownInfoNeedRequest();
            default:
                return false;
        }
    }

    public boolean isReTryHttpDNSInfo() {
        String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mtask.mContext);
        return this.isNeedMultiSrc && this.mTestSpeedStage == 2 && !TextUtils.isEmpty(wifiOr2gOr3G) && !this.mMultiSrcStatData.network.equals(wifiOr2gOr3G) && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo() == null;
    }

    public boolean isDownInfoNeedRequest() {
        return ((MultiSrcBinaryReqTask) this.mtask).isDownInfoNeedRequest();
    }

    public void retryDownloadInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        switch (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType) {
            case 1:
                ((MultiSrcBinaryReqTask) this.mtask).retryServerInfo(onFetchDataRequestListener);
                return;
            default:
                return;
        }
    }
}
