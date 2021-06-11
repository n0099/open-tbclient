package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.media.playerconfig.PlayerConfigManagerInternal;
import com.baidu.tbadk.TbConfig;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class Prefetch {
    public static String TAG = "filecache-Prefetch";

    public static void add(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        String str5;
        int i9 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
        if (i4 >= 30720) {
            i9 = i4 > 6291456 ? TbConfig.THREAD_GIF_MIN_USE_MEMORY : i4;
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        String j = Utils.j();
        if (j == null) {
            str5 = "";
        } else {
            str5 = "http://" + j;
        }
        CyberLog.i(TAG, "adjustPrefetchPolicy call before url : " + str + " prefetchSize : " + i9);
        PlayerConfigManagerInternal.b adjustPrefetchPolicy = adjustPrefetchPolicy(str, i9, prefetchOptions);
        CyberLog.i(TAG, "adjustPrefetchPolicy call after url : " + adjustPrefetchPolicy.f8071b + " info.adjustSize : " + adjustPrefetchPolicy.f8070a);
        if (Utils.a() > Utils.f8038b) {
            nativeAdd(adjustPrefetchPolicy.f8071b, str2 != null ? str2 : "", str3 != null ? str3 : "", str5, i2, i3, adjustPrefetchPolicy.f8070a, str4, i5, i6, i7, i8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PlayerConfigManagerInternal.b adjustPrefetchPolicy(String str, int i2, PrefetchOptions prefetchOptions) {
        int i3;
        Map<String, String> options;
        int i4;
        String str2;
        PlayerConfigManagerInternal.b bVar = new PlayerConfigManagerInternal.b(str, i2);
        CyberLog.i(TAG, "adjustPrefetchPolicy call");
        int i5 = 0;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, false)) {
            return bVar;
        }
        CyberLog.i(TAG, "adjustPrefetchPolicy call use PlayerServer");
        if (prefetchOptions != null && (options = prefetchOptions.getOptions()) != null) {
            String str3 = options.get(CyberPlayerManager.OPT_VIDEO_BPS);
            if (str3 != null && !str3.isEmpty()) {
                try {
                    i4 = Integer.parseInt(str3);
                } catch (Exception unused) {
                }
                str2 = options.get(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE);
                if (str2 != null && !str2.isEmpty()) {
                    try {
                        i3 = Integer.parseInt(str2);
                        i5 = i4;
                    } catch (Exception unused2) {
                    }
                    String str4 = TAG;
                    CyberLog.i(str4, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
                    return i5 <= 0 ? bVar : bVar;
                }
                i5 = i4;
            }
            i4 = 0;
            str2 = options.get(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE);
            if (str2 != null) {
                i3 = Integer.parseInt(str2);
                i5 = i4;
                String str42 = TAG;
                CyberLog.i(str42, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
                return i5 <= 0 ? bVar : bVar;
            }
            i5 = i4;
        }
        i3 = 0;
        String str422 = TAG;
        CyberLog.i(str422, "adjustPrefetchPolicy call videoBps : " + i5 + " videoMoovSize : " + i3);
        if (i5 <= 0) {
        }
    }

    public static boolean hasCacheFile(String str) {
        return nativeHasCacheFile(str);
    }

    public static native void nativeAdd(String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5, int i5, int i6, int i7, int i8);

    public static native boolean nativeHasCacheFile(String str);

    public static native void nativeStopPrefetch(String str);

    public static void stopPrefetch(String str) {
        nativeStopPrefetch(str);
    }
}
