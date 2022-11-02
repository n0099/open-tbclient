package com.baidu.ar.face.detector;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FaceDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bD;
    public boolean bn;
    public PixelReadParams ih;
    public i oA;
    public int oU;
    public j oV;
    public boolean oW;
    public int oX;
    public int oY;
    public long oZ;
    public a oy;
    public boolean oz;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceDetector pa;

        public a(FaceDetector faceDetector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceDetector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pa = faceDetector;
        }

        public void f(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
                com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) new b(mVar));
            }
        }
    }

    public FaceDetector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.oU = 11;
        this.oz = false;
        this.oW = false;
        this.bn = false;
        this.oX = 3;
        this.oy = new a(this);
        this.bD = null;
        this.oY = 0;
        this.oZ = 0L;
        com.baidu.ar.c.c.cd().a(this);
        this.ih = new PixelReadParams(PixelType.BGR);
        if (this.oA == null) {
            this.oA = new i();
        }
    }

    private boolean a(com.baidu.ar.c.a aVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, aVar, z)) == null) {
            if (z) {
                if (el()) {
                    return false;
                }
                if (aVar instanceof h) {
                    ((h) aVar).aa("additional_thread");
                    return true;
                } else if (aVar instanceof o) {
                    ((o) aVar).aa("additional_thread");
                    return true;
                } else if (aVar instanceof d) {
                    ((d) aVar).aa("additional_thread");
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private void e(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, mVar) == null) || this.mv == null || mVar == null) {
            return;
        }
        l lVar = new l(getName(), mVar);
        lVar.n(mVar.dN());
        if (this.bD != null && mVar.cY() > 0) {
            com.baidu.ar.arrender.n nVar = new com.baidu.ar.arrender.n();
            nVar.r(this.bD);
            nVar.g(mVar.cY());
            nVar.c(true);
            nVar.d(mVar.isFrontCamera());
            nVar.setTimestamp(mVar.getTimestamp());
            nVar.s(this.ih.getOutputWidth());
            nVar.t(this.ih.getOutputHeight());
            lVar.g(nVar);
        }
        if (mVar.getTimestamp() < 0 || Math.abs(this.oZ - mVar.getTimestamp()) > 99999999) {
            com.baidu.ar.h.b.c("FaceDetector", "time interval between framepixels is larger than 33 * 3ms");
        } else if (this.oZ >= mVar.getTimestamp()) {
            return;
        }
        com.baidu.ar.h.b.c("FaceDetector", "time_interval: " + String.valueOf(mVar.getTimestamp() - this.oZ));
        this.oZ = mVar.getTimestamp();
        this.mv.a(lVar);
    }

    private boolean el() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            boolean f = com.baidu.ar.b.a.as().f(11);
            int i = this.oY + 1;
            this.oY = i;
            if (f && i > 1) {
                this.oY = 0;
                return f;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.oz = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.oW = z;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            com.baidu.ar.h.b.l("FaceDetector", "detect_frame onCreateInitTask");
            com.baidu.ar.b.b.b bVar = new com.baidu.ar.b.b.b(this, this.oU) { // from class: com.baidu.ar.face.detector.FaceDetector.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetector pa;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.pa = this;
                }

                @Override // com.baidu.ar.b.b.b
                public int a(com.baidu.ar.mdl.a aVar) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                        this.pa.oA.a(this.pa.oV).dV();
                        if (this.pa.mv != null && this.pa.oA.dW()) {
                            this.pa.mv.a(new com.baidu.ar.d.l(this.pa.getName(), true, 10));
                        }
                        return this.pa.oA.dW() ? 0 : -1;
                    }
                    return invokeL2.intValue;
                }

                @Override // com.baidu.ar.c.a
                public String getTag() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return null;
                    }
                    return (String) invokeV.objValue;
                }
            };
            bVar.setPriority(10);
            return bVar;
        }
        return (com.baidu.ar.b.b.b) invokeL.objValue;
    }

    @Override // com.baidu.ar.b.a.a
    public void a(AlgoHandleController algoHandleController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, algoHandleController) == null) {
            this.oA.a(algoHandleController);
        }
    }

    public void a(a.C0059a c0059a, int i, com.baidu.ar.face.b bVar, a.b bVar2, String str) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{c0059a, Integer.valueOf(i), bVar, bVar2, str}) == null) {
            this.oA.G(i);
            if (c0059a != null) {
                this.oA.a(Float.parseFloat(c0059a.pR), Float.parseFloat(c0059a.pS));
                this.oA.d(Float.parseFloat(c0059a.pT));
            }
            this.oA.z(bVar.dy());
            this.oA.B(bVar.dz());
            this.oA.A(bVar.dx());
            this.oA.a(bVar.dt(), bVar.du(), bVar.dv());
            this.oA.C(bVar.dw());
            int dD = bVar.dD();
            if (!TextUtils.isEmpty(str)) {
                dD = bVar.dC() < bVar.dD() ? bVar.dC() : bVar.dD();
            }
            this.oA.H(dD);
            if (bVar2 == null || (iArr = bVar2.ot) == null) {
                return;
            }
            this.oA.c(iArr);
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.oV == null) {
            com.baidu.ar.h.b.b("FaceDetector", "setupFrameDetector mFaceParams is NULLLL");
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (!this.oA.eh() || com.baidu.ar.b.a.as().f(13) || com.baidu.ar.b.a.as().f(12)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.ar.c.c.cd().b(this);
            av();
            com.baidu.ar.d.e eVar = this.mv;
            if (eVar != null) {
                eVar.b(new com.baidu.ar.d.l(getName(), true));
            }
            com.baidu.ar.h.b.l("FaceDetector", "releaseFrameDetector");
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.face.detector.FaceDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FaceDetector pa;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.pa = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    this.pa.oA.release();
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }
        } : (com.baidu.ar.b.b.a) invokeV.objValue;
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.oU : invokeV.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.oA.b(j);
        }
    }

    public void b(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
            this.oV = jVar;
            this.ih.setOutputWidth(jVar.ex());
            this.ih.setOutputHeight(this.oV.ey());
            this.ih.setIsPortrait(true);
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, framePixels)) == null) {
            boolean c = com.baidu.ar.b.a.as().c(au());
            if (!c || framePixels == null) {
                com.baidu.ar.h.b.b("FaceDetector", "detect_frame detect frame failed isInitTaskFinished: " + c);
                if (framePixels != null) {
                    e(new m(framePixels.getTimestamp()));
                    return true;
                }
                return false;
            }
            this.oA.ef();
            if (!this.bn || this.oX >= 3) {
                h hVar = new h(framePixels.getPixelsAddress(), framePixels.getWidth(), framePixels.getHeight(), framePixels.getTimestamp(), framePixels.isFrontCamera(), this.oW ? -1 : framePixels.getOrientation().getDegree(), this.oz);
                hVar.a(this.oy);
                hVar.a(this.oA);
                return com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) hVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, framePixels)) == null) {
            return null;
        }
        return (com.baidu.ar.b.b.c) invokeL.objValue;
    }

    @Override // com.baidu.ar.d.j
    public PixelReadParams di() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.ih : (PixelReadParams) invokeV.objValue;
    }

    public void ej() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.bn = true;
            this.oX = 3;
        }
    }

    public void ek() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.bn = false;
        }
    }

    public i em() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.oA : (i) invokeV.objValue;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "FaceDetector" : (String) invokeV.objValue;
    }

    @CallBack
    public void onAnimateResult(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) new b(cVar));
        }
    }

    @CallBack
    public void onDetectResult(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            o oVar = new o(fVar);
            oVar.b(this.oy);
            com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) oVar);
        }
    }

    @CallBack
    public void onFaceAlgoResult(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mVar) == null) {
            e(mVar);
        }
    }

    @CallBack
    public void onTrackResult(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, nVar) == null) {
            if (!this.bn) {
                boolean f = com.baidu.ar.b.a.as().f(14);
                d dVar = new d(nVar);
                if (a(dVar, f)) {
                    com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) dVar);
                    return;
                }
                return;
            }
            int i = this.oX;
            if (i == 0) {
                this.oy.f(com.baidu.ar.face.c.a(nVar.ob, nVar.og, nVar.mf, nVar.oh, nVar.oe, nVar.timestamp, nVar.oi));
            } else if (i > 0) {
                this.oX = i - 1;
                o oVar = new o(nVar);
                oVar.b(this.oy);
                com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) oVar);
            }
        }
    }

    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            this.oA.setContext(context);
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.oA.q(j);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.bD = str;
        }
    }
}
