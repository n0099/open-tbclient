package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int dph = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dpj = 0;
    private int has_more = 0;
    private int dpk = 0;
    private int total_count = 0;
    private int dpi = 0;

    public int aJv() {
        return this.dph;
    }

    public void jG(int i) {
        this.dph = i;
    }

    public int aID() {
        return this.total_num;
    }

    public void jH(int i) {
        this.total_num = i;
    }

    public int aJw() {
        return this.total_count;
    }

    public int aJx() {
        return this.dpi;
    }

    public void jI(int i) {
        this.dpi = i;
    }

    public int aJy() {
        return this.current_page;
    }

    public void jJ(int i) {
        this.current_page = i;
    }

    public int aJz() {
        return this.dpj;
    }

    public void jK(int i) {
        this.dpj = i;
    }

    public void jL(int i) {
        this.has_more = i;
    }

    public int aJA() {
        return this.has_more;
    }

    public void jM(int i) {
        this.dpk = i;
    }

    public int aJB() {
        return this.dpk;
    }

    public void a(Page page) {
        if (page != null) {
            this.dph = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dpj = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dpk = page.has_prev.intValue();
            this.dpi = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dph = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dpj = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dpk = jSONObject.optInt("has_prev", 0);
                this.dpi = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
