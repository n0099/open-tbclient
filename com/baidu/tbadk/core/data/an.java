package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bzy = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bzA = 0;
    private int has_more = 0;
    private int bzB = 0;
    private int total_count = 0;
    private int bzz = 0;

    public int XF() {
        return this.bzy;
    }

    public void gh(int i) {
        this.bzy = i;
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
        return this.bzz;
    }

    public void gj(int i) {
        this.bzz = i;
    }

    public int XI() {
        return this.current_page;
    }

    public void gk(int i) {
        this.current_page = i;
    }

    public int XJ() {
        return this.bzA;
    }

    public void gl(int i) {
        this.bzA = i;
    }

    public void gm(int i) {
        this.has_more = i;
    }

    public int XK() {
        return this.has_more;
    }

    public void gn(int i) {
        this.bzB = i;
    }

    public int XL() {
        return this.bzB;
    }

    public void a(Page page) {
        if (page != null) {
            this.bzy = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bzA = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bzB = page.has_prev.intValue();
            this.bzz = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bzy = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bzA = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bzB = jSONObject.optInt("has_prev", 0);
                this.bzz = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
