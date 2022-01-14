package c.a.t0.x2.i.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.t0.g0.f0.e;
import c.a.t0.g0.f0.f;
import c.a.t0.g0.f0.l;
import c.a.t0.x2.e.k;
import c.a.t0.y2.b;
import c.a.t0.y2.g;
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
    public static final int f25501b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f25502c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2091410860, "Lc/a/t0/x2/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2091410860, "Lc/a/t0/x2/i/c/a;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds44);
        f25501b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds36);
        f25502c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds58);
    }

    public static List<n> a(List<e2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                e2 e2Var = (e2) ListUtils.getItem(list, i2);
                if (e2Var != null) {
                    c.a.s0.b.f.a.e(e2Var);
                    c.a.t0.g0.f0.b d2 = d(e2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.s0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<e2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                k kVar = new k();
                kVar.f25444h = f25502c;
                kVar.f25443g = f25501b;
                kVar.f25442f = a;
                kVar.f25441e = g.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    e2 e2Var = list.get(i2);
                    if (e2Var != null) {
                        c.a.s0.b.f.a.e(e2Var);
                        c.a.t0.g0.f0.b d2 = d(e2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                c.a.s0.b.f.a.d(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<n> list) {
        InterceptResult invokeL;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = (n) ListUtils.getItem(list, i2);
                if ((nVar instanceof CardPersonDynamicThreadData) && (e2Var = ((CardPersonDynamicThreadData) nVar).t) != null) {
                    c.a.s0.b.f.a.e(e2Var);
                    c.a.t0.g0.f0.b d2 = d(e2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.s0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static c.a.t0.g0.f0.b d(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2Var)) == null) {
            c.a.t0.g0.f0.b bVar = null;
            if (e2Var == null) {
                return null;
            }
            e2Var.e2 = true;
            e2Var.J1();
            if (e2Var.A1) {
                bVar = new c.a.t0.g0.f0.k();
                bVar.f17778e = e2Var;
            } else if (e.Y(e2Var)) {
                bVar = new e(e2Var);
            } else if (f.b0(e2Var)) {
                bVar = new f(e2Var);
            } else if (!c.a.t0.g0.f0.k.Y(e2Var) && !c.a.t0.g0.f0.k.Z(e2Var)) {
                if (l.T(e2Var)) {
                    bVar = new l(e2Var);
                }
            } else {
                bVar = new c.a.t0.g0.f0.k();
                if (!e2Var.h2() && !e2Var.z2()) {
                    e2Var.c2();
                }
                bVar.f17778e = e2Var;
            }
            if (bVar != null) {
                c.a.s0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (c.a.t0.g0.f0.b) invokeL.objValue;
    }

    public static e2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.s0.s.q.a)) {
                e2 threadData = ((c.a.s0.s.q.a) nVar).getThreadData();
                threadData.e2 = true;
                c.a.s0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (e2) invokeL.objValue;
    }
}
