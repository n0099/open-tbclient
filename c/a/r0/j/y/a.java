package c.a.r0.j.y;

import c.a.r0.a.g1.f;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.p.b.a.k;
import c.a.r0.n.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

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
        this.a = new ArrayList<>();
    }

    @Override // c.a.r0.a.p.b.a.k
    public void a(c.a.r0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        d(aVar.B("action"), aVar.B("menuItemName"));
    }

    @Override // c.a.r0.a.p.b.a.k
    public void b(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nVar != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                nVar.p(id.intValue());
            }
        }
    }

    public final boolean c(n nVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nVar, str)) == null) {
            Integer a = b.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (nVar != null) {
                    nVar.p(a.intValue());
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
                f U = f.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                g V = U.V();
                c.a.r0.j.n.a aVar = V != null ? (c.a.r0.j.n.a) V.n(c.a.r0.j.n.a.class) : null;
                n r3 = aVar != null ? aVar.r3() : null;
                if (r3 != null && aVar != null) {
                    aVar.D3(true);
                }
                return c(r3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
