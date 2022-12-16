package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i, String str, Object obj) {
        super(str, obj);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = i;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.d = obj;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0032: IGET  (r4v3 int A[REMOVE]) = (r5v0 'this' com.alipay.android.phone.mrpc.core.a.e A[IMMUTABLE_TYPE, THIS]) com.alipay.android.phone.mrpc.core.a.e.c int)] */
    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (this.d != null) {
                    arrayList.add(new BasicNameValuePair("extParam", com.alipay.a.a.f.a(this.d)));
                }
                arrayList.add(new BasicNameValuePair("operationType", this.a));
                StringBuilder sb = new StringBuilder();
                sb.append(this.c);
                arrayList.add(new BasicNameValuePair("id", sb.toString()));
                new StringBuilder("mParams is:").append(this.b);
                arrayList.add(new BasicNameValuePair("requestData", this.b == null ? "[]" : com.alipay.a.a.f.a(this.b)));
                return URLEncodedUtils.format(arrayList, IMAudioTransRequest.CHARSET).getBytes();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("request  =");
                sb2.append(this.b);
                sb2.append(":");
                sb2.append(e);
                throw new RpcException(9, sb2.toString() == null ? "" : e.getMessage(), e);
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
