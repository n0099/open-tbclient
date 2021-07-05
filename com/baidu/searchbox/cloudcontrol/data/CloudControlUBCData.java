package com.baidu.searchbox.cloudcontrol.data;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudControlUBCData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_COUNT = "count";
    public static final String KEY_ITEMS = "items";
    public static final String TAG = "CloudControlUBCData";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject controlJsonObject;
    public String logId;
    public String mTraceId;
    public String runType;
    public JSONObject serviceJsonObject;

    public CloudControlUBCData() {
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
        this.serviceJsonObject = new JSONObject();
        this.controlJsonObject = new JSONObject();
    }

    public void collectDegradegInfo(int i2, int i3, int i4, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jSONArray}) == null) {
            try {
                this.controlJsonObject.put("count", i2 + "," + i3 + "," + i4);
                this.controlJsonObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "collectDegradegInfo is error" + e2.toString());
                }
            }
        }
    }

    public void collectServiceInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            this.serviceJsonObject = jSONObject;
        }
    }

    public JSONObject getControlJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.controlJsonObject : (JSONObject) invokeV.objValue;
    }

    public String getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.logId : (String) invokeV.objValue;
    }

    public String getRunType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.runType : (String) invokeV.objValue;
    }

    public JSONObject getServiceJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.serviceJsonObject : (JSONObject) invokeV.objValue;
    }

    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTraceId : (String) invokeV.objValue;
    }

    public void setLogId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.logId = str;
        }
    }

    public void setRunType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.runType = str;
        }
    }

    public void setTraceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mTraceId = str;
        }
    }
}
