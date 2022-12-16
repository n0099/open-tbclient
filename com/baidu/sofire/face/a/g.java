package com.baidu.sofire.face.a;

import android.hardware.Camera;
import android.view.TextureView;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.sofire.face.a.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ f a;

    public g(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            this.a.F = false;
            f fVar = this.a;
            Camera camera = fVar.A;
            if (camera != null) {
                if (fVar.i && com.baidu.sofire.face.d.c.f) {
                    try {
                        camera.lock();
                    } catch (Throwable unused) {
                    }
                }
                this.a.A.setErrorCallback(null);
                this.a.A.setPreviewCallback(null);
                this.a.A.stopPreview();
                a.a(this.a.A);
                this.a.A = null;
            }
            TextureView textureView = this.a.c;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
            }
            f fVar2 = this.a;
            if (fVar2.h) {
                ILivenessStrategy iLivenessStrategy = fVar2.R;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.reset();
                    this.a.R = null;
                }
            } else {
                IDetectStrategy iDetectStrategy = fVar2.S;
                if (iDetectStrategy != null) {
                    iDetectStrategy.reset();
                    this.a.S = null;
                }
            }
            f.h hVar = this.a.c0;
            if (hVar != null) {
                hVar.a = false;
                this.a.c0.interrupt();
                this.a.c0 = null;
            }
        } catch (Throwable unused2) {
        }
    }
}
