package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static CyberPlayerCoreProvider f4810a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4811b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f4812c = "com.baidu.media.duplayer";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4813d = f4812c + ".CyberVRRenderProviderImpl";

    /* renamed from: e  reason: collision with root package name */
    public static final String f4814e = f4812c + ".MediaInstanceManagerImpl";

    /* renamed from: f  reason: collision with root package name */
    public static final String f4815f = f4812c + ".CyberPlayerCoreImpl";

    /* renamed from: g  reason: collision with root package name */
    public static Class<?> f4816g;

    public static int a(String str, int i2, int i3, int i4, Map<String, String> map) {
        if (a(1)) {
            return f4810a.getDevicePlayQualityScore(str, i2, i3, i4, map);
        }
        return -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        if (f4816g == null) {
            try {
                f4816g = Class.forName(f4813d, false, context.getClassLoader());
            } catch (Exception e2) {
                e2.printStackTrace();
                f4816g = null;
            }
        }
        Class<?> cls = f4816g;
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

    public static PlayerProvider a(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return f4810a.createCyberPlayer(i2, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        if (a(33)) {
            return f4810a.createCaptureManager(context, i2, i3, i4, i5, i6);
        }
        return null;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        if (a(33)) {
            return f4810a.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static String a() {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4810a;
        return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
    }

    public static Map<String, String> a(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        if (a(1)) {
            return f4810a.getLibsVersion(libsVersionType);
        }
        return null;
    }

    public static void a(long j) {
        if (a(1)) {
            f4810a.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        synchronized (d.class) {
            if (f4810a == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(f4815f, true, classLoader).newInstance();
                    f4810a = cyberPlayerCoreProvider;
                    cyberPlayerCoreProvider.init(context, str);
                    if (f4810a != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, f4810a.getLibsSearchPath());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f4810a = null;
                    throw e2;
                }
            }
        }
    }

    public static void a(String str) {
        if (!com.baidu.cyberplayer.sdk.remote.g.a().b(str) && a(1)) {
            f4810a.updatePlayerConfig(str);
        }
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        long longValue;
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.26.2.13";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                if (!f4811b && CyberPlayerManager.getNetHandleListener() != null) {
                    longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                    if (longValue != 0 && c(longValue) == 0) {
                        f4811b = true;
                    }
                }
                f4810a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            if (!f4811b) {
                longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                if (longValue != 0) {
                    f4811b = true;
                }
            }
            f4810a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
        }
    }

    public static void a(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f4810a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i2) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4810a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i2);
        }
        return false;
    }

    public static boolean a(int i2, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4810a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i2, map);
        }
        return a(i2);
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2) {
        if (a(1)) {
            f4810a.duplayerEncrypt(bArr, i2, bArr2);
            return true;
        }
        return false;
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return f4810a.createCyberExtractor();
        }
        return null;
    }

    public static void b(long j) {
        if (a(1)) {
            f4810a.updateStorageQuota(j);
        }
    }

    public static void b(String str) {
        if (a(1)) {
            f4810a.stopPrefetch(str);
        }
    }

    public static void b(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            f4810a.enableRTCCaptureDebug(z);
        }
    }

    public static int c(long j) {
        if (a(1)) {
            return f4810a.nativeKernelNetInit(j);
        }
        return -1;
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return f4810a.createInstanceManager();
        }
        return null;
    }

    public static boolean c(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return f4810a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return f4810a.createCyberAudioRecorder();
        }
        return null;
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return f4810a.createRTCRoom();
        }
        return null;
    }

    public static DlnaProvider f() {
        if (a(1)) {
            return f4810a.createDlna();
        }
        return null;
    }

    public static boolean g() {
        return f4810a != null;
    }

    public static void h() {
        if (a(1)) {
            f4810a.updateCfg();
        }
    }

    public static long i() {
        if (a(1)) {
            return f4810a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> j() {
        if (a(1)) {
            return f4810a.getSystemInfraInfo();
        }
        return null;
    }

    public static boolean k() {
        if (a(1)) {
            return f4810a.downgrade();
        }
        return false;
    }
}
