package c.a.p0.f1.j;

import c.a.e.k.e.n;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.a0.d0.j;
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
/* loaded from: classes3.dex */
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
                if (next instanceof c2) {
                    c2 c2Var = (c2) next;
                    c2Var.a2 = true;
                    int[] g0 = c2Var.g0();
                    if (c2Var.getType() == c2.W2) {
                        if (c2Var != null && c2Var.Y() != null && !StringUtils.isNull(c2Var.Y().f14093b)) {
                            b2 b2Var = new b2();
                            b2Var.w = c2Var;
                            b2Var.position = i2;
                            b2Var.v = true;
                            b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(b2Var);
                        } else {
                            b2 b2Var2 = new b2();
                            b2Var2.w = c2Var;
                            b2Var2.position = i2;
                            b2Var2.f13845e = true;
                            b2Var2.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(b2Var2);
                        }
                        b2 b2Var3 = new b2();
                        b2Var3.w = c2Var;
                        b2Var3.position = i2;
                        if (c2Var.K1()) {
                            b2Var3.f13850j = true;
                        } else if (c2Var.X2() == 1) {
                            b2Var3.f13848h = true;
                            b2Var3.x = g0[0];
                            b2Var3.y = g0[1];
                        } else if (c2Var.X2() >= 2) {
                            b2Var3.f13849i = true;
                        } else {
                            b2Var3.f13846f = true;
                        }
                        b2Var3.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        b2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var3);
                        if (c2Var.q0() != null) {
                            b2 b2Var4 = new b2();
                            b2Var4.r = true;
                            b2Var4.w = c2Var;
                            b2Var4.position = i2;
                            b2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var4);
                        }
                        if (!ListUtils.isEmpty(c2Var.y0()) || !ListUtils.isEmpty(c2Var.c0())) {
                            b2 b2Var5 = new b2();
                            b2Var5.w = c2Var;
                            b2Var5.position = i2;
                            if (ListUtils.getCount(c2Var.y0()) + ListUtils.getCount(c2Var.c0()) == 1) {
                                b2Var5.t = true;
                            } else if (ListUtils.getCount(c2Var.y0()) + ListUtils.getCount(c2Var.c0()) > 1) {
                                b2Var5.u = true;
                            }
                            b2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var5);
                        }
                        b2 b2Var6 = new b2();
                        b2Var6.q = true;
                        b2Var6.w = c2Var;
                        b2Var6.position = i2;
                        arrayList2.add(b2Var6);
                        b2 b2Var7 = new b2();
                        b2Var7.k = true;
                        b2Var7.w = c2Var;
                        b2Var7.position = i2;
                        b2Var7.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(b2Var7);
                    } else if (c2Var.getType() == c2.t3) {
                        if (c2Var != null && c2Var.Y() != null && !StringUtils.isNull(c2Var.Y().f14093b)) {
                            b2 b2Var8 = new b2();
                            b2Var8.w = c2Var;
                            b2Var8.position = i2;
                            b2Var8.v = true;
                            b2Var8.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(b2Var8);
                        } else {
                            b2 b2Var9 = new b2();
                            b2Var9.w = c2Var;
                            b2Var9.position = i2;
                            b2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                            b2Var9.f13845e = true;
                            arrayList2.add(b2Var9);
                        }
                        b2 b2Var10 = new b2();
                        b2Var10.w = c2Var;
                        b2Var10.position = i2;
                        b2Var10.m = true;
                        c2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        b2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var10);
                        if (c2Var.q0() != null) {
                            b2 b2Var11 = new b2();
                            b2Var11.r = true;
                            b2Var11.w = c2Var;
                            b2Var11.position = i2;
                            b2Var11.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(b2Var11);
                        }
                        b2 b2Var12 = new b2();
                        b2Var12.q = true;
                        b2Var12.w = c2Var;
                        b2Var12.position = i2;
                        arrayList2.add(b2Var12);
                        b2 b2Var13 = new b2();
                        b2Var13.k = true;
                        b2Var13.w = c2Var;
                        b2Var13.position = i2;
                        b2Var13.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(b2Var13);
                    } else if (c2Var.getType() == c2.l3 && c2Var.J1()) {
                        c2Var.position = i2;
                        c2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(c2Var);
                    } else if (j.Y(c2Var)) {
                        j jVar = new j(c2Var);
                        jVar.l = c2Var.q1();
                        jVar.feedBackReasonMap = c2Var.h1;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        b2 b2Var14 = new b2();
                        b2Var14.w = c2Var;
                        b2Var14.position = i2;
                        b2Var14.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(b2Var14);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.o0.b.f.a.d(arrayList2);
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
                c2 c2Var = null;
                if (item instanceof b2) {
                    c2Var = ((b2) item).getThreadData();
                } else if (item instanceof c2) {
                    c2Var = (c2) item;
                } else if (item instanceof j) {
                    c2Var = ((j) item).f14959e;
                }
                if (c2Var != null && c2Var.q1().equals(str)) {
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

    public static void c(boolean z, ArrayList<n> arrayList, c.a.o0.s.q.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
            return;
        }
        if (i2 != 0 || z) {
            int size = arrayList.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (arrayList.get(i4) instanceof c2) {
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
