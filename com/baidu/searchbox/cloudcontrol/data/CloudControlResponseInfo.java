package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CloudControlResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mCheckData;
    public CloudControlErrorBean mCloudControlErrorBean;
    public JSONObject mOption;
    public JSONObject mServiceData;
    public String mServiceName;

    public CloudControlResponseInfo(String str, JSONObject jSONObject, JSONObject jSONObject2, Object obj, CloudControlErrorBean cloudControlErrorBean) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, jSONObject2, obj, cloudControlErrorBean};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mServiceName = str;
        this.mServiceData = jSONObject;
        this.mOption = jSONObject2;
        this.mCheckData = obj;
        this.mCloudControlErrorBean = cloudControlErrorBean;
    }

    public Object getCheckData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCheckData : invokeV.objValue;
    }

    public CloudControlErrorBean getCloudControlErrorBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCloudControlErrorBean : (CloudControlErrorBean) invokeV.objValue;
    }

    public JSONObject getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOption : (JSONObject) invokeV.objValue;
    }

    public JSONObject getServiceData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mServiceData : (JSONObject) invokeV.objValue;
    }

    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mServiceName : (String) invokeV.objValue;
    }
}
