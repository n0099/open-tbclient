package c.a.p0.v;

import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f19019e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public a f19020b;

    /* renamed from: c  reason: collision with root package name */
    public c f19021c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f19022d;

    public d() {
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(1);
        this.a.add(2);
        c cVar = new c();
        this.f19021c = cVar;
        this.f19020b = new a(cVar, this.a);
        g(c.a.o0.r.j0.b.k().l("key_abtest_channel", 0));
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f19019e == null) {
                synchronized (c.class) {
                    if (f19019e == null) {
                        f19019e = new d();
                    }
                }
            }
            return f19019e;
        }
        return (d) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.f19022d == null) {
            this.f19022d = new ArrayList();
        }
        this.f19022d.add(statisticItem);
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            a aVar = this.f19020b;
            if (aVar == null) {
                return 0;
            }
            return aVar.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (m.isEmpty(str) || (cVar = this.f19021c) == null || !cVar.g()) {
                c.a.t0.a.a.d(str);
            }
        }
    }

    public void e(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (m.isEmpty(str) || (cVar = this.f19021c) == null || !cVar.g()) {
                c.a.t0.a.a.e(str);
            }
        }
    }

    public void f(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (aVar = this.f19020b) == null) {
            return;
        }
        aVar.b(str);
    }

    public void g(int i) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (cVar = this.f19021c) == null) {
            return;
        }
        cVar.k(i);
    }

    public void h(String str, String str2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.f19022d) || (cVar = this.f19021c) == null || !cVar.g()) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.f19022d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i != statisticItem.getPosition()) {
                    i = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f19022d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (cVar = this.f19021c) == null || !cVar.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = params.get(i);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        c.a.t0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
