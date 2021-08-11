package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class SerializerFeature {
    public static final /* synthetic */ SerializerFeature[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SerializerFeature BeanToArray;
    public static final SerializerFeature BrowserCompatible;
    public static final SerializerFeature BrowserSecure;
    public static final SerializerFeature DisableCheckSpecialChar;
    public static final SerializerFeature DisableCircularReferenceDetect;
    public static final SerializerFeature[] EMPTY;
    public static final SerializerFeature IgnoreErrorGetter;
    public static final SerializerFeature IgnoreNonFieldGetter;
    public static final SerializerFeature MapSortField;
    public static final SerializerFeature NotWriteDefaultValue;
    public static final SerializerFeature NotWriteRootClassName;
    public static final SerializerFeature PrettyFormat;
    public static final SerializerFeature QuoteFieldNames;
    public static final SerializerFeature SkipTransientField;
    public static final SerializerFeature SortField;
    public static final SerializerFeature UseISO8601DateFormat;
    public static final SerializerFeature UseSingleQuotes;
    public static final int WRITE_MAP_NULL_FEATURES;
    public static final SerializerFeature WriteBigDecimalAsPlain;
    public static final SerializerFeature WriteClassName;
    public static final SerializerFeature WriteDateUseDateFormat;
    public static final SerializerFeature WriteEnumUsingName;
    public static final SerializerFeature WriteEnumUsingToString;
    public static final SerializerFeature WriteMapNullValue;
    public static final SerializerFeature WriteNonStringKeyAsString;
    public static final SerializerFeature WriteNonStringValueAsString;
    public static final SerializerFeature WriteNullBooleanAsFalse;
    public static final SerializerFeature WriteNullListAsEmpty;
    public static final SerializerFeature WriteNullNumberAsZero;
    public static final SerializerFeature WriteNullStringAsEmpty;
    public static final SerializerFeature WriteSlashAsSpecial;
    @Deprecated
    public static final SerializerFeature WriteTabAsSpecial;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mask;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2116514710, "Lcom/alibaba/fastjson/serializer/SerializerFeature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2116514710, "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
                return;
            }
        }
        QuoteFieldNames = new SerializerFeature("QuoteFieldNames", 0);
        UseSingleQuotes = new SerializerFeature("UseSingleQuotes", 1);
        WriteMapNullValue = new SerializerFeature("WriteMapNullValue", 2);
        WriteEnumUsingToString = new SerializerFeature("WriteEnumUsingToString", 3);
        WriteEnumUsingName = new SerializerFeature("WriteEnumUsingName", 4);
        UseISO8601DateFormat = new SerializerFeature("UseISO8601DateFormat", 5);
        WriteNullListAsEmpty = new SerializerFeature("WriteNullListAsEmpty", 6);
        WriteNullStringAsEmpty = new SerializerFeature("WriteNullStringAsEmpty", 7);
        WriteNullNumberAsZero = new SerializerFeature("WriteNullNumberAsZero", 8);
        WriteNullBooleanAsFalse = new SerializerFeature("WriteNullBooleanAsFalse", 9);
        SkipTransientField = new SerializerFeature("SkipTransientField", 10);
        SortField = new SerializerFeature("SortField", 11);
        WriteTabAsSpecial = new SerializerFeature("WriteTabAsSpecial", 12);
        PrettyFormat = new SerializerFeature("PrettyFormat", 13);
        WriteClassName = new SerializerFeature("WriteClassName", 14);
        DisableCircularReferenceDetect = new SerializerFeature("DisableCircularReferenceDetect", 15);
        WriteSlashAsSpecial = new SerializerFeature("WriteSlashAsSpecial", 16);
        BrowserCompatible = new SerializerFeature("BrowserCompatible", 17);
        WriteDateUseDateFormat = new SerializerFeature("WriteDateUseDateFormat", 18);
        NotWriteRootClassName = new SerializerFeature("NotWriteRootClassName", 19);
        DisableCheckSpecialChar = new SerializerFeature("DisableCheckSpecialChar", 20);
        BeanToArray = new SerializerFeature("BeanToArray", 21);
        WriteNonStringKeyAsString = new SerializerFeature("WriteNonStringKeyAsString", 22);
        NotWriteDefaultValue = new SerializerFeature("NotWriteDefaultValue", 23);
        BrowserSecure = new SerializerFeature("BrowserSecure", 24);
        IgnoreNonFieldGetter = new SerializerFeature("IgnoreNonFieldGetter", 25);
        WriteNonStringValueAsString = new SerializerFeature("WriteNonStringValueAsString", 26);
        IgnoreErrorGetter = new SerializerFeature("IgnoreErrorGetter", 27);
        WriteBigDecimalAsPlain = new SerializerFeature("WriteBigDecimalAsPlain", 28);
        SerializerFeature serializerFeature = new SerializerFeature("MapSortField", 29);
        MapSortField = serializerFeature;
        SerializerFeature serializerFeature2 = WriteMapNullValue;
        $VALUES = new SerializerFeature[]{QuoteFieldNames, UseSingleQuotes, serializerFeature2, WriteEnumUsingToString, WriteEnumUsingName, UseISO8601DateFormat, WriteNullListAsEmpty, WriteNullStringAsEmpty, WriteNullNumberAsZero, WriteNullBooleanAsFalse, SkipTransientField, SortField, WriteTabAsSpecial, PrettyFormat, WriteClassName, DisableCircularReferenceDetect, WriteSlashAsSpecial, BrowserCompatible, WriteDateUseDateFormat, NotWriteRootClassName, DisableCheckSpecialChar, BeanToArray, WriteNonStringKeyAsString, NotWriteDefaultValue, BrowserSecure, IgnoreNonFieldGetter, WriteNonStringValueAsString, IgnoreErrorGetter, WriteBigDecimalAsPlain, serializerFeature};
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature2.getMask() | WriteNullBooleanAsFalse.getMask() | WriteNullListAsEmpty.getMask() | WriteNullNumberAsZero.getMask() | WriteNullStringAsEmpty.getMask();
    }

    public SerializerFeature(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mask = 1 << ordinal();
    }

    public static int config(int i2, SerializerFeature serializerFeature, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), serializerFeature, Boolean.valueOf(z)})) == null) {
            if (z) {
                return i2 | serializerFeature.mask;
            }
            return i2 & (~serializerFeature.mask);
        }
        return invokeCommon.intValue;
    }

    public static boolean isEnabled(int i2, SerializerFeature serializerFeature) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, serializerFeature)) == null) ? (i2 & serializerFeature.mask) != 0 : invokeIL.booleanValue;
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, serializerFeatureArr)) == null) {
            if (serializerFeatureArr == null) {
                return 0;
            }
            int i2 = 0;
            for (SerializerFeature serializerFeature : serializerFeatureArr) {
                i2 |= serializerFeature.mask;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static SerializerFeature valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (SerializerFeature) Enum.valueOf(SerializerFeature.class, str) : (SerializerFeature) invokeL.objValue;
    }

    public static SerializerFeature[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (SerializerFeature[]) $VALUES.clone() : (SerializerFeature[]) invokeV.objValue;
    }

    public final int getMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mask : invokeV.intValue;
    }

    public static boolean isEnabled(int i2, int i3, SerializerFeature serializerFeature) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, serializerFeature)) == null) {
            int i4 = serializerFeature.mask;
            return ((i2 & i4) == 0 && (i3 & i4) == 0) ? false : true;
        }
        return invokeIIL.booleanValue;
    }
}
