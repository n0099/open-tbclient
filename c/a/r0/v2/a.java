package c.a.r0.v2;

import android.view.View;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, c.a.q0.s.q.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65536, null, view, aVar, i2) == null) || view == null || aVar == null || aVar.getThreadData() == null || StringUtils.isNull(aVar.getThreadData().v1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
        statisticItem.param("obj_source", 3);
        d2 threadData = aVar.getThreadData();
        if (threadData.P1()) {
            statisticItem.param("obj_type", 1);
        } else if (threadData.S1()) {
            statisticItem.param("obj_type", 2);
        } else if (threadData.Q1()) {
            statisticItem.param("obj_type", 3);
        } else if (threadData.R1()) {
            statisticItem.param("obj_type", 4);
        } else if (threadData.d0 == 0) {
            statisticItem.param("obj_type", 5);
        } else if (threadData.H2()) {
            statisticItem.param("obj_type", 6);
        }
        if (aVar.getThreadData().J() != null) {
            statisticItem.param("uid", aVar.getThreadData().J().getUserId());
        }
        if (threadData.L() != null) {
            statisticItem.param("obj_id", threadData.L().oriUgcNid);
        } else {
            statisticItem.param("obj_id", threadData.v1());
        }
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void b(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_SHOW);
            d2 threadData = aVar.getThreadData();
            if (threadData.P1()) {
                statisticItem.param("obj_type", 1);
            } else if (threadData.S1()) {
                statisticItem.param("obj_type", 2);
            } else if (threadData.Q1()) {
                statisticItem.param("obj_type", 3);
            } else if (threadData.R1()) {
                statisticItem.param("obj_type", 4);
            } else if (threadData.d0 == 0) {
                statisticItem.param("obj_type", 5);
            } else if (threadData.H2()) {
                statisticItem.param("obj_type", 6);
            }
            if (threadData.L() != null) {
                statisticItem.param("obj_id", threadData.L().oriUgcNid);
            } else {
                statisticItem.param("obj_id", threadData.v1());
            }
            statisticItem.param("uid", threadData.J().getUserId());
            TiebaStatic.log(statisticItem);
        }
    }
}
