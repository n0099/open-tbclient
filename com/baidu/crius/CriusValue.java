package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
@DoNotStrip
/* loaded from: classes6.dex */
public class CriusValue {
    public final CriusUnit unit;
    public final float value;
    static final CriusValue UNDEFINED = new CriusValue(Float.NaN, CriusUnit.UNDEFINED);
    static final CriusValue ZERO = new CriusValue(0.0f, CriusUnit.POINT);
    static final CriusValue AUTO = new CriusValue(Float.NaN, CriusUnit.AUTO);

    public CriusValue(float f, CriusUnit criusUnit) {
        this.value = f;
        this.unit = criusUnit;
    }

    @DoNotStrip
    CriusValue(float f, int i) {
        this(f, CriusUnit.fromInt(i));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CriusValue) {
            CriusValue criusValue = (CriusValue) obj;
            if (this.unit == criusValue.unit) {
                return this.unit == CriusUnit.UNDEFINED || Float.compare(this.value, criusValue.value) == 0;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.intValue();
    }

    public String toString() {
        switch (this.unit) {
            case UNDEFINED:
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            case POINT:
                return Float.toString(this.value);
            case PERCENT:
                return this.value + "%";
            case AUTO:
                return "auto";
            default:
                throw new IllegalStateException();
        }
    }

    public static CriusValue parse(String str) {
        if (str == null) {
            return null;
        }
        if (SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(str)) {
            return UNDEFINED;
        }
        if ("auto".equals(str)) {
            return AUTO;
        }
        if (str.endsWith("%")) {
            return new CriusValue(Float.parseFloat(str.substring(0, str.length() - 1)), CriusUnit.PERCENT);
        }
        return new CriusValue(Float.parseFloat(str), CriusUnit.POINT);
    }
}
