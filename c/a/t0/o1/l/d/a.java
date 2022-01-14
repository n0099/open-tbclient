package c.a.t0.o1.l.d;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.t0.d1.l;
import c.a.t0.g0.f0.b;
import c.a.t0.g0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, bVar, statisticItem) == null) || bVar == null || bVar.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (bVar.getThreadData().L() != null) {
            BaijiahaoData L = bVar.getThreadData().L();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, L.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, L.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e2Var)) == null) {
            if (e2Var == null || e2Var.A1) {
                return false;
            }
            int i2 = e2Var.d0;
            return i2 == 0 || i2 == 11 || i2 == 40 || e2Var.G2();
        }
        return invokeL.booleanValue;
    }

    public static void c(c.a.s0.s.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        e2 threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.U()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.a0());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        m.a(threadData.v1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null || (y = bVar.y("c13583", true)) == null) {
            return;
        }
        a(bVar, y);
        TiebaStatic.log(y);
    }

    public static void e(b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) || bVar == null || (y = bVar.y("c13584", true)) == null) {
            return;
        }
        a(bVar, y);
        y.param(TiebaStatic.Params.OBJ_FLOOR, bVar.position + 1);
        TiebaStatic.log(y);
    }

    public static void f(b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, bVar) == null) || bVar == null || (y = bVar.y("c13585", true)) == null) {
            return;
        }
        a(bVar, y);
        TiebaStatic.log(y);
    }

    public static void g(b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, bVar) == null) || bVar == null || (y = bVar.y("c13586", true)) == null) {
            return;
        }
        a(bVar, y);
        TiebaStatic.log(y);
    }

    public static void h(b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bVar) == null) || bVar == null || (y = bVar.y("c13587", true)) == null) {
            return;
        }
        a(bVar, y);
        TiebaStatic.log(y);
    }
}
