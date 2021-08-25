package c.a.j;

import android.content.Context;
import c.a.j.h;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f3662a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f3663b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f3664c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f3665d;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BDHttpDns j2 = BDHttpDns.j(context);
        this.f3663b = j2;
        this.f3662a = j2.a();
        this.f3664c = this.f3663b.f();
        this.f3665d = this.f3663b.g();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i2, i.d dVar, Map<String, i.e> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), dVar, map, str}) == null) {
            if (i2 != -1) {
                if (i2 != 0) {
                    k.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i2));
                } else {
                    for (Map.Entry<String, i.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        i.e value = entry.getValue();
                        if (value != null) {
                            h.a aVar = new h.a();
                            aVar.a(value.b());
                            aVar.e(System.currentTimeMillis() / 1000);
                            aVar.b(value.a());
                            this.f3662a.c(key, aVar);
                        } else if (this.f3664c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                            this.f3662a.f(key);
                        }
                    }
                }
            } else if (dVar.equals(i.d.f38385a) && this.f3664c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.f3662a.f(str2);
                }
            }
            if (this.f3663b.h() <= 0 || this.f3665d.C()) {
                return;
            }
            this.f3665d.s(true);
            k.a("preResolve has finished", new Object[0]);
        }
    }
}
