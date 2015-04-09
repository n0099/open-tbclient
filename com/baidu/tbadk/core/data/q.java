package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int PU = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int PW = 0;
    private int has_more = 0;
    private int PX = 0;
    private int PV = 0;

    public int qh() {
        return this.PU;
    }

    public void bn(int i) {
        this.PU = i;
    }

    public int pN() {
        return this.total_num;
    }

    public void bo(int i) {
        this.total_num = i;
    }

    public int qi() {
        return this.PV;
    }

    public int qj() {
        return this.current_page;
    }

    public void bp(int i) {
        this.current_page = i;
    }

    public int qk() {
        return this.PW;
    }

    public void bq(int i) {
        this.PW = i;
    }

    public void br(int i) {
        this.has_more = i;
    }

    public int ql() {
        return this.has_more;
    }

    public void bs(int i) {
        this.PX = i;
    }

    public int qm() {
        return this.PX;
    }

    public void a(Page page) {
        if (page != null) {
            this.PU = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.PV = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.PW = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.PX = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PU = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.PV = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.PW = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.PX = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
