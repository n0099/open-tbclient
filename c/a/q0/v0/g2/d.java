package c.a.q0.v0.g2;

import android.content.Context;
import c.a.q0.i3.b0;
import c.a.q0.i3.c0;
import c.a.q0.i3.e0;
import c.a.q0.v0.m2.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, b0 b0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, b0Var) == null) || b0Var == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        c0 c0Var = b0Var.f20211f;
        if (c0Var != null) {
            c.a.q0.u.a.b(c0Var.f20216b, c0Var.f20217c, "1191003700000000", c0Var.f20218d);
        } else {
            if (YYLiveUtil.isYYLiveLink(b0Var.f20209d)) {
                str = b0Var.f20209d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = b0Var.f20209d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        h.a(tbPageContext, b0Var.f20210e);
    }

    public static void c(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, b0Var) == null) || b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", b0Var.f20212g);
        statisticItem.param("obj_type", b0Var.f20211f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f20213h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        c0 c0Var = b0Var.f20211f;
        String str = c0Var != null ? c0Var.f20217c : b0Var.f20209d;
        c0 c0Var2 = b0Var.f20211f;
        if (c0Var2 != null) {
            String str2 = c0Var2.f20215a;
        } else {
            String str3 = b0Var.f20208c;
        }
        statisticItem.param("obj_name", b0Var.f20208c);
        statisticItem.param("obj_param1", b0Var.f20209d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        e0.a((String) ListUtils.getItem(b0Var.f20214i, 1));
    }

    public static void d(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, b0Var) == null) || b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", b0Var.f20212g);
        statisticItem.param("obj_type", b0Var.f20211f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f20213h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        c0 c0Var = b0Var.f20211f;
        String str = c0Var != null ? c0Var.f20217c : b0Var.f20209d;
        c0 c0Var2 = b0Var.f20211f;
        if (c0Var2 != null) {
            String str2 = c0Var2.f20215a;
        } else {
            String str3 = b0Var.f20208c;
        }
        statisticItem.param("obj_name", b0Var.f20208c);
        statisticItem.param("obj_param1", b0Var.f20209d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        e0.a((String) ListUtils.getItem(b0Var.f20214i, 0));
    }
}
