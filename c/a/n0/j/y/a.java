package c.a.n0.j.y;

import c.a.n0.a.f.b.a.k;
import c.a.n0.a.x.g.g;
import c.a.n0.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    @Override // c.a.n0.a.f.b.a.k
    public void a(c.a.n0.a.o.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        d(aVar.B("action"), aVar.B("menuItemName"));
    }

    @Override // c.a.n0.a.f.b.a.k
    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (fVar != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                fVar.m(id.intValue());
            }
        }
    }

    public final boolean c(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            Integer a = b.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (fVar != null) {
                    fVar.m(a.intValue());
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
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                g V = U.V();
                c.a.n0.j.n.a aVar = V != null ? (c.a.n0.j.n.a) V.n(c.a.n0.j.n.a.class) : null;
                f v3 = aVar != null ? aVar.v3() : null;
                if (v3 != null && aVar != null) {
                    aVar.H3(true);
                }
                return c(v3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
