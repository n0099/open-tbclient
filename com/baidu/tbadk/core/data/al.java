package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aMb = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aMd = 0;
    private int has_more = 0;
    private int aMe = 0;
    private int total_count = 0;
    private int aMc = 0;

    public int xQ() {
        return this.aMb;
    }

    public void eE(int i) {
        this.aMb = i;
    }

    public int wU() {
        return this.total_num;
    }

    public void eF(int i) {
        this.total_num = i;
    }

    public int xR() {
        return this.total_count;
    }

    public int xS() {
        return this.aMc;
    }

    public void eG(int i) {
        this.aMc = i;
    }

    public int xT() {
        return this.current_page;
    }

    public void eH(int i) {
        this.current_page = i;
    }

    public int xU() {
        return this.aMd;
    }

    public void eI(int i) {
        this.aMd = i;
    }

    public void eJ(int i) {
        this.has_more = i;
    }

    public int xV() {
        return this.has_more;
    }

    public void eK(int i) {
        this.aMe = i;
    }

    public int xW() {
        return this.aMe;
    }

    public void a(Page page) {
        if (page != null) {
            this.aMb = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aMd = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aMe = page.has_prev.intValue();
            this.aMc = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMb = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aMd = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aMe = jSONObject.optInt("has_prev", 0);
                this.aMc = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
