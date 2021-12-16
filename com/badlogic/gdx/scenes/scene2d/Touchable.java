package com.badlogic.gdx.scenes.scene2d;

import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.button.StyleHelper;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class Touchable {
    public static final /* synthetic */ Touchable[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Touchable childrenOnly;
    public static final Touchable disabled;
    public static final Touchable enabled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794507115, "Lcom/badlogic/gdx/scenes/scene2d/Touchable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794507115, "Lcom/badlogic/gdx/scenes/scene2d/Touchable;");
                return;
            }
        }
        enabled = new Touchable(SapiOptions.KEY_CACHE_ENABLED, 0);
        disabled = new Touchable(StyleHelper.KEY_ONDISABLE, 1);
        Touchable touchable = new Touchable("childrenOnly", 2);
        childrenOnly = touchable;
        $VALUES = new Touchable[]{enabled, disabled, touchable};
    }

    public Touchable(String str, int i2) {
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

    public static Touchable valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Touchable) Enum.valueOf(Touchable.class, str) : (Touchable) invokeL.objValue;
    }

    public static Touchable[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Touchable[]) $VALUES.clone() : (Touchable[]) invokeV.objValue;
    }
}
