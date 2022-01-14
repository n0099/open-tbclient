package c.a.t0.o1.e.e;

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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e2Var)) == null) {
            if (e2Var == null || e2Var.A1) {
                return false;
            }
            int i2 = e2Var.d0;
            return i2 == 0 || i2 == 11 || i2 == 40 || e2Var.G2();
        }
        return invokeL.booleanValue;
    }

    public static void b(c.a.s0.s.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        e2 threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.U()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.a0());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(threadData.v1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, bVar, i2) == null) || bVar == null) {
            return;
        }
        int i3 = 1;
        StatisticItem y = bVar.y("c13488", true);
        if (y != null) {
            if (bVar.getThreadData() != null) {
                e2 threadData = bVar.getThreadData();
                if (threadData.y1() == null || (threadData.y1().N() == null && threadData.y1().Z() == null)) {
                    i3 = 0;
                }
                y.param("obj_name", i3);
                if (threadData.J() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                }
            }
            y.param("obj_type", i2);
            TiebaStatic.log(y);
        }
    }

    public static void d(b bVar, int i2) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || !c.a.t0.g0.f0.l.T(bVar.f17778e) || (y = bVar.y("c13494", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }

    public static void e(b bVar, int i2) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, i2) == null) || bVar == null || !c.a.t0.g0.f0.l.T(bVar.f17778e) || (y = bVar.y("c13495", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }

    public static void f(b bVar, int i2) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || (y = bVar.y("c13496", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }
}
