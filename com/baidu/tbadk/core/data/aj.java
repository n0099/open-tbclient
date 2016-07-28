package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class aj {
    private int Pd = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Pf = 0;
    private int has_more = 0;
    private int Pg = 0;
    private int total_count = 0;
    private int Pe = 0;

    public int pi() {
        return this.Pd;
    }

    public void bx(int i) {
        this.Pd = i;
    }

    public int oe() {
        return this.total_num;
    }

    public void by(int i) {
        this.total_num = i;
    }

    public int pj() {
        return this.total_count;
    }

    public int pk() {
        return this.Pe;
    }

    public void bz(int i) {
        this.Pe = i;
    }

    public int pl() {
        return this.current_page;
    }

    public void bA(int i) {
        this.current_page = i;
    }

    public int pm() {
        return this.Pf;
    }

    public void bB(int i) {
        this.Pf = i;
    }

    public void bC(int i) {
        this.has_more = i;
    }

    public int pn() {
        return this.has_more;
    }

    public void bD(int i) {
        this.Pg = i;
    }

    public int po() {
        return this.Pg;
    }

    public void a(Page page) {
        if (page != null) {
            this.Pd = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Pf = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Pg = page.has_prev.intValue();
            this.Pe = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Pd = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Pf = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Pg = jSONObject.optInt("has_prev", 0);
                this.Pe = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
