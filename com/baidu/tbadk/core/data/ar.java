package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ar {
    private int Ya = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Yc = 0;
    private int has_more = 0;
    private int Yd = 0;
    private int total_count = 0;
    private int Yb = 0;

    public int qz() {
        return this.Ya;
    }

    public void bG(int i) {
        this.Ya = i;
    }

    public int ps() {
        return this.total_num;
    }

    public void bH(int i) {
        this.total_num = i;
    }

    public int qA() {
        return this.total_count;
    }

    public int qB() {
        return this.Yb;
    }

    public void bI(int i) {
        this.Yb = i;
    }

    public int qC() {
        return this.current_page;
    }

    public void bJ(int i) {
        this.current_page = i;
    }

    public int qD() {
        return this.Yc;
    }

    public void bK(int i) {
        this.Yc = i;
    }

    public void bL(int i) {
        this.has_more = i;
    }

    public int qE() {
        return this.has_more;
    }

    public void bM(int i) {
        this.Yd = i;
    }

    public int qF() {
        return this.Yd;
    }

    public void a(Page page) {
        if (page != null) {
            this.Ya = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Yc = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Yd = page.has_prev.intValue();
            this.Yb = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ya = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Yc = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Yd = jSONObject.optInt("has_prev", 0);
                this.Yb = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
