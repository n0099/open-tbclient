package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "c";
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture dL;
    public int gv;
    public int gw;
    public Surface gx;
    public Canvas gy;
    public boolean gz;
    public int mTextureId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1109054371, "Lcom/baidu/ar/arplay/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1109054371, "Lcom/baidu/ar/arplay/d/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gv = 500;
        this.gw = 500;
        this.gz = true;
    }

    public Surface a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            this.mTextureId = i2;
            this.dL = new SurfaceTexture(i2);
            f(i3, i4);
            Surface surface = new Surface(this.dL);
            this.gx = surface;
            return surface;
        }
        return (Surface) invokeIII.objValue;
    }

    public void bo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Canvas canvas = this.gy;
            if (canvas != null) {
                this.gx.unlockCanvasAndPost(canvas);
            }
            this.gy = null;
        }
    }

    public void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.gv = i2;
            this.gw = i3;
            this.dL.setDefaultBufferSize(i2, i3);
        }
    }

    public Canvas lockCanvas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.gy = null;
            Surface surface = this.gx;
            if (surface != null) {
                try {
                    this.gy = surface.lockCanvas(null);
                } catch (Exception e2) {
                    String str = "error while rendering view to gl: " + e2;
                }
            }
            return this.gy;
        }
        return (Canvas) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Surface surface = this.gx;
            if (surface != null) {
                surface.release();
            }
            SurfaceTexture surfaceTexture = this.dL;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this.gx = null;
            this.dL = null;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.dL.updateTexImage();
            } catch (Exception e2) {
                String str = "error while update view to gl: " + e2;
            }
        }
    }
}
