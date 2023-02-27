package com.baidu.pass.face.platform.c;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.IDetectStrategyCallback;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements IDetectStrategy {
    public static final String a = "com.baidu.pass.face.platform.c.b";
    public static volatile int p;
    public Context b;
    public Rect c;
    public Rect d;
    public IDetectStrategyCallback e;
    public ISecurityCallback f;
    public int g;
    public final com.baidu.pass.face.platform.b.a h;
    public volatile boolean j;
    public FaceConfig l;
    public final com.baidu.pass.face.platform.c.a n;
    public final com.baidu.pass.face.platform.a.b o;
    public boolean i = false;
    public volatile boolean k = false;
    public volatile boolean m = true;
    public int q = 0;
    public long r = 0;
    public Map<FaceStatusNewEnum, String> s = new HashMap();
    public HashMap<String, ImageInfo> t = new HashMap<>();
    public HashMap<String, ImageInfo> u = new HashMap<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public byte[] b;

        public a(byte[] bArr) {
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.b);
            b.a();
        }
    }

    public b(Context context) {
        com.baidu.pass.face.platform.a.a.b();
        com.baidu.pass.face.platform.a.a.b("ca", "Baidu-IDL-FaceSDK4.1.1");
        com.baidu.pass.face.platform.a.a.b("version", "4.1.1");
        com.baidu.pass.face.platform.a.a.b("stm", Long.valueOf(System.currentTimeMillis()));
        this.b = context;
        this.n = new com.baidu.pass.face.platform.c.a();
        this.o = new com.baidu.pass.face.platform.a.b(context);
        this.h = new com.baidu.pass.face.platform.b.a();
    }

    public static /* synthetic */ int a() {
        int i = p - 1;
        p = i;
        return i;
    }

    private com.baidu.pass.face.platform.model.a a(FaceInfo[] faceInfoArr, BDFaceImageInstance bDFaceImageInstance) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        com.baidu.pass.face.platform.model.a aVar = new com.baidu.pass.face.platform.model.a();
        FaceExtInfo[] a2 = this.h.a(faceInfoArr);
        aVar.a(this.n.a(a2, this.d, false, this.l));
        aVar.a(a2);
        aVar.a(System.currentTimeMillis());
        return aVar;
    }

    private String a(FaceStatusNewEnum faceStatusNewEnum) {
        Context context;
        if (this.s.containsKey(faceStatusNewEnum)) {
            return this.s.get(faceStatusNewEnum);
        }
        int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
        if (tipsId <= 0 || (context = this.b) == null) {
            return "";
        }
        String string = context.getResources().getString(tipsId);
        this.s.put(faceStatusNewEnum, string);
        return string;
    }

    private void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> a2 = this.h.a(faceExtInfo, bDFaceImageInstance);
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.t;
        hashMap.put("bestCropDetectImage_" + i + "_" + f + "_" + System.currentTimeMillis(), a2.get(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.pass.face.platform.model.a aVar, BDFaceImageInstance bDFaceImageInstance) {
        FaceExtInfo faceExtInfo;
        if (bDFaceImageInstance == null) {
            return;
        }
        if (this.j) {
            bDFaceImageInstance.destory();
            return;
        }
        if (aVar == null || aVar.b() == null || aVar.b().length <= 0) {
            com.baidu.pass.face.platform.c.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.c();
            }
            faceExtInfo = null;
        } else {
            faceExtInfo = aVar.b()[0];
            com.baidu.pass.face.platform.a.a.a("ftm", Long.valueOf(System.currentTimeMillis()));
        }
        if (faceExtInfo != null) {
            if (this.n == null) {
                bDFaceImageInstance.destory();
                return;
            } else if (this.k) {
                a(FaceStatusNewEnum.OK, faceExtInfo);
                bDFaceImageInstance.destory();
                return;
            } else if (aVar == null) {
                return;
            } else {
                FaceStatusNewEnum a2 = aVar.a();
                if (a2 == FaceStatusNewEnum.OK) {
                    com.baidu.pass.face.platform.a.a.a("btm", Long.valueOf(System.currentTimeMillis()));
                    if (this.q >= this.l.getCacheImageNum()) {
                        this.k = true;
                        a(FaceStatusNewEnum.OK, faceExtInfo);
                    } else if (a(bDFaceImageInstance, faceExtInfo, this.q)) {
                        this.q++;
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (this.n.a()) {
                    this.j = true;
                    bDFaceImageInstance.destory();
                    b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                    return;
                } else {
                    a(a2, faceExtInfo);
                }
            }
        } else if (this.n == null) {
            bDFaceImageInstance.destory();
            return;
        } else {
            long j = 0;
            if (aVar != null && (aVar.a() == FaceStatusNewEnum.DetectRemindCodeNoFaceDetected || aVar.a() == FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame)) {
                this.n.c();
                int i = (this.r > 0L ? 1 : (this.r == 0L ? 0 : -1));
                j = System.currentTimeMillis();
                if (i != 0) {
                    if (j - this.r > this.l.getTimeDetectModule()) {
                        this.j = true;
                        bDFaceImageInstance.destory();
                        b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                        return;
                    }
                    if (!this.n.a()) {
                        bDFaceImageInstance.destory();
                        this.j = true;
                        b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                        return;
                    }
                    a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
                }
            }
            this.r = j;
            if (!this.n.a()) {
            }
        }
        bDFaceImageInstance.destory();
    }

    private void a(byte[] bArr) {
        if (p > 0) {
            return;
        }
        p++;
        new a(bArr).run();
    }

    private boolean a(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum != null) {
            this.o.a(this.m);
            boolean a2 = this.o.a(faceStatusNewEnum);
            if (a2) {
                com.baidu.pass.face.platform.a.a.a(faceStatusNewEnum.name());
                b(faceStatusNewEnum, faceExtInfo);
                return a2;
            }
            return a2;
        }
        return false;
    }

    private boolean a(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, int i) {
        float b = this.n.b();
        this.h.a(this.l);
        BDFaceImageInstance b2 = FaceSDKManager.getInstance().b(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.l.getCropHeight(), this.l.getCropWidth());
        if (b2 == null) {
            return false;
        }
        a(faceExtInfo, b2, i, b);
        b2.destory();
        b(faceExtInfo, bDFaceImageInstance, i, b);
        return true;
    }

    private void b(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
            com.baidu.pass.face.platform.a.a.a();
        }
        IDetectStrategyCallback iDetectStrategyCallback = this.e;
        if (iDetectStrategyCallback != null) {
            if (faceStatusNewEnum != FaceStatusNewEnum.OK) {
                iDetectStrategyCallback.onDetectCompletion(faceStatusNewEnum, a(faceStatusNewEnum), null, null);
                return;
            }
            this.j = true;
            this.k = true;
            com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
            com.baidu.pass.face.platform.a.a.a("finish", 1);
            com.baidu.pass.face.platform.a.a.a();
            this.e.onDetectCompletion(faceStatusNewEnum, a(faceStatusNewEnum), this.t, this.u);
        }
    }

    private void b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> b = this.h.b(faceExtInfo, bDFaceImageInstance);
        if (b == null || b.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.u;
        hashMap.put("bestSrcDetectImage_" + i + "_" + f + "_" + System.currentTimeMillis(), b.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr) {
        try {
            BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.c.width(), this.c.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.g, 1);
            FaceInfo[] a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance);
            com.baidu.pass.face.platform.model.a a3 = a(a2, bDFaceImageInstance);
            if (this.f != null) {
                this.f.getFaceInfoForSecurity(a2);
            }
            a(a3, bDFaceImageInstance);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(FaceConfig faceConfig) {
        this.l = faceConfig;
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void detectStrategy(byte[] bArr) {
        if (!this.i) {
            this.i = true;
            a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
        } else if (this.j) {
        } else {
            a(bArr);
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void reset() {
        this.q = 0;
        com.baidu.pass.face.platform.a.b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        HashMap<String, ImageInfo> hashMap = this.t;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.u;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        this.i = false;
        this.j = false;
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback) {
        this.c = rect;
        this.d = rect2;
        this.e = iDetectStrategyCallback;
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setDetectStrategySoundEnable(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        this.f = iSecurityCallback;
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setPreviewDegree(int i) {
        this.g = i;
    }
}
