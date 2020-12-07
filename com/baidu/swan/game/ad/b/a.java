package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes14.dex */
public class a {
    private a.b dSp;
    private boolean dSq;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dSq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dSr;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dSs;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dSr = dVar;
            this.dSs = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dSr != null && this.dSr.dSU != null) {
                ResponseCallback<AdResponseInfo> responseCallback = new ResponseCallback<AdResponseInfo>() { // from class: com.baidu.swan.game.ad.b.a.1.1
                    private int count = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: c */
                    public AdResponseInfo parseResponse(Response response, int i) {
                        AdResponseInfo adResponseInfo = null;
                        if (response != null && response.body() != null) {
                            this.count++;
                            if (response.isSuccessful()) {
                                try {
                                    String string = response.body().string();
                                    if (!TextUtils.isEmpty(string)) {
                                        if (a.this.dSq) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dSq);
                                        } else {
                                            adResponseInfo = new AdResponseInfo(string);
                                        }
                                    }
                                } catch (Exception e) {
                                } catch (OutOfMemoryError e2) {
                                }
                            }
                        }
                        return adResponseInfo;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                        if (adResponseInfo == null) {
                            a.this.wj("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aTk = adResponseInfo.aTk();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dSp != null) {
                                        a.this.dSp.a(aTk);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dSr.dSU.rV() == 1 && com.baidu.swan.game.ad.d.f.aTJ()) {
                            a.this.a(AnonymousClass1.this.dSs, AnonymousClass1.this.dSr, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.wj(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.wj("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dSq || !(this.dSr instanceof e)) {
                        a.this.dSq = false;
                        String aTv = this.dSr.aTv();
                        if (this.dSs != null) {
                            this.dSs.a(aTv, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dSr;
                    if (this.dSs != null && eVar.aTy() != null) {
                        this.dSs.a(eVar.aTv(), eVar.aTy(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.wj("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dSq = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aTy() != null) {
                    bVar.a(eVar.aTv(), eVar.aTy(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().wk(com.baidu.swan.game.ad.d.f.aTG()).wl(com.baidu.swan.game.ad.d.f.aTH()).wm(dVar.dSU.aTr()).mj(ah.getDisplayWidth(this.mContext)).mk(ah.getDisplayHeight(this.mContext)).aTs(), 5, 5);
            if (bVar != null && eVar2.aTy() != null) {
                bVar.a(eVar2.aTv(), eVar2.aTy(), responseCallback);
                return;
            }
            return;
        }
        wj("3010003");
    }

    public void a(a.b bVar) {
        this.dSp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dSp != null) {
                    a.this.dSp.we(str);
                }
            }
        });
    }
}
