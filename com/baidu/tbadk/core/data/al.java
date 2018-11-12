package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aoH = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aoJ = 0;
    private int has_more = 0;
    private int aoK = 0;
    private int total_count = 0;
    private int aoI = 0;

    public int xG() {
        return this.aoH;
    }

    public void cr(int i) {
        this.aoH = i;
    }

    public int wW() {
        return this.total_num;
    }

    public void cs(int i) {
        this.total_num = i;
    }

    public int xH() {
        return this.total_count;
    }

    public int xI() {
        return this.aoI;
    }

    public void ct(int i) {
        this.aoI = i;
    }

    public int xJ() {
        return this.current_page;
    }

    public void cu(int i) {
        this.current_page = i;
    }

    public int xK() {
        return this.aoJ;
    }

    public void cv(int i) {
        this.aoJ = i;
    }

    public void cw(int i) {
        this.has_more = i;
    }

    public int xL() {
        return this.has_more;
    }

    public void cx(int i) {
        this.aoK = i;
    }

    public int xM() {
        return this.aoK;
    }

    public void a(Page page) {
        if (page != null) {
            this.aoH = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aoJ = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aoK = page.has_prev.intValue();
            this.aoI = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aoH = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aoJ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aoK = jSONObject.optInt("has_prev", 0);
                this.aoI = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
