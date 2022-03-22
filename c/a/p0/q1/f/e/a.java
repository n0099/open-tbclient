package c.a.p0.q1.f.e;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.l;
import c.a.p0.h0.e0.b;
import c.a.p0.h0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void b(c.a.o0.r.r.a aVar, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = aVar.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
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
        m.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, bVar, i) == null) || bVar == null) {
            return;
        }
        int i2 = 1;
        StatisticItem y = bVar.y("c13488", true);
        if (y != null) {
            if (bVar.getThreadData() != null) {
                ThreadData threadData = bVar.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().N() == null && threadData.getTopAgreePost().Z() == null)) {
                    i2 = 0;
                }
                y.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            y.param("obj_type", i);
            TiebaStatic.log(y);
        }
    }

    public static void d(b bVar, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, bVar, i) == null) || bVar == null || bVar.getThreadData() == null || !c.a.p0.h0.e0.l.R(bVar.a) || (y = bVar.y("c13494", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(y);
    }

    public static void e(b bVar, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, i) == null) || bVar == null || !c.a.p0.h0.e0.l.R(bVar.a) || (y = bVar.y("c13495", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }

    public static void f(b bVar, int i) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, bVar, i) == null) || bVar == null || bVar.getThreadData() == null || (y = bVar.y("c13496", true)) == null) {
            return;
        }
        y.param("obj_type", i);
        TiebaStatic.log(y);
    }
}
