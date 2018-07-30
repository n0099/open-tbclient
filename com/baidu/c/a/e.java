package com.baidu.c.a;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class e {
    private Context a;
    private HashMap<String, String> b = null;
    private a<String> Vv = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a<Result> {
        void a(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            }
        } catch (JSONException e) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.Vv != null) {
            this.Vv.a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    private HashMap<String, String> i(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap, a<String> aVar) {
        this.b = i(hashMap);
        this.Vv = aVar;
        new Thread(new Runnable() { // from class: com.baidu.c.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
                e.this.a(new g(e.this.a).a(e.this.b));
            }
        }).start();
    }
}
