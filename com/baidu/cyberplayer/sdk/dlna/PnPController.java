package com.baidu.cyberplayer.sdk.dlna;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public class PnPController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CtrlPointProvider a;

    public PnPController(String str, DlnaProvider dlnaProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dlnaProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        if (dlnaProvider != null) {
            this.a = dlnaProvider.ctrlPoint(str);
        }
    }

    public long getCurrentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CtrlPointProvider ctrlPointProvider = this.a;
            if (ctrlPointProvider != null) {
                return ctrlPointProvider.getCurrentTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CtrlPointProvider ctrlPointProvider = this.a;
            if (ctrlPointProvider != null) {
                return ctrlPointProvider.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getPlaybackVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CtrlPointProvider ctrlPointProvider = this.a;
            if (ctrlPointProvider != null) {
                return ctrlPointProvider.getPlaybackVolume();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getUrlPlayStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            CtrlPointProvider ctrlPointProvider = this.a;
            if (ctrlPointProvider == null || str == null) {
                return -1;
            }
            return ctrlPointProvider.getUrlPlayStatus(str);
        }
        return invokeL.intValue;
    }

    public void pause() {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.pause();
    }

    public void play() {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.play();
    }

    public void seek(long j2) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.seek(j2);
    }

    public void setAVTransportUrl(String str) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.setAVTransportUrl(str);
    }

    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ctrlPointListener) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.setListener(ctrlPointListener);
    }

    public void setMute(boolean z) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.setMute(z ? 1 : 0);
    }

    public void setPlaybackVolume(int i2) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.setPlaybackVolume(i2);
    }

    @Deprecated
    public void shutdown() {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.shutdown();
    }

    public void shutdown(boolean z) {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.shutdown(z);
    }

    public void stop() {
        CtrlPointProvider ctrlPointProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ctrlPointProvider = this.a) == null) {
            return;
        }
        ctrlPointProvider.stop();
    }
}
