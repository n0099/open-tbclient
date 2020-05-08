package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int dpl = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dpn = 0;
    private int has_more = 0;
    private int dpo = 0;
    private int total_count = 0;
    private int dpm = 0;

    public int aJt() {
        return this.dpl;
    }

    public void jG(int i) {
        this.dpl = i;
    }

    public int aIB() {
        return this.total_num;
    }

    public void jH(int i) {
        this.total_num = i;
    }

    public int aJu() {
        return this.total_count;
    }

    public int aJv() {
        return this.dpm;
    }

    public void jI(int i) {
        this.dpm = i;
    }

    public int aJw() {
        return this.current_page;
    }

    public void jJ(int i) {
        this.current_page = i;
    }

    public int aJx() {
        return this.dpn;
    }

    public void jK(int i) {
        this.dpn = i;
    }

    public void jL(int i) {
        this.has_more = i;
    }

    public int aJy() {
        return this.has_more;
    }

    public void jM(int i) {
        this.dpo = i;
    }

    public int aJz() {
        return this.dpo;
    }

    public void a(Page page) {
        if (page != null) {
            this.dpl = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dpn = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dpo = page.has_prev.intValue();
            this.dpm = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dpl = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dpn = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dpo = jSONObject.optInt("has_prev", 0);
                this.dpm = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
