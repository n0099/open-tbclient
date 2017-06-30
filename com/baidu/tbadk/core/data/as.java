package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class as {
    private int Wl = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Wn = 0;
    private int has_more = 0;
    private int Wo = 0;
    private int total_count = 0;
    private int Wm = 0;

    public int ql() {
        return this.Wl;
    }

    public void bF(int i) {
        this.Wl = i;
    }

    public int pe() {
        return this.total_num;
    }

    public void bG(int i) {
        this.total_num = i;
    }

    public int qm() {
        return this.total_count;
    }

    public int qn() {
        return this.Wm;
    }

    public void bH(int i) {
        this.Wm = i;
    }

    public int qo() {
        return this.current_page;
    }

    public void bI(int i) {
        this.current_page = i;
    }

    public int qp() {
        return this.Wn;
    }

    public void bJ(int i) {
        this.Wn = i;
    }

    public void bK(int i) {
        this.has_more = i;
    }

    public int qq() {
        return this.has_more;
    }

    public void bL(int i) {
        this.Wo = i;
    }

    public int qr() {
        return this.Wo;
    }

    public void a(Page page) {
        if (page != null) {
            this.Wl = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Wn = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Wo = page.has_prev.intValue();
            this.Wm = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wl = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Wn = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Wo = jSONObject.optInt("has_prev", 0);
                this.Wm = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
