package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes9.dex */
public final class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f30670c;

    /* renamed from: d  reason: collision with root package name */
    public Object f30671d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, String str, Object obj) {
        super(str, obj);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30670c = i2;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.f30671d = obj;
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
                if (this.f30671d != null) {
                    arrayList.add(new BasicNameValuePair("extParam", com.alipay.a.a.f.a(this.f30671d)));
                }
                arrayList.add(new BasicNameValuePair("operationType", this.a));
                StringBuilder sb = new StringBuilder();
                sb.append(this.f30670c);
                arrayList.add(new BasicNameValuePair("id", sb.toString()));
                new StringBuilder("mParams is:").append(this.f30669b);
                arrayList.add(new BasicNameValuePair("requestData", this.f30669b == null ? "[]" : com.alipay.a.a.f.a(this.f30669b)));
                return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("request  =");
                sb2.append(this.f30669b);
                sb2.append(":");
                sb2.append(e2);
                throw new RpcException(9, sb2.toString() == null ? "" : e2.getMessage(), e2);
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
