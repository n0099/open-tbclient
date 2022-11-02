package com.baidu.tbadk.core.dialog.yun;

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
public final class DialogTime {
    public static final /* synthetic */ DialogTime[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DialogTime MAIN_PAGE_COMMON_TAB;
    public static final DialogTime MAIN_PAGE_RECOMMEND;
    public static final DialogTime PAGE_UNDEFINED;
    public static final DialogTime SYNC_FINISH;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isPage;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677138447, "Lcom/baidu/tbadk/core/dialog/yun/DialogTime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(677138447, "Lcom/baidu/tbadk/core/dialog/yun/DialogTime;");
                return;
            }
        }
        SYNC_FINISH = new DialogTime("SYNC_FINISH", 0, "sync_finish", false);
        PAGE_UNDEFINED = new DialogTime("PAGE_UNDEFINED", 1, "page_undefined", true);
        MAIN_PAGE_RECOMMEND = new DialogTime("MAIN_PAGE_RECOMMEND", 2, "main_page_recommend", true);
        DialogTime dialogTime = new DialogTime("MAIN_PAGE_COMMON_TAB", 3, "main_page_common_tab", true);
        MAIN_PAGE_COMMON_TAB = dialogTime;
        $VALUES = new DialogTime[]{SYNC_FINISH, PAGE_UNDEFINED, MAIN_PAGE_RECOMMEND, dialogTime};
    }

    public DialogTime(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Boolean.valueOf(z)};
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
        this.value = str2;
        this.isPage = z;
    }

    public static DialogTime valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (DialogTime) Enum.valueOf(DialogTime.class, str);
        }
        return (DialogTime) invokeL.objValue;
    }

    public static DialogTime[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (DialogTime[]) $VALUES.clone();
        }
        return (DialogTime[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }

    public boolean isPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isPage;
        }
        return invokeV.booleanValue;
    }
}
