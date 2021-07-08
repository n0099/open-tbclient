package com.baidu.crabsdk.lite.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4705a.get(str);
            return (hashMap == null || (obj = hashMap.get("sdk_channel")) == null) ? "N/A" : (String) obj;
        }
        return (String) invokeL.objValue;
    }
}
