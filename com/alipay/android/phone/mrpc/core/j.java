package com.alipay.android.phone.mrpc.core;

import com.baidu.nadcore.exp.ADConfigError;
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
/* loaded from: classes.dex */
public final class j extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, method, Integer.valueOf(i), str, bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Method) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (byte[]) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o oVar = new o(this.g.a());
            oVar.a(this.b);
            oVar.a(this.e);
            oVar.a(this.f);
            oVar.a("id", String.valueOf(this.d));
            oVar.a("operationType", this.c);
            oVar.a("gzip", String.valueOf(this.g.d()));
            oVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
            List<Header> b = this.g.c().b();
            if (b != null && !b.isEmpty()) {
                for (Header header : b) {
                    oVar.a(header);
                }
            }
            StringBuilder sb = new StringBuilder("threadid = ");
            sb.append(Thread.currentThread().getId());
            sb.append("; ");
            sb.append(oVar.toString());
            try {
                u uVar = this.g.b().a(oVar).get();
                if (uVar != null) {
                    return uVar.b();
                }
                throw new RpcException((Integer) 9, ADConfigError.REASON_NULL_RESPONSE);
            } catch (InterruptedException e) {
                throw new RpcException(13, "", e);
            } catch (CancellationException e2) {
                throw new RpcException(13, "", e2);
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause == null || !(cause instanceof HttpException)) {
                    throw new RpcException(9, "", e3);
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
