package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int WX = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int WZ = 0;
    private int has_more = 0;
    private int Xa = 0;
    private int total_count = 0;
    private int WY = 0;

    public int qh() {
        return this.WX;
    }

    public void bG(int i) {
        this.WX = i;
    }

    public int pg() {
        return this.total_num;
    }

    public void bH(int i) {
        this.total_num = i;
    }

    public int qi() {
        return this.total_count;
    }

    public int qj() {
        return this.WY;
    }

    public void bI(int i) {
        this.WY = i;
    }

    public int qk() {
        return this.current_page;
    }

    public void bJ(int i) {
        this.current_page = i;
    }

    public int ql() {
        return this.WZ;
    }

    public void bK(int i) {
        this.WZ = i;
    }

    public void bL(int i) {
        this.has_more = i;
    }

    public int qm() {
        return this.has_more;
    }

    public void bM(int i) {
        this.Xa = i;
    }

    public int qn() {
        return this.Xa;
    }

    public void a(Page page) {
        if (page != null) {
            this.WX = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.WZ = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Xa = page.has_prev.intValue();
            this.WY = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WX = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.WZ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Xa = jSONObject.optInt("has_prev", 0);
                this.WY = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
