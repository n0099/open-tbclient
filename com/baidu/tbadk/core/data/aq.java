package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class aq {
    private int WI = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int WK = 0;
    private int has_more = 0;
    private int WL = 0;
    private int total_count = 0;
    private int WJ = 0;

    public int qL() {
        return this.WI;
    }

    public void bE(int i) {
        this.WI = i;
    }

    public int pk() {
        return this.total_num;
    }

    public void bF(int i) {
        this.total_num = i;
    }

    public int qM() {
        return this.total_count;
    }

    public int qN() {
        return this.WJ;
    }

    public void bG(int i) {
        this.WJ = i;
    }

    public int qO() {
        return this.current_page;
    }

    public void bH(int i) {
        this.current_page = i;
    }

    public int qP() {
        return this.WK;
    }

    public void bI(int i) {
        this.WK = i;
    }

    public void bJ(int i) {
        this.has_more = i;
    }

    public int qQ() {
        return this.has_more;
    }

    public void bK(int i) {
        this.WL = i;
    }

    public int qR() {
        return this.WL;
    }

    public void a(Page page) {
        if (page != null) {
            this.WI = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.WK = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.WL = page.has_prev.intValue();
            this.WJ = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WI = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.WK = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.WL = jSONObject.optInt("has_prev", 0);
                this.WJ = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
