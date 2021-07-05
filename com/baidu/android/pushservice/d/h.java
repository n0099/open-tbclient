package com.baidu.android.pushservice.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f3027d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, Context context, String str) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context, str};
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
        this.f3027d = str;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            super.b(hashMap);
            hashMap.put("method", "deltags");
            hashMap.put(CommandMessage.TYPE_TAGS, this.f3027d);
        }
    }
}
