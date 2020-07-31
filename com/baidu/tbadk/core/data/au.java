package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class au {
    private int dPR = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dPT = 0;
    private int has_more = 0;
    private int dPU = 0;
    private int total_count = 0;
    private int dPS = 0;

    public int aUW() {
        return this.dPR;
    }

    public void kO(int i) {
        this.dPR = i;
    }

    public int aUc() {
        return this.total_num;
    }

    public void kP(int i) {
        this.total_num = i;
    }

    public int aUX() {
        return this.total_count;
    }

    public int aUY() {
        return this.dPS;
    }

    public void kQ(int i) {
        this.dPS = i;
    }

    public int aUZ() {
        return this.current_page;
    }

    public void kR(int i) {
        this.current_page = i;
    }

    public int aVa() {
        return this.dPT;
    }

    public void kS(int i) {
        this.dPT = i;
    }

    public void kT(int i) {
        this.has_more = i;
    }

    public int aVb() {
        return this.has_more;
    }

    public void kU(int i) {
        this.dPU = i;
    }

    public int aVc() {
        return this.dPU;
    }

    public void a(Page page) {
        if (page != null) {
            this.dPR = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dPT = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dPU = page.has_prev.intValue();
            this.dPS = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dPR = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dPT = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dPU = jSONObject.optInt("has_prev", 0);
                this.dPS = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
