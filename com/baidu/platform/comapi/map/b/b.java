package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0126a a;
    public MapController b;
    public com.baidu.platform.comapi.map.b.a.b c;
    public com.baidu.platform.comapi.map.b.a.a d;

    public b(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new c(this);
        this.b = mapController;
        this.c = new com.baidu.platform.comapi.map.b.a.b(new com.baidu.platform.comapi.map.b.b.b(mapController));
        this.d = new com.baidu.platform.comapi.map.b.a.a(this.a, mapController);
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            this.c.a(motionEvent);
            this.d.a(motionEvent);
        }
    }
}
