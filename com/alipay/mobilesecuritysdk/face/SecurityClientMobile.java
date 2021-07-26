package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.cons.b;
import com.alipay.security.mobile.module.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SecurityClientMobile {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SecurityClientMobile() {
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

    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, map)) == null) {
            synchronized (SecurityClientMobile.class) {
                HashMap hashMap = new HashMap();
                hashMap.put(b.f1880g, a.a(map, b.f1880g, ""));
                hashMap.put("tid", a.a(map, "tid", ""));
                hashMap.put("userId", a.a(map, "userId", ""));
                APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
                a2 = com.alipay.apmobilesecuritysdk.a.a.a(context);
            }
            return a2;
        }
        return (String) invokeLL.objValue;
    }
}
