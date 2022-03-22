package com.badlogic.gdx.scenes.scene2d.ui;

import c.b.b.n.a;
import c.b.b.q.a0;
import c.b.b.q.z;
import com.badlogic.gdx.math.Rectangle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Table$DebugRect extends Rectangle {
    public static /* synthetic */ Interceptable $ic;
    public static z<Table$DebugRect> pool;
    public transient /* synthetic */ FieldHolder $fh;
    public a color;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(83909708, "Lcom/badlogic/gdx/scenes/scene2d/ui/Table$DebugRect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(83909708, "Lcom/badlogic/gdx/scenes/scene2d/ui/Table$DebugRect;");
                return;
            }
        }
        pool = a0.a(Table$DebugRect.class);
    }

    public Table$DebugRect() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
