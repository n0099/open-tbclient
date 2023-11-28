package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.w.m.c
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String a = kVar.a();
            String h = kVar.h();
            int i2 = kVar.i();
            PublicMsg a2 = j.a(this.a, h, a, bArr);
            if (a2 == null || TextUtils.isEmpty(a2.mTitle) || TextUtils.isEmpty(a2.mDescription) || TextUtils.isEmpty(a2.mUrl)) {
                i = 2;
            } else {
                if (f.a(this.a, a2)) {
                    Context context = this.a;
                    if (Utility.n(context, context.getPackageName())) {
                        f.a(this.a, a2, h, i2);
                        i = 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">>> Don't Show pMsg Notification! --- IsBaiduApp = ");
                Context context2 = this.a;
                sb.append(Utility.n(context2, context2.getPackageName()));
                sb.toString();
                i = 0;
            }
            com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
            gVar.a(i);
            return gVar;
        }
        return (com.baidu.android.pushservice.w.g) invokeLL.objValue;
    }
}
