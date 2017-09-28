package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int Xj = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Xl = 0;
    private int has_more = 0;
    private int Xm = 0;
    private int total_count = 0;
    private int Xk = 0;

    public int qo() {
        return this.Xj;
    }

    public void bH(int i) {
        this.Xj = i;
    }

    public int pn() {
        return this.total_num;
    }

    public void bI(int i) {
        this.total_num = i;
    }

    public int qp() {
        return this.total_count;
    }

    public int qq() {
        return this.Xk;
    }

    public void bJ(int i) {
        this.Xk = i;
    }

    public int qr() {
        return this.current_page;
    }

    public void bK(int i) {
        this.current_page = i;
    }

    public int qs() {
        return this.Xl;
    }

    public void bL(int i) {
        this.Xl = i;
    }

    public void bM(int i) {
        this.has_more = i;
    }

    public int qt() {
        return this.has_more;
    }

    public void bN(int i) {
        this.Xm = i;
    }

    public int qu() {
        return this.Xm;
    }

    public void a(Page page) {
        if (page != null) {
            this.Xj = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Xl = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Xm = page.has_prev.intValue();
            this.Xk = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Xj = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Xl = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Xm = jSONObject.optInt("has_prev", 0);
                this.Xk = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
