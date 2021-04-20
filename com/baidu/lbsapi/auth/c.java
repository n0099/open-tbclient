package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f6359a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f6360b = null;

    /* renamed from: c  reason: collision with root package name */
    public a<String> f6361c = null;

    /* loaded from: classes2.dex */
    public interface a<Result> {
        void a(Result result);
    }

    public c(Context context) {
        this.f6359a = context;
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
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        a<String> aVar = this.f6361c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    public void a(HashMap<String, String> hashMap, a<String> aVar) {
        this.f6360b = a(hashMap);
        this.f6361c = aVar;
        new Thread(new d(this)).start();
    }
}
