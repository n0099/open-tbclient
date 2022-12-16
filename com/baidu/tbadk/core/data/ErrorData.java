package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ErrorData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATA = "data";
    public static final String ERRMSG = "errmsg";
    public static final String ERRNO = "errno";
    public static final long serialVersionUID = -2582050549890612990L;
    public transient /* synthetic */ FieldHolder $fh;
    public int error_code;
    public String error_data;
    public String error_msg;

    public ErrorData() {
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
        this.error_code = -1;
        this.error_msg = null;
        this.error_data = null;
    }

    public int getError_code() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.error_code;
        }
        return invokeV.intValue;
    }

    public String getError_data() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.error_data;
        }
        return (String) invokeV.objValue;
    }

    public String getError_msg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.error_msg;
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setError_code(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.error_code = i;
        }
    }

    public void setError_data(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.error_data = str;
        }
    }

    public void setError_msg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.error_msg = str;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject == null) {
                this.error_code = jSONObject.optInt("error_code", 0);
                this.error_msg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                this.error_data = jSONObject.optString("error_data");
                if (jSONObject.has("errno")) {
                    this.error_code = jSONObject.optInt("errno", 0);
                }
                if (jSONObject.has("errmsg")) {
                    this.error_msg = jSONObject.optString("errmsg");
                }
                if (jSONObject.has("data")) {
                    this.error_data = jSONObject.optString("data");
                    return;
                }
                return;
            }
            this.error_code = optJSONObject.optInt("errno", 0);
            this.error_msg = optJSONObject.optString("errmsg");
            this.error_data = optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
