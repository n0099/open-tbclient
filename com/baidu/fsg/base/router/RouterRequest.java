package com.baidu.fsg.base.router;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RouterRequest {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5255a = "RouterRequest";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f5256b;

    /* renamed from: c  reason: collision with root package name */
    public String f5257c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f5258d;

    public RouterRequest() {
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
        this.f5256b = "";
        this.f5257c = "";
        this.f5258d = new HashMap();
    }

    public RouterRequest action(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f5257c = str;
            return this;
        }
        return (RouterRequest) invokeL.objValue;
    }

    public RouterRequest data(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            this.f5258d.put(str, obj);
            return this;
        }
        return (RouterRequest) invokeLL.objValue;
    }

    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5257c : (String) invokeV.objValue;
    }

    public HashMap getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5258d : (HashMap) invokeV.objValue;
    }

    public String getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5256b : (String) invokeV.objValue;
    }

    public RouterRequest provider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f5256b = str;
            return this;
        }
        return (RouterRequest) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", this.f5256b);
                jSONObject.put("action", this.f5257c);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Object obj : this.f5258d.keySet()) {
                        jSONObject2.put(obj.toString(), this.f5258d.get(obj));
                    }
                    jSONObject.put("data", jSONObject2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    jSONObject.put("data", StringUtil.EMPTY_ARRAY);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public RouterRequest data(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            this.f5258d = hashMap;
            return this;
        }
        return (RouterRequest) invokeL.objValue;
    }
}
