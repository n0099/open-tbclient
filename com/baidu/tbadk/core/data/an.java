package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bGR = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bGT = 0;
    private int has_more = 0;
    private int bGU = 0;
    private int total_count = 0;
    private int bGS = 0;

    public int ack() {
        return this.bGR;
    }

    public void gS(int i) {
        this.bGR = i;
    }

    public int abC() {
        return this.total_num;
    }

    public void gT(int i) {
        this.total_num = i;
    }

    public int acl() {
        return this.total_count;
    }

    public int acm() {
        return this.bGS;
    }

    public void gU(int i) {
        this.bGS = i;
    }

    public int acn() {
        return this.current_page;
    }

    public void gV(int i) {
        this.current_page = i;
    }

    public int aco() {
        return this.bGT;
    }

    public void gW(int i) {
        this.bGT = i;
    }

    public void gX(int i) {
        this.has_more = i;
    }

    public int acp() {
        return this.has_more;
    }

    public void gY(int i) {
        this.bGU = i;
    }

    public int acq() {
        return this.bGU;
    }

    public void a(Page page) {
        if (page != null) {
            this.bGR = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bGT = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bGU = page.has_prev.intValue();
            this.bGS = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bGR = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bGT = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bGU = jSONObject.optInt("has_prev", 0);
                this.bGS = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
