package com.baidu.searchbox.fluency.config;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0012J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "newBuilder", "()Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "", "isDebug", "Z", "()Z", "isDevEnv", "isFpsEnable", "", "timeSliceMs", "I", "getTimeSliceMs", "()I", "<init>", "()V", "builder", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;)V", "Builder", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class BdTracesConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isDebug;
    public final boolean isDevEnv;
    public final boolean isFpsEnable;
    public final int timeSliceMs;

    public BdTracesConfig(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.isFpsEnable = builder.isFpsEnable$lib_fps_release();
        this.isDebug = builder.isDebug$lib_fps_release();
        this.isDevEnv = builder.isDevEnv$lib_fps_release();
        this.timeSliceMs = builder.getTimeSliceMs$lib_fps_release();
    }

    public final int getTimeSliceMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.timeSliceMs : invokeV.intValue;
    }

    public final boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isDebug : invokeV.booleanValue;
    }

    public final boolean isDevEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isDevEnv : invokeV.booleanValue;
    }

    public final boolean isFpsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isFpsEnable : invokeV.booleanValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new Builder(this) : (Builder) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000B\u0011\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fB\u0007¢\u0006\u0004\b\u001e\u0010 J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "build", "()Lcom/baidu/searchbox/fluency/config/BdTracesConfig;", "", "isDebug", "debug", "(Z)Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "isDevEnv", "devEnv", "isFpsEnable", "fpsEnable", "", "timeSliceMs", "(I)Lcom/baidu/searchbox/fluency/config/BdTracesConfig$Builder;", "Z", "isDebug$lib_fps_release", "()Z", "setDebug$lib_fps_release", "(Z)V", "isDevEnv$lib_fps_release", "setDevEnv$lib_fps_release", "isFpsEnable$lib_fps_release", "setFpsEnable$lib_fps_release", "I", "getTimeSliceMs$lib_fps_release", "()I", "setTimeSliceMs$lib_fps_release", "(I)V", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "<init>", "(Lcom/baidu/searchbox/fluency/config/BdTracesConfig;)V", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isDebug;
        public boolean isDevEnv;
        public boolean isFpsEnable;
        public int timeSliceMs;

        public Builder() {
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
            this.timeSliceMs = 10000;
        }

        public final BdTracesConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new BdTracesConfig(this) : (BdTracesConfig) invokeV.objValue;
        }

        public final Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.isDebug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder devEnv(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.isDevEnv = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder fpsEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.isFpsEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final int getTimeSliceMs$lib_fps_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.timeSliceMs : invokeV.intValue;
        }

        public final boolean isDebug$lib_fps_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isDebug : invokeV.booleanValue;
        }

        public final boolean isDevEnv$lib_fps_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isDevEnv : invokeV.booleanValue;
        }

        public final boolean isFpsEnable$lib_fps_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isFpsEnable : invokeV.booleanValue;
        }

        public final void setDebug$lib_fps_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                this.isDebug = z;
            }
        }

        public final void setDevEnv$lib_fps_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.isDevEnv = z;
            }
        }

        public final void setFpsEnable$lib_fps_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.isFpsEnable = z;
            }
        }

        public final void setTimeSliceMs$lib_fps_release(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                this.timeSliceMs = i2;
            }
        }

        public final Builder timeSliceMs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.timeSliceMs = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(BdTracesConfig config) {
            this();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {config};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(config, "config");
            this.isFpsEnable = config.isFpsEnable();
            this.isDebug = config.isDebug();
            this.isDevEnv = config.isDevEnv();
            this.timeSliceMs = config.getTimeSliceMs();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTracesConfig() {
        this(new Builder());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
