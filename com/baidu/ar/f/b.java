package com.baidu.ar.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.f.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b wd;
    public transient /* synthetic */ FieldHolder $fh;
    public a we;
    public boolean wf;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wf = false;
        this.we = new a(context);
    }

    public static synchronized b q(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (wd == null) {
                    wd = new b(context);
                }
                bVar = wd;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void S(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (aVar = this.we) == null) {
            return;
        }
        aVar.S(z);
    }

    public void b(a.InterfaceC0072a interfaceC0072a) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0072a) == null) || (aVar = this.we) == null) {
            return;
        }
        aVar.a(interfaceC0072a);
        if (this.wf) {
            return;
        }
        try {
            this.we.start();
            this.wf = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                stop();
            } catch (Throwable unused) {
            }
            if (this.we != null) {
                this.we = null;
            }
            if (wd != null) {
                wd = null;
            }
            this.wf = false;
        }
    }

    public void stop() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.we) == null) {
            return;
        }
        aVar.stop();
        this.wf = false;
    }
}
