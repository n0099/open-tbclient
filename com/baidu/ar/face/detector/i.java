package com.baidu.ar.face.detector;

import android.content.Context;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceJniClient;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class i {
    private AlgoHandleController bY;
    private String oA;
    private String oB;
    private String oC;
    private String oD;
    private long oq;
    private long or;
    private String ow;
    private String ox;
    private String oy;
    private String[] oz;
    private long om = 0;
    private long on = 0;
    private long oo = 0;
    private boolean op = true;
    private k os = new k();
    private FaceAlgoConfig ot = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);
    private boolean ou = true;
    private boolean ov = false;
    private g ol = new g();

    public i() {
        com.baidu.ar.g.b.b("algo", "environment version= " + com.baidu.ar.g.c.getVersionCode() + ", face = " + FaceJniClient.getFaceAlgoVersion());
    }

    private String Y(String str) {
        return str.startsWith("file:///android_asset/") ? str.replace("file:///android_asset/", "") : str;
    }

    private void ej() {
        try {
            if (this.om > 0) {
                FaceJniClient.releaseDetectCore(this.om);
            }
            if (this.on > 0) {
                FaceJniClient.releaseTrackCore(this.on);
            }
            if (this.oo > 0) {
                FaceJniClient.releaseAnimateCore(this.oo);
            }
            this.om = 0L;
            this.on = 0L;
            this.oo = 0L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAutoCalibrate(boolean z) {
        if (this.ot != null) {
            this.ot.setAutoCalibrate(z);
        }
    }

    public void B(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedRefineEyes:" + z);
            this.ot.setNeedRefineEyes(z);
        }
    }

    public void C(boolean z) {
        if (this.ot != null) {
            if (z && !com.baidu.ar.auth.a.checkFeatureAuth(FeatureCodes.FACE_DUMOJI)) {
                com.baidu.ar.g.b.c("bdar-face", "setAnimojiMode(true) hasn't auth");
                return;
            }
            com.baidu.ar.g.b.c("bdar-face", "setAnimojiMode:" + z);
            this.ot.setIsAnimojiMode(z);
        }
    }

    public void D(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedRefineMouth:" + z);
            this.ot.setNeedRefineMouth(z);
        }
    }

    public void E(int i) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "trackMode:" + i);
            this.ot.setRunningMode(i);
        }
    }

    public void E(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedExpression:" + z);
            this.ot.setNeedExpression(z);
        }
    }

    public void F(int i) {
        this.ol.D(i);
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setMaxTrackingFace:" + i);
            this.ot.setMaxTrackingFace(i);
        }
    }

    public i a(j jVar) {
        this.ow = jVar.eo();
        this.ox = jVar.ep();
        this.oy = jVar.eq();
        this.oz = new String[]{jVar.er(), jVar.es(), jVar.et()};
        this.oA = jVar.eu();
        this.oB = jVar.ev();
        this.oC = jVar.ew();
        this.oD = jVar.ex();
        return this;
    }

    public void a(float f, float f2) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "mTrackingSmoothAlpha:" + f + " mTrackingSmoothThreshold:" + f2);
            this.ot.setTrackingSmoothAlpha(f);
            this.ot.setTrackingSmoothThreshold(f2);
        }
    }

    public void a(AlgoHandleController algoHandleController) {
        this.bY = algoHandleController;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
            this.ot.setAnimateRunningMode(z, z2, z3);
        }
    }

    public boolean a(boolean z, int i) {
        if (!this.ov) {
            com.baidu.ar.g.b.k("bdar-face", "detect_frame track task executing modelLoad failed");
            return true;
        }
        if ((!this.op) == z) {
            this.ot.setForceLost(true);
            this.op = z;
        } else {
            this.ot.setForceLost(false);
        }
        this.ot.setMirror(false);
        this.ot.setTrackingRT(com.baidu.ar.face.c.B(i));
        return false;
    }

    public void b(long j) {
        com.baidu.ar.g.b.j("bdar-face", "[FaceHandlerThread] destroy handle:" + j);
        FaceJniClient.destoryFrame(j);
    }

    public void c(int[] iArr) {
        if (this.ol != null) {
            this.ol.b(iArr);
        } else {
            com.baidu.ar.g.b.b("bdar-face", "mDetectSkiper is null when being configured");
        }
    }

    public i dW() {
        if (com.baidu.ar.face.c.a(this.ow, this.ox, this.oy, this.oz, this.oA, this.oB, this.oC, this.oD)) {
            com.baidu.ar.g.b.b("bdar-face", "init error! check face model!");
            return null;
        }
        com.baidu.ar.g.b.c("bdar-face", "detect_frame load facemodel");
        setAutoCalibrate(true);
        com.baidu.ar.g.b.c("bdar-face", "imbin:" + this.ow + "\nDetect:" + this.ox + "\nTrack0:" + this.oy + "\nTrack1:" + Arrays.toString(this.oz) + "\nTrack2:" + this.oA + "\nTrack3:" + this.oB + "\nexpression:" + this.oC + "\nmouth:" + this.oD);
        String[] strArr = {"detect", Y(this.ox)};
        String[] strArr2 = {"angle", Y(this.oy), "heavy", Y(this.oz[0]), "medium", Y(this.oz[1]), "lite", Y(this.oz[2]), com.baidu.pass.biometrics.face.liveness.c.a.i, Y(this.oD), "eyes", Y(this.oA), "iris", Y(this.oB)};
        String[] strArr3 = {"animate", Y(this.ow), "expression", Y(this.oC)};
        this.om = this.ox.startsWith("file:///android_asset/") ? FaceJniClient.createDetectCoreFromAssetDir(strArr) : FaceJniClient.createDetectCore(strArr);
        this.on = this.oy.startsWith("file:///android_asset/") ? FaceJniClient.createTrackCoreFromAssetDir(strArr2) : FaceJniClient.createTrackCore(strArr2);
        this.oo = this.ow.startsWith("file:///android_asset/") ? FaceJniClient.createAnimateCoreFromAssetDir(strArr3) : FaceJniClient.createAnimateCore(strArr3);
        char c = 'd';
        com.baidu.ar.g.b.c("bdar-face", "face init mDetectHandle:" + this.om + " mTrackHandle:" + this.on + " mAnimateHandle:" + this.oo);
        this.ov = ((this.om <= 0 || this.on <= 0 || this.oo <= 0) ? 'h' : 'h') == 'd';
        return this;
    }

    public boolean dX() {
        return this.ov;
    }

    public g dY() {
        return this.ol;
    }

    public AlgoHandleController dZ() {
        return this.bY;
    }

    public void e(float f) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "mTrackingMouthThreshold:" + f);
            this.ot.setTrackingMouthThreshold(f);
        }
    }

    public long ea() {
        return this.om;
    }

    public long eb() {
        return this.on;
    }

    public long ec() {
        return this.oo;
    }

    public FaceAlgoConfig ed() {
        return this.ot;
    }

    public k ee() {
        return this.os;
    }

    public boolean ef() {
        return this.ou;
    }

    public i eg() {
        if (this.oq > 0 && this.os != null) {
            this.os.e(System.currentTimeMillis() - this.oq);
        }
        this.oq = System.currentTimeMillis();
        return this;
    }

    public i eh() {
        if (this.or > 0 && this.os != null) {
            this.os.f(System.currentTimeMillis() - this.or);
        }
        this.or = System.currentTimeMillis();
        return this;
    }

    public boolean ei() {
        return dX();
    }

    public boolean release() {
        ej();
        if (this.os != null) {
            this.os.eA();
            this.os = null;
            return true;
        }
        return true;
    }

    public void s(long j) {
        if (this.bY != null) {
            this.bY.destroyHandle(j);
        }
    }

    public void setContext(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 != null) {
            FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
        }
    }

    public void setNeedHeadPose(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedHeadPose:" + z);
            this.ot.setNeedHeadPose(z);
        }
    }

    public void setNeedSkeleton(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedSkeleton:" + z);
            this.ot.setNeedSkeleton(z);
        }
    }

    public void setNeedTriggers(boolean z) {
        if (this.ot != null) {
            com.baidu.ar.g.b.c("bdar-face", "setNeedTriggers:" + z);
            this.ot.setNeedTriggers(z);
        }
    }
}
