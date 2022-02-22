package c.a.d0.v.m0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bdVideoSeries)) == null) {
            if (bdVideoSeries == null || bdVideoSeries.getSelectedVideo() == null) {
                return 0;
            }
            return c.a.d0.v.v0.d.c(bdVideoSeries.getSelectedVideo().getTotalLength());
        }
        return invokeL.intValue;
    }

    public static void b(@Nullable BdVideoSeries bdVideoSeries, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, null, bdVideoSeries, i2, i3) == null) || bdVideoSeries == null || bdVideoSeries.getSelectedVideo() == null) {
            return;
        }
        bdVideoSeries.setPositionMs(i2);
        bdVideoSeries.setDurationMs(i3);
        BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
        selectedVideo.setCurrentLength((i2 / 1000) + "");
        BdVideo selectedVideo2 = bdVideoSeries.getSelectedVideo();
        selectedVideo2.setTotalLength((i3 / 1000) + "");
    }

    @NonNull
    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    int d2 = c.a.d0.v.v0.d.d(str, -1);
                    return d2 < 0 ? "" : c.a.d0.v.v0.d.b(d2, false);
                } catch (Exception e2) {
                    c.a.d0.v.v0.h.k("toTimeString(" + str + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
