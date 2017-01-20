package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ao {
    private int Ru = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Rw = 0;
    private int has_more = 0;
    private int Rx = 0;
    private int total_count = 0;
    private int Rv = 0;

    public int qs() {
        return this.Ru;
    }

    public void bJ(int i) {
        this.Ru = i;
    }

    public int oW() {
        return this.total_num;
    }

    public void bK(int i) {
        this.total_num = i;
    }

    public int qt() {
        return this.total_count;
    }

    public int qu() {
        return this.Rv;
    }

    public void bL(int i) {
        this.Rv = i;
    }

    public int qv() {
        return this.current_page;
    }

    public void bM(int i) {
        this.current_page = i;
    }

    public int qw() {
        return this.Rw;
    }

    public void bN(int i) {
        this.Rw = i;
    }

    public void bO(int i) {
        this.has_more = i;
    }

    public int qx() {
        return this.has_more;
    }

    public void bP(int i) {
        this.Rx = i;
    }

    public int qy() {
        return this.Rx;
    }

    public void a(Page page) {
        if (page != null) {
            this.Ru = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Rw = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Rx = page.has_prev.intValue();
            this.Rv = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ru = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Rw = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Rx = jSONObject.optInt("has_prev", 0);
                this.Rv = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
