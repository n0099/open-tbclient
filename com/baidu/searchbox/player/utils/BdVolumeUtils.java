package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class BdVolumeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BdVolumeUtils() {
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

    @Nullable
    public static AudioManager getAudioManager(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (AudioManager) invokeL.objValue;
    }

    public static int getMaxVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int getVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static float getVolumePercent(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager != null) {
                return Math.round((audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) * 1000.0f) / 1000.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static void setVolume(Context context, int i2) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, context, i2) == null) || (audioManager = getAudioManager(context)) == null) {
            return;
        }
        audioManager.setStreamVolume(3, i2, 8);
    }

    public static void setVolumePercent(Context context, float f2) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65542, null, context, f2) == null) || (audioManager = getAudioManager(context)) == null) {
            return;
        }
        audioManager.setStreamVolume(3, Math.round(audioManager.getStreamMaxVolume(3) * f2), 0);
    }
}
