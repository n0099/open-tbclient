package com.baidu.swan.games.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class e {

    /* loaded from: classes11.dex */
    public interface a {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public static void a(long j, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
            if (apN == null) {
                aVar.onFail("swan app is null");
                return;
            }
            com.baidu.swan.games.network.b.aCf().getRequest().cookieManager(com.baidu.swan.apps.u.a.agu().TS()).url(com.baidu.swan.apps.u.a.agj().Tf()).addUrlParam("appkey", apN.getAppKey()).addUrlParam("duration", String.valueOf(j)).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject b = e.b(str, a.this);
                        if (b != null) {
                            a.this.onSuccess(g.bO(b));
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
            com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
            if (apN == null) {
                aVar.onFail("swan app is null");
                return;
            }
            com.baidu.swan.games.network.b.aCf().getRequest().cookieManager(com.baidu.swan.apps.u.a.agu().TS()).url(com.baidu.swan.apps.u.a.agj().Tg()).addUrlParam("appkey", apN.getAppKey()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str2, int i) {
                    if (!TextUtils.isEmpty(str2)) {
                        JSONObject b = e.b(str2, a.this);
                        if (b != null) {
                            a.this.onSuccess(f.bN(b));
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
