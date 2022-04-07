package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FAUImage;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "e";
    public transient /* synthetic */ FieldHolder $fh;
    public FaceAlgoConfig op;
    public FAUImage oq;
    public AlgoHandleController or;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1258542339, "Lcom/baidu/ar/face/detector/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1258542339, "Lcom/baidu/ar/face/detector/e;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ByteBuffer byteBuffer) {
        super(byteBuffer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ByteBuffer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(int i, int i2, boolean z, int i3, boolean z2, long j) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            dJ();
            this.or = this.oc.dY();
            if (this.oc.ee() && (algoHandleController = this.or) != null) {
                this.oh = algoHandleController.createHandle();
                this.oc.dY().setHandleInput(this.oh, 10, j, 2, i, i2, z, i3, z2, this.oe);
            }
            this.oq = new FAUImage(this.oe, i, i2, 2);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.ar.h.b.l(TAG, "detect_frame track task executing before createFrame");
            this.mf = FaceJniClient.createFrame(this.oq);
            FaceAlgoData faceAlgoData = new FaceAlgoData();
            this.ob = faceAlgoData;
            faceAlgoData.setAlgoConfig(this.op);
            this.ob.setFaceFrame(new FaceFrame());
            AlgoHandleController algoHandleController = this.or;
            if (algoHandleController != null) {
                long j = this.oh;
                if (j > 0) {
                    algoHandleController.setHandleFaceHandle(j, this.mf);
                }
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dG();
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "create", SystemClock.elapsedRealtime() - this.of, 1);
            k kVar = this.od;
            if (kVar != null) {
                kVar.b(this.og);
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.dJ();
            this.op = this.oc.ec().cloneInstance();
        }
    }

    public long dN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.oh : invokeV.longValue;
    }
}
