package com.baidu.searchbox.logsystem.logsys;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class LogPipelineSingleton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRASH_PAD_DIR = "crashpad";
    public static final String TAG = "LogPipelineSingleton";
    public static volatile LogPipelineSingleton sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public LogSystemConfig mLogSystemConfig;

    public LogPipelineSingleton(@NonNull LogSystemConfig logSystemConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logSystemConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLogSystemConfig = logSystemConfig;
    }

    @NonNull
    public static LogPipelineSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (LogPipelineSingleton.class) {
                    if (sInstance == null) {
                        initialize();
                    }
                }
            }
            return sInstance;
        }
        return (LogPipelineSingleton) invokeV.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            LogSystemConfig.init();
        }
    }

    public static synchronized void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (LogPipelineSingleton.class) {
                initialize(LogSystemConfig.newBuilder(AppRuntime.getAppContext()).build());
            }
        }
    }

    public static File obtainFileDirWithProcessName(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            File file = getInstance().getLogStoreDirSupplier().get();
            return TextUtils.isEmpty(str) ? file : new File(file, str.replace(":", "_"));
        }
        return (File) invokeL.objValue;
    }

    public File getCrashRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(getLogStoreDirSupplier().get(), CRASH_PAD_DIR) : (File) invokeV.objValue;
    }

    @NonNull
    public Supplier<File> getLogStoreDirSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLogSystemConfig.getLogDiskStoreConfig().getLogStoreRootDirSupplier() : (Supplier) invokeV.objValue;
    }

    @NonNull
    public File getProcessCrashpadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new File(getCrashRootDir(), CrashUtil.getCrashTAG()) : (File) invokeV.objValue;
    }

    @Nullable
    public File getProcessCrashpadDir(@NonNull CrashUtil.CrashTAG crashTAG) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, crashTAG)) == null) {
            String crashTAG2 = CrashUtil.CrashTAG.getCrashTAG(crashTAG);
            if (TextUtils.isEmpty(crashTAG2)) {
                return null;
            }
            return new File(getCrashRootDir(), crashTAG2);
        }
        return (File) invokeL.objValue;
    }

    public static synchronized void initialize(@NonNull LogSystemConfig logSystemConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, logSystemConfig) == null) {
            synchronized (LogPipelineSingleton.class) {
                sInstance = new LogPipelineSingleton(logSystemConfig);
            }
        }
    }

    @Nullable
    public File getProcessCrashpadDir(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            CrashUtil.CrashTAG crashTAG = CrashUtil.CrashTAG.getCrashTAG(str);
            if (crashTAG != null) {
                return getProcessCrashpadDir(crashTAG);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }
}
