package com.baidu.searchbox.player.kernel;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class EmptyKernel extends AbsVideoKernel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EmptyKernel() {
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

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            BdVideoLog.e("player has released, cannot call changePlayUrl!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdVideoLog.e("player has released, cannot call getBVideoView!!!");
            return new FrameLayout(BDPlayerConfig.getAppContext());
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdVideoLog.e("player has released, cannot call getBufferingPosition!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdVideoLog.e("player has released, cannot call getDuration!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdVideoLog.e("player has released, cannot call getDurationMs!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdVideoLog.e("player has released, cannot call getPlayedTime!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdVideoLog.e("player has released, cannot call getPosition!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdVideoLog.e("player has released, cannot call getPositionMs!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdVideoLog.e("player has released, cannot call getSyncPositionMs!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdVideoLog.e("player has released, cannot call getVideoHeight!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdVideoLog.e("player has released, cannot call getVideoWidth!!!");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            BdVideoLog.e("player has released, cannot call mute!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdVideoLog.e("player has released, cannot call onComplete!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BdVideoLog.e("player has released, cannot call onError!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onInfo(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, obj) == null) {
            BdVideoLog.e("player has released, cannot call onInfo!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdVideoLog.e("player has released, cannot call onPrepared!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            BdVideoLog.e("player has released, cannot call play!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            BdVideoLog.e("player has released, cannot call seekTo!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            BdVideoLog.e("player has released, cannot call setDecodeMode!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, obj) == null) {
            BdVideoLog.e("player has released, cannot call setExternalInfo!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, hashMap) == null) {
            BdVideoLog.e("player has released, cannot call setHttpHeader!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iKernelPlayer) == null) {
            BdVideoLog.e("player has released, cannot call setKernelCallBack!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            BdVideoLog.e("player has released, cannot call setLooping!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) {
            BdVideoLog.e("player has released, cannot call setOption!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            BdVideoLog.e("player has released, cannot call setPageUrl!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdVideoLog.e("player has released, cannot call setProxy!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            BdVideoLog.e("player has released, cannot call setSpeed!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            BdVideoLog.e("player has released, cannot call setUserAgent!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, hashMap) == null) {
            BdVideoLog.e("player has released, cannot call setVideoFormatOptions!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            BdVideoLog.e("player has released, cannot call setVideoRotation!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            BdVideoLog.e("player has released, cannot call setVideoScalingMode!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoSession(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, videoSession) == null) {
            BdVideoLog.e("player has released, cannot call setVideoSession!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            BdVideoLog.e("player has released, cannot call setVideoUrl!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            BdVideoLog.e("player has released, cannot call start!!!");
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048611, this, onSnapShotCompleteListener, f2)) == null) {
            return false;
        }
        return invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            BdVideoLog.e("player has released, cannot call updateFreeProxy!!!");
        }
    }
}
