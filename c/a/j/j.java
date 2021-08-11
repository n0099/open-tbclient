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
    public final h f3460a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f3461b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f3462c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f3463d;

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
        this.f3461b = j2;
        this.f3460a = j2.a();
        this.f3462c = this.f3461b.f();
        this.f3463d = this.f3461b.g();
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
                            this.f3460a.c(key, aVar);
                        } else if (this.f3462c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                            this.f3460a.f(key);
                        }
                    }
                }
            } else if (dVar.equals(i.d.f38279a) && this.f3462c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.f3460a.f(str2);
                }
            }
            if (this.f3461b.h() <= 0 || this.f3463d.C()) {
                return;
            }
            this.f3463d.s(true);
            k.a("preResolve has finished", new Object[0]);
        }
    }
}
