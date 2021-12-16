package com.baidu.nadcore.sweetsqlite.query;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class JoinType {
    public static final /* synthetic */ JoinType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JoinType CROSS;
    public static final JoinType INNER;
    public static final JoinType LEFT;
    public static final JoinType OTTER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(843809872, "Lcom/baidu/nadcore/sweetsqlite/query/JoinType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(843809872, "Lcom/baidu/nadcore/sweetsqlite/query/JoinType;");
                return;
            }
        }
        LEFT = new JoinType("LEFT", 0);
        OTTER = new JoinType("OTTER", 1);
        INNER = new JoinType("INNER", 2);
        JoinType joinType = new JoinType("CROSS", 3);
        CROSS = joinType;
        $VALUES = new JoinType[]{LEFT, OTTER, INNER, joinType};
    }

    public JoinType(String str, int i2) {
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

    public static JoinType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JoinType) Enum.valueOf(JoinType.class, str) : (JoinType) invokeL.objValue;
    }

    public static JoinType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JoinType[]) $VALUES.clone() : (JoinType[]) invokeV.objValue;
    }
}
