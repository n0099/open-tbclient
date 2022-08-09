package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ConfigRequestInfo extends CloudControlRequestInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG = "config";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigRequestInfo() {
        super("config", null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], objArr[1], (HashMap) objArr[2], objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setConfigModuleList(List<ConfigModule> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (ConfigModule configModule : list) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (ConfigAction configAction : configModule.getConfigActions()) {
                    jSONObject2.put(configAction.getAction(), configAction.getVersion());
                }
                jSONObject.put(configModule.getModule(), jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        setPostData(jSONObject);
    }
}
