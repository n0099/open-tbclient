package c.a.q0.f1.c.g;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.a0.d0.e;
import c.a.q0.a0.d0.j;
import c.a.q0.a0.d0.k;
import c.a.q0.a0.d0.l;
import c.a.q0.f1.c.d;
import c.a.q0.f1.h.k.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f17393a;

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
        this.f17393a = new c();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public c b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
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
                        if (c.a.q0.f1.c.f.c.p(builder.hot_recomforum, i3)) {
                            c.a.q0.f1.c.f.c cVar = new c.a.q0.f1.c.f.c();
                            if (cVar.k(builder.hot_recomforum.tab_list)) {
                                cVar.position = i3;
                                linkedList.add(cVar);
                                i3++;
                            }
                        }
                        if (c.a.q0.f1.c.f.a.o(concernData)) {
                            c.a.q0.f1.c.f.a aVar = new c.a.q0.f1.c.f.a();
                            if (concernData.recom_user_list.size() >= 4) {
                                aVar.i(concernData.recom_user_list);
                                aVar.position = i3;
                                aVar.p(builder.thread_info.size() > 1);
                                linkedList.add(aVar);
                            }
                        } else {
                            c2 c2Var = new c2();
                            c2Var.C3(true);
                            c.a.p0.b.f.a.e(c2Var);
                            c2Var.S2(concernData.thread_list);
                            JSONObject b2 = c.a.q0.x2.l0.b.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(e(c2Var, i3, concernData));
                        }
                        i3++;
                    }
                }
                c.a.p0.b.f.a.d(linkedList);
                c.a.q0.x2.l0.b.f().h("CONCERN", arrayList);
                c cVar2 = this.f17393a;
                cVar2.f17847a = linkedList;
                return cVar2;
            }
            return null;
        }
        return (c) invokeCommon.objValue;
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
                if (c.a.q0.f1.c.f.a.o(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!d.J()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && c.a.q0.f1.c.f.a.o(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.f17393a.f17848b = ListUtils.getCount(list) - count;
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

    public List<n> e(c2 c2Var, int i2, ConcernData concernData) {
        InterceptResult invokeLIL;
        c.a.q0.a0.d0.b kVar;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, c2Var, i2, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((k.Y(c2Var) || l.T(c2Var)) && c2Var.getType() != c2.y3) {
                if (l.T(c2Var)) {
                    kVar = new l(c2Var);
                } else {
                    kVar = new k();
                    c2Var.b2();
                    c2Var.s2();
                    if (!c2Var.b2() && !c2Var.s2()) {
                        c2Var.W1();
                    }
                    kVar.f15245e = c2Var;
                }
                kVar.l = c2Var.q1();
                if (k.Y(c2Var)) {
                    kVar.N("1");
                } else if (l.T(c2Var)) {
                    kVar.N("2");
                }
                kVar.F = true;
                if (c.a.p0.b.d.i() && kVar.getThreadData() != null && kVar.getThreadData().J() != null) {
                    if (!kVar.getThreadData().J().hadConcerned() && !ThreadCardUtils.isSelf(c2Var)) {
                        c.a.q0.f1.h.k.d.r(kVar);
                        c.a.q0.f1.h.k.d.o(c2Var);
                    } else {
                        c.a.q0.f1.h.k.d.t(kVar);
                    }
                } else {
                    c.a.q0.f1.h.k.d.t(kVar);
                }
                kVar.f15245e.E1();
                if (kVar instanceof k) {
                    if (c2Var.K1()) {
                        c.a.q0.f1.h.k.d.u(kVar);
                    } else if (c2Var.X2() == 1) {
                        c.a.q0.f1.h.k.d.w(kVar);
                        int[] g0 = c2Var.g0();
                        kVar.o = g0[0];
                        kVar.p = g0[1];
                    } else if (c2Var.X2() >= 2) {
                        c.a.q0.f1.h.k.d.v(kVar);
                    } else {
                        c.a.q0.f1.h.k.d.x(kVar);
                    }
                } else if (kVar instanceof l) {
                    c.a.q0.f1.h.k.d.y(kVar);
                }
                if (c2Var.q0() != null) {
                    c.a.q0.f1.h.k.d.z(kVar);
                }
                if (!ListUtils.isEmpty(c2Var.y0()) || !ListUtils.isEmpty(c2Var.c0())) {
                    if (ListUtils.getCount(c2Var.y0()) + ListUtils.getCount(c2Var.c0()) == 1) {
                        c.a.q0.f1.h.k.d.C(kVar);
                    } else {
                        c.a.q0.f1.h.k.d.A(kVar);
                    }
                }
                c.a.q0.f1.h.k.d.q(kVar);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    c.a.q0.f1.h.k.d.s(kVar);
                }
                c.a.q0.f1.h.k.d.p(kVar);
                kVar.setSupportType(BaseCardInfo.SupportType.TOP);
                kVar.position = i2;
                arrayList.add(kVar);
            } else {
                if (c.a.p0.b.d.i()) {
                    c2Var.getThreadData();
                    if (c2Var != null) {
                        c2Var.getThreadData();
                        if (c2Var.J() != null) {
                            c2Var.getThreadData();
                            boolean hadConcerned = c2Var.J().hadConcerned();
                            if (!hadConcerned && (hadConcerned || !ThreadCardUtils.isSelf(c2Var))) {
                                c.a.q0.f1.h.k.d.o(c2Var);
                            }
                        }
                    }
                }
                if (c2Var.w1) {
                    k kVar2 = new k();
                    kVar2.f15245e = c2Var;
                    kVar2.position = i2;
                    arrayList.add(kVar2);
                } else if (l.T(c2Var)) {
                    l lVar = new l(c2Var);
                    lVar.l = c2Var.q1();
                    if (concernData != null) {
                        lVar.M(concernData.source.intValue());
                    }
                    if (lVar.isValid()) {
                        arrayList.add(lVar);
                    }
                } else if (j.Y(c2Var)) {
                    j jVar = new j(c2Var);
                    jVar.l = c2Var.q1();
                    jVar.N("3");
                    if (jVar.isValid()) {
                        arrayList.add(jVar);
                    }
                } else if (e.Y(c2Var) && c2Var.J1()) {
                    e eVar = new e(c2Var);
                    eVar.position = i2;
                    arrayList.add(eVar);
                } else {
                    k kVar3 = new k();
                    kVar3.f15245e = c2Var;
                    kVar3.N(c2Var.b2() ? "4" : "1");
                    kVar3.position = i2;
                    if (concernData != null) {
                        kVar3.M(concernData.source.intValue());
                    }
                    if (kVar3.f15245e != null && kVar3.isValid() && !StringUtils.isNull(kVar3.f15245e.f0()) && !"0".equals(kVar3.f15245e.q1())) {
                        arrayList.add(kVar3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
