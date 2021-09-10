package c.a.j;

import android.content.Context;
import c.a.j.f;
import c.a.j.h;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g implements f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BDHttpDns.a f3545a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f3546b;

    /* renamed from: c  reason: collision with root package name */
    public final h f3547c;

    public g(Context context, BDHttpDns.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3545a = aVar;
        BDHttpDns j2 = BDHttpDns.j(context);
        this.f3546b = j2;
        this.f3547c = j2.d();
    }

    @Override // c.a.j.f.a
    public void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j2, String str) {
        BDHttpDns.a aVar;
        BDHttpDnsResult bDHttpDnsResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), arrayList, arrayList2, Long.valueOf(j2), str}) == null) {
            if (i2 == -1) {
                k.a("Async resolve failed, host(%s), dns resolve failed", str);
                aVar = this.f3545a;
                if (aVar == null) {
                    return;
                }
                bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2);
            } else if (i2 != 0) {
                k.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i2));
                return;
            } else {
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = arrayList != null ? arrayList.toString() : null;
                objArr[2] = arrayList2 != null ? arrayList2.toString() : null;
                objArr[3] = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS.toString();
                k.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                h.a aVar2 = new h.a();
                aVar2.a(60L);
                aVar2.e(System.currentTimeMillis() / 1000);
                aVar2.b(arrayList);
                aVar2.f(arrayList2);
                this.f3547c.c(str, aVar2);
                aVar = this.f3545a;
                if (aVar == null) {
                    return;
                }
                bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2);
            }
            aVar.a(bDHttpDnsResult);
        }
    }
}
