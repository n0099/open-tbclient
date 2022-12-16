package com.baidu.sofire.face.a;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ m a;

    public n(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            this.a.D = false;
            Camera camera = this.a.y;
            if (camera != null) {
                if (com.baidu.sofire.face.d.c.f) {
                    try {
                        camera.lock();
                    } catch (Throwable unused) {
                    }
                }
                this.a.y.setErrorCallback(null);
                this.a.y.setPreviewCallback(null);
                this.a.y.stopPreview();
                a.a(this.a.y);
                this.a.y = null;
            }
            m mVar = this.a;
            SurfaceHolder surfaceHolder = mVar.c;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(mVar);
            }
        } catch (Throwable unused2) {
        }
    }
}
