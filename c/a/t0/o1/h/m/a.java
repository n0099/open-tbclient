package c.a.t0.o1.h.m;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.g1.n.e;
import c.a.s0.s.q.d2;
import c.a.t0.o1.h.g;
import c.a.t0.v3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static void a(d2 d2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, d2Var, str, i2) == null) {
            b(d2Var, str, i2, 1);
        }
    }

    public static void b(d2 d2Var, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65537, null, d2Var, str, i2, i3) == null) || d2Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(d2Var.b3)) {
            ThirdStatisticHelper.sendTiePlusReq(d2Var.b3);
        }
        if (d2Var.V2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (d2Var.I2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (d2Var.H2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i3);
            statisticItem.addParam("tid", d2Var.v1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, d2Var.U());
            TiebaStatic.log(statisticItem);
            c.a.s0.d.a.a(c.a.s0.d.a.f12574e, c.a.s0.d.a.a, d2Var.W2, d2Var.X2, d2Var.Y2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.s0.d.a.a(c.a.s0.d.a.l, c.a.s0.d.a.a, str, d2Var.X2, d2Var.Y2, i2);
    }

    public static void c(d2 d2Var, BdUniqueId bdUniqueId, int i2, int i3) {
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65538, null, d2Var, bdUniqueId, i2, i3) == null) || d2Var == null) {
            return;
        }
        if (d2Var.t2) {
            str = d2Var.u2;
            z = true;
            i4 = 20;
        } else {
            str = null;
            z = false;
            i4 = 0;
        }
        StatisticItem e2 = c.a.t0.v3.a.e(d2Var, "a002", "common_click", i3, i2, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        if (d2Var.d2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (d2Var.t0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i5 = indexOf + 1;
                e2.getParams().remove(i5);
                e2.getParams().add(i5, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else if (e.t(d2Var)) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (d2Var.t2) {
            e2.delete("thread_type");
            e2.param("thread_type", d2Var.r1());
        }
        c.g().c(bdUniqueId, e2);
        d(d2Var, i3);
    }

    public static void d(d2 d2Var, int i2) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, d2Var, i2) == null) {
            if (i2 != 2) {
                n = i2 != 9 ? null : c.a.t0.v3.a.n("c13693", d2Var, 1);
            } else {
                n = c.a.t0.v3.a.n("c13692", d2Var, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void e(d2 d2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var, str, i2) == null) || d2Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(d2Var.a3)) {
            ThirdStatisticHelper.sendTiePlusReq(d2Var.a3);
        }
        if (d2Var.V2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (d2Var.I2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (d2Var.H2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", d2Var.v1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, d2Var.U());
            TiebaStatic.log(statisticItem);
            c.a.s0.d.a.a(c.a.s0.d.a.f12573d, c.a.s0.d.a.a, d2Var.W2, d2Var.X2, d2Var.Y2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.s0.d.a.a(c.a.s0.d.a.f12580k, c.a.s0.d.a.a, str, d2Var.X2, d2Var.Y2, i2);
    }

    public static void f(d2 d2Var, BdUniqueId bdUniqueId, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65541, null, d2Var, bdUniqueId, i2) == null) || d2Var == null) {
            return;
        }
        if (d2Var.t2) {
            str = d2Var.u2;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        String c2 = c.a.t0.v3.a.c(d2Var.v1(), str, "", d2Var.L());
        StatisticItem g2 = c.a.t0.v3.a.g(d2Var, "a002", "common_exp", i2, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        if (d2Var.t2) {
            g2.delete("thread_type");
            g2.param("thread_type", d2Var.r1());
        }
        if (d2Var.d2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (d2Var.t0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (e.t(d2Var)) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 4);
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
