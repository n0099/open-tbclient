package com.baidu.pass.face.platform.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.pass.face.platform.ILivenessStrategyCallback;
import com.baidu.pass.face.platform.ILivenessViewCallback;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements ILivenessStrategy {
    public static final String a = "c";
    public static volatile int u;
    public boolean A;
    public Context b;
    public Rect c;
    public Rect d;
    public com.baidu.pass.face.platform.c.a e;
    public d f;
    public com.baidu.pass.face.platform.b.a g;
    public ILivenessStrategyCallback h;
    public ILivenessViewCallback i;
    public ISecurityCallback j;
    public com.baidu.pass.face.platform.a.b l;
    public int m;
    public boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public FaceConfig t;
    public boolean w;
    public int z;
    public volatile boolean k = true;
    public Map<FaceStatusNewEnum, String> q = new HashMap();
    public HashMap<String, ImageInfo> r = new HashMap<>();
    public HashMap<String, ImageInfo> s = new HashMap<>();
    public long v = 0;
    public volatile EnumC0121c x = EnumC0121c.LivenessCrop;
    public long y = -1;

    /* renamed from: com.baidu.pass.face.platform.c.c$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC0121c.values().length];
            b = iArr;
            try {
                iArr[EnumC0121c.LivenessReady.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC0121c.LivenessTips.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC0121c.LivenessOK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            a = iArr2;
            try {
                iArr2[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public byte[] b;

        public a(byte[] bArr) {
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(this.b);
            c.a();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public Bitmap b;

        public b(Bitmap bitmap) {
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(this.b);
            c.a();
        }
    }

    /* renamed from: com.baidu.pass.face.platform.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0121c {
        LivenessReady,
        LivenessTips,
        LivenessOK,
        LivenessCourse,
        LivenessCrop
    }

    public c(Context context) {
        this.l = null;
        com.baidu.pass.face.platform.a.a.b();
        com.baidu.pass.face.platform.a.a.b("ca", "Baidu-IDL-FaceSDK4.1.1");
        com.baidu.pass.face.platform.a.a.b("version", "4.1.1");
        com.baidu.pass.face.platform.a.a.b("stm", Long.valueOf(System.currentTimeMillis()));
        this.b = context;
        this.e = new com.baidu.pass.face.platform.c.a();
        this.f = new d();
        this.g = new com.baidu.pass.face.platform.b.a();
        this.l = new com.baidu.pass.face.platform.a.b(context);
    }

    public static /* synthetic */ int a() {
        int i = u - 1;
        u = i;
        return i;
    }

    private com.baidu.pass.face.platform.model.a a(FaceInfo[] faceInfoArr) {
        FaceExtInfo[] a2 = this.g.a(faceInfoArr);
        com.baidu.pass.face.platform.model.a aVar = new com.baidu.pass.face.platform.model.a();
        aVar.a(a2);
        aVar.a(this.e.a(this.d, a2, this.t));
        aVar.a(System.currentTimeMillis());
        return aVar;
    }

    private String a(FaceStatusNewEnum faceStatusNewEnum) {
        Context context;
        if (this.q.containsKey(faceStatusNewEnum)) {
            return this.q.get(faceStatusNewEnum);
        }
        int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
        if (tipsId <= 0 || (context = this.b) == null) {
            return "";
        }
        String string = context.getResources().getString(tipsId);
        this.q.put(faceStatusNewEnum, string);
        return string;
    }

    private void a(Bitmap bitmap) {
        if (u > 0) {
            return;
        }
        u++;
        new b(bitmap).run();
    }

    private void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> a2 = this.g.a(faceExtInfo, bDFaceImageInstance);
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.r;
        hashMap.put("bestCropImage_" + i + "_" + f + "_" + System.currentTimeMillis(), a2.get(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:
        if (r11.f.e() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.pass.face.platform.model.a aVar, BDFaceImageInstance bDFaceImageInstance) {
        EnumC0121c enumC0121c;
        if (bDFaceImageInstance == null) {
            return;
        }
        if (this.o) {
            bDFaceImageInstance.destory();
        } else if (aVar == null || aVar.b() == null || aVar.b().length == 0) {
            bDFaceImageInstance.destory();
            com.baidu.pass.face.platform.c.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.c();
            }
        } else {
            FaceStatusNewEnum a2 = aVar.a();
            FaceExtInfo faceExtInfo = aVar.b()[0];
            if (a2 != FaceStatusNewEnum.OK) {
                if (!this.e.a()) {
                    if (AnonymousClass1.a[a2.ordinal()] != 1) {
                        bDFaceImageInstance.destory();
                        a(a2, faceExtInfo);
                        this.e.c();
                        this.f.j();
                        return;
                    }
                    if (this.v == 0) {
                        this.v = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.v <= this.t.getTimeDetectModule()) {
                        if (this.w && this.v != 0 && System.currentTimeMillis() - this.v < FaceEnvironment.TIME_DETECT_NO_FACE_CONTINUOUS) {
                            bDFaceImageInstance.destory();
                            return;
                        }
                        this.w = false;
                        bDFaceImageInstance.destory();
                        this.e.c();
                        this.f.j();
                        a(a2, (FaceExtInfo) null);
                        return;
                    }
                }
            } else if (faceExtInfo == null) {
                return;
            } else {
                this.i.setFaceInfo(faceExtInfo);
                if (this.x == EnumC0121c.LivenessCrop) {
                    if (this.z >= this.t.getCacheImageNum()) {
                        this.x = EnumC0121c.LivenessReady;
                    } else if (a(bDFaceImageInstance, faceExtInfo, this.f.a(), this.z)) {
                        this.z++;
                    }
                }
                if (this.x == EnumC0121c.LivenessReady || this.x == EnumC0121c.LivenessTips) {
                    if (faceExtInfo.getFaceId() != this.y) {
                        this.f.i();
                        FaceSDKManager.getInstance().a();
                        if (this.y != -1) {
                            this.x = EnumC0121c.LivenessCrop;
                            this.z = 0;
                            HashMap<String, ImageInfo> hashMap = this.r;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            HashMap<String, ImageInfo> hashMap2 = this.s;
                            if (hashMap2 != null) {
                                hashMap2.clear();
                            }
                        }
                        this.i.viewReset();
                        this.y = faceExtInfo.getFaceId();
                    }
                    this.f.a(faceExtInfo, bDFaceImageInstance, this.c);
                }
                this.v = 0L;
                com.baidu.pass.face.platform.a.a.a("btm", Long.valueOf(System.currentTimeMillis()));
                int i = AnonymousClass1.b[this.x.ordinal()];
                if (i == 1) {
                    if (a(this.f.b(), faceExtInfo)) {
                        enumC0121c = EnumC0121c.LivenessTips;
                        this.x = enumC0121c;
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (i != 2) {
                    if (i == 3 && a(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                        if (!this.w) {
                            this.w = true;
                        }
                        if (this.f.f()) {
                            this.f.h();
                            enumC0121c = EnumC0121c.LivenessReady;
                            this.x = enumC0121c;
                        } else if (this.f.c()) {
                            b(FaceStatusNewEnum.OK, faceExtInfo);
                        }
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (this.f.d()) {
                    enumC0121c = EnumC0121c.LivenessOK;
                    this.x = enumC0121c;
                    bDFaceImageInstance.destory();
                    return;
                } else {
                    a(this.f.b(), faceExtInfo);
                    b();
                }
            }
            bDFaceImageInstance.destory();
            this.o = true;
            b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
        }
    }

    private void a(byte[] bArr) {
        if (u > 0) {
            return;
        }
        u++;
        new a(bArr).run();
    }

    private boolean a(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        if (faceStatusNewEnum != null) {
            this.l.a(this.k);
            boolean a2 = this.l.a(faceStatusNewEnum);
            if (a2) {
                com.baidu.pass.face.platform.a.a.a(faceStatusNewEnum.name());
                b(faceStatusNewEnum, faceExtInfo);
                return a2;
            }
            return a2;
        }
        return false;
    }

    private boolean a(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i) {
        FaceStatusNewEnum a2;
        FaceStatusNewEnum a3 = this.e.a(faceExtInfo, this.t);
        if (a3 != FaceStatusNewEnum.OK) {
            this.h.onLivenessCompletion(a3, a(a3), null, null, 0);
            return false;
        } else if (this.t.isNoBlackCropImage() && (a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.t.getCropHeight(), this.t.getCropWidth())) != FaceStatusNewEnum.OK) {
            this.h.onLivenessCompletion(a2, a(a2), null, null, 0);
            return false;
        } else {
            float b2 = this.e.b();
            this.g.a(this.t);
            BDFaceImageInstance b3 = FaceSDKManager.getInstance().b(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.t.getCropHeight(), this.t.getCropWidth());
            if (b3 == null) {
                return false;
            }
            a(faceExtInfo, b3, i, b2);
            b3.destory();
            b(faceExtInfo, bDFaceImageInstance, i, b2);
            return true;
        }
    }

    private void b() {
        if (!this.f.a(this.t) || this.A) {
            return;
        }
        ILivenessViewCallback iLivenessViewCallback = this.i;
        if (iLivenessViewCallback != null) {
            iLivenessViewCallback.setCurrentLiveType(this.f.a());
        }
        b(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, null);
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bitmap bitmap) {
        try {
            if (bitmap.isRecycled()) {
                return;
            }
            BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bitmap);
            a(a(FaceSDKManager.getInstance().a(bDFaceImageInstance)), bDFaceImageInstance);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        ILivenessStrategyCallback iLivenessStrategyCallback;
        String a2;
        FaceStatusNewEnum faceStatusNewEnum2;
        HashMap<String, ImageInfo> hashMap;
        HashMap<String, ImageInfo> hashMap2;
        int g;
        if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
            com.baidu.pass.face.platform.a.a.a();
        }
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            this.o = true;
            this.p = true;
            com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
            com.baidu.pass.face.platform.a.a.a("finish", 1);
            com.baidu.pass.face.platform.a.a.a();
            iLivenessStrategyCallback = this.h;
            if (iLivenessStrategyCallback == null) {
                return;
            }
        } else if (faceStatusNewEnum != FaceStatusNewEnum.FaceLivenessActionComplete) {
            iLivenessStrategyCallback = this.h;
            if (iLivenessStrategyCallback != null) {
                a2 = a(faceStatusNewEnum);
                HashMap<String, ImageInfo> hashMap3 = this.r;
                faceStatusNewEnum2 = faceStatusNewEnum;
                hashMap = hashMap3;
                hashMap2 = this.s;
                g = this.f.g() - 1;
                iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g);
            }
            return;
        } else {
            iLivenessStrategyCallback = this.h;
            if (iLivenessStrategyCallback == null) {
                return;
            }
        }
        a2 = a(faceStatusNewEnum);
        hashMap = this.r;
        hashMap2 = this.s;
        g = this.f.g();
        faceStatusNewEnum2 = faceStatusNewEnum;
        iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g);
    }

    private void b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> b2 = this.g.b(faceExtInfo, bDFaceImageInstance);
        if (b2 == null || b2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.s;
        hashMap.put("bestSrcImage_" + i + "_" + f + "_" + System.currentTimeMillis(), b2.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr) {
        try {
            BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.c.width(), this.c.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.m, 1);
            FaceInfo[] a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance);
            if (this.j != null) {
                this.j.getFaceInfoForSecurity(a2);
            }
            a(a(a2), bDFaceImageInstance);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(FaceConfig faceConfig) {
        this.t = faceConfig;
    }

    public void a(ILivenessViewCallback iLivenessViewCallback) {
        this.i = iLivenessViewCallback;
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void livenessStrategy(Bitmap bitmap) {
        if (!this.n) {
            this.n = true;
            a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
        } else if (this.o) {
        } else {
            a(bitmap);
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void livenessStrategy(byte[] bArr) {
        if (!this.n) {
            this.n = true;
            a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
        } else if (this.o) {
        } else {
            a(bArr);
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void reset() {
        FaceSDKManager.getInstance().a();
        d dVar = this.f;
        if (dVar != null) {
            dVar.i();
        }
        HashMap<String, ImageInfo> hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, ImageInfo> hashMap2 = this.s;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        com.baidu.pass.face.platform.a.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
        this.n = false;
        this.o = false;
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        this.j = iSecurityCallback;
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback) {
        this.f.a(list);
        this.c = rect;
        this.d = rect2;
        this.h = iLivenessStrategyCallback;
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setLivenessStrategySoundEnable(boolean z) {
        this.k = z;
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setPreviewDegree(int i) {
        this.m = i;
    }
}
