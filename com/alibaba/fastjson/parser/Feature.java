package com.alibaba.fastjson.parser;
/* loaded from: classes.dex */
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
    SupportAutoType,
    NonStringKeyAsString,
    CustomMapDeserializer,
    ErrorOnEnumNotMatch,
    SafeMode,
    TrimStringFieldValue;
    
    public final int mask = 1 << ordinal();

    Feature() {
    }

    public static int config(int i2, Feature feature, boolean z) {
        if (z) {
            return i2 | feature.mask;
        }
        return i2 & (~feature.mask);
    }

    public static boolean isEnabled(int i2, Feature feature) {
        return (i2 & feature.mask) != 0;
    }

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i2 = 0;
        for (Feature feature : featureArr) {
            i2 |= feature.mask;
        }
        return i2;
    }

    public final int getMask() {
        return this.mask;
    }
}
