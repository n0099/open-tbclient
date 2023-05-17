package com.baidu.pass.face.platform.c;

import android.graphics.Rect;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d {
    public static final String a = "d";
    public List<LivenessTypeEnum> b;
    public volatile int d;
    public boolean e = false;
    public volatile LivenessTypeEnum f = null;
    public long g = -1;
    public HashMap<LivenessTypeEnum, Boolean> h = new HashMap<>();
    public long i = 0;
    public long j = 0;
    public long c = 0;

    /* renamed from: com.baidu.pass.face.platform.c.d$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LivenessTypeEnum.values().length];
            a = iArr;
            try {
                iArr[LivenessTypeEnum.Eye.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LivenessTypeEnum.Mouth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LivenessTypeEnum.HeadUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LivenessTypeEnum.HeadDown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LivenessTypeEnum.HeadLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LivenessTypeEnum.HeadRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public d() {
        this.d = 0;
        this.d = 0;
    }

    private void k() {
        this.h.clear();
        for (int i = 0; i < this.b.size(); i++) {
            this.h.put(this.b.get(i), Boolean.FALSE);
        }
    }

    public LivenessTypeEnum a() {
        return this.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ba, code lost:
        if (r0.get() != 1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01d9, code lost:
        if (r0.get() == 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01dc, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01dd, code lost:
        r6.put(r1, java.lang.Boolean.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01f9, code lost:
        if (r0.get() == 1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r0.get() == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ba, code lost:
        if (r0.get() != 1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d9, code lost:
        if (r0.get() == 1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fa, code lost:
        if (r0.get() != 1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0119, code lost:
        if (r0.get() == 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011b, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011d, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013a, code lost:
        if (r0.get() != 1) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0159, code lost:
        if (r0.get() == 1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015b, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015d, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017a, code lost:
        if (r0.get() != 1) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0199, code lost:
        if (r0.get() == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x019b, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x019d, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        HashMap<LivenessTypeEnum, Boolean> hashMap;
        LivenessTypeEnum livenessTypeEnum;
        boolean z;
        HashMap<LivenessTypeEnum, Boolean> hashMap2;
        LivenessTypeEnum livenessTypeEnum2;
        boolean z2;
        HashMap<LivenessTypeEnum, Boolean> hashMap3;
        LivenessTypeEnum livenessTypeEnum3;
        boolean z3;
        HashMap<LivenessTypeEnum, Boolean> hashMap4;
        LivenessTypeEnum livenessTypeEnum4;
        boolean z4;
        HashMap<LivenessTypeEnum, Boolean> hashMap5;
        LivenessTypeEnum livenessTypeEnum5;
        boolean z5;
        HashMap<LivenessTypeEnum, Boolean> hashMap6;
        LivenessTypeEnum livenessTypeEnum6;
        FaceSDKManager faceSDKManager;
        BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType;
        if (this.j == 0) {
            this.j = System.currentTimeMillis();
        }
        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
        long currentTimeMillis = System.currentTimeMillis() - this.j;
        long timeDetectModule = faceConfig.getTimeDetectModule();
        boolean z6 = true;
        if (currentTimeMillis > timeDetectModule) {
            this.e = true;
        } else if (faceExtInfo != null) {
            if (faceExtInfo.getFaceId() != this.g) {
                this.g = faceExtInfo.getFaceId();
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            switch (AnonymousClass1.a[this.f.ordinal()]) {
                case 1:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye) && !this.h.containsKey(LivenessTypeEnum.Eye)) {
                        hashMap = this.h;
                        livenessTypeEnum = LivenessTypeEnum.Eye;
                        break;
                    } else {
                        if (this.f == LivenessTypeEnum.Eye && atomicInteger.get() == 1) {
                            hashMap = this.h;
                            livenessTypeEnum = LivenessTypeEnum.Eye;
                            break;
                        }
                        if (!this.b.contains(LivenessTypeEnum.Mouth) && !this.h.containsKey(LivenessTypeEnum.Mouth)) {
                            hashMap2 = this.h;
                            livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                            break;
                        } else {
                            if (this.f == LivenessTypeEnum.Mouth && atomicInteger.get() == 1) {
                                hashMap2 = this.h;
                                livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                                break;
                            }
                            if (!this.b.contains(LivenessTypeEnum.HeadUp) && !this.h.containsKey(LivenessTypeEnum.HeadUp)) {
                                hashMap3 = this.h;
                                livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                                break;
                            } else {
                                if (this.f == LivenessTypeEnum.HeadUp && atomicInteger.get() == 1) {
                                    hashMap3 = this.h;
                                    livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                                    break;
                                }
                                if (!this.b.contains(LivenessTypeEnum.HeadDown) && !this.h.containsKey(LivenessTypeEnum.HeadDown)) {
                                    hashMap4 = this.h;
                                    livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                                    break;
                                } else {
                                    if (this.f == LivenessTypeEnum.HeadDown && atomicInteger.get() == 1) {
                                        hashMap4 = this.h;
                                        livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                                        break;
                                    }
                                    if (!this.b.contains(LivenessTypeEnum.HeadLeft) && !this.h.containsKey(LivenessTypeEnum.HeadLeft)) {
                                        hashMap5 = this.h;
                                        livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                        break;
                                    } else {
                                        if (this.f == LivenessTypeEnum.HeadLeft && atomicInteger.get() == 1) {
                                            hashMap5 = this.h;
                                            livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                            break;
                                        }
                                        if (!this.b.contains(LivenessTypeEnum.HeadRight) && !this.h.containsKey(LivenessTypeEnum.HeadRight)) {
                                            hashMap6 = this.h;
                                            livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
                                            break;
                                        } else if (this.f != LivenessTypeEnum.HeadRight && atomicInteger.get() == 1) {
                                            hashMap6 = this.h;
                                            livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
                                            break;
                                        } else {
                                            return;
                                        }
                                    }
                                    hashMap5.put(livenessTypeEnum5, Boolean.valueOf(z5));
                                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                                    }
                                    if (this.f != LivenessTypeEnum.HeadRight) {
                                        return;
                                    }
                                    return;
                                }
                                hashMap4.put(livenessTypeEnum4, Boolean.valueOf(z4));
                                if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                                }
                                if (this.f == LivenessTypeEnum.HeadLeft) {
                                    hashMap5 = this.h;
                                    livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                }
                                if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                                }
                                if (this.f != LivenessTypeEnum.HeadRight) {
                                }
                            }
                            hashMap3.put(livenessTypeEnum3, Boolean.valueOf(z3));
                            if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                            }
                            if (this.f == LivenessTypeEnum.HeadDown) {
                                hashMap4 = this.h;
                                livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                            }
                            if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                            }
                            if (this.f == LivenessTypeEnum.HeadLeft) {
                            }
                            if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                            }
                            if (this.f != LivenessTypeEnum.HeadRight) {
                            }
                        }
                        hashMap2.put(livenessTypeEnum2, Boolean.valueOf(z2));
                        if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f == LivenessTypeEnum.HeadUp) {
                            hashMap3 = this.h;
                            livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                        }
                        if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f != LivenessTypeEnum.HeadRight) {
                        }
                    }
                    hashMap.put(livenessTypeEnum, Boolean.valueOf(z));
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                        hashMap2 = this.h;
                        livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                case 2:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                        break;
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                        hashMap = this.h;
                        livenessTypeEnum = LivenessTypeEnum.Eye;
                        break;
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                case 3:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                case 4:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                case 5:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                case 6:
                    faceSDKManager = FaceSDKManager.getInstance();
                    bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT;
                    faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
                default:
                    if (!this.b.contains(LivenessTypeEnum.Eye)) {
                    }
                    if (this.f == LivenessTypeEnum.Eye) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.Mouth)) {
                    }
                    if (this.f == LivenessTypeEnum.Mouth) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadUp)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadUp) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadDown)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadDown) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadLeft)) {
                    }
                    if (this.f == LivenessTypeEnum.HeadLeft) {
                    }
                    if (!this.b.contains(LivenessTypeEnum.HeadRight)) {
                    }
                    if (this.f != LivenessTypeEnum.HeadRight) {
                    }
                    break;
            }
        }
    }

    public void a(List<LivenessTypeEnum> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b = list;
        this.f = list.get(0);
        k();
    }

    public boolean a(FaceConfig faceConfig) {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.c > faceConfig.getTimeLivenessCourse();
    }

    public FaceStatusNewEnum b() {
        if (this.f != null) {
            switch (AnonymousClass1.a[this.f.ordinal()]) {
                case 1:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
                case 2:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
                case 3:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
                case 4:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
                case 5:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
                case 6:
                    return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
            }
        }
        return null;
    }

    public boolean c() {
        boolean z;
        Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.h.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<LivenessTypeEnum, Boolean> next = it.next();
            if (!next.getValue().booleanValue()) {
                z = false;
                next.getKey().name();
                break;
            }
        }
        if (z) {
            this.j = 0L;
        }
        return z;
    }

    public boolean d() {
        boolean booleanValue = this.h.containsKey(this.f) ? this.h.get(this.f).booleanValue() : false;
        if (booleanValue) {
            this.j = 0L;
        }
        return booleanValue;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d + 1 < this.b.size();
    }

    public int g() {
        return this.d + 1;
    }

    public void h() {
        this.d++;
        this.f = this.b.get(this.d);
        this.c = 0L;
    }

    public void i() {
        this.d = 0;
        k();
        if (this.b != null && this.d < this.b.size()) {
            this.f = this.b.get(this.d);
        }
        this.c = 0L;
        this.e = false;
        this.j = 0L;
    }

    public void j() {
        this.c = 0L;
    }
}
