package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;
/* loaded from: classes2.dex */
public class EuiLeakFixUtils {
    public static int level;

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int emuiLevel() {
        int i2 = level;
        if (i2 > 0) {
            return i2;
        }
        Properties properties = new Properties();
        File file = new File(Environment.getRootDirectory(), "build.prop");
        FileInputStream fileInputStream = null;
        if (file.exists()) {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (properties.containsKey("ro.build.hw_emui_api_level")) {
                    }
                    return level;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (properties.containsKey("ro.build.hw_emui_api_level")) {
            try {
                level = Integer.parseInt(properties.getProperty("ro.build.hw_emui_api_level"));
            } catch (Exception unused5) {
            }
        }
        return level;
    }

    public static void fixLeakCanaryOnEui(Context context) {
        if (Build.VERSION.SDK_INT >= 24 && emuiLevel() != 0) {
            try {
                Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
                Field declaredField = cls.getDeclaredField("sGestureBoostManager");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("mContext");
                declaredField2.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj == null) {
                    return;
                }
                declaredField2.set(obj, context);
            } catch (Exception unused) {
            }
        }
    }
}
