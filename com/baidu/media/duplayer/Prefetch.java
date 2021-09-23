package com.baidu.media.duplayer;

import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.media.playerconfig.PlayerConfigManagerInternal;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public class Prefetch {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "filecache-Prefetch";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2045635328, "Lcom/baidu/media/duplayer/Prefetch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2045635328, "Lcom/baidu/media/duplayer/Prefetch;");
        }
    }

    public Prefetch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void add(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), httpDNS, str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) {
            int i9 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
            if (i4 >= 30720) {
                i9 = i4 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i4;
            }
            if (str == null || str.length() <= 0) {
                return;
            }
            String j2 = Utils.j();
            if (j2 == null) {
                str5 = "";
            } else {
                str5 = "http://" + j2;
            }
            CyberLog.i(TAG, "adjustPrefetchPolicy call before url : " + str + " prefetchSize : " + i9);
            PlayerConfigManagerInternal.b adjustPrefetchPolicy = adjustPrefetchPolicy(str, i9, prefetchOptions);
            CyberLog.i(TAG, "adjustPrefetchPolicy call after url : " + adjustPrefetchPolicy.f42712b + " info.adjustSize : " + adjustPrefetchPolicy.f42711a);
            if (Utils.a() > Utils.f42678b) {
                nativeAdd(adjustPrefetchPolicy.f42712b, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i2, i3, adjustPrefetchPolicy.f42711a, str4, i5, i6, i7, i8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PlayerConfigManagerInternal.b adjustPrefetchPolicy(String str, int i2, PrefetchOptions prefetchOptions) {
        InterceptResult invokeLIL;
        int i3;
        Map<String, String> options;
        int i4;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(65539, null, str, i2, prefetchOptions)) != null) {
            return (PlayerConfigManagerInternal.b) invokeLIL.objValue;
        }
        PlayerConfigManagerInternal.b bVar = new PlayerConfigManagerInternal.b(str, i2);
        CyberLog.i(TAG, "adjustPrefetchPolicy call");
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, true)) {
            return bVar;
        }
        CyberLog.i(TAG, "adjustPrefetchPolicy call use PlayerServer");
        int i5 = 0;
        if (prefetchOptions != null && (options = prefetchOptions.getOptions()) != null) {
            String str3 = options.get(CyberPlayerManager.OPT_VIDEO_BPS);
            if (str3 != null && !str3.isEmpty()) {
                try {
                    i4 = Integer.parseInt(str3);
                } catch (Exception unused) {
                }
                str2 = options.get(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE);
                if (str2 != null && !str2.isEmpty()) {
                    try {
                        i3 = Integer.parseInt(str2);
                        i5 = i4;
                    } catch (Exception unused2) {
                    }
                    String str4 = TAG;
                    CyberLog.i(str4, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
                    return i5 <= 0 ? bVar : bVar;
                }
                i5 = i4;
            }
            i4 = 0;
            str2 = options.get(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE);
            if (str2 != null) {
                i3 = Integer.parseInt(str2);
                i5 = i4;
                String str42 = TAG;
                CyberLog.i(str42, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
                return i5 <= 0 ? bVar : bVar;
            }
            i5 = i4;
        }
        i3 = 0;
        String str422 = TAG;
        CyberLog.i(str422, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
        if (i5 <= 0) {
        }
    }

    public static boolean hasCacheFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? nativeHasCacheFile(str) : invokeL.booleanValue;
    }

    public static native void nativeAdd(String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5, int i5, int i6, int i7, int i8);

    public static native boolean nativeHasCacheFile(String str);

    public static native void nativeStopPrefetch(String str);

    public static void stopPrefetch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            nativeStopPrefetch(str);
        }
    }
}
