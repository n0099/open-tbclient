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
/* loaded from: classes2.dex */
public final class BindWidgetAction {
    public static final /* synthetic */ BindWidgetAction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BindWidgetAction BIND_EMAIL;
    public static final BindWidgetAction BIND_MOBILE;
    public static final BindWidgetAction REBIND_EMAIL;
    public static final BindWidgetAction REBIND_MOBILE;
    public static final BindWidgetAction UNBIND_EMAIL;
    public static final BindWidgetAction UNBIND_MOBILE;
    public transient /* synthetic */ FieldHolder $fh;
    public String name;
    public String uri;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-736241833, "Lcom/baidu/sapi2/utils/enums/BindWidgetAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-736241833, "Lcom/baidu/sapi2/utils/enums/BindWidgetAction;");
                return;
            }
        }
        BIND_MOBILE = new BindWidgetAction("BIND_MOBILE", 0, "/wp/bindwidget-bindmobile", "绑定手机");
        BIND_EMAIL = new BindWidgetAction("BIND_EMAIL", 1, "/wp/bindwidget-bindemail", "绑定邮箱");
        REBIND_MOBILE = new BindWidgetAction("REBIND_MOBILE", 2, "/wp/bindwidget-rebindmobile", "换绑手机");
        REBIND_EMAIL = new BindWidgetAction("REBIND_EMAIL", 3, "/wp/bindwidget-rebindemail", "换绑邮箱");
        UNBIND_MOBILE = new BindWidgetAction("UNBIND_MOBILE", 4, "/wp/bindwidget-unbindmobile", "解绑手机");
        BindWidgetAction bindWidgetAction = new BindWidgetAction("UNBIND_EMAIL", 5, "/wp/bindwidget-unbindemail", "解绑邮箱");
        UNBIND_EMAIL = bindWidgetAction;
        $VALUES = new BindWidgetAction[]{BIND_MOBILE, BIND_EMAIL, REBIND_MOBILE, REBIND_EMAIL, UNBIND_MOBILE, bindWidgetAction};
    }

    public BindWidgetAction(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.uri = str2;
        this.name = str3;
    }

    public static BindWidgetAction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BindWidgetAction) Enum.valueOf(BindWidgetAction.class, str) : (BindWidgetAction) invokeL.objValue;
    }

    public static BindWidgetAction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BindWidgetAction[]) $VALUES.clone() : (BindWidgetAction[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uri : (String) invokeV.objValue;
    }
}
