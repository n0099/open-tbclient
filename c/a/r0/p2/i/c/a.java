package c.a.r0.p2.i.c;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.b0.e0.b;
import c.a.r0.b0.e0.e;
import c.a.r0.b0.e0.f;
import c.a.r0.b0.e0.l;
import c.a.r0.p2.e.k;
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
    public static final int f23497a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23498b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23499c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-774842482, "Lc/a/r0/p2/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-774842482, "Lc/a/r0/p2/i/c/a;");
                return;
            }
        }
        f23497a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        f23498b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        f23499c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
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
                    c.a.q0.b.f.a.e(d2Var);
                    b d2 = d(d2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.q0.b.f.a.d(arrayList);
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
                kVar.f23426h = f23499c;
                kVar.f23425g = f23498b;
                kVar.f23424f = f23497a;
                kVar.f23423e = R.string.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    d2 d2Var = list.get(i2);
                    if (d2Var != null) {
                        c.a.q0.b.f.a.e(d2Var);
                        b d2 = d(d2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                c.a.q0.b.f.a.d(arrayList);
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
                    c.a.q0.b.f.a.e(d2Var);
                    b d2 = d(d2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            c.a.q0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static b d(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var)) == null) {
            b bVar = null;
            if (d2Var == null) {
                return null;
            }
            d2Var.e2 = true;
            d2Var.G1();
            if (d2Var.z1) {
                bVar = new c.a.r0.b0.e0.k();
                bVar.f15721e = d2Var;
            } else if (e.Y(d2Var)) {
                bVar = new e(d2Var);
            } else if (f.b0(d2Var)) {
                bVar = new f(d2Var);
            } else if (!c.a.r0.b0.e0.k.Y(d2Var) && !c.a.r0.b0.e0.k.Z(d2Var)) {
                if (l.T(d2Var)) {
                    bVar = new l(d2Var);
                }
            } else {
                bVar = new c.a.r0.b0.e0.k();
                if (!d2Var.e2() && !d2Var.w2()) {
                    d2Var.Z1();
                }
                bVar.f15721e = d2Var;
            }
            if (bVar != null) {
                c.a.q0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static d2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.q0.s.q.a)) {
                d2 threadData = ((c.a.q0.s.q.a) nVar).getThreadData();
                threadData.e2 = true;
                c.a.q0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (d2) invokeL.objValue;
    }
}
