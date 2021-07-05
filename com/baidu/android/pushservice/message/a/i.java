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
/* loaded from: classes.dex */
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
            int a2 = kVar.a();
            PublicMsg a3 = j.a(this.f3524a, f2, c2, bArr);
            if (a3 == null || TextUtils.isEmpty(a3.mTitle) || TextUtils.isEmpty(a3.mDescription) || TextUtils.isEmpty(a3.mUrl)) {
                m.a(">>> pMsg JSON parsing error!", this.f3524a);
                i2 = 2;
            } else {
                if (f.a(this.f3524a, a3)) {
                    Context context = this.f3524a;
                    if (m.d(context, context.getPackageName())) {
                        m.a(">>> Show pMsg Notification!", this.f3524a);
                        f.a(this.f3524a, a3, f2, a2);
                        i2 = 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">>> Don't Show pMsg Notification! --- IsBaiduApp = ");
                Context context2 = this.f3524a;
                sb.append(m.d(context2, context2.getPackageName()));
                m.a(sb.toString(), this.f3524a);
                i2 = 0;
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i2);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
