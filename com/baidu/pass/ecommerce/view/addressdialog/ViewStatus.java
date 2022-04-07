package com.baidu.pass.ecommerce.view.addressdialog;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ViewStatus {
    public static final /* synthetic */ ViewStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ViewStatus EMPTY;
    public static final ViewStatus ERROR;
    public static final ViewStatus LOADING;
    public static final ViewStatus SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(726910822, "Lcom/baidu/pass/ecommerce/view/addressdialog/ViewStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(726910822, "Lcom/baidu/pass/ecommerce/view/addressdialog/ViewStatus;");
                return;
            }
        }
        LOADING = new ViewStatus("LOADING", 0);
        SUCCESS = new ViewStatus("SUCCESS", 1);
        ERROR = new ViewStatus("ERROR", 2);
        ViewStatus viewStatus = new ViewStatus("EMPTY", 3);
        EMPTY = viewStatus;
        $VALUES = new ViewStatus[]{LOADING, SUCCESS, ERROR, viewStatus};
    }

    public ViewStatus(String str, int i) {
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

    public static ViewStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ViewStatus) Enum.valueOf(ViewStatus.class, str) : (ViewStatus) invokeL.objValue;
    }

    public static ViewStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ViewStatus[]) $VALUES.clone() : (ViewStatus[]) invokeV.objValue;
    }
}
