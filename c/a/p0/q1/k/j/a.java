package c.a.p0.q1.k.j;

import c.a.p0.q1.k.h.b;
import c.a.p0.q1.k.h.d;
import com.baidu.android.imsdk.internal.Constants;
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

    public d a(boolean z, b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, bVar)) == null) {
            d dVar = new d();
            dVar.f17522c = bVar.i();
            dVar.f17524e = bVar.a();
            dVar.f17525f = bVar.c();
            ArrayList<ThreadData> h2 = bVar.h();
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
            c.a.p0.q1.k.a.e(true, arrayList, bVar.e());
            c.a.p0.q1.k.a.e(true, arrayList, bVar.f());
            c.a.p0.q1.k.a.e(true, arrayList, bVar.d());
            c.a.p0.q1.k.a.e(true, arrayList, bVar.g());
            dVar.a = c.a.p0.q1.k.a.c(arrayList);
            return dVar;
        }
        return (d) invokeZL.objValue;
    }

    public List<ThreadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
