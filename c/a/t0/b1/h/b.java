package c.a.t0.b1.h;

import c.a.d.o.e.n;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.u0.g0.d0.j;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<? extends n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (n nVar : list) {
                if (nVar instanceof e2) {
                    e2 e2Var = (e2) nVar;
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13813e = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.R1()) {
                            d2Var2.f13818j = true;
                        } else if (e2Var.i3() == 1) {
                            d2Var2.f13816h = true;
                            d2Var2.x = i0[0];
                            d2Var2.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var2.f13817i = true;
                        } else {
                            d2Var2.f13814f = true;
                        }
                        d2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(d2Var2);
                        if (e2Var.u0() != null) {
                            d2 d2Var3 = new d2();
                            d2Var3.r = true;
                            d2Var3.w = e2Var;
                            d2Var3.position = i2;
                            d2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d2Var3);
                        }
                        if (!ListUtils.isEmpty(e2Var.C0())) {
                            d2 d2Var4 = new d2();
                            d2Var4.w = e2Var;
                            d2Var4.position = i2;
                            if (ListUtils.getCount(e2Var.C0()) == 1) {
                                d2Var4.t = true;
                            } else {
                                d2Var4.u = true;
                            }
                            d2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d2Var4);
                        }
                        d2 d2Var5 = new d2();
                        d2Var5.q = true;
                        d2Var5.w = e2Var;
                        d2Var5.position = i2;
                        d2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d2Var5);
                        d2 d2Var6 = new d2();
                        d2Var6.k = true;
                        d2Var6.w = e2Var;
                        d2Var6.position = i2;
                        d2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(d2Var6);
                    } else if (e2Var.getType() == e2.H3) {
                        d2 d2Var7 = new d2();
                        d2Var7.w = e2Var;
                        d2Var7.position = i2;
                        d2Var7.f13813e = true;
                        d2Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(d2Var7);
                        d2 d2Var8 = new d2();
                        d2Var8.w = e2Var;
                        d2Var8.position = i2;
                        d2Var8.m = true;
                        d2Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d2Var8);
                        if (e2Var.u0() != null) {
                            d2 d2Var9 = new d2();
                            d2Var9.r = true;
                            d2Var9.w = e2Var;
                            d2Var9.position = i2;
                            d2Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d2Var9);
                        }
                        d2 d2Var10 = new d2();
                        d2Var10.q = true;
                        d2Var10.w = e2Var;
                        d2Var10.position = i2;
                        d2Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d2Var10);
                        d2 d2Var11 = new d2();
                        d2Var11.k = true;
                        d2Var11.w = e2Var;
                        d2Var11.position = i2;
                        d2Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(d2Var11);
                    } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                        d2 d2Var12 = new d2();
                        d2Var12.w = e2Var;
                        d2Var12.position = i2;
                        arrayList.add(d2Var12);
                    } else if (j.X(e2Var)) {
                        j jVar = new j(e2Var);
                        jVar.k = e2Var.w1();
                        arrayList.add(jVar);
                    } else {
                        d2 d2Var13 = new d2();
                        d2Var13.w = e2Var;
                        d2Var13.position = i2;
                        arrayList.add(d2Var13);
                    }
                } else if (nVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nVar).position = i2;
                    arrayList.add(nVar);
                } else {
                    arrayList.add(nVar);
                }
                i2++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<n> list, c.a.t0.s.r.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, aVar) == null) || aVar == null || list == null || (i2 = aVar.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (list.get(i4) instanceof e2) {
                if (i2 == i3) {
                    a.b("insertFloorPosition-> floorPosition = " + i2);
                    ListUtils.add(list, i4, aVar);
                    return;
                }
                i3++;
            }
        }
    }

    public static List<e2> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                e2 e2Var = new e2();
                e2Var.d3(threadInfo);
                e2Var.K1();
                arrayList.add(e2Var);
            }
            String str = "parserThreadList-> size = " + arrayList.size();
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
