package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
    public String a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) ? str : (String) invokeLL.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.alipay.sdk.packet.e.f1942a, String.valueOf(z));
            hashMap.put("content-type", "application/octet-stream");
            hashMap.put(com.alipay.sdk.packet.e.f1948g, "CBC");
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
    public String c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.alipay.sdk.packet.e.f1950i, "/sdk/log");
            hashMap.put(com.alipay.sdk.packet.e.j, BuildConfig.VERSION_NAME);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(t, "1.0");
            return a(hashMap, hashMap2);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(Context context, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) ? a(context, str, "https://mcgw.alipay.com/sdklog.do", true) : (com.alipay.sdk.packet.b) invokeLL.objValue;
    }
}
