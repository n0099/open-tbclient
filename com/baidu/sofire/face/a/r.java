package com.baidu.sofire.face.a;

import android.hardware.Camera;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class r implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q a;

    public r(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.a.E = false;
                Camera camera = this.a.x;
                if (camera != null) {
                    if (com.baidu.sofire.face.d.c.f) {
                        try {
                            camera.lock();
                        } catch (Throwable unused) {
                        }
                    }
                    this.a.x.setErrorCallback(null);
                    this.a.x.setPreviewCallback(null);
                    this.a.x.stopPreview();
                    a.a(this.a.x);
                    this.a.x = null;
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
