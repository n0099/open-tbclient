package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class at {
    private int dJF = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dJH = 0;
    private int has_more = 0;
    private int dJI = 0;
    private int total_count = 0;
    private int dJG = 0;

    public int aRa() {
        return this.dJF;
    }

    public void ku(int i) {
        this.dJF = i;
    }

    public int aQg() {
        return this.total_num;
    }

    public void kv(int i) {
        this.total_num = i;
    }

    public int aRb() {
        return this.total_count;
    }

    public int aRc() {
        return this.dJG;
    }

    public void kw(int i) {
        this.dJG = i;
    }

    public int aRd() {
        return this.current_page;
    }

    public void kx(int i) {
        this.current_page = i;
    }

    public int aRe() {
        return this.dJH;
    }

    public void ky(int i) {
        this.dJH = i;
    }

    public void kz(int i) {
        this.has_more = i;
    }

    public int aRf() {
        return this.has_more;
    }

    public void kA(int i) {
        this.dJI = i;
    }

    public int aRg() {
        return this.dJI;
    }

    public void a(Page page) {
        if (page != null) {
            this.dJF = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dJH = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dJI = page.has_prev.intValue();
            this.dJG = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dJF = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dJH = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dJI = jSONObject.optInt("has_prev", 0);
                this.dJG = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
