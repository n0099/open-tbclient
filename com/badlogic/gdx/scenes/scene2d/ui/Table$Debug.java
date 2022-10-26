package com.badlogic.gdx.scenes.scene2d.ui;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class Table$Debug {
    public static final /* synthetic */ Table$Debug[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Table$Debug actor;
    public static final Table$Debug all;
    public static final Table$Debug cell;
    public static final Table$Debug none;
    public static final Table$Debug table;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2059174832, "Lcom/badlogic/gdx/scenes/scene2d/ui/Table$Debug;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2059174832, "Lcom/badlogic/gdx/scenes/scene2d/ui/Table$Debug;");
                return;
            }
        }
        none = new Table$Debug("none", 0);
        all = new Table$Debug("all", 1);
        table = new Table$Debug("table", 2);
        cell = new Table$Debug("cell", 3);
        Table$Debug table$Debug = new Table$Debug("actor", 4);
        actor = table$Debug;
        $VALUES = new Table$Debug[]{none, all, table, cell, table$Debug};
    }

    public Table$Debug(String str, int i) {
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

    public static Table$Debug valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (Table$Debug) Enum.valueOf(Table$Debug.class, str);
        }
        return (Table$Debug) invokeL.objValue;
    }

    public static Table$Debug[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (Table$Debug[]) $VALUES.clone();
        }
        return (Table$Debug[]) invokeV.objValue;
    }
}
