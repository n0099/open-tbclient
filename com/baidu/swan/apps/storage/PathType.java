package com.baidu.swan.apps.storage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class PathType {
    public static final /* synthetic */ PathType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PathType BD_FILE;
    public static final PathType CLOUD;
    public static final PathType ERROR;
    public static final PathType NETWORK;
    public static final PathType RELATIVE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-228912005, "Lcom/baidu/swan/apps/storage/PathType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-228912005, "Lcom/baidu/swan/apps/storage/PathType;");
                return;
            }
        }
        ERROR = new PathType("ERROR", 0);
        BD_FILE = new PathType("BD_FILE", 1);
        RELATIVE = new PathType("RELATIVE", 2);
        NETWORK = new PathType("NETWORK", 3);
        PathType pathType = new PathType("CLOUD", 4);
        CLOUD = pathType;
        $VALUES = new PathType[]{ERROR, BD_FILE, RELATIVE, NETWORK, pathType};
    }

    public PathType(String str, int i) {
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

    public static PathType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PathType) Enum.valueOf(PathType.class, str) : (PathType) invokeL.objValue;
    }

    public static PathType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PathType[]) $VALUES.clone() : (PathType[]) invokeV.objValue;
    }
}
