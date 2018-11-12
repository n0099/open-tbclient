package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class HttpAsyncTask {
    private Context a;
    private HashMap<String, String> b = null;
    private IHttpConnectionCallback<String> c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface IHttpConnectionCallback<Result> {
        void httpRequest(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpAsyncTask(Context context) {
        this.a = context;
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException e) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.c != null) {
            this.c.httpRequest(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postWithHttps(HashMap<String, String> hashMap, IHttpConnectionCallback<String> iHttpConnectionCallback) {
        this.b = a(hashMap);
        this.c = iHttpConnectionCallback;
        new Thread(new Runnable() { // from class: com.baidu.lbsapi.auth.HttpAsyncTask.1
            @Override // java.lang.Runnable
            public void run() {
                BLog.d("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
                HttpAsyncTask.this.a(new HttpsHelper(HttpAsyncTask.this.a).request(HttpAsyncTask.this.b));
            }
        }).start();
    }
}
