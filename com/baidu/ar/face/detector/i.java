package com.baidu.ar.face.detector;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceJniClient;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class i {
    private AlgoHandleController cb;
    private long oG;
    private long oH;
    private String oM;
    private String oN;
    private String oO;
    private String[] oP;
    private String oQ;
    private String oR;
    private String oS;
    private String oT;
    private long oC = 0;
    private long oD = 0;
    private long oE = 0;
    private boolean oF = true;
    private k oI = new k();
    private FaceAlgoConfig oJ = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);
    private boolean oK = true;
    private boolean oL = false;
    private g oB = new g();

    public i() {
        com.baidu.ar.h.b.b("algo", "environment version= " + com.baidu.ar.h.c.getVersionCode() + ", face = " + FaceJniClient.getFaceAlgoVersion());
    }

    private String ab(String str) {
        return str.startsWith("file:///android_asset/") ? str.replace("file:///android_asset/", "") : str;
    }

    private void ei() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAutoCalibrate(boolean z) {
        if (this.oJ != null) {
            this.oJ.setAutoCalibrate(z);
        }
    }

    public void A(boolean z) {
        if (this.oJ != null) {
            if (z && !ARAuth.checkFeatureAuth(FeatureCodes.FACE_DUMOJI)) {
                com.baidu.ar.h.b.c("bdar-face", "setAnimojiMode(true) hasn't auth");
                return;
            }
            com.baidu.ar.h.b.c("bdar-face", "setAnimojiMode:" + z);
            this.oJ.setIsAnimojiMode(z);
        }
    }

    public void B(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedRefineMouth:" + z);
            this.oJ.setNeedRefineMouth(z);
        }
    }

    public void C(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedExpression:" + z);
            this.oJ.setNeedExpression(z);
        }
    }

    public void G(int i) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "trackMode:" + i);
            this.oJ.setRunningMode(i);
        }
    }

    public void H(int i) {
        this.oB.F(i);
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setMaxTrackingFace:" + i);
            this.oJ.setMaxTrackingFace(i);
        }
    }

    public i a(j jVar) {
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

    public void a(float f, float f2) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "mTrackingSmoothAlpha:" + f + " mTrackingSmoothThreshold:" + f2);
            this.oJ.setTrackingSmoothAlpha(f);
            this.oJ.setTrackingSmoothThreshold(f2);
        }
    }

    public void a(AlgoHandleController algoHandleController) {
        this.cb = algoHandleController;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
            this.oJ.setAnimateRunningMode(z, z2, z3);
        }
    }

    public boolean a(boolean z, int i) {
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
        this.oJ.setTrackingRT(com.baidu.ar.face.c.D(i));
        return false;
    }

    public void b(long j) {
        com.baidu.ar.h.b.j("bdar-face", "[FaceHandlerThread] destroy handle:" + j);
        FaceJniClient.destoryFrame(j);
    }

    public void c(int[] iArr) {
        if (this.oB != null) {
            this.oB.b(iArr);
        } else {
            com.baidu.ar.h.b.b("bdar-face", "mDetectSkiper is null when being configured");
        }
    }

    public void d(float f) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "mTrackingMouthThreshold:" + f);
            this.oJ.setTrackingMouthThreshold(f);
        }
    }

    public i dV() {
        if (com.baidu.ar.face.c.a(this.oM, this.oN, this.oO, this.oP, this.oQ, this.oR, this.oS, this.oT)) {
            com.baidu.ar.h.b.b("bdar-face", "init error! check face model!");
            return null;
        }
        com.baidu.ar.h.b.c("bdar-face", "detect_frame load facemodel");
        setAutoCalibrate(true);
        com.baidu.ar.h.b.c("bdar-face", "imbin:" + this.oM + "\nDetect:" + this.oN + "\nTrack0:" + this.oO + "\nTrack1:" + Arrays.toString(this.oP) + "\nTrack2:" + this.oQ + "\nTrack3:" + this.oR + "\nexpression:" + this.oS + "\nmouth:" + this.oT);
        String[] strArr = {"detect", ab(this.oN)};
        String[] strArr2 = {"angle", ab(this.oO), "heavy", ab(this.oP[0]), "medium", ab(this.oP[1]), "lite", ab(this.oP[2]), com.baidu.pass.biometrics.face.liveness.c.a.i, ab(this.oT), "eyes", ab(this.oQ), "iris", ab(this.oR)};
        String[] strArr3 = {"animate", ab(this.oM), "expression", ab(this.oS)};
        this.oC = this.oN.startsWith("file:///android_asset/") ? FaceJniClient.createDetectCoreFromAssetDir(strArr) : FaceJniClient.createDetectCore(strArr);
        this.oD = this.oO.startsWith("file:///android_asset/") ? FaceJniClient.createTrackCoreFromAssetDir(strArr2) : FaceJniClient.createTrackCore(strArr2);
        this.oE = this.oM.startsWith("file:///android_asset/") ? FaceJniClient.createAnimateCoreFromAssetDir(strArr3) : FaceJniClient.createAnimateCore(strArr3);
        char c = 'd';
        com.baidu.ar.h.b.c("bdar-face", "face init mDetectHandle:" + this.oC + " mTrackHandle:" + this.oD + " mAnimateHandle:" + this.oE);
        this.oL = ((this.oC <= 0 || this.oD <= 0 || this.oE <= 0) ? 'h' : 'h') == 'd';
        return this;
    }

    public boolean dW() {
        return this.oL;
    }

    public g dX() {
        return this.oB;
    }

    public AlgoHandleController dY() {
        return this.cb;
    }

    public long dZ() {
        return this.oC;
    }

    public long ea() {
        return this.oD;
    }

    public long eb() {
        return this.oE;
    }

    public FaceAlgoConfig ec() {
        return this.oJ;
    }

    public k ed() {
        return this.oI;
    }

    public boolean ee() {
        return this.oK;
    }

    public i ef() {
        if (this.oG > 0 && this.oI != null) {
            this.oI.e(System.currentTimeMillis() - this.oG);
        }
        this.oG = System.currentTimeMillis();
        return this;
    }

    public i eg() {
        if (this.oH > 0 && this.oI != null) {
            this.oI.f(System.currentTimeMillis() - this.oH);
        }
        this.oH = System.currentTimeMillis();
        return this;
    }

    public boolean eh() {
        return dW();
    }

    public void q(long j) {
        if (this.cb != null) {
            this.cb.destroyHandle(j);
        }
    }

    public boolean release() {
        ei();
        if (this.oI != null) {
            this.oI.ez();
            this.oI = null;
            return true;
        }
        return true;
    }

    public void setContext(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 != null) {
            FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
        }
    }

    public void setNeedHeadPose(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedHeadPose:" + z);
            this.oJ.setNeedHeadPose(z);
        }
    }

    public void setNeedSkeleton(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedSkeleton:" + z);
            this.oJ.setNeedSkeleton(z);
        }
    }

    public void setNeedTriggers(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedTriggers:" + z);
            this.oJ.setNeedTriggers(z);
        }
    }

    public void z(boolean z) {
        if (this.oJ != null) {
            com.baidu.ar.h.b.c("bdar-face", "setNeedRefineEyes:" + z);
            this.oJ.setNeedRefineEyes(z);
        }
    }
}
