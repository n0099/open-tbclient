package c.a.q0.f1.e.e;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.a0.d0.b;
import c.a.q0.a0.m;
import c.a.q0.v0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, c2Var)) == null) {
            if (c2Var == null || c2Var.w1) {
                return false;
            }
            int i2 = c2Var.a0;
            return i2 == 0 || i2 == 11 || i2 == 40 || c2Var.z2();
        }
        return invokeL.booleanValue;
    }

    public static void b(c.a.p0.s.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        c2 threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.Z());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(threadData.q1());
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
                c2 threadData = bVar.getThreadData();
                if (threadData.t1() == null || (threadData.t1().K() == null && threadData.t1().V() == null)) {
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
        if (!(interceptable == null || interceptable.invokeLI(65539, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || !c.a.q0.a0.d0.l.T(bVar.f15245e) || (y = bVar.y("c13494", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }

    public static void e(b bVar, int i2) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, i2) == null) || bVar == null || !c.a.q0.a0.d0.l.T(bVar.f15245e) || (y = bVar.y("c13495", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }

    public static void f(b bVar, int i2) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, bVar, i2) == null) || bVar == null || bVar.getThreadData() == null || (y = bVar.y("c13496", true)) == null) {
            return;
        }
        y.param("obj_type", i2);
        TiebaStatic.log(y);
    }
}
