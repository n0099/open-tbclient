package com.baidu.swan.apps.relateswans;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public List<C0467a> dwT;
    public String dwU;

    @Nullable
    public static a bB(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dwU = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0467a c0467a = new C0467a();
                c0467a.appKey = optJSONObject.optString("app_key");
                c0467a.appName = optJSONObject.optString("app_name");
                c0467a.iconUrl = optJSONObject.optString("photo_addr");
                c0467a.dwV = optJSONObject.optString("scheme");
                arrayList.add(c0467a);
            }
        }
        aVar.dwT = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.relateswans.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0467a {
        public String appKey;
        public String appName;
        public String dwV;
        public String iconUrl;

        C0467a() {
        }
    }
}
