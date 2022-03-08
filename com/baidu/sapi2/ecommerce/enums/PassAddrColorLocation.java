package com.baidu.sapi2.ecommerce.enums;

import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class PassAddrColorLocation implements NoProguard {
    public static final /* synthetic */ PassAddrColorLocation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PassAddrColorLocation ADDRESS_ITEM_IC_BG_COLOR;
    public static final PassAddrColorLocation ADDRESS_ITEM_IC_BG_COLOR_DARKMODE;
    public static final PassAddrColorLocation ADDRESS_ITEM_IC_TEXT_COLOR;
    public static final PassAddrColorLocation ADDRESS_ITEM_IC_TEXT_COLOR_DARKMODE;
    public static final PassAddrColorLocation ADDRESS_ITEM_TEXT_NAME_BOLD;
    public static final PassAddrColorLocation ADDRESS_ITEM_TEXT_PHONE_BOLD;
    public static final PassAddrColorLocation ADD_ADDRESS_BTN_BG;
    public static final PassAddrColorLocation ADD_ADDRESS_BTN_BG_DARKMODE;
    public static final PassAddrColorLocation ADD_ADDRESS_BTN_CORNER_RADIUS;
    public static final PassAddrColorLocation ADD_ADDRESS_TEXT_BG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(82066499, "Lcom/baidu/sapi2/ecommerce/enums/PassAddrColorLocation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(82066499, "Lcom/baidu/sapi2/ecommerce/enums/PassAddrColorLocation;");
                return;
            }
        }
        ADDRESS_ITEM_IC_TEXT_COLOR = new PassAddrColorLocation("ADDRESS_ITEM_IC_TEXT_COLOR", 0);
        ADDRESS_ITEM_IC_BG_COLOR = new PassAddrColorLocation("ADDRESS_ITEM_IC_BG_COLOR", 1);
        ADD_ADDRESS_BTN_BG = new PassAddrColorLocation("ADD_ADDRESS_BTN_BG", 2);
        ADD_ADDRESS_TEXT_BG = new PassAddrColorLocation("ADD_ADDRESS_TEXT_BG", 3);
        ADDRESS_ITEM_IC_TEXT_COLOR_DARKMODE = new PassAddrColorLocation("ADDRESS_ITEM_IC_TEXT_COLOR_DARKMODE", 4);
        ADDRESS_ITEM_IC_BG_COLOR_DARKMODE = new PassAddrColorLocation("ADDRESS_ITEM_IC_BG_COLOR_DARKMODE", 5);
        ADD_ADDRESS_BTN_BG_DARKMODE = new PassAddrColorLocation("ADD_ADDRESS_BTN_BG_DARKMODE", 6);
        ADD_ADDRESS_BTN_CORNER_RADIUS = new PassAddrColorLocation("ADD_ADDRESS_BTN_CORNER_RADIUS", 7);
        ADDRESS_ITEM_TEXT_NAME_BOLD = new PassAddrColorLocation("ADDRESS_ITEM_TEXT_NAME_BOLD", 8);
        PassAddrColorLocation passAddrColorLocation = new PassAddrColorLocation("ADDRESS_ITEM_TEXT_PHONE_BOLD", 9);
        ADDRESS_ITEM_TEXT_PHONE_BOLD = passAddrColorLocation;
        $VALUES = new PassAddrColorLocation[]{ADDRESS_ITEM_IC_TEXT_COLOR, ADDRESS_ITEM_IC_BG_COLOR, ADD_ADDRESS_BTN_BG, ADD_ADDRESS_TEXT_BG, ADDRESS_ITEM_IC_TEXT_COLOR_DARKMODE, ADDRESS_ITEM_IC_BG_COLOR_DARKMODE, ADD_ADDRESS_BTN_BG_DARKMODE, ADD_ADDRESS_BTN_CORNER_RADIUS, ADDRESS_ITEM_TEXT_NAME_BOLD, passAddrColorLocation};
    }

    public PassAddrColorLocation(String str, int i2) {
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

    public static PassAddrColorLocation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PassAddrColorLocation) Enum.valueOf(PassAddrColorLocation.class, str) : (PassAddrColorLocation) invokeL.objValue;
    }

    public static PassAddrColorLocation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PassAddrColorLocation[]) $VALUES.clone() : (PassAddrColorLocation[]) invokeV.objValue;
    }
}
