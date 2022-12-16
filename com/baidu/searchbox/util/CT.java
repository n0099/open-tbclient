package com.baidu.searchbox.util;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes3.dex */
public class CT {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CTV = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCtv;

    public CT() {
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
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int B64GetVersion = Base64Encoder.B64GetVersion();
            if (B64GetVersion == 0) {
                this.mCtv = "1";
                return;
            }
            this.mCtv = B64GetVersion + "";
        }
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCtv;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDefaultCtv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TextUtils.equals(this.mCtv, "1");
        }
        return invokeV.booleanValue;
    }
}
