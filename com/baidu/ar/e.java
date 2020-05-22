package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.j;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.f.l;
import com.baidu.ar.libloader.a;
import com.baidu.ar.libloader.d;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e {
    static volatile boolean ag = false;
    static volatile boolean ah = false;
    private DuMixInput aa;
    private DuMixOutput ab;
    protected DuMixCallback ac;
    private List<Integer> ad;
    private com.baidu.ar.lua.c ae;
    private com.baidu.ar.b af;
    private a al;
    private String am;
    private String an;
    private a ap;
    private b aw;
    private DefaultParams c;
    private com.baidu.ar.lua.b e;
    private com.baidu.ar.arrender.c f;
    private Context mContext;
    private com.baidu.ar.filter.a w;
    private boolean ai = false;
    private boolean aj = false;
    private boolean ak = false;
    private volatile boolean ao = false;
    private boolean aq = false;
    private boolean ar = true;
    private boolean as = false;
    private boolean at = false;
    private boolean au = false;
    private boolean av = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        ARType aA;
        String aB;
        String aC;

        public a(ARType aRType, String str, String str2) {
            this.aA = aRType;
            this.aB = str;
            this.aC = str2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                return (!TextUtils.isEmpty(this.aB) && this.aB.equals(((a) obj).aB)) || (TextUtils.isEmpty(this.aB) && !TextUtils.isEmpty(this.aC) && this.aC.equals(((a) obj).aC));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_CREATE_CASE");
                    a aVar = (a) message.obj;
                    e.this.c(aVar.aA, aVar.aB, aVar.aC);
                    return;
                case 1002:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_DESTROY_CASE");
                    e.this.F();
                    if (e.this.w != null) {
                        e.this.w.bc();
                        return;
                    }
                    return;
                case 1003:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_FILTER_CREATE");
                    e.this.ai = true;
                    if (e.this.w != null && !e.this.at) {
                        e.this.w.df();
                    }
                    e.this.I();
                    return;
                case 1004:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_FILTER_CHANGED");
                    if (e.this.w != null) {
                        e.this.w.d((List) ((HashMap) message.obj).get("filter_name_list"));
                        return;
                    }
                    return;
                case 1005:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_ENGINE_CREATE");
                    e.ag = false;
                    if (e.this.af != null) {
                        e.this.af.e();
                    }
                    if (e.this.f != null) {
                        e.this.f.q(true);
                    }
                    e.this.aj = true;
                    e.this.I();
                    return;
                case 1006:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_ENGINE_DESTROY");
                    e.ah = false;
                    if (e.this.ac != null) {
                        e.this.ac.onRelease();
                        e.this.ac = null;
                        return;
                    }
                    return;
                case 1007:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_CASE_CREATE");
                    e.this.aq = true;
                    e.this.at = false;
                    if (e.this.af != null) {
                        e.this.af.onCaseCreate(e.this.am + File.separator + "ar");
                    }
                    if ((e.this.as || e.this.au) && e.this.aw != null) {
                        e.this.aw.removeMessages(1002);
                        e.this.aw.sendMessage(e.this.aw.obtainMessage(1002));
                    } else {
                        e.this.ar = true;
                    }
                    if (e.this.ac != null) {
                        e.this.ac.onCaseCreate(true, e.this.am, e.this.an);
                        return;
                    }
                    return;
                case 1008:
                    com.baidu.ar.f.b.c("ControllerHelper", "MainThreadHandler MSG_ON_CASE_DESTROY");
                    e.this.aq = false;
                    e.this.G();
                    if (e.this.af != null) {
                        e.this.af.onCaseDestroy();
                    }
                    if (!e.this.as || e.this.ap == null || e.this.aw == null) {
                        e.this.ar = true;
                        e.this.am = null;
                        e.this.an = null;
                        if (e.this.w != null) {
                            e.this.w.ae(e.this.am);
                        }
                    } else {
                        e.this.at = true;
                        a aVar2 = new a(e.this.ap.aA, e.this.ap.aB, e.this.ap.aC);
                        e.this.aw.removeMessages(1001);
                        e.this.aw.sendMessageDelayed(e.this.aw.obtainMessage(1001, aVar2), 100L);
                    }
                    e.this.ap = null;
                    e.this.as = false;
                    e.this.au = false;
                    if (e.this.ac != null) {
                        e.this.ac.onCaseDestroy();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, DefaultParams defaultParams) {
        this.mContext = context;
        this.c = defaultParams;
        this.aw = new b(context.getMainLooper());
    }

    private void A() {
        this.ad = Arrays.asList(12, 50, 6, 7, 8, 9);
        this.ae = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.e.3
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                com.baidu.ar.f.b.c("ControllerHelper", "onEngineMessage msgType = " + i + " && msgId = " + i2);
                switch (i) {
                    case 6:
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1005));
                            return;
                        }
                        return;
                    case 7:
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1006));
                            return;
                        }
                        return;
                    case 8:
                        e.this.f.bd();
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1007));
                            return;
                        }
                        return;
                    case 9:
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1008));
                            return;
                        }
                        return;
                    case 12:
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1003));
                            return;
                        }
                        return;
                    case 50:
                        if (e.this.aw != null) {
                            e.this.aw.sendMessage(e.this.aw.obtainMessage(1004, hashMap));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                return e.this.ad;
            }
        };
        if (this.e != null) {
            this.e.c(this.ae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Bitmap createTipBitmap;
        if (this.f == null || this.ab == null || (createTipBitmap = com.baidu.ar.auth.a.createTipBitmap(this.mContext)) == null) {
            return;
        }
        float outputWidth = ((this.ab.getOutputWidth() * createTipBitmap.getHeight()) * 0.78125f) / (this.ab.getOutputHeight() * createTipBitmap.getWidth());
        this.f.a(createTipBitmap, (1.0f - 0.78125f) / 2.0f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        G();
        if (this.f != null) {
            this.f.F();
        }
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.af != null) {
            if (this.as && this.ap != null && H()) {
                this.af.g();
            } else {
                this.af.f();
            }
        }
    }

    private boolean H() {
        return (this.ap.aA == null || this.ap.aA == ARType.FACE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (!this.ai || !this.aj || this.ak || this.ac == null) {
            return;
        }
        this.ak = true;
        this.ac.onSetup(true, this.aa, this.ab);
    }

    private void a(String str, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str2, str3);
        hashMap.put("event_data", hashMap2);
        if (this.e != null) {
            this.e.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        com.baidu.ar.f.b.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.ar + " && mCaseSwitched = " + this.as);
        if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
            com.baidu.ar.f.b.b("ControllerHelper", "casePath is empty!!!");
            if (this.ac != null) {
                this.ac.onCaseCreate(false, str, str2);
            }
        } else if (this.ao) {
            com.baidu.ar.f.b.b("ControllerHelper", "auth rejected");
        } else {
            a aVar = new a(aRType, str + File.separator + "ar", str2);
            if (this.ar) {
                this.ar = false;
                com.baidu.ar.f.b.c("ControllerHelper", "executeLoadCase mCaseLoaded = " + this.aq);
                if (this.aq) {
                    this.ap = aVar;
                    this.as = true;
                    this.aw.sendMessage(this.aw.obtainMessage(1002));
                } else {
                    this.aw.sendMessage(this.aw.obtainMessage(1001, aVar));
                }
            } else {
                this.ap = aVar;
                this.as = true;
            }
            this.au = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
        if (this.ao) {
            com.baidu.ar.f.b.b("ControllerHelper", "createCase ignored; auth rejected");
            return;
        }
        if (aRType != null) {
            ARConfig.setARType(aRType.getTypeValue());
        }
        ARConfig.setARKey(str2);
        if (this.av) {
            this.av = false;
            StatisticApi.onEvent(StatisticConstants.EVENT_CASE_FIRST);
        }
        StatisticApi.onEventStart(StatisticConstants.EVENT_CASE_START);
        if (this.f != null && !TextUtils.isEmpty(str)) {
            this.am = str.substring(0, str.lastIndexOf(File.separator + "ar"));
            this.an = str2;
            if (this.w != null) {
                this.w.ae(this.am);
            }
            if (this.c.isUseInputSizeInEngine() || aRType == ARType.FACE || aRType == ARType.VPAS) {
                this.f.r(false);
            } else {
                this.f.r(true);
            }
            this.f.I(str);
        }
        if (aRType == null || this.af == null) {
            return;
        }
        this.af.a(aRType, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSoDownLoadDir(Context context) {
        if (context == null) {
            com.baidu.ar.f.b.b("ControllerHelper", "get so download dir error");
            return null;
        }
        File file = new File(context.getFilesDir(), "arlibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        com.baidu.ar.libloader.b.a(this.mContext, new a.b() { // from class: com.baidu.ar.e.4
            @Override // com.baidu.ar.libloader.a.b
            public void onSuccess() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        com.baidu.ar.auth.a.loadAuthInfo(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        com.baidu.ar.auth.a.doAuth(this.mContext, new j() { // from class: com.baidu.ar.e.7
            private boolean az = false;

            @Override // com.baidu.ar.auth.j
            public void onError(String str, int i) {
                com.baidu.ar.f.b.b("ControllerHelper", String.format("auth fail feature: %d msg: %s", Integer.valueOf(i), str));
                if (i == 0) {
                    e.this.ao = true;
                    e.this.F();
                }
                if (this.az || !com.baidu.ar.auth.a.isShowAuthTip()) {
                    return;
                }
                this.az = true;
                e.this.E();
            }

            @Override // com.baidu.ar.auth.j
            public void onSuccess() {
                com.baidu.ar.f.b.c("ControllerHelper", "auth success");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DuMixController duMixController) {
        String soDownLoadDir = getSoDownLoadDir(this.mContext);
        Object a2 = l.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
        if (a2 != null) {
            com.baidu.ar.libloader.b.a((com.baidu.ar.libloader.a) a2);
        } else if (TextUtils.isEmpty(soDownLoadDir) || com.baidu.ar.libloader.b.isRegistered()) {
        } else {
            com.baidu.ar.libloader.d dVar = new com.baidu.ar.libloader.d(soDownLoadDir);
            dVar.a(new d.a() { // from class: com.baidu.ar.e.2
                @Override // com.baidu.ar.libloader.d.a
                public void a(String str, String str2) {
                    if (e.this.ac != null) {
                        e.this.ac.onError(DuMixErrorType.LibraryError, str2, str);
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
                /* renamed from: k */
                public void run(String str) {
                    if (e.this.ac != null) {
                        e.this.ac.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
                    }
                }
            });
            bVar.b(new ICallbackWith<JSONObject>() { // from class: com.baidu.ar.e.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: b */
                public void run(JSONObject jSONObject) {
                    if (e.this.f != null) {
                        if (jSONObject != null) {
                            e.this.f.a(jSONObject);
                        } else if (bVar != null) {
                            e.this.f.setLocalDeviceGrade(bVar.Q());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.arrender.c cVar, com.baidu.ar.b bVar, com.baidu.ar.filter.a aVar, com.baidu.ar.lua.b bVar2) {
        this.f = cVar;
        this.af = bVar;
        this.w = aVar;
        this.e = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCase() {
        if (ag || ah) {
            com.baidu.ar.f.b.b("ControllerHelper", "clearCase DuMix has not setup!!!!!!");
            return;
        }
        com.baidu.ar.f.b.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.ar + " && mCaseLoaded = " + this.aq);
        if (this.ar && this.aq) {
            this.ar = false;
            if (this.aw != null) {
                this.aw.sendMessage(this.aw.obtainMessage(1002));
            }
        } else {
            this.ap = null;
            this.au = true;
        }
        this.al = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        a("recorder_video", "msg", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        a("dumix_system_message", "system_message", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.ao) {
            com.baidu.ar.f.b.b("ControllerHelper", "auth rejected");
        } else if (this.aw == null || ag || ah) {
            com.baidu.ar.f.b.b("ControllerHelper", "loadCase DuMix has not setup!!!!!!");
            if (this.ac != null) {
                this.ac.onCaseCreate(false, str, str2);
            }
        } else {
            a aVar = new a(aRType, str, str2);
            if (this.al == null || !aVar.equals(this.al)) {
                this.al = aVar;
                com.baidu.ar.libloader.b.a(aRType, str, str2, new a.InterfaceC0084a() { // from class: com.baidu.ar.e.1
                    @Override // com.baidu.ar.libloader.a.InterfaceC0084a
                    public void a(ARType aRType2, String str3, String str4) {
                        e.this.b(aRType2, str3, str4);
                    }
                });
                return;
            }
            com.baidu.ar.f.b.c("ControllerHelper", "loadCase() case has loaded!!!");
            if (this.ac != null) {
                this.ac.onCaseCreate(true, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.f = null;
        this.af = null;
        this.w = null;
        this.aa = null;
        this.ab = null;
        this.mContext = null;
        this.c = null;
        this.ad = null;
        this.ae = null;
        this.e = null;
        ah = false;
        ag = false;
        this.aw = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        this.aa = duMixInput;
        this.ab = duMixOutput;
        this.ac = duMixCallback;
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (this.aw != null) {
            this.aw.removeCallbacksAndMessages(null);
        }
    }
}
