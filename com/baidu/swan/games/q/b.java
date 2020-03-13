package com.baidu.swan.games.q;

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
/* loaded from: classes11.dex */
public class b extends a {
    private com.baidu.swan.games.e.b cqH;

    public b(@NonNull com.baidu.swan.games.e.b bVar) {
        this.cqH = bVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null && this.cqH != null) {
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            try {
                int i = c.getInt("todayPlayedTime");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.acH());
                    jSONObject.put("todayPlayedTime", String.valueOf(i));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                b(com.baidu.swan.apps.w.a.Ui().If(), jSONObject.toString(), new ResponseCallback<com.baidu.swan.games.q.a.a>() { // from class: com.baidu.swan.games.q.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: d */
                    public com.baidu.swan.games.q.a.a parseResponse(Response response, int i2) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("CheckIsUserAdvisedToRestApi", "parse response: " + string);
                        }
                        JSONObject jSONObject2 = new JSONObject(string);
                        String optString = jSONObject2.optString("errno");
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("CheckIsUserAdvisedToRestApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject2.optString(BaseJsonData.TAG_ERRMSG));
                            return null;
                        }
                        String optString2 = jSONObject2.optJSONObject("data").optString("result");
                        com.baidu.swan.games.q.a.a aVar = new com.baidu.swan.games.q.a.a();
                        aVar.result = TextUtils.equals(optString2, "0") ? false : true;
                        aVar.errNo = "0";
                        aVar.errMsg = com.baidu.swan.games.utils.b.bV("checkIsUserAdvisedToRest", "ok");
                        return aVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(final com.baidu.swan.games.q.a.a aVar, int i2) {
                        if (a.DEBUG) {
                            Log.d("CheckIsUserAdvisedToRestApi", "on success");
                        }
                        b.this.cqH.m(new Runnable() { // from class: com.baidu.swan.games.q.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, true, aVar);
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
                        b.this.cqH.m(new Runnable() { // from class: com.baidu.swan.games.q.b.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.a("checkIsUserAdvisedToRest", e2);
                com.baidu.swan.games.utils.b.a(c, false, cVar);
            }
        }
    }
}
