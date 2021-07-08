package com.baidu.down.loopj.android.http;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.MultiSrcTaskMsg;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MultiSrcAsyncHttpRequest extends AsyncHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int NOTIFY_TIME_INTERVAL = 100;
    public static final String TAG = "MultiSrcAsyncHttpRequest";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSrcAsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler, String str, MultiSrcRequestParams multiSrcRequestParams) {
        super(iCommonRequestHandler, asyncHttpResponseHandler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iCommonRequestHandler, asyncHttpResponseHandler, str, multiSrcRequestParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ICommonRequestHandler) objArr2[0], (AsyncHttpResponseHandler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSegBeginPos : invokeV.longValue;
    }

    public long getSegEndPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSegEndPos : invokeV.longValue;
    }

    public boolean isTestSpeedRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsTestSpeedRequest : invokeV.booleanValue;
    }

    public boolean requestIsRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRequestIsRunning : invokeV.booleanValue;
    }

    public void resetHttpRequestData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mRequestUrl = str;
            this.mRequestStartTime = SystemClock.elapsedRealtime();
            this.mRequestLastNotifyTimes = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpRequest, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mRequestStartTime = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public void setSegBeginPos(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mSegBeginPos = j;
        }
    }

    public void setSegEndPos(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.mSegEndPos = j;
        }
    }

    public void setTestSpeedRequest(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bool) == null) {
            this.mIsTestSpeedRequest = bool.booleanValue();
        }
    }

    public void stopRequestRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mRequestIsRunning = false;
        }
    }

    public void updateAverageSpeed(MultiSrcBinaryReqTask multiSrcBinaryReqTask, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{multiSrcBinaryReqTask, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
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
}
