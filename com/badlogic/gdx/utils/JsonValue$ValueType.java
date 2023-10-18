package com.badlogic.gdx.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class JsonValue$ValueType {
    public static final /* synthetic */ JsonValue$ValueType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JsonValue$ValueType array;
    public static final JsonValue$ValueType booleanValue;
    public static final JsonValue$ValueType doubleValue;
    public static final JsonValue$ValueType longValue;
    public static final JsonValue$ValueType nullValue;
    public static final JsonValue$ValueType object;
    public static final JsonValue$ValueType stringValue;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1367339623, "Lcom/badlogic/gdx/utils/JsonValue$ValueType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1367339623, "Lcom/badlogic/gdx/utils/JsonValue$ValueType;");
                return;
            }
        }
        object = new JsonValue$ValueType("object", 0);
        array = new JsonValue$ValueType("array", 1);
        stringValue = new JsonValue$ValueType("stringValue", 2);
        doubleValue = new JsonValue$ValueType("doubleValue", 3);
        longValue = new JsonValue$ValueType("longValue", 4);
        booleanValue = new JsonValue$ValueType("booleanValue", 5);
        JsonValue$ValueType jsonValue$ValueType = new JsonValue$ValueType("nullValue", 6);
        nullValue = jsonValue$ValueType;
        $VALUES = new JsonValue$ValueType[]{object, array, stringValue, doubleValue, longValue, booleanValue, jsonValue$ValueType};
    }

    public JsonValue$ValueType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static JsonValue$ValueType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (JsonValue$ValueType) Enum.valueOf(JsonValue$ValueType.class, str);
        }
        return (JsonValue$ValueType) invokeL.objValue;
    }

    public static JsonValue$ValueType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (JsonValue$ValueType[]) $VALUES.clone();
        }
        return (JsonValue$ValueType[]) invokeV.objValue;
    }
}
