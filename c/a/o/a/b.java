package c.a.o.a;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1214241523, "Lc/a/o/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1214241523, "Lc/a/o/a/b;");
        }
    }

    public static boolean a(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, weakReference, z)) == null) {
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (z) {
                if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                    return false;
                }
            } else if (audioManager.abandonAudioFocus(null) != 1) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }
}
