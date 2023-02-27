package com.baidu.browser.core.database.annotation;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class BdDbColumn$TYPE {
    public static final /* synthetic */ BdDbColumn$TYPE[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BdDbColumn$TYPE BLOB;
    public static final BdDbColumn$TYPE FLOAT;
    public static final BdDbColumn$TYPE INTEGER;
    public static final BdDbColumn$TYPE LONG;
    public static final BdDbColumn$TYPE SHORT;
    public static final BdDbColumn$TYPE TEXT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1354133670, "Lcom/baidu/browser/core/database/annotation/BdDbColumn$TYPE;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1354133670, "Lcom/baidu/browser/core/database/annotation/BdDbColumn$TYPE;");
                return;
            }
        }
        TEXT = new BdDbColumn$TYPE("TEXT", 0);
        INTEGER = new BdDbColumn$TYPE("INTEGER", 1);
        LONG = new BdDbColumn$TYPE("LONG", 2);
        SHORT = new BdDbColumn$TYPE("SHORT", 3);
        FLOAT = new BdDbColumn$TYPE("FLOAT", 4);
        BdDbColumn$TYPE bdDbColumn$TYPE = new BdDbColumn$TYPE("BLOB", 5);
        BLOB = bdDbColumn$TYPE;
        $VALUES = new BdDbColumn$TYPE[]{TEXT, INTEGER, LONG, SHORT, FLOAT, bdDbColumn$TYPE};
    }

    public BdDbColumn$TYPE(String str, int i) {
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

    public static BdDbColumn$TYPE valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BdDbColumn$TYPE) Enum.valueOf(BdDbColumn$TYPE.class, str);
        }
        return (BdDbColumn$TYPE) invokeL.objValue;
    }

    public static BdDbColumn$TYPE[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BdDbColumn$TYPE[]) $VALUES.clone();
        }
        return (BdDbColumn$TYPE[]) invokeV.objValue;
    }
}
