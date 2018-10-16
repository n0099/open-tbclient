package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int anU = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int anW = 0;
    private int has_more = 0;
    private int anX = 0;
    private int total_count = 0;
    private int anV = 0;

    public int xy() {
        return this.anU;
    }

    public void cc(int i) {
        this.anU = i;
    }

    public int wO() {
        return this.total_num;
    }

    public void cd(int i) {
        this.total_num = i;
    }

    public int xz() {
        return this.total_count;
    }

    public int xA() {
        return this.anV;
    }

    public void ce(int i) {
        this.anV = i;
    }

    public int xB() {
        return this.current_page;
    }

    public void cf(int i) {
        this.current_page = i;
    }

    public int xC() {
        return this.anW;
    }

    public void cg(int i) {
        this.anW = i;
    }

    public void ch(int i) {
        this.has_more = i;
    }

    public int xD() {
        return this.has_more;
    }

    public void ci(int i) {
        this.anX = i;
    }

    public int xE() {
        return this.anX;
    }

    public void a(Page page) {
        if (page != null) {
            this.anU = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.anW = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.anX = page.has_prev.intValue();
            this.anV = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.anU = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.anW = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.anX = jSONObject.optInt("has_prev", 0);
                this.anV = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
