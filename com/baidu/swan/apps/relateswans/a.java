package com.baidu.swan.apps.relateswans;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public List<C0447a> dur;
    public String dus;

    @Nullable
    public static a by(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dus = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0447a c0447a = new C0447a();
                c0447a.appKey = optJSONObject.optString("app_key");
                c0447a.appName = optJSONObject.optString("app_name");
                c0447a.iconUrl = optJSONObject.optString("photo_addr");
                c0447a.dut = optJSONObject.optString("scheme");
                arrayList.add(c0447a);
            }
        }
        aVar.dur = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.relateswans.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0447a {
        public String appKey;
        public String appName;
        public String dut;
        public String iconUrl;

        C0447a() {
        }
    }
}
