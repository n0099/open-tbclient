package c.a.b0.v.i0;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // c.a.b0.v.i0.a
    public void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "seekTo(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setClarityInfo(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.b0.v.v0.h.d("player has released, cannot call setDataSourceAndPrepare!!!");
        }
    }

    @Override // c.a.b0.v.i0.a
    public void D(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setHttpHeader(" + hashMap + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void E(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setKernelCallBack(" + System.identityHashCode(eVar) + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setLooping(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setPlayConf(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void H(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void I(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setSpeed(" + f2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void K(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, hashMap) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setVideoFormatOptions(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "setVideoScalingMode(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void M(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "player has released, cannot call setVideoUrl!!! isNeedChangeState = " + z);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "start()");
        }
    }

    @Override // c.a.b0.v.i0.a
    public void R(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "updateFreeProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "changePlayUrl(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    @NonNull
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getBVideoView()");
            return new FrameLayout(c.a.b0.v.d.b());
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.i0.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getBufferingPosition()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getDuration()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getDurationMs()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getPosition()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getPositionMs()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getVideoHeight()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "getVideoWidth()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b0.v.i0.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "mute(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a, c.a.b0.v.p0.c
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // c.a.b0.v.i0.a
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "onComplete()");
        }
    }

    @Override // c.a.b0.v.i0.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "onError()");
        }
    }

    @Override // c.a.b0.v.i0.a
    public void s(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, obj) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "onInfo(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // c.a.b0.v.i0.a
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.b0.v.v0.h.e(EmptyKernel.TAG, "onPrepared()");
        }
    }

    @Override // c.a.b0.v.i0.a, c.a.b0.v.p0.c
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? EmptyKernel.TAG.equals(str) : invokeL.booleanValue;
    }
}
