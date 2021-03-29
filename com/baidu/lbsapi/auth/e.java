package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f6328a;

    /* renamed from: b  reason: collision with root package name */
    public List<HashMap<String, String>> f6329b = null;

    /* renamed from: c  reason: collision with root package name */
    public a<String> f6330c = null;

    /* loaded from: classes2.dex */
    public interface a<Result> {
        void a(Result result);
    }

    public e(Context context) {
        this.f6328a = context;
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                String str2 = str.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            arrayList.add(hashMap2);
        } else {
            for (String str3 : strArr) {
                HashMap hashMap3 = new HashMap();
                for (String str4 : hashMap.keySet()) {
                    String str5 = str4.toString();
                    hashMap3.put(str5, hashMap.get(str5));
                }
                hashMap3.put("mcode", str3);
                arrayList.add(hashMap3);
            }
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
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        a<String> aVar = this.f6330c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list) {
        int i;
        com.baidu.lbsapi.auth.a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            com.baidu.lbsapi.auth.a.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i2 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i2);
            g gVar = new g(this.f6328a);
            if (gVar.a()) {
                String a2 = gVar.a(hashMap);
                if (a2 == null) {
                    a2 = "";
                }
                com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i2 + "  result:" + a2);
                arrayList.add(a2);
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        com.baidu.lbsapi.auth.a.a("auth end and break");
                        a(a2);
                        return;
                    }
                } catch (JSONException unused) {
                    com.baidu.lbsapi.auth.a.a("continue-------------------------------");
                }
            } else {
                com.baidu.lbsapi.auth.a.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            com.baidu.lbsapi.auth.a.a("syncConnect end");
            i2++;
        }
        com.baidu.lbsapi.auth.a.a("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || i2 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                return;
            }
            com.baidu.lbsapi.auth.a.a("i-1 result is not 0,return first result");
            a((String) arrayList.get(0));
        } catch (JSONException e2) {
            a(ErrorMessage.a("JSONException:" + e2.getMessage()));
        }
    }

    public void a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        this.f6329b = a(hashMap, strArr);
        this.f6330c = aVar;
        new Thread(new f(this)).start();
    }
}
