package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bHS = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bHU = 0;
    private int has_more = 0;
    private int bHV = 0;
    private int total_count = 0;
    private int bHT = 0;

    public int adn() {
        return this.bHS;
    }

    public void gX(int i) {
        this.bHS = i;
    }

    public int acF() {
        return this.total_num;
    }

    public void gY(int i) {
        this.total_num = i;
    }

    public int ado() {
        return this.total_count;
    }

    public int adp() {
        return this.bHT;
    }

    public void gZ(int i) {
        this.bHT = i;
    }

    public int adq() {
        return this.current_page;
    }

    public void ha(int i) {
        this.current_page = i;
    }

    public int adr() {
        return this.bHU;
    }

    public void hb(int i) {
        this.bHU = i;
    }

    public void hc(int i) {
        this.has_more = i;
    }

    public int ads() {
        return this.has_more;
    }

    public void hd(int i) {
        this.bHV = i;
    }

    public int adt() {
        return this.bHV;
    }

    public void a(Page page) {
        if (page != null) {
            this.bHS = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bHU = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bHV = page.has_prev.intValue();
            this.bHT = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bHS = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bHU = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bHV = jSONObject.optInt("has_prev", 0);
                this.bHT = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
