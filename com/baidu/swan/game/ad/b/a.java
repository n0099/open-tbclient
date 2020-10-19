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
    private a.b dyL;
    private boolean dyM;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dyM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dyN;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dyO;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dyN = dVar;
            this.dyO = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dyN != null && this.dyN.dzq != null) {
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
                                        if (a.this.dyM) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dyM);
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
                            a.this.va("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aMt = adResponseInfo.aMt();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dyL != null) {
                                        a.this.dyL.a(aMt);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dyN.dzq.rT() == 1 && com.baidu.swan.game.ad.d.f.aMS()) {
                            a.this.a(AnonymousClass1.this.dyO, AnonymousClass1.this.dyN, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.va(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.va("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dyM || !(this.dyN instanceof e)) {
                        a.this.dyM = false;
                        String aME = this.dyN.aME();
                        if (this.dyO != null) {
                            this.dyO.a(aME, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dyN;
                    if (this.dyO != null && eVar.aMH() != null) {
                        this.dyO.a(eVar.aME(), eVar.aMH(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.va("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dyM = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aMH() != null) {
                    bVar.a(eVar.aME(), eVar.aMH(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().vb(com.baidu.swan.game.ad.d.f.aMP()).vc(com.baidu.swan.game.ad.d.f.aMQ()).vd(dVar.dzq.aMA()).lu(ah.getDisplayWidth(this.mContext)).lv(ah.getDisplayHeight(this.mContext)).aMB(), 5, 5);
            if (bVar != null && eVar2.aMH() != null) {
                bVar.a(eVar2.aME(), eVar2.aMH(), responseCallback);
                return;
            }
            return;
        }
        va("3010003");
    }

    public void a(a.b bVar) {
        this.dyL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dyL != null) {
                    a.this.dyL.uV(str);
                }
            }
        });
    }
}
