package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class e {
    private Context a;
    private List<HashMap<String, String>> b = null;
    private a<String> c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a<Result> {
        void a(Result result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context) {
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
            this.c.a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list) {
        int i = 0;
        com.baidu.lbsapi.auth.a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            com.baidu.lbsapi.auth.a.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                com.baidu.lbsapi.auth.a.a("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
                if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject((String) arrayList.get(i2 - 1));
                    if (!jSONObject.has("status") || jSONObject.getInt("status") == 0) {
                        return;
                    }
                    com.baidu.lbsapi.auth.a.a("i-1 result is not 0,return first result");
                    a((String) arrayList.get(0));
                    return;
                } catch (JSONException e) {
                    a(ErrorMessage.a("JSONException:" + e.getMessage()));
                    return;
                }
            }
            com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            g gVar = new g(this.a);
            if (gVar.a()) {
                String a2 = gVar.a(hashMap);
                if (a2 == null) {
                    a2 = "";
                }
                com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i2 + "  result:" + a2);
                arrayList.add(a2);
                try {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (jSONObject2.has("status") && jSONObject2.getInt("status") == 0) {
                        com.baidu.lbsapi.auth.a.a("auth end and break");
                        a(a2);
                        return;
                    }
                } catch (JSONException e2) {
                    com.baidu.lbsapi.auth.a.a("continue-------------------------------");
                }
            } else {
                com.baidu.lbsapi.auth.a.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            com.baidu.lbsapi.auth.a.a("syncConnect end");
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        this.b = a(hashMap, strArr);
        this.c = aVar;
        new Thread(new f(this)).start();
    }
}
