package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class an {
    private int bZX = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int bZZ = 0;
    private int has_more = 0;
    private int caa = 0;
    private int total_count = 0;
    private int bZY = 0;

    public int ahv() {
        return this.bZX;
    }

    public void hx(int i) {
        this.bZX = i;
    }

    public int agP() {
        return this.total_num;
    }

    public void hy(int i) {
        this.total_num = i;
    }

    public int ahw() {
        return this.total_count;
    }

    public int ahx() {
        return this.bZY;
    }

    public void hz(int i) {
        this.bZY = i;
    }

    public int ahy() {
        return this.current_page;
    }

    public void hA(int i) {
        this.current_page = i;
    }

    public int ahz() {
        return this.bZZ;
    }

    public void hB(int i) {
        this.bZZ = i;
    }

    public void hC(int i) {
        this.has_more = i;
    }

    public int ahA() {
        return this.has_more;
    }

    public void hD(int i) {
        this.caa = i;
    }

    public int ahB() {
        return this.caa;
    }

    public void a(Page page) {
        if (page != null) {
            this.bZX = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.bZZ = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.caa = page.has_prev.intValue();
            this.bZY = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bZX = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.bZZ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.caa = jSONObject.optInt("has_prev", 0);
                this.bZY = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
