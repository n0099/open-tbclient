package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "f";
    public transient /* synthetic */ FieldHolder $fh;
    public long os;
    public long time;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1258542308, "Lcom/baidu/ar/face/detector/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1258542308, "Lcom/baidu/ar/face/detector/f;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ByteBuffer byteBuffer) {
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

    @Override // com.baidu.ar.face.detector.a
    public void dE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dE();
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.ar.b.a.as().a(12, true);
            this.time = System.currentTimeMillis();
            this.ob = FaceJniClient.detectFace(this.os, this.ob, this.mf);
            String str = TAG;
            com.baidu.ar.h.b.k(str, "detect-time= " + (System.currentTimeMillis() - this.time));
            String str2 = TAG;
            com.baidu.ar.h.b.l(str2, "detect_frame detect task executing faceboxes：" + this.ob.getFaceFrame().getFaceBoxes());
            com.baidu.ar.b.a.as().a(12, false);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dG();
            FaceAlgoData faceAlgoData = this.ob;
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ConstPath.KEY_DETECT, SystemClock.elapsedRealtime() - this.of, (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || this.ob.getFaceFrame().getFaceBoxes() == null) ? 0 : this.ob.getFaceFrame().getFaceBoxes().size());
            k kVar = this.od;
            if (kVar != null) {
                kVar.a(this.og);
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.dJ();
            this.os = this.oc.dZ();
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.oh = j;
        }
    }

    public void setFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.oi = z;
        }
    }

    public void setTimestamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.timestamp = j;
        }
    }
}
