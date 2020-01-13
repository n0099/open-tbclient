package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes10.dex */
public class a {
    private a.InterfaceC0317a cdv;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(d dVar, com.baidu.swan.game.ad.a.b bVar) {
        if (dVar != null) {
            ResponseCallback<AdResponseInfo> responseCallback = new ResponseCallback<AdResponseInfo>() { // from class: com.baidu.swan.game.ad.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: c */
                public AdResponseInfo parseResponse(Response response, int i) {
                    if (response == null || response.body() == null || !response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (TextUtils.isEmpty(string)) {
                            return null;
                        }
                        return new AdResponseInfo(string);
                    } catch (Exception e) {
                        return null;
                    } catch (OutOfMemoryError e2) {
                        return null;
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                    if (adResponseInfo == null) {
                        a.this.ny("200000");
                    } else if (adResponseInfo.getAdInstanceList().size() > 0) {
                        final AdElementInfo aia = adResponseInfo.aia();
                        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.c.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cdv != null) {
                                    a.this.cdv.b(aia);
                                }
                            }
                        });
                    } else {
                        String errorCode = adResponseInfo.getErrorCode();
                        if (errorCode.equals("0")) {
                            errorCode = "201000";
                        }
                        a.this.ny(errorCode);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    a.this.ny("3010002");
                }
            };
            if (SwanAppNetworkUtils.isNetworkConnected(this.mContext)) {
                String ail = dVar.ail();
                if (bVar != null) {
                    bVar.a(ail, responseCallback);
                    return;
                }
                return;
            }
            ny("3010003");
        }
    }

    public void a(a.InterfaceC0317a interfaceC0317a) {
        this.cdv = interfaceC0317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cdv != null) {
                    a.this.cdv.nt(str);
                }
            }
        });
    }
}
