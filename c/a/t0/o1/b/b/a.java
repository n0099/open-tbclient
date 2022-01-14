package c.a.t0.o1.b.b;

import c.a.s0.s.q.e2;
import c.a.t0.o1.j.h.d;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e2> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.l2.b.a f20112b;

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

    public final void a(d dVar) {
        c.a.t0.l2.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (aVar = this.f20112b) == null || ListUtils.isEmpty(aVar.f19121f)) {
            return;
        }
        dVar.a.add(0, this.f20112b);
    }

    public d b(int i2, boolean z, c.a.t0.o1.b.a.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), aVar})) == null) {
            d dVar = new d();
            dVar.f20644c = aVar.f();
            dVar.f20646e = aVar.a();
            dVar.f20647f = aVar.b();
            ArrayList<e2> e2 = aVar.e();
            if (z) {
                this.f20112b = aVar.d();
                if (!ListUtils.isEmpty(e2)) {
                    this.a.clear();
                    this.a.addAll(e2);
                    dVar.f20645d = 1;
                }
            } else if (!ListUtils.isEmpty(e2)) {
                this.a.addAll(e2);
                dVar.f20645d = i2 + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            c.a.t0.o1.j.a.e(true, arrayList, aVar.c());
            dVar.a = c.a.t0.o1.j.a.c(arrayList);
            a(dVar);
            c.a.t0.l2.b.a aVar2 = this.f20112b;
            if (aVar2 != null && aVar2.f19120e && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                dVar.a.add(0, new c.a.t0.o1.j.h.a());
            }
            return dVar;
        }
        return (d) invokeCommon.objValue;
    }

    public List<e2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<e2> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
