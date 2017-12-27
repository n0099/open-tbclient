package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class am {
    private int aMc = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aMe = 0;
    private int has_more = 0;
    private int aMf = 0;
    private int total_count = 0;
    private int aMd = 0;

    public int xS() {
        return this.aMc;
    }

    public void eF(int i) {
        this.aMc = i;
    }

    public int wU() {
        return this.total_num;
    }

    public void eG(int i) {
        this.total_num = i;
    }

    public int xT() {
        return this.total_count;
    }

    public int xU() {
        return this.aMd;
    }

    public void eH(int i) {
        this.aMd = i;
    }

    public int xV() {
        return this.current_page;
    }

    public void eI(int i) {
        this.current_page = i;
    }

    public int xW() {
        return this.aMe;
    }

    public void eJ(int i) {
        this.aMe = i;
    }

    public void eK(int i) {
        this.has_more = i;
    }

    public int xX() {
        return this.has_more;
    }

    public void eL(int i) {
        this.aMf = i;
    }

    public int xY() {
        return this.aMf;
    }

    public void a(Page page) {
        if (page != null) {
            this.aMc = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aMe = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aMf = page.has_prev.intValue();
            this.aMd = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMc = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aMe = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aMf = jSONObject.optInt("has_prev", 0);
                this.aMd = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
