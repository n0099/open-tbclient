package c.a.o0.b1;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12655a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(477242245, "Lc/a/o0/b1/r0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(477242245, "Lc/a/o0/b1/r0;");
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 == 2) {
                int frsAutoPlay = TbadkCoreApplication.getInst().getFrsAutoPlay();
                if ((frsAutoPlay == 1 || !c.a.e.e.p.j.H()) && (frsAutoPlay != 2 || !c.a.e.e.p.j.x())) {
                    return false;
                }
            } else if (i2 == 3 || i2 == 4) {
                return c.a.e.e.p.j.H();
            } else {
                if (i2 != 5) {
                    int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
                    if ((homePageAutoPlay == 1 || !c.a.e.e.p.j.H()) && (homePageAutoPlay != 2 || !c.a.e.e.p.j.x())) {
                        return false;
                    }
                } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !c.a.e.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 0)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f12655a : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!c.a.e.e.p.j.H() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 1) {
                return c.a.e.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, weakReference, z)) == null) {
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

    public static void f(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, weakReference) == null) || weakReference == null || weakReference.get() == null) {
            return;
        }
        f12655a = ((AudioManager) weakReference.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isMusicActive();
    }
}
