package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public List<C0328a> cMd;
    public String cMe;

    @Nullable
    public static a bh(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.cMe = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0328a c0328a = new C0328a();
                c0328a.appKey = optJSONObject.optString("app_key");
                c0328a.appName = optJSONObject.optString("app_name");
                c0328a.iconUrl = optJSONObject.optString("photo_addr");
                c0328a.cMf = optJSONObject.optString("scheme");
                arrayList.add(c0328a);
            }
        }
        aVar.cMd = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0328a {
        public String appKey;
        public String appName;
        public String cMf;
        public String iconUrl;

        C0328a() {
        }
    }
}
