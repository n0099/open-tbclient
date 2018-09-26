package cn.jiguang.g;

import android.content.Context;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
/* loaded from: classes3.dex */
public final class j {
    public static String a(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            return (String) loadClass.getMethod("get", String.class, String.class).invoke(loadClass, new String(str), new String(str2));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return str2;
        }
    }
}
