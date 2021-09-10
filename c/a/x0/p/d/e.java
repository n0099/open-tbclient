package c.a.x0.p.d;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
/* loaded from: classes4.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean F;

    @Override // c.a.x0.p.d.a, c.a.x0.p.g.b
    public void a(c.a.x0.p.f.a aVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, surfaceTexture) == null) {
            aVar.h(this.mFullScreen2D, this.x, GlUtil.IDENTITY_MATRIX);
            aVar.f(surfaceTexture);
        }
    }

    public final void i(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8, float[] fArr2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), fArr2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            GLES20.glBindFramebuffer(36160, i3);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            if (this.D) {
                if (z) {
                    int i9 = this.n;
                    int i10 = this.o;
                    if (i9 > i10) {
                        int i11 = this.t;
                        float f2 = (i11 * 1.0f) / i9;
                        GLES20.glViewport(0, (this.u - ((int) (i10 * f2))) / 2, i11, (int) (i10 * f2));
                    } else {
                        GLES20.glViewport(0, 0, this.t, this.u);
                    }
                    this.s.drawFrame(this.p, fArr2);
                }
                if (z2) {
                    GLES20.glViewport(0, 0, this.t, this.u);
                } else {
                    GLES20.glViewport(i5 + this.A, ((this.u - i8) - i6) - this.B, i7, i8);
                }
                this.mFullScreen2D.drawFrame(i2, fArr);
            } else {
                GLES20.glViewport(0, 0, this.t, this.u);
                this.mFullScreen2D.drawFrame(i2, fArr);
                if (z) {
                    int i12 = i5 + this.A;
                    int i13 = this.u;
                    int i14 = this.o;
                    GLES20.glViewport(i12, ((i13 - i14) - i6) - this.B, this.n, i14);
                    this.s.drawFrame(this.p, fArr2);
                }
            }
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public boolean j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? (this.D && d(motionEvent)) || (!this.D && e(motionEvent)) : invokeL.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(c.a.a0.b.a.e eVar, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, eVar, i2, fArr) == null) && this.w && this.p != 0) {
            try {
                this.mTextureId = i2;
                this.q.updateTexImage();
                this.q.getTransformMatrix(this.r);
                f();
                i(i2, fArr, this.z, this.x, this.f31012j, this.k, this.l, this.m, this.r, !this.F, false);
                GLES20.glViewport(0, 0, this.t, this.u);
                this.mFullScreen2D.drawFrame(this.x, GlUtil.IDENTITY_MATRIX);
                i(i2, fArr, this.z, this.x, this.f31012j, this.k, this.l, this.m, this.r, false, true);
            } catch (Throwable th) {
                c.a.x0.t.c.c("followvideo", th.toString());
            }
        }
    }
}
