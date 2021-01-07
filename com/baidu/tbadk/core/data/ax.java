package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ax {
    private int eRa = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eRc = 0;
    private int has_more = 0;
    private int eRd = 0;
    private int total_count = 0;
    private int eRb = 0;

    public int bqb() {
        return this.eRa;
    }

    public void oB(int i) {
        this.eRa = i;
    }

    public int bpd() {
        return this.total_num;
    }

    public void oC(int i) {
        this.total_num = i;
    }

    public int bqc() {
        return this.total_count;
    }

    public int bqd() {
        return this.eRb;
    }

    public void oD(int i) {
        this.eRb = i;
    }

    public int bqe() {
        return this.current_page;
    }

    public void oE(int i) {
        this.current_page = i;
    }

    public int bqf() {
        return this.eRc;
    }

    public void oF(int i) {
        this.eRc = i;
    }

    public void oG(int i) {
        this.has_more = i;
    }

    public int bqg() {
        return this.has_more;
    }

    public void oH(int i) {
        this.eRd = i;
    }

    public int bqh() {
        return this.eRd;
    }

    public void a(Page page) {
        if (page != null) {
            this.eRa = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eRc = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eRd = page.has_prev.intValue();
            this.eRb = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eRa = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eRc = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eRd = jSONObject.optInt("has_prev", 0);
                this.eRb = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
