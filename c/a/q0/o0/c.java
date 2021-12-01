package c.a.q0.o0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.g;
import c.a.d.a.j;
import c.a.d.f.p.k;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static StatisticItem a(StatisticItem statisticItem, TbPageTag tbPageTag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, statisticItem, tbPageTag)) == null) {
            if (tbPageTag == null || statisticItem == null) {
                return null;
            }
            if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
                if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                    statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
            }
            statisticItem.param("sort_tab", tbPageTag.sortType);
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem b(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, statisticItem)) == null) ? (context == null || statisticItem == null) ? statisticItem : c(statisticItem, j(context)) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem c(StatisticItem statisticItem, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, statisticItem, bVar)) == null) ? (bVar == null || statisticItem == null) ? statisticItem : d(statisticItem, bVar.b(), bVar.a()) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem d(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, statisticItem, tbPageTag, tbPageTag2)) == null) {
            if (statisticItem == null) {
                return null;
            }
            if (tbPageTag2 != null) {
                if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                    if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                        statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag2.locatePage);
                }
                statisticItem.param("sort_tab", tbPageTag2.sortType);
            }
            if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
                statisticItem.param(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static StatisticItem e(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, statisticItem)) == null) ? (context == null || statisticItem == null) ? statisticItem : f(statisticItem, j(context)) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem f(StatisticItem statisticItem, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, statisticItem, bVar)) == null) ? (bVar == null || statisticItem == null) ? statisticItem : g(statisticItem, bVar.b(), bVar.a()) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem g(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, statisticItem, tbPageTag, tbPageTag2)) == null) {
            if (statisticItem == null) {
                return null;
            }
            if (tbPageTag2 != null) {
                if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PAGE, tbPageTag2.locatePage);
                }
                statisticItem.param("sort_tab", tbPageTag2.sortType);
            }
            if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
                if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                    statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static StatisticItem h(Context context, StatisticItem statisticItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, statisticItem)) == null) {
            if (context == null || statisticItem == null) {
                return null;
            }
            TbPageTag l = l(context);
            if (l != null) {
                if (!TextUtils.isEmpty(l.locatePage)) {
                    if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                        statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_TAB, l.locatePage);
                }
                statisticItem.param("sort_tab", l.sortType);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem i(Context context, d2 d2Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, d2Var, str)) == null) {
            if (context == null || d2Var == null || StringUtils.isNull(str)) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", d2Var.g0()).param("fid", d2Var.U()).param("thread_type", d2Var.r1()).param("card_type", d2Var.R0()).param("nid", d2Var.G0());
            if (d2Var.L() != null && !k.isEmpty(d2Var.L().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
            }
            statisticItem.param("weight", d2Var.a1).param("ab_tag", d2Var.b1).param("extra", d2Var.c1).param("obj_type", d2Var.K2 ? "2" : "1").param("source", d2Var.Z0);
            h(context, statisticItem);
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static b j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context != null) {
                g<?> b2 = j.b(context);
                if (b2 instanceof a) {
                    return ((a) b2).getTbPageInfo();
                }
                return null;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static TbPageTag k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            b j2 = j(context);
            if (j2 == null) {
                return null;
            }
            return j2.a();
        }
        return (TbPageTag) invokeL.objValue;
    }

    public static TbPageTag l(Context context) {
        InterceptResult invokeL;
        g<?> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context == null || (b2 = j.b(context)) == null || b2.getPageContext() == null || b2.getPageContext().getPageActivity() == null) {
                return null;
            }
            return m(b2.getPageContext().getPageActivity().getIntent());
        }
        return (TbPageTag) invokeL.objValue;
    }

    public static TbPageTag m(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, intent)) == null) {
            if (intent != null) {
                return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
            }
            return null;
        }
        return (TbPageTag) invokeL.objValue;
    }
}
