package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ad {
    private int OP = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int OR = 0;
    private int has_more = 0;
    private int OS = 0;
    private int total_count = 0;
    private int OQ = 0;

    public int pF() {
        return this.OP;
    }

    public void bx(int i) {
        this.OP = i;
    }

    public int ou() {
        return this.total_num;
    }

    public void by(int i) {
        this.total_num = i;
    }

    public int pG() {
        return this.total_count;
    }

    public int pH() {
        return this.OQ;
    }

    public void bz(int i) {
        this.OQ = i;
    }

    public int pI() {
        return this.current_page;
    }

    public void bA(int i) {
        this.current_page = i;
    }

    public int pJ() {
        return this.OR;
    }

    public void bB(int i) {
        this.OR = i;
    }

    public void bC(int i) {
        this.has_more = i;
    }

    public int pK() {
        return this.has_more;
    }

    public void bD(int i) {
        this.OS = i;
    }

    public int pL() {
        return this.OS;
    }

    public void a(Page page) {
        if (page != null) {
            this.OP = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.OR = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.OS = page.has_prev.intValue();
            this.OQ = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.OP = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.OR = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.OS = jSONObject.optInt("has_prev", 0);
                this.OQ = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
