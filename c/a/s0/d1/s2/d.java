package c.a.s0.d1.s2;

import android.content.Context;
import c.a.s0.d1.y2.h;
import c.a.s0.v3.d0;
import c.a.s0.v3.e0;
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
/* loaded from: classes7.dex */
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
        e0 e0Var = d0Var.f24845f;
        if (e0Var != null) {
            c.a.s0.z.a.b(e0Var.f24852b, e0Var.f24853c, "1191003700000000", e0Var.f24854d);
        } else {
            if (YYLiveUtil.isYYLiveLink(d0Var.f24843d)) {
                str = d0Var.f24843d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = d0Var.f24843d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        h.a(tbPageContext, d0Var.f24844e);
    }

    public static void c(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, d0Var) == null) || d0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", d0Var.f24846g);
        statisticItem.param("obj_type", d0Var.f24845f == null ? 1 : 2);
        statisticItem.param("obj_locate", d0Var.f24847h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        e0 e0Var = d0Var.f24845f;
        String str = e0Var != null ? e0Var.f24853c : d0Var.f24843d;
        e0 e0Var2 = d0Var.f24845f;
        if (e0Var2 != null) {
            String str2 = e0Var2.a;
        } else {
            String str3 = d0Var.f24842c;
        }
        statisticItem.param("obj_name", d0Var.f24842c);
        statisticItem.param("obj_param1", d0Var.f24843d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(d0Var.f24848i, 1));
    }

    public static void d(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, d0Var) == null) || d0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", d0Var.f24846g);
        statisticItem.param("obj_type", d0Var.f24845f == null ? 1 : 2);
        statisticItem.param("obj_locate", d0Var.f24847h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        e0 e0Var = d0Var.f24845f;
        String str = e0Var != null ? e0Var.f24853c : d0Var.f24843d;
        e0 e0Var2 = d0Var.f24845f;
        if (e0Var2 != null) {
            String str2 = e0Var2.a;
        } else {
            String str3 = d0Var.f24842c;
        }
        statisticItem.param("obj_name", d0Var.f24842c);
        statisticItem.param("obj_param1", d0Var.f24843d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(d0Var.f24848i, 0));
    }
}
