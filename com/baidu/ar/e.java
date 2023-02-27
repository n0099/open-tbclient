package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthCallback;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.n;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.c;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public com.baidu.ar.filter.a B;
    public DuMixInput V;
    public DuMixOutput W;
    public DuMixCallback aa;
    public List<Integer> ab;
    public com.baidu.ar.lua.c ac;
    public b ad;
    public CaseModel ah;
    public String ai;
    public String aj;
    public CaseModel al;
    public a as;
    public DefaultParams d;
    public com.baidu.ar.lua.b f;
    public com.baidu.ar.arrender.c g;
    public Context mContext;
    public boolean ae = false;
    public boolean af = false;
    public boolean ag = false;
    public volatile boolean ak = false;
    public boolean am = false;
    public boolean an = true;
    public boolean ao = false;
    public boolean ap = false;
    public boolean aq = false;
    public boolean ar = true;
    public ConcurrentHashMap<PixelReadParams, PixelReadListener> at = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.ar.e$8  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] ax;

        static {
            int[] iArr = new int[ARType.values().length];
            ax = iArr;
            try {
                iArr[ARType.IMU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ax[ARType.TRACK_2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ax[ARType.CLOUD_IR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ax[ARType.ON_DEVICE_IR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                ax[ARType.VO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 4001:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_CREATE_CASE");
                    CaseModel caseModel = (CaseModel) message.obj;
                    e.this.c(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                    return;
                case 4002:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_DESTROY_CASE");
                    e.this.J();
                    return;
                case 4003:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CREATE");
                    e.this.K();
                    return;
                case 4004:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CHANGE");
                    e.this.c((List) ((HashMap) message.obj).get("filter_name_list"));
                    return;
                case 4005:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_CREATE");
                    e.this.L();
                    return;
                case 4006:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_DESTROY");
                    e.this.M();
                    return;
                case 4007:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_CREATE");
                    e.this.N();
                    return;
                case 4008:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_DESTROY");
                    e.this.O();
                    return;
                default:
                    return;
            }
        }
    }

    public e(Context context, DefaultParams defaultParams, HandlerThread handlerThread) {
        this.mContext = context;
        this.d = defaultParams;
        this.as = new a(handlerThread.getLooper());
    }

    private void B() {
        this.ab = Arrays.asList(12, 50, 6, 7, 8, 9);
        com.baidu.ar.lua.c cVar = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.e.3
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                a aVar;
                a aVar2;
                int i3;
                Message message;
                com.baidu.ar.h.b.c("ControllerHelper", "onEngineMessage msgType = " + i + " && msgId = " + i2);
                if (i != 12) {
                    if (i == 50) {
                        if (e.this.as != null) {
                            aVar = e.this.as;
                            message = e.this.as.obtainMessage(4004, hashMap);
                            aVar.sendMessage(message);
                        }
                        return;
                    }
                    switch (i) {
                        case 6:
                            if (e.this.as != null) {
                                aVar = e.this.as;
                                aVar2 = e.this.as;
                                i3 = 4005;
                                break;
                            } else {
                                return;
                            }
                        case 7:
                            if (e.this.as != null) {
                                aVar = e.this.as;
                                aVar2 = e.this.as;
                                i3 = 4006;
                                break;
                            } else {
                                return;
                            }
                        case 8:
                            e.this.g.bw();
                            if (e.this.as != null) {
                                aVar = e.this.as;
                                aVar2 = e.this.as;
                                i3 = 4007;
                                break;
                            } else {
                                return;
                            }
                        case 9:
                            if (e.this.as != null) {
                                aVar = e.this.as;
                                aVar2 = e.this.as;
                                i3 = 4008;
                                break;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                } else if (e.this.as == null) {
                    return;
                } else {
                    aVar = e.this.as;
                    aVar2 = e.this.as;
                    i3 = 4003;
                }
                message = aVar2.obtainMessage(i3);
                aVar.sendMessage(message);
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return e.this.ab;
            }
        };
        this.ac = cVar;
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.c(cVar);
        }
    }

    private void C() {
        com.baidu.ar.libloader.a.load(this.mContext, new ILibLoader.b() { // from class: com.baidu.ar.e.4
            @Override // com.baidu.ar.libloader.ILibLoader.b
            public void onSuccess() {
            }
        });
    }

    private void D() {
        ARAuth.loadAuthInfo(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        Bitmap createTipBitmap;
        if (this.g == null || this.W == null || (createTipBitmap = ARAuth.createTipBitmap(this.mContext)) == null) {
            return;
        }
        float outputWidth = ((this.W.getOutputWidth() * createTipBitmap.getHeight()) * 0.78125f) / (this.W.getOutputHeight() * createTipBitmap.getWidth());
        this.g.a(createTipBitmap, 0.109375f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
    }

    private void H() {
        if (this.ad == null) {
            return;
        }
        if (this.ao && this.al != null && I()) {
            this.ad.g();
        } else {
            this.ad.f();
        }
    }

    private boolean I() {
        ARType aRType = this.al.mCaseType;
        return (aRType == null || aRType == ARType.FACE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        H();
        com.baidu.ar.arrender.c cVar = this.g;
        if (cVar != null) {
            cVar.bB();
        }
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        com.baidu.ar.filter.a aVar = this.B;
        if (aVar != null) {
            aVar.bv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.ae = true;
        com.baidu.ar.filter.a aVar = this.B;
        if (aVar != null && !this.ap) {
            aVar.eE();
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        b bVar = this.ad;
        if (bVar != null) {
            bVar.e();
        }
        com.baidu.ar.arrender.c cVar = this.g;
        if (cVar != null) {
            cVar.o(true);
        }
        this.af = true;
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        DuMixCallback duMixCallback = this.aa;
        if (duMixCallback != null) {
            duMixCallback.onRelease();
            this.aa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        a aVar;
        this.am = true;
        this.ap = false;
        b bVar = this.ad;
        if (bVar != null) {
            bVar.onCaseCreate(this.ai + File.separator + "ar");
        }
        if ((this.ao || this.aq) && (aVar = this.as) != null) {
            aVar.removeMessages(4002);
            a aVar2 = this.as;
            aVar2.sendMessage(aVar2.obtainMessage(4002));
        } else {
            this.an = true;
        }
        DuMixCallback duMixCallback = this.aa;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(true, this.ai, this.aj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        CaseModel caseModel;
        this.am = false;
        H();
        b bVar = this.ad;
        if (bVar != null) {
            bVar.onCaseDestroy();
        }
        if (!this.ao || (caseModel = this.al) == null || this.as == null) {
            this.an = true;
            this.ai = null;
            this.aj = null;
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.am(null);
            }
        } else {
            this.ap = true;
            CaseModel caseModel2 = new CaseModel(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
            this.as.removeMessages(4001);
            a aVar2 = this.as;
            aVar2.sendMessageDelayed(aVar2.obtainMessage(4001, caseModel2), 100L);
        }
        this.al = null;
        this.ao = false;
        this.aq = false;
        DuMixCallback duMixCallback = this.aa;
        if (duMixCallback != null) {
            duMixCallback.onCaseDestroy();
        }
    }

    private void P() {
        DuMixCallback duMixCallback;
        if (!this.ae || !this.af || this.ag || (duMixCallback = this.aa) == null) {
            return;
        }
        this.ag = true;
        duMixCallback.onSetup(true, this.V, this.W);
    }

    private void Q() {
        HashMap hashMap = new HashMap();
        hashMap.put("continuous_mapping", m("interaction_plane_move"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("limit_radius", 1);
        hashMap2.put("radius_min", Float.valueOf(0.0f));
        hashMap2.put("radius_max", Float.valueOf(3000.0f));
        hashMap2.put("limit_step_length", 1);
        hashMap2.put("step_length", Float.valueOf(80.0f));
        hashMap2.put("limit_far_frustum", 1);
        hashMap2.put("move_leave_callback", 1);
        hashMap.put("plane_move_config", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("limit_world_axis", 1);
        hashMap3.put("world_axis", "y");
        hashMap.put("rotate_config", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("limit_distance_factor", 1);
        hashMap.put("scale_config", hashMap4);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
    }

    private void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("continuous_mapping", m("interaction_space_move"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("limit_radius_invariant", Integer.valueOf(i));
        hashMap.put("space_move_config", hashMap2);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
    }

    private void a(String str, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str2, str3);
        hashMap.put("event_data", hashMap2);
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.b(1902, hashMap);
        }
    }

    private void b(ARType aRType) {
        int i = AnonymousClass8.ax[aRType.ordinal()];
        if (i == 1) {
            a(1);
        } else if (i == 2 || i == 3 || i == 4) {
            a(0);
        } else if (i != 5) {
        } else {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        a aVar;
        Message obtainMessage;
        com.baidu.ar.h.b.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.an + " && mCaseSwitched = " + this.ao);
        if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
            com.baidu.ar.h.b.b("ControllerHelper", "casePath is empty!!!");
            DuMixCallback duMixCallback = this.aa;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(false, str, str2);
            }
        } else if (this.ak) {
            com.baidu.ar.h.b.b("ControllerHelper", "auth rejected");
        } else {
            CaseModel caseModel = new CaseModel(aRType, str + File.separator + "ar", str2);
            if (this.an) {
                this.an = false;
                com.baidu.ar.h.b.c("ControllerHelper", "executeLoadCase mCaseLoaded = " + this.am);
                if (this.am) {
                    this.al = caseModel;
                    this.ao = true;
                    aVar = this.as;
                    obtainMessage = aVar.obtainMessage(4002);
                } else {
                    aVar = this.as;
                    obtainMessage = aVar.obtainMessage(4001, caseModel);
                }
                aVar.sendMessage(obtainMessage);
            } else {
                this.al = caseModel;
                this.ao = true;
            }
            this.aq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
        b bVar;
        if (this.ak) {
            com.baidu.ar.h.b.b("ControllerHelper", "handleCreateCase ignored; auth rejected");
            return;
        }
        if (aRType != null) {
            ARConfig.setARType(aRType.getTypeValue());
            b(aRType);
        }
        ARConfig.setARKey(str2);
        if (this.ar) {
            this.ar = false;
            StatisticApi.onEvent(StatisticConstants.EVENT_CASE_FIRST);
        }
        StatisticApi.onEventStart(StatisticConstants.EVENT_CASE_START);
        if (this.g != null && !TextUtils.isEmpty(str)) {
            String substring = str.substring(0, str.lastIndexOf(File.separator + "ar"));
            this.ai = substring;
            this.aj = str2;
            com.baidu.ar.filter.a aVar = this.B;
            if (aVar != null) {
                aVar.am(substring);
            }
            if (this.d.isUseInputSizeInEngine() || aRType == ARType.FACE || aRType == ARType.VPAS) {
                this.g.p(false);
            } else {
                this.g.p(true);
            }
            this.g.L(str);
        }
        if (aRType == null || (bVar = this.ad) == null) {
            return;
        }
        bVar.a(aRType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        com.baidu.ar.filter.a aVar = this.B;
        if (aVar != null) {
            aVar.f(list);
        }
    }

    public static String getSoDownLoadDir(Context context) {
        if (context == null) {
            com.baidu.ar.h.b.b("ControllerHelper", "get so download dir error");
            return null;
        }
        File file = new File(context.getFilesDir(), "arlibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private HashMap<String, Object> m(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("gesture_scroll", str);
        hashMap.put("gesture_two_finger_scroll", "interaction_rotate");
        hashMap.put("gesture_two_finger_pinch", "interaction_scale_down");
        hashMap.put("gesture_two_finger_unpinch", "interaction_scale_up");
        return hashMap;
    }

    public void A() {
        a aVar = this.as;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    public void E() {
        ARAuth.doAuth(this.mContext, new IAuthCallback() { // from class: com.baidu.ar.e.7
            public boolean aw = false;

            @Override // com.baidu.ar.auth.IAuthCallback
            public void onError(String str, int i) {
                com.baidu.ar.h.b.b("ControllerHelper", String.format("auth fail feature: %d msg: %s", Integer.valueOf(i), str));
                if (i == 0) {
                    e.this.ak = true;
                    if (e.this.as != null) {
                        e.this.as.sendMessage(e.this.as.obtainMessage(4002));
                    }
                }
                if (this.aw || !ARAuth.isShowAuthTip()) {
                    return;
                }
                this.aw = true;
                e.this.G();
            }

            @Override // com.baidu.ar.auth.IAuthCallback
            public void onSuccess() {
                com.baidu.ar.h.b.c("ControllerHelper", "auth success");
            }
        });
    }

    public void F() {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.at;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<PixelReadParams, PixelReadListener> entry : this.at.entrySet()) {
            this.g.createPixelReader(entry.getKey(), entry.getValue());
        }
        this.at.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.baidu.ar.libloader.ILibLoader] */
    public void a(DuMixController duMixController) {
        com.baidu.ar.libloader.c cVar;
        String soDownLoadDir = getSoDownLoadDir(this.mContext);
        Object a2 = n.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
        if (a2 != null) {
            cVar = (ILibLoader) a2;
        } else if (TextUtils.isEmpty(soDownLoadDir) || com.baidu.ar.libloader.a.isRegistered()) {
            com.baidu.ar.libloader.a.fg();
            return;
        } else {
            com.baidu.ar.libloader.c cVar2 = new com.baidu.ar.libloader.c(soDownLoadDir);
            cVar2.a(new c.a() { // from class: com.baidu.ar.e.2
                @Override // com.baidu.ar.libloader.c.a
                public void a(String str, String str2) {
                    DuMixCallback duMixCallback = e.this.aa;
                    if (duMixCallback != null) {
                        duMixCallback.onError(DuMixErrorType.LibraryError, str2, str);
                    }
                }
            });
            cVar = cVar2;
        }
        com.baidu.ar.libloader.a.a(cVar);
    }

    public void a(final com.baidu.ar.a.b bVar) {
        if (bVar != null) {
            bVar.a(new ICallbackWith<String>() { // from class: com.baidu.ar.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: n */
                public void run(String str) {
                    DuMixCallback duMixCallback = e.this.aa;
                    if (duMixCallback != null) {
                        duMixCallback.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
                    }
                }
            });
            bVar.b(new ICallbackWith<JSONObject>() { // from class: com.baidu.ar.e.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: b */
                public void run(JSONObject jSONObject) {
                    if (e.this.g != null) {
                        if (jSONObject != null) {
                            e.this.g.a(jSONObject);
                        } else if (bVar != null) {
                            e.this.g.setLocalDeviceGrade(bVar.ag());
                        }
                    }
                }
            });
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.at;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(pixelReadParams, pixelReadListener);
        }
    }

    public void a(com.baidu.ar.arrender.c cVar, b bVar, com.baidu.ar.filter.a aVar, com.baidu.ar.lua.b bVar2) {
        this.g = cVar;
        this.ad = bVar;
        this.B = aVar;
        this.f = bVar2;
    }

    public void clearCase() {
        com.baidu.ar.h.b.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.an + " && mCaseLoaded = " + this.am);
        if (this.an && this.am) {
            this.an = false;
            a aVar = this.as;
            if (aVar != null) {
                aVar.sendMessage(aVar.obtainMessage(4002));
            }
        } else {
            this.al = null;
            this.aq = true;
        }
        this.ah = null;
    }

    public void k(String str) {
        a("recorder_video", "msg", str);
    }

    public void l(String str) {
        a("dumix_system_message", "system_message", str);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.ak) {
            com.baidu.ar.h.b.b("ControllerHelper", "auth rejected");
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str, str2);
        CaseModel caseModel2 = this.ah;
        if (caseModel2 == null || !caseModel.equals(caseModel2)) {
            this.ah = caseModel;
            com.baidu.ar.libloader.a.prepareCaseRes(aRType, str, str2, new ILibLoader.a() { // from class: com.baidu.ar.e.1
                @Override // com.baidu.ar.libloader.ILibLoader.a
                public void a(ARType aRType2, String str3, String str4) {
                    e.this.b(aRType2, str3, str4);
                }
            });
            return;
        }
        com.baidu.ar.h.b.c("ControllerHelper", "loadCase() case has loaded!!!");
        DuMixCallback duMixCallback = this.aa;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(true, str, str2);
        }
    }

    public void release() {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.at;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.at = null;
        }
        this.g = null;
        this.ad = null;
        this.B = null;
        this.V = null;
        this.W = null;
        this.mContext = null;
        this.d = null;
        this.ab = null;
        this.ac = null;
        this.f = null;
        this.as = null;
    }

    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        this.V = duMixInput;
        this.W = duMixOutput;
        this.aa = duMixCallback;
        B();
        D();
        C();
    }
}
