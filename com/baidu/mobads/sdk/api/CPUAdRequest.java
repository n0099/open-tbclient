package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CPUAdRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeCPUAd";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mParameters;

    /* renamed from: com.baidu.mobads.sdk.api.CPUAdRequest$1  reason: invalid class name */
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

        public CPUAdRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new CPUAdRequest(this, null);
            }
            return (CPUAdRequest) invokeV.objValue;
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

        public Builder setBarType(CpuLpActionBar cpuLpActionBar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cpuLpActionBar)) == null) {
                this.mExtras.put("customizedBar", cpuLpActionBar.getVlaue());
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCityIfLocalChannel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mExtras.put("listScene", 6);
                this.mExtras.put("city", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mExtras.put("outerUid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDownloadAppConfirmPolicy(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.mExtras.put("downloadAppConfirmPolicy", Integer.valueOf(i));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setKeyWords(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mExtras.put("keywords", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setListScene(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.mExtras.put("listScene", Integer.valueOf(i));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLpDarkMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cpuLpFontSize)) == null) {
                this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSubChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
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

    public CPUAdRequest(Builder builder) {
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

    public /* synthetic */ CPUAdRequest(Builder builder, AnonymousClass1 anonymousClass1) {
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
