package c.a.p0.f1.o2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.o0.e1.n.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, statisticItem, threadData, tbPageTag) == null) {
            if (!m.isEmpty(threadData.mRecomWeight)) {
                statisticItem.param(TiebaStatic.Params.RECOM_WEIGHT, threadData.mRecomWeight);
            }
            if (!m.isEmpty(threadData.mRecomExtra)) {
                statisticItem.param(TiebaStatic.Params.RECOM_EXTRA, threadData.mRecomExtra);
            }
            if (!m.isEmpty(threadData.mRecomSource)) {
                statisticItem.param("recom_source", threadData.mRecomSource);
            }
            if (!m.isEmpty(threadData.mRecomAbTag)) {
                statisticItem.param(TiebaStatic.Params.RECOM_AB_TAG, threadData.mRecomAbTag);
            }
            statisticItem.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
            c.a.o0.o0.c.a(statisticItem, tbPageTag);
        }
    }

    public static void b(ThreadData threadData, TbPageTag tbPageTag, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, threadData, tbPageTag, str) == null) || threadData == null) {
            return;
        }
        int i2 = 2;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if (!"a071".equals(tbPageTag.locatePage)) {
            return;
        } else {
            i = 2;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", threadData.tid);
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("fname", threadData.getForum_name());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, (threadData.getAuthor().getAlaInfo().live_status == 1 || threadData.getAuthor().getAlaInfo().friendRoomStatus == 2) ? 1 : 1);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.getYYStaticticType());
        statisticItem.param("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    @Deprecated
    public static void c(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, threadData, str) == null) {
            d(threadData, str, 1);
        }
    }

    public static void d(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, threadData, str, i) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            c.a.o0.c.a.a(c.a.o0.c.a.f9870e, c.a.o0.c.a.f9867b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() == null || !threadData.getRecomSource().startsWith("manual")) {
            return;
        }
        c.a.o0.c.a.a(c.a.o0.c.a.l, c.a.o0.c.a.f9867b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
    }

    public static void e(ThreadData threadData, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{threadData, Integer.valueOf(i), bdUniqueId, bVar, tbPageTag}) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i2 = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i2 = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 17;
        } else {
            str = str2;
            z = z3;
            i3 = i2;
        }
        StatisticItem e2 = c.a.p0.z3.a.e(threadData, "a006", "common_click", i, threadData.statFloor, z, str, null, i3);
        if (e2 == null) {
            return;
        }
        e2.param(TiebaStatic.Params.LIST_ORDER, c.k().l(bVar));
        c.a.p0.f1.l2.a.a(e2);
        if (threadData.isGoods()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                e2.getParams().remove(i4);
                e2.getParams().add(i4, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else if (e.t(threadData)) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(e2, threadData, tbPageTag);
        if (threadData.isGoods()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        }
        if (z2) {
            e2.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            e2.delete("thread_type");
            e2.param("thread_type", threadData.getThreadType());
        }
        j(e2, tbPageTag, true);
        c.a.p0.z3.c.g().c(bdUniqueId, e2);
        i(threadData, i);
        o(threadData, tbPageTag, i);
    }

    public static void f(ThreadData threadData, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, threadData, bdUniqueId, tbPageTag) == null) || threadData == null || bdUniqueId == null || !threadData.isHeadLinePost) {
            return;
        }
        boolean z = (threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (!threadData.isSmartFrsThread() || threadData.getFeedBackReasonMap() == null || z) {
            return;
        }
        StatisticItem param = new StatisticItem("common_exp").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("fid", threadData.getFid()).param("thread_type", threadData.getThreadType()).param("tid", threadData.getId()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName());
        a(param, threadData, tbPageTag);
        String c2 = c.a.p0.z3.a.c(threadData.getTid(), "", "", threadData.getBaijiahaoData());
        c.a.p0.z3.c g2 = c.a.p0.z3.c.g();
        g2.d(bdUniqueId, c2 + "_15", param);
    }

    public static void g(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, Integer.valueOf(i), forumData, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || i <= 0) {
            return;
        }
        StatisticItem i4 = c.a.p0.z3.a.i("a006", "common_fill", true, i, i3);
        if (forumData != null) {
            if (!m.isEmpty(forumData.getId())) {
                i4.param("fid", forumData.getId());
            }
            if (!m.isEmpty(forumData.getName())) {
                i4.param("fname", forumData.getName());
            }
            if (!m.isEmpty(forumData.getFirst_class())) {
                i4.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
            }
            if (!m.isEmpty(forumData.getSecond_class())) {
                i4.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
        }
        i4.param(TiebaStatic.Params.LIST_ORDER, i2);
        c.a.p0.z3.c.g().c(bdUniqueId, i4);
    }

    public static void h(BdUniqueId bdUniqueId, List<n> list, ForumData forumData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65543, null, bdUniqueId, list, forumData, i) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof c.a.p0.h.c) {
                i2++;
            }
            if (i2 <= 0) {
                return;
            }
            g(bdUniqueId, i2, forumData, i, 0);
        }
    }

    public static void i(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, threadData, i) == null) {
            TiebaStatic.log(i != 2 ? null : c.a.p0.z3.a.n("c13692", threadData, 2));
        }
    }

    public static void j(StatisticItem statisticItem, TbPageTag tbPageTag, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65545, null, statisticItem, tbPageTag, z) == null) || statisticItem == null || tbPageTag == null) {
            return;
        }
        int i2 = 0;
        if ("a070".equals(tbPageTag.locatePage)) {
            i = 1;
        } else if ("a071".equals(tbPageTag.locatePage)) {
            i = 2;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 3;
        } else {
            int i3 = tbPageTag.tabId;
            if (502 == i3) {
                i = 5;
            } else {
                int i4 = tbPageTag.tabType;
                if (92 == i4 || 49 == i3 || 1120 == i3) {
                    i = 6;
                } else if (16 == i4) {
                    i = 7;
                } else if (3 == i4) {
                    i = 8;
                } else if (90 == i3) {
                    i = 9;
                } else if (505 == i3) {
                    i = 10;
                } else if (100 == i4) {
                    i = 11;
                } else {
                    i = tbPageTag.isGeneralTab == 1 ? 4 : 0;
                }
            }
        }
        if (z) {
            if (i > 0) {
                statisticItem.delete("obj_name");
                statisticItem.param("obj_name", i);
            }
        } else if (i > 0) {
            statisticItem.delete("obj_locate");
            statisticItem.param("obj_locate", i);
        }
        int i5 = tbPageTag.sortType;
        if (i5 == 1) {
            i2 = 3;
        } else if (i5 == 2) {
            i2 = 1;
        } else if (i5 == 3) {
            i2 = 2;
        } else if (i5 == 4) {
            i2 = 4;
        }
        if (i2 > 0) {
            if (i == 1 || i == 2) {
                statisticItem.delete(TiebaStatic.Params.LIST_ORDER);
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i2);
            }
        }
    }

    public static void k(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("common_click").param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 15).param("obj_id", threadData.getId()).param("fid", threadData.getFid()).param(TiebaStatic.Params.OBJ_FLOOR, threadData.statFloor).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.FIRST_DIR, threadData.getFirstClassName()).param(TiebaStatic.Params.SECOND_DIR, threadData.getSecondClassName()).param("nid", threadData.getNid()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
        a(param, threadData, tbPageTag);
        TiebaStatic.log(param);
    }

    public static void l(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, threadData, tbPageTag) == null) || threadData == null || tbPageTag == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i = 2;
        if ("a071".equals(tbPageTag.locatePage)) {
            i = 3;
        } else if ("a072".equals(tbPageTag.locatePage)) {
            i = 5;
        } else if (tbPageTag.isGeneralTab == 1) {
            i = 4;
        }
        threadData.tiePlusFrsStaticLocate = i;
    }

    public static void m(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, threadData, str) == null) || threadData == null) {
            return;
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", threadData.tiePlusFrsStaticLocate);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, str);
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            c.a.o0.c.a.a(c.a.o0.c.a.f9869d, c.a.o0.c.a.f9867b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
        }
        if (threadData.getRecomSource() == null || !threadData.getRecomSource().startsWith("manual")) {
            return;
        }
        c.a.o0.c.a.a(c.a.o0.c.a.k, c.a.o0.c.a.f9867b, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, threadData.statFloor);
    }

    public static void n(ThreadData threadData, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65549, null, threadData, bdUniqueId, bVar, tbPageTag) == null) || threadData == null) {
            return;
        }
        String str2 = null;
        boolean z2 = (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) ? false : true;
        boolean z3 = z2 && threadData.getThreadAlaInfo().frsLiveStageType == 0;
        if (z3) {
            str2 = String.valueOf(threadData.getThreadAlaInfo().live_id);
            i = 4;
        } else {
            i = 0;
        }
        if (!z3) {
            z3 = threadData.getThreadType() == 41;
            if (z3) {
                if (threadData.getTaskInfoData() != null) {
                    str2 = threadData.getTaskInfoData().f();
                }
                i = 2;
            }
        }
        if (threadData.isHeadLinePost) {
            str2 = threadData.getId();
            i = 14;
            z3 = true;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 17;
        } else {
            str = str2;
            z = z3;
            i2 = i;
        }
        String str3 = str;
        StatisticItem g2 = c.a.p0.z3.a.g(threadData, "a006", "common_exp", threadData.statFloor, z, str, null, i2);
        if (g2 == null) {
            return;
        }
        c.a.p0.f1.l2.a.a(g2);
        g2.param(TiebaStatic.Params.LIST_ORDER, c.k().l(bVar));
        if (threadData.isGoods()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (e.t(threadData)) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        a(g2, threadData, tbPageTag);
        if (z2) {
            g2.param(TiebaStatic.Params.IS_OFFICIAL, threadData.getThreadAlaInfo().user_info.is_official);
        }
        if (z2 || threadData.isHeadLinePost || threadData.isSCard) {
            g2.delete("thread_type");
            g2.param("thread_type", threadData.getThreadType());
        }
        j(g2, tbPageTag, false);
        c.a.p0.z3.c.g().d(bdUniqueId, c.a.p0.z3.a.c(threadData.getTid(), str3, "", threadData.getBaijiahaoData()), g2);
        if (threadData.isHeadLinePost) {
            f(threadData, bdUniqueId, tbPageTag);
        }
        p(threadData, tbPageTag);
    }

    public static void o(ThreadData threadData, TbPageTag tbPageTag, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65550, null, threadData, tbPageTag, i) == null) && threadData != null && 2 == i) {
            b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_CLICK);
        }
    }

    public static void p(ThreadData threadData, TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, threadData, tbPageTag) == null) || threadData == null) {
            return;
        }
        b(threadData, tbPageTag, CommonStatisticKey.KEY_YY_FRS_HEAD_SCULPTURE_SHOW);
    }
}
