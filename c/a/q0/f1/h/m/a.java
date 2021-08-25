package c.a.q0.f1.h.m;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.f1.h.g;
import c.a.q0.h3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static void a(c2 c2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, c2Var, str, i2) == null) {
            b(c2Var, str, i2, 1);
        }
    }

    public static void b(c2 c2Var, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65537, null, c2Var, str, i2, i3) == null) || c2Var == null) {
            return;
        }
        if (c2Var.O2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (c2Var.B2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (c2Var.A2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i3);
            statisticItem.addParam("tid", c2Var.q1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, c2Var.T());
            TiebaStatic.log(statisticItem);
            c.a.p0.d.a.a(c.a.p0.d.a.f13023e, c.a.p0.d.a.f13019a, c2Var.P2, c2Var.Q2, c2Var.R2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.p0.d.a.a(c.a.p0.d.a.l, c.a.p0.d.a.f13019a, str, c2Var.Q2, c2Var.R2, i2);
    }

    public static void c(c2 c2Var, BdUniqueId bdUniqueId, int i2, int i3) {
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65538, null, c2Var, bdUniqueId, i2, i3) == null) || c2Var == null) {
            return;
        }
        if (c2Var.n2) {
            str = c2Var.o2;
            z = true;
            i4 = 20;
        } else {
            str = null;
            z = false;
            i4 = 0;
        }
        StatisticItem e2 = c.a.q0.h3.a.e(c2Var, "a002", "common_click", i3, i2, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        if (c2Var.X1()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (c2Var.q0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i5 = indexOf + 1;
                e2.getParams().remove(i5);
                e2.getParams().add(i5, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (c2Var.n2) {
            e2.delete("thread_type");
            e2.param("thread_type", c2Var.m1());
        }
        c.g().c(bdUniqueId, e2);
        d(c2Var, i3);
    }

    public static void d(c2 c2Var, int i2) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, c2Var, i2) == null) {
            if (i2 != 2) {
                n = i2 != 9 ? null : c.a.q0.h3.a.n("c13693", c2Var, 1);
            } else {
                n = c.a.q0.h3.a.n("c13692", c2Var, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void e(c2 c2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, c2Var, str, i2) == null) || c2Var == null) {
            return;
        }
        if (c2Var.O2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (c2Var.B2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (c2Var.A2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", c2Var.q1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, c2Var.T());
            TiebaStatic.log(statisticItem);
            c.a.p0.d.a.a(c.a.p0.d.a.f13022d, c.a.p0.d.a.f13019a, c2Var.P2, c2Var.Q2, c2Var.R2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.p0.d.a.a(c.a.p0.d.a.k, c.a.p0.d.a.f13019a, str, c2Var.Q2, c2Var.R2, i2);
    }

    public static void f(c2 c2Var, BdUniqueId bdUniqueId, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, c2Var, bdUniqueId, i2) == null) || c2Var == null) {
            return;
        }
        if (c2Var.n2) {
            str = c2Var.o2;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        String c2 = c.a.q0.h3.a.c(c2Var.q1(), str, "", c2Var.L());
        StatisticItem g2 = c.a.q0.h3.a.g(c2Var, "a002", "common_exp", i2, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        if (c2Var.n2) {
            g2.delete("thread_type");
            g2.param("thread_type", c2Var.m1());
        }
        if (c2Var.X1()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (c2Var.q0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        c.g().d(bdUniqueId, c2, g2);
        if (g.d()) {
            g.c(c2);
            if (g.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                g.e(false);
            }
        }
    }
}
