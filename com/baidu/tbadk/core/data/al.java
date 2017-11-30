package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int XH = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int XJ = 0;
    private int has_more = 0;
    private int XK = 0;
    private int total_count = 0;
    private int XI = 0;

    public int qr() {
        return this.XH;
    }

    public void bF(int i) {
        this.XH = i;
    }

    public int pt() {
        return this.total_num;
    }

    public void bG(int i) {
        this.total_num = i;
    }

    public int qs() {
        return this.total_count;
    }

    public int qt() {
        return this.XI;
    }

    public void bH(int i) {
        this.XI = i;
    }

    public int qu() {
        return this.current_page;
    }

    public void bI(int i) {
        this.current_page = i;
    }

    public int qv() {
        return this.XJ;
    }

    public void bJ(int i) {
        this.XJ = i;
    }

    public void bK(int i) {
        this.has_more = i;
    }

    public int qw() {
        return this.has_more;
    }

    public void bL(int i) {
        this.XK = i;
    }

    public int qx() {
        return this.XK;
    }

    public void a(Page page) {
        if (page != null) {
            this.XH = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.XJ = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.XK = page.has_prev.intValue();
            this.XI = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XH = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.XJ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.XK = jSONObject.optInt("has_prev", 0);
                this.XI = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
