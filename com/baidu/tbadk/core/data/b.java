package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import org.json.JSONObject;
import tbclient.FrsPage.App;
/* loaded from: classes.dex */
public class b extends o {
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public int a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.j;
    }

    public void a(int i) {
        this.k = i;
    }

    public int g() {
        return this.k;
    }

    @Override // com.baidu.tbadk.core.data.o
    public void a(JSONObject jSONObject) {
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
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.o, com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }

    public void a(App app) {
        if (app != null) {
            this.c = app.type.intValue();
            this.d = app.pos.intValue();
            this.e = app.icon_url;
            this.f = app.icon_link;
            this.g = app.app_name;
            this.h = app.app_desc;
            this.i = app.p_name;
            this.j = app.p_url;
        }
    }
}
