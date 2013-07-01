package com.baidu.android.defense.push;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends i {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList f241a;

    public a(String str, Context context) {
        super(str, context);
        this.f241a = new ArrayList();
        a();
    }

    public void a() {
        if (this.b != null) {
            try {
                JSONArray jSONArray = this.b.getJSONArray("params");
                if (jSONArray == null || jSONArray.length() == 0) {
                    this.c = false;
                    return;
                }
                int length = jSONArray.length();
                new JSONObject();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        com.baidu.android.defense.b.c cVar = new com.baidu.android.defense.b.c();
                        cVar.a(jSONObject.getString("packagename"));
                        cVar.a(jSONObject.getInt("versioncode"));
                        this.f241a.add(cVar);
                    }
                }
            } catch (JSONException e) {
                this.c = false;
            }
        }
    }

    @Override // com.baidu.android.defense.push.i
    public boolean b() {
        return false;
    }
}
