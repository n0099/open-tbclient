package com.alibaba.fastjson.serializer;
/* loaded from: classes.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;
    
    public static final SerializerFeature[] EMPTY;
    public static final int WRITE_MAP_NULL_FEATURES;
    public final int mask = 1 << ordinal();

    static {
        SerializerFeature serializerFeature = WriteMapNullValue;
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | WriteNullBooleanAsFalse.getMask() | WriteNullListAsEmpty.getMask() | WriteNullNumberAsZero.getMask() | WriteNullStringAsEmpty.getMask();
    }

    SerializerFeature() {
    }

    public static int config(int i2, SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i2 | serializerFeature.mask;
        }
        return i2 & (~serializerFeature.mask);
    }

    public static boolean isEnabled(int i2, SerializerFeature serializerFeature) {
        return (i2 & serializerFeature.mask) != 0;
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i2 = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i2 |= serializerFeature.mask;
        }
        return i2;
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i2, int i3, SerializerFeature serializerFeature) {
        int i4 = serializerFeature.mask;
        return ((i2 & i4) == 0 && (i3 & i4) == 0) ? false : true;
    }
}
