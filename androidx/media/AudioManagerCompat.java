package androidx.media;

import android.media.AudioManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final String TAG = "AudioManCompat";
    public transient /* synthetic */ FieldHolder $fh;

    public AudioManagerCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, audioManager, audioFocusRequestCompat)) == null) {
            if (audioManager != null) {
                if (audioFocusRequestCompat != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return audioManager.abandonAudioFocusRequest(audioFocusRequestCompat.getAudioFocusRequest());
                    }
                    return audioManager.abandonAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener());
                }
                throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            }
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        return invokeLL.intValue;
    }

    public static int requestAudioFocus(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, audioManager, audioFocusRequestCompat)) == null) {
            if (audioManager != null) {
                if (audioFocusRequestCompat != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return audioManager.requestAudioFocus(audioFocusRequestCompat.getAudioFocusRequest());
                    }
                    return audioManager.requestAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener(), audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), audioFocusRequestCompat.getFocusGain());
                }
                throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            }
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        return invokeLL.intValue;
    }
}
