package c.a.s0.x2.i.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.s0.g0.f0.e;
import c.a.s0.g0.f0.f;
import c.a.s0.g0.f0.l;
import c.a.s0.x2.e.k;
import c.a.s0.y2.b;
import c.a.s0.y2.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f25793b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f25794c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074473717, "Lc/a/s0/x2/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074473717, "Lc/a/s0/x2/i/c/a;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds44);
        f25793b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds36);
        f25794c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds58);
    }

    public static List<n> a(List<d2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                d2 d2Var = (d2) ListUtils.getItem(list, i2);
                if (d2Var != null) {
                    c.a.r0.b.f.a.e(d2Var);
                    c.a.s0.g0.f0.b d2 = d(d2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.r0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<d2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                k kVar = new k();
                kVar.f25735h = f25794c;
                kVar.f25734g = f25793b;
                kVar.f25733f = a;
                kVar.f25732e = g.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    d2 d2Var = list.get(i2);
                    if (d2Var != null) {
                        c.a.r0.b.f.a.e(d2Var);
                        c.a.s0.g0.f0.b d2 = d(d2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                c.a.r0.b.f.a.d(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<n> list) {
        InterceptResult invokeL;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = (n) ListUtils.getItem(list, i2);
                if ((nVar instanceof CardPersonDynamicThreadData) && (d2Var = ((CardPersonDynamicThreadData) nVar).t) != null) {
                    c.a.r0.b.f.a.e(d2Var);
                    c.a.s0.g0.f0.b d2 = d(d2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.r0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static c.a.s0.g0.f0.b d(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var)) == null) {
            c.a.s0.g0.f0.b bVar = null;
            if (d2Var == null) {
                return null;
            }
            d2Var.f2 = true;
            d2Var.J1();
            if (d2Var.B1) {
                bVar = new c.a.s0.g0.f0.k();
                bVar.f17727e = d2Var;
            } else if (e.Y(d2Var)) {
                bVar = new e(d2Var);
            } else if (f.b0(d2Var)) {
                bVar = new f(d2Var);
            } else if (!c.a.s0.g0.f0.k.Y(d2Var) && !c.a.s0.g0.f0.k.Z(d2Var)) {
                if (l.T(d2Var)) {
                    bVar = new l(d2Var);
                }
            } else {
                bVar = new c.a.s0.g0.f0.k();
                if (!d2Var.h2() && !d2Var.z2()) {
                    d2Var.c2();
                }
                bVar.f17727e = d2Var;
            }
            if (bVar != null) {
                c.a.r0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (c.a.s0.g0.f0.b) invokeL.objValue;
    }

    public static d2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.r0.s.r.a)) {
                d2 threadData = ((c.a.r0.s.r.a) nVar).getThreadData();
                threadData.f2 = true;
                c.a.r0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (d2) invokeL.objValue;
    }
}
