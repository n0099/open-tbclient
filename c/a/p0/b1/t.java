package c.a.p0.b1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z, Context context, c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), context, c2Var, str}) == null) || c2Var == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        if (z) {
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(c2Var);
        } else {
            videoSerializeVideoThreadInfo.copyFromThreadInfo(c2Var);
        }
        VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(context, str, videoSerializeVideoThreadInfo.threadId, c.a.q0.a0.m.g(), c2Var.getPbInputLocate(), videoSerializeVideoThreadInfo);
        BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
        if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
            videoMiddlePageLightActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
    }

    public static void b(Context context, c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, c2Var, str) == null) || c2Var == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromTransmitThreadData(c2Var);
        c(context, c2Var, str, videoSerializeVideoThreadInfo.threadId, c.a.q0.a0.m.g(), c2Var.getPbInputLocate(), videoSerializeVideoThreadInfo);
    }

    public static void c(Context context, c2 c2Var, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, c2Var, str, str2, str3, str4, videoSerializeVideoThreadInfo}) == null) {
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(context, str, str2, str3, str4, videoSerializeVideoThreadInfo);
            BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
            if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public static void d(int i2, boolean z, Context context, c2 c2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), context, c2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || c2Var == null) {
            return;
        }
        if (c.a.p0.b.d.k0()) {
            a(true, context, c2Var, str4);
        } else if (c.a.p0.b.d.m0()) {
            c2Var.getThreadData();
            f(true, context, c2Var, i3, rect, str, str2, str3, str4, str5);
        } else if (c.a.p0.b.d.p0()) {
            ThreadCardUtils.jumpToPB(c2Var.v1, context, i2);
        } else if (z) {
            c2Var.getThreadData();
            f(true, context, c2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            b(context, c2Var, str4);
        }
    }

    public static void e(int i2, Context context, c2 c2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), context, c2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || c2Var == null) {
            return;
        }
        if (c.a.p0.b.d.j0()) {
            a(true, context, c2Var, str4);
        } else if (c.a.p0.b.d.l0()) {
            c2Var.getThreadData();
            f(true, context, c2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            ThreadCardUtils.jumpToPB(c2Var.v1, context, i2);
        }
    }

    public static void f(boolean z, Context context, c2 c2Var, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), context, c2Var, Integer.valueOf(i2), rect, str, str2, str3, str4, str5}) == null) || c2Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        if (z) {
            videoItemData.buildWithOriginThreadData(c2Var.v1);
        } else {
            videoItemData.buildWithThreadData(c2Var);
        }
        arrayList.add(videoItemData);
        OriginalThreadInfo originalThreadInfo = c2Var.v1;
        boolean z2 = true;
        if (originalThreadInfo != null && originalThreadInfo.r != null) {
            c2Var.getThreadData();
            if (c2Var.v1.r.is_vertical.intValue() != 1) {
                z2 = false;
            }
        }
        String str6 = null;
        OriginalThreadInfo originalThreadInfo2 = c2Var.v1;
        if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
            str6 = baijiahaoData.oriUgcNid;
        }
        g(context, arrayList, str6, z2, i2, rect, str, str2, str3, str4, str5, false);
    }

    public static void g(Context context, List<VideoItemData> list, String str, boolean z, int i2, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i2), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2)}) == null) {
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, list, i2, rect, str2, str3, str4, str5, str6);
            videoPlayActivityConfig.setParamIsVertail(z);
            videoPlayActivityConfig.setIsShowPbCommentFloat(z2);
            if (str != null) {
                videoPlayActivityConfig.setNid(str);
            }
            if (c.a.p0.b.d.i0() && ("index".equals(str5) || "concern_tab".equals(str5))) {
                VideoClickTabData videoClickTabData = new VideoClickTabData();
                videoClickTabData.setVideoMiddleBundle(videoPlayActivityConfig.getIntent().getExtras());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921610, videoClickTabData));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }
}
