package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public List<C0359a> dgH;
    public String dgI;

    @Nullable
    public static a br(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.dgI = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0359a c0359a = new C0359a();
                c0359a.appKey = optJSONObject.optString("app_key");
                c0359a.appName = optJSONObject.optString("app_name");
                c0359a.iconUrl = optJSONObject.optString("photo_addr");
                c0359a.dgJ = optJSONObject.optString("scheme");
                arrayList.add(c0359a);
            }
        }
        aVar.dgH = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0359a {
        public String appKey;
        public String appName;
        public String dgJ;
        public String iconUrl;

        C0359a() {
        }
    }
}
