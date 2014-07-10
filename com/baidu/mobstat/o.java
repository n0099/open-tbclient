package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    private long b = 0;
    private long c = 0;
    private int d = 0;
    List<p> a = new ArrayList();

    public o() {
        a(System.currentTimeMillis());
    }

    public long a() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str, long j, long j2) {
        this.a.add(new p(this, str, j, j2));
    }

    public void b() {
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
        this.a.clear();
        a(System.currentTimeMillis());
    }

    public void b(long j) {
        this.c = j;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.b);
            jSONObject.put("e", this.c);
            jSONObject.put("i", System.currentTimeMillis());
            jSONObject.put("c", this.d);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.a.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("n", this.a.get(i).a());
                jSONObject2.put("d", this.a.get(i).b());
                long c = this.a.get(i).c() - this.b;
                if (c < 0) {
                    c = 0;
                }
                jSONObject2.put("ps", c);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", "StatSession.constructJSONObject() failed");
        }
        return jSONObject;
    }

    public int d() {
        return this.d;
    }
}
