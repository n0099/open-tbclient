package c.a.y0.p.d;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes9.dex */
public class a extends MediaBaseRenderer implements c.a.y0.p.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27458e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f27459f;

    /* renamed from: g  reason: collision with root package name */
    public int f27460g;

    /* renamed from: h  reason: collision with root package name */
    public float f27461h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27459f = new int[1];
    }

    @Override // c.a.y0.p.g.b
    public void a(c.a.y0.p.f.a aVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, surfaceTexture) == null) {
            int i2 = this.mSurfaceViewHeight;
            int i3 = this.mSurfaceViewWidth;
            float f2 = this.mRatio;
            int i4 = i2 - ((int) (i3 * f2));
            if (f2 != 0.0f && f2 != (i2 * 1.0f) / i3 && i4 > 0) {
                b();
                GLES20.glBindFramebuffer(36160, this.f27460g);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f27458e, 0);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, (i4 * (-1.0680001f)) / this.mSurfaceViewHeight);
                this.mFullScreen2D.drawFrame(this.mTextureId, this.mMtx);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                GLES20.glBindFramebuffer(36160, 0);
                aVar.h(this.mFullScreen2D, this.f27458e, GlUtil.IDENTITY_MATRIX);
            } else if (this.mTextureMode == 1) {
                aVar.h(this.mFullScreen2D, this.mTextureId, this.mMtx);
            } else {
                aVar.h(this.mFullScreenEXT, this.mTextureId, this.mMtx);
            }
            aVar.f(surfaceTexture);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f27461h != this.mRatio) {
                c();
            }
            if (this.f27458e == 0) {
                this.f27458e = this.mFullScreen2D.createTexture2DObject();
                int i2 = this.mSurfaceViewWidth;
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, i2, (int) (i2 * this.mRatio), 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.f27459f, 0);
                this.f27460g = this.f27459f[0];
                this.f27461h = this.mRatio;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27458e == 0) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, this.f27459f, 0);
        GLES20.glDeleteTextures(1, new int[]{this.f27458e}, 0);
        this.f27458e = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroyInGlThread();
            c();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPauseInGlThread();
            c();
        }
    }
}
