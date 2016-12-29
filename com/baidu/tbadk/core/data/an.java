package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int Sl = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Sn = 0;
    private int has_more = 0;
    private int So = 0;
    private int total_count = 0;
    private int Sm = 0;

    public int qz() {
        return this.Sl;
    }

    public void bK(int i) {
        this.Sl = i;
    }

    public int pd() {
        return this.total_num;
    }

    public void bL(int i) {
        this.total_num = i;
    }

    public int qA() {
        return this.total_count;
    }

    public int qB() {
        return this.Sm;
    }

    public void bM(int i) {
        this.Sm = i;
    }

    public int qC() {
        return this.current_page;
    }

    public void bN(int i) {
        this.current_page = i;
    }

    public int qD() {
        return this.Sn;
    }

    public void bO(int i) {
        this.Sn = i;
    }

    public void bP(int i) {
        this.has_more = i;
    }

    public int qE() {
        return this.has_more;
    }

    public void bQ(int i) {
        this.So = i;
    }

    public int qF() {
        return this.So;
    }

    public void a(Page page) {
        if (page != null) {
            this.Sl = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Sn = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.So = page.has_prev.intValue();
            this.Sm = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Sl = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Sn = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.So = jSONObject.optInt("has_prev", 0);
                this.Sm = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
