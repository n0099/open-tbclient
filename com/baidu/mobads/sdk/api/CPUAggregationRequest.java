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
public class CPUAggregationRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mParameters;

    /* renamed from: com.baidu.mobads.sdk.api.CPUAggregationRequest$1  reason: invalid class name */
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

        public CPUAggregationRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new CPUAggregationRequest(this, null);
            }
            return (CPUAggregationRequest) invokeV.objValue;
        }

        public Builder setAccessType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.mExtras.put("accessType", Integer.valueOf(i));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setCity(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mExtras.put("city", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mExtras.put("outerUid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLpDarkMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                if (z) {
                    this.mExtras.put("preferscolortheme", "dark");
                } else {
                    this.mExtras.put("preferscolortheme", "light");
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cpuLpFontSize)) == null) {
                this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSubChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mExtras.put("subChannelId", str);
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

    public CPUAggregationRequest(Builder builder) {
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

    public /* synthetic */ CPUAggregationRequest(Builder builder, AnonymousClass1 anonymousClass1) {
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
