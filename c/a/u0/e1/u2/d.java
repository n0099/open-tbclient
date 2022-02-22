package c.a.u0.e1.u2;

import android.content.Context;
import c.a.u0.e1.b3.k;
import c.a.u0.z3.e0;
import c.a.u0.z3.f0;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, e0 e0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, e0Var) == null) || e0Var == null) {
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
        f0 f0Var = e0Var.f26156f;
        if (f0Var != null) {
            c.a.u0.z.a.b(f0Var.f26164b, f0Var.f26165c, "1191003700000000", f0Var.f26166d);
        } else {
            if (YYLiveUtil.isYYLiveLink(e0Var.f26154d)) {
                str = e0Var.f26154d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = e0Var.f26154d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        k.a(tbPageContext, e0Var.f26155e);
    }

    public static void c(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", e0Var.f26157g);
        statisticItem.param("obj_type", e0Var.f26156f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f26158h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f26156f;
        String str = f0Var != null ? f0Var.f26165c : e0Var.f26154d;
        f0 f0Var2 = e0Var.f26156f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f26153c;
        }
        statisticItem.param("obj_name", e0Var.f26153c);
        statisticItem.param("obj_param1", e0Var.f26154d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.f26159i, 1));
    }

    public static void d(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", e0Var.f26157g);
        statisticItem.param("obj_type", e0Var.f26156f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f26158h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f26156f;
        String str = f0Var != null ? f0Var.f26165c : e0Var.f26154d;
        f0 f0Var2 = e0Var.f26156f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f26153c;
        }
        statisticItem.param("obj_name", e0Var.f26153c);
        statisticItem.param("obj_param1", e0Var.f26154d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.f26159i, 0));
    }
}
