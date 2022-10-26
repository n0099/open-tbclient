package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends com.baidu.searchbox.dns.d.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean E;
    public String F;
    public c G;
    public int H;

    @Override // com.baidu.searchbox.dns.d.b.a
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "DNS_TASK" : (String) invokeV.objValue;
    }

    public a(boolean z, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = z;
        this.F = str;
        this.H = i;
    }

    private void a(com.baidu.searchbox.dns.d.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bVar) == null) {
            Map B = bVar.B();
            if (B != null && !B.isEmpty()) {
                for (Map.Entry entry : B.entrySet()) {
                    com.baidu.searchbox.dns.a.a.e().a((String) entry.getKey(), (com.baidu.searchbox.dns.d.a.a) entry.getValue());
                }
            }
            Map C = bVar.C();
            if (C != null && !C.isEmpty()) {
                for (Map.Entry entry2 : C.entrySet()) {
                    com.baidu.searchbox.dns.a.a.e().b((String) entry2.getKey(), (com.baidu.searchbox.dns.d.a.a) entry2.getValue());
                }
            }
            String D = bVar.D();
            if (!TextUtils.isEmpty(D)) {
                com.baidu.searchbox.dns.a.a.e().e(D);
            }
            String E = bVar.E();
            if (!TextUtils.isEmpty(E)) {
                com.baidu.searchbox.dns.a.a.e().f(E);
            }
            if (bVar.F()) {
                com.baidu.searchbox.dns.a.a.e().a(bVar.isIPv6TestArea());
            }
        }
    }

    private synchronized c l() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                if (this.G == null) {
                    this.G = new c(this.E, this.F, this.H);
                }
                cVar = this.G;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.searchbox.dns.d.a.b x = l().x();
            if (x != null) {
                a(x);
            }
            b.o().j(this.F);
        }
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.o().a(this.F, this);
            super.start();
        }
    }
}
