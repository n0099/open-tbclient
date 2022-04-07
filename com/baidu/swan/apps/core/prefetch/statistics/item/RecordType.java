package com.baidu.swan.apps.core.prefetch.statistics.item;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class RecordType {
    public static final /* synthetic */ RecordType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RecordType APP_ID;
    public static final RecordType APP_VERSION;
    public static final RecordType PREFETCH_EVENT;
    public static final RecordType PREFETCH_OTHER_MSG;
    public static final RecordType PREFETCH_PRELINK;
    public static final RecordType PREFETCH_TYPE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1098296363, "Lcom/baidu/swan/apps/core/prefetch/statistics/item/RecordType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1098296363, "Lcom/baidu/swan/apps/core/prefetch/statistics/item/RecordType;");
                return;
            }
        }
        APP_ID = new RecordType("APP_ID", 0);
        APP_VERSION = new RecordType("APP_VERSION", 1);
        PREFETCH_TYPE = new RecordType("PREFETCH_TYPE", 2);
        PREFETCH_EVENT = new RecordType("PREFETCH_EVENT", 3);
        PREFETCH_OTHER_MSG = new RecordType("PREFETCH_OTHER_MSG", 4);
        RecordType recordType = new RecordType("PREFETCH_PRELINK", 5);
        PREFETCH_PRELINK = recordType;
        $VALUES = new RecordType[]{APP_ID, APP_VERSION, PREFETCH_TYPE, PREFETCH_EVENT, PREFETCH_OTHER_MSG, recordType};
    }

    public RecordType(String str, int i) {
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

    public static RecordType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RecordType) Enum.valueOf(RecordType.class, str) : (RecordType) invokeL.objValue;
    }

    public static RecordType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RecordType[]) $VALUES.clone() : (RecordType[]) invokeV.objValue;
    }
}
