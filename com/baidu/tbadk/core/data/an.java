package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bZg = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bZi = 0;
    private int has_more = 0;
    private int bZj = 0;
    private int total_count = 0;
    private int bZh = 0;

    public int aht() {
        return this.bZg;
    }

    public void hw(int i) {
        this.bZg = i;
    }

    public int agN() {
        return this.total_num;
    }

    public void hx(int i) {
        this.total_num = i;
    }

    public int ahu() {
        return this.total_count;
    }

    public int ahv() {
        return this.bZh;
    }

    public void hy(int i) {
        this.bZh = i;
    }

    public int ahw() {
        return this.current_page;
    }

    public void hz(int i) {
        this.current_page = i;
    }

    public int ahx() {
        return this.bZi;
    }

    public void hA(int i) {
        this.bZi = i;
    }

    public void hB(int i) {
        this.has_more = i;
    }

    public int ahy() {
        return this.has_more;
    }

    public void hC(int i) {
        this.bZj = i;
    }

    public int ahz() {
        return this.bZj;
    }

    public void a(Page page) {
        if (page != null) {
            this.bZg = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bZi = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.bZj = page.has_prev.intValue();
            this.bZh = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bZg = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bZi = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.bZj = jSONObject.optInt("has_prev", 0);
                this.bZh = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
