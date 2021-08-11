package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.face.algo.FaceAlgoData;
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
/* loaded from: classes5.dex */
public class n extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "n";
    public transient /* synthetic */ FieldHolder $fh;
    public long pK;
    public long time;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1258542060, "Lcom/baidu/ar/face/detector/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1258542060, "Lcom/baidu/ar/face/detector/n;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ByteBuffer byteBuffer) {
        super(byteBuffer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ByteBuffer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ar.b.a.as().a(13, true);
            this.time = System.currentTimeMillis();
            this.ob = FaceJniClient.trackFace(this.pK, this.ob, this.mf);
            com.baidu.ar.h.b.k(TAG, "track-time= " + (System.currentTimeMillis() - this.time));
            com.baidu.ar.h.b.c(TAG, "detect_frame track task executing");
            String str = "face track: " + this.mf + "   ,  " + this.pK;
            com.baidu.ar.b.a.as().a(13, false);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dG();
            FaceAlgoData faceAlgoData = this.ob;
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - this.of, (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || this.ob.getFaceFrame().getFaceBoxes() == null) ? 0 : this.ob.getFaceFrame().getFaceBoxes().size());
            k kVar = this.od;
            if (kVar != null) {
                kVar.c(this.og);
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dJ();
            this.pK = this.oc.ea();
        }
    }

    public void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.oh = j2;
        }
    }

    public void setFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.oi = z;
        }
    }

    public void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.timestamp = j2;
        }
    }
}
