package com.baidu.frontia;

import android.content.Context;
import com.baidu.frontia.framework.IModule;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class a {
    a() {
    }

    public static void a(Context context, String str) {
        Class<?> cls;
        Method method;
        IModule iModule;
        int i = 0;
        try {
            String[] a = a();
            if (a == null) {
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 >= a.length) {
                    return;
                }
                String str2 = a[i2];
                if (str2 != null && str2.length() > 0 && (cls = Class.forName(str2)) != null && (method = cls.getMethod("newInstance", Context.class)) != null && (iModule = (IModule) method.invoke(null, context)) != null) {
                    iModule.init(str);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }

    public static String[] a() {
        return new String[]{"com.baidu.frontia.api.FrontiaPush"};
    }
}
