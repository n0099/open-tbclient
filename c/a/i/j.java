package c.a.i;

import android.content.Context;
import c.a.i.h;
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
    public final h a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f3003b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f3004c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f3005d;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BDHttpDns j = BDHttpDns.j(context);
        this.f3003b = j;
        this.a = j.a();
        this.f3004c = this.f3003b.f();
        this.f3005d = this.f3003b.g();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), dVar, map, str}) == null) {
            if (i != -1) {
                if (i != 0) {
                    k.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                } else {
                    for (Map.Entry<String, i.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        i.e value = entry.getValue();
                        if (value != null) {
                            h.a aVar = new h.a();
                            aVar.a(value.b());
                            aVar.e(System.currentTimeMillis() / 1000);
                            aVar.b(value.a());
                            this.a.c(key, aVar);
                        } else if (this.f3004c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                            this.a.f(key);
                        }
                    }
                }
            } else if (dVar.equals(i.d.a) && this.f3004c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.a.f(str2);
                }
            }
            if (this.f3003b.h() <= 0 || this.f3005d.C()) {
                return;
            }
            this.f3005d.s(true);
            k.a("preResolve has finished", new Object[0]);
        }
    }
}
