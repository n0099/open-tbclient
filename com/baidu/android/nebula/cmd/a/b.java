package com.baidu.android.nebula.cmd.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public String a;
    public String b;
    public List c;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return null;
        }
        bVar.a = jSONObject.optString("name");
        bVar.b = jSONObject.optString("starred");
        if (jSONObject.has("fields")) {
            bVar.c = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("fields");
            for (int i = 0; i < jSONArray.length(); i++) {
                a aVar = new a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                aVar.a = jSONObject2.optString("type");
                aVar.b = jSONObject2.optString("type_code");
                aVar.c = jSONObject2.optString("type_ext");
                aVar.d = jSONObject2.optString("value");
                bVar.c.add(aVar);
            }
        }
        return bVar;
    }

    public String toString() {
        return "ContactUser [mName=" + this.a + ", mFields=" + this.c + "]";
    }
}
