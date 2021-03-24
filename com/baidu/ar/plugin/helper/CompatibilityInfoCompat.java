package com.baidu.ar.plugin.helper;

import com.baidu.ar.plugin.reflect.FieldUtils;
/* loaded from: classes2.dex */
public class CompatibilityInfoCompat {
    public static Class sClass;
    public static Object sDefaultCompatibilityInfo;

    public static Object getDefaultCompatibilityInfo() throws IllegalAccessException, ClassNotFoundException {
        if (sDefaultCompatibilityInfo == null) {
            sDefaultCompatibilityInfo = FieldUtils.readStaticField(getMyClass(), "DEFAULT_COMPATIBILITY_INFO");
        }
        return sDefaultCompatibilityInfo;
    }

    public static Class getMyClass() throws ClassNotFoundException {
        if (sClass == null) {
            sClass = Class.forName("android.content.res.CompatibilityInfo");
        }
        return sClass;
    }
}
