package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aNk = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aNm = 0;
    private int has_more = 0;
    private int aNn = 0;
    private int total_count = 0;
    private int aNl = 0;

    public int yr() {
        return this.aNk;
    }

    public void eE(int i) {
        this.aNk = i;
    }

    public int xH() {
        return this.total_num;
    }

    public void eF(int i) {
        this.total_num = i;
    }

    public int ys() {
        return this.total_count;
    }

    public int yt() {
        return this.aNl;
    }

    public void eG(int i) {
        this.aNl = i;
    }

    public int yu() {
        return this.current_page;
    }

    public void eH(int i) {
        this.current_page = i;
    }

    public int yv() {
        return this.aNm;
    }

    public void eI(int i) {
        this.aNm = i;
    }

    public void eJ(int i) {
        this.has_more = i;
    }

    public int yw() {
        return this.has_more;
    }

    public void eK(int i) {
        this.aNn = i;
    }

    public int yx() {
        return this.aNn;
    }

    public void a(Page page) {
        if (page != null) {
            this.aNk = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aNm = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aNn = page.has_prev.intValue();
            this.aNl = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aNk = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aNm = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aNn = jSONObject.optInt("has_prev", 0);
                this.aNl = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
