package c.a.p0.q4.n.c.d;

import android.opengl.Matrix;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
/* loaded from: classes2.dex */
public class c extends BaseOutputSurface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public MultiMediaData f17836b;

    public c(int i, int i2, boolean z, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new float[16];
        this.f17836b = new MultiMediaData();
        init(i, i2, z, handler);
        this.mFullScreenEXT.setMirror(true);
        Matrix.orthoM(this.a, 0, 0.0f, i, 0.0f, i2, -1.0f, 1.0f);
    }

    public void a(int i, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            MultiMediaData multiMediaData = this.f17836b;
            multiMediaData.type = 1;
            multiMediaData.width = i;
            multiMediaData.height = i2;
            multiMediaData.rotation = f2;
            if (((f2 == 90.0f || f2 == 270.0f) ? (i2 * 1.0f) / i : (i * 1.0f) / i2) <= (this.mVideoWidth * 1.0f) / this.mVideoHeight) {
                this.f17836b.scaleType = "center_crop";
            } else {
                this.f17836b.scaleType = "center_inside";
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.drawImage(i);
            if (this.mFullScreenEXT == null) {
                return;
            }
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.multiplyMM(fArr, 0, this.a, 0, MultiMediaPreProcessor.calculateModelView(this.f17836b, this.mVideoWidth, this.mVideoHeight, 0, 0), 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
            this.mFullScreenEXT.setAngle(180.0f);
            this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
            Matrix.setIdentityM(fArr, 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
        }
    }
}
