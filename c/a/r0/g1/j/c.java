package c.a.r0.g1.j;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m;
import c.a.q0.s.q.q1;
import c.a.r0.a0.t;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i2, str2) == null) {
            if (obj instanceof c.a.r0.g1.f.a.e.c) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", i2);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("topic_id", ((c.a.r0.g1.f.a.e.c) obj).f18097a);
                statisticItem.param("obj_source", str2);
                statisticItem.eventStat();
            }
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 2);
                statisticItem2.param("obj_locate", i2);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", specialColumnItemData.threadId);
                statisticItem2.param("obj_id", specialColumnItemData.liveId);
                statisticItem2.eventStat();
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 2);
                statisticItem3.param("obj_locate", i2);
                statisticItem3.param("uid", ((MetaData) obj).getUserIdLong());
                statisticItem3.eventStat();
            } else if (obj instanceof q1) {
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 2);
                statisticItem4.param("obj_locate", i2);
                statisticItem4.param("fid", ((q1) obj).o());
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.eventStat();
            } else if (obj instanceof m) {
                m mVar = (m) obj;
                StatisticItem statisticItem5 = new StatisticItem(str);
                statisticItem5.param("obj_type", 2);
                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem5.param("obj_locate", i2);
                statisticItem5.param("obj_param1", mVar.c());
                statisticItem5.param("obj_source", str2);
                d(statisticItem5, mVar.c());
                statisticItem5.eventStat();
            } else if (obj instanceof Boolean) {
                StatisticItem statisticItem6 = new StatisticItem(str);
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", i2);
                statisticItem6.eventStat();
            }
        }
    }

    public static void b(String str, Object obj, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, obj, i2, str2) == null) {
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", i2);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", specialColumnItemData.threadId);
                statisticItem.param("obj_id", specialColumnItemData.liveId);
                t.b().a(statisticItem);
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 1);
                statisticItem2.param("obj_locate", i2);
                statisticItem2.param("uid", ((MetaData) obj).getUserIdLong());
                t.b().a(statisticItem2);
            } else if (obj instanceof q1) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 1);
                statisticItem3.param("obj_locate", i2);
                statisticItem3.param("fid", ((q1) obj).o());
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                t.b().a(statisticItem3);
            } else if (obj instanceof m) {
                m mVar = (m) obj;
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 1);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.param("obj_locate", i2);
                statisticItem4.param("obj_param1", mVar.c());
                statisticItem4.param("obj_source", str2);
                d(statisticItem4, mVar.c());
                t.b().a(statisticItem4);
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_source", str2);
            t.b().a(statisticItem);
        }
    }

    public static void d(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void e(View view, c.a.q0.s.q.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        if (threadData.E2()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view.getId();
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                return;
            } else if (id == R.id.user_name) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                return;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
                return;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
                return;
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
                return;
            } else {
                return;
            }
        }
        TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
    }

    public static void f(c.a.q0.s.q.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        if (aVar.getThreadData().E2()) {
            t.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(aVar.getThreadData(), str));
        } else {
            t.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(aVar.getThreadData(), str));
        }
    }
}
