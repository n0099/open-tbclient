package com.alibaba.fastjson.parser;

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
public final class Feature {
    public static final /* synthetic */ Feature[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Feature AllowArbitraryCommas;
    public static final Feature AllowComment;
    public static final Feature AllowISO8601DateFormat;
    public static final Feature AllowSingleQuotes;
    public static final Feature AllowUnQuotedFieldNames;
    public static final Feature AutoCloseSource;
    public static final Feature CustomMapDeserializer;
    public static final Feature DisableASM;
    public static final Feature DisableCircularReferenceDetect;
    public static final Feature DisableFieldSmartMatch;
    public static final Feature DisableSpecialKeyDetect;
    public static final Feature ErrorOnEnumNotMatch;
    public static final Feature IgnoreAutoType;
    public static final Feature IgnoreNotMatch;
    public static final Feature InitStringFieldAsEmpty;
    public static final Feature InternFieldNames;
    public static final Feature NonStringKeyAsString;
    public static final Feature OrderedField;
    public static final Feature SafeMode;
    public static final Feature SortFeidFastMatch;
    public static final Feature SupportArrayToBean;
    public static final Feature SupportAutoType;
    public static final Feature SupportNonPublicField;
    public static final Feature TrimStringFieldValue;
    public static final Feature UseBigDecimal;
    public static final Feature UseObjectArray;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mask;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1253199945, "Lcom/alibaba/fastjson/parser/Feature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1253199945, "Lcom/alibaba/fastjson/parser/Feature;");
                return;
            }
        }
        AutoCloseSource = new Feature("AutoCloseSource", 0);
        AllowComment = new Feature("AllowComment", 1);
        AllowUnQuotedFieldNames = new Feature("AllowUnQuotedFieldNames", 2);
        AllowSingleQuotes = new Feature("AllowSingleQuotes", 3);
        InternFieldNames = new Feature("InternFieldNames", 4);
        AllowISO8601DateFormat = new Feature("AllowISO8601DateFormat", 5);
        AllowArbitraryCommas = new Feature("AllowArbitraryCommas", 6);
        UseBigDecimal = new Feature("UseBigDecimal", 7);
        IgnoreNotMatch = new Feature("IgnoreNotMatch", 8);
        SortFeidFastMatch = new Feature("SortFeidFastMatch", 9);
        DisableASM = new Feature("DisableASM", 10);
        DisableCircularReferenceDetect = new Feature("DisableCircularReferenceDetect", 11);
        InitStringFieldAsEmpty = new Feature("InitStringFieldAsEmpty", 12);
        SupportArrayToBean = new Feature("SupportArrayToBean", 13);
        OrderedField = new Feature("OrderedField", 14);
        DisableSpecialKeyDetect = new Feature("DisableSpecialKeyDetect", 15);
        UseObjectArray = new Feature("UseObjectArray", 16);
        SupportNonPublicField = new Feature("SupportNonPublicField", 17);
        IgnoreAutoType = new Feature("IgnoreAutoType", 18);
        DisableFieldSmartMatch = new Feature("DisableFieldSmartMatch", 19);
        SupportAutoType = new Feature("SupportAutoType", 20);
        NonStringKeyAsString = new Feature("NonStringKeyAsString", 21);
        CustomMapDeserializer = new Feature("CustomMapDeserializer", 22);
        ErrorOnEnumNotMatch = new Feature("ErrorOnEnumNotMatch", 23);
        SafeMode = new Feature("SafeMode", 24);
        Feature feature = new Feature("TrimStringFieldValue", 25);
        TrimStringFieldValue = feature;
        $VALUES = new Feature[]{AutoCloseSource, AllowComment, AllowUnQuotedFieldNames, AllowSingleQuotes, InternFieldNames, AllowISO8601DateFormat, AllowArbitraryCommas, UseBigDecimal, IgnoreNotMatch, SortFeidFastMatch, DisableASM, DisableCircularReferenceDetect, InitStringFieldAsEmpty, SupportArrayToBean, OrderedField, DisableSpecialKeyDetect, UseObjectArray, SupportNonPublicField, IgnoreAutoType, DisableFieldSmartMatch, SupportAutoType, NonStringKeyAsString, CustomMapDeserializer, ErrorOnEnumNotMatch, SafeMode, feature};
    }

    public Feature(String str, int i2) {
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

    public static int config(int i2, Feature feature, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), feature, Boolean.valueOf(z)})) == null) {
            if (z) {
                return i2 | feature.mask;
            }
            return i2 & (~feature.mask);
        }
        return invokeCommon.intValue;
    }

    public static boolean isEnabled(int i2, Feature feature) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, feature)) == null) ? (i2 & feature.mask) != 0 : invokeIL.booleanValue;
    }

    public static int of(Feature[] featureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, featureArr)) == null) {
            if (featureArr == null) {
                return 0;
            }
            int i2 = 0;
            for (Feature feature : featureArr) {
                i2 |= feature.mask;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static Feature valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (Feature) Enum.valueOf(Feature.class, str) : (Feature) invokeL.objValue;
    }

    public static Feature[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (Feature[]) $VALUES.clone() : (Feature[]) invokeV.objValue;
    }

    public final int getMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mask : invokeV.intValue;
    }
}
