package b.a.r0.x0.s2;

import android.content.Context;
import b.a.r0.m3.d0;
import b.a.r0.m3.e0;
import b.a.r0.x0.y2.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, d0 d0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, d0Var) == null) || d0Var == null) {
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
        e0 e0Var = d0Var.f22388f;
        if (e0Var != null) {
            b.a.r0.v.a.b(e0Var.f22397b, e0Var.f22398c, "1191003700000000", e0Var.f22399d);
        } else {
            if (YYLiveUtil.isYYLiveLink(d0Var.f22386d)) {
                str = d0Var.f22386d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = d0Var.f22386d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        h.a(tbPageContext, d0Var.f22387e);
    }

    public static void c(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, d0Var) == null) || d0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", d0Var.f22389g);
        statisticItem.param("obj_type", d0Var.f22388f == null ? 1 : 2);
        statisticItem.param("obj_locate", d0Var.f22390h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        e0 e0Var = d0Var.f22388f;
        String str = e0Var != null ? e0Var.f22398c : d0Var.f22386d;
        e0 e0Var2 = d0Var.f22388f;
        if (e0Var2 != null) {
            String str2 = e0Var2.f22396a;
        } else {
            String str3 = d0Var.f22385c;
        }
        statisticItem.param("obj_name", d0Var.f22385c);
        statisticItem.param("obj_param1", d0Var.f22386d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(d0Var.f22391i, 1));
    }

    public static void d(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, d0Var) == null) || d0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", d0Var.f22389g);
        statisticItem.param("obj_type", d0Var.f22388f == null ? 1 : 2);
        statisticItem.param("obj_locate", d0Var.f22390h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        e0 e0Var = d0Var.f22388f;
        String str = e0Var != null ? e0Var.f22398c : d0Var.f22386d;
        e0 e0Var2 = d0Var.f22388f;
        if (e0Var2 != null) {
            String str2 = e0Var2.f22396a;
        } else {
            String str3 = d0Var.f22385c;
        }
        statisticItem.param("obj_name", d0Var.f22385c);
        statisticItem.param("obj_param1", d0Var.f22386d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(d0Var.f22391i, 0));
    }
}
