package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class HttpSyncTask {
    private Context a;
    private List<HashMap<String, String>> b = null;
    private IHttpConnectionCallback<String> c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface IHttpConnectionCallback<Result> {
        void httpRequest(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpSyncTask(Context context) {
        this.a = context;
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                HashMap hashMap2 = new HashMap();
                for (String str : hashMap.keySet()) {
                    String str2 = str.toString();
                    hashMap2.put(str2, hashMap.get(str2));
                }
                hashMap2.put("mcode", strArr[i2]);
                arrayList.add(hashMap2);
                i = i2 + 1;
            }
        } else {
            HashMap hashMap3 = new HashMap();
            for (String str3 : hashMap.keySet()) {
                String str4 = str3.toString();
                hashMap3.put(str4, hashMap.get(str4));
            }
            arrayList.add(hashMap3);
        }
        return arrayList;
    }

    private void a(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list) {
        int i = 0;
        BLog.d("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            BLog.e("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                BLog.d("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
                if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject((String) arrayList.get(i2 - 1));
                    if (!jSONObject.has("status") || jSONObject.getInt("status") == 0) {
                        return;
                    }
                    BLog.d("i-1 result is not 0,return first result");
                    a((String) arrayList.get(0));
                    return;
                } catch (JSONException e) {
                    a(ErrorMessage.a("JSONException:" + e.getMessage()));
                    return;
                }
            }
            BLog.d("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            HttpsHelper httpsHelper = new HttpsHelper(this.a);
            if (httpsHelper.checkNetwork()) {
                String request = httpsHelper.request(hashMap);
                if (request == null) {
                    request = "";
                }
                BLog.d("syncConnect resuest " + i2 + "  result:" + request);
                arrayList.add(request);
                try {
                    JSONObject jSONObject2 = new JSONObject(request);
                    if (jSONObject2.has("status") && jSONObject2.getInt("status") == 0) {
                        BLog.d("auth end and break");
                        a(request);
                        return;
                    }
                } catch (JSONException e2) {
                    BLog.d("continue-------------------------------");
                }
            } else {
                BLog.d("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            BLog.d("syncConnect end");
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postWithHttps(HashMap<String, String> hashMap, String[] strArr, IHttpConnectionCallback<String> iHttpConnectionCallback) {
        this.b = a(hashMap, strArr);
        this.c = iHttpConnectionCallback;
        new Thread(new Runnable() { // from class: com.baidu.lbsapi.auth.HttpSyncTask.1
            @Override // java.lang.Runnable
            public void run() {
                HttpSyncTask.this.a(HttpSyncTask.this.b);
            }
        }).start();
    }
}
