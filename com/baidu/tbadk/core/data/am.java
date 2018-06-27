package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class am {
    private int ahf = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int ahh = 0;
    private int has_more = 0;
    private int ahi = 0;
    private int total_count = 0;
    private int ahg = 0;

    public int uA() {
        return this.ahf;
    }

    public void bG(int i) {
        this.ahf = i;
    }

    public int tR() {
        return this.total_num;
    }

    public void bH(int i) {
        this.total_num = i;
    }

    public int uB() {
        return this.total_count;
    }

    public int uC() {
        return this.ahg;
    }

    public void bI(int i) {
        this.ahg = i;
    }

    public int uD() {
        return this.current_page;
    }

    public void bJ(int i) {
        this.current_page = i;
    }

    public int uE() {
        return this.ahh;
    }

    public void bK(int i) {
        this.ahh = i;
    }

    public void bL(int i) {
        this.has_more = i;
    }

    public int uF() {
        return this.has_more;
    }

    public void bM(int i) {
        this.ahi = i;
    }

    public int uG() {
        return this.ahi;
    }

    public void a(Page page) {
        if (page != null) {
            this.ahf = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.ahh = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.ahi = page.has_prev.intValue();
            this.ahg = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahf = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.ahh = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.ahi = jSONObject.optInt("has_prev", 0);
                this.ahg = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
