package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static CyberPlayerCoreProvider f1803a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f1804b = "com.baidu.media.duplayer";
    private static final String c = f1804b + ".CyberVRRenderProviderImpl";
    private static final String d = f1804b + ".MediaInstanceManagerImpl";
    private static final String e = f1804b + ".CyberPlayerCoreImpl";
    private static Class<?> f;

    public static int a(String str, int i, int i2, int i3, Map<String, String> map) {
        if (a(1)) {
            return f1803a.getDevicePlayQualityScore(str, i, i2, i3, map);
        }
        return -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        if (f1803a == null || f == null) {
            return null;
        }
        try {
            return (CyberVRRenderProvider) f.getConstructor(Context.class).newInstance(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            CyberLog.e("CyberPlayerCoreInvoker", "create CyberVRRender failed");
            return null;
        }
    }

    public static PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return f1803a.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        if (a(33)) {
            return f1803a.createCaptureManager(context, i, i2, i3, i4, i5);
        }
        return null;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        if (a(33)) {
            return f1803a.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static String a() {
        return f1803a != null ? f1803a.getCoreVersion() : "";
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        synchronized (d.class) {
            if (f1803a == null) {
                try {
                    f1803a = (CyberPlayerCoreProvider) Class.forName(e, true, classLoader).newInstance();
                    f1803a.init(context, str);
                    if (f1803a != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, f1803a.getLibsSearchPath());
                        try {
                            f = Class.forName(c, false, context.getClassLoader());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            f = null;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    f1803a = null;
                    throw e3;
                }
            }
        }
    }

    public static void a(String str) {
        if (a(1)) {
            f1803a.stopPrefetch(str);
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i, i2, i3) && a(1)) {
            f1803a.prefetch(str, TextUtils.isEmpty(str2) ? "dumedia/7.12.2.49" : str2.indexOf("dumedia") == -1 ? str2 + " dumedia/" + SDKVersion.VERSION : str2, str3, i, i2, i3, httpDNS, str4);
        }
    }

    public static void a(boolean z) {
        if (a(33)) {
            f1803a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i) {
        if (f1803a != null) {
            return f1803a.isLoaded(i);
        }
        return false;
    }

    public static boolean a(int i, Map<String, String> map) throws FileNotFoundException {
        if (f1803a != null) {
            f1803a.loadlibs(i, map);
        }
        return a(i);
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (a(1)) {
            f1803a.duplayerEncrypt(bArr, i, bArr2);
            return true;
        }
        return false;
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return f1803a.createCyberExtractor();
        }
        return null;
    }

    public static void b(boolean z) {
        if (a(33)) {
            f1803a.enableRTCCaptureDebug(z);
        }
    }

    public static boolean b(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return f1803a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return f1803a.createInstanceManager();
        }
        return null;
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return f1803a.createCyberAudioRecorder();
        }
        return null;
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return f1803a.createRTCRoom();
        }
        return null;
    }

    public static void f() {
        if (a(1)) {
            f1803a.forceCleanFilecache();
        }
    }

    public static boolean g() {
        return f1803a != null;
    }

    public static void h() {
        if (a(1)) {
            f1803a.updateCfg();
        }
    }

    public static long i() {
        if (a(1)) {
            return f1803a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> j() {
        if (a(1)) {
            return f1803a.getSystemInfraInfo();
        }
        return null;
    }
}
