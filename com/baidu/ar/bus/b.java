package com.baidu.ar.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean kA;
    public boolean kB;
    public final d kx;
    public final int ky;
    public final a kz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper, int i) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, looper, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.kB = false;
        this.kz = aVar;
        this.ky = i;
        this.kx = new d();
    }

    public void c(g gVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gVar, obj) == null) {
            c d = c.d(gVar, obj);
            synchronized (this) {
                this.kx.c(d);
                if (!this.kA) {
                    this.kA = true;
                    if (!sendMessage(obtainMessage())) {
                        com.baidu.ar.h.b.aS("Could not send handler message");
                    }
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                while (!this.kB) {
                    c cH = this.kx.cH();
                    if (cH == null) {
                        synchronized (this) {
                            cH = this.kx.cH();
                            if (cH == null) {
                                this.kA = false;
                                return;
                            }
                        }
                    }
                    this.kz.a(cH);
                    if (SystemClock.uptimeMillis() - uptimeMillis >= this.ky) {
                        if (!sendMessage(obtainMessage())) {
                            com.baidu.ar.h.b.aS("Could not send handler message");
                        }
                        this.kA = true;
                        return;
                    }
                }
            } finally {
                this.kA = false;
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.kB = true;
        }
    }
}
