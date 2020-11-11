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
    private a.b dNa;
    private boolean dNb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dNb = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dNc;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dNd;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dNc = dVar;
            this.dNd = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dNc != null && this.dNc.dNF != null) {
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
                                        if (a.this.dNb) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dNb);
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
                            a.this.vH("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aQN = adResponseInfo.aQN();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dNa != null) {
                                        a.this.dNa.a(aQN);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dNc.dNF.rT() == 1 && com.baidu.swan.game.ad.d.f.aRm()) {
                            a.this.a(AnonymousClass1.this.dNd, AnonymousClass1.this.dNc, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.vH(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.vH("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dNb || !(this.dNc instanceof e)) {
                        a.this.dNb = false;
                        String aQY = this.dNc.aQY();
                        if (this.dNd != null) {
                            this.dNd.a(aQY, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dNc;
                    if (this.dNd != null && eVar.aRb() != null) {
                        this.dNd.a(eVar.aQY(), eVar.aRb(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.vH("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dNb = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aRb() != null) {
                    bVar.a(eVar.aQY(), eVar.aRb(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().vI(com.baidu.swan.game.ad.d.f.aRj()).vJ(com.baidu.swan.game.ad.d.f.aRk()).vK(dVar.dNF.aQU()).lP(ah.getDisplayWidth(this.mContext)).lQ(ah.getDisplayHeight(this.mContext)).aQV(), 5, 5);
            if (bVar != null && eVar2.aRb() != null) {
                bVar.a(eVar2.aQY(), eVar2.aRb(), responseCallback);
                return;
            }
            return;
        }
        vH("3010003");
    }

    public void a(a.b bVar) {
        this.dNa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dNa != null) {
                    a.this.dNa.vC(str);
                }
            }
        });
    }
}
