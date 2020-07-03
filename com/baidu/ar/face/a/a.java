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
    private static a nc = null;
    private AlgoHandleController ch;
    private long nG;
    private long nH;
    private HandlerThread nL;
    private HandlerC0083a nM;
    private c ne;
    private ByteBuffer nh;
    private long ni;
    private boolean nf = false;
    private boolean ng = false;
    private boolean nj = true;
    private boolean nk = false;
    private long nl = 0;
    private int nm = 0;
    private int[] nn = {3, 10, 10, 10, 10};
    private Thread no = null;
    private Thread np = null;
    private Thread nq = null;
    private boolean nr = true;
    private boolean ns = true;
    private boolean nt = true;
    private boolean nu = true;
    private boolean nv = true;
    private boolean nw = true;
    private final List<b> nx = Collections.synchronizedList(new ArrayList());
    private final List<b> ny = Collections.synchronizedList(new ArrayList());
    private int mPreviewWidth = 320;
    private int mPreviewHeight = 180;
    private long nz = 0;
    private long nA = 0;
    private long nB = 0;
    private int nC = 1;
    private int nD = 0;
    private volatile ArrayList<Long> nE = new ArrayList<>();
    private int mOrientation = -1;
    private f nF = new f();
    private FaceAlgoConfig nI = new FaceAlgoConfig(180, 5, 0.03f, 1.0f);
    private boolean nJ = true;
    private long nK = 0;
    private FaceJniClient nd = new FaceJniClient();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.face.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class HandlerC0083a extends Handler {
        private boolean cF;

        public HandlerC0083a(Looper looper) {
            super(looper);
            this.cF = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cF) {
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
                this.cF = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private a() {
        StringBuilder append = new StringBuilder().append("environment version= ").append(com.baidu.ar.f.c.getVersionCode()).append(", face = ");
        FaceJniClient faceJniClient = this.nd;
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
        if (this.ne != null) {
            if (this.nG > 0 && this.nF != null) {
                this.nF.f(System.currentTimeMillis() - this.nG);
            }
            this.nG = System.currentTimeMillis();
            if (this.nL == null || !this.nL.isAlive() || this.nM == null) {
                return;
            }
            this.nM.a(1002, new Runnable() { // from class: com.baidu.ar.face.a.a.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] Callback handle:" + hVar.cz());
                    a.this.ne.e(hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceAlgoData faceAlgoData, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        FaceJniClient faceJniClient = this.nd;
        FaceAlgoData trackFace = FaceJniClient.trackFace(this.nA, faceAlgoData, j);
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - elapsedRealtime, (trackFace == null || trackFace.getFaceFrame() == null || trackFace.getFaceFrame().getFaceBoxes() == null) ? 0 : trackFace.getFaceFrame().getFaceBoxes().size());
        if (this.nF != null) {
            this.nF.c(System.currentTimeMillis() - currentTimeMillis);
        }
        com.baidu.ar.f.b.h("bdar-face", "track cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j);
        if (trackFace == null || trackFace.getFaceFrame() == null || trackFace.getFaceFrame().getProcessResult() != 200 || trackFace.getFaceFrame().getTrackedPointsList().size() < this.nC) {
            this.ng = false;
        } else {
            this.ng = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, boolean z, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        FaceJniClient faceJniClient = this.nd;
        FaceAlgoData animateFace = FaceJniClient.animateFace(this.nB, faceAlgoData, j);
        int i = 0;
        if (animateFace != null && animateFace.getFaceFrame() != null && animateFace.getFaceFrame().getFaceBoxes() != null) {
            i = animateFace.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "animate", SystemClock.elapsedRealtime() - elapsedRealtime, i);
        if (this.nF != null) {
            this.nF.d(System.currentTimeMillis() - currentTimeMillis);
        }
        com.baidu.ar.f.b.h("bdar-face", "animate cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j + " timestamp:" + j2);
        long currentTimeMillis2 = this.nl > 0 ? System.currentTimeMillis() - this.nl : System.currentTimeMillis() - j3;
        if (animateFace != null && animateFace.getFaceFrame() != null) {
            if (animateFace.getFaceFrame().getProcessResult() != 200) {
                this.nD = 0;
            }
            if (animateFace.getFaceFrame().getFaceBoxes() != null) {
                this.nD = animateFace.getFaceFrame().getFaceBoxes().size();
                if (this.nD > 4) {
                    this.nD = 4;
                }
            }
        }
        this.nl = System.currentTimeMillis();
        a(j2, animateFace, j, currentTimeMillis2, byteBuffer, z, j4);
    }

    private void a(boolean z, boolean z2, boolean z3, String[] strArr, String[] strArr2, String[] strArr3) {
        long createDetectCore;
        long createTrackCore;
        long createAnimateCore;
        if (z) {
            FaceJniClient faceJniClient = this.nd;
            createDetectCore = FaceJniClient.createDetectCoreFromAssetDir(strArr);
        } else {
            FaceJniClient faceJniClient2 = this.nd;
            createDetectCore = FaceJniClient.createDetectCore(strArr);
        }
        this.nz = createDetectCore;
        if (z2) {
            FaceJniClient faceJniClient3 = this.nd;
            createTrackCore = FaceJniClient.createTrackCoreFromAssetDir(strArr2);
        } else {
            FaceJniClient faceJniClient4 = this.nd;
            createTrackCore = FaceJniClient.createTrackCore(strArr2);
        }
        this.nA = createTrackCore;
        if (z3) {
            FaceJniClient faceJniClient5 = this.nd;
            createAnimateCore = FaceJniClient.createAnimateCoreFromAssetDir(strArr3);
        } else {
            FaceJniClient faceJniClient6 = this.nd;
            createAnimateCore = FaceJniClient.createAnimateCore(strArr3);
        }
        this.nB = createAnimateCore;
        com.baidu.ar.f.b.c("bdar-face", "face init mDetectHandle:" + this.nz + " mTrackHandle:" + this.nA + " mAnimateHandle:" + this.nB);
        int i = (this.nz <= 0 || this.nA <= 0 || this.nB <= 0) ? 104 : 100;
        boolean z4 = i == 100;
        this.nf = z4;
        if (this.ne != null) {
            this.ne.C(z4);
        }
        if (!z4) {
            com.baidu.ar.f.b.b("bdar-face", "face init failed:" + i);
            return;
        }
        cU();
        cV();
        cW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FaceAlgoData faceAlgoData, long j, long j2, ByteBuffer byteBuffer, boolean z, long j3) {
        boolean z2 = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ng) {
            this.nm = 0;
            com.baidu.ar.f.b.h("bdar-face", "skip detect");
            return false;
        }
        if (this.nm != 0) {
            com.baidu.ar.f.b.h("bdar-face", "detect rate: 1/" + this.nn + " skip frame: mFaceHandle = " + j);
            boolean z3 = this.nD < 1;
            if (z3) {
                a(j2, faceAlgoData, j, System.currentTimeMillis() - currentTimeMillis, byteBuffer, z, j3);
            }
            z2 = z3;
        } else if (!this.ns) {
            return true;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            FaceJniClient faceJniClient = this.nd;
            FaceAlgoData detectFace = FaceJniClient.detectFace(this.nz, faceAlgoData, j);
            int i = 0;
            if (detectFace != null && detectFace.getFaceFrame() != null && detectFace.getFaceFrame().getFaceBoxes() != null) {
                i = detectFace.getFaceFrame().getFaceBoxes().size();
            }
            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "detect", SystemClock.elapsedRealtime() - elapsedRealtime, i);
            if (this.nF != null) {
                this.nF.a(System.currentTimeMillis() - currentTimeMillis);
            }
            com.baidu.ar.f.b.h("bdar-face", "detect cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + j);
            if (detectFace != null && detectFace.getFaceFrame() != null && detectFace.getFaceFrame().getProcessResult() != 200 && this.nD <= 0) {
                com.baidu.ar.f.b.h("bdar-face", "detect fail，mFaceHandle = " + j);
                this.nD = 0;
                a(j2, detectFace, j, System.currentTimeMillis() - currentTimeMillis, byteBuffer, z, j3);
                z2 = true;
            }
        }
        this.nm++;
        if (this.nm >= this.nn[this.nD]) {
            this.nm = 0;
            return z2;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, String str2, String str3, String[] strArr, String str4, String str5, String str6, String str7) {
        boolean a = com.baidu.ar.face.b.a(str, str2, str3, strArr, str4, str5, str6, str7);
        if (this.nd == null || a) {
            com.baidu.ar.f.b.b("bdar-face", "init error! check face model!");
            return false;
        }
        setAutoCalibrate(true);
        com.baidu.ar.f.b.c("bdar-face", "imbin:" + str + "\nDetect:" + str2 + "\nTrack0:" + str3 + "\nTrack1:" + Arrays.toString(strArr) + "\nTrack2:" + str4 + "\nTrack3:" + str5 + "\nexpression:" + str6 + "\nmouth:" + str7);
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
            str5 = str5.replace("file:///android_asset/", "");
            str7 = str7.replace("file:///android_asset/", "");
        }
        boolean z3 = false;
        if (str.startsWith("file:///android_asset/")) {
            z3 = true;
            str = str.replace("file:///android_asset/", "");
            str6 = str6.replace("file:///android_asset/", "");
        }
        com.baidu.ar.f.b.c("bdar-face", "loadDetectAssets:" + z + " loadTrackAssets:" + z2 + " loadAnimateAssets:" + z3);
        a(z, z2, z3, new String[]{"detect", str2}, new String[]{"angle", str3, "heavy", strArr[0], "medium", strArr[1], "lite", strArr[2], LivenessStat.TYPE_LIVING_MOUTH, str7, "eyes", str4, "iris", str5}, new String[]{"animate", str, "expression", str6});
        return true;
    }

    public static synchronized a cT() {
        a aVar;
        synchronized (a.class) {
            if (nc == null) {
                nc = new a();
            }
            aVar = nc;
        }
        return aVar;
    }

    private void cU() {
        if (this.no == null) {
            this.no = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.nr) {
                        if (!a.this.nu || a.this.nh == null || !a.this.nf || a.this.nx.size() > 0) {
                            try {
                                Thread.sleep(3L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            a.this.nu = false;
                            long j = a.this.ni;
                            if (a.this.nk) {
                                a.this.nI.setForceLost(true);
                                a.this.nk = false;
                            }
                            ByteBuffer byteBuffer = a.this.nh;
                            long j2 = a.this.nK;
                            boolean z = a.this.nj;
                            a.this.nI.setMirror(false);
                            a.this.nI.setTrackingRT(com.baidu.ar.face.b.B(a.this.mOrientation));
                            a.this.nh = null;
                            a.this.nK = 0L;
                            FAUImage fAUImage = new FAUImage(byteBuffer, a.this.mPreviewWidth, a.this.mPreviewHeight, 2);
                            long currentTimeMillis = System.currentTimeMillis();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            FaceJniClient unused = a.this.nd;
                            long createFrame = FaceJniClient.createFrame(fAUImage);
                            StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "create", SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                            if (a.this.nF != null) {
                                a.this.nF.b(System.currentTimeMillis() - currentTimeMillis);
                            }
                            com.baidu.ar.f.b.h("bdar-face", "create cost:" + (System.currentTimeMillis() - currentTimeMillis) + " mFaceHandle = " + createFrame);
                            if (createFrame <= 0) {
                                com.baidu.ar.f.b.b("bdar-face", "create handle illegal:" + createFrame);
                                a.this.nu = true;
                            } else {
                                boolean z2 = false;
                                try {
                                    Iterator it = a.this.nE.iterator();
                                    while (it.hasNext()) {
                                        z2 = ((Long) it.next()).longValue() == createFrame ? true : z2;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    com.baidu.ar.f.b.i("bdar-face", "faceHandle isListContain Exception:" + e2.getMessage());
                                }
                                if (z2) {
                                    com.baidu.ar.f.b.i("bdar-face", "handle exist, not add to mCreateHandleList:" + createFrame);
                                    a.this.nu = true;
                                } else {
                                    a.this.nE.add(Long.valueOf(createFrame));
                                    FaceAlgoData faceAlgoData = new FaceAlgoData();
                                    faceAlgoData.setAlgoConfig(a.this.nI.cloneInstance());
                                    faceAlgoData.setFaceFrame(new FaceFrame());
                                    if (a.this.ch != null && j2 > 0) {
                                        a.this.ch.setHandleFaceHandle(j2, createFrame);
                                    }
                                    a.this.nI.setForceLost(false);
                                    a.this.nx.add(new b(faceAlgoData, createFrame, j, currentTimeMillis, byteBuffer, z, j2));
                                    a.this.nu = true;
                                }
                            }
                        }
                    }
                }
            });
        }
        this.no.setName("FaceCreateThread");
        if (!this.no.isAlive()) {
            this.no.start();
        }
        this.nr = true;
    }

    private void cV() {
        if (this.np == null) {
            this.np = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.ns) {
                        if (a.this.nv && a.this.nx.size() > 0 && a.this.nf) {
                            a.this.nv = false;
                            try {
                                FaceAlgoData dc = ((b) a.this.nx.get(0)).dc();
                                long handle = ((b) a.this.nx.get(0)).getHandle();
                                long timestamp = ((b) a.this.nx.get(0)).getTimestamp();
                                long dd = ((b) a.this.nx.get(0)).dd();
                                long de2 = ((b) a.this.nx.get(0)).de();
                                ByteBuffer db = ((b) a.this.nx.get(0)).db();
                                boolean isFrontCamera = ((b) a.this.nx.get(0)).isFrontCamera();
                                a.this.nx.remove(0);
                                if (a.this.a(dc, handle, timestamp, db, isFrontCamera, de2) || !a.this.ns) {
                                    a.this.nv = true;
                                } else {
                                    a.this.a(dc, handle);
                                    a.this.ny.add(new b(dc, handle, timestamp, dd, db, isFrontCamera, de2));
                                    a.this.nv = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                com.baidu.ar.f.b.b("bdar-face", "FaceTrackThread IndexOutOfBoundsException:" + e.getMessage());
                                a.this.nv = true;
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
        this.np.setName("FaceTrackThread");
        if (!this.np.isAlive()) {
            this.np.start();
        }
        this.ns = true;
    }

    private void cW() {
        if (this.nq == null) {
            this.nq = new Thread(new Runnable() { // from class: com.baidu.ar.face.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    while (a.this.nt) {
                        if (a.this.ny.size() > 0 && a.this.nf && a.this.nw) {
                            a.this.nw = false;
                            try {
                                FaceAlgoData dc = ((b) a.this.ny.get(0)).dc();
                                long handle = ((b) a.this.ny.get(0)).getHandle();
                                long timestamp = ((b) a.this.ny.get(0)).getTimestamp();
                                long dd = ((b) a.this.ny.get(0)).dd();
                                long de2 = ((b) a.this.ny.get(0)).de();
                                ByteBuffer db = ((b) a.this.ny.get(0)).db();
                                boolean isFrontCamera = ((b) a.this.ny.get(0)).isFrontCamera();
                                a.this.ny.remove(0);
                                if (a.this.nt) {
                                    a.this.a(dc, handle, timestamp, dd, db, isFrontCamera, de2);
                                    a.this.nw = true;
                                } else {
                                    a.this.nw = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                com.baidu.ar.f.b.i("bdar-face", "FaceAnimateThread IndexOutOfBoundsException:" + e.getMessage());
                                a.this.nw = true;
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
        this.nq.setName("FaceAnimateThread");
        if (!this.nq.isAlive()) {
            this.nq.start();
        }
        this.nt = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cY() {
        this.nr = false;
        this.ns = false;
        this.nt = false;
        this.nf = false;
        this.nu = false;
        this.nv = false;
        this.nw = false;
        try {
            if (this.nx.size() > 0) {
                this.nx.clear();
            }
            if (this.ny.size() > 0) {
                this.ny.clear();
            }
        } catch (Exception e) {
            com.baidu.ar.f.b.i("bdar-face", "Results.clear Exception：" + e.getMessage());
            e.printStackTrace();
        }
        this.no = null;
        this.np = null;
        this.nq = null;
        cZ();
        da();
        if (this.nM != null) {
            this.nM = null;
        }
        if (this.nL != null) {
            this.nL.quit();
            this.nL = null;
        }
        nc = null;
        if (this.ne != null) {
            this.ne.D(true);
        }
        this.nh = null;
        if (this.nF != null) {
            this.nF.dt();
            this.nF = null;
        }
        this.nH = 0L;
        this.nG = 0L;
        return true;
    }

    private void cZ() {
        try {
            if (this.nE.size() > 0) {
                Iterator<Long> it = this.nE.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    com.baidu.ar.f.b.i("bdar-face", "releaseHandleList, release handle:" + longValue);
                    FaceJniClient faceJniClient = this.nd;
                    FaceJniClient.destoryFrame(longValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.ar.f.b.i("bdar-face", "release mCreateHandleList Exception:" + e.getMessage());
        }
        this.nE.clear();
    }

    private void da() {
        try {
            if (this.nz > 0) {
                FaceJniClient faceJniClient = this.nd;
                FaceJniClient.releaseDetectCore(this.nz);
            }
            if (this.nA > 0) {
                FaceJniClient faceJniClient2 = this.nd;
                FaceJniClient.releaseTrackCore(this.nA);
            }
            if (this.nB > 0) {
                FaceJniClient faceJniClient3 = this.nd;
                FaceJniClient.releaseAnimateCore(this.nB);
            }
            this.nz = 0L;
            this.nA = 0L;
            this.nB = 0L;
            this.nd = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAutoCalibrate(boolean z) {
        if (this.nI != null) {
            this.nI.setAutoCalibrate(z);
        }
    }

    public void A(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedRefineMouth:" + z);
            this.nI.setNeedRefineMouth(z);
        }
    }

    public void B(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedExpression:" + z);
            this.nI.setNeedExpression(z);
        }
    }

    public void C(int i) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "trackMode:" + i);
            this.nI.setRunningMode(i);
        }
    }

    public void D(int i) {
        this.nC = i;
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setMaxTrackingFace:" + i);
            this.nI.setMaxTrackingFace(this.nC);
        }
    }

    public void a(float f, float f2) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "mTrackingSmoothAlpha:" + f + " mTrackingSmoothThreshold:" + f2);
            this.nI.setTrackingSmoothAlpha(f);
            this.nI.setTrackingSmoothThreshold(f2);
        }
    }

    public void a(AlgoHandleController algoHandleController) {
        this.ch = algoHandleController;
    }

    public void a(c cVar) {
        this.ne = cVar;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setAnimateMode needHeadPose:" + z + " needSkeleton:" + z2 + " needTriggers:" + z3);
            this.nI.setAnimateRunningMode(z, z2, z3);
        }
    }

    public boolean a(ByteBuffer byteBuffer, long j, int i, int i2, boolean z, int i3, boolean z2) {
        if (this.nf) {
            if (this.nH > 0 && this.nF != null && this.nf) {
                this.nF.e(System.currentTimeMillis() - this.nH);
            }
            this.nH = System.currentTimeMillis();
            if (this.nh == null) {
                if (this.nJ && this.ch != null) {
                    this.nK = this.ch.createHandle();
                    this.ch.setHandleInput(this.nK, 10, j, 2, i, i2, z, i3, z2, byteBuffer);
                }
                this.nh = byteBuffer;
                this.mOrientation = i3;
                if (this.nj != z) {
                    this.nk = true;
                }
                this.nj = z;
                this.ni = j;
                this.mPreviewWidth = i;
                this.mPreviewHeight = i2;
                return true;
            }
            return false;
        }
        return false;
    }

    public void b(final long j) {
        if (this.nL == null || !this.nL.isAlive() || this.nM == null) {
            return;
        }
        this.nM.a(1003, new Runnable() { // from class: com.baidu.ar.face.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (a.this.nE.size() > 0) {
                    int i2 = 0;
                    i = -1;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= a.this.nE.size()) {
                            break;
                        }
                        if (a.this.nE.get(i3) != null && ((Long) a.this.nE.get(i3)).longValue() == j) {
                            i = i3;
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    i = -1;
                }
                if (i >= 0 && a.this.nE.size() > 0) {
                    a.this.nE.remove(i);
                }
                com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] destroy handle:" + j);
                FaceJniClient unused = a.this.nd;
                FaceJniClient.destoryFrame(j);
            }
        });
    }

    public void b(int[] iArr) {
        if (iArr != null) {
            com.baidu.ar.f.b.c("bdar-face", "setDetectRate:" + Arrays.toString(iArr));
        }
        this.nn = iArr;
    }

    public boolean b(final String str, final String str2, final String str3, final String[] strArr, final String str4, final String str5, final String str6, final String str7) {
        if (this.nL == null) {
            this.nL = new HandlerThread("FaceHandlerThread");
            this.nL.start();
        }
        if (this.nM == null) {
            this.nM = new HandlerC0083a(this.nL.getLooper());
        }
        if (this.nL == null || !this.nL.isAlive() || this.nM == null) {
            return false;
        }
        this.nM.a(1001, new Runnable() { // from class: com.baidu.ar.face.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.f.b.h("bdar-face", "[FaceHandlerThread] init");
                a.this.c(str, str2, str3, strArr, str4, str5, str6, str7);
            }
        });
        return true;
    }

    public boolean cX() {
        return this.nf && this.nh == null;
    }

    public void e(float f) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "mTrackingMouthThreshold:" + f);
            this.nI.setTrackingMouthThreshold(f);
        }
    }

    public void r(long j) {
        if (this.ch != null) {
            this.ch.destroyHandle(j);
        }
    }

    public boolean release() {
        if (this.nL == null || !this.nL.isAlive() || this.nM == null) {
            return false;
        }
        this.nM.a(1004, new Runnable() { // from class: com.baidu.ar.face.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.ar.f.b.c("bdar-face", "[FaceHandlerThread] release");
                a.this.cY();
            }
        });
        return true;
    }

    public void setContext(Context context) {
        Context context2 = (Context) new WeakReference(context).get();
        if (context2 == null || this.nd == null) {
            return;
        }
        FaceJniClient faceJniClient = this.nd;
        FaceJniClient.setAssetManager(context2.getApplicationContext().getAssets());
    }

    public void setNeedHeadPose(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedHeadPose:" + z);
            this.nI.setNeedHeadPose(z);
        }
    }

    public void setNeedSkeleton(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedSkeleton:" + z);
            this.nI.setNeedSkeleton(z);
        }
    }

    public void setNeedTriggers(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedTriggers:" + z);
            this.nI.setNeedTriggers(z);
        }
    }

    public void y(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setNeedRefineEyes:" + z);
            this.nI.setNeedRefineEyes(z);
        }
    }

    public void z(boolean z) {
        if (this.nI != null) {
            com.baidu.ar.f.b.c("bdar-face", "setAnimojiMode:" + z);
            this.nI.setIsAnimojiMode(z);
        }
    }
}
