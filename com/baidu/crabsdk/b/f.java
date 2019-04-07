package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.res.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public final class f {
    public static String d(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        try {
            Configuration configuration = context.getResources().getConfiguration();
            for (Field field : configuration.getClass().getFields()) {
                try {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        sb.append(field.getName()).append(": ").append(field.get(configuration));
                        sb.append('\n');
                    }
                } catch (IllegalAccessException e) {
                    com.baidu.crabsdk.c.a.f("Failed to inspect device configuration: " + configuration, e);
                } catch (IllegalArgumentException e2) {
                    com.baidu.crabsdk.c.a.f("Failed to inspect device configuration: " + configuration, e2);
                }
            }
        } catch (RuntimeException e3) {
            com.baidu.crabsdk.c.a.f("getConfigInfo", e3);
        }
        return sb.toString();
    }
}
