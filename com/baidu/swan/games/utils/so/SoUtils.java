package com.baidu.swan.games.utils.so;

import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
@Keep
/* loaded from: classes9.dex */
public final class SoUtils {
    public static final String ARM64_V8A = "arm64-v8a";
    public static final String ARMEABI = "armeabi";
    private static final String EXT = ".so";
    private static final boolean LOGFLAG = true;
    private static final String PRE = "lib";
    public static final String SO_EVENT_ID_DEFAULT = "24";
    public static final String SO_EVENT_ID_NEW_SO = "25";
    private static final String TAG = "SoUtils";
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a sUbcImpl = new c();
    public static String[] uris = {"lib/armeabi", "lib/arm64-v8a"};

    /* loaded from: classes9.dex */
    public interface a {
        void onEvent(String str, String str2);
    }

    private SoUtils() {
    }

    public static void init(a aVar) {
        sUbcImpl = aVar;
    }

    public static void onEvent(String str, String str2) {
        a aVar = sUbcImpl;
        if (aVar != null) {
            aVar.onEvent(str, str2);
        }
        if (DEBUG) {
            Log.d(TAG, "onEvent:UbcImpl=" + aVar + ";eventId=" + str + ";content=" + str2);
        }
    }

    public static String getFullName(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return "lib" + str + ".so";
        }
        return str;
    }

    public static String getSimpleName(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
            String[] split = str.split("\\.");
            String substring = (split == null || split.length != 2) ? str : split[0].substring(3);
            if (DEBUG) {
                Log.e(TAG, "SoUtils load but the param soName:" + str + ", name:" + substring);
            }
            return substring;
        }
        return str;
    }

    public static void sendLog(String str) {
        if (!TextUtils.isEmpty(str)) {
            onEvent(SO_EVENT_ID_DEFAULT, str);
        }
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i) {
        if (inputStream == null || outputStream == null) {
            return 0L;
        }
        try {
            byte[] bArr = new byte[i * 1024];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    outputStream.flush();
                    return j;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static String getUriName(String str, int i) {
        return uris[i] + File.separator + str;
    }

    public static String getCurrentCpuAbi() {
        return ("arm64-v8a".equals(Build.CPU_ABI) || "arm64-v8a".equals(Build.CPU_ABI2)) ? "arm64-v8a" : "armeabi";
    }
}
