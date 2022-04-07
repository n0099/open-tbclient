package com.baidu.livesdk.sdk.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMLikeData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appVersion;
    public int callFlag;
    public String cuid;
    public long num;
    public long roomId;
    public int sourceType;
    public long uid;
    public int version;

    public IMLikeData() {
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
        this.version = 1;
    }

    public String toJson() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", this.roomId);
            jSONObject.put("source_type", 0);
            jSONObject.put("uid", this.uid);
            jSONObject.put("number", this.num);
            jSONObject.put("app_version", this.appVersion);
            jSONObject.put("source_type", this.sourceType);
            jSONObject.put("caller_flag", this.callFlag);
            jSONObject.put("version", this.version);
            jSONObject.put("device_id", this.cuid);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
