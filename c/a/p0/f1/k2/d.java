package c.a.p0.f1.k2;

import android.content.Context;
import c.a.p0.a4.e0;
import c.a.p0.a4.f0;
import c.a.p0.f1.r2.k;
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
        f0 f0Var = e0Var.f12185f;
        if (f0Var != null) {
            c.a.p0.b0.a.b(f0Var.f12192b, f0Var.f12193c, "1191003700000000", f0Var.f12194d);
        } else {
            if (YYLiveUtil.isYYLiveLink(e0Var.f12183d)) {
                str = e0Var.f12183d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = e0Var.f12183d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        k.a(tbPageContext, e0Var.f12184e);
    }

    public static void c(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", e0Var.f12186g);
        statisticItem.param("obj_type", e0Var.f12185f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f12187h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f12185f;
        String str = f0Var != null ? f0Var.f12193c : e0Var.f12183d;
        f0 f0Var2 = e0Var.f12185f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f12182c;
        }
        statisticItem.param("obj_name", e0Var.f12182c);
        statisticItem.param("obj_param1", e0Var.f12183d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.i, 1));
    }

    public static void d(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, e0Var) == null) || e0Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", e0Var.f12186g);
        statisticItem.param("obj_type", e0Var.f12185f == null ? 1 : 2);
        statisticItem.param("obj_locate", e0Var.f12187h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        f0 f0Var = e0Var.f12185f;
        String str = f0Var != null ? f0Var.f12193c : e0Var.f12183d;
        f0 f0Var2 = e0Var.f12185f;
        if (f0Var2 != null) {
            String str2 = f0Var2.a;
        } else {
            String str3 = e0Var.f12182c;
        }
        statisticItem.param("obj_name", e0Var.f12182c);
        statisticItem.param("obj_param1", e0Var.f12183d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(e0Var.i, 0));
    }
}
