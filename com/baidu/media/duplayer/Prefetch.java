package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
@Keep
/* loaded from: classes2.dex */
public class Prefetch {
    public static String TAG = "filecache-Prefetch";

    public static void add(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i4 = i3 < 30720 ? TbConfig.VOICE_CHUNK_UPLOAD_SIZE : i3 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i3;
        if (str == null || str.length() <= 0) {
            return;
        }
        String i5 = Utils.i();
        String str5 = i5 == null ? "" : i5;
        if (Utils.a() > Utils.f7955b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i, i2, i4, str4);
        }
    }

    public static void add(String str, String str2, String str3, int i, int i2, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i3 = i2 < 30720 ? TbConfig.VOICE_CHUNK_UPLOAD_SIZE : i2 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i2;
        if (str == null || str.length() <= 0) {
            return;
        }
        String i4 = Utils.i();
        String str5 = i4 == null ? "" : i4;
        if (Utils.a() > Utils.f7955b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i, 0, i3, str4);
        }
    }

    public static boolean hasCacheFile(String str) {
        return nativeHasCacheFile(str);
    }

    public static native void nativeAdd(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5);

    public static native boolean nativeHasCacheFile(String str);

    public static native void nativeStopPrefetch(String str);

    public static void stopPrefetch(String str) {
        nativeStopPrefetch(str);
    }
}
