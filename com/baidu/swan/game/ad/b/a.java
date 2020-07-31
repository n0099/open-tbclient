package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class a {
    private a.b dan;
    private boolean dao;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public a(Context context, boolean z) {
        this(context);
        this.dao = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.game.ad.b.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ d dap;
        final /* synthetic */ com.baidu.swan.game.ad.a.b daq;

        AnonymousClass1(d dVar, com.baidu.swan.game.ad.a.b bVar) {
            this.dap = dVar;
            this.daq = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dap != null && this.dap.daU != null) {
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
                                        if (a.this.dao) {
                                            adResponseInfo = new AdResponseInfo(string, a.this.dao);
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
                            a.this.rB("200000");
                        } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                            final AdElementInfo aAo = adResponseInfo.aAo();
                            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (a.this.dan != null) {
                                        a.this.dan.a(aAo);
                                    }
                                }
                            });
                        } else if (this.count == 1 && AnonymousClass1.this.dap.daU.qp() == 1 && com.baidu.swan.game.ad.d.f.aAP()) {
                            a.this.a(AnonymousClass1.this.daq, AnonymousClass1.this.dap, this);
                        } else {
                            this.count = 0;
                            String errorCode = adResponseInfo.getErrorCode();
                            if (errorCode.equals("0")) {
                                errorCode = "201000";
                            }
                            a.this.rB(errorCode);
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        a.this.rB("3010002");
                    }
                };
                if (SwanAppNetworkUtils.isNetworkConnected(a.this.mContext)) {
                    if (!a.this.dao || !(this.dap instanceof e)) {
                        a.this.dao = false;
                        String aAA = this.dap.aAA();
                        if (this.daq != null) {
                            this.daq.a(aAA, responseCallback);
                            return;
                        }
                        return;
                    }
                    e eVar = (e) this.dap;
                    if (this.daq != null && eVar.aAE() != null) {
                        this.daq.a(eVar.aAA(), eVar.aAE(), responseCallback);
                        return;
                    }
                    return;
                }
                a.this.rB("3010003");
            }
        }
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        p.postOnIO(new AnonymousClass1(dVar, bVar), "execAdRequest");
    }

    public void a(com.baidu.swan.game.ad.a.b bVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
            this.dao = true;
            if (dVar instanceof e) {
                e eVar = (e) dVar;
                if (bVar != null && eVar.aAE() != null) {
                    bVar.a(eVar.aAA(), eVar.aAE(), responseCallback);
                    return;
                }
                return;
            }
            e eVar2 = new e(this.mContext, new b.a().rC(com.baidu.swan.game.ad.d.f.aAM()).rD(com.baidu.swan.game.ad.d.f.aAN()).rE(dVar.daU.aAw()).iD(ai.getDisplayWidth(this.mContext)).iE(ai.getDisplayHeight(this.mContext)).aAx(), 5, 5);
            if (bVar != null && eVar2.aAE() != null) {
                bVar.a(eVar2.aAA(), eVar2.aAE(), responseCallback);
                return;
            }
            return;
        }
        rB("3010003");
    }

    public void a(a.b bVar) {
        this.dan = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(final String str) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dan != null) {
                    a.this.dan.rw(str);
                }
            }
        });
    }
}
