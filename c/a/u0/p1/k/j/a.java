package c.a.u0.p1.k.j;

import c.a.t0.s.r.e2;
import c.a.u0.p1.k.h.b;
import c.a.u0.p1.k.h.d;
import com.baidu.android.imsdk.internal.Constants;
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

    public d a(boolean z, b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, bVar)) == null) {
            d dVar = new d();
            dVar.f20851c = bVar.i();
            dVar.f20853e = bVar.a();
            dVar.f20854f = bVar.c();
            ArrayList<e2> h2 = bVar.h();
            if (z) {
                if (!ListUtils.isEmpty(h2)) {
                    this.a.clear();
                    this.a.addAll(h2);
                }
            } else if (!ListUtils.isEmpty(h2)) {
                this.a.addAll(h2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            c.a.u0.p1.k.a.e(true, arrayList, bVar.e());
            c.a.u0.p1.k.a.e(true, arrayList, bVar.f());
            c.a.u0.p1.k.a.e(true, arrayList, bVar.d());
            c.a.u0.p1.k.a.e(true, arrayList, bVar.g());
            dVar.a = c.a.u0.p1.k.a.c(arrayList);
            return dVar;
        }
        return (d) invokeZL.objValue;
    }

    public List<e2> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<e2> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
