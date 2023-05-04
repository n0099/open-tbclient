package com.baidu.swan.apps.so;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tieba.ho1;
import com.baidu.tieba.pd3;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public final class SoUtils {
    public static final String ARM64_V8A = "arm64-v8a";
    public static final String ARMEABI = "armeabi";
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String SO_EVENT_ID_DEFAULT = "24";
    public static final String SO_EVENT_ID_NEW_SO = "25";
    public static final String SO_EVENT_ID_V8_SO = "26";
    public static final String TAG = "SoUtils";
    public static final boolean DEBUG = ho1.a;
    public static a sUbcImpl = new pd3();
    public static String[] uris = {"lib/armeabi", "lib/arm64-v8a"};

    /* loaded from: classes3.dex */
    public interface a {
        void onEvent(String str, String str2);
    }

    public static String getCurrentCpuAbi() {
        if ("arm64-v8a".equals(Build.CPU_ABI) || "arm64-v8a".equals(Build.CPU_ABI2)) {
            return "arm64-v8a";
        }
        return "armeabi";
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean hasGingerbread() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        return false;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i) {
        if (inputStream != null && outputStream != null) {
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
            }
        }
        return 0L;
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
    }

    public static String getFullName(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return "lib" + str + ".so";
        }
        return str;
    }

    public static void init(a aVar) {
        sUbcImpl = aVar;
    }

    public static void sendLog(String str) {
        if (!TextUtils.isEmpty(str)) {
            onEvent("24", str);
        }
    }

    public static String getSimpleName(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so")) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split != null && split.length == 2) {
                str2 = split[0].substring(3);
            } else {
                str2 = str;
            }
            if (DEBUG) {
                Log.e("SoUtils", "SoUtils load but the param soName:" + str + ", name:" + str2);
            }
            return str2;
        }
        return str;
    }

    public static String getUriName(String str, int i) {
        return uris[i] + File.separator + str;
    }

    public static void onEvent(String str, String str2) {
        a aVar = sUbcImpl;
        if (aVar != null) {
            aVar.onEvent(str, str2);
        }
        if (DEBUG) {
            Log.d("SoUtils", "onEvent:UbcImpl=" + aVar + ";eventId=" + str + ";content=" + str2);
        }
    }
}
