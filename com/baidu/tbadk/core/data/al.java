package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int XB = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int XD = 0;
    private int has_more = 0;
    private int XE = 0;
    private int total_count = 0;
    private int XC = 0;

    public int qp() {
        return this.XB;
    }

    public void bF(int i) {
        this.XB = i;
    }

    public int pr() {
        return this.total_num;
    }

    public void bG(int i) {
        this.total_num = i;
    }

    public int qq() {
        return this.total_count;
    }

    public int qr() {
        return this.XC;
    }

    public void bH(int i) {
        this.XC = i;
    }

    public int qs() {
        return this.current_page;
    }

    public void bI(int i) {
        this.current_page = i;
    }

    public int qt() {
        return this.XD;
    }

    public void bJ(int i) {
        this.XD = i;
    }

    public void bK(int i) {
        this.has_more = i;
    }

    public int qu() {
        return this.has_more;
    }

    public void bL(int i) {
        this.XE = i;
    }

    public int qv() {
        return this.XE;
    }

    public void a(Page page) {
        if (page != null) {
            this.XB = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.XD = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.XE = page.has_prev.intValue();
            this.XC = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XB = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.XD = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.XE = jSONObject.optInt("has_prev", 0);
                this.XC = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
