package com.baidu.sofire.face.a;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b a;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            this.a.D = false;
            Camera camera = this.a.x;
            if (camera != null) {
                camera.setErrorCallback(null);
                this.a.x.setPreviewCallback(null);
                this.a.x.stopPreview();
                a.a(this.a.x);
                this.a.x = null;
            }
            b bVar = this.a;
            SurfaceHolder surfaceHolder = bVar.c;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(bVar);
            }
            b bVar2 = this.a;
            if (bVar2.h) {
                ILivenessStrategy iLivenessStrategy = bVar2.N;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.reset();
                    this.a.N = null;
                    return;
                }
                return;
            }
            IDetectStrategy iDetectStrategy = bVar2.O;
            if (iDetectStrategy != null) {
                iDetectStrategy.reset();
                this.a.O = null;
            }
        } catch (Throwable unused) {
        }
    }
}
