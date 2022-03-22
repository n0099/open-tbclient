package com.baidu.sapi2.dto.loginhistory;

import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LoginHistoryItem implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> actionTimes;
    public String bduss;

    public LoginHistoryItem() {
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
        this.actionTimes = new ArrayList<>();
    }

    public static JSONArray toJSONArray(List<LoginHistoryItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (LoginHistoryItem loginHistoryItem : list) {
                JSONObject jSONObject = loginHistoryItem.toJSONObject();
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject toJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bduss", this.bduss);
                jSONObject.put("times", new JSONArray((Collection) this.actionTimes));
                return jSONObject;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
