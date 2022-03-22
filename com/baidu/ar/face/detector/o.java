package com.baidu.ar.face.detector;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.detector.FaceDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class o extends com.baidu.ar.c.a<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String oj;
    public a oo;
    public FaceDetector.a oy;

    public o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.oj = "face_track";
        this.oo = fVar;
        setPriority(10);
    }

    public o(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oj = "face_track";
        this.oo = nVar;
        setPriority(10);
    }

    private void b(FaceAlgoData faceAlgoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, faceAlgoData) == null) {
            if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || faceAlgoData.getFaceFrame().getProcessResult() != 200 || faceAlgoData.getFaceFrame().getTrackedPointsList().size() < this.oo.dI().dX().dR()) {
                this.oo.dI().dX().dQ();
            } else {
                this.oo.dI().dX().dP();
            }
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.oy.f(com.baidu.ar.face.c.a(aVar.ob, aVar.og, aVar.mf, aVar.oh, aVar.oe, aVar.timestamp, aVar.oi));
        }
    }

    public void aa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.oj = str;
        }
    }

    public void b(FaceDetector.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.oy = aVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: eD */
    public n ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n nVar = new n(this.oo.oe);
            nVar.a(this.oo.ob);
            nVar.g(this.oo.mf);
            nVar.p(this.oo.oh);
            nVar.setTimestamp(this.oo.timestamp);
            nVar.setFrontCamera(this.oo.oi);
            nVar.a(this.oo.oc);
            nVar.oj = this.oj;
            nVar.dJ();
            nVar.dH();
            b(nVar.ob);
            if (nVar.ob != null) {
                return nVar;
            }
            a(this.oo);
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.oj : (String) invokeV.objValue;
    }
}
