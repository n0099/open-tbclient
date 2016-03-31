package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ac {
    private int TY = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Ua = 0;
    private int has_more = 0;
    private int Ub = 0;
    private int total_count = 0;
    private int TZ = 0;

    public int sl() {
        return this.TY;
    }

    public void bM(int i) {
        this.TY = i;
    }

    public int qX() {
        return this.total_num;
    }

    public void bN(int i) {
        this.total_num = i;
    }

    public int sm() {
        return this.total_count;
    }

    public int sn() {
        return this.TZ;
    }

    public void bO(int i) {
        this.TZ = i;
    }

    public int so() {
        return this.current_page;
    }

    public void bP(int i) {
        this.current_page = i;
    }

    public int sp() {
        return this.Ua;
    }

    public void bQ(int i) {
        this.Ua = i;
    }

    public void bR(int i) {
        this.has_more = i;
    }

    public int sq() {
        return this.has_more;
    }

    public void bS(int i) {
        this.Ub = i;
    }

    public int sr() {
        return this.Ub;
    }

    public void a(Page page) {
        if (page != null) {
            this.TY = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Ua = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Ub = page.has_prev.intValue();
            this.TZ = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TY = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Ua = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Ub = jSONObject.optInt("has_prev", 0);
                this.TZ = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
