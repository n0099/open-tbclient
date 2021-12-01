package c.a.b0.s.j0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.f0.c;
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

    /* renamed from: k  reason: collision with root package name */
    public String f1973k;

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

    @Override // c.a.b0.s.j0.b
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Z();
        }
    }

    @Override // c.a.b0.s.j0.a
    public void V(c.a.b0.s.f0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.V(aVar);
            c.a.b0.s.f0.a aVar2 = this.f1966j;
            if (aVar2 != null) {
                aVar2.d(this);
            }
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.f1973k) || "ad_video_detail_tail_frame_layer".equals(this.f1973k)) {
                Y();
            }
        }
    }

    public final void Y() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = v().o1();
            c.a.b0.s.f v = v();
            if (o1 == null || v == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            c.a.b0.s.f0.e a = c.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(v.V0());
            V(a);
        }
    }

    public void Z() {
        c.a.b0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f1966j) == null) {
            return;
        }
        aVar.onDestroy();
        this.f1966j = null;
    }

    public final void a0() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.f1973k) || "ad_video_detail_tail_frame_layer".equals(this.f1973k)) && (this.f1966j instanceof c.a.b0.s.f0.e) && (o1 = v().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((c.a.b0.s.f0.e) this.f1966j).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(pVar.c()) && !TextUtils.isEmpty(this.f1973k)) {
                if (this.f1966j != null) {
                    a0();
                } else {
                    X();
                }
            }
            c.a.b0.s.f0.a aVar = this.f1966j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.b0.s.j0.a, c.a.b0.s.f0.k
    public boolean f(@NonNull c.a.b0.s.c0.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pVar)) == null) {
            if (v().U0()) {
                return false;
            }
            return super.f(pVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            super.l(pVar);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
                c.a.b0.f.a.a("AdLayer", "screen mode: " + pVar.c());
            }
            c.a.b0.s.f0.a aVar = this.f1966j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void o(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            super.o(pVar);
            c.a.b0.s.f0.a aVar = this.f1966j;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }
    }

    @Override // c.a.b0.s.j0.a, c.a.b0.s.j0.j, c.a.b0.s.j0.b, c.a.b0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            Z();
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void r(@NonNull c.a.b0.s.c0.p pVar) {
        c.a.b0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) || (aVar = this.f1966j) == null) {
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
        this.f1973k = str;
    }
}
