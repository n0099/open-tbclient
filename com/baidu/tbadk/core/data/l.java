package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class l {
    private int a = 0;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int c = 0;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public void e(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }

    public void f(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public void a(Page page) {
        if (page != null) {
            this.a = page.total_page.intValue();
            this.b = page.total_num.intValue();
            this.c = page.total_count.intValue();
            this.d = page.current_page.intValue();
            this.e = page.page_size.intValue();
            this.f = page.has_more.intValue();
            this.g = page.has_prev.intValue();
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("total_page", 0);
                this.b = jSONObject.optInt("total_num", 0);
                this.c = jSONObject.optInt("total_count", 0);
                this.d = jSONObject.optInt("current_page", 0);
                this.e = jSONObject.optInt("page_size", 0);
                this.f = jSONObject.optInt("has_more", 0);
                this.g = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
