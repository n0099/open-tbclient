package com.alipay.sdk.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, jSONObject2)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
                for (int i2 = 0; i2 < 2; i2++) {
                    JSONObject jSONObject4 = jSONObjectArr[i2];
                    if (jSONObject4 != null) {
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject3.put(next, jSONObject4.get(next));
                        }
                    }
                }
            } catch (JSONException e2) {
                c.a(e2);
            }
            return jSONObject3;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
