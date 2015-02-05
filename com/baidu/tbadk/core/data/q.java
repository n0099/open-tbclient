package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int Ec = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Ee = 0;
    private int has_more = 0;
    private int Ef = 0;
    private int Ed = 0;

    public int mN() {
        return this.Ec;
    }

    public void bo(int i) {
        this.Ec = i;
    }

    public int mm() {
        return this.total_num;
    }

    public void bp(int i) {
        this.total_num = i;
    }

    public int mO() {
        return this.Ed;
    }

    public int mP() {
        return this.current_page;
    }

    public void bq(int i) {
        this.current_page = i;
    }

    public int mQ() {
        return this.Ee;
    }

    public void br(int i) {
        this.Ee = i;
    }

    public void bs(int i) {
        this.has_more = i;
    }

    public int mR() {
        return this.has_more;
    }

    public void bt(int i) {
        this.Ef = i;
    }

    public int mS() {
        return this.Ef;
    }

    public void a(Page page) {
        if (page != null) {
            this.Ec = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.Ed = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Ee = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Ef = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ec = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.Ed = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Ee = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Ef = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
