package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class av {
    private int ewa = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int ewc = 0;
    private int has_more = 0;
    private int ewd = 0;
    private int total_count = 0;
    private int ewb = 0;

    public int biL() {
        return this.ewa;
    }

    public void nN(int i) {
        this.ewa = i;
    }

    public int bhP() {
        return this.total_num;
    }

    public void nO(int i) {
        this.total_num = i;
    }

    public int biM() {
        return this.total_count;
    }

    public int biN() {
        return this.ewb;
    }

    public void nP(int i) {
        this.ewb = i;
    }

    public int biO() {
        return this.current_page;
    }

    public void nQ(int i) {
        this.current_page = i;
    }

    public int biP() {
        return this.ewc;
    }

    public void nR(int i) {
        this.ewc = i;
    }

    public void nS(int i) {
        this.has_more = i;
    }

    public int biQ() {
        return this.has_more;
    }

    public void nT(int i) {
        this.ewd = i;
    }

    public int biR() {
        return this.ewd;
    }

    public void a(Page page) {
        if (page != null) {
            this.ewa = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.ewc = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.ewd = page.has_prev.intValue();
            this.ewb = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ewa = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.ewc = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.ewd = jSONObject.optInt("has_prev", 0);
                this.ewb = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
