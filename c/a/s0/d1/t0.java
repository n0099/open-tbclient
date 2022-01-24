package c.a.s0.d1;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class t0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1894619209, "Lc/a/s0/d1/t0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1894619209, "Lc/a/s0/d1/t0;");
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 == 2) {
                int frsAutoPlay = TbadkCoreApplication.getInst().getFrsAutoPlay();
                if ((frsAutoPlay == 1 || !c.a.d.f.p.l.H()) && (frsAutoPlay != 2 || !c.a.d.f.p.l.x())) {
                    return false;
                }
            } else if (i2 == 3 || i2 == 4) {
                return c.a.d.f.p.l.H();
            } else {
                if (i2 != 5) {
                    int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
                    if ((homePageAutoPlay == 1 || !c.a.d.f.p.l.H()) && (homePageAutoPlay != 2 || !c.a.d.f.p.l.x())) {
                        return false;
                    }
                } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !c.a.d.f.p.l.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 0)) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, str)) == null) ? a(i2) : invokeIL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : invokeV.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? (context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload() && c.a.s0.b.d.L() : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (!c.a.d.f.p.l.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
                return c.a.d.f.p.l.x() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean f(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, weakReference, z)) == null) {
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

    public static void g(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, weakReference) == null) || weakReference == null || weakReference.get() == null) {
            return;
        }
        a = ((AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isMusicActive();
    }
}
