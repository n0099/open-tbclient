package c.a.s0.o1.b.b;

import c.a.r0.s.r.d2;
import c.a.s0.o1.j.h.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<d2> a;

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
        this.a = new ArrayList();
    }

    public final void a(c.a.s0.o1.b.a.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, dVar) == null) || aVar.d() == null || ListUtils.isEmpty(aVar.d().f19133f)) {
            return;
        }
        dVar.a.add(0, aVar.d());
    }

    public d b(int i2, boolean z, c.a.s0.o1.b.a.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), aVar})) == null) {
            d dVar = new d();
            dVar.f21163c = aVar.f();
            dVar.f21165e = aVar.a();
            dVar.f21166f = aVar.b();
            ArrayList<d2> e2 = aVar.e();
            if (z) {
                if (!ListUtils.isEmpty(e2)) {
                    this.a.clear();
                    this.a.addAll(e2);
                    dVar.f21164d = 1;
                }
            } else if (!ListUtils.isEmpty(e2)) {
                this.a.addAll(e2);
                dVar.f21164d = i2 + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            c.a.s0.o1.j.a.e(true, arrayList, aVar.c());
            dVar.a = c.a.s0.o1.j.a.c(arrayList);
            a(aVar, dVar);
            if (aVar.g() && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                dVar.a.add(0, new c.a.s0.o1.j.h.a());
            }
            return dVar;
        }
        return (d) invokeCommon.objValue;
    }

    public List<d2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<d2> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
