package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int WY = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Xa = 0;
    private int has_more = 0;
    private int Xb = 0;
    private int total_count = 0;
    private int WZ = 0;

    public int ri() {
        return this.WY;
    }

    public void bH(int i) {
        this.WY = i;
    }

    public int pI() {
        return this.total_num;
    }

    public void bI(int i) {
        this.total_num = i;
    }

    public int rj() {
        return this.total_count;
    }

    public int rk() {
        return this.WZ;
    }

    public void bJ(int i) {
        this.WZ = i;
    }

    public int rl() {
        return this.current_page;
    }

    public void bK(int i) {
        this.current_page = i;
    }

    public int rm() {
        return this.Xa;
    }

    public void bL(int i) {
        this.Xa = i;
    }

    public void bM(int i) {
        this.has_more = i;
    }

    public int rn() {
        return this.has_more;
    }

    public void bN(int i) {
        this.Xb = i;
    }

    public int ro() {
        return this.Xb;
    }

    public void a(Page page) {
        if (page != null) {
            this.WY = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Xa = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Xb = page.has_prev.intValue();
            this.WZ = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WY = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Xa = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Xb = jSONObject.optInt("has_prev", 0);
                this.WZ = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
