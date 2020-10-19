package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public List<C0345a> cYg;
    public String cYh;

    @Nullable
    public static a bo(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.cYh = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0345a c0345a = new C0345a();
                c0345a.appKey = optJSONObject.optString("app_key");
                c0345a.appName = optJSONObject.optString("app_name");
                c0345a.iconUrl = optJSONObject.optString("photo_addr");
                c0345a.cYi = optJSONObject.optString("scheme");
                arrayList.add(c0345a);
            }
        }
        aVar.cYg = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0345a {
        public String appKey;
        public String appName;
        public String cYi;
        public String iconUrl;

        C0345a() {
        }
    }
}
