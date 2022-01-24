package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.net.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends com.alipay.sdk.packet.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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
        return (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str)) == null) ? new HashMap() : (Map) invokeZL.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, context, str)) == null) {
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "mdap post");
            byte[] a = com.alipay.sdk.encrypt.b.a(str.getBytes(Charset.forName("UTF-8")));
            HashMap hashMap = new HashMap();
            hashMap.put("utdId", com.alipay.sdk.sys.b.d().c());
            hashMap.put("logHeader", "RAW");
            hashMap.put("bizCode", com.alipay.sdk.util.c.f30946b);
            hashMap.put("productId", "alipaysdk_android");
            hashMap.put("Content-Encoding", "Gzip");
            hashMap.put("productVersion", "15.8.02");
            a.b a2 = com.alipay.sdk.net.a.a(context, new a.C1702a(com.alipay.sdk.cons.a.f30840d, hashMap, a));
            com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "mdap got " + a2);
            if (a2 != null) {
                boolean a3 = com.alipay.sdk.packet.e.a(a2);
                try {
                    byte[] bArr = a2.f30901c;
                    if (a3) {
                        bArr = com.alipay.sdk.encrypt.b.b(bArr);
                    }
                    return new com.alipay.sdk.packet.b("", new String(bArr, Charset.forName("UTF-8")));
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return null;
                }
            }
            throw new RuntimeException("Response is null");
        }
        return (com.alipay.sdk.packet.b) invokeLLL.objValue;
    }
}
