package c.a.p0.f1.r2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.w;
import c.a.o0.r.r.z1;
import c.a.p0.a4.m0.a;
import c.a.p0.f1.p1.d.e0;
import c.a.p0.l3.a0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.p0.f1.o2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f14300c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f14300c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(c.a.p0.f1.q qVar, FrsViewData frsViewData, String str, boolean z, ThreadData threadData) {
        c.a.o0.s.c.c adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), threadData}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g()) {
            return;
        }
        e0 W = qVar == null ? null : qVar.W();
        List<c.a.d.o.e.n> f2 = W != null ? W.f() : null;
        List<c.a.d.o.e.n> singletonList = threadData != null ? Collections.singletonList(threadData) : f2;
        if (singletonList == null || f2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (z) {
            for (c.a.d.o.e.n nVar : f2) {
                i++;
                for (c.a.d.o.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof ThreadData)) {
                        a.c cVar = new a.c();
                        cVar.a = ((ThreadData) nVar2).getTid();
                        cVar.f12289c = i;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (c.a.d.o.e.n nVar3 : singletonList) {
                if (nVar3 instanceof ThreadData) {
                    ThreadData threadData2 = (ThreadData) nVar3;
                    i++;
                    if (threadData2.showStatus == 1 && !TextUtils.isEmpty(threadData2.getTid())) {
                        threadData2.showStatus = 2;
                        a.c cVar2 = new a.c();
                        cVar2.a = threadData2.getTid();
                        cVar2.f12289c = i;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            a0.v(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.i());
        }
    }

    public static void c(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, z1Var) == null) || z1Var == null) {
            return;
        }
        String d2 = z1Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = z1Var.f();
        }
        String str = d2;
        String b2 = z1Var.b();
        String c2 = z1Var.c();
        String g2 = z1Var.g();
        c.a.p0.a4.m0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + z1Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, threadData) == null) || threadData == null || frsViewData == null) {
            return;
        }
        FrsModelController b0 = frsFragment.b0();
        c.a.p0.f1.q x0 = frsFragment.x0();
        if (x0 == null || b0 == null) {
            return;
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", threadData.getId()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            c.a.p0.f1.o2.b bVar = new c.a.p0.f1.o2.b();
            bVar.a = frsViewData.needLog == 1;
            bVar.f14300c = frsViewData.getForum().getId();
            bVar.f14301d = frsViewData.getForum().getName();
            bVar.f14299b = b0.T();
            c.a.p0.f1.o2.b bVar2 = c.a.p0.f1.o2.d.f0;
            if (bVar2 != null) {
                bVar.f14302e = bVar2.f14302e;
                bVar.f14303f = bVar2.f14303f;
            }
            c.a.p0.f1.o2.c.k().h(bVar, threadData, 1);
            c.a.p0.f1.o2.a.e(threadData, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(x0, frsViewData, frsFragment.c(), true, threadData);
    }

    public static void e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            w.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.h0() - j, frsModelController.j0(), frsModelController.i0(), currentTimeMillis - frsModelController.g0());
    }

    public static void g(@Nullable ThreadData threadData, @Nullable FrsViewData frsViewData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, threadData, frsViewData, i) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        c.a.p0.f1.o2.a.d(threadData, frsViewData.getForum().getId(), i);
    }
}
