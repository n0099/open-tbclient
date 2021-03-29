package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.res.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public final class f {
    public static String a(Context context) {
        Field[] fields;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            Configuration configuration = context.getResources().getConfiguration();
            for (Field field : configuration.getClass().getFields()) {
                try {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        sb.append(field.getName());
                        sb.append(": ");
                        sb.append(field.get(configuration));
                        sb.append('\n');
                    }
                } catch (IllegalAccessException e2) {
                    e = e2;
                    str = "Failed to inspect device configuration: " + configuration;
                    com.baidu.crabsdk.c.a.a(str, e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    str = "Failed to inspect device configuration: " + configuration;
                    com.baidu.crabsdk.c.a.a(str, e);
                }
            }
        } catch (RuntimeException e4) {
            com.baidu.crabsdk.c.a.a("getConfigInfo", e4);
        }
        return sb.toString();
    }
}
