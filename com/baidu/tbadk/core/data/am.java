package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class am {
    private int YL = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int YN = 0;
    private int has_more = 0;
    private int YO = 0;
    private int total_count = 0;
    private int YM = 0;

    public int qW() {
        return this.YL;
    }

    public void bD(int i) {
        this.YL = i;
    }

    public int qp() {
        return this.total_num;
    }

    public void bE(int i) {
        this.total_num = i;
    }

    public int qX() {
        return this.total_count;
    }

    public int qY() {
        return this.YM;
    }

    public void bF(int i) {
        this.YM = i;
    }

    public int qZ() {
        return this.current_page;
    }

    public void bG(int i) {
        this.current_page = i;
    }

    public int ra() {
        return this.YN;
    }

    public void bH(int i) {
        this.YN = i;
    }

    public void bI(int i) {
        this.has_more = i;
    }

    public int rb() {
        return this.has_more;
    }

    public void bJ(int i) {
        this.YO = i;
    }

    public int rc() {
        return this.YO;
    }

    public void a(Page page) {
        if (page != null) {
            this.YL = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.YN = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.YO = page.has_prev.intValue();
            this.YM = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.YL = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.YN = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.YO = jSONObject.optInt("has_prev", 0);
                this.YM = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
