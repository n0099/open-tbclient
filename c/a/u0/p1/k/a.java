package c.a.u0.p1.k;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.u0.g0.d0.j;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e2 e2Var, int i2, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, e2Var, i2, arrayList) == null) {
            if (e2Var.m1() == 1) {
                b(e2Var, i2, arrayList, true);
            } else if (e2Var.Z() != null && !StringUtils.isNull(e2Var.Z().f13743b)) {
                b(e2Var, i2, arrayList, false);
            } else {
                b(e2Var, i2, arrayList, true);
            }
        }
    }

    public static void b(e2 e2Var, int i2, ArrayList<n> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{e2Var, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) {
            d2 d2Var = new d2();
            d2Var.w = e2Var;
            d2Var.position = i2;
            if (z) {
                d2Var.f13813e = true;
            } else {
                d2Var.v = true;
            }
            d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(d2Var);
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
                if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    e2Var.d2 = true;
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3) {
                        a(e2Var, i2, arrayList2);
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        if (e2Var.R1()) {
                            d2Var.f13818j = true;
                        } else if (e2Var.i3() == 1) {
                            d2Var.f13816h = true;
                            d2Var.x = i0[0];
                            d2Var.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var.f13817i = true;
                        } else {
                            d2Var.f13814f = true;
                        }
                        d2Var.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        d2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var);
                        if (e2Var.u0() != null) {
                            d2 d2Var2 = new d2();
                            d2Var2.r = true;
                            d2Var2.w = e2Var;
                            d2Var2.position = i2;
                            d2Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var2);
                        }
                        if (!ListUtils.isEmpty(e2Var.C0()) || !ListUtils.isEmpty(e2Var.e0())) {
                            d2 d2Var3 = new d2();
                            d2Var3.w = e2Var;
                            d2Var3.position = i2;
                            if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) == 1) {
                                d2Var3.t = true;
                            } else if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) > 1) {
                                d2Var3.u = true;
                            }
                            d2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var3);
                        }
                        d2 d2Var4 = new d2();
                        d2Var4.q = true;
                        d2Var4.w = e2Var;
                        d2Var4.position = i2;
                        d2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(d2Var4);
                        d2 d2Var5 = new d2();
                        d2Var5.k = true;
                        d2Var5.w = e2Var;
                        d2Var5.position = i2;
                        d2Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var5);
                    } else if (e2Var.getType() == e2.H3) {
                        a(e2Var, i2, arrayList2);
                        d2 d2Var6 = new d2();
                        d2Var6.w = e2Var;
                        d2Var6.position = i2;
                        d2Var6.m = true;
                        e2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        d2Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var6);
                        if (e2Var.u0() != null) {
                            d2 d2Var7 = new d2();
                            d2Var7.r = true;
                            d2Var7.w = e2Var;
                            d2Var7.position = i2;
                            d2Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(d2Var7);
                        }
                        d2 d2Var8 = new d2();
                        d2Var8.q = true;
                        d2Var8.w = e2Var;
                        d2Var8.position = i2;
                        d2Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(d2Var8);
                        d2 d2Var9 = new d2();
                        d2Var9.k = true;
                        d2Var9.w = e2Var;
                        d2Var9.position = i2;
                        d2Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var9);
                    } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                        e2Var.position = i2;
                        e2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(e2Var);
                    } else if (j.X(e2Var)) {
                        j jVar = new j(e2Var);
                        jVar.k = e2Var.w1();
                        jVar.feedBackReasonMap = e2Var.l1;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        d2 d2Var10 = new d2();
                        d2Var10.w = e2Var;
                        d2Var10.position = i2;
                        d2Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(d2Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.t0.b.f.a.d(arrayList2);
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
                e2 e2Var = null;
                if (item instanceof d2) {
                    e2Var = ((d2) item).getThreadData();
                } else if (item instanceof e2) {
                    e2Var = (e2) item;
                } else if (item instanceof j) {
                    e2Var = ((j) item).f17886e;
                }
                if (e2Var != null && e2Var.w1().equals(str)) {
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

    public static void e(boolean z, ArrayList<n> arrayList, c.a.t0.s.r.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
            return;
        }
        if (i2 != 0 || z) {
            int size = arrayList.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (arrayList.get(i4) instanceof e2) {
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
