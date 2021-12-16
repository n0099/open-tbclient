package com.badlogic.gdx.graphics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class Cursor$SystemCursor {
    public static final /* synthetic */ Cursor$SystemCursor[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Cursor$SystemCursor Arrow;
    public static final Cursor$SystemCursor Crosshair;
    public static final Cursor$SystemCursor Hand;
    public static final Cursor$SystemCursor HorizontalResize;
    public static final Cursor$SystemCursor Ibeam;
    public static final Cursor$SystemCursor VerticalResize;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-53826212, "Lcom/badlogic/gdx/graphics/Cursor$SystemCursor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-53826212, "Lcom/badlogic/gdx/graphics/Cursor$SystemCursor;");
                return;
            }
        }
        Arrow = new Cursor$SystemCursor("Arrow", 0);
        Ibeam = new Cursor$SystemCursor("Ibeam", 1);
        Crosshair = new Cursor$SystemCursor("Crosshair", 2);
        Hand = new Cursor$SystemCursor("Hand", 3);
        HorizontalResize = new Cursor$SystemCursor("HorizontalResize", 4);
        Cursor$SystemCursor cursor$SystemCursor = new Cursor$SystemCursor("VerticalResize", 5);
        VerticalResize = cursor$SystemCursor;
        $VALUES = new Cursor$SystemCursor[]{Arrow, Ibeam, Crosshair, Hand, HorizontalResize, cursor$SystemCursor};
    }

    public Cursor$SystemCursor(String str, int i2) {
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

    public static Cursor$SystemCursor valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Cursor$SystemCursor) Enum.valueOf(Cursor$SystemCursor.class, str) : (Cursor$SystemCursor) invokeL.objValue;
    }

    public static Cursor$SystemCursor[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Cursor$SystemCursor[]) $VALUES.clone() : (Cursor$SystemCursor[]) invokeV.objValue;
    }
}
