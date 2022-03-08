package c.d.b;

import c.d.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes3.dex */
public final class u implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final CookieHandler f28142b;

    public u(CookieHandler cookieHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cookieHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28142b = cookieHandler;
    }

    @Override // c.d.b.m
    public List<l> a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVar)) == null) {
            try {
                ArrayList arrayList = null;
                for (Map.Entry<String, List<String>> entry : this.f28142b.get(sVar.B(), Collections.emptyMap()).entrySet()) {
                    String key = entry.getKey();
                    if ("Cookie".equalsIgnoreCase(key) || SM.COOKIE2.equalsIgnoreCase(key)) {
                        if (!entry.getValue().isEmpty()) {
                            for (String str : entry.getValue()) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll(c(sVar, str));
                            }
                        }
                    }
                }
                if (arrayList != null) {
                    return Collections.unmodifiableList(arrayList);
                }
                return Collections.emptyList();
            } catch (IOException e2) {
                c.d.b.e0.n.g m = c.d.b.e0.n.g.m();
                m.u(5, "Loading cookies failed for " + sVar.z("/..."), e2);
                return Collections.emptyList();
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.d.b.m
    public void b(s sVar, List<l> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, list) == null) || this.f28142b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (l lVar : list) {
            arrayList.add(lVar.j(true));
        }
        try {
            this.f28142b.put(sVar.B(), Collections.singletonMap("Set-Cookie", arrayList));
        } catch (IOException e2) {
            c.d.b.e0.n.g m = c.d.b.e0.n.g.m();
            m.u(5, "Saving cookies failed for " + sVar.z("/..."), e2);
        }
    }

    public final List<l> c(s sVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sVar, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int n = c.d.b.e0.e.n(str, i2, length, ";,");
                int m = c.d.b.e0.e.m(str, i2, n, com.alipay.sdk.encrypt.a.f29503h);
                String H = c.d.b.e0.e.H(str, i2, m);
                if (!H.startsWith("$")) {
                    String H2 = m < n ? c.d.b.e0.e.H(str, m + 1, n) : "";
                    if (H2.startsWith("\"") && H2.endsWith("\"")) {
                        H2 = H2.substring(1, H2.length() - 1);
                    }
                    l.a aVar = new l.a();
                    aVar.d(H);
                    aVar.e(H2);
                    aVar.b(sVar.l());
                    arrayList.add(aVar.a());
                }
                i2 = n + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
