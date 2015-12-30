package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int Wb = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Wc = 0;
    private int has_more = 0;
    private int Wd = 0;
    private int total_count = 0;

    public int rK() {
        return this.Wb;
    }

    public void bu(int i) {
        this.Wb = i;
    }

    public int rj() {
        return this.total_num;
    }

    public void bv(int i) {
        this.total_num = i;
    }

    public int rL() {
        return this.total_count;
    }

    public int rM() {
        return this.current_page;
    }

    public void bw(int i) {
        this.current_page = i;
    }

    public int rN() {
        return this.Wc;
    }

    public void bx(int i) {
        this.Wc = i;
    }

    public void by(int i) {
        this.has_more = i;
    }

    public int rO() {
        return this.has_more;
    }

    public void bz(int i) {
        this.Wd = i;
    }

    public int rP() {
        return this.Wd;
    }

    public void a(Page page) {
        if (page != null) {
            this.Wb = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Wc = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Wd = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wb = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Wc = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Wd = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
