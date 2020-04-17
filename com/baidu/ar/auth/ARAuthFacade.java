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
/* loaded from: classes3.dex */
public class ARAuthFacade implements k {
    public static final int AUTH_TYPE_AIP = 1;
    public static final int AUTH_TYPE_AR_SERVER = 2;
    public static final int AUTH_TYPE_PACKAGE = 4;
    private f iK;
    private volatile i iM;
    private j iN;
    private ICallbackWith<Integer> iO;
    private boolean iL = false;
    private List<j> iP = new ArrayList();
    private boolean iQ = false;

    private l a(f fVar) {
        boolean z = (fVar.jl & 2) > 0;
        boolean z2 = (fVar.jl & 4) > 0;
        boolean z3 = (fVar.jl & 1) > 0;
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(new m(fVar));
        }
        if (z) {
            arrayList.add(new b(fVar));
        }
        if (z3 && d.bR()) {
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
        if (this.iM == null) {
            this.iM = new i(this.iK != null ? this.iK.jr : null);
            if (this.iK != null ? a(context, jVar, this.iK, iCallbackWith) : false) {
                return;
            }
            a("未知鉴权方式", this.iK, context);
            if (runnable != null) {
                p.a(runnable, 0L);
            }
        } else if (this.iM.isRunning()) {
            if (jVar != null) {
                this.iP.add(jVar);
            }
        } else if (this.iM.isFailed()) {
            if (jVar != null) {
                jVar.onError(this.iM.bT(), 0);
            }
        } else if (jVar != null) {
            jVar.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f fVar, Context context) {
        if (this.iM != null) {
            this.iM.Q(str);
        }
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.INPUT_DEF_PKG, context.getPackageName());
            if (fVar != null) {
                hashMap.put("authtype", String.valueOf(fVar.jl));
                hashMap.put("r_appid", fVar.jp);
            }
            hashMap.put("event_param", str);
            StatisticApi.onEvent(StatisticConstants.AUTH_FAILURE, hashMap);
        }
    }

    private boolean a(final Context context, final j jVar, final f fVar, final ICallbackWith<List<Integer>> iCallbackWith) {
        l a = a(fVar);
        if (a != null) {
            a.a(new l.a() { // from class: com.baidu.ar.auth.ARAuthFacade.5
                @Override // com.baidu.ar.auth.l.a
                public void a(Set<Integer> set) {
                    if (ARAuthFacade.this.iM != null) {
                        ARAuthFacade.this.iM.b(set);
                        if (iCallbackWith != null) {
                            iCallbackWith.run(ARAuthFacade.this.iM.bV());
                        }
                    }
                }
            });
            a.doAuth(context, new j() { // from class: com.baidu.ar.auth.ARAuthFacade.6
                @Override // com.baidu.ar.auth.j
                public void onError(String str, int i) {
                    ARAuthFacade.this.a(str, fVar, context);
                    if (jVar != null) {
                        jVar.onError(str, i);
                    }
                    if (ARAuthFacade.this.iP.isEmpty()) {
                        return;
                    }
                    for (j jVar2 : ARAuthFacade.this.iP) {
                        jVar2.onError(str, i);
                    }
                }

                @Override // com.baidu.ar.auth.j
                public void onSuccess() {
                    if (ARAuthFacade.this.iM != null) {
                        ARAuthFacade.this.iM.bS();
                    }
                    if (jVar != null) {
                        jVar.onSuccess();
                    }
                    if (ARAuthFacade.this.iP.isEmpty()) {
                        return;
                    }
                    for (j jVar2 : ARAuthFacade.this.iP) {
                        jVar2.onSuccess();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void t(final int i) {
        p.a(new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.4
            @Override // java.lang.Runnable
            public void run() {
                if (ARAuthFacade.this.iN != null) {
                    ARAuthFacade.this.iN.onError("未授权功能: " + i, i);
                }
                if (ARAuthFacade.this.iO != null) {
                    ARAuthFacade.this.iO.run(Integer.valueOf(i));
                }
            }
        }, 0L);
    }

    @Override // com.baidu.ar.auth.k
    public List<Integer> checkAuth(Context context, byte[] bArr, final ICallbackWith<List<Integer>> iCallbackWith, final ICallbackWith<Integer> iCallbackWith2) {
        if (this.iM != null) {
            return this.iK != null ? this.iK.jr : new ArrayList();
        } else if (bArr == null) {
            throw new IllegalStateException("license数据不能为空");
        } else {
            this.iQ = true;
            this.iO = iCallbackWith2;
            f fVar = new f();
            try {
                e.a(bArr, fVar);
                this.iK = fVar;
            } catch (Exception e) {
                e.printStackTrace();
                this.iK = null;
            }
            this.iL = true;
            final Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iCallbackWith != null) {
                        iCallbackWith.run(new ArrayList());
                    }
                    if (iCallbackWith2 != null) {
                        iCallbackWith2.run(0);
                    }
                }
            };
            a(context.getApplicationContext(), new j() { // from class: com.baidu.ar.auth.ARAuthFacade.2
                @Override // com.baidu.ar.auth.j
                public void onError(String str, int i) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // com.baidu.ar.auth.j
                public void onSuccess() {
                }
            }, runnable, iCallbackWith);
            return this.iK != null ? fVar.jr : new ArrayList();
        }
    }

    @Override // com.baidu.ar.auth.k
    public boolean checkFeatureAuth(int i) {
        boolean u = this.iM != null ? this.iM.u(i) : true;
        if (!u) {
            t(i);
        }
        if (u) {
            HashMap hashMap = new HashMap();
            hashMap.put("feature_code", String.valueOf(i));
            StatisticApi.onEventDebounce(StatisticConstants.EVENT_FEATURE_AUTH, 200L, hashMap);
        }
        return u;
    }

    @Override // com.baidu.ar.auth.k
    public Bitmap createTipBitmap(Context context) {
        return g.l(context);
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, final j jVar) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.iN = jVar;
        if (!this.iL) {
            loadAuthInfo(applicationContext);
        }
        a(applicationContext, jVar, new Runnable() { // from class: com.baidu.ar.auth.ARAuthFacade.3
            @Override // java.lang.Runnable
            public void run() {
                if (jVar != null) {
                    String str = "请检查license文件";
                    if (ARAuthFacade.this.iQ) {
                        str = "请检查传入checkAuth方法的arLicense数据";
                    } else if (!d.bR()) {
                        str = "请检查dumixar.license文件";
                    }
                    jVar.onError(str, 0);
                }
            }
        }, (ICallbackWith<List<Integer>>) null);
    }

    @Override // com.baidu.ar.auth.k
    public boolean enableFeature(int i) {
        if (this.iM != null) {
            return this.iM.u(i);
        }
        return true;
    }

    @Override // com.baidu.ar.auth.k
    public boolean isShowAuthTip() {
        return this.iK == null || !this.iK.jn;
    }

    @Override // com.baidu.ar.auth.k
    public void loadAuthInfo(Context context) {
        if (!this.iL) {
            f fVar = null;
            try {
                fVar = e.j(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.iK = fVar;
        }
        this.iL = true;
        if (this.iK == null || TextUtils.isEmpty(this.iK.jp)) {
            return;
        }
        DuMixARConfig.setAppId(this.iK.jp);
        DuMixARConfig.setAPIKey(this.iK.jq);
        DuMixARConfig.setSecretKey("");
    }

    @Override // com.baidu.ar.auth.k
    public void receiveAuthFailMessage(int i) {
        t(i);
    }

    @Override // com.baidu.ar.auth.k
    public void release() {
        this.iL = false;
        this.iM = null;
        this.iN = null;
        this.iP.clear();
    }
}
