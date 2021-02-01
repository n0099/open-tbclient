package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class az {
    private int eOB = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eOD = 0;
    private int has_more = 0;
    private int eOE = 0;
    private int total_count = 0;
    private int eOC = 0;

    public int bmA() {
        return this.eOB;
    }

    public void mY(int i) {
        this.eOB = i;
    }

    public int blB() {
        return this.total_num;
    }

    public void mZ(int i) {
        this.total_num = i;
    }

    public int bmB() {
        return this.total_count;
    }

    public int bmC() {
        return this.eOC;
    }

    public void na(int i) {
        this.eOC = i;
    }

    public int bmD() {
        return this.current_page;
    }

    public void nb(int i) {
        this.current_page = i;
    }

    public int bmE() {
        return this.eOD;
    }

    public void nc(int i) {
        this.eOD = i;
    }

    public void nd(int i) {
        this.has_more = i;
    }

    public int bmF() {
        return this.has_more;
    }

    public void ne(int i) {
        this.eOE = i;
    }

    public int bmG() {
        return this.eOE;
    }

    public void a(Page page) {
        if (page != null) {
            this.eOB = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eOD = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eOE = page.has_prev.intValue();
            this.eOC = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eOB = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eOD = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eOE = jSONObject.optInt("has_prev", 0);
                this.eOC = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
