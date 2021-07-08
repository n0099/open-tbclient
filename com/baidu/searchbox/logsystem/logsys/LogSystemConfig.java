package com.baidu.searchbox.logsystem.logsys;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
    @NonNull
    public Context mContext;
    @NonNull
    public LogDiskStoreConfig mLogDiskStoreConfig;
    @NonNull
    public LogUploadConfig mLogUploadConfig;

    /* renamed from: com.baidu.searchbox.logsystem.logsys.LogSystemConfig$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public Context mContext;
        @Nullable
        public LogDiskStoreConfig mLogDiskStoreConfig;
        @Nullable
        public LogUploadConfig mLogUploadConfig;

        public Builder(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        @NonNull
        private Builder setLogDiskStoreConfig(@Nullable LogDiskStoreConfig logDiskStoreConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, logDiskStoreConfig)) == null) {
                this.mLogDiskStoreConfig = logDiskStoreConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        private Builder setLogUploadNetworkConfig(@Nullable LogUploadConfig logUploadConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, logUploadConfig)) == null) {
                this.mLogUploadConfig = logUploadConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public LogSystemConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LogSystemConfig(this, null) : (LogSystemConfig) invokeV.objValue;
        }
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

    @NonNull
    public static Builder newBuilder(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
    }

    @NonNull
    public LogDiskStoreConfig getLogDiskStoreConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLogDiskStoreConfig : (LogDiskStoreConfig) invokeV.objValue;
    }

    @NonNull
    public LogUploadConfig getLogUploadNetworkConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLogUploadConfig : (LogUploadConfig) invokeV.objValue;
    }

    public LogSystemConfig(@NonNull Builder builder) {
        LogDiskStoreConfig logDiskStoreConfig;
        LogUploadConfig logUploadConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
