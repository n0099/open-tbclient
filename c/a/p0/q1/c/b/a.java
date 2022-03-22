package c.a.p0.q1.c.b;

import c.a.p0.q1.k.h.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.p2.b.a f17132b;

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
        this.a = new ArrayList();
    }

    public final void a(d dVar) {
        c.a.p0.p2.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (aVar = this.f17132b) == null || ListUtils.isEmpty(aVar.f16906b)) {
            return;
        }
        dVar.a.add(0, this.f17132b);
    }

    public d b(int i, boolean z, c.a.p0.q1.c.a.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), aVar})) == null) {
            d dVar = new d();
            dVar.f17522c = aVar.f();
            dVar.f17524e = aVar.a();
            dVar.f17525f = aVar.b();
            ArrayList<ThreadData> e2 = aVar.e();
            if (z) {
                this.f17132b = aVar.d();
                if (!ListUtils.isEmpty(e2)) {
                    this.a.clear();
                    this.a.addAll(e2);
                    dVar.f17523d = 1;
                }
            } else if (!ListUtils.isEmpty(e2)) {
                this.a.addAll(e2);
                dVar.f17523d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            c.a.p0.q1.k.a.e(true, arrayList, aVar.c());
            dVar.a = c.a.p0.q1.k.a.c(arrayList);
            a(dVar);
            c.a.p0.p2.b.a aVar2 = this.f17132b;
            if (aVar2 != null && aVar2.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                dVar.a.add(0, new c.a.p0.q1.k.h.a());
            }
            return dVar;
        }
        return (d) invokeCommon.objValue;
    }

    public List<ThreadData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
