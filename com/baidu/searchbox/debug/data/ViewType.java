package com.baidu.searchbox.debug.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/debug/data/ViewType;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "CHECKBOX_VIEW", "DOUBLE_TEXT_VIEW", "NORMAL_VIEW", "CUSTOMIZE_VIEW", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ViewType {
    public static final /* synthetic */ ViewType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ViewType CHECKBOX_VIEW;
    public static final ViewType CUSTOMIZE_VIEW;
    public static final ViewType DOUBLE_TEXT_VIEW;
    public static final ViewType NORMAL_VIEW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1446623859, "Lcom/baidu/searchbox/debug/data/ViewType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1446623859, "Lcom/baidu/searchbox/debug/data/ViewType;");
                return;
            }
        }
        ViewType viewType = new ViewType("CHECKBOX_VIEW", 0);
        CHECKBOX_VIEW = viewType;
        ViewType viewType2 = new ViewType("DOUBLE_TEXT_VIEW", 1);
        DOUBLE_TEXT_VIEW = viewType2;
        ViewType viewType3 = new ViewType("NORMAL_VIEW", 2);
        NORMAL_VIEW = viewType3;
        ViewType viewType4 = new ViewType("CUSTOMIZE_VIEW", 3);
        CUSTOMIZE_VIEW = viewType4;
        $VALUES = new ViewType[]{viewType, viewType2, viewType3, viewType4};
    }

    public ViewType(String str, int i) {
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

    public static ViewType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ViewType) Enum.valueOf(ViewType.class, str) : (ViewType) invokeL.objValue;
    }

    public static ViewType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ViewType[]) $VALUES.clone() : (ViewType[]) invokeV.objValue;
    }
}
