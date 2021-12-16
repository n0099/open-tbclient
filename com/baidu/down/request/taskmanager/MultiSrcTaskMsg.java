package com.baidu.down.request.taskmanager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.MultiSrcAsyncHttpRequest;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class MultiSrcTaskMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressInfo.Segment mSegment;
    public MultiSrcBinaryReqTask mTask;
    public long mTotalBytes;
    public long mTotalTimes;
    public String mUrl;
    public MultiSrcAsyncHttpRequest request;

    public MultiSrcTaskMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void addAsyncRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTask.addAsyncRequest(this.mSegment);
        }
    }

    public void cancelAsyncRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTask.cancelAsyncRequest(this.request);
        }
    }

    public void updateAsyncRequestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTask.updateAverageSpeed(this);
        }
    }
}
