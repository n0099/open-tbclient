package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.bean.Jsonable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ApsMessage<T extends Jsonable> implements Jsonable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JN_K_DATA = "data";
    public static final String JN_K_MSG = "msg";
    public static final String JN_K_STATUS = "status";
    public static final String JN_K_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public T data;
    public String msg;
    public int status;
    public int type;

    public ApsMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public T getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (T) invokeV.objValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.status = jSONObject.optInt("status");
                this.msg = jSONObject.optString("msg");
                this.type = jSONObject.optInt("type");
                parseData(jSONObject.optJSONObject("data"));
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean parseData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            this.data = t;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", this.status);
                    jSONObject.put("msg", this.msg);
                    jSONObject.put("type", this.type);
                    T data = getData();
                    if (data != null) {
                        jSONObject.put("data", data.toJson());
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return jSONObject;
                }
            } catch (Exception e4) {
                jSONObject = null;
                e2 = e4;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
