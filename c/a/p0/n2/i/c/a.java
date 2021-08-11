package c.a.p0.n2.i.c;

import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.p0.a0.d0.b;
import c.a.p0.a0.d0.e;
import c.a.p0.a0.d0.f;
import c.a.p0.a0.d0.l;
import c.a.p0.n2.e.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f22386a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f22387b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f22388c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1713066290, "Lc/a/p0/n2/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1713066290, "Lc/a/p0/n2/i/c/a;");
                return;
            }
        }
        f22386a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        f22387b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        f22388c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<n> a(List<c2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                c2 c2Var = (c2) ListUtils.getItem(list, i2);
                if (c2Var != null) {
                    c.a.o0.b.f.a.e(c2Var);
                    b d2 = d(c2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.o0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<c2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                k kVar = new k();
                kVar.f22315h = f22388c;
                kVar.f22314g = f22387b;
                kVar.f22313f = f22386a;
                kVar.f22312e = R.string.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    c2 c2Var = list.get(i2);
                    if (c2Var != null) {
                        c.a.o0.b.f.a.e(c2Var);
                        b d2 = d(c2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                c.a.o0.b.f.a.d(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<n> list) {
        InterceptResult invokeL;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = (n) ListUtils.getItem(list, i2);
                if ((nVar instanceof CardPersonDynamicThreadData) && (c2Var = ((CardPersonDynamicThreadData) nVar).r) != null) {
                    c.a.o0.b.f.a.e(c2Var);
                    b d2 = d(c2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.o0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static b d(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c2Var)) == null) {
            b bVar = null;
            if (c2Var == null) {
                return null;
            }
            c2Var.b2 = true;
            c2Var.E1();
            if (c2Var.w1) {
                bVar = new c.a.p0.a0.d0.k();
                bVar.f14959e = c2Var;
            } else if (e.Y(c2Var)) {
                bVar = new e(c2Var);
            } else if (f.b0(c2Var)) {
                bVar = new f(c2Var);
            } else if (!c.a.p0.a0.d0.k.Y(c2Var) && !c.a.p0.a0.d0.k.Z(c2Var)) {
                if (l.T(c2Var)) {
                    bVar = new l(c2Var);
                }
            } else {
                bVar = new c.a.p0.a0.d0.k();
                if (!c2Var.b2() && !c2Var.s2()) {
                    c2Var.W1();
                }
                bVar.f14959e = c2Var;
            }
            if (bVar != null) {
                c.a.o0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static c2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.o0.s.q.a)) {
                c2 threadData = ((c.a.o0.s.q.a) nVar).getThreadData();
                threadData.b2 = true;
                c.a.o0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (c2) invokeL.objValue;
    }
}
