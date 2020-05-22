package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ao {
    private int dDj = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int dDl = 0;
    private int has_more = 0;
    private int dDm = 0;
    private int total_count = 0;
    private int dDk = 0;

    public int aPo() {
        return this.dDj;
    }

    public void kg(int i) {
        this.dDj = i;
    }

    public int aOw() {
        return this.total_num;
    }

    public void kh(int i) {
        this.total_num = i;
    }

    public int aPp() {
        return this.total_count;
    }

    public int aPq() {
        return this.dDk;
    }

    public void ki(int i) {
        this.dDk = i;
    }

    public int aPr() {
        return this.current_page;
    }

    public void kj(int i) {
        this.current_page = i;
    }

    public int aPs() {
        return this.dDl;
    }

    public void kk(int i) {
        this.dDl = i;
    }

    public void kl(int i) {
        this.has_more = i;
    }

    public int aPt() {
        return this.has_more;
    }

    public void km(int i) {
        this.dDm = i;
    }

    public int aPu() {
        return this.dDm;
    }

    public void a(Page page) {
        if (page != null) {
            this.dDj = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.dDl = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.dDm = page.has_prev.intValue();
            this.dDk = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dDj = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.dDl = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.dDm = jSONObject.optInt("has_prev", 0);
                this.dDk = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
