package com.baidu.swan.apps.relateswans;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public List<C0450a> dsf;
    public String dsg;

    @Nullable
    public static a bB(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dsg = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0450a c0450a = new C0450a();
                c0450a.appKey = optJSONObject.optString("app_key");
                c0450a.appName = optJSONObject.optString("app_name");
                c0450a.iconUrl = optJSONObject.optString("photo_addr");
                c0450a.dsh = optJSONObject.optString("scheme");
                arrayList.add(c0450a);
            }
        }
        aVar.dsf = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.relateswans.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0450a {
        public String appKey;
        public String appName;
        public String dsh;
        public String iconUrl;

        C0450a() {
        }
    }
}
