package com.baidu.android.pushservice.c;

import android.text.TextUtils;
import com.tencent.tauth.AuthActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private String a;
    private String b;
    private String c;
    private final List<String> d = new ArrayList();
    private final List<String> e = new ArrayList();
    private final List<String> f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("tar");
            this.b = jSONObject.optString("stat");
            this.c = jSONObject.optString("compo");
            JSONArray optJSONArray = jSONObject.optJSONArray("filter");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString(AuthActivity.ACTION_KEY);
                    if (TextUtils.isEmpty(optString)) {
                        String optString2 = jSONObject2.optString("category");
                        if (TextUtils.isEmpty(optString2)) {
                            String optString3 = jSONObject2.optString("data");
                            if (!TextUtils.isEmpty(optString3)) {
                                this.f.add(optString3);
                            }
                        } else {
                            this.e.add(optString2);
                        }
                    } else {
                        this.d.add(optString);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public List<String> c() {
        return this.d;
    }

    public List<String> d() {
        return this.e;
    }

    public List<String> e() {
        return this.f;
    }
}
