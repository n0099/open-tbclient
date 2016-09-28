package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class am {
    private int RV = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int RX = 0;
    private int has_more = 0;
    private int RY = 0;
    private int total_count = 0;
    private int RW = 0;

    public int qw() {
        return this.RV;
    }

    public void bK(int i) {
        this.RV = i;
    }

    public int pb() {
        return this.total_num;
    }

    public void bL(int i) {
        this.total_num = i;
    }

    public int qx() {
        return this.total_count;
    }

    public int qy() {
        return this.RW;
    }

    public void bM(int i) {
        this.RW = i;
    }

    public int qz() {
        return this.current_page;
    }

    public void bN(int i) {
        this.current_page = i;
    }

    public int qA() {
        return this.RX;
    }

    public void bO(int i) {
        this.RX = i;
    }

    public void bP(int i) {
        this.has_more = i;
    }

    public int qB() {
        return this.has_more;
    }

    public void bQ(int i) {
        this.RY = i;
    }

    public int qC() {
        return this.RY;
    }

    public void a(Page page) {
        if (page != null) {
            this.RV = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.RX = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.RY = page.has_prev.intValue();
            this.RW = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.RV = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.RX = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.RY = jSONObject.optInt("has_prev", 0);
                this.RW = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
