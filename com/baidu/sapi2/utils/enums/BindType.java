package com.baidu.sapi2.utils.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class BindType {
    public static final /* synthetic */ BindType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BindType BIND_MOBILE;
    public static final BindType EXPLICIT;
    public static final BindType SMS;
    public transient /* synthetic */ FieldHolder $fh;
    public String callbackPage;
    public String finishBindPage;
    public String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-567225417, "Lcom/baidu/sapi2/utils/enums/BindType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-567225417, "Lcom/baidu/sapi2/utils/enums/BindType;");
                return;
            }
        }
        EXPLICIT = new BindType("EXPLICIT", 0, "explicit", "afterauth", "finishbind");
        SMS = new BindType("SMS", 1, "sms", "afterauth", "finishbind");
        BindType bindType = new BindType("BIND_MOBILE", 2, "bind_mobile", "afterauth", "afterauth");
        BIND_MOBILE = bindType;
        $VALUES = new BindType[]{EXPLICIT, SMS, bindType};
    }

    public BindType(String str, int i2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str5 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = "";
        this.name = str2;
        this.callbackPage = str3;
        this.finishBindPage = str4;
    }

    public static BindType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BindType) Enum.valueOf(BindType.class, str) : (BindType) invokeL.objValue;
    }

    public static BindType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BindType[]) $VALUES.clone() : (BindType[]) invokeV.objValue;
    }

    public String getCallbackPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callbackPage : (String) invokeV.objValue;
    }

    public String getFinishBindPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.finishBindPage : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
