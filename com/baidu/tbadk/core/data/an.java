package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bzE = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bzG = 0;
    private int has_more = 0;
    private int bzH = 0;
    private int total_count = 0;
    private int bzF = 0;

    public int XC() {
        return this.bzE;
    }

    public void gg(int i) {
        this.bzE = i;
    }

    public int WV() {
        return this.total_num;
    }

    public void gh(int i) {
        this.total_num = i;
    }

    public int XD() {
        return this.total_count;
    }

    public int XE() {
        return this.bzF;
    }

    public void gi(int i) {
        this.bzF = i;
    }

    public int XF() {
        return this.current_page;
    }

    public void gj(int i) {
        this.current_page = i;
    }

    public int XG() {
        return this.bzG;
    }

    public void gk(int i) {
        this.bzG = i;
    }

    public void gl(int i) {
        this.has_more = i;
    }

    public int XH() {
        return this.has_more;
    }

    public void gm(int i) {
        this.bzH = i;
    }

    public int XI() {
        return this.bzH;
    }

    public void a(Page page) {
        if (page != null) {
            this.bzE = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bzG = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bzH = page.has_prev.intValue();
            this.bzF = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bzE = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bzG = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bzH = jSONObject.optInt("has_prev", 0);
                this.bzF = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
