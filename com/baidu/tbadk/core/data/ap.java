package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int cLJ = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cLL = 0;
    private int has_more = 0;
    private int cLM = 0;
    private int total_count = 0;
    private int cLK = 0;

    public int ayM() {
        return this.cLJ;
    }

    public void jh(int i) {
        this.cLJ = i;
    }

    public int axX() {
        return this.total_num;
    }

    public void ji(int i) {
        this.total_num = i;
    }

    public int ayN() {
        return this.total_count;
    }

    public int ayO() {
        return this.cLK;
    }

    public void jj(int i) {
        this.cLK = i;
    }

    public int ayP() {
        return this.current_page;
    }

    public void jk(int i) {
        this.current_page = i;
    }

    public int ayQ() {
        return this.cLL;
    }

    public void jl(int i) {
        this.cLL = i;
    }

    public void jm(int i) {
        this.has_more = i;
    }

    public int ayR() {
        return this.has_more;
    }

    public void jn(int i) {
        this.cLM = i;
    }

    public int ayS() {
        return this.cLM;
    }

    public void a(Page page) {
        if (page != null) {
            this.cLJ = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.cLL = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.cLM = page.has_prev.intValue();
            this.cLK = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cLJ = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cLL = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cLM = jSONObject.optInt("has_prev", 0);
                this.cLK = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
