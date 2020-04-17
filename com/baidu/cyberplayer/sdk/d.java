package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static CyberPlayerCoreProvider a = null;
    private static String b = "com.baidu.media.duplayer";
    private static final String c = b + ".CyberVRRenderProviderImpl";
    private static final String d = b + ".CyberPlayerCoreImpl";
    private static Class<?> e;

    public static CyberVRRenderProvider a(Context context) {
        if (a == null || e == null) {
            return null;
        }
        try {
            return (CyberVRRenderProvider) e.getConstructor(Context.class).newInstance(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            CyberLog.e("CyberPlayerCoreInvoker", "create CyberVRRender failed");
            return null;
        }
    }

    public static PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return a.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static String a() {
        return a != null ? a.getCoreVersion() : "";
    }

    public static synchronized void a(Context context, ClassLoader classLoader, String str) throws Exception {
        synchronized (d.class) {
            if (a == null) {
                try {
                    a = (CyberPlayerCoreProvider) Class.forName(d, true, classLoader).newInstance();
                    a.init(context, str);
                    if (a != null) {
                        com.baidu.cyberplayer.sdk.b.a.a(classLoader, a.getLibsSearchPath());
                        try {
                            e = Class.forName(c, false, context.getClassLoader());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            e = null;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    a = null;
                    throw e3;
                }
            }
        }
    }

    public static void a(String str) {
        if (a(1)) {
            a.stopPrefetch(str);
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        if (!com.baidu.cyberplayer.sdk.remote.g.a().a(str, str2, str3, i, i2, i3) && a(1)) {
            a.prefetch(str, TextUtils.isEmpty(str2) ? "dumedia/7.7.2.14" : str2.indexOf("dumedia") == -1 ? str2 + " dumedia/" + SDKVersion.VERSION : str2, str3, i, i2, i3, httpDNS, str4);
        }
    }

    public static boolean a(int i) {
        if (a != null) {
            return a.isLoaded(i);
        }
        return false;
    }

    public static boolean a(int i, Map<String, String> map) throws FileNotFoundException {
        if (a != null) {
            a.loadlibs(i, map);
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

    public static boolean b(String str) {
        int a2 = com.baidu.cyberplayer.sdk.remote.g.a().a(str);
        if (a2 >= 0) {
            return a2 == 1;
        } else if (a(1)) {
            return a.hasCacheFile(str);
        } else {
            return false;
        }
    }

    public static CyberAudioRecorder c() {
        if (a(5)) {
            return a.createCyberAudioRecorder();
        }
        return null;
    }

    public static void d() {
        if (a(1)) {
            a.forceCleanFilecache();
        }
    }

    public static boolean e() {
        return a != null;
    }

    public static void f() {
        if (a(1)) {
            a.updateCfg();
        }
    }

    public static long g() {
        if (a(1)) {
            return a.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> h() {
        if (a(1)) {
            return a.getSystemInfraInfo();
        }
        return null;
    }
}
