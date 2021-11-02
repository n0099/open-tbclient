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
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.cyberplayer.sdk.videodownload.VideoSourceBean;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static CyberPlayerCoreProvider f37045a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f37046b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f37047c = "com.baidu.media.duplayer";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37048d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f37049e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f37050f;

    /* renamed from: g  reason: collision with root package name */
    public static Class<?> f37051g;
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
        f37048d = f37047c + ".CyberVRRenderProviderImpl";
        f37049e = f37047c + ".MediaInstanceManagerImpl";
        f37050f = f37047c + ".CyberPlayerCoreImpl";
    }

    public static int a(String str, int i2, int i3, int i4, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) ? a(1) ? f37045a.getDevicePlayQualityScore(str, i2, i3, i4, map) : i3 * i4 < 921600 ? 100 : -1 : invokeCommon.intValue;
    }

    public static CyberVRRenderProvider a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f37051g == null) {
                try {
                    f37051g = Class.forName(f37048d, false, context.getClassLoader());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f37051g = null;
                }
            }
            Class<?> cls = f37051g;
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
                return f37045a.createCyberPlayer(i2, httpDNS);
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
                return f37045a.createCaptureManager(context, i2, i3, i4, i5, i6);
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
                return f37045a.createRTCVideoView(context, attributeSet);
            }
            return null;
        }
        return (RTCVideoViewProvider) invokeLL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f37045a;
            return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str, VideoSourceBean videoSourceBean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, videoSourceBean)) == null) ? a(1) ? f37045a.startDownload(str, videoSourceBean) : str : (String) invokeLL.objValue;
    }

    public static Map<String, String> a(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, libsVersionType)) == null) {
            if (a(1)) {
                return f37045a.getLibsVersion(libsVersionType);
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65545, null, j) == null) && a(1)) {
            f37045a.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str, CyberPlayerManager.InstallListener2 installListener2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, context, classLoader, str, installListener2) == null) {
            synchronized (d.class) {
                if (f37045a == null) {
                    try {
                        CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(f37050f, true, classLoader).newInstance();
                        f37045a = cyberPlayerCoreProvider;
                        cyberPlayerCoreProvider.init(context, str);
                        f37045a.setInstallListener(installListener2);
                        if (f37045a != null) {
                            CyberClassLoader.addNativeLibraryDirectories(classLoader, f37045a.getLibsSearchPath());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        f37045a = null;
                        throw e2;
                    }
                }
            }
        }
    }

    public static void a(CyberVideoDownloader.DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, downloadListener) == null) && a(1)) {
            f37045a.setDownloadListener(downloadListener);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, str) == null) && !com.baidu.cyberplayer.sdk.remote.g.a().b(str) && a(1)) {
            f37045a.updatePlayerConfig(str);
        }
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        long longValue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), httpDNS, str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) && !com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.31.32.19";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                if (!f37046b && CyberPlayerManager.getNetHandleListener() != null) {
                    longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                    if (longValue != 0 && c(longValue) == 0) {
                        f37046b = true;
                    }
                }
                f37045a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            if (!f37046b) {
                longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                if (longValue != 0) {
                    f37046b = true;
                }
            }
            f37045a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, null, z) == null) && a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f37045a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f37045a;
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i2, map)) == null) {
            CyberPlayerCoreProvider cyberPlayerCoreProvider = f37045a;
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
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65553, null, bArr, i2, bArr2)) == null) {
            if (a(1)) {
                f37045a.duplayerEncrypt(bArr, i2, bArr2);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static ExtractorProvider b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (a(1)) {
                return f37045a.createCyberExtractor();
            }
            return null;
        }
        return (ExtractorProvider) invokeV.objValue;
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65555, null, j) == null) && a(1)) {
            f37045a.updateStorageQuota(j);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, str) == null) && a(1)) {
            f37045a.stopPrefetch(str);
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65557, null, z) == null) && a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f37045a.enableRTCCaptureDebug(z);
        }
    }

    public static int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65558, null, j)) == null) {
            if (a(1)) {
                return f37045a.nativeKernelNetInit(j);
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public static MediaInstanceManagerProvider c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (a(1)) {
                return f37045a.createInstanceManager();
            }
            return null;
        }
        return (MediaInstanceManagerProvider) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
            if (a2 >= 0) {
                return a2 == 1;
            } else if (a(1)) {
                return f37045a.hasCacheFile(str);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static CyberAudioRecorder d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (a(5)) {
                return f37045a.createCyberAudioRecorder();
            }
            return null;
        }
        return (CyberAudioRecorder) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, null, str) == null) && a(1)) {
            f37045a.setWorkDir(str);
        }
    }

    public static RTCRoomProvider e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (a(33)) {
                return f37045a.createRTCRoom();
            }
            return null;
        }
        return (RTCRoomProvider) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && a(1)) {
            f37045a.pauseDownload(str);
        }
    }

    public static DlnaProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (a(1)) {
                return f37045a.createDlna();
            }
            return null;
        }
        return (DlnaProvider) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65566, null, str) == null) && a(1)) {
            f37045a.cancelDownload(str);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, str) == null) && a(1)) {
            f37045a.deleteDownload(str);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? f37045a != null : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65569, null) == null) && a(1)) {
            f37045a.updateCfg();
        }
    }

    public static long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            if (a(1)) {
                return f37045a.caculateFolderSize();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static HashMap<Integer, Long> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (a(1)) {
                return f37045a.getSystemInfraInfo();
            }
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            if (a(1)) {
                return f37045a.downgrade();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
