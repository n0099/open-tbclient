package com.baidu.minivideo.plugin.capture.download.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DownloadStatus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_CANCELED = 107;
    public static final int STATUS_COMPLETED = 105;
    public static final int STATUS_CONNECTED = 103;
    public static final int STATUS_CONNECTING = 102;
    public static final int STATUS_FAILED = 108;
    public static final int STATUS_PAUSED = 106;
    public static final int STATUS_PROGRESS = 104;
    public static final int STATUS_STARTED = 101;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean acceptRanges;
    public DownloadCallback callBack;
    public boolean calledCompleted;
    public DownloadException exception;
    public long finished;
    public long length;
    public int percent;
    public String savedPath;
    public int status;
    public long time;

    public DownloadStatus() {
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

    public DownloadCallback getCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callBack : (DownloadCallback) invokeV.objValue;
    }

    public boolean getCalledCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.calledCompleted : invokeV.booleanValue;
    }

    public Exception getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.exception : (Exception) invokeV.objValue;
    }

    public long getFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.finished : invokeV.longValue;
    }

    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.length : invokeV.longValue;
    }

    public int getPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.percent : invokeV.intValue;
    }

    public String getSavedPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.savedPath : (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.status : invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.time : invokeV.longValue;
    }

    public boolean isAcceptRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.acceptRanges : invokeV.booleanValue;
    }

    public void setAcceptRanges(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.acceptRanges = z;
        }
    }

    public void setCallBack(DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadCallback) == null) {
            this.callBack = downloadCallback;
        }
    }

    public void setCalledCompleted(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.calledCompleted = z;
        }
    }

    public void setException(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadException) == null) {
            this.exception = downloadException;
        }
    }

    public void setFinished(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.finished = j;
        }
    }

    public void setLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.length = j;
        }
    }

    public void setPercent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.percent = i2;
        }
    }

    public void setSavedPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.savedPath = str;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.status = i2;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.time = j;
        }
    }
}
