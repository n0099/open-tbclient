package c.a.r0.e2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.q1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i2, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (obj instanceof q1) {
                statisticItem.param("fid", ((q1) obj).o());
            } else if (obj instanceof c.a.r0.e2.e.b) {
                c.a.r0.e2.e.b bVar = (c.a.r0.e2.e.b) obj;
                d2 d2Var = bVar.l;
                if (d2Var != null) {
                    statisticItem.param("tid", d2Var.s1());
                }
                statisticItem.param("obj_locate", bVar.b());
            }
            statisticItem.param("topic_id", str2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static void b(c.a.r0.e2.d.c.a aVar, c.a.q0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, aVar, aVar2) == null) {
            d(aVar, aVar2, true);
        }
    }

    public static void c(c.a.r0.e2.d.c.a aVar, c.a.q0.s.q.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aVar, aVar2) == null) {
            d(aVar, aVar2, false);
        }
    }

    public static void d(c.a.r0.e2.d.c.a aVar, c.a.q0.s.q.a aVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, aVar, aVar2, z) == null) || aVar2 == null || aVar2.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar2.getThreadData();
        boolean h0 = aVar.h0();
        StatisticItem statisticItem = new StatisticItem(z ? h0 ? "c13823" : "c13822" : h0 ? "c13824" : "c13821");
        statisticItem.param("tid", threadData.s1());
        statisticItem.param("fid", threadData.T());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (aVar.i0().getOrignalPage() instanceof HotTopicDetailActivity) {
            statisticItem.param("topic_id", ((HotTopicDetailActivity) aVar.i0().getOrignalPage()).getTopicId());
        }
        statisticItem.eventStat();
    }

    public static void e(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, str) == null) || tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", tbPageContext.getOrignalPage().getTopicId());
        statisticItem.eventStat();
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", str2);
        statisticItem.eventStat();
    }

    public static void g(TbPageContext<HotTopicDetailActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, tbPageContext, str) == null) || tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("topic_id", tbPageContext.getOrignalPage().getTopicId());
        statisticItem.eventStat();
    }
}
