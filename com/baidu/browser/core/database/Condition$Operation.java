package com.baidu.browser.core.database;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class Condition$Operation {
    public static final /* synthetic */ Condition$Operation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Condition$Operation BETWEEN;
    public static final Condition$Operation EQUAL;
    public static final Condition$Operation GREAT;
    public static final Condition$Operation GREATEQUAL;
    public static final Condition$Operation IN;
    public static final Condition$Operation IS_NOT_NULL;
    public static final Condition$Operation IS_NULL;
    public static final Condition$Operation LESS;
    public static final Condition$Operation LESSEQUAL;
    public static final Condition$Operation LIKE;
    public static final Condition$Operation NOTEQUAL;
    public static final Condition$Operation NOT_BETWEEN;
    public static final Condition$Operation NOT_IN;
    public static final Condition$Operation NOT_LIKE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1376921962, "Lcom/baidu/browser/core/database/Condition$Operation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1376921962, "Lcom/baidu/browser/core/database/Condition$Operation;");
                return;
            }
        }
        EQUAL = new Condition$Operation("EQUAL", 0);
        NOTEQUAL = new Condition$Operation("NOTEQUAL", 1);
        GREAT = new Condition$Operation("GREAT", 2);
        GREATEQUAL = new Condition$Operation("GREATEQUAL", 3);
        LESS = new Condition$Operation("LESS", 4);
        LESSEQUAL = new Condition$Operation("LESSEQUAL", 5);
        BETWEEN = new Condition$Operation("BETWEEN", 6);
        NOT_BETWEEN = new Condition$Operation("NOT_BETWEEN", 7);
        IN = new Condition$Operation("IN", 8);
        NOT_IN = new Condition$Operation("NOT_IN", 9);
        LIKE = new Condition$Operation("LIKE", 10);
        NOT_LIKE = new Condition$Operation("NOT_LIKE", 11);
        IS_NULL = new Condition$Operation("IS_NULL", 12);
        Condition$Operation condition$Operation = new Condition$Operation("IS_NOT_NULL", 13);
        IS_NOT_NULL = condition$Operation;
        $VALUES = new Condition$Operation[]{EQUAL, NOTEQUAL, GREAT, GREATEQUAL, LESS, LESSEQUAL, BETWEEN, NOT_BETWEEN, IN, NOT_IN, LIKE, NOT_LIKE, IS_NULL, condition$Operation};
    }

    public Condition$Operation(String str, int i2) {
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
            }
        }
    }

    public static Condition$Operation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Condition$Operation) Enum.valueOf(Condition$Operation.class, str) : (Condition$Operation) invokeL.objValue;
    }

    public static Condition$Operation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Condition$Operation[]) $VALUES.clone() : (Condition$Operation[]) invokeV.objValue;
    }
}
