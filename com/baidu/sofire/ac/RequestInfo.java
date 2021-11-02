package com.baidu.sofire.ac;

import com.baidu.sofire.utility.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RequestInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject data;
    public String path;
    public String sKey;
    public String xDeviceId;

    public RequestInfo(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sKey = str;
        this.xDeviceId = str2;
        this.data = jSONObject;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return "RequestInfo{sKey='" + this.sKey + ExtendedMessageFormat.QUOTE + ", xDeviceId='" + this.xDeviceId + ExtendedMessageFormat.QUOTE + ", data=" + this.data + ", path='" + this.path + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public RequestInfo(String str, String str2, JSONObject jSONObject, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, jSONObject, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sKey = str;
        this.xDeviceId = str2;
        this.data = jSONObject;
        this.path = str3;
    }
}
