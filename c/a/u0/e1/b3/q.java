package c.a.u0.e1.b3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.a.w;
import c.a.t0.s.r.c2;
import c.a.t0.s.r.e2;
import c.a.u0.e1.z1.d.e0;
import c.a.u0.l3.z;
import c.a.u0.z3.m0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.u0.e1.y2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f17331c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f17331c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(c.a.u0.e1.q qVar, FrsViewData frsViewData, String str, boolean z, e2 e2Var) {
        c.a.t0.t.c.d adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), e2Var}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g()) {
            return;
        }
        e0 W = qVar == null ? null : qVar.W();
        List<c.a.d.o.e.n> g2 = W != null ? W.g() : null;
        List<c.a.d.o.e.n> singletonList = e2Var != null ? Collections.singletonList(e2Var) : g2;
        if (singletonList == null || g2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (c.a.d.o.e.n nVar : g2) {
                i2++;
                for (c.a.d.o.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof e2)) {
                        a.c cVar = new a.c();
                        cVar.a = ((e2) nVar2).w1();
                        cVar.f26273c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (c.a.d.o.e.n nVar3 : singletonList) {
                if (nVar3 instanceof e2) {
                    e2 e2Var2 = (e2) nVar3;
                    i2++;
                    if (e2Var2.E0 == 1 && !TextUtils.isEmpty(e2Var2.w1())) {
                        e2Var2.E0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.a = e2Var2.w1();
                        cVar2.f26273c = i2;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            z.v(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.i());
        }
    }

    public static void c(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, c2Var) == null) || c2Var == null) {
            return;
        }
        String d2 = c2Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = c2Var.f();
        }
        String str = d2;
        String b2 = c2Var.b();
        String c2 = c2Var.c();
        String g2 = c2Var.g();
        c.a.u0.z3.m0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + c2Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, e2Var) == null) || e2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController modelController = frsFragment.getModelController();
        c.a.u0.e1.q frsView = frsFragment.getFrsView();
        if (frsView == null || modelController == null) {
            return;
        }
        if (e2Var.J() != null && e2Var.J().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", e2Var.h0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            c.a.u0.e1.y2.b bVar = new c.a.u0.e1.y2.b();
            bVar.a = frsViewData.needLog == 1;
            bVar.f17331c = frsViewData.getForum().getId();
            bVar.f17332d = frsViewData.getForum().getName();
            bVar.f17330b = modelController.R();
            c.a.u0.e1.y2.b bVar2 = c.a.u0.e1.y2.d.p0;
            if (bVar2 != null) {
                bVar.f17333e = bVar2.f17333e;
                bVar.f17334f = bVar2.f17334f;
            }
            c.a.u0.e1.y2.c.k().h(bVar, e2Var, 1);
            c.a.u0.e1.y2.a.e(e2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(frsView, frsViewData, frsFragment.getForumId(), true, e2Var);
    }

    public static void e(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i2).param("obj_type", i3).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
            w.a(param, str);
            TiebaStatic.log(param);
        }
    }

    public static void f(FrsModelController frsModelController, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65541, null, frsModelController, j2) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j2, frsModelController.f0() - j2, frsModelController.h0(), frsModelController.g0(), currentTimeMillis - frsModelController.e0());
    }

    public static void g(@Nullable e2 e2Var, @Nullable FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, e2Var, frsViewData, i2) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        c.a.u0.e1.y2.a.d(e2Var, frsViewData.getForum().getId(), i2);
    }
}
