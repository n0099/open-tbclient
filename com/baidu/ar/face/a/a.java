package com.baidu.ar.face.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FAUImage;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a mF = null;
    private AlgoHandleController bU;
    private c mH;
    private ByteBuffer mK;
    private long mL;
    private long nj;
    private long nk;
    private HandlerThread no;
    private HandlerC0059a np;
    private boolean mI = false;
    private boolean mJ = false;
    private boolean mM = true;
    private boolean mN = false;
    private long mO = 0;
    private int mP = 0;
    private int[] mQ = {3, 10, 10, 10, 10};
    private Thread mR = null;
    private Thread mS = null;
    private Thread mT = null;
    private boolean mU = true;
    private boolean mV = true;
    private boolean mW = true;
    private boolean mX = true;
    private boolean mY = true;
    private boolean mZ = true;
    private final List<b> na = Collections.synchronizedList(new ArrayList());
    private final List<b> nb = Collections.synchronizedList(new ArrayList());
    private int mPreviewWidth = 320;
    private int mPreviewHeight = 180;
    private long nc = 0;
    private long nd = 0;
    private long ne = 0;
    private int nf = 1;
    private int ng = 0;
    private volatile ArrayList<Long> nh = new ArrayList<>();
    private f ni = new f();
    private FaceAlgoConfig nl = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);
    private boolean nm = true;
    private long nn = 0;
    private FaceJniClient mG = new FaceJniClient();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.face.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class HandlerC0059a extends Handler {
        private boolean cs;

        public HandlerC0059a(Looper looper) {
            super(looper);
            this.cs = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cs) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1004) {
                this.cs = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private a() {
        StringBuilder append = new StringBuilder().append("environment version= ").append(com.baidu.ar.f.c.getVersionCode()).append(", face = ");
        FaceJniClient faceJniClient = this.mG;
        com.baidu.ar.f.b.b("algo", append.append(FaceJniClient.getFaceAlgoVersion()).toString());
    }

    private void a(long j, FaceAlgoData faceAlgoData, long j2, long j3, ByteBuffer byteBuffer, boolean z, long j4) {
        final h hVar = new h(j);
        hVar.a(faceAlgoData);
        hVar.i(j2);
        hVar.t(j3);
        hVar.a(byteBuffer);
        hVar.setFrontCamera(z);
        hVar.s(j4);
        if (faceAlgoData != null && faceAlgoData.getFaceFrame() != null) {
            hVar.G(true);
            if (faceAlgoData.getFaceFrame().getProcessResult() == 200) {
                hVar.setTracked(true);
            } else {
                hVar.setTracked(false);
            }
        }
        if (this.mH != null) {
            if (this.nj > 0 && this.ni != null) {
                this.ni.f(System.currentTimeMillis() - this.nj);
            }
            this.nj = System.currentTimeMillis();
            if (this.no == null || !this.no.isAlive() || this.np == null) {
                return;
            }
            this.np.a(1002, new Runnable() { // from class: com.baidu.ar.face.a.a.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] Callback handle:" + hVar.bv());
                    a.this.mH.g(hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceAlgoData faceAlgoData, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        FaceJniClient faceJniClient = this.mG;
        FaceAlgoData trackFace = FaceJniClient.trackFace(this.nd, faceAlgoData, j);
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - elapsedRealtime, (trackFace == null || trackFace.getFaceFrame() == null || trackFace.getFaceFrame().getFaceBoxes() == null) ? 0 : trackFace.getFaceFrame().getFaceBoxes().size());
        if (this.ni != null) {
            this.ni.c(System.currentTimeMillis() - currentTimeMillis);
        }
        com.baidu.ar.f.b.h("bdar-face", "track cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j);
        if (trackFace == null || trackFace.getFaceFrame() == null || trackFace.getFaceFrame().getProcessResult() != 200 || trackFace.getFaceFrame().getTrackedPointsList().size() < this.nf) {
            this.mJ = false;
        } else {
            this.mJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, boolean z, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        FaceJniClient faceJniClient = this.mG;
        FaceAlgoData animateFace = FaceJniClient.animateFace(this.ne, faceAlgoData, j);
        int i = 0;
        if (animateFace != null && animateFace.getFaceFrame() != null && animateFace.getFaceFrame().getFaceBoxes() != null) {
            i = animateFace.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "animate", SystemClock.elapsedRealtime() - elapsedRealtime, i);
        if (this.ni != null) {
            this.ni.d(System.currentTimeMillis() - currentTimeMillis);
        }
        com.baidu.ar.f.b.h("bdar-face", "animate cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j + " timestamp:" + j2);
        long currentTimeMillis2 = this.mO > 0 ? System.currentTimeMillis() - this.mO : System.currentTimeMillis() - j3;
        if (animateFace != null && animateFace.getFaceFrame() != null) {
            if (animateFace.getFaceFrame().getProcessResult() != 200) {
                this.ng = 0;
            }
            if (animateFace.getFaceFrame().getFaceBoxes() != null) {
                this.ng = animateFace.getFaceFrame().getFaceBoxes().size();
            }
        }
        this.mO = System.currentTimeMillis();
        a(j2, animateFace, j, currentTimeMillis2, byteBuffer, z, j4);
    }

    private void a(boolean z, boolean z2, boolean z3, String[] strArr, String[] strArr2, String[] strArr3) {
        long createDetectCore;
        long createTrackCore;
        long createAnimateCore;
        if (z) {
            FaceJniClient faceJniClient = this.mG;
            createDetectCore = FaceJniClient.createDetectCoreFromAssetDir(strArr);
        } else {
            FaceJniClient faceJniClient2 = this.mG;
            createDetectCore = FaceJniClient.createDetectCore(strArr);
        }
        this.nc = createDetectCore;
        if (z2) {
            FaceJniClient faceJniClient3 = this.mG;
            createTrackCore = FaceJniClient.createTrackCoreFromAssetDir(strArr2);
        } else {
            FaceJniClient faceJniClient4 = this.mG;
            createTrackCore = FaceJniClient.createTrackCore(strArr2);
        }
        this.nd = createTrackCore;
        if (z3) {
            FaceJniClient faceJniClient5 = this.mG;
            createAnimateCore = FaceJniClient.createAnimateCoreFromAssetDir(strArr3);
        } else {
            FaceJniClient faceJniClient6 = this.mG;
            createAnimateCore = FaceJniClient.createAnimateCore(strArr3);
        }
        this.ne = createAnimateCore;
        com.baidu.ar.f.b.c("bdar-face", "face init mDetectHandle:" + this.nc + " mTrackHandle:" + this.nd + " mAnimateHandle:" + this.ne);
        int i = (this.nc <= 0 || this.nd <= 0 || this.ne <= 0) ? 104 : 100;
        boolean z4 = i == 100;
        this.mI = z4;
        if (this.mH != null) {
            this.mH.D(z4);
        }
        if (!z4) {
            com.baidu.ar.f.b.b("bdar-face", "face init failed:" + i);
            return;
        }
        cF();
        cG();
        cH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceAlgoData faceAlgoData, long j, long j2, ByteBuffer byteBuffer, boolean z, long j3) {
        boolean z2 = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mJ) {
            this.mP = 0;
            com.baidu.ar.f.b.h("bdar-face", "skip detect");
            return false;
        }
        if (this.mP != 0) {
            com.baidu.ar.f.b.h("bdar-face", "detect rate: 1/" + this.mQ + " skip frame: mFaceHandle = " + j);
            boolean z3 = this.ng < 1;
            if (z3) {
                a(j2, faceAlgoData, j, System.currentTimeMillis() - currentTimeMillis, byteBuffer, z, j3);
            }
            z2 = z3;
        } else if (!this.mV) {
            return true;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            FaceJniClient faceJniClient = this.mG;
            FaceAlgoData detectFace = FaceJniClient.detectFace(this.nc, faceAlgoData, j);
            int i = 0;
            if (detectFace != null && detectFace.getFaceFrame() != null && detectFace.getFaceFrame().getFaceBoxes() != null) {
                i = detectFace.getFaceFrame().getFaceBoxes().size();
            }
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "detect", SystemClock.elapsedRealtime() - elapsedRealtime, i);
            if (this.ni != null) {
                this.ni.a(System.currentTimeMillis() - currentTimeMillis);
            }
            com.baidu.ar.f.b.h("bdar-face", "detect cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j);
            if (detectFace != null && detectFace.getFaceFrame() != null && detectFace.getFaceFrame().getProcessResult() != 200 && this.ng <= 0) {
                com.baidu.ar.f.b.h("bdar-face", "detect fail，mFaceHandle = " + j);
                this.ng = 0;
                a(j2, detectFace, j, System.currentTimeMillis() - currentTimeMillis, byteBuffer, z, j3);
                z2 = true;
            }
        }
        this.mP++;
        if (this.mP >= this.mQ[this.ng]) {
            this.mP = 0;
            return z2;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, String str2, String str3, String[] strArr, String str4, String str5, String str6) {
        boolean a = com.baidu.ar.face.b.a(str, str2, str3, strArr, str4, str5, str6);
        if (this.mG == null || a) {
            com.baidu.ar.f.b.b("bdar-face", "init error! check face model!");
            return false;
        }
        setAutoCalibrate(true);
        com.baidu.ar.f.b.c("bdar-face", "imbin:" + str + "\nDetect:" + str2 + "\nTrack0:" + str3 + "\nTrack1:" + Arrays.toString(strArr) + "\nTrack2:" + str4 + "\nexpression:" + str5 + "\nmouth:" + str6);
        boolean z = false;
        if (str2.startsWith("file:///android_asset/")) {
            z = true;
            str2 = str2.replace("file:///android_asset/", "");
        }
        boolean z2 = false;
        if (str3.startsWith("file:///android_asset/")) {
            z2 = true;
            str3 = str3.replace("file:///android_asset/", "");
            strArr[0] = strArr[0].replace("file:///android_asset/", "");
            strArr[1] = strArr[1].replace("file:///android_asset/", "");
            strArr[2] = strArr[2].replace("file:///android_asset/", "");
            str4 = str4.replace("file:///android_asset/", "");
            str6 = str6.replace("file:///android_asset/", "");
        }
        boolean z3 = false;
        if (str.startsWith("file:///android_asset/")) {
            z3 = true;
            str = str.replace("file:///android_asset/", "");
            str5 = str5.replace("file:///android_asset/", "");
        }
        com.baidu.ar.f.b.c("bdar-face", "loadDetectAssets:" + z + " loadTrackAssets:" + z2 + " loadAnimateAssets:" + z3);
        a(z, z2, z3, new String[]{"detect", str2}, new String[]{"angle", str3, "heavy", strArr[0], "medium", strArr[1], "lite", strArr[2], LivenessStat.TYPE_LIVING_MOUTH, str6, "eyes", str4}, new String[]{"animate", str, "expression", str5});
        return true;
    }

    public static synchronized a cE() {
        a aVar;
        synchronized (a.class) {
            if (mF == null) {
                mF = new a();
            }
            aVar = mF;
        }
        return aVar;
    }

    private void cF() {
        if (this.mR == null) {
            this.mR = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.mU) {
                        if (!a.this.mX || a.this.mK == null || !a.this.mI || a.this.na.size() > 0) {
                            try {
                                Thread.sleep(3L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            a.this.mX = false;
                            long j = a.this.mL;
                            if (a.this.mN) {
                                a.this.nl.setForceLost(true);
                                a.this.mN = false;
                            }
                            ByteBuffer byteBuffer = a.this.mK;
                            long j2 = a.this.nn;
                            boolean z = a.this.mM;
                            a.this.nl.setMirror(false);
                            a.this.mK = null;
                            a.this.nn = 0L;
                            FAUImage fAUImage = new FAUImage(byteBuffer, a.this.mPreviewWidth, a.this.mPreviewHeight, 2);
                            long currentTimeMillis = System.currentTimeMillis();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            FaceJniClient unused = a.this.mG;
                            long createFrame = FaceJniClient.createFrame(fAUImage);
                            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "create", SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                            if (a.this.ni != null) {
                                a.this.ni.b(System.currentTimeMillis() - currentTimeMillis);
                            }
                            com.baidu.ar.f.b.h("bdar-face", "create cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + createFrame);
                            if (createFrame <= 0) {
                                com.baidu.ar.f.b.b("bdar-face", "create handle illegal:" + createFrame);
                                a.this.mX = true;
                            } else {
                                boolean z2 = false;
                                try {
                                    Iterator it = a.this.nh.iterator();
                                    while (it.hasNext()) {
                                        z2 = ((Long) it.next()).longValue() == createFrame ? true : z2;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    com.baidu.ar.f.b.i("bdar-face", "faceHandle isListContain Exception:" + e2.getMessage());
                                }
                                if (z2) {
                                    com.baidu.ar.f.b.i("bdar-face", "handle exist, not add to mCreateHandleList:" + createFrame);
                                    a.this.mX = true;
                                } else {
                                    a.this.nh.add(Long.valueOf(createFrame));
                                    FaceAlgoData faceAlgoData = new FaceAlgoData();
                                    faceAlgoData.setAlgoConfig(a.this.nl.cloneInstance());
                                    faceAlgoData.setFaceFrame(new FaceFrame());
                                    if (a.this.bU != null && j2 > 0) {
                                        a.this.bU.setHandleFaceHandle(j2, createFrame);
                                    }
                                    a.this.nl.setForceLost(false);
                                    a.this.na.add(new b(faceAlgoData, createFrame, j, currentTimeMillis, byteBuffer, z, j2));
                                    a.this.mX = true;
                                }
                            }
                        }
                    }
                }
            });
        }
        this.mR.setName("FaceCreateThread");
        if (!this.mR.isAlive()) {
            this.mR.start();
        }
        this.mU = true;
    }

    private void cG() {
        if (this.mS == null) {
            this.mS = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.mV) {
                        if (a.this.mY && a.this.na.size() > 0 && a.this.mI) {
                            a.this.mY = false;
                            try {
                                FaceAlgoData cN = ((b) a.this.na.get(0)).cN();
                                long handle = ((b) a.this.na.get(0)).getHandle();
                                long timestamp = ((b) a.this.na.get(0)).getTimestamp();
                                long cO = ((b) a.this.na.get(0)).cO();
                                long cP = ((b) a.this.na.get(0)).cP();
                                ByteBuffer cM = ((b) a.this.na.get(0)).cM();
                                boolean isFrontCamera = ((b) a.this.na.get(0)).isFrontCamera();
                                a.this.na.remove(0);
                                if (a.this.a(cN, handle, timestamp, cM, isFrontCamera, cP) || !a.this.mV) {
                                    a.this.mY = true;
                                } else {
                                    a.this.a(cN, handle);
                                    a.this.nb.add(new b(cN, handle, timestamp, cO, cM, isFrontCamera, cP));
                                    a.this.mY = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                com.baidu.ar.f.b.b("bdar-face", "FaceTrackThread IndexOutOfBoundsException:" + e.getMessage());
                                a.this.mY = true;
                            }
                        } else {
                            try {
                                Thread.sleep(3L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
        this.mS.setName("FaceTrackThread");
        if (!this.mS.isAlive()) {
            this.mS.start();
        }
        this.mV = true;
    }

    private void cH() {
        if (this.mT == null) {
            this.mT = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.mW) {
                        if (a.this.nb.size() > 0 && a.this.mI && a.this.mZ) {
                            a.this.mZ = false;
                            try {
                                FaceAlgoData cN = ((b) a.this.nb.get(0)).cN();
                                long handle = ((b) a.this.nb.get(0)).getHandle();
                                long timestamp = ((b) a.this.nb.get(0)).getTimestamp();
                                long cO = ((b) a.this.nb.get(0)).cO();
                                long cP = ((b) a.this.nb.get(0)).cP();
                                ByteBuffer cM = ((b) a.this.nb.get(0)).cM();
                                boolean isFrontCamera = ((b) a.this.nb.get(0)).isFrontCamera();
                                a.this.nb.remove(0);
                                if (a.this.mW) {
                                    a.this.a(cN, handle, timestamp, cO, cM, isFrontCamera, cP);
                                    a.this.mZ = true;
                                } else {
                                    a.this.mZ = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                com.baidu.ar.f.b.i("bdar-face", "FaceAnimateThread IndexOutOfBoundsException:" + e.getMessage());
                                a.this.mZ = true;
                            }
                        } else {
                            try {
                                Thread.sleep(3L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
        this.mT.setName("FaceAnimateThread");
        if (!this.mT.isAlive()) {
            this.mT.start();
        }
        this.mW = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJ() {
        this.mU = false;
        this.mV = false;
        this.mW = false;
        this.mI = false;
        this.mX = false;
        this.mY = false;
        this.mZ = false;
        try {
            if (this.na.size() > 0) {
                this.na.clear();
            }
            if (this.nb.size() > 0) {
                this.nb.clear();
            }
        } catch (Exception e) {
            com.baidu.ar.f.b.i("bdar-face", "Results.clear Exception：" + e.getMessage());
            e.printStackTrace();
        }
        this.mR = null;
        this.mS = null;
        this.mT = null;
        cK();
        cL();
        if (this.np != null) {
            this.np = null;
        }
        if (this.no != null) {
            this.no.quit();
            this.no = null;
        }
        mF = null;
        if (this.mH != null) {
            this.mH.E(true);
        }
        this.mK = null;
        if (this.ni != null) {
            this.ni.dd();
            this.ni = null;
        }
        this.nk = 0L;
        this.nj = 0L;
        return true;
    }

    private void cK() {
        try {
            if (this.nh.size() > 0) {
                Iterator<Long> it = this.nh.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    com.baidu.ar.f.b.i("bdar-face", "releaseHandleList, release handle:" + longValue);
                    FaceJniClient faceJniClient = this.mG;
                    FaceJniClient.destoryFrame(longValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.ar.f.b.i("bdar-face", "release mCreateHandleList Exception:" + e.getMessage());
        }
        this.nh.clear();
    }

    private void cL() {
        try {
            if (this.nc > 0) {
                FaceJniClient faceJniClient = this.mG;
                FaceJniClient.releaseDetectCore(this.nc);
            }
            if (this.nd > 0) {
                FaceJniClient faceJniClient2 = this.mG;
                FaceJniClient.releaseTrackCore(this.nd);
            }
            if (this.ne > 0) {
                FaceJniClient faceJniClient3 = this.mG;
                FaceJniClient.releaseAnimateCore(this.ne);
            }
            this.nc = 0L;
            this.nd = 0L;
            this.ne = 0L;
            this.mG = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAutoCalibrate(boolean z) {
        if (this.nl != null) {
            this.nl.setAutoCalibrate(z);
        }
    }

    public void A(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setAnimojiMode:" + z);
            this.nl.setIsAnimojiMode(z);
        }
    }

    public void B(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedRefineMouth:" + z);
            this.nl.setNeedRefineMouth(z);
        }
    }

    public void C(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedExpression:" + z);
            this.nl.setNeedExpression(z);
        }
    }

    public void a(float f, float f2) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "mTrackingSmoothAlpha:" + f + " mTrackingSmoothThreshold:" + f2);
            this.nl.setTrackingSmoothAlpha(f);
            this.nl.setTrackingSmoothThreshold(f2);
        }
    }

    public void a(AlgoHandleController algoHandleController) {
        this.bU = algoHandleController;
    }

    public void a(c cVar) {
        this.mH = cVar;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
            this.nl.setAnimateRunningMode(z, z2, z3);
        }
    }

    public boolean a(ByteBuffer byteBuffer, long j, int i, int i2, boolean z, int i3, boolean z2) {
        if (this.mI) {
            if (this.nk > 0 && this.ni != null && this.mI) {
                this.ni.e(System.currentTimeMillis() - this.nk);
            }
            this.nk = System.currentTimeMillis();
            if (this.mK == null) {
                if (this.nm && this.bU != null) {
                    this.nn = this.bU.createHandle();
                    this.bU.setHandleInput(this.nn, 10, j, 2, i, i2, z, i3, z2, byteBuffer);
                }
                this.mK = byteBuffer;
                if (this.mM != z) {
                    this.mN = true;
                }
                this.mM = z;
                this.mL = j;
                this.mPreviewWidth = i;
                this.mPreviewHeight = i2;
                return true;
            }
            return false;
        }
        return false;
    }

    public void b(final long j) {
        if (this.no == null || !this.no.isAlive() || this.np == null) {
            return;
        }
        this.np.a(1003, new Runnable() { // from class: com.baidu.ar.face.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (a.this.nh.size() > 0) {
                    int i2 = 0;
                    i = -1;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= a.this.nh.size()) {
                            break;
                        }
                        if (a.this.nh.get(i3) != null && ((Long) a.this.nh.get(i3)).longValue() == j) {
                            i = i3;
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    i = -1;
                }
                if (i >= 0 && a.this.nh.size() > 0) {
                    a.this.nh.remove(i);
                }
                com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] destroy handle:" + j);
                FaceJniClient unused = a.this.mG;
                FaceJniClient.destoryFrame(j);
            }
        });
    }

    public void b(int[] iArr) {
        if (iArr != null) {
            com.baidu.ar.f.b.c("bdar-face", "setDetectRate:" + Arrays.toString(iArr));
        }
        this.mQ = iArr;
    }

    public boolean b(final String str, final String str2, final String str3, final String[] strArr, final String str4, final String str5, final String str6) {
        if (this.no == null) {
            this.no = new HandlerThread("FaceHandlerThread");
            this.no.start();
        }
        if (this.np == null) {
            this.np = new HandlerC0059a(this.no.getLooper());
        }
        if (this.no == null || !this.no.isAlive() || this.np == null) {
            return false;
        }
        this.np.a(1001, new Runnable() { // from class: com.baidu.ar.face.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] init");
                a.this.c(str, str2, str3, strArr, str4, str5, str6);
            }
        });
        return true;
    }

    public void c(float f) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "mTrackingMouthThreshold:" + f);
            this.nl.setTrackingMouthThreshold(f);
        }
    }

    public boolean cI() {
        return this.mI && this.mK == null;
    }

    public void r(long j) {
        if (this.bU != null) {
            this.bU.destroyHandle(j);
        }
    }

    public boolean release() {
        if (this.no == null || !this.no.isAlive() || this.np == null) {
            return false;
        }
        this.np.a(1004, new Runnable() { // from class: com.baidu.ar.face.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.f.b.c("bdar-face", "[FaceHandlerThread] release");
                a.this.cJ();
            }
        });
        return true;
    }

    public void setContext(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 == null || this.mG == null) {
            return;
        }
        FaceJniClient faceJniClient = this.mG;
        FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
    }

    public void setNeedHeadPose(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedHeadPose:" + z);
            this.nl.setNeedHeadPose(z);
        }
    }

    public void setNeedSkeleton(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedSkeleton:" + z);
            this.nl.setNeedSkeleton(z);
        }
    }

    public void setNeedTriggers(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedTriggers:" + z);
            this.nl.setNeedTriggers(z);
        }
    }

    public void x(int i) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "trackMode:" + i);
            this.nl.setRunningMode(i);
        }
    }

    public void y(int i) {
        this.nf = i;
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setMaxTrackingFace:" + i);
            this.nl.setMaxTrackingFace(this.nf);
        }
    }

    public void z(boolean z) {
        if (this.nl != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedRefineEyes:" + z);
            this.nl.setNeedRefineEyes(z);
        }
    }
}
