package com.baidu.ar.child.b;

import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, HashMap hashMap, com.baidu.ar.ihttp.a aVar) {
        IHttpRequest newRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, str, hashMap, aVar) == null) || (newRequest = HttpFactory.newRequest()) == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(str).addFormData(hashMap);
        newRequest.enqueue(aVar);
    }
}
