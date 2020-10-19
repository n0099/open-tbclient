package com.alibaba.fastjson.parser;
/* loaded from: classes5.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch,
    SupportAutoType;
    
    public final int mask = 1 << ordinal();

    Feature() {
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (feature.mask & i) != 0;
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return feature.mask | i;
        }
        return (feature.mask ^ (-1)) & i;
    }

    public static int of(Feature[] featureArr) {
        int i = 0;
        if (featureArr != null) {
            int length = featureArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = featureArr[i2].mask | i;
                i2++;
                i = i3;
            }
        }
        return i;
    }
}
