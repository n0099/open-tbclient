package c.a.r0.d1.k2;

import android.content.Context;
import c.a.r0.d1.r2.k;
import c.a.r0.y3.e0;
import c.a.r0.y3.f0;
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
/* loaded from: classes2.dex */
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
        f0 f0Var = e0Var.f24978f;
        if (f0Var != null) {
            c.a.r0.z.a.b(f0Var.f24986b, f0Var.f24987c, "1191003700000000", f0Var.f24988d);
        } else {
            if (YYLiveUtil.isYYLiveLink(e0Var.f24976d)) {
                str = e0Var.f24976d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = e0Var.f24976d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        k.a(tbPageContext, e0Var.f24977e);
    }

    public static void c(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", e0Var.f24979g);
        statisticItem.param("obj_type", e0Var.f24978f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f24980h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f24978f;
        String str = f0Var != null ? f0Var.f24987c : e0Var.f24976d;
        f0 f0Var2 = e0Var.f24978f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f24975c;
        }
        statisticItem.param("obj_name", e0Var.f24975c);
        statisticItem.param("obj_param1", e0Var.f24976d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.f24981i, 1));
    }

    public static void d(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", e0Var.f24979g);
        statisticItem.param("obj_type", e0Var.f24978f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f24980h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f24978f;
        String str = f0Var != null ? f0Var.f24987c : e0Var.f24976d;
        f0 f0Var2 = e0Var.f24978f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f24975c;
        }
        statisticItem.param("obj_name", e0Var.f24975c);
        statisticItem.param("obj_param1", e0Var.f24976d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.f24981i, 0));
    }
}
