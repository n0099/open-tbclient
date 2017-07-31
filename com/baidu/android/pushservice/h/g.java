package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends l {
    private static g e = null;
    private String c;
    private com.baidu.android.pushservice.j.g d;

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

    @Override // com.baidu.android.pushservice.h.l
    String a(boolean z) {
        return com.baidu.android.pushservice.j.h.a(this.a, z);
    }

    public void a(com.baidu.android.pushservice.j.g gVar) {
        this.d = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    @Override // com.baidu.android.pushservice.h.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.baidu.android.pushservice.j.h.a(this.a, System.currentTimeMillis());
        com.baidu.android.pushservice.g.a.b(this.c, "<<< Location info send result return OK!");
        com.baidu.android.pushservice.g.a.c(this.c, "Lbs upload respponse: " + str);
        try {
            jSONObject2 = new JSONObject(str);
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.e(this.c, " e " + e2.getMessage());
        }
        if (jSONObject2.has("lbsInfo")) {
            jSONObject = jSONObject2.optJSONObject("lbsInfo");
            if (jSONObject == null) {
                String a = com.baidu.android.pushservice.j.h.a(this.a, jSONObject);
                if (this.d == null || TextUtils.isEmpty(a)) {
                    return;
                }
                this.d.a(0, a);
                this.d = null;
                return;
            }
            return;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    @Override // com.baidu.android.pushservice.h.l
    void a(String str, HashMap<String, String> hashMap) {
        hashMap.put(PushConstants.EXTRA_METHOD, "uploadGeo");
        com.baidu.android.pushservice.g.a.c(this.c, "Sending LBS data: " + str);
        hashMap.put("data", str);
    }

    @Override // com.baidu.android.pushservice.h.l
    boolean a() {
        return true;
    }

    @Override // com.baidu.android.pushservice.h.l
    boolean b() {
        return true;
    }
}
