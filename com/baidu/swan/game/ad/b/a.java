package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes14.dex */
public class a {
    private a.b dWA;
    private boolean dWB;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dWB = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dWC;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dWD;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dWC = dVar;
            this.dWD = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dWC != null && this.dWC.dXf != null) {
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
                                        if (a.this.dWB) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dWB);
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
                            a.this.uX("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aRL = adResponseInfo.aRL();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dWA != null) {
                                        a.this.dWA.a(aRL);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dWC.dXf.rw() == 1 && com.baidu.swan.game.ad.d.f.aSk()) {
                            a.this.a(AnonymousClass1.this.dWD, AnonymousClass1.this.dWC, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.uX(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.uX("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dWB || !(this.dWC instanceof e)) {
                        a.this.dWB = false;
                        String aRW = this.dWC.aRW();
                        if (this.dWD != null) {
                            this.dWD.a(aRW, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dWC;
                    if (this.dWD != null && eVar.aRZ() != null) {
                        this.dWD.a(eVar.aRW(), eVar.aRZ(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.uX("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.a(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dWB = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aRZ() != null) {
                    bVar.a(eVar.aRW(), eVar.aRZ(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().uY(com.baidu.swan.game.ad.d.f.aSh()).uZ(com.baidu.swan.game.ad.d.f.aSi()).va(dVar.dXf.aRS()).kL(ah.getDisplayWidth(this.mContext)).kM(ah.getDisplayHeight(this.mContext)).aRT(), 5, 5);
            if (bVar != null && eVar2.aRZ() != null) {
                bVar.a(eVar2.aRW(), eVar2.aRZ(), responseCallback);
                return;
            }
            return;
        }
        uX("3010003");
    }

    public void a(a.b bVar) {
        this.dWA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uX(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dWA != null) {
                    a.this.dWA.uS(str);
                }
            }
        });
    }
}
