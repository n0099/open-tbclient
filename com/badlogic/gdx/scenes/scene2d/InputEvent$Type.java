package com.badlogic.gdx.scenes.scene2d;

import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class InputEvent$Type {
    public static final /* synthetic */ InputEvent$Type[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final InputEvent$Type enter;
    public static final InputEvent$Type exit;
    public static final InputEvent$Type keyDown;
    public static final InputEvent$Type keyTyped;
    public static final InputEvent$Type keyUp;
    public static final InputEvent$Type mouseMoved;
    public static final InputEvent$Type scrolled;
    public static final InputEvent$Type touchDown;
    public static final InputEvent$Type touchDragged;
    public static final InputEvent$Type touchUp;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-112182314, "Lcom/badlogic/gdx/scenes/scene2d/InputEvent$Type;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-112182314, "Lcom/badlogic/gdx/scenes/scene2d/InputEvent$Type;");
                return;
            }
        }
        touchDown = new InputEvent$Type("touchDown", 0);
        touchUp = new InputEvent$Type("touchUp", 1);
        touchDragged = new InputEvent$Type("touchDragged", 2);
        mouseMoved = new InputEvent$Type("mouseMoved", 3);
        enter = new InputEvent$Type("enter", 4);
        exit = new InputEvent$Type(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, 5);
        scrolled = new InputEvent$Type("scrolled", 6);
        keyDown = new InputEvent$Type("keyDown", 7);
        keyUp = new InputEvent$Type("keyUp", 8);
        InputEvent$Type inputEvent$Type = new InputEvent$Type("keyTyped", 9);
        keyTyped = inputEvent$Type;
        $VALUES = new InputEvent$Type[]{touchDown, touchUp, touchDragged, mouseMoved, enter, exit, scrolled, keyDown, keyUp, inputEvent$Type};
    }

    public InputEvent$Type(String str, int i) {
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

    public static InputEvent$Type valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InputEvent$Type) Enum.valueOf(InputEvent$Type.class, str) : (InputEvent$Type) invokeL.objValue;
    }

    public static InputEvent$Type[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InputEvent$Type[]) $VALUES.clone() : (InputEvent$Type[]) invokeV.objValue;
    }
}
