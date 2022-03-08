package c.a.b0.v.d0;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.b0.v.m0.f a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            c.a.b0.v.m0.f fVar = new c.a.b0.v.m0.f();
            fVar.k(str2);
            fVar.l(c.a.b0.v.m0.e.c(bdVideo.getCurrentLength()) + "/" + c.a.b0.v.m0.e.c(bdVideo.getTotalLength()));
            fVar.p(bdVideoSeries.getVid());
            fVar.m(bdVideo.getType());
            fVar.j(System.currentTimeMillis());
            fVar.n(bdVideo.getTitle());
            fVar.o(str);
            fVar.r(bdVideoSeries.getPositionMs());
            fVar.q(bdVideo.getCurrentLength());
            fVar.s(bdVideo.getTotalLength());
            return fVar;
        }
        return (c.a.b0.v.m0.f) invokeLLLL.objValue;
    }
}
