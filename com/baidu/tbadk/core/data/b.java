package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import org.json.JSONObject;
import tbclient.FrsPage.App;
/* loaded from: classes.dex */
public class b extends n {
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private String l;
    private String m;
    private long n;

    public String a() {
        return this.l;
    }

    public String b() {
        return this.m;
    }

    public long c() {
        return this.n;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public void a(int i) {
        this.k = i;
    }

    public int k() {
        return this.k;
    }

    @Override // com.baidu.tbadk.core.data.n
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

    @Override // com.baidu.tbadk.core.data.n, com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
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
            this.l = app.web_url;
            this.m = app.img_url;
            this.n = app.app_time.intValue();
        }
    }
}
