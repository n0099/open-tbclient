package com.baidu.swan.apps.af;

import android.support.annotation.Nullable;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public List<C0333a> cJZ;
    public String cKa;

    @Nullable
    public static a be(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.cKa = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0333a c0333a = new C0333a();
                c0333a.appKey = optJSONObject.optString("app_key");
                c0333a.appName = optJSONObject.optString("app_name");
                c0333a.iconUrl = optJSONObject.optString("photo_addr");
                c0333a.cKb = optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                arrayList.add(c0333a);
            }
        }
        aVar.cJZ = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.af.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0333a {
        public String appKey;
        public String appName;
        public String cKb;
        public String iconUrl;

        C0333a() {
        }
    }
}
