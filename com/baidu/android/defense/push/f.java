package com.baidu.android.defense.push;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends a {
    protected ArrayList d;

    public f(String str, Context context) {
        super(str, context);
        this.d = new ArrayList();
        b();
    }

    @Override // com.baidu.android.defense.push.a
    public boolean a() {
        return false;
    }

    public void b() {
        if (this.f505a != null) {
            try {
                JSONArray jSONArray = this.f505a.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.b = false;
                    return;
                }
                int length = jSONArray.length();
                new JSONObject();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        com.baidu.android.defense.b.a aVar = new com.baidu.android.defense.b.a();
                        aVar.a(jSONObject.getString("packagename"));
                        aVar.a(jSONObject.getInt("versioncode"));
                        this.d.add(aVar);
                    }
                }
            } catch (JSONException e) {
                this.b = false;
            }
        }
    }
}
