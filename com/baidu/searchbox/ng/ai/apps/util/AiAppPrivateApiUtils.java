package com.baidu.searchbox.ng.ai.apps.util;

import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class AiAppPrivateApiUtils {
    private static final int SDK_VERSION_P = 28;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            System.loadLibrary("private-p-master");
        }
    }

    public static void usePrivateApi() {
    }

    public static String getSystemProtertiesMethod(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
        declaredMethod.setAccessible(true);
        return (String) declaredMethod.invoke(null, str);
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
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
