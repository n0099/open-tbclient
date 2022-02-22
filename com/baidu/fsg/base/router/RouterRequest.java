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
/* loaded from: classes10.dex */
public class RouterRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RouterRequest";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f33996b;

    /* renamed from: c  reason: collision with root package name */
    public String f33997c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f33998d;

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
        this.f33996b = "";
        this.f33997c = "";
        this.f33998d = new HashMap();
    }

    public RouterRequest action(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f33997c = str;
            return this;
        }
        return (RouterRequest) invokeL.objValue;
    }

    public RouterRequest data(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            this.f33998d.put(str, obj);
            return this;
        }
        return (RouterRequest) invokeLL.objValue;
    }

    public RouterRequest data(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            this.f33998d = hashMap;
            return this;
        }
        return (RouterRequest) invokeL.objValue;
    }

    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33997c : (String) invokeV.objValue;
    }

    public HashMap getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33998d : (HashMap) invokeV.objValue;
    }

    public String getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33996b : (String) invokeV.objValue;
    }

    public RouterRequest provider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f33996b = str;
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
                jSONObject.put("provider", this.f33996b);
                jSONObject.put("action", this.f33997c);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Object obj : this.f33998d.keySet()) {
                        jSONObject2.put(obj.toString(), this.f33998d.get(obj));
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
}
