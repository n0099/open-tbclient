package com.baidu.ar.vo.b;

import android.opengl.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.algovo.ARVOJniClient;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.slam.TrackModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c implements a, b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "c";
    public static final float[] yI;
    public transient /* synthetic */ FieldHolder $fh;
    public d yJ;
    public com.baidu.ar.algo.a yK;
    public boolean yL;
    public float[] yM;
    public float yN;
    public boolean yO;
    public float yP;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647272373, "Lcom/baidu/ar/vo/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-647272373, "Lcom/baidu/ar/vo/b/c;");
                return;
            }
        }
        yI = new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public c(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.yL = false;
        this.yN = 0.0f;
        this.yO = false;
        this.yJ = dVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, fArr, fArr2) == null) {
            float[] fArr3 = new float[16];
            float[] fArr4 = new float[16];
            Matrix.invertM(fArr3, 0, fArr2, 0);
            Matrix.multiplyMM(fArr4, 0, yI, 0, fArr3, 0);
            Matrix.invertM(fArr3, 0, fArr4, 0);
            fArr[0] = fArr3[0];
            fArr[1] = fArr3[1];
            fArr[2] = fArr3[2];
            fArr[4] = fArr3[4];
            fArr[5] = fArr3[5];
            fArr[6] = fArr3[6];
            fArr[8] = fArr3[8];
            fArr[9] = fArr3[9];
            fArr[10] = fArr3[10];
            float scale = this.yK.getScale();
            float f2 = fArr[12];
            float f3 = this.yP;
            fArr[12] = f2 * f3 * scale;
            fArr[13] = fArr[13] * f3 * scale;
            fArr[14] = fArr[14] * f3 * scale;
            Matrix.rotateM(fArr, 0, this.yN - 90.0f, 0.0f, 0.0f, 1.0f);
        }
    }

    private float[] p(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fArr)) == null) {
            if (this.yN == 0.0f) {
                this.yN = this.yJ.yS.getAngle();
            }
            float[] fArr2 = new float[16];
            float[] fArr3 = new float[16];
            Matrix.invertM(fArr2, 0, fArr, 0);
            Matrix.multiplyMM(fArr3, 0, yI, 0, fArr2, 0);
            return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
        }
        return (float[]) invokeL.objValue;
    }

    @Override // com.baidu.ar.vo.b.b
    public void a(FramePixels framePixels, ICallbackWith<f> iCallbackWith) {
        d dVar;
        float[] hb;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, framePixels, iCallbackWith) == null) || framePixels == null || !this.yL || (dVar = this.yJ) == null || (hb = dVar.yS.hb()) == null || hb.length == 0) {
            return;
        }
        if (!this.yO) {
            iCallbackWith.run(new f(framePixels.getTimestamp()));
            return;
        }
        this.yM = hb;
        ARVOJniClient.track(framePixels.getPixelsAddress(), p(hb));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.yM);
        }
        g gVar = new g(framePixels.getTimestamp());
        gVar.F(true);
        gVar.setTracked(true);
        gVar.b(fetchModelPose);
        iCallbackWith.run(new f(gVar));
    }

    @Override // com.baidu.ar.vo.b.a
    public float[] a(float f2, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), fArr})) == null) {
            if (this.yL) {
                float[] fArr2 = new float[2];
                return new float[]{ARVOJniClient.calModelPosition(this.yK.aj(), f2, p(fArr), fArr2), fArr2[0], fArr2[1]};
            }
            return null;
        }
        return (float[]) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.vo.b.a
    public void hi() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.yL && this.yO) {
            ARVOJniClient.removeAllModel();
            this.yO = false;
        }
    }

    @Override // com.baidu.ar.vo.b.b
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d dVar = this.yJ;
            this.yK = com.baidu.ar.algo.a.a(dVar.yQ, dVar.yR, false);
            try {
                com.baidu.ar.libloader.a.require("ardatabasic");
                com.baidu.ar.libloader.a.require("module_basic");
                com.baidu.ar.libloader.a.require("module_vo");
                this.yL = ARVOJniClient.start(this.yK.width, this.yK.height, this.yK.aj(), this.yK.ak());
            } catch (UnsatisfiedLinkError e2) {
                String str = TAG;
                com.baidu.ar.h.b.b(str, "slam algo UnsatisfiedLinkError " + e2.getMessage());
            }
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public int insertModel(String str, int i, int i2, float[] fArr, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), fArr, Float.valueOf(f2)})) == null) {
            if (this.yL) {
                this.yP = f2;
                if (fArr == null) {
                    fArr = yI;
                }
                int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
                this.yO = true;
                return insertModel;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.yL) {
                ARVOJniClient.stop();
                this.yL = false;
            }
            this.yJ = null;
        }
    }
}
