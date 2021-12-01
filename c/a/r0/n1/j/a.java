package c.a.r0.n1.j;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.g0.f0.j;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d2 d2Var, int i2, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, d2Var, i2, arrayList) == null) {
            if (d2Var.l1() == 1) {
                b(d2Var, i2, arrayList, true);
            } else if (d2Var.Z() != null && !StringUtils.isNull(d2Var.Z().f13108b)) {
                b(d2Var, i2, arrayList, false);
            } else {
                b(d2Var, i2, arrayList, true);
            }
        }
    }

    public static void b(d2 d2Var, int i2, ArrayList<n> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{d2Var, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) {
            c2 c2Var = new c2();
            c2Var.w = d2Var;
            c2Var.position = i2;
            if (z) {
                c2Var.f12884e = true;
            } else {
                c2Var.v = true;
            }
            c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(c2Var);
        }
    }

    public static ArrayList<n> c(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    d2Var.e2 = true;
                    int[] h0 = d2Var.h0();
                    if (d2Var.getType() == d2.f3) {
                        a(d2Var, i2, arrayList2);
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        if (d2Var.Q1()) {
                            c2Var.f12889j = true;
                        } else if (d2Var.h3() == 1) {
                            c2Var.f12887h = true;
                            c2Var.x = h0[0];
                            c2Var.y = h0[1];
                        } else if (d2Var.h3() >= 2) {
                            c2Var.f12888i = true;
                        } else {
                            c2Var.f12885f = true;
                        }
                        c2Var.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        c2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var);
                        if (d2Var.t0() != null) {
                            c2 c2Var2 = new c2();
                            c2Var2.r = true;
                            c2Var2.w = d2Var;
                            c2Var2.position = i2;
                            c2Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var2);
                        }
                        if (!ListUtils.isEmpty(d2Var.B0()) || !ListUtils.isEmpty(d2Var.d0())) {
                            c2 c2Var3 = new c2();
                            c2Var3.w = d2Var;
                            c2Var3.position = i2;
                            if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) == 1) {
                                c2Var3.t = true;
                            } else if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) > 1) {
                                c2Var3.u = true;
                            }
                            c2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var3);
                        }
                        c2 c2Var4 = new c2();
                        c2Var4.q = true;
                        c2Var4.w = d2Var;
                        c2Var4.position = i2;
                        c2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(c2Var4);
                        c2 c2Var5 = new c2();
                        c2Var5.f12890k = true;
                        c2Var5.w = d2Var;
                        c2Var5.position = i2;
                        c2Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var5);
                    } else if (d2Var.getType() == d2.D3) {
                        a(d2Var, i2, arrayList2);
                        c2 c2Var6 = new c2();
                        c2Var6.w = d2Var;
                        c2Var6.position = i2;
                        c2Var6.m = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        c2Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var6);
                        if (d2Var.t0() != null) {
                            c2 c2Var7 = new c2();
                            c2Var7.r = true;
                            c2Var7.w = d2Var;
                            c2Var7.position = i2;
                            c2Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(c2Var7);
                        }
                        c2 c2Var8 = new c2();
                        c2Var8.q = true;
                        c2Var8.w = d2Var;
                        c2Var8.position = i2;
                        c2Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(c2Var8);
                        c2 c2Var9 = new c2();
                        c2Var9.f12890k = true;
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        c2Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var9);
                    } else if (d2Var.getType() == d2.v3 && d2Var.P1()) {
                        d2Var.position = i2;
                        d2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(d2Var);
                    } else if (j.Y(d2Var)) {
                        j jVar = new j(d2Var);
                        jVar.l = d2Var.v1();
                        jVar.feedBackReasonMap = d2Var.m1;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        c2 c2Var10 = new c2();
                        c2Var10.w = d2Var;
                        c2Var10.position = i2;
                        c2Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(c2Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.q0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
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
                    d2Var = ((j) item).f17245e;
                }
                if (d2Var != null && d2Var.v1().equals(str)) {
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

    public static void e(boolean z, ArrayList<n> arrayList, c.a.q0.s.q.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
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
