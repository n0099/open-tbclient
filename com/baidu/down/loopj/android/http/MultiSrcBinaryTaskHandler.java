package com.baidu.down.loopj.android.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.BinaryReqTask;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.statistic.MultiSrcStatData;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class MultiSrcBinaryTaskHandler extends BinaryReqTask.BinaryTaskHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int MAX_STATICTIS_PAUSE = 3;
    public static final String TAG = "MultiSrcBinaryTaskHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedMultiSrc;
    public boolean isNeedTestSpeed;
    public MultiSrcStatData mMultiSrcStatData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSrcBinaryTaskHandler(BinaryReqTask binaryReqTask) {
        super(binaryReqTask);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryReqTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BinaryReqTask) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        binaryReqTask.getClass();
        this.isNeedMultiSrc = true;
        this.isNeedTestSpeed = true;
        this.mMultiSrcStatData = new MultiSrcStatData();
        this.mMultiSrcStatData = new MultiSrcStatData();
    }

    public void cleanData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isNeedMultiSrc = true;
            this.mTestSpeedStartTime = 0L;
            this.mTestSpeedStage = 0;
            this.isNeedTestSpeed = true;
            this.mMultiSrcStatData = new MultiSrcStatData();
        }
    }

    public void handlerCDNRedirectUrl(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) {
        String noMeasuredUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCommonRequestHandler, asyncHttpRequest) == null) {
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
    }

    public void handlerReplaceUrl(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, iCommonRequestHandler, asyncHttpRequest) == null) {
            String noMeasuredUrl = ((MultiSrcBinaryReqTask) this.mtask).getNoMeasuredUrl(true);
            if (iCommonRequestHandler.cloneRequest(noMeasuredUrl)) {
                MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = (MultiSrcAsyncHttpRequest) asyncHttpRequest;
                multiSrcAsyncHttpRequest.resetHttpRequestData(noMeasuredUrl);
                multiSrcAsyncHttpRequest.setTestSpeedRequest(Boolean.TRUE);
            }
        }
    }

    public boolean isDownInfoNeedRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((MultiSrcBinaryReqTask) this.mtask).isDownInfoNeedRequest() : invokeV.booleanValue;
    }

    public boolean isNeedMultiSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isNeedMultiSrc : invokeV.booleanValue;
    }

    public boolean isNeedStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (((MultiSrcBinaryReqTask) this.mtask).mPauseNum >= 3 || getTestSpeedStage() != 2) {
                return false;
            }
            ((MultiSrcBinaryReqTask) this.mtask).mPauseNum++;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedTestSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isNeedTestSpeed : invokeV.booleanValue;
    }

    public boolean isReTryDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType != 1) {
                return false;
            }
            return isReTryHttpDNSInfo() || isDownInfoNeedRequest();
        }
        return invokeV.booleanValue;
    }

    public boolean isReTryHttpDNSInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mtask.mContext);
            return this.isNeedMultiSrc && this.mTestSpeedStage == 2 && !TextUtils.isEmpty(wifiOr2gOr3G) && !this.mMultiSrcStatData.network.equals(wifiOr2gOr3G) && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo() == null;
        }
        return invokeV.booleanValue;
    }

    public void multiSrcToNormal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ((MultiSrcBinaryReqTask) this.mtask).multiSrcToNormal();
        }
    }

    @Override // com.baidu.down.loopj.android.http.BinaryHttpResponseHandler
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i2, AsyncHttpRequest asyncHttpRequest) throws IOException {
        InterceptResult invokeCommon;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{iCommonRequestHandler, Long.valueOf(j), Integer.valueOf(i2), asyncHttpRequest})) == null) {
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
                for (int i3 = -1; this.mRunning && multiSrcAsyncHttpRequest.requestIsRunning() && (read = inputStream.read(bArr)) != i3; i3 = -1) {
                    int i4 = length - byteArray.mByteArrayLength;
                    if (read <= i4) {
                        i4 = read;
                    }
                    int i5 = byteArray.mByteArrayLength;
                    if (i5 + i4 >= length) {
                        System.arraycopy(bArr, 0, byteArray.mByteArray, i5, i4);
                        byteArray.mByteArrayLength += i4;
                        sendDownloadMessage(byteArray);
                        j2 += i4;
                        byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                        byteArray.mFilePos = j2;
                        byteArray.mByteArrayLength = 0;
                    } else {
                        System.arraycopy(bArr, 0, byteArray.mByteArray, i5, i4);
                        byteArray.mByteArrayLength += i4;
                        j2 += i4;
                    }
                    if (i4 < read) {
                        int i6 = read - i4;
                        System.arraycopy(bArr, i4, byteArray.mByteArray, byteArray.mByteArrayLength, i6);
                        byteArray.mByteArrayLength += i6;
                        j2 += i6;
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
                sendSuccessMessage(i2, null, j2);
            }
            if (this.mTrunked) {
                this.mRunning = false;
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public void retryDownloadInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, onFetchDataRequestListener) == null) && TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType == 1) {
            ((MultiSrcBinaryReqTask) this.mtask).retryServerInfo(onFetchDataRequestListener);
        }
    }

    public void setHttpDNSInfoStatus(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            ((MultiSrcBinaryReqTask) this.mtask).setHttpDNSInfoStatus(str, i2);
        }
    }

    public void setNeedMultiSrc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isNeedMultiSrc = z;
        }
    }

    public void setNeedTestSpeed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isNeedTestSpeed = z;
            if (z) {
                this.mTestSpeedStage = 0;
                return;
            }
            this.mTestSpeedStartTime = 0L;
            this.mTestSpeedStage = 2;
        }
    }

    public void updateStatCstatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mMultiSrcStatData.dyuse = i2;
        }
    }
}
