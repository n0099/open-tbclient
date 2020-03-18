package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int cQb = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cQd = 0;
    private int has_more = 0;
    private int cQe = 0;
    private int total_count = 0;
    private int cQc = 0;

    public int aBi() {
        return this.cQb;
    }

    public void jz(int i) {
        this.cQb = i;
    }

    public int aAq() {
        return this.total_num;
    }

    public void jA(int i) {
        this.total_num = i;
    }

    public int aBj() {
        return this.total_count;
    }

    public int aBk() {
        return this.cQc;
    }

    public void jB(int i) {
        this.cQc = i;
    }

    public int aBl() {
        return this.current_page;
    }

    public void jC(int i) {
        this.current_page = i;
    }

    public int aBm() {
        return this.cQd;
    }

    public void jD(int i) {
        this.cQd = i;
    }

    public void jE(int i) {
        this.has_more = i;
    }

    public int aBn() {
        return this.has_more;
    }

    public void jF(int i) {
        this.cQe = i;
    }

    public int aBo() {
        return this.cQe;
    }

    public void a(Page page) {
        if (page != null) {
            this.cQb = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.cQd = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.cQe = page.has_prev.intValue();
            this.cQc = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQb = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cQd = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cQe = jSONObject.optInt("has_prev", 0);
                this.cQc = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
