package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static String a = null;
    private static CyberPlayerCoreProvider b = null;

    public static PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (a(1)) {
            return b.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static String a() {
        return b != null ? b.getInitError() : a;
    }

    public static void a(String str) {
        if (a(1)) {
            b.stopPrefetch(str);
        }
    }

    public static void a(String str, String str2, String str3, int i, int i2, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        if (!com.baidu.cyberplayer.sdk.remote.f.a().a(str, str2, str3, i, i2) && a(1)) {
            b.prefetch(str, TextUtils.isEmpty(str2) ? "dumedia/6.14.2.2" : str2.indexOf("dumedia") == -1 ? str2 + " dumedia/" + SDKVersion.VERSION : str2, str3, i, i2, httpDNS, str4);
        }
    }

    public static boolean a(int i) {
        if (b != null) {
            return b.isLoaded(i);
        }
        return false;
    }

    public static boolean a(Context context, ClassLoader classLoader, int i, Map<String, String> map) throws FileNotFoundException, ClassNotFoundException {
        if (!a(i)) {
            if (b == null) {
                try {
                    b = (CyberPlayerCoreProvider) Class.forName("com.baidu.media.duplayer.CyberPlayerCoreImpl", true, classLoader).newInstance();
                    a = null;
                } catch (ClassNotFoundException e) {
                    throw e;
                } catch (Exception e2) {
                    a = e2.toString();
                    b = null;
                }
            }
            if (b != null) {
                try {
                    b.init(context, i, map);
                } catch (FileNotFoundException e3) {
                    throw e3;
                }
            }
        }
        return a(i);
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        if (a(1)) {
            b.duplayerEncrypt(bArr, i, bArr2);
            return true;
        }
        return false;
    }

    public static String b() {
        return b != null ? b.getCoreVersion() : "";
    }

    public static boolean b(String str) {
        if (a(1)) {
            return b.hasCacheFile(str);
        }
        return false;
    }

    public static CyberAudioRecorder c() {
        if (a(5)) {
            return b.createCyberAudioRecorder();
        }
        return null;
    }

    public static void d() {
        if (a(1)) {
            b.forceCleanFilecache();
        }
    }

    public static boolean e() {
        return b != null;
    }

    public static void f() {
        if (a(1)) {
            b.updateCfg();
        }
    }

    public static long g() {
        if (a(1)) {
            return b.caculateFolderSize();
        }
        return 0L;
    }

    public static HashMap<Integer, Long> h() {
        if (a(1)) {
            return b.getSystemInfraInfo();
        }
        return null;
    }
}
