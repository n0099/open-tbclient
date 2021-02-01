package com.baidu.swan.games.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class e {

    /* loaded from: classes9.dex */
    public interface a {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public static void a(long j, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            if (aIL == null) {
                aVar.onFail("swan app is null");
                return;
            }
            com.baidu.swan.games.network.b.aXB().getRequest().cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).url(com.baidu.swan.apps.t.a.axi().ahC()).addUrlParam("appkey", aIL.getAppKey()).addUrlParam("duration", String.valueOf(j)).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: U */
                public void onSuccess(String str, int i) {
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject b2 = e.b(str, a.this);
                        if (b2 != null) {
                            a.this.onSuccess(g.ct(b2));
                            return;
                        }
                        return;
                    }
                    a.this.onFail("response is null");
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }

    public static void a(String str, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            if (aIL == null) {
                aVar.onFail("swan app is null");
                return;
            }
            com.baidu.swan.games.network.b.aXB().getRequest().cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).url(com.baidu.swan.apps.t.a.axi().ahD()).addUrlParam("appkey", aIL.getAppKey()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: U */
                public void onSuccess(String str2, int i) {
                    if (!TextUtils.isEmpty(str2)) {
                        JSONObject b2 = e.b(str2, a.this);
                        if (b2 != null) {
                            a.this.onSuccess(f.cs(b2));
                            return;
                        }
                        return;
                    }
                    a.this.onFail("response is null");
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject b(String str, a aVar) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.optInt(BaseJsonData.TAG_ERRNO, -1) != 0) {
                aVar.onFail(jSONObject2.optString(BaseJsonData.TAG_ERRMSG));
            } else {
                jSONObject = jSONObject2.optJSONObject("data");
            }
        } catch (Exception e) {
            aVar.onFail(e.getMessage());
        }
        return jSONObject;
    }
}
