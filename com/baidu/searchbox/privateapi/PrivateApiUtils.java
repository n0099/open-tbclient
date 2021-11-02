package com.baidu.searchbox.privateapi;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class PrivateApiUtils implements NoProGuard {
    public static final String SDK_VERSION_NAME = "REL";
    public static final int SDK_VERSION_P = 28;
    public static final String SO_FILE_NAME = "libprivate-p-master.so";

    static {
        int i2 = Build.VERSION.SDK_INT;
        String str = Build.VERSION.CODENAME;
        if (i2 == 28 && !TextUtils.isEmpty(str) && SDK_VERSION_NAME.equals(str)) {
            SoLoader.load(AppRuntime.getAppContext(), SO_FILE_NAME);
        }
    }

    public static String getMiuiChannel(String str) {
        try {
            return (String) Class.forName("miui.os.MiuiInit").getMethod("getMiuiChannelPath", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static String getSystemProtertiesMethod(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
        declaredMethod.setAccessible(true);
        return (String) declaredMethod.invoke(null, str);
    }

    public static void usePrivateApi() {
    }
}
