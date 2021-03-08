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
/* loaded from: classes5.dex */
public class a {
    private a.b eai;
    private boolean eaj;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.eaj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d eak;
        final /* synthetic */ com.baidu.swan.game.ad.a.b eal;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.eak = dVar;
            this.eal = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eak != null && this.eak.eaN != null) {
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
                                        if (a.this.eaj) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.eaj);
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
                            a.this.vx("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aSd = adResponseInfo.aSd();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.eai != null) {
                                        a.this.eai.a(aSd);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.eak.eaN.ru() == 1 && com.baidu.swan.game.ad.d.f.aSz()) {
                            a.this.a(AnonymousClass1.this.eal, AnonymousClass1.this.eak, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.vx(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.vx("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.eaj || !(this.eak instanceof e)) {
                        a.this.eaj = false;
                        String aSl = this.eak.aSl();
                        if (this.eal != null) {
                            this.eal.a(aSl, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.eak;
                    if (this.eal != null && eVar.aSo() != null) {
                        this.eal.a(eVar.aSl(), eVar.aSo(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.vx("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.a(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.eaj = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aSo() != null) {
                    bVar.a(eVar.aSl(), eVar.aSo(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().vy(com.baidu.swan.game.ad.d.f.aSw()).vz(com.baidu.swan.game.ad.d.f.aSx()).vA(dVar.eaN.aSh()).kP(ah.getDisplayWidth(this.mContext)).kQ(ah.getDisplayHeight(this.mContext)).aSi(), 5, 5);
            if (bVar != null && eVar2.aSo() != null) {
                bVar.a(eVar2.aSl(), eVar2.aSo(), responseCallback);
                return;
            }
            return;
        }
        vx("3010003");
    }

    public void a(a.b bVar) {
        this.eai = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.eai != null) {
                    a.this.eai.vs(str);
                }
            }
        });
    }
}
