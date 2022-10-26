package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogUploadConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LogSystemConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public LogDiskStoreConfig mLogDiskStoreConfig;
    public LogUploadConfig mLogUploadConfig;

    /* renamed from: com.baidu.searchbox.logsystem.logsys.LogSystemConfig$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public LogDiskStoreConfig mLogDiskStoreConfig;
        public LogUploadConfig mLogUploadConfig;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        private Builder setLogDiskStoreConfig(LogDiskStoreConfig logDiskStoreConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, logDiskStoreConfig)) == null) {
                this.mLogDiskStoreConfig = logDiskStoreConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        private Builder setLogUploadNetworkConfig(LogUploadConfig logUploadConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, logUploadConfig)) == null) {
                this.mLogUploadConfig = logUploadConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public LogSystemConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new LogSystemConfig(this, null);
            }
            return (LogSystemConfig) invokeV.objValue;
        }
    }

    public LogSystemConfig(Builder builder) {
        LogDiskStoreConfig logDiskStoreConfig;
        LogUploadConfig logUploadConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = builder.mContext;
        if (builder.mLogDiskStoreConfig != null) {
            logDiskStoreConfig = builder.mLogDiskStoreConfig;
        } else {
            logDiskStoreConfig = new LogDiskStoreConfig.Builder(this.mContext).build();
        }
        this.mLogDiskStoreConfig = logDiskStoreConfig;
        if (builder.mLogUploadConfig != null) {
            logUploadConfig = builder.mLogUploadConfig;
        } else {
            logUploadConfig = new LogUploadConfig.Builder().build();
        }
        this.mLogUploadConfig = logUploadConfig;
    }

    public /* synthetic */ LogSystemConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            LogUploadConfig.init();
            LogDiskStoreConfig.init();
        }
    }

    public LogDiskStoreConfig getLogDiskStoreConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mLogDiskStoreConfig;
        }
        return (LogDiskStoreConfig) invokeV.objValue;
    }

    public LogUploadConfig getLogUploadNetworkConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mLogUploadConfig;
        }
        return (LogUploadConfig) invokeV.objValue;
    }

    public static Builder newBuilder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return new Builder(context);
        }
        return (Builder) invokeL.objValue;
    }
}
