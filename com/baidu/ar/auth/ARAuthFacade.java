package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.auth.m;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.g.r;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class ARAuthFacade implements l {
    public static final int AUTH_TYPE_AIP = 1;
    public static final int AUTH_TYPE_AR_SERVER = 2;
    public static final int AUTH_TYPE_PACKAGE = 4;
    private g iI;
    private volatile j iK;
    private k iL;
    private com.baidu.ar.g.d iP;
    private byte[] iQ;
    private boolean iJ = false;
    private final List<IDuMixAuthCallback> iM = new ArrayList();
    private List<k> iN = new ArrayList();
    private boolean iO = false;
    private boolean iR = false;

    private m a(g gVar) {
        boolean z = (gVar.js & 2) > 0;
        boolean z2 = (gVar.js & 4) > 0;
        boolean z3 = (gVar.js & 1) > 0;
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(new n(gVar));
        }
        if (z) {
            arrayList.add(new c(gVar));
        }
        if (z3 && e.cy()) {
            arrayList.add(new d(gVar));
        }
        if (arrayList.size() > 1) {
            return new i((m[]) arrayList.toArray(new m[arrayList.size()]));
        }
        if (arrayList.size() == 1) {
            return (m) arrayList.get(0);
        }
        return null;
    }

    private void a(Context context, k kVar, Runnable runnable, ICallbackWith<List<Integer>> iCallbackWith) {
        if (this.iK == null) {
            this.iK = new j(this.iI != null ? this.iI.jy : null);
            if (this.iI != null ? a(context, kVar, this.iI, iCallbackWith) : false) {
                return;
            }
            a("未知鉴权方式", this.iI, context);
            if (runnable != null) {
                r.a(runnable, 0L);
            }
        } else if (this.iK.isRunning()) {
            if (kVar != null) {
                this.iN.add(kVar);
            }
        } else if (this.iK.isFailed()) {
            this.iK.cD();
            if (kVar != null) {
                kVar.onError(this.iK.cC(), 0);
            }
        } else {
            this.iK.cD();
            if (kVar != null) {
                kVar.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, g gVar, Context context) {
        if (this.iK != null) {
            this.iK.R(str);
        }
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.INPUT_DEF_PKG, context.getPackageName());
            if (gVar != null) {
                hashMap.put("authtype", String.valueOf(gVar.js));
                hashMap.put("r_appid", gVar.jw);
            }
            hashMap.put("event_param", str);
            StatisticApi.onEvent(StatisticConstants.AUTH_FAILURE, hashMap);
        }
    }

    private boolean a(final Context context, final k kVar, final g gVar, final ICallbackWith<List<Integer>> iCallbackWith) {
        final m a = a(gVar);
        if (a != null) {
            a.a(new m.a() { // from class: com.baidu.ar.auth.ARAuthFacade.7
                @Override // com.baidu.ar.auth.m.a
                public void a(Set<Integer> set) {
                    if (ARAuthFacade.this.iK != null) {
                        ARAuthFacade.this.iK.b(set);
                        if (iCallbackWith != null) {
                            iCallbackWith.run(ARAuthFacade.this.iK.cE());
                        }
                    }
                }
            });
            if (this.iP == null) {
                this.iP = new com.baidu.ar.g.d("ARAuthWorker");
                this.iP.start();
            }
            this.iP.execute(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.8
                @Override // java.lang.Runnable
                public void run() {
                    a.doAuth(context, new k() { // from class: com.baidu.ar.auth.ARAuthFacade.8.1
                        @Override // com.baidu.ar.auth.k
                        public void onError(String str, int i) {
                            ARAuthFacade.this.a(str, gVar, context);
                            if (kVar != null) {
                                kVar.onError(str, i);
                            }
                            if (ARAuthFacade.this.iN.isEmpty()) {
                                return;
                            }
                            for (k kVar2 : ARAuthFacade.this.iN) {
                                kVar2.onError(str, i);
                            }
                        }

                        @Override // com.baidu.ar.auth.k
                        public void onSuccess() {
                            if (ARAuthFacade.this.iK != null) {
                                ARAuthFacade.this.iK.cB();
                            }
                            if (kVar != null) {
                                kVar.onSuccess();
                            }
                            if (ARAuthFacade.this.iN.isEmpty()) {
                                return;
                            }
                            for (k kVar2 : ARAuthFacade.this.iN) {
                                kVar2.onSuccess();
                            }
                        }
                    });
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IDuMixAuthCallback[] cw() {
        IDuMixAuthCallback[] iDuMixAuthCallbackArr = new IDuMixAuthCallback[this.iM.size()];
        this.iM.toArray(iDuMixAuthCallbackArr);
        return iDuMixAuthCallbackArr;
    }

    private g d(byte[] bArr) {
        g gVar = new g();
        try {
            f.a(bArr, gVar);
            this.iI = gVar;
        } catch (Exception e) {
            e.printStackTrace();
            this.iI = null;
        }
        return gVar;
    }

    private void g(Context context) {
        if (!this.iJ) {
            g gVar = null;
            if (this.iQ == null || this.iQ.length <= 0) {
                try {
                    gVar = f.l(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                gVar = d(this.iQ);
            }
            this.iI = gVar;
        }
        this.iJ = true;
        if (this.iI == null || TextUtils.isEmpty(this.iI.jw)) {
            return;
        }
        DuMixARConfig.setAppId(this.iI.jw);
        DuMixARConfig.setAPIKey(this.iI.jx);
        DuMixARConfig.setSecretKey("");
    }

    private void s(final int i) {
        r.a(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.6
            @Override // java.lang.Runnable
            public void run() {
                if (ARAuthFacade.this.iL != null) {
                    ARAuthFacade.this.iL.onError("未授权功能: " + i, i);
                }
                for (IDuMixAuthCallback iDuMixAuthCallback : ARAuthFacade.this.cw()) {
                    iDuMixAuthCallback.onFeatureRejected(i);
                }
            }
        }, 0L);
    }

    @Override // com.baidu.ar.auth.l
    public List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        if (this.iK != null) {
            if (iDuMixAuthCallback != null) {
                if (this.iK.isRunning()) {
                    this.iM.add(iDuMixAuthCallback);
                } else if (this.iK.isFailed()) {
                    iDuMixAuthCallback.onResult(false);
                } else {
                    iDuMixAuthCallback.onResult(true);
                }
            }
            return this.iI != null ? this.iI.jy : new ArrayList();
        } else if (bArr == null) {
            throw new IllegalStateException("license数据不能为空");
        } else {
            this.iO = true;
            if (iDuMixAuthCallback != null) {
                this.iM.add(iDuMixAuthCallback);
            }
            g d = d(bArr);
            this.iJ = true;
            final Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.2
                @Override // java.lang.Runnable
                public void run() {
                    IDuMixAuthCallback[] cw;
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cw()) {
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(new ArrayList());
                        iDuMixAuthCallback2.onResult(false);
                        iDuMixAuthCallback2.onFeatureRejected(0);
                    }
                }
            };
            a(context.getApplicationContext(), new k() { // from class: com.baidu.ar.auth.ARAuthFacade.3
                @Override // com.baidu.ar.auth.k
                public void onError(String str, int i) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // com.baidu.ar.auth.k
                public void onSuccess() {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cw()) {
                        iDuMixAuthCallback2.onResult(true);
                    }
                }
            }, runnable, new ICallbackWith<List<Integer>>() { // from class: com.baidu.ar.auth.ARAuthFacade.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: e */
                public void run(List<Integer> list) {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cw()) {
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(list);
                    }
                }
            });
            return this.iI != null ? d.jy : new ArrayList();
        }
    }

    @Override // com.baidu.ar.auth.l
    public List<Integer> checkAuth(Context context, byte[] bArr, final ICallbackWith<List<Integer>> iCallbackWith, final ICallbackWith<Integer> iCallbackWith2) {
        IDuMixAuthCallback iDuMixAuthCallback = null;
        if (iCallbackWith != null || iCallbackWith2 != null) {
            iDuMixAuthCallback = new IDuMixAuthCallback() { // from class: com.baidu.ar.auth.ARAuthFacade.1
                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onAvailFeaturesUpdate(List<Integer> list) {
                    if (iCallbackWith != null) {
                        iCallbackWith.run(list);
                    }
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onFeatureRejected(int i) {
                    if (iCallbackWith2 != null) {
                        iCallbackWith2.run(Integer.valueOf(i));
                    }
                }

                @Override // com.baidu.ar.auth.IDuMixAuthCallback
                public void onResult(boolean z) {
                }
            };
        }
        return checkAuth(context, bArr, iDuMixAuthCallback);
    }

    @Override // com.baidu.ar.auth.l
    public boolean checkFeatureAuth(int i) {
        boolean t = this.iK != null ? this.iK.t(i) : true;
        if (!t) {
            s(i);
        }
        if (t) {
            HashMap hashMap = new HashMap();
            hashMap.put("feature_code", String.valueOf(i));
            StatisticApi.onEventDebounce(StatisticConstants.EVENT_FEATURE_AUTH, 200L, hashMap);
        }
        return t;
    }

    @Override // com.baidu.ar.auth.l
    public boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        if (this.iK != null) {
            if (!this.iK.isRunning() && this.iK.isFailed()) {
                return false;
            }
            return true;
        } else if (bArr == null || context == null) {
            return false;
        } else {
            this.iO = true;
            g d = d(bArr);
            this.iJ = true;
            if (d == null) {
                this.iK = new j(null);
                com.baidu.ar.g.b.b("ARAuth", "invalid license data");
                this.iK.R("invalid license data");
                return false;
            }
            m a = a(d);
            if (a instanceof n) {
                this.iK = new j(this.iI != null ? this.iI.jy : null);
                String[] strArr = new String[1];
                boolean a2 = ((n) a).a(context, strArr);
                if (a2) {
                    this.iK.cB();
                    return a2;
                }
                this.iK.R(strArr[0]);
                com.baidu.ar.g.b.b("ARAuth", strArr[0]);
                return a2;
            }
            return false;
        }
    }

    @Override // com.baidu.ar.auth.l
    public Bitmap createTipBitmap(Context context) {
        return h.n(context);
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, final k kVar) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.iL = kVar;
        if (!this.iJ) {
            g(applicationContext);
        }
        a(applicationContext, kVar, new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.5
            @Override // java.lang.Runnable
            public void run() {
                if (kVar != null) {
                    String str = "请检查license文件";
                    if (ARAuthFacade.this.iO) {
                        str = "请检查传入checkAuth方法的arLicense数据";
                    } else if (!e.cy()) {
                        str = "请检查dumixar.license文件";
                    }
                    kVar.onError(str, 0);
                }
            }
        }, (ICallbackWith<List<Integer>>) null);
    }

    @Override // com.baidu.ar.auth.l
    public boolean enableFeature(int i) {
        if (this.iK != null) {
            return this.iK.t(i);
        }
        return true;
    }

    @Override // com.baidu.ar.auth.l
    public boolean isShowAuthTip() {
        return this.iI == null || !this.iI.ju;
    }

    @Override // com.baidu.ar.auth.l
    public void loadAuthInfo(Context context) {
        if (this.iR) {
            return;
        }
        g(context);
    }

    @Override // com.baidu.ar.auth.l
    public void receiveAuthFailMessage(int i) {
        s(i);
    }

    @Override // com.baidu.ar.auth.l
    public void release() {
        if (this.iP != null) {
            this.iP.stop();
            this.iP = null;
        }
        this.iJ = false;
        this.iK = null;
        this.iL = null;
        this.iM.clear();
        this.iN.clear();
    }

    @Override // com.baidu.ar.auth.l
    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        this.iQ = bArr;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
        this.iR = !TextUtils.isEmpty(str2);
    }
}
