package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
@Keep
/* loaded from: classes2.dex */
public class Prefetch {
    public static String TAG = "filecache-Prefetch";

    public static void add(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i5 = i4 < 30720 ? TbConfig.VOICE_CHUNK_UPLOAD_SIZE : i4 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i4;
        if (str == null || str.length() <= 0) {
            return;
        }
        String i6 = Utils.i();
        String str5 = i6 == null ? "" : i6;
        if (Utils.a() > Utils.f8281b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i2, i3, i5, str4);
        }
    }

    public static void add(String str, String str2, String str3, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        int i4 = i3 < 30720 ? TbConfig.VOICE_CHUNK_UPLOAD_SIZE : i3 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i3;
        if (str == null || str.length() <= 0) {
            return;
        }
        String i5 = Utils.i();
        String str5 = i5 == null ? "" : i5;
        if (Utils.a() > Utils.f8281b) {
            nativeAdd(str, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i2, 0, i4, str4);
        }
    }

    public static boolean hasCacheFile(String str) {
        return nativeHasCacheFile(str);
    }

    public static native void nativeAdd(String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5);

    public static native boolean nativeHasCacheFile(String str);

    public static native void nativeStopPrefetch(String str);

    public static void stopPrefetch(String str) {
        nativeStopPrefetch(str);
    }
}
