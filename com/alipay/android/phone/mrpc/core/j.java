package com.alipay.android.phone.mrpc.core;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: g  reason: collision with root package name */
    public g f1686g;

    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.f1686g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        o oVar = new o(this.f1686g.a());
        oVar.a(this.f1655b);
        oVar.a(this.f1658e);
        oVar.a(this.f1659f);
        oVar.a("id", String.valueOf(this.f1657d));
        oVar.a("operationType", this.f1656c);
        oVar.a(AsyncHttpClient.ENCODING_GZIP, String.valueOf(this.f1686g.d()));
        oVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b2 = this.f1686g.c().b();
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
            u uVar = this.f1686g.b().a(oVar).get();
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
}
