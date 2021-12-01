package c.a.r0.n1.j.j;

import c.a.q0.s.q.d2;
import c.a.r0.n1.j.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
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

    public c a(boolean z, c.a.r0.n1.j.h.a aVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, aVar)) == null) {
            c cVar = new c();
            cVar.f20639c = aVar.i();
            cVar.f20641e = aVar.a();
            cVar.f20642f = aVar.c();
            ArrayList<d2> h2 = aVar.h();
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
            c.a.r0.n1.j.a.e(true, arrayList, aVar.e());
            c.a.r0.n1.j.a.e(true, arrayList, aVar.f());
            c.a.r0.n1.j.a.e(true, arrayList, aVar.d());
            c.a.r0.n1.j.a.e(true, arrayList, aVar.g());
            cVar.a = c.a.r0.n1.j.a.c(arrayList);
            return cVar;
        }
        return (c) invokeZL.objValue;
    }

    public List<d2> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d2> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
