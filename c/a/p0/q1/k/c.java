package c.a.p0.q1.k;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.m;
import c.a.o0.r.r.n1;
import c.a.p0.h0.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, str, obj, i, str2) == null) {
            if (obj instanceof c.a.p0.q1.g.a.e.c) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", i);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("topic_id", ((c.a.p0.q1.g.a.e.c) obj).a);
                statisticItem.param("obj_source", str2);
                statisticItem.eventStat();
            }
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 2);
                statisticItem2.param("obj_locate", i);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", specialColumnItemData.threadId);
                statisticItem2.param("obj_id", specialColumnItemData.liveId);
                statisticItem2.eventStat();
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 2);
                statisticItem3.param("obj_locate", i);
                statisticItem3.param("uid", ((MetaData) obj).getUserIdLong());
                statisticItem3.eventStat();
            } else if (obj instanceof n1) {
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 2);
                statisticItem4.param("obj_locate", i);
                statisticItem4.param("fid", ((n1) obj).k());
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.eventStat();
            } else if (obj instanceof m) {
                m mVar = (m) obj;
                StatisticItem statisticItem5 = new StatisticItem(str);
                statisticItem5.param("obj_type", 2);
                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem5.param("obj_locate", i);
                statisticItem5.param("obj_param1", mVar.c());
                statisticItem5.param("obj_source", str2);
                d(statisticItem5, mVar.c());
                statisticItem5.eventStat();
            } else if (obj instanceof Boolean) {
                StatisticItem statisticItem6 = new StatisticItem(str);
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", i);
                statisticItem6.eventStat();
            }
        }
    }

    public static void b(String str, Object obj, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, str, obj, i, str2) == null) {
            if (obj instanceof SpecialColumnItemData) {
                SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", i);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", specialColumnItemData.threadId);
                statisticItem.param("obj_id", specialColumnItemData.liveId);
                u.b().a(statisticItem);
            } else if (obj instanceof MetaData) {
                StatisticItem statisticItem2 = new StatisticItem(str);
                statisticItem2.param("obj_type", 1);
                statisticItem2.param("obj_locate", i);
                statisticItem2.param("uid", ((MetaData) obj).getUserIdLong());
                u.b().a(statisticItem2);
            } else if (obj instanceof n1) {
                StatisticItem statisticItem3 = new StatisticItem(str);
                statisticItem3.param("obj_type", 1);
                statisticItem3.param("obj_locate", i);
                statisticItem3.param("fid", ((n1) obj).k());
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                u.b().a(statisticItem3);
            } else if (obj instanceof m) {
                m mVar = (m) obj;
                StatisticItem statisticItem4 = new StatisticItem(str);
                statisticItem4.param("obj_type", 1);
                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem4.param("obj_locate", i);
                statisticItem4.param("obj_param1", mVar.c());
                statisticItem4.param("obj_source", str2);
                d(statisticItem4, mVar.c());
                u.b().a(statisticItem4);
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
            u.b().a(statisticItem);
        }
    }

    public static void d(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14472");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem("c14521"));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14486");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void h(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14490");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("obj_param1", i3);
            statisticItem.param("obj_id", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14492");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void j(View view, c.a.o0.r.r.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, view, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        ThreadData threadData = aVar.getThreadData();
        int id = view.getId();
        if (view.getId() == R.id.obfuscated_res_0x7f091f9a || id == R.id.obfuscated_res_0x7f091fac) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092296) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f0922bb) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a68 || id == R.id.obfuscated_res_0x7f090a39) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f091fac) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f09160b || id == R.id.obfuscated_res_0x7f0906e2) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14479");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TiebaStatic.log(new StatisticItem("c14520"));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14485");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void n(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14489");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14491");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p(c.a.o0.r.r.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        if (aVar.getThreadData().isVideoThreadType()) {
            u.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(aVar.getThreadData(), str));
        } else {
            u.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(aVar.getThreadData(), str));
        }
    }
}
