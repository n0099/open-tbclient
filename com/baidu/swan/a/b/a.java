package com.baidu.swan.a.b;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.lang.reflect.Field;
/* loaded from: classes11.dex */
public class a {
    public static String avf() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        ApplicationInfo applicationInfo = AppRuntime.getAppContext().getApplicationInfo();
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return null;
        }
    }
}
