package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends m {
    private static g e = null;
    private String c;
    private com.baidu.android.pushservice.j.f d;

    private g(Context context) {
        super(context);
        this.c = "LbsSender";
        this.d = null;
        this.b = "https://lbsonline.pushct.baidu.com/lbsupload";
    }

    public static g a(Context context) {
        if (e == null) {
            e = new g(context);
        }
        return e;
    }

    @Override // com.baidu.android.pushservice.h.m
    String a(boolean z) {
        return com.baidu.android.pushservice.j.g.a(this.a, z);
    }

    public void a(com.baidu.android.pushservice.j.f fVar) {
        this.d = fVar;
    }

    @Override // com.baidu.android.pushservice.h.m
    void a(String str) {
        JSONObject jSONObject;
        com.baidu.android.pushservice.j.g.a(this.a, System.currentTimeMillis());
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject = jSONObject2.has("lbsInfo") ? jSONObject2.optJSONObject("lbsInfo") : null;
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            String a = com.baidu.android.pushservice.j.g.a(this.a, jSONObject);
            if (this.d == null || TextUtils.isEmpty(a)) {
                return;
            }
            this.d.a(0, a);
            this.d = null;
        }
    }

    @Override // com.baidu.android.pushservice.h.m
    void a(String str, HashMap<String, String> hashMap) {
        hashMap.put("method", "uploadGeo");
        hashMap.put("data", str);
    }

    @Override // com.baidu.android.pushservice.h.m
    boolean a() {
        return true;
    }

    @Override // com.baidu.android.pushservice.h.m
    boolean b() {
        return true;
    }
}
