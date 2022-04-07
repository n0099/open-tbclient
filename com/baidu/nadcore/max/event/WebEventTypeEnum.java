package com.baidu.nadcore.max.event;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/nadcore/max/event/WebEventTypeEnum;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "WEB_INIT_SUCCESS", "WEB_DESTROY", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebEventTypeEnum {
    public static final /* synthetic */ WebEventTypeEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WebEventTypeEnum WEB_DESTROY;
    public static final WebEventTypeEnum WEB_INIT_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1425699853, "Lcom/baidu/nadcore/max/event/WebEventTypeEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1425699853, "Lcom/baidu/nadcore/max/event/WebEventTypeEnum;");
                return;
            }
        }
        WebEventTypeEnum webEventTypeEnum = new WebEventTypeEnum("WEB_INIT_SUCCESS", 0);
        WEB_INIT_SUCCESS = webEventTypeEnum;
        WebEventTypeEnum webEventTypeEnum2 = new WebEventTypeEnum("WEB_DESTROY", 1);
        WEB_DESTROY = webEventTypeEnum2;
        $VALUES = new WebEventTypeEnum[]{webEventTypeEnum, webEventTypeEnum2};
    }

    public WebEventTypeEnum(String str, int i) {
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

    public static WebEventTypeEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebEventTypeEnum) Enum.valueOf(WebEventTypeEnum.class, str) : (WebEventTypeEnum) invokeL.objValue;
    }

    public static WebEventTypeEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebEventTypeEnum[]) $VALUES.clone() : (WebEventTypeEnum[]) invokeV.objValue;
    }
}
