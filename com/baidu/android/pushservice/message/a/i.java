package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i extends d {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String c2 = kVar.c();
            String f2 = kVar.f();
            int a = kVar.a();
            PublicMsg a2 = j.a(this.a, f2, c2, bArr);
            if (a2 == null || TextUtils.isEmpty(a2.mTitle) || TextUtils.isEmpty(a2.mDescription) || TextUtils.isEmpty(a2.mUrl)) {
                m.a(">>> pMsg JSON parsing error!", this.a);
                i2 = 2;
            } else {
                if (f.a(this.a, a2)) {
                    Context context = this.a;
                    if (m.d(context, context.getPackageName())) {
                        m.a(">>> Show pMsg Notification!", this.a);
                        f.a(this.a, a2, f2, a);
                        i2 = 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">>> Don't Show pMsg Notification! --- IsBaiduApp = ");
                Context context2 = this.a;
                sb.append(m.d(context2, context2.getPackageName()));
                m.a(sb.toString(), this.a);
                i2 = 0;
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i2);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
