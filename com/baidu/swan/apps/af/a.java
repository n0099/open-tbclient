package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    public List<C0381a> drV;
    public String drW;

    @Nullable
    public static a bt(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.drW = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0381a c0381a = new C0381a();
                c0381a.appKey = optJSONObject.optString("app_key");
                c0381a.appName = optJSONObject.optString("app_name");
                c0381a.iconUrl = optJSONObject.optString("photo_addr");
                c0381a.drX = optJSONObject.optString("scheme");
                arrayList.add(c0381a);
            }
        }
        aVar.drV = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0381a {
        public String appKey;
        public String appName;
        public String drX;
        public String iconUrl;

        C0381a() {
        }
    }
}
