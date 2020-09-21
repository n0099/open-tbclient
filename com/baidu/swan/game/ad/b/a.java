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
/* loaded from: classes10.dex */
public class a {
    private a.b dmF;
    private boolean dmG;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dmG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dmH;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dmI;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dmH = dVar;
            this.dmI = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dmH != null && this.dmH.dnk != null) {
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
                                        if (a.this.dmG) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dmG);
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
                            a.this.uo("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aJK = adResponseInfo.aJK();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dmF != null) {
                                        a.this.dmF.a(aJK);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dmH.dnk.rT() == 1 && com.baidu.swan.game.ad.d.f.aKj()) {
                            a.this.a(AnonymousClass1.this.dmI, AnonymousClass1.this.dmH, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.uo(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.uo("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dmG || !(this.dmH instanceof e)) {
                        a.this.dmG = false;
                        String aJV = this.dmH.aJV();
                        if (this.dmI != null) {
                            this.dmI.a(aJV, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dmH;
                    if (this.dmI != null && eVar.aJY() != null) {
                        this.dmI.a(eVar.aJV(), eVar.aJY(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.uo("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dmG = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aJY() != null) {
                    bVar.a(eVar.aJV(), eVar.aJY(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().up(com.baidu.swan.game.ad.d.f.aKg()).uq(com.baidu.swan.game.ad.d.f.aKh()).ur(dVar.dnk.aJR()).kX(ah.getDisplayWidth(this.mContext)).kY(ah.getDisplayHeight(this.mContext)).aJS(), 5, 5);
            if (bVar != null && eVar2.aJY() != null) {
                bVar.a(eVar2.aJV(), eVar2.aJY(), responseCallback);
                return;
            }
            return;
        }
        uo("3010003");
    }

    public void a(a.b bVar) {
        this.dmF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dmF != null) {
                    a.this.dmF.uj(str);
                }
            }
        });
    }
}
