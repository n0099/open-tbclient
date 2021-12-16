package c.a.s0.o1.c.g;

import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.s0.g0.f0.j;
import c.a.s0.g0.f0.k;
import c.a.s0.g0.f0.l;
import c.a.s0.g0.f0.m;
import c.a.s0.o1.c.f.c;
import c.a.s0.o1.h.k.d;
import c.a.s0.o1.h.k.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;

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
        this.a = new d();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public d b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)})) == null) {
            if (i2 == 0 || i2 == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                d(z, builder, builder2, i2);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (ConcernData concernData : builder.thread_info) {
                    if (concernData != null) {
                        if (c.p(builder.hot_recomforum, i3)) {
                            c cVar = new c();
                            if (cVar.k(builder.hot_recomforum.tab_list)) {
                                cVar.position = i3;
                                linkedList.add(cVar);
                                i3++;
                            }
                        }
                        if (c.a.s0.o1.c.f.a.o(concernData)) {
                            c.a.s0.o1.c.f.a aVar = new c.a.s0.o1.c.f.a();
                            if (concernData.recom_user_list.size() >= 4) {
                                aVar.i(concernData.recom_user_list);
                                aVar.position = i3;
                                aVar.p(builder.thread_info.size() > 1);
                                linkedList.add(aVar);
                            }
                        } else {
                            d2 d2Var = new d2();
                            d2Var.N3(true);
                            c.a.r0.b.f.a.e(d2Var);
                            d2Var.c3(concernData.thread_list);
                            JSONObject b2 = c.a.s0.j3.l0.b.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(e(d2Var, i3, concernData));
                        }
                        i3++;
                    }
                }
                c.a.r0.b.f.a.d(linkedList);
                c.a.s0.j3.l0.b.f().h("CONCERN", arrayList);
                d dVar = this.a;
                dVar.a = linkedList;
                return dVar;
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i2) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i2)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i2 == 1) {
            for (ConcernData concernData : list2) {
                if (c.a.s0.o1.c.f.a.o(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!c.a.s0.o1.c.d.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && c.a.s0.o1.c.f.a.o(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.f21088b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        c(z, list, list2, i2);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<n> e(d2 d2Var, int i2, ConcernData concernData) {
        InterceptResult invokeLIL;
        c.a.s0.g0.f0.b kVar;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, d2Var, i2, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((k.Y(d2Var) || l.T(d2Var) || m.Y(d2Var)) && d2Var.getType() != d2.J3) {
                if (m.Y(d2Var)) {
                    kVar = new m(d2Var);
                } else if (l.T(d2Var)) {
                    kVar = new l(d2Var);
                } else {
                    kVar = new k();
                    d2Var.h2();
                    d2Var.z2();
                    if (!d2Var.h2() && !d2Var.z2()) {
                        d2Var.c2();
                    }
                    kVar.f17727e = d2Var;
                }
                kVar.l = d2Var.v1();
                if (k.Y(d2Var)) {
                    kVar.N("1");
                } else if (l.T(d2Var)) {
                    kVar.N("2");
                }
                kVar.G = true;
                if (c.a.r0.b.d.j() && kVar.getThreadData() != null && kVar.getThreadData().J() != null) {
                    if (!kVar.getThreadData().J().hadConcerned() && !ThreadCardUtils.isSelf(d2Var)) {
                        e.r(kVar);
                        e.o(d2Var);
                    } else {
                        e.t(kVar);
                    }
                } else if (kVar instanceof m) {
                    e.t(kVar);
                } else {
                    e.t(kVar);
                }
                kVar.f17727e.J1();
                if (kVar instanceof k) {
                    if (d2Var.Q1()) {
                        e.u(kVar);
                    } else if (d2Var.h3() == 1) {
                        e.w(kVar);
                        int[] h0 = d2Var.h0();
                        kVar.o = h0[0];
                        kVar.p = h0[1];
                    } else if (d2Var.h3() >= 2) {
                        e.v(kVar);
                    } else {
                        e.x(kVar);
                    }
                } else if (kVar instanceof l) {
                    e.y(kVar);
                }
                if (kVar instanceof m) {
                    e.z(kVar);
                }
                if (d2Var.t0() != null) {
                    e.A(kVar);
                }
                if (!ListUtils.isEmpty(d2Var.B0()) || !ListUtils.isEmpty(d2Var.d0())) {
                    if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) == 1) {
                        e.D(kVar);
                    } else {
                        e.B(kVar);
                    }
                }
                e.q(kVar);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    e.s(kVar);
                }
                e.p(kVar);
                kVar.setSupportType(BaseCardInfo.SupportType.TOP);
                kVar.position = i2;
                arrayList.add(kVar);
            } else {
                if (c.a.r0.b.d.j() && d2Var.getThreadData() != null && d2Var.getThreadData().J() != null && !(hadConcerned = d2Var.getThreadData().J().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(d2Var))) {
                    e.o(d2Var);
                }
                if (d2Var.B1) {
                    k kVar2 = new k();
                    kVar2.f17727e = d2Var;
                    kVar2.position = i2;
                    arrayList.add(kVar2);
                } else if (l.T(d2Var)) {
                    l lVar = new l(d2Var);
                    lVar.l = d2Var.v1();
                    if (concernData != null) {
                        lVar.M(concernData.source.intValue());
                    }
                    if (lVar.isValid()) {
                        arrayList.add(lVar);
                    }
                } else if (j.Y(d2Var)) {
                    j jVar = new j(d2Var);
                    jVar.l = d2Var.v1();
                    jVar.N("3");
                    if (jVar.isValid()) {
                        arrayList.add(jVar);
                    }
                } else if (c.a.s0.g0.f0.e.Y(d2Var) && d2Var.P1()) {
                    c.a.s0.g0.f0.e eVar = new c.a.s0.g0.f0.e(d2Var);
                    eVar.position = i2;
                    arrayList.add(eVar);
                } else {
                    k kVar3 = new k();
                    kVar3.f17727e = d2Var;
                    kVar3.N(d2Var.h2() ? "4" : "1");
                    kVar3.position = i2;
                    if (concernData != null) {
                        kVar3.M(concernData.source.intValue());
                    }
                    if (kVar3.f17727e != null && kVar3.isValid() && !StringUtils.isNull(kVar3.f17727e.g0()) && !"0".equals(kVar3.f17727e.v1())) {
                        arrayList.add(kVar3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
