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
public class d {
    public static CyberPlayerCoreProvider a = null;
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static String d = "com.baidu.media.duplayer";
    public static final String e = d + ".CyberVRRenderProviderImpl";
    public static final String f = d + ".MediaInstanceManagerImpl";
    public static final String g = d + ".CyberPlayerCoreImpl";
    public static Class<?> h;

    public static int a(String str, int i, int i2, int i3, Map<String, String> map) {
        return a(1) ? a.getDevicePlayQualityScore(str, i, i2, i3, map) : i2 * i3 < 921600 ? 100 : -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        if (h == null) {
            try {
                h = Class.forName(e, false, context.getClassLoader());
            } catch (Exception e2) {
                e2.printStackTrace();
                h = null;
            }
        }
        Class<?> cls = h;
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

    public static PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return a.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        if (a(33)) {
            return a.createCaptureManager(context, i, i2, i3, i4, i5);
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
        return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
    }

    public static String a(String str, VideoSourceBean videoSourceBean) {
        return a(1) ? a.startDownload(str, videoSourceBean) : str;
    }

    public static Map<String, String> a(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        if (a(1)) {
            return a.getLibsVersion(libsVersionType);
        }
        return null;
    }

    public static void a(long j) {
        if (a(1)) {
            a.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str, CyberPlayerManager.InstallListener2 installListener2) throws Exception {
        synchronized (d.class) {
            if (a == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(g, true, classLoader).newInstance();
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

    public static void a(CyberVideoDownloader.DownloadListener downloadListener) {
        if (a(1)) {
            a.setDownloadListener(downloadListener);
        }
    }

    public static void a(String str) {
        if (!com.baidu.cyberplayer.sdk.remote.g.a().b(str) && a(1)) {
            a.updatePlayerConfig(str);
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.32.10.41";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                l();
                m();
                a.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4, i4, i5, i6, i7, prefetchOptions);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            l();
            m();
            a.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4, i4, i5, i6, i7, prefetchOptions);
        }
    }

    public static void a(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i);
        }
        return false;
    }

    public static boolean a(int i, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i, map);
        }
        return a(i);
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (a(1)) {
            a.duplayerEncrypt(bArr, i, bArr2);
            return true;
        }
        return false;
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return a.createCyberExtractor();
        }
        return null;
    }

    public static void b(long j) {
        if (a(1)) {
            a.updateStorageQuota(j);
        }
    }

    public static void b(String str) {
        if (a(1)) {
            a.stopPrefetch(str);
        }
    }

    public static void b(boolean z) {
        if (a(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            a.enableRTCCaptureDebug(z);
        }
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return a.createInstanceManager();
        }
        return null;
    }

    public static boolean c(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return a.createCyberAudioRecorder();
        }
        return null;
    }

    public static void d(String str) {
        if (a(1)) {
            a.setWorkDir(str);
        }
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return a.createRTCRoom();
        }
        return null;
    }

    public static void e(String str) {
        if (a(1)) {
            a.pauseDownload(str);
        }
    }

    public static DlnaProvider f() {
        if (a(1)) {
            return a.createDlna();
        }
        return null;
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

    public static boolean g() {
        return a != null;
    }

    public static void h() {
        if (a(1)) {
            a.updateCfg();
        }
    }

    public static long i() {
        if (a(1)) {
            return a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> j() {
        if (a(1)) {
            return a.getSystemInfraInfo();
        }
        return null;
    }

    public static boolean k() {
        if (a(1)) {
            return a.downgrade();
        }
        return false;
    }

    public static void l() {
        if (b || !a(1) || CyberPlayerManager.getNetHandleListener() == null) {
            return;
        }
        long longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
        if (longValue == 0 || a.kernelNetInit(longValue) != 0) {
            return;
        }
        b = true;
    }

    public static void m() {
        if (c || !a(1) || CyberPlayerManager.getNetHandleListener() == null) {
            return;
        }
        long longValue = CyberPlayerManager.getNetHandleListener().getPcdnNetHandle().longValue();
        if (longValue == 0 || a.pcdnNetInit(longValue) != 0) {
            return;
        }
        c = true;
    }
}
