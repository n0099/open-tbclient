package com.baidu.searchbox.privateapi;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class PrivateApiUtils implements NoProGuard {
    private static final String SDK_VERSION_NAME = "REL";
    private static final int SDK_VERSION_P = 28;
    private static final String SO_FILE_NAME = "libprivate-p-master.so";

    static {
        int i = Build.VERSION.SDK_INT;
        String str = Build.VERSION.CODENAME;
        if (i == 28 && !TextUtils.isEmpty(str) && SDK_VERSION_NAME.equals(str)) {
            SoLoader.load(AppRuntime.getAppContext(), SO_FILE_NAME);
        }
    }

    public static void usePrivateApi() {
    }

    public static String getSystemProtertiesMethod(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
        declaredMethod.setAccessible(true);
        return (String) declaredMethod.invoke(null, str);
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getMiuiChannel(String str) {
        try {
            return (String) Class.forName("miui.os.MiuiInit").getMethod("getMiuiChannelPath", String.class).invoke(null, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
