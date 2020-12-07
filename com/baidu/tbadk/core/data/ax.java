package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ax {
    private int eHj = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eHl = 0;
    private int has_more = 0;
    private int eHm = 0;
    private int total_count = 0;
    private int eHk = 0;

    public int bnA() {
        return this.eHj;
    }

    public void or(int i) {
        this.eHj = i;
    }

    public int bmB() {
        return this.total_num;
    }

    public void os(int i) {
        this.total_num = i;
    }

    public int bnB() {
        return this.total_count;
    }

    public int bnC() {
        return this.eHk;
    }

    public void ot(int i) {
        this.eHk = i;
    }

    public int bnD() {
        return this.current_page;
    }

    public void ou(int i) {
        this.current_page = i;
    }

    public int bnE() {
        return this.eHl;
    }

    public void ov(int i) {
        this.eHl = i;
    }

    public void ow(int i) {
        this.has_more = i;
    }

    public int bnF() {
        return this.has_more;
    }

    public void ox(int i) {
        this.eHm = i;
    }

    public int bnG() {
        return this.eHm;
    }

    public void a(Page page) {
        if (page != null) {
            this.eHj = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eHl = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eHm = page.has_prev.intValue();
            this.eHk = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHj = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eHl = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eHm = jSONObject.optInt("has_prev", 0);
                this.eHk = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
