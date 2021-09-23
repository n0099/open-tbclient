package c.a.r0.w0.n2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.w;
import c.a.q0.s.q.b2;
import c.a.q0.s.q.d2;
import c.a.r0.j3.k0.a;
import c.a.r0.w0.n1.d.e0;
import c.a.r0.w0.q;
import c.a.r0.y2.z;
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

    public static void a(c.a.r0.w0.k2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f26961c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f26961c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(q qVar, FrsViewData frsViewData, String str, boolean z, d2 d2Var) {
        c.a.q0.t.c.d adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), d2Var}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g()) {
            return;
        }
        e0 W = qVar == null ? null : qVar.W();
        List<c.a.e.l.e.n> g2 = W != null ? W.g() : null;
        List<c.a.e.l.e.n> singletonList = d2Var != null ? Collections.singletonList(d2Var) : g2;
        if (singletonList == null || g2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (c.a.e.l.e.n nVar : g2) {
                i2++;
                for (c.a.e.l.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof d2)) {
                        a.c cVar = new a.c();
                        cVar.f20930a = ((d2) nVar2).s1();
                        cVar.f20932c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (c.a.e.l.e.n nVar3 : singletonList) {
                if (nVar3 instanceof d2) {
                    d2 d2Var2 = (d2) nVar3;
                    i2++;
                    if (d2Var2.C0 == 1 && !TextUtils.isEmpty(d2Var2.s1())) {
                        d2Var2.C0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f20930a = d2Var2.s1();
                        cVar2.f20932c = i2;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            z.u(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.i());
        }
    }

    public static void c(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, b2Var) == null) || b2Var == null) {
            return;
        }
        String d2 = b2Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = b2Var.f();
        }
        String str = d2;
        String b2 = b2Var.b();
        String c2 = b2Var.c();
        String g2 = b2Var.g();
        c.a.r0.j3.k0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + b2Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, frsFragment, frsViewData, d2Var) == null) || d2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController modelController = frsFragment.getModelController();
        q frsView = frsFragment.getFrsView();
        if (frsView == null || modelController == null) {
            return;
        }
        if (d2Var.J() != null && d2Var.J().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", d2Var.f0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            c.a.r0.w0.k2.b bVar = new c.a.r0.w0.k2.b();
            bVar.f26959a = frsViewData.needLog == 1;
            bVar.f26961c = frsViewData.getForum().getId();
            bVar.f26960b = modelController.R();
            c.a.r0.w0.k2.b bVar2 = c.a.r0.w0.k2.d.h0;
            if (bVar2 != null) {
                bVar.f26962d = bVar2.f26962d;
                bVar.f26963e = bVar2.f26963e;
            }
            c.a.r0.w0.k2.c.j().g(bVar, d2Var, 1);
            c.a.r0.w0.k2.a.e(d2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(frsView, frsViewData, frsFragment.getForumId(), true, d2Var);
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

    public static void g(@Nullable d2 d2Var, @Nullable FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, d2Var, frsViewData, i2) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        c.a.r0.w0.k2.a.d(d2Var, frsViewData.getForum().getId(), i2);
    }
}
