package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.b.a;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a {
    private Context a;
    private a.InterfaceC0208a bem;

    public a(Context context) {
        this.a = context;
    }

    public void a(d dVar, com.baidu.swan.game.ad.b.b bVar) {
        if (dVar != null) {
            ResponseCallback<com.baidu.swan.game.ad.a.b> responseCallback = new ResponseCallback<com.baidu.swan.game.ad.a.b>() { // from class: com.baidu.swan.game.ad.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: b */
                public com.baidu.swan.game.ad.a.b parseResponse(Response response, int i) {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            return new com.baidu.swan.game.ad.a.b(string);
                        }
                    } catch (Exception e) {
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.swan.game.ad.a.b bVar2, int i) {
                    if (bVar2 == null) {
                        a.this.a("200000");
                    } else if (bVar2.c().size() > 0) {
                        final com.baidu.swan.game.ad.a.a QL = bVar2.QL();
                        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.c.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bem != null) {
                                    a.this.bem.a(QL);
                                }
                            }
                        });
                    } else {
                        String b = bVar2.b();
                        if (b.equals("0")) {
                            b = "201000";
                        }
                        a.this.a(b);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    a.this.a("3010002");
                }
            };
            if (SwanAppNetworkUtils.isNetworkConnected(this.a)) {
                String b = dVar.b();
                if (bVar != null) {
                    bVar.a(b, responseCallback);
                    return;
                }
                return;
            }
            a("3010003");
        }
    }

    public void a(a.InterfaceC0208a interfaceC0208a) {
        this.bem = interfaceC0208a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bem != null) {
                    a.this.bem.a(str);
                }
            }
        });
    }
}
