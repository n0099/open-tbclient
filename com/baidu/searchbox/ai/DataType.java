package com.baidu.searchbox.ai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class DataType {
    public static final /* synthetic */ DataType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DataType BOOL;
    public static final DataType DOUBLE;
    public static final DataType FLOAT;
    public static final DataType INT32;
    public static final DataType INT64;
    public static final DataType STRING;
    public static final DataType UINT8;
    public static HashMap<Class<?>, DataType> classDataTypes;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-902528662, "Lcom/baidu/searchbox/ai/DataType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-902528662, "Lcom/baidu/searchbox/ai/DataType;");
                return;
            }
        }
        FLOAT = new DataType("FLOAT", 0, 1);
        DOUBLE = new DataType("DOUBLE", 1, 2);
        INT32 = new DataType("INT32", 2, 3);
        INT64 = new DataType("INT64", 3, 4);
        UINT8 = new DataType("UINT8", 4, 5);
        STRING = new DataType("STRING", 5, 6);
        DataType dataType = new DataType("BOOL", 6, 7);
        BOOL = dataType;
        $VALUES = new DataType[]{FLOAT, DOUBLE, INT32, INT64, UINT8, STRING, dataType};
        HashMap<Class<?>, DataType> hashMap = new HashMap<>();
        classDataTypes = hashMap;
        hashMap.put(Integer.TYPE, INT32);
        classDataTypes.put(Integer.class, INT32);
        classDataTypes.put(Long.TYPE, INT64);
        classDataTypes.put(Long.class, INT64);
        classDataTypes.put(Float.TYPE, FLOAT);
        classDataTypes.put(Float.class, FLOAT);
        classDataTypes.put(Double.TYPE, DOUBLE);
        classDataTypes.put(Double.class, DOUBLE);
        classDataTypes.put(Byte.TYPE, STRING);
        classDataTypes.put(Byte.class, STRING);
        classDataTypes.put(Boolean.TYPE, BOOL);
        classDataTypes.put(Boolean.class, BOOL);
    }

    public DataType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.value = i2;
    }

    public static DataType dataTypeOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            Class<?> cls = obj.getClass();
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            DataType dataType = classDataTypes.get(cls);
            if (dataType != null) {
                return dataType;
            }
            throw new IllegalArgumentException("cannot create Tensors of type " + cls.getName());
        }
        return (DataType) invokeL.objValue;
    }

    public static DataType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DataType) Enum.valueOf(DataType.class, str) : (DataType) invokeL.objValue;
    }

    public static DataType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DataType[]) $VALUES.clone() : (DataType[]) invokeV.objValue;
    }

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
