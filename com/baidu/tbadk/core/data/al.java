package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int asi = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int ask = 0;
    private int has_more = 0;
    private int asl = 0;
    private int total_count = 0;
    private int asj = 0;

    public int yK() {
        return this.asi;
    }

    public void cF(int i) {
        this.asi = i;
    }

    public int ya() {
        return this.total_num;
    }

    public void cG(int i) {
        this.total_num = i;
    }

    public int yL() {
        return this.total_count;
    }

    public int yM() {
        return this.asj;
    }

    public void cH(int i) {
        this.asj = i;
    }

    public int yN() {
        return this.current_page;
    }

    public void cI(int i) {
        this.current_page = i;
    }

    public int yO() {
        return this.ask;
    }

    public void cJ(int i) {
        this.ask = i;
    }

    public void cK(int i) {
        this.has_more = i;
    }

    public int yP() {
        return this.has_more;
    }

    public void cL(int i) {
        this.asl = i;
    }

    public int yQ() {
        return this.asl;
    }

    public void a(Page page) {
        if (page != null) {
            this.asi = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.ask = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.asl = page.has_prev.intValue();
            this.asj = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asi = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.ask = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.asl = jSONObject.optInt("has_prev", 0);
                this.asj = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
