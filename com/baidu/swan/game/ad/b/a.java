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
/* loaded from: classes3.dex */
public class a {
    private a.b ebm;
    private boolean ebn;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.ebn = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d ebo;
        final /* synthetic */ com.baidu.swan.game.ad.a.b ebp;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.ebo = dVar;
            this.ebp = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ebo != null && this.ebo.ebR != null) {
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
                                        if (a.this.ebn) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.ebn);
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
                            a.this.wi("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aVF = adResponseInfo.aVF();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.ebm != null) {
                                        a.this.ebm.a(aVF);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.ebo.ebR.rw() == 1 && com.baidu.swan.game.ad.d.f.aWe()) {
                            a.this.a(AnonymousClass1.this.ebp, AnonymousClass1.this.ebo, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.wi(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.wi("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.ebn || !(this.ebo instanceof e)) {
                        a.this.ebn = false;
                        String aVQ = this.ebo.aVQ();
                        if (this.ebp != null) {
                            this.ebp.a(aVQ, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.ebo;
                    if (this.ebp != null && eVar.aVT() != null) {
                        this.ebp.a(eVar.aVQ(), eVar.aVT(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.wi("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.a(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.ebn = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aVT() != null) {
                    bVar.a(eVar.aVQ(), eVar.aVT(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().wj(com.baidu.swan.game.ad.d.f.aWb()).wk(com.baidu.swan.game.ad.d.f.aWc()).wl(dVar.ebR.aVM()).mr(ah.getDisplayWidth(this.mContext)).ms(ah.getDisplayHeight(this.mContext)).aVN(), 5, 5);
            if (bVar != null && eVar2.aVT() != null) {
                bVar.a(eVar2.aVQ(), eVar2.aVT(), responseCallback);
                return;
            }
            return;
        }
        wi("3010003");
    }

    public void a(a.b bVar) {
        this.ebm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ebm != null) {
                    a.this.ebm.wd(str);
                }
            }
        });
    }
}
