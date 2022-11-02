package com.baidu.searchbox.cloudcontrol.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mCheckDatas;
    public CloudControlErrorBean mCloudControlErrorBean;
    public CloudControlUBCData mCloudControlUBCData;
    public HashMap<String, IProcessorDataInterceptor> mDataInterceptors;
    public HashMap<String, Boolean> mIsForceDispatchs;
    public JSONObject mOptionsData;
    public JSONObject mServiceDatas;

    public CloudControlData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public HashMap<String, Object> getCheckDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mCheckDatas == null) {
                this.mCheckDatas = new HashMap<>();
            }
            return this.mCheckDatas;
        }
        return (HashMap) invokeV.objValue;
    }

    public CloudControlErrorBean getCloudControlErrorBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCloudControlErrorBean;
        }
        return (CloudControlErrorBean) invokeV.objValue;
    }

    public CloudControlUBCData getCloudControlUBCData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mCloudControlUBCData == null) {
                this.mCloudControlUBCData = new CloudControlUBCData();
            }
            return this.mCloudControlUBCData;
        }
        return (CloudControlUBCData) invokeV.objValue;
    }

    public HashMap<String, IProcessorDataInterceptor> getDataInterceptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, IProcessorDataInterceptor> hashMap = this.mDataInterceptors;
            if (hashMap == null) {
                return new HashMap<>();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public HashMap<String, Boolean> getIsForceDispatchs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mIsForceDispatchs == null) {
                this.mIsForceDispatchs = new HashMap<>();
            }
            return this.mIsForceDispatchs;
        }
        return (HashMap) invokeV.objValue;
    }

    public JSONObject getOptionsData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mOptionsData;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getServiceData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mServiceDatas;
        }
        return (JSONObject) invokeV.objValue;
    }

    public CloudControlData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mServiceDatas = jSONObject;
    }

    public void setCheckDatas(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            this.mCheckDatas = hashMap;
        }
    }

    public void setCloudControlErrorBean(CloudControlErrorBean cloudControlErrorBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cloudControlErrorBean) == null) {
            this.mCloudControlErrorBean = cloudControlErrorBean;
        }
    }

    public void setCloudControlUBCData(CloudControlUBCData cloudControlUBCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cloudControlUBCData) == null) {
            this.mCloudControlUBCData = cloudControlUBCData;
        }
    }

    public void setDataInterceptor(HashMap<String, IProcessorDataInterceptor> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) {
            this.mDataInterceptors = hashMap;
        }
    }

    public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) {
            this.mIsForceDispatchs = hashMap;
        }
    }

    public void setOptionsData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.mOptionsData = jSONObject;
        }
    }

    public void setServiceData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            this.mServiceDatas = jSONObject;
        }
    }
}
