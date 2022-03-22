package c.a.p0.s2.d;

import c.a.d.o.e.n;
import c.a.p0.s2.c.c;
import c.a.p0.s2.c.d;
import c.a.p0.s2.c.e;
import c.a.p0.s2.c.f;
import c.a.p0.s2.c.g;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-351000052, "Lc/a/p0/s2/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-351000052, "Lc/a/p0/s2/d/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(int i, c cVar, int i2, List<n> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<c.a.p0.s2.c.a> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), cVar, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || cVar == null || (list2 = cVar.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<c.a.p0.s2.c.a> list3 = cVar.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (c.a.p0.s2.c.a aVar : list3) {
            if (aVar != null && i == aVar.f18225b.intValue()) {
                List<g> list4 = aVar.a;
                if (list4 == null || list4.size() <= 0) {
                    return;
                }
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    if (list4.get(i4) != null) {
                        if (arrayList.size() >= 20) {
                            d(list.get(i2));
                            bdTypeRecyclerView.setData(list);
                            return;
                        } else if (i3 >= 4) {
                            bdTypeRecyclerView.setData(list);
                            return;
                        } else {
                            if (i4 == list4.size() - 1) {
                                d(list.get(i2));
                            }
                            RecommendForumInfo recommendForumInfo = list4.get(i4).a;
                            if (!arrayList.contains(recommendForumInfo.forum_id)) {
                                d dVar = new d();
                                dVar.n(aVar.f18225b.intValue());
                                dVar.m(recommendForumInfo.avatar);
                                dVar.q(recommendForumInfo.forum_id.longValue());
                                dVar.r(recommendForumInfo.forum_name);
                                dVar.s(recommendForumInfo.member_count.intValue());
                                dVar.w(recommendForumInfo.thread_count.intValue());
                                dVar.v(recommendForumInfo.slogan);
                                dVar.u(false);
                                list.add(i2, dVar);
                                arrayList.add(recommendForumInfo.forum_id);
                                i2++;
                                i3++;
                            }
                        }
                    }
                }
                bdTypeRecyclerView.setData(list);
            }
        }
    }

    public List<n> b(List<c.a.p0.s2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.p0.s2.c.a aVar : list) {
                if (aVar != null) {
                    f fVar = new f();
                    fVar.f(aVar.f18225b.intValue());
                    fVar.e(aVar.f18227d);
                    fVar.g(aVar.f18226c);
                    arrayList.add(fVar);
                    List<g> list2 = aVar.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (g gVar : list2) {
                            if (gVar != null) {
                                if (a >= 4) {
                                    break;
                                }
                                d dVar = new d();
                                RecommendForumInfo recommendForumInfo = gVar.a;
                                dVar.n(aVar.f18225b.intValue());
                                dVar.p(aVar.f18226c);
                                dVar.m(recommendForumInfo.avatar);
                                dVar.q(recommendForumInfo.forum_id.longValue());
                                dVar.r(recommendForumInfo.forum_name);
                                dVar.s(recommendForumInfo.member_count.intValue());
                                dVar.w(recommendForumInfo.thread_count.intValue());
                                dVar.v(recommendForumInfo.slogan);
                                arrayList.add(dVar);
                                a++;
                            }
                        }
                        e eVar = new e();
                        eVar.f(aVar.f18225b.intValue());
                        eVar.g(aVar.f18226c);
                        arrayList.add(eVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<n> list2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (n nVar : list2) {
                if ((nVar instanceof d) && (dVar = (d) nVar) != null && dVar.b() == i) {
                    list.add(Long.valueOf(dVar.e()));
                }
            }
        }
    }

    public final void d(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nVar) == null) && (nVar instanceof e)) {
            ((e) nVar).i(false);
        }
    }
}
