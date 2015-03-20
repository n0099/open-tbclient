package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int PR = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int PU = 0;
    private int has_more = 0;
    private int PV = 0;
    private int PT = 0;

    public int qh() {
        return this.PR;
    }

    public void bn(int i) {
        this.PR = i;
    }

    public int pN() {
        return this.total_num;
    }

    public void bo(int i) {
        this.total_num = i;
    }

    public int qi() {
        return this.PT;
    }

    public int qj() {
        return this.current_page;
    }

    public void bp(int i) {
        this.current_page = i;
    }

    public int qk() {
        return this.PU;
    }

    public void bq(int i) {
        this.PU = i;
    }

    public void br(int i) {
        this.has_more = i;
    }

    public int ql() {
        return this.has_more;
    }

    public void bs(int i) {
        this.PV = i;
    }

    public int qm() {
        return this.PV;
    }

    public void a(Page page) {
        if (page != null) {
            this.PR = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.PT = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.PU = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.PV = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PR = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.PT = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.PU = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.PV = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
