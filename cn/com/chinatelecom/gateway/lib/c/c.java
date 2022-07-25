package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.Network;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class c implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public /* synthetic */ String c;
    public /* synthetic */ Context d;
    public /* synthetic */ String e;
    public /* synthetic */ String f;
    public /* synthetic */ String g;
    public /* synthetic */ String h;
    public /* synthetic */ PreCodeListener i;
    public /* synthetic */ a j;

    public c(a aVar, String str, Context context, String str2, String str3, String str4, String str5, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, str, context, str2, str3, str4, str5, preCodeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = aVar;
        this.c = str;
        this.d = context;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = preCodeListener;
        this.a = false;
        this.b = false;
    }

    @Override // cn.com.chinatelecom.gateway.lib.c.m
    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.a = true;
                if (!this.b) {
                    cn.com.chinatelecom.gateway.lib.b.d.a(this.c, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                    CtAuth.postResult(this.d, "{\"result\":80000,\"msg\":\"请求超时\"}", this.c, this.i);
                }
            }
        }
    }

    @Override // cn.com.chinatelecom.gateway.lib.c.m
    public final synchronized void a(int i, String str, long j) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}) == null) {
            synchronized (this) {
                if (!this.a && !this.b) {
                    this.b = true;
                    cn.com.chinatelecom.gateway.lib.b.a a = cn.com.chinatelecom.gateway.lib.b.d.a(this.c);
                    a.h("switchToMobile_L  onFail()  expendTime : " + j).a(i).f(str).a(j);
                    CtAuth.postResult(this.d, p.a(i, str), this.c, this.i);
                    str2 = a.a;
                    CtAuth.info(str2, "Switching network failed (L), errorMsg :" + str + " , expendTime ：" + j);
                }
            }
        }
    }

    @Override // cn.com.chinatelecom.gateway.lib.c.m
    public final void a(Network network, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, network, j) == null) {
            str = a.a;
            CtAuth.info(str, "Switching network successfully (L) , expendTime ：" + j);
            if (this.a || this.b) {
                return;
            }
            cn.com.chinatelecom.gateway.lib.b.d.a(this.c).a(j);
            String a = a.a(this.j, this.d, this.e, this.f, this.g, network, this.h, this.c);
            synchronized (this) {
                if (!this.a && !this.b) {
                    this.b = true;
                    CtAuth.postResult(this.d, a, this.c, this.i);
                }
            }
        }
    }
}
