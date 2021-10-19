package c.a.r0.h1.b.b;

import c.a.q0.s.q.d2;
import c.a.r0.h1.j.h.c;
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
    public final List<d2> f17943a;

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
        this.f17943a = new ArrayList();
    }

    public c a(int i2, boolean z, c.a.r0.h1.b.a.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), aVar})) == null) {
            c cVar = new c();
            cVar.f18637c = aVar.e();
            cVar.f18639e = aVar.a();
            cVar.f18640f = aVar.b();
            ArrayList<d2> d2 = aVar.d();
            if (z) {
                if (!ListUtils.isEmpty(d2)) {
                    this.f17943a.clear();
                    this.f17943a.addAll(d2);
                    cVar.f18638d = 1;
                }
            } else if (!ListUtils.isEmpty(d2)) {
                this.f17943a.addAll(d2);
                cVar.f18638d = i2 + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f17943a);
            c.a.r0.h1.j.a.c(true, arrayList, aVar.c());
            cVar.f18635a = c.a.r0.h1.j.a.a(arrayList);
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public List<d2> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17943a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d2> list = this.f17943a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
