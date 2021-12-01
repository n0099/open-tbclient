package com.baidu.ar.face.detector;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;
    public g oB;
    public long oC;
    public long oD;
    public long oE;
    public boolean oF;
    public long oG;
    public long oH;
    public k oI;
    public FaceAlgoConfig oJ;
    public boolean oK;
    public boolean oL;
    public String oM;
    public String oN;
    public String oO;
    public String[] oP;
    public String oQ;
    public String oR;
    public String oS;
    public String oT;

    public i() {
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
        this.oC = 0L;
        this.oD = 0L;
        this.oE = 0L;
        this.oF = true;
        this.oI = new k();
        this.oJ = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);
        this.oK = true;
        this.oL = false;
        this.oB = new g();
        com.baidu.ar.h.b.b("algo", "environment version= " + com.baidu.ar.h.c.getVersionCode() + ", face = " + FaceJniClient.getFaceAlgoVersion());
    }

    private String ab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? str.startsWith("file:///android_asset/") ? str.replace("file:///android_asset/", "") : str : (String) invokeL.objValue;
    }

    private void ei() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                if (this.oC > 0) {
                    FaceJniClient.releaseDetectCore(this.oC);
                }
                if (this.oD > 0) {
                    FaceJniClient.releaseTrackCore(this.oD);
                }
                if (this.oE > 0) {
                    FaceJniClient.releaseAnimateCore(this.oE);
                }
                this.oC = 0L;
                this.oD = 0L;
                this.oE = 0L;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void setAutoCalibrate(boolean z) {
        FaceAlgoConfig faceAlgoConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || (faceAlgoConfig = this.oJ) == null) {
            return;
        }
        faceAlgoConfig.setAutoCalibrate(z);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.oJ == null) {
            return;
        }
        if (z && !ARAuth.checkFeatureAuth(FeatureCodes.FACE_DUMOJI)) {
            com.baidu.ar.h.b.c("bdar-face", "setAnimojiMode(true) hasn't auth");
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setAnimojiMode:" + z);
        this.oJ.setIsAnimojiMode(z);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedRefineMouth:" + z);
        this.oJ.setNeedRefineMouth(z);
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedExpression:" + z);
        this.oJ.setNeedExpression(z);
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "trackMode:" + i2);
        this.oJ.setRunningMode(i2);
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.oB.F(i2);
            if (this.oJ != null) {
                com.baidu.ar.h.b.c("bdar-face", "setMaxTrackingFace:" + i2);
                this.oJ.setMaxTrackingFace(i2);
            }
        }
    }

    public i a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jVar)) == null) {
            this.oM = jVar.en();
            this.oN = jVar.eo();
            this.oO = jVar.ep();
            this.oP = new String[]{jVar.eq(), jVar.er(), jVar.es()};
            this.oQ = jVar.et();
            this.oR = jVar.eu();
            this.oS = jVar.ev();
            this.oT = jVar.ew();
            return this;
        }
        return (i) invokeL.objValue;
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "mTrackingSmoothAlpha:" + f2 + " mTrackingSmoothThreshold:" + f3);
        this.oJ.setTrackingSmoothAlpha(f2);
        this.oJ.setTrackingSmoothThreshold(f3);
    }

    public void a(AlgoHandleController algoHandleController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, algoHandleController) == null) {
            this.cb = algoHandleController;
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
        this.oJ.setAnimateRunningMode(z, z2, z3);
    }

    public boolean a(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (!this.oL) {
                com.baidu.ar.h.b.k("bdar-face", "detect_frame track task executing modelLoad failed");
                return true;
            }
            if ((!this.oF) == z) {
                this.oJ.setForceLost(true);
                this.oF = z;
            } else {
                this.oJ.setForceLost(false);
            }
            this.oJ.setMirror(false);
            this.oJ.setTrackingRT(com.baidu.ar.face.c.D(i2));
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            com.baidu.ar.h.b.j("bdar-face", "[FaceHandlerThread] destroy handle:" + j2);
            FaceJniClient.destoryFrame(j2);
        }
    }

    public void c(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) {
            g gVar = this.oB;
            if (gVar != null) {
                gVar.b(iArr);
            } else {
                com.baidu.ar.h.b.b("bdar-face", "mDetectSkiper is null when being configured");
            }
        }
    }

    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f2) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "mTrackingMouthThreshold:" + f2);
        this.oJ.setTrackingMouthThreshold(f2);
    }

    public i dV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (com.baidu.ar.face.c.a(this.oM, this.oN, this.oO, this.oP, this.oQ, this.oR, this.oS, this.oT)) {
                com.baidu.ar.h.b.b("bdar-face", "init error! check face model!");
                return null;
            }
            com.baidu.ar.h.b.c("bdar-face", "detect_frame load facemodel");
            setAutoCalibrate(true);
            com.baidu.ar.h.b.c("bdar-face", "imbin:" + this.oM + "\nDetect:" + this.oN + "\nTrack0:" + this.oO + "\nTrack1:" + Arrays.toString(this.oP) + "\nTrack2:" + this.oQ + "\nTrack3:" + this.oR + "\nexpression:" + this.oS + "\nmouth:" + this.oT);
            String[] strArr = {"detect", ab(this.oN)};
            String[] strArr2 = {"angle", ab(this.oO), "heavy", ab(this.oP[0]), "medium", ab(this.oP[1]), "lite", ab(this.oP[2]), com.baidu.pass.biometrics.face.liveness.b.a.b0, ab(this.oT), "eyes", ab(this.oQ), "iris", ab(this.oR)};
            String[] strArr3 = {"animate", ab(this.oM), "expression", ab(this.oS)};
            this.oC = this.oN.startsWith("file:///android_asset/") ? FaceJniClient.createDetectCoreFromAssetDir(strArr) : FaceJniClient.createDetectCore(strArr);
            this.oD = this.oO.startsWith("file:///android_asset/") ? FaceJniClient.createTrackCoreFromAssetDir(strArr2) : FaceJniClient.createTrackCore(strArr2);
            this.oE = this.oM.startsWith("file:///android_asset/") ? FaceJniClient.createAnimateCoreFromAssetDir(strArr3) : FaceJniClient.createAnimateCore(strArr3);
            com.baidu.ar.h.b.c("bdar-face", "face init mDetectHandle:" + this.oC + " mTrackHandle:" + this.oD + " mAnimateHandle:" + this.oE);
            this.oL = (((this.oC > 0L ? 1 : (this.oC == 0L ? 0 : -1)) <= 0 || (this.oD > 0L ? 1 : (this.oD == 0L ? 0 : -1)) <= 0 || (this.oE > 0L ? 1 : (this.oE == 0L ? 0 : -1)) <= 0) ? 'h' : 'd') == 'd';
            return this;
        }
        return (i) invokeV.objValue;
    }

    public boolean dW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.oL : invokeV.booleanValue;
    }

    public g dX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.oB : (g) invokeV.objValue;
    }

    public AlgoHandleController dY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.cb : (AlgoHandleController) invokeV.objValue;
    }

    public long dZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.oC : invokeV.longValue;
    }

    public long ea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.oD : invokeV.longValue;
    }

    public long eb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.oE : invokeV.longValue;
    }

    public FaceAlgoConfig ec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.oJ : (FaceAlgoConfig) invokeV.objValue;
    }

    public k ed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.oI : (k) invokeV.objValue;
    }

    public boolean ee() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.oK : invokeV.booleanValue;
    }

    public i ef() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.oG > 0 && (kVar = this.oI) != null) {
                kVar.e(System.currentTimeMillis() - this.oG);
            }
            this.oG = System.currentTimeMillis();
            return this;
        }
        return (i) invokeV.objValue;
    }

    public i eg() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.oH > 0 && (kVar = this.oI) != null) {
                kVar.f(System.currentTimeMillis() - this.oH);
            }
            this.oH = System.currentTimeMillis();
            return this;
        }
        return (i) invokeV.objValue;
    }

    public boolean eh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? dW() : invokeV.booleanValue;
    }

    public void q(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) || (algoHandleController = this.cb) == null) {
            return;
        }
        algoHandleController.destroyHandle(j2);
    }

    public boolean release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ei();
            k kVar = this.oI;
            if (kVar != null) {
                kVar.ez();
                this.oI = null;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setContext(Context context) {
        Context context2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, context) == null) || (context2 = (Context) new WeakReference(context).get()) == null) {
            return;
        }
        FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
    }

    public void setNeedHeadPose(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedHeadPose:" + z);
        this.oJ.setNeedHeadPose(z);
    }

    public void setNeedSkeleton(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedSkeleton:" + z);
        this.oJ.setNeedSkeleton(z);
    }

    public void setNeedTriggers(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedTriggers:" + z);
        this.oJ.setNeedTriggers(z);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || this.oJ == null) {
            return;
        }
        com.baidu.ar.h.b.c("bdar-face", "setNeedRefineEyes:" + z);
        this.oJ.setNeedRefineEyes(z);
    }
}
