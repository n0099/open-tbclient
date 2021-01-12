package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ax {
    private int eMp = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eMr = 0;
    private int has_more = 0;
    private int eMs = 0;
    private int total_count = 0;
    private int eMq = 0;

    public int bmh() {
        return this.eMp;
    }

    public void mV(int i) {
        this.eMp = i;
    }

    public int blj() {
        return this.total_num;
    }

    public void mW(int i) {
        this.total_num = i;
    }

    public int bmi() {
        return this.total_count;
    }

    public int bmj() {
        return this.eMq;
    }

    public void mX(int i) {
        this.eMq = i;
    }

    public int bmk() {
        return this.current_page;
    }

    public void mY(int i) {
        this.current_page = i;
    }

    public int bml() {
        return this.eMr;
    }

    public void mZ(int i) {
        this.eMr = i;
    }

    public void na(int i) {
        this.has_more = i;
    }

    public int bmm() {
        return this.has_more;
    }

    public void nb(int i) {
        this.eMs = i;
    }

    public int bmn() {
        return this.eMs;
    }

    public void a(Page page) {
        if (page != null) {
            this.eMp = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eMr = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eMs = page.has_prev.intValue();
            this.eMq = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMp = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eMr = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eMs = jSONObject.optInt("has_prev", 0);
                this.eMq = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
