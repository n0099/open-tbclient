package c.a.p0.v0.g2;

import android.content.Context;
import c.a.p0.i3.b0;
import c.a.p0.i3.c0;
import c.a.p0.v0.n2.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, b0Var) == null) || b0Var == null) {
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
        c0 c0Var = b0Var.f19882f;
        if (c0Var != null) {
            c.a.p0.u.a.b(c0Var.f19887b, c0Var.f19888c, "1191003700000000", c0Var.f19889d);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{b0Var.f19880d});
        }
        h.a(tbPageContext, b0Var.f19881e);
    }

    public static void b(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, b0Var) == null) || b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", b0Var.f19883g);
        statisticItem.param("obj_type", b0Var.f19882f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f19884h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_name", b0Var.f19879c);
        statisticItem.param("obj_param1", b0Var.f19880d);
        TiebaStatic.log(statisticItem);
        c.a.p0.v0.l2.a.a(b0Var.f19885i);
    }

    public static void c(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, b0Var) == null) || b0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", b0Var.f19883g);
        statisticItem.param("obj_type", b0Var.f19882f == null ? 1 : 2);
        statisticItem.param("obj_locate", b0Var.f19884h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_name", b0Var.f19879c);
        statisticItem.param("obj_param1", b0Var.f19880d);
        TiebaStatic.log(statisticItem);
        c.a.p0.v0.l2.a.b(b0Var.f19885i);
    }
}
