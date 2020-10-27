package com.baidu.swan.games.r;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends a {
    private com.baidu.swan.games.f.b dRU;

    public b(@NonNull com.baidu.swan.games.f.b bVar) {
        this.dRU = bVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null && this.dRU != null) {
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            try {
                int i = e.getInt("todayPlayedTime");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.aEW());
                    jSONObject.put("todayPlayedTime", String.valueOf(i));
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                c(com.baidu.swan.apps.t.a.aum().aeH(), jSONObject.toString(), new ResponseCallback<com.baidu.swan.games.r.a.a>() { // from class: com.baidu.swan.games.r.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: e */
                    public com.baidu.swan.games.r.a.a parseResponse(Response response, int i2) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("CheckIsUserAdvisedToRestApi", "parse response: " + string);
                        }
                        JSONObject jSONObject2 = new JSONObject(string);
                        String optString = jSONObject2.optString(BaseJsonData.TAG_ERRNO);
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("CheckIsUserAdvisedToRestApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject2.optString(BaseJsonData.TAG_ERRMSG));
                            return null;
                        }
                        String optString2 = jSONObject2.optJSONObject("data").optString("result");
                        com.baidu.swan.games.r.a.a aVar = new com.baidu.swan.games.r.a.a();
                        aVar.result = TextUtils.equals(optString2, "0") ? false : true;
                        aVar.errNo = "0";
                        aVar.errMsg = com.baidu.swan.games.utils.b.dl("checkIsUserAdvisedToRest", "ok");
                        return aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(final com.baidu.swan.games.r.a.a aVar, int i2) {
                        if (a.DEBUG) {
                            Log.d("CheckIsUserAdvisedToRestApi", "on success");
                        }
                        b.this.dRU.o(new Runnable() { // from class: com.baidu.swan.games.r.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, true, aVar);
                            }
                        });
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (a.DEBUG) {
                            Log.e("CheckIsUserAdvisedToRestApi", "on fail");
                        }
                        if (TextUtils.isEmpty(cVar.errMsg)) {
                            cVar.errNo = "100";
                            cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                        }
                        b.this.dRU.o(new Runnable() { // from class: com.baidu.swan.games.r.b.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.a("checkIsUserAdvisedToRest", e3);
                com.baidu.swan.games.utils.b.a(e, false, cVar);
            }
        }
    }
}
