package com.baidu.ar.arrender;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends c implements IGLRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String hb;
    public String hc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, looper, bVar, eGLContext, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, looper, bVar, eGLContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Looper) objArr2[1], (com.baidu.ar.lua.b) objArr2[2], (EGLContext) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hb = "";
        this.hc = "";
        this.hb = Build.HARDWARE.toLowerCase();
        this.hc = Build.BOARD.toLowerCase();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, surface) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().bindTargetSurface(surface);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3)) == null) {
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
                return null;
            }
            Texture texture = new Texture();
            long createTexture = this.hx.getARPRenderer().createTexture(i, i2, i3);
            texture.setHandle(createTexture);
            texture.setId(this.hx.getARPRenderer().getTextureId(createTexture));
            texture.setType(i);
            return texture;
        }
        return (Texture) invokeIII.objValue;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, texture) == null) || texture == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            super.onRenderFinished(j);
            if (TextUtils.isEmpty(this.hb) || !this.hb.contains("qcom") || TextUtils.isEmpty(this.hc)) {
                return;
            }
            if (this.hc.contains("msm8953") || this.hc.contains("sdm632")) {
                GLES20.glFinish();
            }
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.release();
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setInputTexture(i, i2, i3, i4);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        ARPEngine aRPEngine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().swapBuffer();
    }
}
