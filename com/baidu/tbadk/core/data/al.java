package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aNj = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int aNl = 0;
    private int has_more = 0;
    private int aNm = 0;
    private int total_count = 0;
    private int aNk = 0;

    public int yr() {
        return this.aNj;
    }

    public void eE(int i) {
        this.aNj = i;
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
        return this.aNk;
    }

    public void eG(int i) {
        this.aNk = i;
    }

    public int yu() {
        return this.current_page;
    }

    public void eH(int i) {
        this.current_page = i;
    }

    public int yv() {
        return this.aNl;
    }

    public void eI(int i) {
        this.aNl = i;
    }

    public void eJ(int i) {
        this.has_more = i;
    }

    public int yw() {
        return this.has_more;
    }

    public void eK(int i) {
        this.aNm = i;
    }

    public int yx() {
        return this.aNm;
    }

    public void a(Page page) {
        if (page != null) {
            this.aNj = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.aNl = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.aNm = page.has_prev.intValue();
            this.aNk = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aNj = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.aNl = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.aNm = jSONObject.optInt("has_prev", 0);
                this.aNk = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
