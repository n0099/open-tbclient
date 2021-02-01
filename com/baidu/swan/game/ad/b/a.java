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
    private a.b dYH;
    private boolean dYI;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dYI = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dYJ;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dYK;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dYJ = dVar;
            this.dYK = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dYJ != null && this.dYJ.dZl != null) {
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
                                        if (a.this.dYI) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dYI);
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
                            a.this.vq("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aSa = adResponseInfo.aSa();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dYH != null) {
                                        a.this.dYH.a(aSa);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dYJ.dZl.ru() == 1 && com.baidu.swan.game.ad.d.f.aSw()) {
                            a.this.a(AnonymousClass1.this.dYK, AnonymousClass1.this.dYJ, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.vq(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.vq("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dYI || !(this.dYJ instanceof e)) {
                        a.this.dYI = false;
                        String aSi = this.dYJ.aSi();
                        if (this.dYK != null) {
                            this.dYK.a(aSi, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dYJ;
                    if (this.dYK != null && eVar.aSl() != null) {
                        this.dYK.a(eVar.aSi(), eVar.aSl(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.vq("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.a(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dYI = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aSl() != null) {
                    bVar.a(eVar.aSi(), eVar.aSl(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().vr(com.baidu.swan.game.ad.d.f.aSt()).vs(com.baidu.swan.game.ad.d.f.aSu()).vt(dVar.dZl.aSe()).kO(ah.getDisplayWidth(this.mContext)).kP(ah.getDisplayHeight(this.mContext)).aSf(), 5, 5);
            if (bVar != null && eVar2.aSl() != null) {
                bVar.a(eVar2.aSi(), eVar2.aSl(), responseCallback);
                return;
            }
            return;
        }
        vq("3010003");
    }

    public void a(a.b bVar) {
        this.dYH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dYH != null) {
                    a.this.dYH.vl(str);
                }
            }
        });
    }
}
