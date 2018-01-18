package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aLY = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aMa = 0;
    private int has_more = 0;
    private int aMb = 0;
    private int total_count = 0;
    private int aLZ = 0;

    public int xP() {
        return this.aLY;
    }

    public void eE(int i) {
        this.aLY = i;
    }

    public int wT() {
        return this.total_num;
    }

    public void eF(int i) {
        this.total_num = i;
    }

    public int xQ() {
        return this.total_count;
    }

    public int xR() {
        return this.aLZ;
    }

    public void eG(int i) {
        this.aLZ = i;
    }

    public int xS() {
        return this.current_page;
    }

    public void eH(int i) {
        this.current_page = i;
    }

    public int xT() {
        return this.aMa;
    }

    public void eI(int i) {
        this.aMa = i;
    }

    public void eJ(int i) {
        this.has_more = i;
    }

    public int xU() {
        return this.has_more;
    }

    public void eK(int i) {
        this.aMb = i;
    }

    public int xV() {
        return this.aMb;
    }

    public void a(Page page) {
        if (page != null) {
            this.aLY = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aMa = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aMb = page.has_prev.intValue();
            this.aLZ = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLY = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aMa = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aMb = jSONObject.optInt("has_prev", 0);
                this.aLZ = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
