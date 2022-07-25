package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class d extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ Context a;
    public /* synthetic */ String b;
    public /* synthetic */ String c;
    public /* synthetic */ String d;
    public /* synthetic */ String e;
    public /* synthetic */ String f;
    public /* synthetic */ PreCodeListener g;
    public /* synthetic */ a h;

    public d(a aVar, Context context, String str, String str2, String str3, String str4, String str5, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, context, str, str2, str3, str4, str5, preCodeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = aVar;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = preCodeListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!new j().a(this.a, "https://id6.me/auth/preauth.do")) {
                if (a()) {
                    return;
                }
                CtAuth.postResult(this.a, p.a(80800, "WIFI切换超时"), this.f, this.g);
            } else if (a()) {
            } else {
                String a = a.a(this.h, this.a, this.b, this.c, this.d, null, this.e, this.f);
                if (a()) {
                    return;
                }
                CtAuth.postResult(this.a, a, this.f, this.g);
            }
        }
    }
}
