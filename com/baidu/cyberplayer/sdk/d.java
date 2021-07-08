package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static CyberPlayerCoreProvider f4857a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4858b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f4859c = "com.baidu.media.duplayer";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4860d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f4861e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f4862f;

    /* renamed from: g  reason: collision with root package name */
    public static Class<?> f4863g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-598477553, "Lcom/baidu/cyberplayer/sdk/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-598477553, "Lcom/baidu/cyberplayer/sdk/d;");
                return;
            }
        }
        f4860d = f4859c + ".CyberVRRenderProviderImpl";
        f4861e = f4859c + ".MediaInstanceManagerImpl";
        f4862f = f4859c + ".CyberPlayerCoreImpl";
    }

    public static int a(String str, int i2, int i3, int i4, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            if (a(1)) {
                return f4857a.getDevicePlayQualityScore(str, i2, i3, i4, map);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static CyberVRRenderProvider a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f4863g == null) {
                try {
                    f4863g = Class.forName(f4860d, false, context.getClassLoader());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f4863g = null;
                }
            }
            Class<?> cls = f4863g;
            if (cls != null) {
                try {
                    return (CyberVRRenderProvider) cls.getConstructor(Context.class).newInstance(context);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    CyberLog.e("CyberPlayerCoreInvoker", "create CyberVRRender failed");
                    return null;
                }
            }
            return null;
        }
        return (CyberVRRenderProvider) invokeL.objValue;
    }

    public static PlayerProvider a(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, httpDNS)) == null) {
            if (a(1)) {
                return f4857a.createCyberPlayer(i2, httpDNS);
            }
            return null;
        }
        return (PlayerProvider) invokeIL.objValue;
    }

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (a(33)) {
                return f4857a.createCaptureManager(context, i2, i3, i4, i5, i6);
            }
            return null;
        }
        return (CaptureManagerProvider) invokeCommon.objValue;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, attributeSet)) == null) {
            if (a(33)) {
                return f4857a.createRTCVideoView(context, attributeSet);
            }
            return null;
        }
        return (RTCVideoViewProvider) invokeLL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f4857a;
            return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
        }
        return (String) invokeV.objValue;
    }

    public static Map<String, String> a(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, libsVersionType)) == null) {
            if (a(1)) {
                return f4857a.getLibsVersion(libsVersionType);
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65544, null, j) == null) && a(1)) {
            f4857a.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, classLoader, str) == null) {
            synchronized (d.class) {
                if (f4857a == null) {
                    try {
                        CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(f4862f, true, classLoader).newInstance();
                        f4857a = cyberPlayerCoreProvider;
                        cyberPlayerCoreProvider.init(context, str);
                        if (f4857a != null) {
                            CyberClassLoader.addNativeLibraryDirectories(classLoader, f4857a.getLibsSearchPath());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        f4857a = null;
                        throw e2;
                    }
                }
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, str) == null) && !com.baidu.cyberplayer.sdk.remote.g.a().b(str) && a(1)) {
            f4857a.updatePlayerConfig(str);
        }
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        long longValue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), httpDNS, str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) && !com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.26.2.13";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                if (!f4858b && CyberPlayerManager.getNetHandleListener() != null) {
                    longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                    if (longValue != 0 && c(longValue) == 0) {
                        f4858b = true;
                    }
                }
                f4857a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            if (!f4858b) {
                longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                if (longValue != 0) {
                    f4858b = true;
                }
            }
            f4857a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65548, null, z) == null) && a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f4857a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f4857a;
            if (cyberPlayerCoreProvider != null) {
                return cyberPlayerCoreProvider.isLoaded(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean a(int i2, Map<String, String> map) throws FileNotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i2, map)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f4857a;
            if (cyberPlayerCoreProvider != null) {
                cyberPlayerCoreProvider.loadlibs(i2, map);
            }
            return a(i2);
        }
        return invokeIL.booleanValue;
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, bArr, i2, bArr2)) == null) {
            if (a(1)) {
                f4857a.duplayerEncrypt(bArr, i2, bArr2);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static ExtractorProvider b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (a(1)) {
                return f4857a.createCyberExtractor();
            }
            return null;
        }
        return (ExtractorProvider) invokeV.objValue;
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65553, null, j) == null) && a(1)) {
            f4857a.updateStorageQuota(j);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, str) == null) && a(1)) {
            f4857a.stopPrefetch(str);
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65555, null, z) == null) && a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f4857a.enableRTCCaptureDebug(z);
        }
    }

    public static int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) {
            if (a(1)) {
                return f4857a.nativeKernelNetInit(j);
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public static MediaInstanceManagerProvider c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (a(1)) {
                return f4857a.createInstanceManager();
            }
            return null;
        }
        return (MediaInstanceManagerProvider) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
            if (a2 >= 0) {
                return a2 == 1;
            } else if (a(1)) {
                return f4857a.hasCacheFile(str);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static CyberAudioRecorder d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (a(5)) {
                return f4857a.createCyberAudioRecorder();
            }
            return null;
        }
        return (CyberAudioRecorder) invokeV.objValue;
    }

    public static RTCRoomProvider e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (a(33)) {
                return f4857a.createRTCRoom();
            }
            return null;
        }
        return (RTCRoomProvider) invokeV.objValue;
    }

    public static DlnaProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (a(1)) {
                return f4857a.createDlna();
            }
            return null;
        }
        return (DlnaProvider) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? f4857a != null : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, null) == null) && a(1)) {
            f4857a.updateCfg();
        }
    }

    public static long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (a(1)) {
                return f4857a.caculateFolderSize();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static HashMap<Integer, Long> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (a(1)) {
                return f4857a.getSystemInfraInfo();
            }
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            if (a(1)) {
                return f4857a.downgrade();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
