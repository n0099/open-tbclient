package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(i iVar, Context context) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "unbind");
            hashMap.put("model", l.a(((a) this).a) + "");
            if (com.baidu.android.pushservice.b.d.b(((a) this).a)) {
                hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(((a) this).a).c());
            }
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).a) ? 1 : 0) + "");
            hashMap.put("manufacture", com.baidu.android.pushservice.i.m.a(false));
            hashMap.put("proxy_mode", (com.baidu.android.pushservice.b.d.c(((a) this).a) ? 1 : 0) + "");
        }
    }
}
