package c.a.u0.z2.j.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.e2;
import c.a.u0.a3.b;
import c.a.u0.a3.g;
import c.a.u0.g0.d0.e;
import c.a.u0.g0.d0.f;
import c.a.u0.g0.d0.l;
import c.a.u0.z2.e.k;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f26087b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26088c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1253640620, "Lc/a/u0/z2/j/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1253640620, "Lc/a/u0/z2/j/c/a;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds44);
        f26087b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds36);
        f26088c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.tbds58);
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
                    c.a.t0.b.f.a.e(e2Var);
                    c.a.u0.g0.d0.b d2 = d(e2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.t0.b.f.a.d(arrayList);
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
                kVar.f26011h = f26088c;
                kVar.f26010g = f26087b;
                kVar.f26009f = a;
                kVar.f26008e = g.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    e2 e2Var = list.get(i2);
                    if (e2Var != null) {
                        c.a.t0.b.f.a.e(e2Var);
                        c.a.u0.g0.d0.b d2 = d(e2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                c.a.t0.b.f.a.d(arrayList);
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
                    c.a.t0.b.f.a.e(e2Var);
                    c.a.u0.g0.d0.b d2 = d(e2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.t0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static c.a.u0.g0.d0.b d(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2Var)) == null) {
            c.a.u0.g0.d0.b bVar = null;
            if (e2Var == null) {
                return null;
            }
            e2Var.e2 = true;
            e2Var.K1();
            if (e2Var.A1) {
                bVar = new c.a.u0.g0.d0.k();
                bVar.f17886e = e2Var;
            } else if (e.X(e2Var)) {
                bVar = new e(e2Var);
            } else if (f.a0(e2Var)) {
                bVar = new f(e2Var);
            } else if (!c.a.u0.g0.d0.k.X(e2Var) && !c.a.u0.g0.d0.k.Y(e2Var)) {
                if (l.S(e2Var)) {
                    bVar = new l(e2Var);
                }
            } else {
                bVar = new c.a.u0.g0.d0.k();
                if (!e2Var.i2() && !e2Var.A2()) {
                    e2Var.d2();
                }
                bVar.f17886e = e2Var;
            }
            if (bVar != null) {
                c.a.t0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (c.a.u0.g0.d0.b) invokeL.objValue;
    }

    public static e2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.t0.s.r.a)) {
                e2 threadData = ((c.a.t0.s.r.a) nVar).getThreadData();
                threadData.e2 = true;
                c.a.t0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (e2) invokeL.objValue;
    }
}
