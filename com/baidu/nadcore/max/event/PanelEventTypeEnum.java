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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/nadcore/max/event/PanelEventTypeEnum;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "CLICK_PANEL_UI", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PanelEventTypeEnum {
    public static final /* synthetic */ PanelEventTypeEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PanelEventTypeEnum CLICK_PANEL_UI;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1687726595, "Lcom/baidu/nadcore/max/event/PanelEventTypeEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1687726595, "Lcom/baidu/nadcore/max/event/PanelEventTypeEnum;");
                return;
            }
        }
        PanelEventTypeEnum panelEventTypeEnum = new PanelEventTypeEnum("CLICK_PANEL_UI", 0);
        CLICK_PANEL_UI = panelEventTypeEnum;
        $VALUES = new PanelEventTypeEnum[]{panelEventTypeEnum};
    }

    public PanelEventTypeEnum(String str, int i) {
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

    public static PanelEventTypeEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PanelEventTypeEnum) Enum.valueOf(PanelEventTypeEnum.class, str) : (PanelEventTypeEnum) invokeL.objValue;
    }

    public static PanelEventTypeEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PanelEventTypeEnum[]) $VALUES.clone() : (PanelEventTypeEnum[]) invokeV.objValue;
    }
}
