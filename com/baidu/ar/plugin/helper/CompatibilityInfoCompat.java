package com.baidu.ar.plugin.helper;

import com.baidu.ar.plugin.reflect.FieldUtils;
/* loaded from: classes15.dex */
public class CompatibilityInfoCompat {
    private static Class sClass;
    private static Object sDefaultCompatibilityInfo;

    private static Class getMyClass() throws ClassNotFoundException {
        if (sClass == null) {
            sClass = Class.forName("android.content.res.CompatibilityInfo");
        }
        return sClass;
    }

    public static Object getDefaultCompatibilityInfo() throws IllegalAccessException, ClassNotFoundException {
        if (sDefaultCompatibilityInfo == null) {
            sDefaultCompatibilityInfo = FieldUtils.readStaticField(getMyClass(), "DEFAULT_COMPATIBILITY_INFO");
        }
        return sDefaultCompatibilityInfo;
    }
}
