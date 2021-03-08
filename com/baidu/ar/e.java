package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
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
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e {
    private com.baidu.ar.filter.a B;
    private DuMixInput V;
    private DuMixOutput W;
    protected DuMixCallback aa;
    private List<Integer> ab;
    private com.baidu.ar.lua.c ac;
    private b ad;
    private CaseModel ah;
    private String ai;
    private String aj;
    private CaseModel al;
    private a as;
    private DefaultParams d;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private Context mContext;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    private volatile boolean ak = false;
    private boolean am = false;
    private boolean an = true;
    private boolean ao = false;
    private boolean ap = false;
    private boolean aq = false;
    private boolean ar = true;
    private ConcurrentHashMap<PixelReadParams, PixelReadListener> at = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
                case PluginError.ERROR_LOA_ASSET_MANAGER /* 4006 */:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_DESTROY");
                    e.this.M();
                    return;
                case PluginError.ERROR_LOA_CLASS /* 4007 */:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_CREATE");
                    e.this.N();
                    return;
                case PluginError.ERROR_LOA_SO_MD5_CHECK /* 4008 */:
                    com.baidu.ar.h.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_DESTROY");
                    e.this.O();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, DefaultParams defaultParams, HandlerThread handlerThread) {
        this.mContext = context;
        this.d = defaultParams;
        this.as = new a(handlerThread.getLooper());
    }

    private void B() {
        this.ab = Arrays.asList(12, 50, 6, 7, 8, 9);
        this.ac = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.e.3
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                com.baidu.ar.h.b.c("ControllerHelper", "onEngineMessage msgType = " + i + " && msgId = " + i2);
                switch (i) {
                    case 6:
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(4005));
                            return;
                        }
                        return;
                    case 7:
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(PluginError.ERROR_LOA_ASSET_MANAGER));
                            return;
                        }
                        return;
                    case 8:
                        e.this.g.bw();
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(PluginError.ERROR_LOA_CLASS));
                            return;
                        }
                        return;
                    case 9:
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(PluginError.ERROR_LOA_SO_MD5_CHECK));
                            return;
                        }
                        return;
                    case 12:
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(4003));
                            return;
                        }
                        return;
                    case 50:
                        if (e.this.as != null) {
                            e.this.as.sendMessage(e.this.as.obtainMessage(4004, hashMap));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return e.this.ab;
            }
        };
        if (this.f != null) {
            this.f.c(this.ac);
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
        this.g.a(createTipBitmap, (1.0f - 0.78125f) / 2.0f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
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
        return (this.al.mCaseType == null || this.al.mCaseType == ARType.FACE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        H();
        if (this.g != null) {
            this.g.bB();
        }
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        if (this.B != null) {
            this.B.bv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.ae = true;
        if (this.B != null && !this.ap) {
            this.B.eE();
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.ad != null) {
            this.ad.e();
        }
        if (this.g != null) {
            this.g.o(true);
        }
        this.af = true;
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.aa != null) {
            this.aa.onRelease();
            this.aa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.am = true;
        this.ap = false;
        if (this.ad != null) {
            this.ad.onCaseCreate(this.ai + File.separator + "ar");
        }
        if ((this.ao || this.aq) && this.as != null) {
            this.as.removeMessages(4002);
            this.as.sendMessage(this.as.obtainMessage(4002));
        } else {
            this.an = true;
        }
        if (this.aa != null) {
            this.aa.onCaseCreate(true, this.ai, this.aj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.am = false;
        H();
        if (this.ad != null) {
            this.ad.onCaseDestroy();
        }
        if (!this.ao || this.al == null || this.as == null) {
            this.an = true;
            this.ai = null;
            this.aj = null;
            if (this.B != null) {
                this.B.am(this.ai);
            }
        } else {
            this.ap = true;
            CaseModel caseModel = new CaseModel(this.al.mCaseType, this.al.mCasePath, this.al.mCaseId);
            this.as.removeMessages(4001);
            this.as.sendMessageDelayed(this.as.obtainMessage(4001, caseModel), 100L);
        }
        this.al = null;
        this.ao = false;
        this.aq = false;
        if (this.aa != null) {
            this.aa.onCaseDestroy();
        }
    }

    private void P() {
        if (!this.ae || !this.af || this.ag || this.aa == null) {
            return;
        }
        this.ag = true;
        this.aa.onSetup(true, this.V, this.W);
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
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str2, str3);
        hashMap.put("event_data", hashMap2);
        if (this.f != null) {
            this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    private void b(ARType aRType) {
        switch (aRType) {
            case IMU:
                a(1);
                return;
            case TRACK_2D:
            case CLOUD_IR:
            case ON_DEVICE_IR:
                a(0);
                return;
            case VO:
                Q();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        com.baidu.ar.h.b.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.an + " && mCaseSwitched = " + this.ao);
        if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
            com.baidu.ar.h.b.b("ControllerHelper", "casePath is empty!!!");
            if (this.aa != null) {
                this.aa.onCaseCreate(false, str, str2);
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
                    this.as.sendMessage(this.as.obtainMessage(4002));
                } else {
                    this.as.sendMessage(this.as.obtainMessage(4001, caseModel));
                }
            } else {
                this.al = caseModel;
                this.ao = true;
            }
            this.aq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
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
            this.ai = str.substring(0, str.lastIndexOf(File.separator + "ar"));
            this.aj = str2;
            if (this.B != null) {
                this.B.am(this.ai);
            }
            if (this.d.isUseInputSizeInEngine() || aRType == ARType.FACE || aRType == ARType.VPAS) {
                this.g.p(false);
            } else {
                this.g.p(true);
            }
            this.g.L(str);
        }
        if (aRType == null || this.ad == null) {
            return;
        }
        this.ad.a(aRType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        if (this.B != null) {
            this.B.f(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.as != null) {
            this.as.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        ARAuth.doAuth(this.mContext, new IAuthCallback() { // from class: com.baidu.ar.e.7
            private boolean aw = false;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        if (this.at == null || this.at.isEmpty()) {
            return;
        }
        for (Map.Entry<PixelReadParams, PixelReadListener> entry : this.at.entrySet()) {
            this.g.createPixelReader(entry.getKey(), entry.getValue());
        }
        this.at.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DuMixController duMixController) {
        String soDownLoadDir = getSoDownLoadDir(this.mContext);
        Object a2 = n.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
        if (a2 != null) {
            com.baidu.ar.libloader.a.a((ILibLoader) a2);
        } else if (TextUtils.isEmpty(soDownLoadDir) || com.baidu.ar.libloader.a.isRegistered()) {
            com.baidu.ar.libloader.a.fg();
        } else {
            com.baidu.ar.libloader.c cVar = new com.baidu.ar.libloader.c(soDownLoadDir);
            cVar.a(new c.a() { // from class: com.baidu.ar.e.2
                @Override // com.baidu.ar.libloader.c.a
                public void a(String str, String str2) {
                    if (e.this.aa != null) {
                        e.this.aa.onError(DuMixErrorType.LibraryError, str2, str);
                    }
                }
            });
            com.baidu.ar.libloader.a.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final com.baidu.ar.a.b bVar) {
        if (bVar != null) {
            bVar.a(new ICallbackWith<String>() { // from class: com.baidu.ar.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: n */
                public void run(String str) {
                    if (e.this.aa != null) {
                        e.this.aa.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.at != null) {
            this.at.put(pixelReadParams, pixelReadListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.arrender.c cVar, b bVar, com.baidu.ar.filter.a aVar, com.baidu.ar.lua.b bVar2) {
        this.g = cVar;
        this.ad = bVar;
        this.B = aVar;
        this.f = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCase() {
        com.baidu.ar.h.b.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.an + " && mCaseLoaded = " + this.am);
        if (this.an && this.am) {
            this.an = false;
            if (this.as != null) {
                this.as.sendMessage(this.as.obtainMessage(4002));
            }
        } else {
            this.al = null;
            this.aq = true;
        }
        this.ah = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str) {
        a("recorder_video", "msg", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        a("dumix_system_message", "system_message", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.ak) {
            com.baidu.ar.h.b.b("ControllerHelper", "auth rejected");
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str, str2);
        if (this.ah == null || !caseModel.equals(this.ah)) {
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
        if (this.aa != null) {
            this.aa.onCaseCreate(true, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.at != null) {
            this.at.clear();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        this.V = duMixInput;
        this.W = duMixOutput;
        this.aa = duMixCallback;
        B();
        D();
        C();
    }
}
