package c.a.c0.s.j0;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoNewCacheView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f2433i;

    /* renamed from: j  reason: collision with root package name */
    public BdThumbSeekBar f2434j;

    /* renamed from: k  reason: collision with root package name */
    public BdVideoNewCacheView f2435k;

    public p() {
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

    @Override // c.a.c0.s.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2433i = new FrameLayout(this.f2414g);
            K();
            L();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f2433i == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = c.a.c0.e0.a.d.b.b(-4.0f);
        BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.f2414g, 2);
        this.f2434j = bdThumbSeekBar;
        bdThumbSeekBar.setThumbScaleVisible(false);
        this.f2434j.setDragable(false);
        this.f2434j.setProgressColor(this.f2414g.getResources().getColor(c.a.c0.h0.o.nad_video_seek_bar_played_color));
        this.f2433i.addView(this.f2434j, layoutParams);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdVideoNewCacheView bdVideoNewCacheView = new BdVideoNewCacheView(this.f2414g);
            this.f2435k = bdVideoNewCacheView;
            bdVideoNewCacheView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f2433i.addView(this.f2435k, layoutParams);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2435k.startCacheRotation(4);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f2435k.startCacheRotation(0);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(pVar.c())) {
                if (701 == pVar.g(1)) {
                    N();
                    return;
                } else {
                    M();
                    return;
                }
            }
            M();
        }
    }

    @Override // c.a.c0.s.j0.o
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2433i : (View) invokeV.objValue;
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{2, 4, 5} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                M();
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            if (ControlEvent.ACTION_SYNC_PROGRESS.equals(pVar.c())) {
                this.f2434j.syncPos(pVar.g(1), pVar.g(2), pVar.g(3));
            } else if (ControlEvent.ACTION_START.equals(pVar.c())) {
                N();
            } else if (ControlEvent.ACTION_STOP.equals(pVar.c())) {
                M();
            }
        }
    }
}
