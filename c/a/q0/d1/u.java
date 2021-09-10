package c.a.q0.d1;

import android.content.Context;
import android.graphics.Rect;
import c.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, boolean z, Context context, d2 d2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), context, d2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || d2Var == null) {
            return;
        }
        d2Var.getThreadData();
        c(true, context, d2Var, i3, rect, str, str2, str3, str4, str5);
    }

    public static void b(int i2, Context context, d2 d2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), context, d2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || d2Var == null) {
            return;
        }
        d2Var.getThreadData();
        c(true, context, d2Var, i3, rect, str, str2, str3, str4, str5);
    }

    public static void c(boolean z, Context context, d2 d2Var, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), context, d2Var, Integer.valueOf(i2), rect, str, str2, str3, str4, str5}) == null) || d2Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        if (z) {
            videoItemData.buildWithOriginThreadData(d2Var.x1);
        } else {
            videoItemData.buildWithThreadData(d2Var);
        }
        arrayList.add(videoItemData);
        OriginalThreadInfo originalThreadInfo = d2Var.x1;
        boolean z2 = true;
        if (originalThreadInfo != null && originalThreadInfo.r != null) {
            d2Var.getThreadData();
            if (d2Var.x1.r.is_vertical.intValue() != 1) {
                z2 = false;
            }
        }
        String str6 = null;
        OriginalThreadInfo originalThreadInfo2 = d2Var.x1;
        if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
            str6 = baijiahaoData.oriUgcNid;
        }
        d(context, arrayList, str6, z2, i2, rect, str, str2, str3, str4, str5, false);
    }

    public static void d(Context context, List<VideoItemData> list, String str, boolean z, int i2, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i2), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2)}) == null) {
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, list, i2, rect, str2, str3, str4, str5, str6);
            videoPlayActivityConfig.setParamIsVertail(z);
            videoPlayActivityConfig.setIsShowPbCommentFloat(z2);
            if (str != null) {
                videoPlayActivityConfig.setNid(str);
            }
            if (c.a.q0.b.d.T() && ("index".equals(str5) || "concern_tab".equals(str5))) {
                VideoClickTabData videoClickTabData = new VideoClickTabData();
                videoClickTabData.setVideoMiddleBundle(videoPlayActivityConfig.getIntent().getExtras());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921610, videoClickTabData));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }
}
