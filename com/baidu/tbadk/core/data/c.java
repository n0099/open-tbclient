package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private ArrayList<b> a = new ArrayList<>();

    public final ArrayList<b> a() {
        return this.a;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("app");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        b bVar = new b();
                        bVar.a(optJSONArray.optJSONObject(i));
                        this.a.add(bVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
