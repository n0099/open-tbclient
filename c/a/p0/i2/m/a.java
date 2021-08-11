package c.a.p0.i2.m;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.h3.c;
import c.a.p0.i2.h.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e eVar, PostData postData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, eVar, postData, i2, i3) == null) {
            c(eVar, postData, postData != null ? postData.E() : null, i2, i3);
        }
    }

    public static void b(e eVar, PostData postData, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{eVar, postData, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, eVar, postData, i2, i3, false, postData != null ? postData.E() : null);
        statisticItem.param("obj_locate", i4);
        TiebaStatic.log(statisticItem);
    }

    public static void c(e eVar, PostData postData, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{eVar, postData, str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, eVar, postData, i2, i3, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, e eVar, PostData postData, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, eVar, postData, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            String E = postData != null ? postData.E() : null;
            f(bdUniqueId, eVar, postData, E, E, i2, i3);
        }
    }

    public static void e(BdUniqueId bdUniqueId, e eVar, PostData postData, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, eVar, postData, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            String E = postData != null ? postData.E() : null;
            g(bdUniqueId, eVar, postData, E, E, i2, i3, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, e eVar, PostData postData, String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bdUniqueId, eVar, postData, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || bdUniqueId == null || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, eVar, postData, i2, i3, false, str);
        c.g().d(bdUniqueId, str2, statisticItem);
    }

    public static void g(BdUniqueId bdUniqueId, e eVar, PostData postData, String str, String str2, int i2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{bdUniqueId, eVar, postData, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) || bdUniqueId == null || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, eVar, postData, i2, i3, false, str);
        statisticItem.param("common_exp_source_pb_comment", str3);
        c.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem h(StatisticItem statisticItem, e eVar, PostData postData, int i2, int i3, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, eVar, postData, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str})) == null) {
            if (eVar == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", eVar.n() + "");
            StatisticItem param3 = param2.param("tid", eVar.Q() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i3);
            if (postData != null) {
                statisticItem.param("pid", postData.E() + "");
            }
            if (eVar.O() != null) {
                statisticItem.param("thread_type", eVar.O().a0);
                BaijiahaoData L = eVar.O().L();
                if (L != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, L.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, L.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, L.oriUgcType);
                }
            }
            int i4 = 2;
            if (eVar.O().X1()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.F() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
            }
            if (!eVar.f0()) {
                int i5 = eVar.f18735g;
                if (i5 == 2) {
                    i4 = 1;
                } else if (i5 == 1) {
                    i4 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
            }
            if (eVar.O() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, eVar.O().E2() ? 1 : 0);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(e eVar, PostData postData, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{eVar, postData, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (eVar == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            h(statisticItem, eVar, postData, i2, i3, false, postData != null ? postData.E() : null);
            statisticItem.param("obj_locate", i4);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("游戏".equals(str)) {
                return 1;
            }
            if ("动漫".equals(str)) {
                return 2;
            }
            return "电脑数码".equals(str) ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public static String k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) ? (tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getIntent() == null) ? "" : tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id") : (String) invokeL.objValue;
    }

    public static int l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.getPbModel() != null && absPbActivity.getPbModel().O0() != null) {
                    return absPbActivity.getPbModel().O0().H();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(c.a.o0.s.q.a aVar, int i2, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, aVar, i2, tbPageContext) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        if (aVar.getThreadData().Y() != null) {
            statisticItem.param("obj_type", j(aVar.getThreadData().Y().f14101j));
        }
        statisticItem.param("obj_locate", aVar.getThreadData().G2);
        statisticItem.param("tid", aVar.getThreadData().q1());
        statisticItem.param("fid", aVar.getThreadData().T());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i2);
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        TiebaStatic.log(statisticItem);
    }

    public static void n(c.a.o0.s.q.a aVar, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, aVar, tbPageContext) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        if (aVar.getThreadData().Y() != null) {
            statisticItem.param("obj_type", j(aVar.getThreadData().Y().f14101j));
        }
        statisticItem.param("tid", aVar.getThreadData().q1());
        statisticItem.param("fid", aVar.getThreadData().T());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        TiebaStatic.log(statisticItem);
    }
}
