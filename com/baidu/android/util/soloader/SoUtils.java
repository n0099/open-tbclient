package com.baidu.android.util.soloader;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.NoProGuard;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class SoUtils implements NoProGuard {
    public static final boolean DEBUG = false;
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String TAG = "SoUtils";
    public static SoUbcLoggable sUbcImpl;
    public static String[] uris = {"lib/armeabi", "lib/x86", "lib/mips"};

    /* loaded from: classes.dex */
    public static final class SOLOG {
        public static final String SO_LOAD_LIBRARY = "SO_LOAD_LIBRARY";
        public static final String SO_LOAD_TAG = "SO_LOAD_TAG";
        public static final String SO_NATIVE_LIB_LOAD = "SO_NATIVE_LIB_LOAD";
        public static final String SO_RELEASE_EXECUTE_LOAD = "SO_RELEASE_EXECUTE_LOAD";
        public static final String SO_RELEASE_LIB_LOAD = "SO_RELEASE_LIB_LOAD";
    }

    /* loaded from: classes.dex */
    public interface SoUbcLoggable {
        void onEvent(String str, String str2);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i2) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[i2 * 1024];
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
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static String getFullName(String str) {
        if (str.startsWith("lib") && str.endsWith(".so")) {
            return str;
        }
        return "lib" + str + ".so";
    }

    public static String getSimpleName(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String substring = (split == null || split.length != 2) ? str : split[0].substring(3);
            if (DEBUG) {
                Log.e("SoUtils", "SoUtils load but the param soName:" + str + ", name:" + substring);
            }
            return substring;
        }
        return str;
    }

    public static String getUriName(String str, int i2) {
        return uris[i2] + File.separator + str;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static void init(SoUbcLoggable soUbcLoggable) {
        sUbcImpl = soUbcLoggable;
    }

    public static void onEvent(String str, String str2) {
        SoUbcLoggable soUbcLoggable = sUbcImpl;
        if (soUbcLoggable != null) {
            soUbcLoggable.onEvent(str, str2);
        }
        if (DEBUG) {
            Log.d("SoUtils", "onEvent:UbcImpl=" + soUbcLoggable + ";eventId=" + str + ";content=" + str2);
        }
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void sendLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        onEvent(com.baidu.swan.apps.so.SoUtils.SO_EVENT_ID_DEFAULT, str);
    }
}
