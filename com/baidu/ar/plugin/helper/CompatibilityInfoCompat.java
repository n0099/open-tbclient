package com.baidu.ar.plugin.helper;

import com.baidu.ar.plugin.reflect.FieldUtils;
/* loaded from: classes.dex */
public class CompatibilityInfoCompat {
    public static Class sClass;
    public static Object sDefaultCompatibilityInfo;

    public static Object getDefaultCompatibilityInfo() {
        if (sDefaultCompatibilityInfo == null) {
            sDefaultCompatibilityInfo = FieldUtils.readStaticField(getMyClass(), "DEFAULT_COMPATIBILITY_INFO");
        }
        return sDefaultCompatibilityInfo;
    }

    public static Class getMyClass() {
        if (sClass == null) {
            sClass = Class.forName("android.content.res.CompatibilityInfo");
        }
        return sClass;
    }
}
