package com.baidu.minivideo.plugin.capture.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class RequestTask implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_COMPLETE = 6;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_CONNECT_ERROR = 2;
    public static final int STATUS_DOWNLOADING = 3;
    public static final int STATUS_DOWNLOAD_ERROR = 5;
    public static final int STATUS_NOT_DOWNLOAD = 0;
    public static final int STATUS_PAUSED = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public String downloadPerSize;
    public String id;
    public String image;
    public String name;
    public int progress;
    public String savePath;
    public int status;
    public String url;

    public RequestTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = "";
        this.id = "";
        this.image = "";
        this.url = "";
        this.downloadPerSize = "";
        this.status = 0;
    }

    public static RequestTask createDetailTask(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, str3, str4)) == null) {
            RequestTask requestTask = new RequestTask();
            requestTask.url = str4;
            requestTask.image = str3;
            requestTask.id = str;
            requestTask.name = str2;
            return requestTask;
        }
        return (RequestTask) invokeLLLL.objValue;
    }

    public static RequestTask createTaskWithUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            RequestTask requestTask = new RequestTask();
            requestTask.url = str;
            return requestTask;
        }
        return (RequestTask) invokeL.objValue;
    }

    public static RequestTask createTaskWithUrlAndCover(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            RequestTask requestTask = new RequestTask();
            requestTask.url = str2;
            requestTask.image = str;
            return requestTask;
        }
        return (RequestTask) invokeLL.objValue;
    }

    public String getDownloadPerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.downloadPerSize : (String) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public String getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.image : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.progress : invokeV.intValue;
    }

    public String getSavePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.savePath : (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.status : invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public void setDownloadPerSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.downloadPerSize = str;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.id = str;
        }
    }

    public void setImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.image = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.name = str;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.progress = i2;
        }
    }

    public void setSavePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.savePath = str;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.status = i2;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.url = str;
        }
    }
}
