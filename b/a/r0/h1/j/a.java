package b.a.r0.h1.j;

import b.a.e.l.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.e0.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<n> a(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    d2Var.d2 = true;
                    int[] g0 = d2Var.g0();
                    if (d2Var.getType() == d2.a3) {
                        if (d2Var != null && d2Var.Y() != null && !StringUtils.isNull(d2Var.Y().f13506b)) {
                            c2 c2Var = new c2();
                            c2Var.w = d2Var;
                            c2Var.position = i2;
                            c2Var.v = true;
                            c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(c2Var);
                        } else {
                            c2 c2Var2 = new c2();
                            c2Var2.w = d2Var;
                            c2Var2.position = i2;
                            c2Var2.f13254e = true;
                            c2Var2.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(c2Var2);
                        }
                        c2 c2Var3 = new c2();
                        c2Var3.w = d2Var;
                        c2Var3.position = i2;
                        if (d2Var.N1()) {
                            c2Var3.j = true;
                        } else if (d2Var.d3() == 1) {
                            c2Var3.f13257h = true;
                            c2Var3.x = g0[0];
                            c2Var3.y = g0[1];
                        } else if (d2Var.d3() >= 2) {
                            c2Var3.f13258i = true;
                        } else {
                            c2Var3.f13255f = true;
                        }
                        c2Var3.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        c2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var3);
                        if (d2Var.s0() != null) {
                            c2 c2Var4 = new c2();
                            c2Var4.r = true;
                            c2Var4.w = d2Var;
                            c2Var4.position = i2;
                            c2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var4);
                        }
                        if (!ListUtils.isEmpty(d2Var.A0()) || !ListUtils.isEmpty(d2Var.c0())) {
                            c2 c2Var5 = new c2();
                            c2Var5.w = d2Var;
                            c2Var5.position = i2;
                            if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) == 1) {
                                c2Var5.t = true;
                            } else if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) > 1) {
                                c2Var5.u = true;
                            }
                            c2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var5);
                        }
                        c2 c2Var6 = new c2();
                        c2Var6.q = true;
                        c2Var6.w = d2Var;
                        c2Var6.position = i2;
                        arrayList2.add(c2Var6);
                        c2 c2Var7 = new c2();
                        c2Var7.k = true;
                        c2Var7.w = d2Var;
                        c2Var7.position = i2;
                        c2Var7.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var7);
                    } else if (d2Var.getType() == d2.x3) {
                        if (d2Var != null && d2Var.Y() != null && !StringUtils.isNull(d2Var.Y().f13506b)) {
                            c2 c2Var8 = new c2();
                            c2Var8.w = d2Var;
                            c2Var8.position = i2;
                            c2Var8.v = true;
                            c2Var8.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(c2Var8);
                        } else {
                            c2 c2Var9 = new c2();
                            c2Var9.w = d2Var;
                            c2Var9.position = i2;
                            c2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                            c2Var9.f13254e = true;
                            arrayList2.add(c2Var9);
                        }
                        c2 c2Var10 = new c2();
                        c2Var10.w = d2Var;
                        c2Var10.position = i2;
                        c2Var10.m = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        c2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var10);
                        if (d2Var.s0() != null) {
                            c2 c2Var11 = new c2();
                            c2Var11.r = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            c2Var11.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(c2Var11);
                        }
                        c2 c2Var12 = new c2();
                        c2Var12.q = true;
                        c2Var12.w = d2Var;
                        c2Var12.position = i2;
                        arrayList2.add(c2Var12);
                        c2 c2Var13 = new c2();
                        c2Var13.k = true;
                        c2Var13.w = d2Var;
                        c2Var13.position = i2;
                        c2Var13.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var13);
                    } else if (d2Var.getType() == d2.p3 && d2Var.M1()) {
                        d2Var.position = i2;
                        d2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(d2Var);
                    } else if (j.Y(d2Var)) {
                        j jVar = new j(d2Var);
                        jVar.l = d2Var.s1();
                        jVar.feedBackReasonMap = d2Var.k1;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        c2 c2Var14 = new c2();
                        c2Var14.w = d2Var;
                        c2Var14.position = i2;
                        c2Var14.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(c2Var14);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            b.a.q0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                n item = bdTypeRecyclerView.getItem(i4);
                d2 d2Var = null;
                if (item instanceof c2) {
                    d2Var = ((c2) item).getThreadData();
                } else if (item instanceof d2) {
                    d2Var = (d2) item;
                } else if (item instanceof j) {
                    d2Var = ((j) item).f14748e;
                }
                if (d2Var != null && d2Var.s1().equals(str)) {
                    if (!z) {
                        i2 = i4;
                    }
                    z = true;
                    i3 = i4;
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void c(boolean z, ArrayList<n> arrayList, b.a.q0.s.q.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
            return;
        }
        if (i2 != 0 || z) {
            int size = arrayList.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (arrayList.get(i4) instanceof d2) {
                    if (i2 == i3) {
                        ListUtils.add(arrayList, i4, aVar);
                        return;
                    }
                    i3++;
                }
            }
        }
    }
}
