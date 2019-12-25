package com.baidu.crius;
/* loaded from: classes10.dex */
public class CriusConstants {
    public static final float UNDEFINED = Float.NaN;

    public static boolean isUndefined(float f) {
        return Float.compare(f, Float.NaN) == 0;
    }

    public static boolean isUndefined(CriusValue criusValue) {
        return criusValue.unit == CriusUnit.UNDEFINED;
    }
}
