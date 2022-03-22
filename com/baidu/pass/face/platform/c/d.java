package com.baidu.pass.face.platform.c;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<LivenessTypeEnum> f28101b;

    /* renamed from: c  reason: collision with root package name */
    public long f28102c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f28103d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28104e;

    /* renamed from: f  reason: collision with root package name */
    public volatile LivenessTypeEnum f28105f;

    /* renamed from: g  reason: collision with root package name */
    public long f28106g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<LivenessTypeEnum, Boolean> f28107h;
    public long i;
    public long j;

    /* renamed from: com.baidu.pass.face.platform.c.d$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1667460592, "Lcom/baidu/pass/face/platform/c/d$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1667460592, "Lcom/baidu/pass/face/platform/c/d$1;");
                    return;
                }
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360275619, "Lcom/baidu/pass/face/platform/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360275619, "Lcom/baidu/pass/face/platform/c/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28103d = 0;
        this.f28104e = false;
        this.f28105f = null;
        this.f28106g = -1L;
        this.f28107h = new HashMap<>();
        this.i = 0L;
        this.j = 0L;
        this.f28103d = 0;
        this.f28102c = 0L;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f28107h.clear();
            for (int i = 0; i < this.f28101b.size(); i++) {
                this.f28107h.put(this.f28101b.get(i), Boolean.FALSE);
            }
        }
    }

    public LivenessTypeEnum a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28105f : (LivenessTypeEnum) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01be, code lost:
        if (r0.get() != 1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01dd, code lost:
        if (r0.get() == 1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e0, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01e1, code lost:
        r6.put(r1, java.lang.Boolean.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01fd, code lost:
        if (r0.get() == 1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
        if (r0.get() == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
        if (r0.get() != 1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
        if (r0.get() == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00df, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fe, code lost:
        if (r0.get() != 1) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011d, code lost:
        if (r0.get() == 1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0121, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013e, code lost:
        if (r0.get() != 1) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015d, code lost:
        if (r0.get() == 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x015f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0161, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017e, code lost:
        if (r0.get() != 1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x019d, code lost:
        if (r0.get() == 1) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x019f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a1, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018b  */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceExtInfo, bDFaceImageInstance, rect) == null) {
            if (this.j == 0) {
                this.j = System.currentTimeMillis();
            }
            FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
            long currentTimeMillis = System.currentTimeMillis() - this.j;
            long timeDetectModule = faceConfig.getTimeDetectModule();
            boolean z6 = true;
            if (currentTimeMillis > timeDetectModule) {
                this.f28104e = true;
            } else if (faceExtInfo != null) {
                if (faceExtInfo.getFaceId() != this.f28106g) {
                    this.f28106g = faceExtInfo.getFaceId();
                }
                AtomicInteger atomicInteger = new AtomicInteger();
                switch (AnonymousClass1.a[this.f28105f.ordinal()]) {
                    case 1:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye) && !this.f28107h.containsKey(LivenessTypeEnum.Eye)) {
                            hashMap = this.f28107h;
                            livenessTypeEnum = LivenessTypeEnum.Eye;
                            break;
                        } else {
                            if (this.f28105f == LivenessTypeEnum.Eye && atomicInteger.get() == 1) {
                                hashMap = this.f28107h;
                                livenessTypeEnum = LivenessTypeEnum.Eye;
                                break;
                            }
                            if (!this.f28101b.contains(LivenessTypeEnum.Mouth) && !this.f28107h.containsKey(LivenessTypeEnum.Mouth)) {
                                hashMap2 = this.f28107h;
                                livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                                break;
                            } else {
                                if (this.f28105f == LivenessTypeEnum.Mouth && atomicInteger.get() == 1) {
                                    hashMap2 = this.f28107h;
                                    livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                                    break;
                                }
                                if (!this.f28101b.contains(LivenessTypeEnum.HeadUp) && !this.f28107h.containsKey(LivenessTypeEnum.HeadUp)) {
                                    hashMap3 = this.f28107h;
                                    livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                                    break;
                                } else {
                                    if (this.f28105f == LivenessTypeEnum.HeadUp && atomicInteger.get() == 1) {
                                        hashMap3 = this.f28107h;
                                        livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                                        break;
                                    }
                                    if (!this.f28101b.contains(LivenessTypeEnum.HeadDown) && !this.f28107h.containsKey(LivenessTypeEnum.HeadDown)) {
                                        hashMap4 = this.f28107h;
                                        livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                                        break;
                                    } else {
                                        if (this.f28105f == LivenessTypeEnum.HeadDown && atomicInteger.get() == 1) {
                                            hashMap4 = this.f28107h;
                                            livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                                            break;
                                        }
                                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft) && !this.f28107h.containsKey(LivenessTypeEnum.HeadLeft)) {
                                            hashMap5 = this.f28107h;
                                            livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                            break;
                                        } else {
                                            if (this.f28105f == LivenessTypeEnum.HeadLeft && atomicInteger.get() == 1) {
                                                hashMap5 = this.f28107h;
                                                livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                                break;
                                            }
                                            if (!this.f28101b.contains(LivenessTypeEnum.HeadRight) && !this.f28107h.containsKey(LivenessTypeEnum.HeadRight)) {
                                                hashMap6 = this.f28107h;
                                                livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
                                                break;
                                            } else if (this.f28105f != LivenessTypeEnum.HeadRight && atomicInteger.get() == 1) {
                                                hashMap6 = this.f28107h;
                                                livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
                                                break;
                                            } else {
                                                return;
                                            }
                                        }
                                        hashMap5.put(livenessTypeEnum5, Boolean.valueOf(z5));
                                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                                        }
                                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                                            return;
                                        }
                                        return;
                                    }
                                    hashMap4.put(livenessTypeEnum4, Boolean.valueOf(z4));
                                    if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                                    }
                                    if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                                        hashMap5 = this.f28107h;
                                        livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
                                    }
                                    if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                                    }
                                    if (this.f28105f != LivenessTypeEnum.HeadRight) {
                                    }
                                }
                                hashMap3.put(livenessTypeEnum3, Boolean.valueOf(z3));
                                if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                                }
                                if (this.f28105f == LivenessTypeEnum.HeadDown) {
                                    hashMap4 = this.f28107h;
                                    livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
                                }
                                if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                                }
                                if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                                }
                                if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                                }
                                if (this.f28105f != LivenessTypeEnum.HeadRight) {
                                }
                            }
                            hashMap2.put(livenessTypeEnum2, Boolean.valueOf(z2));
                            if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                            }
                            if (this.f28105f == LivenessTypeEnum.HeadUp) {
                                hashMap3 = this.f28107h;
                                livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
                            }
                            if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                            }
                            if (this.f28105f == LivenessTypeEnum.HeadDown) {
                            }
                            if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                            }
                            if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                            }
                            if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                            }
                            if (this.f28105f != LivenessTypeEnum.HeadRight) {
                            }
                        }
                        hashMap.put(livenessTypeEnum, Boolean.valueOf(z));
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                            hashMap2 = this.f28107h;
                            livenessTypeEnum2 = LivenessTypeEnum.Mouth;
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    case 2:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                            break;
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                            hashMap = this.f28107h;
                            livenessTypeEnum = LivenessTypeEnum.Eye;
                            break;
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    case 3:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    case 4:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    case 5:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    case 6:
                        faceSDKManager = FaceSDKManager.getInstance();
                        bDFaceActionLiveType = BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT;
                        faceSDKManager.a(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger);
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                    default:
                        if (!this.f28101b.contains(LivenessTypeEnum.Eye)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Eye) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.Mouth)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.Mouth) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadUp)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadUp) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadDown)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadDown) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadLeft)) {
                        }
                        if (this.f28105f == LivenessTypeEnum.HeadLeft) {
                        }
                        if (!this.f28101b.contains(LivenessTypeEnum.HeadRight)) {
                        }
                        if (this.f28105f != LivenessTypeEnum.HeadRight) {
                        }
                        break;
                }
            }
        }
    }

    public void a(List<LivenessTypeEnum> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.f28101b = list;
        this.f28105f = list.get(0);
        k();
    }

    public boolean a(FaceConfig faceConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, faceConfig)) == null) {
            if (this.f28102c == 0) {
                this.f28102c = System.currentTimeMillis();
            }
            return System.currentTimeMillis() - this.f28102c > faceConfig.getTimeLivenessCourse();
        }
        return invokeL.booleanValue;
    }

    public FaceStatusNewEnum b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28105f != null) {
                switch (AnonymousClass1.a[this.f28105f.ordinal()]) {
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
        return (FaceStatusNewEnum) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.f28107h.entrySet().iterator();
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
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean booleanValue = this.f28107h.containsKey(this.f28105f) ? this.f28107h.get(this.f28105f).booleanValue() : false;
            if (booleanValue) {
                this.j = 0L;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28104e : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28103d + 1 < this.f28101b.size() : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28103d + 1 : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f28103d++;
            this.f28105f = this.f28101b.get(this.f28103d);
            this.f28102c = 0L;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f28103d = 0;
            k();
            if (this.f28101b != null && this.f28103d < this.f28101b.size()) {
                this.f28105f = this.f28101b.get(this.f28103d);
            }
            this.f28102c = 0L;
            this.f28104e = false;
            this.j = 0L;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f28102c = 0L;
        }
    }
}
