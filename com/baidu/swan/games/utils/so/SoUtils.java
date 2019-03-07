package com.baidu.swan.games.utils.so;

import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
@Keep
/* loaded from: classes2.dex */
public final class SoUtils {
    private static final String EXT = ".so";
    private static final boolean LOGFLAG = true;
    private static final String PRE = "lib";
    private static final String TAG = "SoUtils";
    private static a sUbcImpl;
    public static final boolean DEBUG = c.DEBUG;
    public static String[] uris = {"lib/armeabi", "lib/x86", "lib/mips"};

    /* loaded from: classes2.dex */
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
            onEvent("24", str);
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
}
