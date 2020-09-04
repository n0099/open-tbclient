package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class av {
    private int dZo = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dZq = 0;
    private int has_more = 0;
    private int dZr = 0;
    private int total_count = 0;
    private int dZp = 0;

    public int bdp() {
        return this.dZo;
    }

    public void mU(int i) {
        this.dZo = i;
    }

    public int bct() {
        return this.total_num;
    }

    public void mV(int i) {
        this.total_num = i;
    }

    public int bdq() {
        return this.total_count;
    }

    public int bdr() {
        return this.dZp;
    }

    public void mW(int i) {
        this.dZp = i;
    }

    public int bds() {
        return this.current_page;
    }

    public void mX(int i) {
        this.current_page = i;
    }

    public int bdt() {
        return this.dZq;
    }

    public void mY(int i) {
        this.dZq = i;
    }

    public void mZ(int i) {
        this.has_more = i;
    }

    public int bdu() {
        return this.has_more;
    }

    public void na(int i) {
        this.dZr = i;
    }

    public int bdv() {
        return this.dZr;
    }

    public void a(Page page) {
        if (page != null) {
            this.dZo = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dZq = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dZr = page.has_prev.intValue();
            this.dZp = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dZo = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dZq = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dZr = jSONObject.optInt("has_prev", 0);
                this.dZp = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
