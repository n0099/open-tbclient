package com.baidu.android.pushservice.d;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "unbind");
            hashMap.put("model", l.a(((a) this).f36073a) + "");
            if (com.baidu.android.pushservice.b.d.b(((a) this).f36073a)) {
                hashMap.put("new_channel_id", com.baidu.android.pushservice.k.a(((a) this).f36073a).c());
            }
            hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).f36073a) ? 1 : 0) + "");
            hashMap.put("manufacture", Build.MANUFACTURER);
            hashMap.put("proxy_mode", (com.baidu.android.pushservice.b.d.c(((a) this).f36073a) ? 1 : 0) + "");
        }
    }
}
