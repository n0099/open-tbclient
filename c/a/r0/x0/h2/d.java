package c.a.r0.x0.h2;

import android.content.Context;
import c.a.r0.k3.c0;
import c.a.r0.k3.d0;
import c.a.r0.x0.n2.h;
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

    public static void b(Context context, c0 c0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, c0Var) == null) || c0Var == null) {
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
        d0 d0Var = c0Var.f20965f;
        if (d0Var != null) {
            c.a.r0.v.a.b(d0Var.f20974b, d0Var.f20975c, "1191003700000000", d0Var.f20976d);
        } else {
            if (YYLiveUtil.isYYLiveLink(c0Var.f20963d)) {
                str = c0Var.f20963d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = c0Var.f20963d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        h.a(tbPageContext, c0Var.f20964e);
    }

    public static void c(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, c0Var) == null) || c0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", c0Var.f20966g);
        statisticItem.param("obj_type", c0Var.f20965f == null ? 1 : 2);
        statisticItem.param("obj_locate", c0Var.f20967h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        d0 d0Var = c0Var.f20965f;
        String str = d0Var != null ? d0Var.f20975c : c0Var.f20963d;
        d0 d0Var2 = c0Var.f20965f;
        if (d0Var2 != null) {
            String str2 = d0Var2.f20973a;
        } else {
            String str3 = c0Var.f20962c;
        }
        statisticItem.param("obj_name", c0Var.f20962c);
        statisticItem.param("obj_param1", c0Var.f20963d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(c0Var.f20968i, 1));
    }

    public static void d(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, c0Var) == null) || c0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", c0Var.f20966g);
        statisticItem.param("obj_type", c0Var.f20965f == null ? 1 : 2);
        statisticItem.param("obj_locate", c0Var.f20967h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        d0 d0Var = c0Var.f20965f;
        String str = d0Var != null ? d0Var.f20975c : c0Var.f20963d;
        d0 d0Var2 = c0Var.f20965f;
        if (d0Var2 != null) {
            String str2 = d0Var2.f20973a;
        } else {
            String str3 = c0Var.f20962c;
        }
        statisticItem.param("obj_name", c0Var.f20962c);
        statisticItem.param("obj_param1", c0Var.f20963d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(c0Var.f20968i, 0));
    }
}
