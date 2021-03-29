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
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static CyberPlayerCoreProvider f4911a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f4912b = "com.baidu.media.duplayer";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4913c = f4912b + ".CyberVRRenderProviderImpl";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4914d = f4912b + ".MediaInstanceManagerImpl";

    /* renamed from: e  reason: collision with root package name */
    public static final String f4915e = f4912b + ".CyberPlayerCoreImpl";

    /* renamed from: f  reason: collision with root package name */
    public static Class<?> f4916f;

    public static int a(String str, int i, int i2, int i3, Map<String, String> map) {
        if (a(1)) {
            return f4911a.getDevicePlayQualityScore(str, i, i2, i3, map);
        }
        return -1;
    }

    public static CyberVRRenderProvider a(Context context) {
        Class<?> cls;
        if (f4911a == null || (cls = f4916f) == null) {
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

    public static PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return f4911a.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static CaptureManagerProvider a(Context context, int i, int i2, int i3, int i4, int i5) {
        if (a(33)) {
            return f4911a.createCaptureManager(context, i, i2, i3, i4, i5);
        }
        return null;
    }

    public static RTCVideoViewProvider a(Context context, AttributeSet attributeSet) {
        if (a(33)) {
            return f4911a.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static String a() {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4911a;
        return cyberPlayerCoreProvider != null ? cyberPlayerCoreProvider.getCoreVersion() : "";
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        synchronized (d.class) {
            if (f4911a == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(f4915e, true, classLoader).newInstance();
                    f4911a = cyberPlayerCoreProvider;
                    cyberPlayerCoreProvider.init(context, str);
                    if (f4911a != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, f4911a.getLibsSearchPath());
                        try {
                            f4916f = Class.forName(f4913c, false, context.getClassLoader());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            f4916f = null;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    f4911a = null;
                    throw e3;
                }
            }
        }
    }

    public static void a(String str) {
        if (a(1)) {
            f4911a.stopPrefetch(str);
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        String str5;
        String str6;
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i, i2, i3) && a(1)) {
            if (TextUtils.isEmpty(str2)) {
                str6 = "dumedia/7.12.2.56";
            } else if (str2.indexOf("dumedia") != -1) {
                str5 = str2;
                f4911a.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4);
            } else {
                str6 = str2 + " dumedia/" + SDKVersion.VERSION;
            }
            str5 = str6;
            f4911a.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4);
        }
    }

    public static void a(boolean z) {
        if (a(33)) {
            f4911a.setRTCVerbose(z);
        }
    }

    public static boolean a(int i) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4911a;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i);
        }
        return false;
    }

    public static boolean a(int i, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = f4911a;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i, map);
        }
        return a(i);
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (a(1)) {
            f4911a.duplayerEncrypt(bArr, i, bArr2);
            return true;
        }
        return false;
    }

    public static ExtractorProvider b() {
        if (a(1)) {
            return f4911a.createCyberExtractor();
        }
        return null;
    }

    public static void b(boolean z) {
        if (a(33)) {
            f4911a.enableRTCCaptureDebug(z);
        }
    }

    public static boolean b(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return f4911a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static MediaInstanceManagerProvider c() {
        if (a(1)) {
            return f4911a.createInstanceManager();
        }
        return null;
    }

    public static CyberAudioRecorder d() {
        if (a(5)) {
            return f4911a.createCyberAudioRecorder();
        }
        return null;
    }

    public static RTCRoomProvider e() {
        if (a(33)) {
            return f4911a.createRTCRoom();
        }
        return null;
    }

    public static void f() {
        if (a(1)) {
            f4911a.forceCleanFilecache();
        }
    }

    public static boolean g() {
        return f4911a != null;
    }

    public static void h() {
        if (a(1)) {
            f4911a.updateCfg();
        }
    }

    public static long i() {
        if (a(1)) {
            return f4911a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> j() {
        if (a(1)) {
            return f4911a.getSystemInfraInfo();
        }
        return null;
    }
}
