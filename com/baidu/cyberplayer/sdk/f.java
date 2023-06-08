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
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.cyberplayer.sdk.videodownload.VideoSourceBean;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {
    public static CyberPlayerCoreProvider a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static CyberPlayerManager.OnPrefetchListener e;
    public static Class<?> i;
    public static String d = "com.baidu.media.duplayer";
    public static final String f = d + ".CyberVRRenderProviderImpl";
    public static final String g = d + ".MediaInstanceManagerImpl";
    public static final String h = d + ".CyberPlayerCoreImpl";

    public static int a(int i2, int i3, int i4) {
        if (a(1)) {
            return a.getDeviceHDRSupported(i2, i3, i4);
        }
        return -1;
    }

    public static int a(String str, int i2, int i3, int i4, Map<String, String> map) {
        if (a(1)) {
            return a.getDevicePlayQualityScore(str, i2, i3, i4, map);
        }
        if (i3 * i4 < 921600) {
            return 100;
        }
        return -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        if (i == null) {
            try {
                i = Class.forName(f, false, context.getClassLoader());
            } catch (Exception e2) {
                e2.printStackTrace();
                i = null;
            }
        }
        Class<?> cls = i;
        if (cls == null) {
            return null;
        }
        try {
            return (CyberVRRenderProvider) cls.getConstructor(Context.class).newInstance(context);
        } catch (Exception e3) {
            e3.printStackTrace();
            CyberLog.e("CyberPlayerCoreInvoker", "create CyberVRRender failed");
            return null;
        }
    }

    public static PlayerProvider a(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return a.createCyberPlayer(i2, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        if (a(33)) {
            return a.createCaptureManager(context, i2, i3, i4, i5, i6);
        }
        return null;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        if (a(33)) {
            return a.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static String a() {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.getCoreVersion();
        }
        return "";
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return a.createCyberExtractor();
        }
        return null;
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return a.createInstanceManager();
        }
        return null;
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return a.createCyberAudioRecorder();
        }
        return null;
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return a.createRTCRoom();
        }
        return null;
    }

    public static DlnaProvider f() {
        if (a(1)) {
            return a.createDlna();
        }
        return null;
    }

    public static boolean g() {
        if (a != null) {
            return true;
        }
        return false;
    }

    public static void h() {
        if (a(1)) {
            a.updateCfg();
        }
    }

    public static long i() {
        long d2 = com.baidu.cyberplayer.sdk.remote.h.a().d();
        if (d2 < 0) {
            if (!a(1)) {
                return 0L;
            }
            return a.calculateFolderSizeCanBeCleared();
        }
        return d2;
    }

    public static long j() {
        if (a(1)) {
            return a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> k() {
        if (a(1)) {
            return a.getSystemInfraInfo();
        }
        return null;
    }

    public static boolean l() {
        if (a(1)) {
            return a.downgrade();
        }
        return false;
    }

    public static void m() {
        if (!b && a(1) && CyberPlayerManager.getNetHandleListener() != null) {
            long longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
            if (longValue != 0 && a.kernelNetInit(longValue) == 0) {
                b = true;
            }
        }
    }

    public static void n() {
        if (!c && a(1) && CyberPlayerManager.getNetHandleListener() != null) {
            long longValue = CyberPlayerManager.getNetHandleListener().getPcdnNetHandle().longValue();
            if (longValue != 0 && a.pcdnNetInit(longValue) == 0) {
                c = true;
            }
        }
    }

    public static String a(String str, VideoSourceBean videoSourceBean) {
        if (a(1)) {
            return a.startDownload(str, videoSourceBean);
        }
        return str;
    }

    public static Map<String, String> a(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        if (a(1)) {
            return a.getLibsVersion(libsVersionType);
        }
        return null;
    }

    public static void b(long j) {
        if (a(1)) {
            a.cleanFileCacheWithThreshold(j);
        }
    }

    public static void c(long j) {
        if (a(1)) {
            a.updateStorageQuota(j);
        }
    }

    public static void d(String str) {
        if (a(1)) {
            a.setWorkDir(str);
        }
    }

    public static void e(String str) {
        if (a(1)) {
            a.pauseDownload(str);
        }
    }

    public static void f(String str) {
        if (a(1)) {
            a.cancelDownload(str);
        }
    }

    public static void g(String str) {
        if (a(1)) {
            a.deleteDownload(str);
        }
    }

    public static void a(long j) {
        if (a(1)) {
            a.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static void b(String str) {
        if (a(1)) {
            a.stopPrefetch(str);
        }
    }

    public static boolean c(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.h.a().a(str);
        if (a2 < 0) {
            if (!a(1)) {
                return false;
            }
            return a.hasCacheFile(str);
        } else if (a2 != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str, CyberPlayerManager.InstallListener2 installListener2) throws Exception {
        synchronized (f.class) {
            if (a == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(h, true, classLoader).newInstance();
                    a = cyberPlayerCoreProvider;
                    cyberPlayerCoreProvider.init(context, str);
                    a.setInstallListener(installListener2);
                    if (a != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, a.getLibsSearchPath());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    a = null;
                    throw e2;
                }
            }
        }
    }

    public static void a(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (q.o()) {
            e = onPrefetchListener;
            return;
        }
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.addPrefetchListener(onPrefetchListener);
        }
    }

    public static void b(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            a.enableRTCCaptureDebug(z);
        }
    }

    public static void a(CyberVideoDownloader.DownloadListener downloadListener) {
        if (a(1)) {
            a.setDownloadListener(downloadListener);
        }
    }

    public static void a(String str) {
        if (!com.baidu.cyberplayer.sdk.remote.h.a().b(str) && a(1)) {
            a.updatePlayerConfig(str);
        }
    }

    public static void a(String str, int i2, long j, String str2, PrefetchOptions prefetchOptions) {
        if (a(1)) {
            a.sendGlobalCommond(str, i2, j, str2, prefetchOptions);
        }
    }

    public static void a(String str, String str2) {
        if (a(1)) {
            a.setOption(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:3:0x0002, B:6:0x0026, B:8:0x002d, B:16:0x0058, B:18:0x0064, B:19:0x006b, B:12:0x0037, B:14:0x0040), top: B:22:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        try {
            if (!com.baidu.cyberplayer.sdk.remote.h.a().a(str, str2, str3, i2, i3, i4, str4, i5, i6, i7, i8, prefetchOptions, e) && a(1)) {
                if (TextUtils.isEmpty(str2)) {
                    str6 = "dumedia/7.39.94.57";
                } else if (str2.indexOf("dumedia") == -1) {
                    str6 = str2 + " dumedia/" + SDKVersion.VERSION;
                } else {
                    str5 = str2;
                    m();
                    n();
                    if (q.o()) {
                        a.addPrefetchListener(e);
                    }
                    a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
                }
                str5 = str6;
                m();
                n();
                if (q.o()) {
                }
                a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i2) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i2);
        }
        return false;
    }

    public static boolean a(int i2, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i2, map);
        }
        return a(i2);
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2) {
        if (a(1)) {
            a.duplayerEncrypt(bArr, i2, bArr2);
            return true;
        }
        return false;
    }
}
