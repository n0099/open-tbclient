package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.alipay.sdk.packet.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "log_v";
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // com.alipay.sdk.packet.e
    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, jSONObject)) == null) ? str : (String) invokeLLL.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.alipay.sdk.packet.e.f34144c, String.valueOf(z));
            hashMap.put("content-type", "application/octet-stream");
            hashMap.put(com.alipay.sdk.packet.e.f34150i, "CBC");
            return hashMap;
        }
        return (Map) invokeZL.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public String b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.alipay.sdk.packet.e.k, "/sdk/log");
            hashMap.put(com.alipay.sdk.packet.e.l, "1.0.0");
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(t, "1.0");
            return a(hashMap, hashMap2);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, context, str)) == null) ? a(aVar, context, str, com.alipay.sdk.cons.a.f34065c, true) : (com.alipay.sdk.packet.b) invokeLLL.objValue;
    }
}
