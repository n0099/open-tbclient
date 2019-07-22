package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bHR = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bHT = 0;
    private int has_more = 0;
    private int bHU = 0;
    private int total_count = 0;
    private int bHS = 0;

    public int adm() {
        return this.bHR;
    }

    public void gX(int i) {
        this.bHR = i;
    }

    public int acE() {
        return this.total_num;
    }

    public void gY(int i) {
        this.total_num = i;
    }

    public int adn() {
        return this.total_count;
    }

    public int ado() {
        return this.bHS;
    }

    public void gZ(int i) {
        this.bHS = i;
    }

    public int adp() {
        return this.current_page;
    }

    public void ha(int i) {
        this.current_page = i;
    }

    public int adq() {
        return this.bHT;
    }

    public void hb(int i) {
        this.bHT = i;
    }

    public void hc(int i) {
        this.has_more = i;
    }

    public int adr() {
        return this.has_more;
    }

    public void hd(int i) {
        this.bHU = i;
    }

    public int ads() {
        return this.bHU;
    }

    public void a(Page page) {
        if (page != null) {
            this.bHR = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bHT = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bHU = page.has_prev.intValue();
            this.bHS = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bHR = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bHT = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bHU = jSONObject.optInt("has_prev", 0);
                this.bHS = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
