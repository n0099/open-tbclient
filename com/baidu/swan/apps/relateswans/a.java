package com.baidu.swan.apps.relateswans;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public List<C0453a> dvS;
    public String dvT;

    @Nullable
    public static a bA(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dvT = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0453a c0453a = new C0453a();
                c0453a.appKey = optJSONObject.optString("app_key");
                c0453a.appName = optJSONObject.optString("app_name");
                c0453a.iconUrl = optJSONObject.optString("photo_addr");
                c0453a.dvU = optJSONObject.optString("scheme");
                arrayList.add(c0453a);
            }
        }
        aVar.dvS = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.relateswans.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0453a {
        public String appKey;
        public String appName;
        public String dvU;
        public String iconUrl;

        C0453a() {
        }
    }
}
