package c.a.s0.e1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, boolean z, Context context, d2 d2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), context, d2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || d2Var == null) {
            return;
        }
        c(true, context, d2Var.getThreadData(), i3, rect, str, str2, str3, str4, str5, d2Var.n);
    }

    public static void b(int i2, Context context, d2 d2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), context, d2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || d2Var == null) {
            return;
        }
        c(true, context, d2Var.getThreadData(), i3, rect, str, str2, str3, str4, str5, d2Var.n);
    }

    public static void c(boolean z, Context context, d2 d2Var, int i2, Rect rect, String str, String str2, String str3, String str4, String str5, boolean z2) {
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), context, d2Var, Integer.valueOf(i2), rect, str, str2, str3, str4, str5, Boolean.valueOf(z2)}) == null) || d2Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        if (z) {
            videoItemData.buildWithOriginThreadData(d2Var.A1);
        } else {
            videoItemData.buildWithThreadData(d2Var);
        }
        arrayList.add(videoItemData);
        OriginalThreadInfo originalThreadInfo = d2Var.A1;
        boolean z3 = true;
        if (originalThreadInfo != null && originalThreadInfo.r != null && d2Var.getThreadData().A1.r.is_vertical.intValue() != 1) {
            z3 = false;
        }
        String str6 = null;
        OriginalThreadInfo originalThreadInfo2 = d2Var.A1;
        if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
            str6 = baijiahaoData.oriUgcNid;
        }
        e(context, arrayList, str6, z3, i2, rect, str, str2, str3, str4, str5, false, z2, true);
    }

    public static void d(Context context, List<VideoItemData> list, String str, boolean z, int i2, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i2), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            e(context, list, str, z, i2, rect, str2, str3, str4, str5, str6, z2, z3, false);
        }
    }

    public static void e(Context context, List<VideoItemData> list, String str, boolean z, int i2, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, boolean z4) {
        String str7;
        String str8;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i2), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, list, i2, rect, str2, str3, str4, str5, str6);
            if (z4) {
                videoPlayActivityConfig.setForceUseBigDataList(list);
            }
            videoPlayActivityConfig.setParamIsVertail(z);
            TbSingleton.getInstance().setIsNeedShowPbCommentFloat(z2);
            if (str != null) {
                videoPlayActivityConfig.setNid(str);
            }
            if (c.a.s0.b.d.m0() && ("index".equals(str5) || "concern_tab".equals(str5) || "hot_juhe".equals(str5))) {
                VideoClickTabData videoClickTabData = new VideoClickTabData();
                videoClickTabData.setVideoMiddleBundle(videoPlayActivityConfig.getIntent().getExtras());
                TbSingleton.getInstance().setReloginVideoMiddleBundle(videoClickTabData.getVideoMiddleBundle());
                BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FROM_TAB, "video", "tran");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921610, videoClickTabData));
            } else if (z3) {
                if (ListUtils.getCount(list) <= 0 || list.get(0) == null || TextUtils.isEmpty(list.get(0).thread_id)) {
                    str7 = "";
                } else {
                    String str9 = list.get(0).thread_id;
                    str7 = list.get(0).forum_id;
                    List<VideoItemData> videoTabListByFid = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str7);
                    int size = videoTabListByFid.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (videoTabListByFid.get(i4) != null && str9.equals(videoTabListByFid.get(i4).thread_id)) {
                            str8 = str7;
                            i3 = i4;
                            break;
                        }
                    }
                }
                str8 = str7;
                i3 = 0;
                FrsVideoTabPlayActivityConfig frsVideoTabPlayActivityConfig = new FrsVideoTabPlayActivityConfig(context, null, i3, rect, str2, str3, str4, str5, str6);
                frsVideoTabPlayActivityConfig.setIsShowPbCommentFloat(z2);
                frsVideoTabPlayActivityConfig.setFid(str8);
                if ("frs".equals(str5)) {
                    BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_FROM, FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_PAGE, "tran");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, frsVideoTabPlayActivityConfig));
            } else {
                if ("frs".equals(str5)) {
                    BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FROM_FRS, "video", "tran");
                } else if ("index".equals(str5)) {
                    BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FROM_HOME, "video", "tran");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
            }
        }
    }
}
