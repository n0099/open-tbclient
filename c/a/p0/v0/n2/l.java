package c.a.p0.v0.n2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.w;
import c.a.o0.s.q.a2;
import c.a.o0.s.q.c2;
import c.a.p0.i3.j0.a;
import c.a.p0.v0.m1.d.e0;
import c.a.p0.v0.q;
import c.a.p0.x2.z;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.p0.v0.j2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f25939c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f25939c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(q qVar, FrsViewData frsViewData, String str, boolean z, c2 c2Var) {
        c.a.o0.t.c.d adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), c2Var}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h()) {
            return;
        }
        e0 W = qVar == null ? null : qVar.W();
        List<c.a.e.k.e.n> g2 = W != null ? W.g() : null;
        List<c.a.e.k.e.n> singletonList = c2Var != null ? Collections.singletonList(c2Var) : g2;
        if (singletonList == null || g2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (c.a.e.k.e.n nVar : g2) {
                i2++;
                for (c.a.e.k.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof c2)) {
                        a.c cVar = new a.c();
                        cVar.f20018a = ((c2) nVar2).q1();
                        cVar.f20020c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (c.a.e.k.e.n nVar3 : singletonList) {
                if (nVar3 instanceof c2) {
                    c2 c2Var2 = (c2) nVar3;
                    i2++;
                    if (c2Var2.z0 == 1 && !TextUtils.isEmpty(c2Var2.q1())) {
                        c2Var2.z0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f20018a = c2Var2.q1();
                        cVar2.f20020c = i2;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            z.u(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.j());
        }
    }

    public static void c(a2 a2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, a2Var) == null) || a2Var == null) {
            return;
        }
        String d2 = a2Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = a2Var.f();
        }
        String str = d2;
        String b2 = a2Var.b();
        String c2 = a2Var.c();
        String g2 = a2Var.g();
        c.a.p0.i3.j0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + a2Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, c2Var) == null) || c2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController modelController = frsFragment.getModelController();
        q frsView = frsFragment.getFrsView();
        if (frsView == null || modelController == null) {
            return;
        }
        if (c2Var.J() != null && c2Var.J().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", c2Var.f0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            c.a.p0.v0.j2.b bVar = new c.a.p0.v0.j2.b();
            bVar.f25937a = frsViewData.needLog == 1;
            bVar.f25939c = frsViewData.getForum().getId();
            bVar.f25938b = modelController.R();
            c.a.p0.v0.j2.b bVar2 = c.a.p0.v0.j2.d.h0;
            if (bVar2 != null) {
                bVar.f25940d = bVar2.f25940d;
                bVar.f25941e = bVar2.f25941e;
            }
            c.a.p0.v0.j2.c.j().g(bVar, c2Var, 1);
            c.a.p0.v0.j2.a.e(c2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(frsView, frsViewData, frsFragment.getForumId(), true, c2Var);
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
        if (!(interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, frsModelController, j2) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j2, frsModelController.f0() - j2, frsModelController.h0(), frsModelController.g0(), currentTimeMillis - frsModelController.e0());
    }

    public static void g(@Nullable c2 c2Var, @Nullable FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, c2Var, frsViewData, i2) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        c.a.p0.v0.j2.a.d(c2Var, frsViewData.getForum().getId(), i2);
    }
}
