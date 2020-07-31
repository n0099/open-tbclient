package com.baidu.searchbox.privateapi;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class PrivateApiUtils {
    private static final String SDK_VERSION_NAME = "REL";
    private static final int SDK_VERSION_P = 28;

    static {
        int i = Build.VERSION.SDK_INT;
        String str = Build.VERSION.CODENAME;
        if (i == 28 && !TextUtils.isEmpty(str) && SDK_VERSION_NAME.equals(str)) {
            System.loadLibrary("private-p-master");
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
