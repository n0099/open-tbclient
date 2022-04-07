package com.baidu.nadcore.widget.bubble;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class BubblePosition {
    public static final /* synthetic */ BubblePosition[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BubblePosition DOWN;
    public static final BubblePosition INVALID;
    public static final BubblePosition LEFT;
    public static final BubblePosition RIGHT;
    public static final BubblePosition UP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(524830113, "Lcom/baidu/nadcore/widget/bubble/BubblePosition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(524830113, "Lcom/baidu/nadcore/widget/bubble/BubblePosition;");
                return;
            }
        }
        INVALID = new BubblePosition("INVALID", 0);
        UP = new BubblePosition("UP", 1);
        DOWN = new BubblePosition("DOWN", 2);
        LEFT = new BubblePosition("LEFT", 3);
        BubblePosition bubblePosition = new BubblePosition("RIGHT", 4);
        RIGHT = bubblePosition;
        $VALUES = new BubblePosition[]{INVALID, UP, DOWN, LEFT, bubblePosition};
    }

    public BubblePosition(String str, int i) {
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

    public static BubblePosition valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BubblePosition) Enum.valueOf(BubblePosition.class, str) : (BubblePosition) invokeL.objValue;
    }

    public static BubblePosition[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BubblePosition[]) $VALUES.clone() : (BubblePosition[]) invokeV.objValue;
    }
}
