package com.baidu.android.defense.push;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends a {
    protected ArrayList d;

    public h(String str, Context context) {
        super(str, context);
        this.d = null;
        this.d = new ArrayList();
        b();
    }

    @Override // com.baidu.android.defense.push.a
    public boolean a() {
        if (this.b) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                com.baidu.android.defense.a.c.a().a(new com.baidu.android.defense.a.d(this.c, (com.baidu.android.defense.a.b) it.next()));
            }
            return true;
        }
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
                        com.baidu.android.defense.a.b bVar = new com.baidu.android.defense.a.b();
                        bVar.f495a = jSONObject.getString("downurl");
                        bVar.b = jSONObject.getString("savepath");
                        bVar.c = jSONObject.getInt("filesize");
                        this.d.add(bVar);
                    }
                }
            } catch (JSONException e) {
                this.b = false;
            }
        }
    }
}
