package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.auth.l;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.f.p;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public class ARAuthFacade implements k {
    public static final int AUTH_TYPE_AIP = 1;
    public static final int AUTH_TYPE_AR_SERVER = 2;
    public static final int AUTH_TYPE_PACKAGE = 4;
    private f iZ;
    private volatile i jb;
    private j jc;
    private byte[] jg;
    private boolean ja = false;
    private final List<IDuMixAuthCallback> jd = new ArrayList();
    private List<j> je = new ArrayList();
    private boolean jf = false;
    private boolean jh = false;

    private l a(f fVar) {
        boolean z = (fVar.jC & 2) > 0;
        boolean z2 = (fVar.jC & 4) > 0;
        boolean z3 = (fVar.jC & 1) > 0;
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(new m(fVar));
        }
        if (z) {
            arrayList.add(new b(fVar));
        }
        if (z3 && d.ch()) {
            arrayList.add(new c(fVar));
        }
        if (arrayList.size() > 1) {
            return new h((l[]) arrayList.toArray(new l[arrayList.size()]));
        }
        if (arrayList.size() == 1) {
            return (l) arrayList.get(0);
        }
        return null;
    }

    private void a(Context context, j jVar, Runnable runnable, ICallbackWith<List<Integer>> iCallbackWith) {
        if (this.jb == null) {
            this.jb = new i(this.iZ != null ? this.iZ.jI : null);
            if (this.iZ != null ? a(context, jVar, this.iZ, iCallbackWith) : false) {
                return;
            }
            a("未知鉴权方式", this.iZ, context);
            if (runnable != null) {
                p.a(runnable, 0L);
            }
        } else if (this.jb.isRunning()) {
            if (jVar != null) {
                this.je.add(jVar);
            }
        } else if (this.jb.isFailed()) {
            this.jb.ck();
            if (jVar != null) {
                jVar.onError(this.jb.cj(), 0);
            }
        } else {
            this.jb.ck();
            if (jVar != null) {
                jVar.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f fVar, Context context) {
        if (this.jb != null) {
            this.jb.Q(str);
        }
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.INPUT_DEF_PKG, context.getPackageName());
            if (fVar != null) {
                hashMap.put("authtype", String.valueOf(fVar.jC));
                hashMap.put("r_appid", fVar.jG);
            }
            hashMap.put("event_param", str);
            StatisticApi.onEvent(StatisticConstants.AUTH_FAILURE, hashMap);
        }
    }

    private boolean a(final Context context, final j jVar, final f fVar, final ICallbackWith<List<Integer>> iCallbackWith) {
        l a = a(fVar);
        if (a != null) {
            a.a(new l.a() { // from class: com.baidu.ar.auth.ARAuthFacade.7
                @Override // com.baidu.ar.auth.l.a
                public void a(Set<Integer> set) {
                    if (ARAuthFacade.this.jb != null) {
                        ARAuthFacade.this.jb.b(set);
                        if (iCallbackWith != null) {
                            iCallbackWith.run(ARAuthFacade.this.jb.cl());
                        }
                    }
                }
            });
            a.doAuth(context, new j() { // from class: com.baidu.ar.auth.ARAuthFacade.8
                @Override // com.baidu.ar.auth.j
                public void onError(String str, int i) {
                    ARAuthFacade.this.a(str, fVar, context);
                    if (jVar != null) {
                        jVar.onError(str, i);
                    }
                    if (ARAuthFacade.this.je.isEmpty()) {
                        return;
                    }
                    for (j jVar2 : ARAuthFacade.this.je) {
                        jVar2.onError(str, i);
                    }
                }

                @Override // com.baidu.ar.auth.j
                public void onSuccess() {
                    if (ARAuthFacade.this.jb != null) {
                        ARAuthFacade.this.jb.ci();
                    }
                    if (jVar != null) {
                        jVar.onSuccess();
                    }
                    if (ARAuthFacade.this.je.isEmpty()) {
                        return;
                    }
                    for (j jVar2 : ARAuthFacade.this.je) {
                        jVar2.onSuccess();
                    }
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IDuMixAuthCallback[] ce() {
        IDuMixAuthCallback[] iDuMixAuthCallbackArr = new IDuMixAuthCallback[this.jd.size()];
        this.jd.toArray(iDuMixAuthCallbackArr);
        return iDuMixAuthCallbackArr;
    }

    private f d(byte[] bArr) {
        f fVar = new f();
        try {
            e.a(bArr, fVar);
            this.iZ = fVar;
        } catch (Exception e) {
            e.printStackTrace();
            this.iZ = null;
        }
        return fVar;
    }

    private void g(Context context) {
        if (!this.ja) {
            f fVar = null;
            if (this.jg == null || this.jg.length <= 0) {
                try {
                    fVar = e.l(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fVar = d(this.jg);
            }
            this.iZ = fVar;
        }
        this.ja = true;
        if (this.iZ == null || TextUtils.isEmpty(this.iZ.jG)) {
            return;
        }
        DuMixARConfig.setAppId(this.iZ.jG);
        DuMixARConfig.setAPIKey(this.iZ.jH);
        DuMixARConfig.setSecretKey("");
    }

    private void v(final int i) {
        p.a(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.6
            @Override // java.lang.Runnable
            public void run() {
                if (ARAuthFacade.this.jc != null) {
                    ARAuthFacade.this.jc.onError("未授权功能: " + i, i);
                }
                for (IDuMixAuthCallback iDuMixAuthCallback : ARAuthFacade.this.ce()) {
                    iDuMixAuthCallback.onFeatureRejected(i);
                }
            }
        }, 0L);
    }

    @Override // com.baidu.ar.auth.k
    public List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        if (this.jb != null) {
            if (iDuMixAuthCallback != null) {
                if (this.jb.isRunning()) {
                    this.jd.add(iDuMixAuthCallback);
                } else if (this.jb.isFailed()) {
                    iDuMixAuthCallback.onResult(false);
                } else {
                    iDuMixAuthCallback.onResult(true);
                }
            }
            return this.iZ != null ? this.iZ.jI : new ArrayList();
        } else if (bArr == null) {
            throw new IllegalStateException("license数据不能为空");
        } else {
            this.jf = true;
            if (iDuMixAuthCallback != null) {
                this.jd.add(iDuMixAuthCallback);
            }
            f d = d(bArr);
            this.ja = true;
            final Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.2
                @Override // java.lang.Runnable
                public void run() {
                    IDuMixAuthCallback[] ce;
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.ce()) {
                        iDuMixAuthCallback2.onResult(false);
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(new ArrayList());
                        iDuMixAuthCallback2.onFeatureRejected(0);
                    }
                }
            };
            a(context.getApplicationContext(), new j() { // from class: com.baidu.ar.auth.ARAuthFacade.3
                @Override // com.baidu.ar.auth.j
                public void onError(String str, int i) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // com.baidu.ar.auth.j
                public void onSuccess() {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.ce()) {
                        iDuMixAuthCallback2.onResult(true);
                    }
                }
            }, runnable, new ICallbackWith<List<Integer>>() { // from class: com.baidu.ar.auth.ARAuthFacade.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: e */
                public void run(List<Integer> list) {
                    for (IDuMixAuthCallback iDuMixAuthCallback2 : ARAuthFacade.this.ce()) {
                        iDuMixAuthCallback2.onAvailFeaturesUpdate(list);
                    }
                }
            });
            return this.iZ != null ? d.jI : new ArrayList();
        }
    }

    @Override // com.baidu.ar.auth.k
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

    @Override // com.baidu.ar.auth.k
    public boolean checkFeatureAuth(int i) {
        boolean w = this.jb != null ? this.jb.w(i) : true;
        if (!w) {
            v(i);
        }
        if (w) {
            HashMap hashMap = new HashMap();
            hashMap.put("feature_code", String.valueOf(i));
            StatisticApi.onEventDebounce(StatisticConstants.EVENT_FEATURE_AUTH, 200L, hashMap);
        }
        return w;
    }

    @Override // com.baidu.ar.auth.k
    public Bitmap createTipBitmap(Context context) {
        return g.n(context);
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, final j jVar) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.jc = jVar;
        if (!this.ja) {
            g(applicationContext);
        }
        a(applicationContext, jVar, new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.5
            @Override // java.lang.Runnable
            public void run() {
                if (jVar != null) {
                    String str = "请检查license文件";
                    if (ARAuthFacade.this.jf) {
                        str = "请检查传入checkAuth方法的arLicense数据";
                    } else if (!d.ch()) {
                        str = "请检查dumixar.license文件";
                    }
                    jVar.onError(str, 0);
                }
            }
        }, (ICallbackWith<List<Integer>>) null);
    }

    @Override // com.baidu.ar.auth.k
    public boolean enableFeature(int i) {
        if (this.jb != null) {
            return this.jb.w(i);
        }
        return true;
    }

    @Override // com.baidu.ar.auth.k
    public boolean isShowAuthTip() {
        return this.iZ == null || !this.iZ.jE;
    }

    @Override // com.baidu.ar.auth.k
    public void loadAuthInfo(Context context) {
        if (this.jh) {
            return;
        }
        g(context);
    }

    @Override // com.baidu.ar.auth.k
    public void receiveAuthFailMessage(int i) {
        v(i);
    }

    @Override // com.baidu.ar.auth.k
    public void release() {
        this.ja = false;
        this.jb = null;
        this.jc = null;
        this.jd.clear();
        this.je.clear();
    }

    @Override // com.baidu.ar.auth.k
    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        this.jg = bArr;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
        this.jh = !TextUtils.isEmpty(str2);
    }
}
