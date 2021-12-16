package com.baidu.minivideo.plugin.capture.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ErrorLogInfo implements Jsonable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String code;
    public String data;
    public boolean doReport;
    public boolean isShowSpecialToast;
    public String msg;
    public String name;
    public String specialToast;
    public int type;

    public ErrorLogInfo() {
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

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.type = jSONObject.getInt("type");
                this.doReport = jSONObject.getBoolean("doReport");
                this.name = jSONObject.getString("name");
                this.msg = jSONObject.getString("msg");
                this.data = jSONObject.getString("data");
                this.isShowSpecialToast = jSONObject.getBoolean("isShowSpecialToast");
                this.specialToast = jSONObject.getString("specialToast");
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void set(int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            this.type = i2;
            this.name = str;
            this.code = str2;
            this.msg = str3;
            this.data = str4;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", this.type);
                    jSONObject.put("doReport", this.doReport);
                    jSONObject.put("name", this.name);
                    jSONObject.put("code", this.code);
                    jSONObject.put("msg", this.msg);
                    jSONObject.put("data", this.data);
                    jSONObject.put("isShowSpecialToast", this.isShowSpecialToast);
                    jSONObject.put("specialToast", this.specialToast);
                } catch (JSONException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e4) {
                jSONObject = null;
                e2 = e4;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "type:" + this.type + "name:" + this.name + "code:" + this.code + "msg:" + this.msg + "data" + this.data + "doReport : " + this.doReport;
        }
        return (String) invokeV.objValue;
    }

    public ErrorLogInfo(int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        set(i2, str, str2, str3, str4);
    }

    public void set(int i2, String str, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, Boolean.valueOf(z)}) == null) {
            this.type = i2;
            this.name = str;
            this.code = str2;
            this.msg = str3;
            this.data = str4;
            this.doReport = z;
        }
    }
}
