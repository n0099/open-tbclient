package c.a.b0.v.i0;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.v.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.view.SysVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final SysVideoView f2130g;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2130g = new SysVideoView(s.a());
    }

    @Override // c.a.b0.v.i0.a
    public void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.f2130g.seekTo(i2, i3);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2130g.setVideoURI(this.f2124b, this.f2126d);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f2130g.setLooping(z);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void H(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void I(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void K(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, hashMap) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.N();
            this.f2130g.start();
            if (n(PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // c.a.b0.v.i0.a
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.O();
            P();
        }
    }

    @Override // c.a.b0.v.i0.a
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.P();
            this.f2130g.stop();
        }
    }

    @Override // c.a.b0.v.i0.a
    public void R(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    @Override // c.a.b0.v.i0.f
    public void S(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f2130g.setOnCompletionListener(gVar);
            this.f2130g.setOnErrorListener(gVar);
            this.f2130g.setOnInfoListener(gVar);
            this.f2130g.setOnSeekCompleteListener(gVar);
            this.f2130g.setOnPreparedListener(gVar);
            this.f2130g.setOnBufferingUpdateListener(gVar);
            this.f2130g.setOnVideoSizeChangedListener(gVar);
            U(true);
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    @NonNull
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2130g : (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.i0.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2130g.getDuration() / 1000 : invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f2130g.getDuration() : invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (n(PlayerStatus.IDLE)) {
                int e2 = e() / 1000;
                if (e2 - (this.f2130g.getCurrentPosition() / 1000) <= 2) {
                    return e2;
                }
            }
            return this.f2130g.getCurrentPosition() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (n(PlayerStatus.IDLE) && e() - this.f2130g.getCurrentPosition() <= 2) {
                return f();
            }
            return this.f2130g.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f2130g.getVideoHeight() : invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f2130g.getVideoWidth() : invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f2130g.muteOrUnmuteAudio(z);
        }
    }

    @Override // c.a.b0.v.i0.a, c.a.b0.v.p0.c
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onInit();
            this.f2130g.reset();
            this.f2130g.setVisibility(0);
            this.f2130g.setAlpha(1.0f);
            T(true);
            this.f2130g.setBackgroundColor(-16777216);
        }
    }

    @Override // c.a.b0.v.i0.a, c.a.b0.v.p0.c
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onRelease();
            this.f2126d.clear();
            P();
            this.f2130g.setVisibility(0);
            this.f2130g.setAlpha(1.0f);
            E(null);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.u();
            if (n(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                p(PlayerStatus.PAUSE);
                this.f2130g.pause();
            }
        }
    }

    @Override // c.a.b0.v.i0.a, c.a.b0.v.p0.c
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? "SysBuiltinKernel".equals(str) : invokeL.booleanValue;
    }

    @Override // c.a.b0.v.i0.a
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.y();
            if (n(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
                this.f2130g.start();
            }
        }
    }

    @Override // c.a.b0.v.i0.a
    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.f2130g.seekTo(i2);
        }
    }
}
