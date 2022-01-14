package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Type type, byte[] bArr) {
        super(type, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Type) objArr2[0], (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String str = new String(this.f30640b);
                StringBuilder sb = new StringBuilder("threadid = ");
                sb.append(Thread.currentThread().getId());
                sb.append("; rpc response:  ");
                sb.append(str);
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("resultStatus");
                if (i2 == 1000) {
                    return this.a == String.class ? jSONObject.optString("result") : com.alipay.a.a.e.a(jSONObject.optString("result"), this.a);
                }
                throw new RpcException(Integer.valueOf(i2), jSONObject.optString("tips"));
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("response  =");
                sb2.append(new String(this.f30640b));
                sb2.append(":");
                sb2.append(e2);
                throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e2.getMessage());
            }
        }
        return invokeV.objValue;
    }
}
