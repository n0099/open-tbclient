package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class az {
    private int eQc = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eQe = 0;
    private int has_more = 0;
    private int eQf = 0;
    private int total_count = 0;
    private int eQd = 0;

    public int bmC() {
        return this.eQc;
    }

    public void mZ(int i) {
        this.eQc = i;
    }

    public int blD() {
        return this.total_num;
    }

    public void na(int i) {
        this.total_num = i;
    }

    public int bmD() {
        return this.total_count;
    }

    public int bmE() {
        return this.eQd;
    }

    public void nb(int i) {
        this.eQd = i;
    }

    public int bmF() {
        return this.current_page;
    }

    public void nc(int i) {
        this.current_page = i;
    }

    public int bmG() {
        return this.eQe;
    }

    public void nd(int i) {
        this.eQe = i;
    }

    public void ne(int i) {
        this.has_more = i;
    }

    public int bmH() {
        return this.has_more;
    }

    public void nf(int i) {
        this.eQf = i;
    }

    public int bmI() {
        return this.eQf;
    }

    public void a(Page page) {
        if (page != null) {
            this.eQc = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eQe = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eQf = page.has_prev.intValue();
            this.eQd = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eQc = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eQe = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eQf = jSONObject.optInt("has_prev", 0);
                this.eQd = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
