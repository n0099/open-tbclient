package com.baidu.searchbox.anr.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ANRInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAllStackTracePath;
    public String mCurrentPage;
    public String mLogId;
    public String mLogcatPath;
    public String mStackTrace;
    public String mTimeStamp;
    public String mTracesPath;
    public LinkedList<TrackUI> mTrackUIs;
    public String mType;

    public ANRInfo(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = "anr";
        this.mTimeStamp = str;
        this.mStackTrace = str2;
        this.mLogcatPath = str3;
        this.mTracesPath = str4;
        this.mAllStackTracePath = str5;
    }

    public String getAllStackTracePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAllStackTracePath;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurrentPage;
        }
        return (String) invokeV.objValue;
    }

    public String getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mLogId;
        }
        return (String) invokeV.objValue;
    }

    public String getLogcatPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLogcatPath;
        }
        return (String) invokeV.objValue;
    }

    public String getStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mStackTrace;
        }
        return (String) invokeV.objValue;
    }

    public String getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTimeStamp;
        }
        return (String) invokeV.objValue;
    }

    public String getTracesPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mTracesPath;
        }
        return (String) invokeV.objValue;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mTrackUIs;
        }
        return (LinkedList) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public void setAllStackTracePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mAllStackTracePath = str;
        }
    }

    public void setCurrentPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mCurrentPage = str;
        }
    }

    public void setLogId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mLogId = str;
        }
    }

    public void setLogcatPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mLogcatPath = str;
        }
    }

    public void setStackTrace(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mStackTrace = str;
        }
    }

    public void setTimeStamp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mTimeStamp = str;
        }
    }

    public void setTracesPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mTracesPath = str;
        }
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, linkedList) == null) {
            this.mTrackUIs = linkedList;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mType = str;
        }
    }
}
