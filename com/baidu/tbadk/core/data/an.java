package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bzA = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bzC = 0;
    private int has_more = 0;
    private int bzD = 0;
    private int total_count = 0;
    private int bzB = 0;

    public int XF() {
        return this.bzA;
    }

    public void gh(int i) {
        this.bzA = i;
    }

    public int WY() {
        return this.total_num;
    }

    public void gi(int i) {
        this.total_num = i;
    }

    public int XG() {
        return this.total_count;
    }

    public int XH() {
        return this.bzB;
    }

    public void gj(int i) {
        this.bzB = i;
    }

    public int XI() {
        return this.current_page;
    }

    public void gk(int i) {
        this.current_page = i;
    }

    public int XJ() {
        return this.bzC;
    }

    public void gl(int i) {
        this.bzC = i;
    }

    public void gm(int i) {
        this.has_more = i;
    }

    public int XK() {
        return this.has_more;
    }

    public void gn(int i) {
        this.bzD = i;
    }

    public int XL() {
        return this.bzD;
    }

    public void a(Page page) {
        if (page != null) {
            this.bzA = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bzC = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bzD = page.has_prev.intValue();
            this.bzB = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bzA = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bzC = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bzD = jSONObject.optInt("has_prev", 0);
                this.bzB = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
