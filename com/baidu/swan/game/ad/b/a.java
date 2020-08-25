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
/* loaded from: classes19.dex */
public class a {
    private boolean dkA;
    private a.b dkz;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dkA = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dkB;
        final /* synthetic */ com.baidu.swan.game.ad.a.b dkC;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dkB = dVar;
            this.dkC = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dkB != null && this.dkB.dle != null) {
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
                                        if (a.this.dkA) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dkA);
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
                            a.this.tU("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aIZ = adResponseInfo.aIZ();
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dkz != null) {
                                        a.this.dkz.a(aIZ);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dkB.dle.rO() == 1 && com.baidu.swan.game.ad.d.f.aJy()) {
                            a.this.a(AnonymousClass1.this.dkC, AnonymousClass1.this.dkB, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.tU(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.tU("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dkA || !(this.dkB instanceof e)) {
                        a.this.dkA = false;
                        String aJk = this.dkB.aJk();
                        if (this.dkC != null) {
                            this.dkC.a(aJk, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dkB;
                    if (this.dkC != null && eVar.aJn() != null) {
                        this.dkC.a(eVar.aJk(), eVar.aJn(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.tU("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dkA = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aJn() != null) {
                    bVar.a(eVar.aJk(), eVar.aJn(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().tV(com.baidu.swan.game.ad.d.f.aJv()).tW(com.baidu.swan.game.ad.d.f.aJw()).tX(dVar.dle.aJg()).kM(ah.getDisplayWidth(this.mContext)).kN(ah.getDisplayHeight(this.mContext)).aJh(), 5, 5);
            if (bVar != null && eVar2.aJn() != null) {
                bVar.a(eVar2.aJk(), eVar2.aJn(), responseCallback);
                return;
            }
            return;
        }
        tU("3010003");
    }

    public void a(a.b bVar) {
        this.dkz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dkz != null) {
                    a.this.dkz.tP(str);
                }
            }
        });
    }
}
