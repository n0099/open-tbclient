package com.baidu.location.c;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e a;

    public g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        Location location;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && com.baidu.location.f.isServing) {
            int i2 = message.what;
            if (i2 == 1) {
                this.a.e((Location) message.obj);
                return;
            }
            if (i2 == 3) {
                eVar = this.a;
                location = (Location) message.obj;
                str = "&og=1";
            } else if (i2 != 4) {
                return;
            } else {
                eVar = this.a;
                location = (Location) message.obj;
                str = "&og=2";
            }
            eVar.a(str, location);
        }
    }
}
