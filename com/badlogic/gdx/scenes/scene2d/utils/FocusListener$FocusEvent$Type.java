package com.badlogic.gdx.scenes.scene2d.utils;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class FocusListener$FocusEvent$Type {
    public static final /* synthetic */ FocusListener$FocusEvent$Type[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FocusListener$FocusEvent$Type keyboard;
    public static final FocusListener$FocusEvent$Type scroll;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401918786, "Lcom/badlogic/gdx/scenes/scene2d/utils/FocusListener$FocusEvent$Type;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401918786, "Lcom/badlogic/gdx/scenes/scene2d/utils/FocusListener$FocusEvent$Type;");
                return;
            }
        }
        keyboard = new FocusListener$FocusEvent$Type(IntentConfig.SHOW_KEYBOARD, 0);
        FocusListener$FocusEvent$Type focusListener$FocusEvent$Type = new FocusListener$FocusEvent$Type("scroll", 1);
        scroll = focusListener$FocusEvent$Type;
        $VALUES = new FocusListener$FocusEvent$Type[]{keyboard, focusListener$FocusEvent$Type};
    }

    public FocusListener$FocusEvent$Type(String str, int i2) {
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

    public static FocusListener$FocusEvent$Type valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FocusListener$FocusEvent$Type) Enum.valueOf(FocusListener$FocusEvent$Type.class, str) : (FocusListener$FocusEvent$Type) invokeL.objValue;
    }

    public static FocusListener$FocusEvent$Type[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FocusListener$FocusEvent$Type[]) $VALUES.clone() : (FocusListener$FocusEvent$Type[]) invokeV.objValue;
    }
}
