package com.baidu.searchbox.logsystem.logsys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class LogObject extends LogBaseObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCrashTAG;
    @Nullable
    public String mLogBasicData;
    @Nullable
    public File mLogBasicDataFile;
    public boolean mLogBasicDataOverflow;
    @Nullable
    public LogExtra mLogExtra;
    @Nullable
    public File mLogExtraPathNameKeeper;
    @NonNull
    public String mProcessName;

    public LogObject(@NonNull LogType logType, @NonNull String str, @Nullable String str2, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logType, str, str2, file, file2, logExtra, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProcessName = null;
        this.mLogBasicData = null;
        this.mLogBasicDataFile = null;
        this.mLogBasicDataOverflow = false;
        this.mLogExtraPathNameKeeper = null;
        this.mCrashTAG = null;
        if (LogType.NONE == logType && LLog.sDebug) {
            throw new RuntimeException("logType should not be LogType.NONE in LogObject instance.");
        }
        this.mLogType = logType;
        this.mProcessName = str;
        this.mLogBasicData = str2;
        if (file != null && file.exists() && file.isFile()) {
            this.mLogBasicDataFile = file;
        }
        if (file2 != null && file2.exists() && file2.isFile()) {
            this.mLogExtraPathNameKeeper = file2;
        }
        this.mLogExtra = logExtra;
        this.mCrashTAG = str3;
    }

    public String getCrashTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCrashTAG : (String) invokeV.objValue;
    }

    public String getLogBasicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLogBasicData : (String) invokeV.objValue;
    }

    public File getLogBasicDataFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLogBasicDataFile : (File) invokeV.objValue;
    }

    public boolean getLogBasicDataOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLogBasicDataOverflow : invokeV.booleanValue;
    }

    public LogExtra getLogExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLogExtra : (LogExtra) invokeV.objValue;
    }

    public File getLogExtraPathNameKeeper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLogExtraPathNameKeeper : (File) invokeV.objValue;
    }

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mProcessName : (String) invokeV.objValue;
    }

    public void setLogBasicData(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mLogBasicData = str;
        }
    }

    public void setLogBasicDataFile(@NonNull File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, file) == null) {
            this.mLogBasicDataFile = file;
        }
    }

    public void setLogBasicDataOverflow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mLogBasicDataOverflow = z;
        }
    }
}
