package c.a.p0.b3.j.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.b3.e.k;
import c.a.p0.h0.e0.b;
import c.a.p0.h0.e0.e;
import c.a.p0.h0.e0.f;
import c.a.p0.h0.e0.l;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12791b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12792c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(272990272, "Lc/a/p0/b3/j/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(272990272, "Lc/a/p0/b3/j/c/a;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        f12791b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        f12792c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<n> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                ThreadData threadData = (ThreadData) ListUtils.getItem(list, i);
                if (threadData != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    b d2 = d(threadData);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                k kVar = new k();
                kVar.f12733d = f12792c;
                kVar.f12732c = f12791b;
                kVar.f12731b = a;
                kVar.a = R.string.obfuscated_res_0x7f0f0df4;
                arrayList.add(kVar);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        b d2 = d(threadData);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<n> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                n nVar = (n) ListUtils.getItem(list, i);
                if ((nVar instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) nVar).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    b d2 = d(threadData);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static b d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            b bVar = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                bVar = new c.a.p0.h0.e0.k();
                bVar.a = threadData;
            } else if (e.W(threadData)) {
                bVar = new e(threadData);
            } else if (f.Z(threadData)) {
                bVar = new f(threadData);
            } else if (!c.a.p0.h0.e0.k.W(threadData) && !c.a.p0.h0.e0.k.X(threadData)) {
                if (l.R(threadData)) {
                    bVar = new l(threadData);
                }
            } else {
                bVar = new c.a.p0.h0.e0.k();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                bVar.a = threadData;
            }
            if (bVar != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(bVar);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static ThreadData e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof c.a.o0.r.r.a)) {
                ThreadData threadData = ((c.a.o0.r.r.a) nVar).getThreadData();
                threadData.isFromPersonPolymeric = true;
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                return threadData;
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }
}
