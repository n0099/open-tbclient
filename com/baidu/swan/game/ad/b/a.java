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
    private a.b dHi;
    private boolean dHj;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dHj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dHk;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dHl;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dHk = dVar;
            this.dHl = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dHk != null && this.dHk.dHN != null) {
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
                                        if (a.this.dHj) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dHj);
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
                            a.this.vt("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aOn = adResponseInfo.aOn();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dHi != null) {
                                        a.this.dHi.a(aOn);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dHk.dHN.rT() == 1 && com.baidu.swan.game.ad.d.f.aOM()) {
                            a.this.a(AnonymousClass1.this.dHl, AnonymousClass1.this.dHk, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.vt(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.vt("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dHj || !(this.dHk instanceof e)) {
                        a.this.dHj = false;
                        String aOy = this.dHk.aOy();
                        if (this.dHl != null) {
                            this.dHl.a(aOy, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dHk;
                    if (this.dHl != null && eVar.aOB() != null) {
                        this.dHl.a(eVar.aOy(), eVar.aOB(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.vt("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dHj = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aOB() != null) {
                    bVar.a(eVar.aOy(), eVar.aOB(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().vu(com.baidu.swan.game.ad.d.f.aOJ()).vv(com.baidu.swan.game.ad.d.f.aOK()).vw(dVar.dHN.aOu()).lF(ah.getDisplayWidth(this.mContext)).lG(ah.getDisplayHeight(this.mContext)).aOv(), 5, 5);
            if (bVar != null && eVar2.aOB() != null) {
                bVar.a(eVar2.aOy(), eVar2.aOB(), responseCallback);
                return;
            }
            return;
        }
        vt("3010003");
    }

    public void a(a.b bVar) {
        this.dHi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dHi != null) {
                    a.this.dHi.vo(str);
                }
            }
        });
    }
}
