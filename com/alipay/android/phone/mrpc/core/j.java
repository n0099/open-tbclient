package com.alipay.android.phone.mrpc.core;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
/* loaded from: classes4.dex */
public final class j extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public g f35753g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, Method method, int i2, String str, byte[] bArr, boolean z) {
        super(method, i2, str, bArr, "application/x-www-form-urlencoded", z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, method, Integer.valueOf(i2), str, bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Method) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (byte[]) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35753g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o oVar = new o(this.f35753g.a());
            oVar.a(this.f35722b);
            oVar.a(this.f35725e);
            oVar.a(this.f35726f);
            oVar.a("id", String.valueOf(this.f35724d));
            oVar.a("operationType", this.f35723c);
            oVar.a(AsyncHttpClient.ENCODING_GZIP, String.valueOf(this.f35753g.d()));
            oVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
            List<Header> b2 = this.f35753g.c().b();
            if (b2 != null && !b2.isEmpty()) {
                for (Header header : b2) {
                    oVar.a(header);
                }
            }
            StringBuilder sb = new StringBuilder("threadid = ");
            sb.append(Thread.currentThread().getId());
            sb.append("; ");
            sb.append(oVar.toString());
            try {
                u uVar = this.f35753g.b().a(oVar).get();
                if (uVar != null) {
                    return uVar.b();
                }
                throw new RpcException((Integer) 9, "response is null");
            } catch (InterruptedException e2) {
                throw new RpcException(13, "", e2);
            } catch (CancellationException e3) {
                throw new RpcException(13, "", e3);
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                if (cause == null || !(cause instanceof HttpException)) {
                    throw new RpcException(9, "", e4);
                }
                HttpException httpException = (HttpException) cause;
                int code = httpException.getCode();
                switch (code) {
                    case 1:
                        code = 2;
                        break;
                    case 2:
                        code = 3;
                        break;
                    case 3:
                        code = 4;
                        break;
                    case 4:
                        code = 5;
                        break;
                    case 5:
                        code = 6;
                        break;
                    case 6:
                        code = 7;
                        break;
                    case 7:
                        code = 8;
                        break;
                    case 8:
                        code = 15;
                        break;
                    case 9:
                        code = 16;
                        break;
                }
                throw new RpcException(Integer.valueOf(code), httpException.getMsg());
            }
        }
        return invokeV.objValue;
    }
}
