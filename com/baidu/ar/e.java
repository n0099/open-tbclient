package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.g.n;
import com.baidu.ar.libloader.a;
import com.baidu.ar.libloader.d;
import com.baidu.ar.recorder.MovieRecorder;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class e {
    private com.baidu.ar.filter.a A;
    private DuMixInput W;
    private DuMixOutput aa;
    protected DuMixCallback ab;
    private List<Integer> ac;
    private com.baidu.ar.lua.c ad;
    private b ae;
    private CaseModel ai;
    private String aj;
    private String ak;
    private CaseModel am;
    private a at;
    private DefaultParams d;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private Context mContext;
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = false;
    private volatile boolean al = false;
    private boolean an = false;
    private boolean ao = true;
    private boolean ap = false;
    private boolean aq = false;
    private boolean ar = false;
    private boolean as = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 4001:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_CREATE_CASE");
                    CaseModel caseModel = (CaseModel) message.obj;
                    e.this.c(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                    return;
                case MovieRecorder.ERROR_CODE_ON_STOP /* 4002 */:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_DESTROY_CASE");
                    e.this.I();
                    return;
                case ResponseCode.ERROR_LOGIN_INVALID_REQUEST /* 4003 */:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CREATE");
                    e.this.J();
                    return;
                case ResponseCode.ERROR_LOGIN_LOGIN_FAILED /* 4004 */:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CHANGE");
                    e.this.c((List) ((HashMap) message.obj).get("filter_name_list"));
                    return;
                case ResponseCode.ERROR_LOGIN_CALL_BACKEND_FAILED /* 4005 */:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_CREATE");
                    e.this.K();
                    return;
                case 4006:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_DESTROY");
                    e.this.L();
                    return;
                case 4007:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_CREATE");
                    e.this.M();
                    return;
                case 4008:
                    com.baidu.ar.g.b.c("ControllerHelper", "CaseHandler MSG_ON_CASE_DESTROY");
                    e.this.N();
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
        this.at = new a(handlerThread.getLooper());
    }

    private void B() {
        this.ac = Arrays.asList(12, 50, 6, 7, 8, 9);
        this.ad = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.e.3
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                com.baidu.ar.g.b.c("ControllerHelper", "onEngineMessage msgType = " + i + " && msgId = " + i2);
                switch (i) {
                    case 6:
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(ResponseCode.ERROR_LOGIN_CALL_BACKEND_FAILED));
                            return;
                        }
                        return;
                    case 7:
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(4006));
                            return;
                        }
                        return;
                    case 8:
                        e.this.g.bz();
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(4007));
                            return;
                        }
                        return;
                    case 9:
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(4008));
                            return;
                        }
                        return;
                    case 12:
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(ResponseCode.ERROR_LOGIN_INVALID_REQUEST));
                            return;
                        }
                        return;
                    case 50:
                        if (e.this.at != null) {
                            e.this.at.sendMessage(e.this.at.obtainMessage(ResponseCode.ERROR_LOGIN_LOGIN_FAILED, hashMap));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return e.this.ac;
            }
        };
        if (this.f != null) {
            this.f.c(this.ad);
        }
    }

    private void C() {
        com.baidu.ar.libloader.b.a(this.mContext, new a.b() { // from class: com.baidu.ar.e.4
            @Override // com.baidu.ar.libloader.a.b
            public void onSuccess() {
            }
        });
    }

    private void D() {
        com.baidu.ar.auth.a.loadAuthInfo(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Bitmap createTipBitmap;
        if (this.g == null || this.aa == null || (createTipBitmap = com.baidu.ar.auth.a.createTipBitmap(this.mContext)) == null) {
            return;
        }
        float outputWidth = ((this.aa.getOutputWidth() * createTipBitmap.getHeight()) * 0.78125f) / (this.aa.getOutputHeight() * createTipBitmap.getWidth());
        this.g.a(createTipBitmap, (1.0f - 0.78125f) / 2.0f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
    }

    private void G() {
        if (this.ae == null) {
            return;
        }
        if (this.ap && this.am != null && H()) {
            this.ae.g();
        } else {
            this.ae.f();
        }
    }

    private boolean H() {
        return (this.am.mCaseType == null || this.am.mCaseType == ARType.FACE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        G();
        if (this.g != null) {
            this.g.bD();
        }
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        if (this.A != null) {
            this.A.by();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.af = true;
        if (this.A != null && !this.aq) {
            this.A.eF();
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.ae != null) {
            this.ae.e();
        }
        if (this.g != null) {
            this.g.q(true);
        }
        this.ag = true;
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.ab != null) {
            this.ab.onRelease();
            this.ab = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.an = true;
        this.aq = false;
        if (this.ae != null) {
            this.ae.onCaseCreate(this.aj + File.separator + "ar");
        }
        if ((this.ap || this.ar) && this.at != null) {
            this.at.removeMessages(MovieRecorder.ERROR_CODE_ON_STOP);
            this.at.sendMessage(this.at.obtainMessage(MovieRecorder.ERROR_CODE_ON_STOP));
        } else {
            this.ao = true;
        }
        if (this.ab != null) {
            this.ab.onCaseCreate(true, this.aj, this.ak);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.an = false;
        G();
        if (this.ae != null) {
            this.ae.onCaseDestroy();
        }
        if (!this.ap || this.am == null || this.at == null) {
            this.ao = true;
            this.aj = null;
            this.ak = null;
            if (this.A != null) {
                this.A.aj(this.aj);
            }
        } else {
            this.aq = true;
            CaseModel caseModel = new CaseModel(this.am.mCaseType, this.am.mCasePath, this.am.mCaseId);
            this.at.removeMessages(4001);
            this.at.sendMessageDelayed(this.at.obtainMessage(4001, caseModel), 100L);
        }
        this.am = null;
        this.ap = false;
        this.ar = false;
        if (this.ab != null) {
            this.ab.onCaseDestroy();
        }
    }

    private void O() {
        if (!this.af || !this.ag || this.ah || this.ab == null) {
            return;
        }
        this.ah = true;
        this.ab.onSetup(true, this.W, this.aa);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        com.baidu.ar.g.b.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.ao + " && mCaseSwitched = " + this.ap);
        if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
            com.baidu.ar.g.b.b("ControllerHelper", "casePath is empty!!!");
            if (this.ab != null) {
                this.ab.onCaseCreate(false, str, str2);
            }
        } else if (this.al) {
            com.baidu.ar.g.b.b("ControllerHelper", "auth rejected");
        } else {
            CaseModel caseModel = new CaseModel(aRType, str + File.separator + "ar", str2);
            if (this.ao) {
                this.ao = false;
                com.baidu.ar.g.b.c("ControllerHelper", "executeLoadCase mCaseLoaded = " + this.an);
                if (this.an) {
                    this.am = caseModel;
                    this.ap = true;
                    this.at.sendMessage(this.at.obtainMessage(MovieRecorder.ERROR_CODE_ON_STOP));
                } else {
                    this.at.sendMessage(this.at.obtainMessage(4001, caseModel));
                }
            } else {
                this.am = caseModel;
                this.ap = true;
            }
            this.ar = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
        if (this.al) {
            com.baidu.ar.g.b.b("ControllerHelper", "handleCreateCase ignored; auth rejected");
            return;
        }
        if (aRType != null) {
            ARConfig.setARType(aRType.getTypeValue());
        }
        ARConfig.setARKey(str2);
        if (this.as) {
            this.as = false;
            StatisticApi.onEvent(StatisticConstants.EVENT_CASE_FIRST);
        }
        StatisticApi.onEventStart(StatisticConstants.EVENT_CASE_START);
        if (this.g != null && !TextUtils.isEmpty(str)) {
            this.aj = str.substring(0, str.lastIndexOf(File.separator + "ar"));
            this.ak = str2;
            if (this.A != null) {
                this.A.aj(this.aj);
            }
            if (this.d.isUseInputSizeInEngine() || aRType == ARType.FACE || aRType == ARType.VPAS) {
                this.g.r(false);
            } else {
                this.g.r(true);
            }
            this.g.I(str);
        }
        if (aRType == null || this.ae == null) {
            return;
        }
        this.ae.a(aRType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        if (this.A != null) {
            this.A.f(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSoDownLoadDir(Context context) {
        if (context == null) {
            com.baidu.ar.g.b.b("ControllerHelper", "get so download dir error");
            return null;
        }
        File file = new File(context.getFilesDir(), "arlibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.at != null) {
            this.at.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        com.baidu.ar.auth.a.doAuth(this.mContext, new k() { // from class: com.baidu.ar.e.7
            private boolean aw = false;

            @Override // com.baidu.ar.auth.k
            public void onError(String str, int i) {
                com.baidu.ar.g.b.b("ControllerHelper", String.format("auth fail feature: %d msg: %s", Integer.valueOf(i), str));
                if (i == 0) {
                    e.this.al = true;
                    if (e.this.at != null) {
                        e.this.at.sendMessage(e.this.at.obtainMessage(MovieRecorder.ERROR_CODE_ON_STOP));
                    }
                }
                if (this.aw || !com.baidu.ar.auth.a.isShowAuthTip()) {
                    return;
                }
                this.aw = true;
                e.this.F();
            }

            @Override // com.baidu.ar.auth.k
            public void onSuccess() {
                com.baidu.ar.g.b.c("ControllerHelper", "auth success");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DuMixController duMixController) {
        String soDownLoadDir = getSoDownLoadDir(this.mContext);
        Object a2 = n.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
        if (a2 != null) {
            com.baidu.ar.libloader.b.a((com.baidu.ar.libloader.a) a2);
        } else if (TextUtils.isEmpty(soDownLoadDir) || com.baidu.ar.libloader.b.isRegistered()) {
            com.baidu.ar.libloader.b.fh();
        } else {
            com.baidu.ar.libloader.d dVar = new com.baidu.ar.libloader.d(soDownLoadDir);
            dVar.a(new d.a() { // from class: com.baidu.ar.e.2
                @Override // com.baidu.ar.libloader.d.a
                public void a(String str, String str2) {
                    if (e.this.ab != null) {
                        e.this.ab.onError(DuMixErrorType.LibraryError, str2, str);
                    }
                }
            });
            com.baidu.ar.libloader.b.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final com.baidu.ar.a.b bVar) {
        if (bVar != null) {
            bVar.a(new ICallbackWith<String>() { // from class: com.baidu.ar.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: l */
                public void run(String str) {
                    if (e.this.ab != null) {
                        e.this.ab.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
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
                            e.this.g.setLocalDeviceGrade(bVar.ae());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.arrender.c cVar, b bVar, com.baidu.ar.filter.a aVar, com.baidu.ar.lua.b bVar2) {
        this.g = cVar;
        this.ae = bVar;
        this.A = aVar;
        this.f = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCase() {
        com.baidu.ar.g.b.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.ao + " && mCaseLoaded = " + this.an);
        if (this.ao && this.an) {
            this.ao = false;
            if (this.at != null) {
                this.at.sendMessage(this.at.obtainMessage(MovieRecorder.ERROR_CODE_ON_STOP));
            }
        } else {
            this.am = null;
            this.ar = true;
        }
        this.ai = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        a("recorder_video", "msg", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str) {
        a("dumix_system_message", "system_message", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.al) {
            com.baidu.ar.g.b.b("ControllerHelper", "auth rejected");
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str, str2);
        if (this.ai == null || !caseModel.equals(this.ai)) {
            this.ai = caseModel;
            com.baidu.ar.libloader.b.a(aRType, str, str2, new a.InterfaceC0085a() { // from class: com.baidu.ar.e.1
                @Override // com.baidu.ar.libloader.a.InterfaceC0085a
                public void a(ARType aRType2, String str3, String str4) {
                    e.this.b(aRType2, str3, str4);
                }
            });
            return;
        }
        com.baidu.ar.g.b.c("ControllerHelper", "loadCase() case has loaded!!!");
        if (this.ab != null) {
            this.ab.onCaseCreate(true, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.g = null;
        this.ae = null;
        this.A = null;
        this.W = null;
        this.aa = null;
        this.mContext = null;
        this.d = null;
        this.ac = null;
        this.ad = null;
        this.f = null;
        this.at = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.ab = duMixCallback;
        B();
        D();
        C();
    }
}
