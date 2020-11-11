package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public List<C0371a> dmC;
    public String dmD;

    @Nullable
    public static a bx(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dmD = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0371a c0371a = new C0371a();
                c0371a.appKey = optJSONObject.optString("app_key");
                c0371a.appName = optJSONObject.optString("app_name");
                c0371a.iconUrl = optJSONObject.optString("photo_addr");
                c0371a.dmE = optJSONObject.optString("scheme");
                arrayList.add(c0371a);
            }
        }
        aVar.dmC = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0371a {
        public String appKey;
        public String appName;
        public String dmE;
        public String iconUrl;

        C0371a() {
        }
    }
}
