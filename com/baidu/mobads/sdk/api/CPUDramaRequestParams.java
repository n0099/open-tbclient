package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CPUDramaRequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mParameters;

    /* renamed from: com.baidu.mobads.sdk.api.CPUDramaRequestParams$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, Object> mExtras;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mExtras = new HashMap<>();
        }

        public CPUDramaRequestParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new CPUDramaRequestParams(this, null);
            }
            return (CPUDramaRequestParams) invokeV.objValue;
        }

        public Builder setAppSid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mExtras.put("appsid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mExtras.put("outerUid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDetailConfig(CPUDramaDetailConfig cPUDramaDetailConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cPUDramaDetailConfig)) == null) {
                this.mExtras.put("dramaDetailConfig", cPUDramaDetailConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSubChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mExtras.put("subChannelId", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTimeOut(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.mExtras.put("timeout", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addExtra(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.mExtras.put(str, str2);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    public CPUDramaRequestParams(Builder builder) {
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
        this.mParameters = new HashMap<>();
        if (builder != null && builder.mExtras != null) {
            this.mParameters = builder.mExtras;
        }
    }

    public /* synthetic */ CPUDramaRequestParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public HashMap<String, Object> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mParameters;
        }
        return (HashMap) invokeV.objValue;
    }
}
