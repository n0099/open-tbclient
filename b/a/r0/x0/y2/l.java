package b.a.r0.x0.y2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.a.w;
import b.a.q0.s.q.b2;
import b.a.q0.s.q.d2;
import b.a.r0.a3.z;
import b.a.r0.m3.l0.a;
import b.a.r0.x0.q;
import b.a.r0.x0.y1.d.e0;
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
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b.a.r0.x0.v2.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, str) == null) || TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f27993c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f27993c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(q qVar, FrsViewData frsViewData, String str, boolean z, d2 d2Var) {
        b.a.q0.t.c.d adAdSense;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qVar, frsViewData, str, Boolean.valueOf(z), d2Var}) == null) || qVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g()) {
            return;
        }
        e0 V = qVar == null ? null : qVar.V();
        List<b.a.e.m.e.n> g2 = V != null ? V.g() : null;
        List<b.a.e.m.e.n> singletonList = d2Var != null ? Collections.singletonList(d2Var) : g2;
        if (singletonList == null || g2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (b.a.e.m.e.n nVar : g2) {
                i2++;
                for (b.a.e.m.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof d2)) {
                        a.c cVar = new a.c();
                        cVar.f22529a = ((d2) nVar2).t1();
                        cVar.f22531c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (b.a.e.m.e.n nVar3 : singletonList) {
                if (nVar3 instanceof d2) {
                    d2 d2Var2 = (d2) nVar3;
                    i2++;
                    if (d2Var2.C0 == 1 && !TextUtils.isEmpty(d2Var2.t1())) {
                        d2Var2.C0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f22529a = d2Var2.t1();
                        cVar2.f22531c = i2;
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
        b.a.r0.m3.l0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + b2Var.g(), str);
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
            b.a.r0.x0.v2.b bVar = new b.a.r0.x0.v2.b();
            bVar.f27991a = frsViewData.needLog == 1;
            bVar.f27993c = frsViewData.getForum().getId();
            bVar.f27992b = modelController.R();
            b.a.r0.x0.v2.b bVar2 = b.a.r0.x0.v2.d.h0;
            if (bVar2 != null) {
                bVar.f27994d = bVar2.f27994d;
                bVar.f27995e = bVar2.f27995e;
            }
            b.a.r0.x0.v2.c.j().g(bVar, d2Var, 1);
            b.a.r0.x0.v2.a.e(d2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
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

    public static void f(FrsModelController frsModelController, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, frsModelController, j) == null) || frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.f0() - j, frsModelController.h0(), frsModelController.g0(), currentTimeMillis - frsModelController.e0());
    }

    public static void g(@Nullable d2 d2Var, @Nullable FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, d2Var, frsViewData, i2) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        b.a.r0.x0.v2.a.d(d2Var, frsViewData.getForum().getId(), i2);
    }
}
