package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int agz = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int agB = 0;
    private int has_more = 0;
    private int agC = 0;
    private int total_count = 0;
    private int agA = 0;

    public int un() {
        return this.agz;
    }

    public void bI(int i) {
        this.agz = i;
    }

    public int tD() {
        return this.total_num;
    }

    public void bJ(int i) {
        this.total_num = i;
    }

    public int uo() {
        return this.total_count;
    }

    public int up() {
        return this.agA;
    }

    public void bK(int i) {
        this.agA = i;
    }

    public int uq() {
        return this.current_page;
    }

    public void bL(int i) {
        this.current_page = i;
    }

    public int ur() {
        return this.agB;
    }

    public void bM(int i) {
        this.agB = i;
    }

    public void bN(int i) {
        this.has_more = i;
    }

    public int us() {
        return this.has_more;
    }

    public void bO(int i) {
        this.agC = i;
    }

    public int ut() {
        return this.agC;
    }

    public void a(Page page) {
        if (page != null) {
            this.agz = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.agB = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.agC = page.has_prev.intValue();
            this.agA = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agz = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.agB = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.agC = jSONObject.optInt("has_prev", 0);
                this.agA = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
