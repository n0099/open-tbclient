package c.a.q0.f1.j.j;

import c.a.p0.s.q.c2;
import c.a.q0.f1.j.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<c2> f17929a;

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
        this.f17929a = new ArrayList();
    }

    public c a(boolean z, c.a.q0.f1.j.h.a aVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, aVar)) == null) {
            c cVar = new c();
            cVar.f17923c = aVar.i();
            cVar.f17925e = aVar.a();
            cVar.f17926f = aVar.c();
            ArrayList<c2> h2 = aVar.h();
            if (z) {
                if (!ListUtils.isEmpty(h2)) {
                    this.f17929a.clear();
                    this.f17929a.addAll(h2);
                }
            } else if (!ListUtils.isEmpty(h2)) {
                this.f17929a.addAll(h2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f17929a);
            c.a.q0.f1.j.a.c(true, arrayList, aVar.e());
            c.a.q0.f1.j.a.c(true, arrayList, aVar.f());
            c.a.q0.f1.j.a.c(true, arrayList, aVar.d());
            c.a.q0.f1.j.a.c(true, arrayList, aVar.g());
            cVar.f17921a = c.a.q0.f1.j.a.a(arrayList);
            return cVar;
        }
        return (c) invokeZL.objValue;
    }

    public List<c2> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17929a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c2> list = this.f17929a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
