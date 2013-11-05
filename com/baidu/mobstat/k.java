package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    private long b = 0;
    private long c = 0;
    private int d = 0;

    /* renamed from: a  reason: collision with root package name */
    List<l> f950a = new ArrayList();

    public k() {
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

    public void a(String str, long j) {
        this.f950a.add(new l(this, str, j));
    }

    public void b() {
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
        this.f950a.clear();
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
            for (int i = 0; i < this.f950a.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("n", this.f950a.get(i).a());
                jSONObject2.put("d", this.f950a.get(i).b());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", "StatSession.constructJSONObject() failed");
        }
        return jSONObject;
    }

    public int d() {
        return this.d;
    }
}
