package com.baidu.android.defense.push;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends i {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList f510a;

    public g(String str, Context context) {
        super(str, context);
        this.f510a = null;
        this.f510a = new ArrayList();
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
                        com.baidu.android.defense.a.c cVar = new com.baidu.android.defense.a.c();
                        cVar.f497a = jSONObject.getString("downurl");
                        cVar.b = jSONObject.getString("savepath");
                        cVar.c = jSONObject.getInt("filesize");
                        this.f510a.add(cVar);
                    }
                }
            } catch (JSONException e) {
                this.c = false;
            }
        }
    }

    @Override // com.baidu.android.defense.push.i
    public boolean b() {
        if (this.c) {
            Iterator it = this.f510a.iterator();
            while (it.hasNext()) {
                com.baidu.android.defense.a.b.a().a(new com.baidu.android.defense.a.a(this.d, (com.baidu.android.defense.a.c) it.next()));
            }
            return true;
        }
        return false;
    }
}
