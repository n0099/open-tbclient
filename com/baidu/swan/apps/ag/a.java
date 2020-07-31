package com.baidu.swan.apps.ag;

import android.support.annotation.Nullable;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public List<C0291a> cBL;
    public String cBM;

    @Nullable
    public static a aX(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.cBM = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                C0291a c0291a = new C0291a();
                c0291a.appKey = optJSONObject.optString("app_key");
                c0291a.appName = optJSONObject.optString("app_name");
                c0291a.iconUrl = optJSONObject.optString("photo_addr");
                c0291a.cBN = optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                arrayList.add(c0291a);
            }
        }
        aVar.cBL = arrayList;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.ag.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0291a {
        public String appKey;
        public String appName;
        public String cBN;
        public String iconUrl;

        C0291a() {
        }
    }
}
