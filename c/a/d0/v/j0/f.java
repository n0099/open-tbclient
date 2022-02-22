package c.a.d0.v.j0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.v.f0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.d0.v.j0.b
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            R();
        }
    }

    @Override // c.a.d0.v.j0.a
    public void N(c.a.d0.v.f0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.N(aVar);
            c.a.d0.v.f0.a aVar2 = this.f3302j;
            if (aVar2 != null) {
                aVar2.d(this);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.k) || "ad_video_detail_tail_frame_layer".equals(this.k)) {
                Q();
            }
        }
    }

    public final void Q() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            c.a.d0.v.f u = u();
            if (o1 == null || u == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            c.a.d0.v.f0.e a = c.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(u.V0());
            N(a);
        }
    }

    public void R() {
        c.a.d0.v.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f3302j) == null) {
            return;
        }
        aVar.onDestroy();
        this.f3302j = null;
    }

    public final void S() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.k) || "ad_video_detail_tail_frame_layer".equals(this.k)) && (this.f3302j instanceof c.a.d0.v.f0.e) && (o1 = u().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((c.a.d0.v.f0.e) this.f3302j).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void d(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(pVar.c()) && !TextUtils.isEmpty(this.k)) {
                if (this.f3302j != null) {
                    S();
                } else {
                    P();
                }
            }
            c.a.d0.v.f0.a aVar = this.f3302j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.d0.v.j0.a, c.a.d0.v.f0.k
    public boolean e(@NonNull c.a.d0.v.c0.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pVar)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(pVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void k(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            super.k(pVar);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
                c.a.d0.i.a.a("AdLayer", "screen mode: " + pVar.c());
            }
            c.a.d0.v.f0.a aVar = this.f3302j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void n(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            super.n(pVar);
            c.a.d0.v.f0.a aVar = this.f3302j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.d0.v.j0.a, c.a.d0.v.j0.j, c.a.d0.v.j0.b, c.a.d0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            R();
        }
    }

    @Override // c.a.d0.v.j0.b, c.a.d0.v.f0.j
    public void q(@NonNull c.a.d0.v.c0.p pVar) {
        c.a.d0.v.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) || (aVar = this.f3302j) == null) {
            return;
        }
        aVar.c(pVar);
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = str;
    }
}
