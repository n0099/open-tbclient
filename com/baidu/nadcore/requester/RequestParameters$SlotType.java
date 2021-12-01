package com.baidu.nadcore.requester;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class RequestParameters$SlotType {
    public static final /* synthetic */ RequestParameters$SlotType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RequestParameters$SlotType BANNER;
    public static final RequestParameters$SlotType DEFAULT;
    public static final RequestParameters$SlotType DRAW;
    public static final RequestParameters$SlotType FEED;
    public static final RequestParameters$SlotType REWARD;
    public static final RequestParameters$SlotType SPLASH;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(875916440, "Lcom/baidu/nadcore/requester/RequestParameters$SlotType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(875916440, "Lcom/baidu/nadcore/requester/RequestParameters$SlotType;");
                return;
            }
        }
        DEFAULT = new RequestParameters$SlotType("DEFAULT", 0);
        SPLASH = new RequestParameters$SlotType("SPLASH", 1);
        FEED = new RequestParameters$SlotType("FEED", 2);
        BANNER = new RequestParameters$SlotType("BANNER", 3);
        DRAW = new RequestParameters$SlotType("DRAW", 4);
        RequestParameters$SlotType requestParameters$SlotType = new RequestParameters$SlotType("REWARD", 5);
        REWARD = requestParameters$SlotType;
        $VALUES = new RequestParameters$SlotType[]{DEFAULT, SPLASH, FEED, BANNER, DRAW, requestParameters$SlotType};
    }

    public RequestParameters$SlotType(String str, int i2) {
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

    public static RequestParameters$SlotType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RequestParameters$SlotType) Enum.valueOf(RequestParameters$SlotType.class, str) : (RequestParameters$SlotType) invokeL.objValue;
    }

    public static RequestParameters$SlotType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RequestParameters$SlotType[]) $VALUES.clone() : (RequestParameters$SlotType[]) invokeV.objValue;
    }
}
