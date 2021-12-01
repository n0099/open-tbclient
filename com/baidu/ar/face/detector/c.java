package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "c";
    public transient /* synthetic */ FieldHolder $fh;
    public long om;
    public int on;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1258542401, "Lcom/baidu/ar/face/detector/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1258542401, "Lcom/baidu/ar/face/detector/c;");
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
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ar.b.a.as().a(14, true);
            FaceAlgoData animateFace = FaceJniClient.animateFace(this.om, this.ob, this.mf);
            this.ob = animateFace;
            if (animateFace.getFaceFrame().getTriggersList() != null) {
                String str = TAG;
                com.baidu.ar.h.b.k(str, "detect_frame animate task executing triggers size:" + this.ob.getFaceFrame().getTriggersList().size());
            }
            com.baidu.ar.b.a.as().a(14, false);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dG();
            FaceAlgoData faceAlgoData = this.ob;
            if (faceAlgoData != null && faceAlgoData.getFaceFrame() != null) {
                if (this.ob.getFaceFrame().getProcessResult() != 200) {
                    this.on = 0;
                }
                if (this.ob.getFaceFrame().getFaceBoxes() != null) {
                    int size = this.ob.getFaceFrame().getFaceBoxes().size();
                    this.on = size;
                    if (size > 4) {
                        this.on = 4;
                    }
                }
            }
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "animate", SystemClock.elapsedRealtime() - this.of, 1);
            k kVar = this.od;
            if (kVar != null) {
                kVar.d(this.og);
            }
            this.oc.eg();
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dJ();
            this.om = this.oc.eb();
        }
    }

    public int dL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.on : invokeV.intValue;
    }
}
