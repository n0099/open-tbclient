package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int Xp = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Xr = 0;
    private int has_more = 0;
    private int Xs = 0;
    private int total_count = 0;
    private int Xq = 0;

    public int qm() {
        return this.Xp;
    }

    public void bF(int i) {
        this.Xp = i;
    }

    public int pm() {
        return this.total_num;
    }

    public void bG(int i) {
        this.total_num = i;
    }

    public int qn() {
        return this.total_count;
    }

    public int qo() {
        return this.Xq;
    }

    public void bH(int i) {
        this.Xq = i;
    }

    public int qp() {
        return this.current_page;
    }

    public void bI(int i) {
        this.current_page = i;
    }

    public int qq() {
        return this.Xr;
    }

    public void bJ(int i) {
        this.Xr = i;
    }

    public void bK(int i) {
        this.has_more = i;
    }

    public int qr() {
        return this.has_more;
    }

    public void bL(int i) {
        this.Xs = i;
    }

    public int qs() {
        return this.Xs;
    }

    public void a(Page page) {
        if (page != null) {
            this.Xp = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Xr = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Xs = page.has_prev.intValue();
            this.Xq = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Xp = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Xr = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Xs = jSONObject.optInt("has_prev", 0);
                this.Xq = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
