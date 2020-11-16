package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public List<C0369a> dkV;
    public String dkW;

    @Nullable
    public static a br(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dkW = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0369a c0369a = new C0369a();
                c0369a.appKey = optJSONObject.optString("app_key");
                c0369a.appName = optJSONObject.optString("app_name");
                c0369a.iconUrl = optJSONObject.optString("photo_addr");
                c0369a.dkX = optJSONObject.optString("scheme");
                arrayList.add(c0369a);
            }
        }
        aVar.dkV = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0369a {
        public String appKey;
        public String appName;
        public String dkX;
        public String iconUrl;

        C0369a() {
        }
    }
}
