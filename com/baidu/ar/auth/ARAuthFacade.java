package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.r;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class ARAuthFacade implements j {
    public static final int AUTH_TYPE_AIP = 1;
    public static final int AUTH_TYPE_AR_SERVER = 2;
    public static final int AUTH_TYPE_PACKAGE = 4;
    private f iX;
    private volatile i iZ;
    private IAuthCallback ja;
    private com.baidu.ar.h.d je;
    private byte[] jf;
    private boolean iY = false;
    private final List<IDuMixAuthCallback> jb = new ArrayList();
    private List<IAuthCallback> jc = new ArrayList();
    private boolean jd = false;
    private boolean jg = false;

    private k a(f fVar) {
        boolean z = (fVar.jH & 2) > 0;
        boolean z2 = (fVar.jH & 4) > 0;
        boolean z3 = (fVar.jH & 1) > 0;
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(new l(fVar));
        }
        if (z) {
            arrayList.add(new b(fVar));
        }
        if (z3 && d.cx()) {
            arrayList.add(new c(fVar));
        }
        if (arrayList.size() > 1) {
            return new h((k[]) arrayList.toArray(new k[arrayList.size()]));
        }
        if (arrayList.size() == 1) {
            return (k) arrayList.get(0);
        }
        return null;
    }

    private void a(Context context, IAuthCallback iAuthCallback, Runnable runnable, ICallbackWith<List<Integer>> iCallbackWith) {
        if (this.iZ == null) {
            this.iZ = new i(this.iX != null ? this.iX.jN : null);
            if (this.iX != null ? a(context, iAuthCallback, this.iX, iCallbackWith) : false) {
                return;
            }
            a("未知鉴权方式", this.iX, context);
            if (runnable != null) {
                r.a(runnable, 0L);
            }
        } else if (this.iZ.isRunning()) {
            if (iAuthCallback != null) {
                this.jc.add(iAuthCallback);
            }
        } else if (this.iZ.isFailed()) {
            this.iZ.cC();
            if (iAuthCallback != null) {
                iAuthCallback.onError(this.iZ.cB(), 0);
            }
        } else {
            this.iZ.cC();
            if (iAuthCallback != null) {
                iAuthCallback.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f fVar, Context context) {
        if (this.iZ != null) {
            this.iZ.U(str);
        }
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.INPUT_DEF_PKG, context.getPackageName());
            if (fVar != null) {
                hashMap.put("authtype", String.valueOf(fVar.jH));
                hashMap.put("r_appid", fVar.jL);
            }
            hashMap.put("event_param", str);
            StatisticApi.onEvent(StatisticConstants.AUTH_FAILURE, hashMap);
        }
    }

    private boolean a(final Context context, final IAuthCallback iAuthCallback, final f fVar, final ICallbackWith<List<Integer>> iCallbackWith) {
        final k a2 = a(fVar);
        if (a2 != null) {
            a2.a(new k.a() { // from class: com.baidu.ar.auth.ARAuthFacade.7
                @Override // com.baidu.ar.auth.k.a
                public void a(Set<Integer> set) {
                    if (ARAuthFacade.this.iZ != null) {
                        ARAuthFacade.this.iZ.b(set);
                        if (iCallbackWith != null) {
                            iCallbackWith.run(ARAuthFacade.this.iZ.cD());
                        }
                    }
                }
            });
            if (this.je == null) {
                this.je = new com.baidu.ar.h.d("ARAuthWorker");
                this.je.start();
            }
            this.je.execute(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.8
                @Override // java.lang.Runnable
                public void run() {
                    a2.doAuth(context, new IAuthCallback() { // from class: com.baidu.ar.auth.ARAuthFacade.8.1
                        @Override // com.baidu.ar.auth.IAuthCallback
                        public void onError(String str, int i) {
                            ARAuthFacade.this.a(str, fVar, context);
                            if (iAuthCallback != null) {
                                iAuthCallback.onError(str, i);
                            }
                            if (ARAuthFacade.this.jc.isEmpty()) {
                                return;
                            }
                            for (IAuthCallback iAuthCallback2 : ARAuthFacade.this.jc) {
                                iAuthCallback2.onError(str, i);
                            }
                        }

                        @Override // com.baidu.ar.auth.IAuthCallback
                        public void onSuccess() {
                            if (ARAuthFacade.this.iZ != null) {
                                ARAuthFacade.this.iZ.cA();
                            }
                            if (iAuthCallback != null) {
                                iAuthCallback.onSuccess();
                            }
                            if (ARAuthFacade.this.jc.isEmpty()) {
                                return;
                            }
                            for (IAuthCallback iAuthCallback2 : ARAuthFacade.this.jc) {
                                iAuthCallback2.onSuccess();
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
    public IDuMixAuthCallback[] cv() {
        IDuMixAuthCallback[] iDuMixAuthCallbackArr = new IDuMixAuthCallback[this.jb.size()];
        this.jb.toArray(iDuMixAuthCallbackArr);
        return iDuMixAuthCallbackArr;
    }

    private f d(byte[] bArr) {
        f fVar = new f();
        try {
            e.a(bArr, fVar);
            this.iX = fVar;
        } catch (Exception e) {
            e.printStackTrace();
            this.iX = null;
        }
        return fVar;
    }

    private void h(Context context) {
        if (!this.iY) {
            f fVar = null;
            if (this.jf == null || this.jf.length <= 0) {
                try {
                    fVar = e.m(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fVar = d(this.jf);
            }
            this.iX = fVar;
        }
        this.iY = true;
        if (this.iX == null || TextUtils.isEmpty(this.iX.jL)) {
            return;
        }
        DuMixARConfig.setAppId(this.iX.jL);
        DuMixARConfig.setAPIKey(this.iX.jM);
        DuMixARConfig.setSecretKey("");
    }

    private void u(final int i) {
        r.a(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.6
            @Override // java.lang.Runnable
            public void run() {
                if (ARAuthFacade.this.ja != null) {
                    ARAuthFacade.this.ja.onError("未授权功能: " + i, i);
                }
                for (IDuMixAuthCallback iDuMixAuthCallback : ARAuthFacade.this.cv()) {
                    iDuMixAuthCallback.onFeatureRejected(i);
                }
            }
        }, 0L);
    }

    @Override // com.baidu.ar.auth.j
    public List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        if (this.iZ != null) {
            if (iDuMixAuthCallback != null) {
                if (this.iZ.isRunning()) {
                    this.jb.add(iDuMixAuthCallback);
                } else if (this.iZ.isFailed()) {
                    iDuMixAuthCallback.onResult(false);
                } else {
                    iDuMixAuthCallback.onResult(true);
                }
            }
            return this.iX != null ? this.iX.jN : new ArrayList();
        } else if (bArr == null) {
            throw new IllegalStateException("license数据不能为空");
        } else {
            this.jd = true;
            if (iDuMixAuthCallback != null) {
                this.jb.add(iDuMixAuthCallback);
            }
            f d = d(bArr);
            this.iY = true;
            final Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.2
                @Override // java.lang.Runnable
                public void run() {
                    IDuMixAuthCallback[] cv;
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cv()) {
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(new ArrayList());
                        iDuMixAuthCallback2.onResult(false);
                        iDuMixAuthCallback2.onFeatureRejected(0);
                    }
                }
            };
            a(context.getApplicationContext(), new IAuthCallback() { // from class: com.baidu.ar.auth.ARAuthFacade.3
                @Override // com.baidu.ar.auth.IAuthCallback
                public void onError(String str, int i) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // com.baidu.ar.auth.IAuthCallback
                public void onSuccess() {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cv()) {
                        iDuMixAuthCallback2.onResult(true);
                    }
                }
            }, runnable, new ICallbackWith<List<Integer>>() { // from class: com.baidu.ar.auth.ARAuthFacade.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: e */
                public void run(List<Integer> list) {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.cv()) {
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(list);
                    }
                }
            });
            return this.iX != null ? d.jN : new ArrayList();
        }
    }

    @Override // com.baidu.ar.auth.j
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

    @Override // com.baidu.ar.auth.j
    public boolean checkFeatureAuth(int i) {
        boolean v = this.iZ != null ? this.iZ.v(i) : true;
        if (!v) {
            u(i);
        }
        if (v) {
            HashMap hashMap = new HashMap();
            hashMap.put("feature_code", String.valueOf(i));
            StatisticApi.onEventDebounce(StatisticConstants.EVENT_FEATURE_AUTH, 200L, hashMap);
        }
        return v;
    }

    @Override // com.baidu.ar.auth.j
    public boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        if (this.iZ != null) {
            if (!this.iZ.isRunning() && this.iZ.isFailed()) {
                return false;
            }
            return true;
        } else if (bArr == null || context == null) {
            return false;
        } else {
            this.jd = true;
            f d = d(bArr);
            this.iY = true;
            if (d == null) {
                this.iZ = new i(null);
                com.baidu.ar.h.b.b("ARAuth", "invalid license data");
                this.iZ.U("invalid license data");
                return false;
            }
            k a2 = a(d);
            if (a2 instanceof l) {
                this.iZ = new i(this.iX != null ? this.iX.jN : null);
                String[] strArr = new String[1];
                boolean a3 = ((l) a2).a(context, strArr);
                if (a3) {
                    this.iZ.cA();
                    return a3;
                }
                this.iZ.U(strArr[0]);
                com.baidu.ar.h.b.b("ARAuth", strArr[0]);
                return a3;
            }
            return false;
        }
    }

    @Override // com.baidu.ar.auth.j
    public Bitmap createTipBitmap(Context context) {
        return g.o(context);
    }

    @Override // com.baidu.ar.auth.j
    public void doAuth(Context context, final IAuthCallback iAuthCallback) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.ja = iAuthCallback;
        if (!this.iY) {
            h(applicationContext);
        }
        a(applicationContext, iAuthCallback, new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.5
            @Override // java.lang.Runnable
            public void run() {
                if (iAuthCallback != null) {
                    String str = "请检查license文件";
                    if (ARAuthFacade.this.jd) {
                        str = "请检查传入checkAuth方法的arLicense数据";
                    } else if (!d.cx()) {
                        str = "请检查dumixar.license文件";
                    }
                    iAuthCallback.onError(str, 0);
                }
            }
        }, (ICallbackWith<List<Integer>>) null);
    }

    @Override // com.baidu.ar.auth.j
    public boolean enableFeature(int i) {
        if (this.iZ != null) {
            return this.iZ.v(i);
        }
        return true;
    }

    @Override // com.baidu.ar.auth.j
    public boolean isShowAuthTip() {
        return this.iX == null || !this.iX.jJ;
    }

    @Override // com.baidu.ar.auth.j
    public void loadAuthInfo(Context context) {
        if (this.jg) {
            return;
        }
        h(context);
    }

    @Override // com.baidu.ar.auth.j
    public void receiveAuthFailMessage(int i) {
        u(i);
    }

    @Override // com.baidu.ar.auth.j
    public void release() {
        if (this.je != null) {
            this.je.stop();
            this.je = null;
        }
        this.iY = false;
        this.iZ = null;
        this.ja = null;
        this.jb.clear();
        this.jc.clear();
    }

    @Override // com.baidu.ar.auth.j
    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        this.jf = bArr;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
        this.jg = !TextUtils.isEmpty(str2);
    }
}
