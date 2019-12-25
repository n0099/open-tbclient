package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int cLz = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cLB = 0;
    private int has_more = 0;
    private int cLC = 0;
    private int total_count = 0;
    private int cLA = 0;

    public int ayt() {
        return this.cLz;
    }

    public void jh(int i) {
        this.cLz = i;
    }

    public int axE() {
        return this.total_num;
    }

    public void ji(int i) {
        this.total_num = i;
    }

    public int ayu() {
        return this.total_count;
    }

    public int ayv() {
        return this.cLA;
    }

    public void jj(int i) {
        this.cLA = i;
    }

    public int ayw() {
        return this.current_page;
    }

    public void jk(int i) {
        this.current_page = i;
    }

    public int ayx() {
        return this.cLB;
    }

    public void jl(int i) {
        this.cLB = i;
    }

    public void jm(int i) {
        this.has_more = i;
    }

    public int ayy() {
        return this.has_more;
    }

    public void jn(int i) {
        this.cLC = i;
    }

    public int ayz() {
        return this.cLC;
    }

    public void a(Page page) {
        if (page != null) {
            this.cLz = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.cLB = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.cLC = page.has_prev.intValue();
            this.cLA = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cLz = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cLB = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cLC = jSONObject.optInt("has_prev", 0);
                this.cLA = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
