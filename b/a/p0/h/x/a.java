package b.a.p0.h.x;

import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.p.b.a.k;
import b.a.p0.k.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Integer> f10784a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10784a = new ArrayList<>();
    }

    @Override // b.a.p0.a.p.b.a.k
    public void a(b.a.p0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        d(aVar.B("action"), aVar.B("menuItemName"));
    }

    @Override // b.a.p0.a.p.b.a.k
    public void b(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) || this.f10784a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f10784a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nVar != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                nVar.j(id.intValue());
            }
        }
    }

    public final boolean c(n nVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nVar, str)) == null) {
            Integer a2 = b.a(str);
            if (a2 != null) {
                if (!this.f10784a.contains(a2)) {
                    this.f10784a.add(a2);
                }
                if (nVar != null) {
                    nVar.j(a2.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                f T = f.T();
                Intrinsics.checkNotNullExpressionValue(T, "SwanAppController.getInstance()");
                g U = T.U();
                b.a.p0.h.n.a aVar = U != null ? (b.a.p0.h.n.a) U.n(b.a.p0.h.n.a.class) : null;
                n d3 = aVar != null ? aVar.d3() : null;
                if (d3 != null && aVar != null) {
                    aVar.p3(true);
                }
                return c(d3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
