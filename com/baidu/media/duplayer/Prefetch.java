package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
@Keep
/* loaded from: classes.dex */
public class Prefetch {
    public static String TAG = "filecache-Prefetch";

    public static void add(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i4 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
        if (i3 >= 30720) {
            i4 = i3 > 6291456 ? 6291456 : i3;
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        String b = Utils.b();
        if (b == null) {
            b = "";
        }
        if (Utils.a() > Utils.b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", b, i, i2, i4, str4);
        }
    }

    public static void add(String str, String str2, String str3, int i, int i2, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i3 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
        if (i2 >= 30720) {
            i3 = i2 > 6291456 ? 6291456 : i2;
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        String b = Utils.b();
        if (b == null) {
            b = "";
        }
        if (Utils.a() > Utils.b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", b, i, 0, i3, str4);
        }
    }

    public static boolean hasCacheFile(String str) {
        return nativeHasCacheFile(str);
    }

    private static native void nativeAdd(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5);

    private static native boolean nativeHasCacheFile(String str);

    private static native void nativeStopPrefetch(String str);

    public static void stopPrefetch(String str) {
        nativeStopPrefetch(str);
    }
}
