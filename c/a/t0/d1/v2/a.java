package c.a.t0.d1.v2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.s0.g1.n.e;
import c.a.s0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, d2 d2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, d2Var, tbPageTag) == null) {
            if (!m.isEmpty(d2Var.a1)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, d2Var.a1);
            }
            if (!m.isEmpty(d2Var.c1)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, d2Var.c1);
            }
            if (!m.isEmpty(d2Var.Z0)) {
                statisticItem.param("recom_source", d2Var.Z0);
            }
            if (!m.isEmpty(d2Var.b1)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, d2Var.b1);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, d2Var.R0());
            c.a.s0.p0.c.a(statisticItem, tbPageTag);
        }
    }

    public static void b(d2 d2Var, TbPageTag tbPageTag, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, d2Var, tbPageTag, str) == null) || d2Var == null) {
            return;
        }
        int i3 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i2 = 1;
        } else if (!"a071".equals(tbPageTag.locatePage)) {
            return;
        } else {
            i2 = 2;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", d2Var.E);
        statisticItem.param("fid", d2Var.U());
        statisticItem.param("fname", d2Var.a0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (d2Var.J() != null && d2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(d2Var.J().getAlaInfo()));
            if (d2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, d2Var.J().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (d2Var.J().getAlaInfo().live_status == 1 || d2Var.J().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.H1());
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    @Deprecated
    public static void c(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, d2Var, str) == null) {
            d(d2Var, str, 1);
        }
    }

    public static void d(d2 d2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, d2Var, str, i2) == null) || d2Var == null) {
            return;
        }
        if (d2Var.V2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 2);
            if (d2Var.I2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (d2Var.H2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i2);
            statisticItem.addParam("tid", d2Var.v1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, d2Var.U());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            TiebaStatic.log(statisticItem);
            c.a.s0.d.a.a(c.a.s0.d.a.f12574e, c.a.s0.d.a.f12571b, d2Var.W2, d2Var.X2, d2Var.Y2, d2Var.U1);
        }
        if (d2Var.S0() == null || !d2Var.S0().startsWith("manual")) {
            return;
        }
        c.a.s0.d.a.a(c.a.s0.d.a.l, c.a.s0.d.a.f12571b, d2Var.W2, d2Var.X2, d2Var.Y2, d2Var.U1);
    }

    public static void e(d2 d2Var, int i2, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i3;
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{d2Var, Integer.valueOf(i2), bdUniqueId, bVar, tbPageTag}) == null) || d2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (d2Var.o1() == null || d2Var.o1().user_info == null || d2Var.o1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && d2Var.o1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(d2Var.o1().live_id);
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (!z3) {
            z3 = d2Var.r1() == 41;
            if (z3) {
                if (d2Var.m1() != null) {
                    str2 = d2Var.m1().f();
                }
                i3 = 2;
            }
        }
        if (d2Var.X1) {
            str2 = d2Var.g0();
            i3 = 14;
            z3 = true;
        }
        if (d2Var.t2) {
            str = d2Var.u2;
            z = true;
            i4 = 17;
        } else {
            str = str2;
            z = z3;
            i4 = i3;
        }
        StatisticItem e2 = c.a.t0.v3.a.e(d2Var, "a006", "common_click", i2, d2Var.U1, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        e2.param(TiebaStatic.Params.LIST_ORDER, c.k().l(bVar));
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
        a(e2, d2Var, tbPageTag);
        if (d2Var.d2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            e2.param(TiebaStatic.Params.IS_OFFICIAL, d2Var.o1().user_info.is_official);
        }
        if (z2 || d2Var.X1 || d2Var.t2) {
            e2.delete("thread_type");
            e2.param("thread_type", d2Var.r1());
        }
        j(e2, tbPageTag, true);
        c.a.t0.v3.c.g().c(bdUniqueId, e2);
        i(d2Var, i2);
        n(d2Var, tbPageTag, i2);
    }

    public static void f(d2 d2Var, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, d2Var, bdUniqueId, tbPageTag) == null) || d2Var == null || bdUniqueId == null || !d2Var.X1) {
            return;
        }
        boolean z = (d2Var.J() == null || d2Var.J().getUserId() == null || !d2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!d2Var.A2() || d2Var.T() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", d2Var.g0()).param(TiebaStatic.Params.OBJ_FLOOR, d2Var.U1).param("fid", d2Var.U()).param("thread_type", d2Var.r1()).param("tid", d2Var.g0()).param(TiebaStatic.Params.FIRST_DIR, d2Var.V()).param(TiebaStatic.Params.SECOND_DIR, d2Var.a1());
        a(param, d2Var, tbPageTag);
        String c2 = c.a.t0.v3.a.c(d2Var.v1(), "", "", d2Var.L());
        c.a.t0.v3.c g2 = c.a.t0.v3.c.g();
        g2.d(bdUniqueId, c2 + "_15", param);
    }

    public static void g(BdUniqueId bdUniqueId, int i2, ForumData forumData, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, Integer.valueOf(i2), forumData, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i2 <= 0) {
            return;
        }
        StatisticItem i5 = c.a.t0.v3.a.i("a006", "common_fill", true, i2, i4);
        if (forumData != null) {
            if (!m.isEmpty(forumData.getId())) {
                i5.param("fid", forumData.getId());
            }
            if (!m.isEmpty(forumData.getName())) {
                i5.param("fname", forumData.getName());
            }
            if (!m.isEmpty(forumData.getFirst_class())) {
                i5.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!m.isEmpty(forumData.getSecond_class())) {
                i5.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        i5.param(TiebaStatic.Params.LIST_ORDER, i3);
        c.a.t0.v3.c.g().c(bdUniqueId, i5);
    }

    public static void h(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, bdUniqueId, list, forumData, i2) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) instanceof c.a.t0.h.c) {
                i3++;
            }
            if (i3 <= 0) {
                return;
            }
            g(bdUniqueId, i3, forumData, i2, 0);
        }
    }

    public static void i(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, d2Var, i2) == null) {
            TiebaStatic.log(i2 != 2 ? null : c.a.t0.v3.a.n("c13692", d2Var, 2));
        }
    }

    public static void j(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65545, null, statisticItem, tbPageTag, z) == null) || statisticItem == null || tbPageTag == null) {
            return;
        }
        int i3 = 0;
        if ("a070".equals(tbPageTag.locatePage)) {
            i2 = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i2 = 2;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i2 = 3;
        } else {
            int i4 = tbPageTag.tabId;
            if (502 == i4) {
                i2 = 5;
            } else {
                int i5 = tbPageTag.tabType;
                if (92 == i5 || 49 == i4 || 1120 == i4) {
                    i2 = 6;
                } else if (16 == i5) {
                    i2 = 7;
                } else if (3 == i5) {
                    i2 = 8;
                } else if (90 == i4) {
                    i2 = 9;
                } else if (505 == i4) {
                    i2 = 10;
                } else if (100 == i5) {
                    i2 = 11;
                } else {
                    i2 = tbPageTag.isGeneralTab == 1 ? 4 : 0;
                }
            }
        }
        if (z) {
            if (i2 > 0) {
                statisticItem.delete("obj_name");
                statisticItem.param("obj_name", i2);
            }
        } else if (i2 > 0) {
            statisticItem.delete("obj_locate");
            statisticItem.param("obj_locate", i2);
        }
        int i6 = tbPageTag.sortType;
        if (i6 == 1) {
            i3 = 3;
        } else if (i6 == 2) {
            i3 = 1;
        } else if (i6 == 3) {
            i3 = 2;
        } else if (i6 == 4) {
            i3 = 4;
        }
        if (i3 > 0) {
            if (i2 == 1 || i2 == 2) {
                statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3);
            }
        }
    }

    public static void k(d2 d2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, d2Var, tbPageTag) == null) || d2Var == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", d2Var.g0()).param("fid", d2Var.U()).param(TiebaStatic.Params.OBJ_FLOOR, d2Var.U1).param("tid", d2Var.g0()).param("thread_type", d2Var.r1()).param(TiebaStatic.Params.FIRST_DIR, d2Var.V()).param(TiebaStatic.Params.SECOND_DIR, d2Var.a1()).param("nid", d2Var.G0()).param(TiebaStatic.Params.IS_ZP, d2Var.M2() ? 1 : 0);
        a(param, d2Var, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void l(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, d2Var, str) == null) || d2Var == null) {
            return;
        }
        if (d2Var.V2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 2);
            if (d2Var.I2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (d2Var.H2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", d2Var.v1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, d2Var.U());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            TiebaStatic.log(statisticItem);
            c.a.s0.d.a.a(c.a.s0.d.a.f12573d, c.a.s0.d.a.f12571b, d2Var.W2, d2Var.X2, d2Var.Y2, d2Var.U1);
        }
        if (d2Var.S0() == null || !d2Var.S0().startsWith("manual")) {
            return;
        }
        c.a.s0.d.a.a(c.a.s0.d.a.f12580k, c.a.s0.d.a.f12571b, d2Var.W2, d2Var.X2, d2Var.Y2, d2Var.U1);
    }

    public static void m(d2 d2Var, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65548, null, d2Var, bdUniqueId, bVar, tbPageTag) == null) || d2Var == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (d2Var.o1() == null || d2Var.o1().user_info == null || d2Var.o1().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && d2Var.o1().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(d2Var.o1().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = d2Var.r1() == 41;
            if (z3) {
                if (d2Var.m1() != null) {
                    str2 = d2Var.m1().f();
                }
                i2 = 2;
            }
        }
        if (d2Var.X1) {
            str2 = d2Var.g0();
            i2 = 14;
            z3 = true;
        }
        if (d2Var.t2) {
            str = d2Var.u2;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        String str3 = str;
        StatisticItem g2 = c.a.t0.v3.a.g(d2Var, "a006", "common_exp", d2Var.U1, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        g2.param(TiebaStatic.Params.LIST_ORDER, c.k().l(bVar));
        if (d2Var.d2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (d2Var.t0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (e.t(d2Var)) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(g2, d2Var, tbPageTag);
        if (z2) {
            g2.param(TiebaStatic.Params.IS_OFFICIAL, d2Var.o1().user_info.is_official);
        }
        if (z2 || d2Var.X1 || d2Var.t2) {
            g2.delete("thread_type");
            g2.param("thread_type", d2Var.r1());
        }
        j(g2, tbPageTag, false);
        c.a.t0.v3.c.g().d(bdUniqueId, c.a.t0.v3.a.c(d2Var.v1(), str3, "", d2Var.L()), g2);
        if (d2Var.X1) {
            f(d2Var, bdUniqueId, tbPageTag);
        }
        o(d2Var, tbPageTag);
    }

    public static void n(d2 d2Var, TbPageTag tbPageTag, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65549, null, d2Var, tbPageTag, i2) == null) && d2Var != null && 2 == i2) {
            b(d2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void o(d2 d2Var, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, d2Var, tbPageTag) == null) || d2Var == null) {
            return;
        }
        b(d2Var, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
