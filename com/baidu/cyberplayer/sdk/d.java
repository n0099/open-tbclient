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
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static CyberPlayerCoreProvider f5068a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f5069b = "com.baidu.media.duplayer";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5070c = f5069b + ".CyberVRRenderProviderImpl";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5071d = f5069b + ".MediaInstanceManagerImpl";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5072e = f5069b + ".CyberPlayerCoreImpl";

    /* renamed from: f  reason: collision with root package name */
    public static Class<?> f5073f;

    public static int a(String str, int i2, int i3, int i4, Map<String, String> map) {
        if (a(1)) {
            return f5068a.getDevicePlayQualityScore(str, i2, i3, i4, map);
        }
        return -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        Class<?> cls;
        if (f5068a == null || (cls = f5073f) == null) {
            return null;
        }
        try {
            return (CyberVRRenderProvider) cls.getConstructor(Context.class).newInstance(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            CyberLog.e("CyberPlayerCoreInvoker", "create CyberVRRender failed");
            return null;
        }
    }

    public static PlayerProvider a(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return f5068a.createCyberPlayer(i2, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i2, int i3, int i4, int i5, int i6) {
        if (a(33)) {
            return f5068a.createCaptureManager(context, i2, i3, i4, i5, i6);
        }
        return null;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        if (a(33)) {
            return f5068a.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static String a() {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f5068a;
        return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        synchronized (d.class) {
            if (f5068a == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(f5072e, true, classLoader).newInstance();
                    f5068a = cyberPlayerCoreProvider;
                    cyberPlayerCoreProvider.init(context, str);
                    if (f5068a != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, f5068a.getLibsSearchPath());
                        try {
                            f5073f = Class.forName(f5070c, false, context.getClassLoader());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            f5073f = null;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    f5068a = null;
                    throw e3;
                }
            }
        }
    }

    public static void a(String str) {
        if (a(1)) {
            f5068a.stopPrefetch(str);
        }
    }

    public static void a(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        String str5;
        String str6;
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i2, i3, i4) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.12.2.56";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                f5068a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            f5068a.prefetch(str, str5, str3, i2, i3, i4, httpDNS, str4);
        }
    }

    public static void a(boolean z) {
        if (a(33)) {
            f5068a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i2) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f5068a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i2);
        }
        return false;
    }

    public static boolean a(int i2, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f5068a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i2, map);
        }
        return a(i2);
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2) {
        if (a(1)) {
            f5068a.duplayerEncrypt(bArr, i2, bArr2);
            return true;
        }
        return false;
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return f5068a.createCyberExtractor();
        }
        return null;
    }

    public static void b(boolean z) {
        if (a(33)) {
            f5068a.enableRTCCaptureDebug(z);
        }
    }

    public static boolean b(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return f5068a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return f5068a.createInstanceManager();
        }
        return null;
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return f5068a.createCyberAudioRecorder();
        }
        return null;
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return f5068a.createRTCRoom();
        }
        return null;
    }

    public static void f() {
        if (a(1)) {
            f5068a.forceCleanFilecache();
        }
    }

    public static boolean g() {
        return f5068a != null;
    }

    public static void h() {
        if (a(1)) {
            f5068a.updateCfg();
        }
    }

    public static long i() {
        if (a(1)) {
            return f5068a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> j() {
        if (a(1)) {
            return f5068a.getSystemInfraInfo();
        }
        return null;
    }
}
