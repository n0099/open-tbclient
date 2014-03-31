package com.baidu.tbadk.core.data;

import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends o {
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public final int a() {
        return this.d;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.h;
    }

    public final String e() {
        return this.i;
    }

    public final String f() {
        return this.j;
    }

    public final void a(int i) {
        this.k = i;
    }

    public final int g() {
        return this.k;
    }

    @Override // com.baidu.tbadk.core.data.o
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt("type", 0);
                this.d = jSONObject.optInt("pos", 1);
                this.e = jSONObject.optString("icon_url", "");
                this.f = jSONObject.optString("icon_link", "");
                this.g = jSONObject.optString("app_name", "");
                this.h = jSONObject.optString("app_desc", "");
                this.i = jSONObject.optString("p_name", "");
                this.j = jSONObject.optString("p_url", "");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.o, com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }
}
