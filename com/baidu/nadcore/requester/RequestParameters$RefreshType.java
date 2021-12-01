package com.baidu.nadcore.requester;

import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class RequestParameters$RefreshType {
    public static final /* synthetic */ RequestParameters$RefreshType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RequestParameters$RefreshType NONE;
    public static final RequestParameters$RefreshType PULL_DOWN;
    public static final RequestParameters$RefreshType PULL_UP;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1443753553, "Lcom/baidu/nadcore/requester/RequestParameters$RefreshType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1443753553, "Lcom/baidu/nadcore/requester/RequestParameters$RefreshType;");
                return;
            }
        }
        NONE = new RequestParameters$RefreshType(PolyActivity.NONE_PANEL_TYPE, 0, null);
        PULL_UP = new RequestParameters$RefreshType("PULL_UP", 1, "3");
        RequestParameters$RefreshType requestParameters$RefreshType = new RequestParameters$RefreshType("PULL_DOWN", 2, "4");
        PULL_DOWN = requestParameters$RefreshType;
        $VALUES = new RequestParameters$RefreshType[]{NONE, PULL_UP, requestParameters$RefreshType};
    }

    public RequestParameters$RefreshType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static RequestParameters$RefreshType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RequestParameters$RefreshType) Enum.valueOf(RequestParameters$RefreshType.class, str) : (RequestParameters$RefreshType) invokeL.objValue;
    }

    public static RequestParameters$RefreshType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RequestParameters$RefreshType[]) $VALUES.clone() : (RequestParameters$RefreshType[]) invokeV.objValue;
    }
}
