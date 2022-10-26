package com.baidu.sapi2.utils.enums;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class QrLoginAction {
    public static final /* synthetic */ QrLoginAction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final QrLoginAction CANCEL;
    public static final QrLoginAction LOGIN;
    public static final QrLoginAction NOTICE;
    public transient /* synthetic */ FieldHolder $fh;
    public String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386784758, "Lcom/baidu/sapi2/utils/enums/QrLoginAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386784758, "Lcom/baidu/sapi2/utils/enums/QrLoginAction;");
                return;
            }
        }
        NOTICE = new QrLoginAction("NOTICE", 0, "notice");
        LOGIN = new QrLoginAction("LOGIN", 1, "login");
        QrLoginAction qrLoginAction = new QrLoginAction("CANCEL", 2, "cancel");
        CANCEL = qrLoginAction;
        $VALUES = new QrLoginAction[]{NOTICE, LOGIN, qrLoginAction};
    }

    public QrLoginAction(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str2;
    }

    public static QrLoginAction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (QrLoginAction) Enum.valueOf(QrLoginAction.class, str);
        }
        return (QrLoginAction) invokeL.objValue;
    }

    public static QrLoginAction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (QrLoginAction[]) $VALUES.clone();
        }
        return (QrLoginAction[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }
}
