package c.a.r0.g1.c;

import android.view.View;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, d2Var, i2) == null) {
            TiebaStatic.log(i2 != 1 ? null : c.a.r0.i3.a.n("c13692", d2Var, 3));
        }
    }

    public static void b(View view, c.a.q0.s.q.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, view, aVar, i2) == null) || view == null || aVar == null || aVar.getThreadData() == null || StringUtils.isNull(aVar.getThreadData().s1())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
        d2 threadData = aVar.getThreadData();
        if (threadData.e2()) {
            statisticItem.param("obj_type", 4);
        } else if (threadData.y1) {
            statisticItem.param("obj_type", 5);
        } else if (threadData.M1()) {
            statisticItem.param("obj_type", 6);
        } else if (threadData.N1()) {
            statisticItem.param("obj_type", 7);
        } else if (threadData.P1()) {
            statisticItem.param("obj_type", 8);
        } else if (threadData.O1()) {
            statisticItem.param("obj_type", 9);
        } else if (threadData.getType() == d2.Z2) {
            statisticItem.param("obj_type", 1);
        } else if (threadData.E2()) {
            statisticItem.param("obj_type", 2);
        }
        statisticItem.param("obj_locate", i2);
        statisticItem.param("tid", aVar.getThreadData().s1());
        statisticItem.param("fid", aVar.getThreadData().T());
        statisticItem.param("fname", aVar.getThreadData().Z());
        statisticItem.param("obj_source", 1);
        if (aVar instanceof c.a.r0.a0.d0.b) {
            statisticItem.param("obj_param1", ((c.a.r0.a0.d0.b) aVar).F() ? 2 : 1);
        }
        if (aVar.getThreadData().J() != null) {
            statisticItem.param("uid", aVar.getThreadData().J().getUserId());
        }
        if (threadData.L() != null) {
            statisticItem.param("obj_id", threadData.L().oriUgcNid);
        } else {
            statisticItem.param("obj_id", threadData.s1());
        }
        if (aVar.getThreadData().l1() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(aVar.getThreadData().l1());
            if (aVar.getThreadData().l1().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, aVar.getThreadData().l1().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        TiebaStatic.log(statisticItem);
        a(threadData, i2);
    }

    public static boolean c(DiscoverHotForum.Builder builder, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{builder, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (j2 != 0 && builder != null) {
                List<DiscoverTabCard> list = builder.tab_list;
                if (ListUtils.isEmpty(list)) {
                    return false;
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i2));
                    List<RecommendForumInfo> list2 = builder2.forum_list;
                    if (!ListUtils.isEmpty(list2)) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            RecommendForumInfo.Builder builder3 = new RecommendForumInfo.Builder(list2.get(i3));
                            if (builder3.forum_id.longValue() == j2 && builder3.is_like.intValue() != z) {
                                builder3.is_like = Integer.valueOf(z ? 1 : 0);
                                list2.set(i3, builder3.build(true));
                                list.set(i2, builder2.build(true));
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
