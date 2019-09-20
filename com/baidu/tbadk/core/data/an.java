package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bIq = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bIs = 0;
    private int has_more = 0;
    private int bIt = 0;
    private int total_count = 0;
    private int bIr = 0;

    public int adr() {
        return this.bIq;
    }

    public void gY(int i) {
        this.bIq = i;
    }

    public int acJ() {
        return this.total_num;
    }

    public void gZ(int i) {
        this.total_num = i;
    }

    public int ads() {
        return this.total_count;
    }

    public int adt() {
        return this.bIr;
    }

    public void ha(int i) {
        this.bIr = i;
    }

    public int adu() {
        return this.current_page;
    }

    public void hb(int i) {
        this.current_page = i;
    }

    public int adv() {
        return this.bIs;
    }

    public void hc(int i) {
        this.bIs = i;
    }

    public void hd(int i) {
        this.has_more = i;
    }

    public int adw() {
        return this.has_more;
    }

    public void he(int i) {
        this.bIt = i;
    }

    public int adx() {
        return this.bIt;
    }

    public void a(Page page) {
        if (page != null) {
            this.bIq = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bIs = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bIt = page.has_prev.intValue();
            this.bIr = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bIq = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bIs = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bIt = jSONObject.optInt("has_prev", 0);
                this.bIr = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
