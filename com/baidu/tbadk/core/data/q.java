package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int Ef = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Eh = 0;
    private int has_more = 0;
    private int Ei = 0;
    private int Eg = 0;

    public int mU() {
        return this.Ef;
    }

    public void bo(int i) {
        this.Ef = i;
    }

    public int mt() {
        return this.total_num;
    }

    public void bp(int i) {
        this.total_num = i;
    }

    public int mV() {
        return this.Eg;
    }

    public int mW() {
        return this.current_page;
    }

    public void bq(int i) {
        this.current_page = i;
    }

    public int mX() {
        return this.Eh;
    }

    public void br(int i) {
        this.Eh = i;
    }

    public void bs(int i) {
        this.has_more = i;
    }

    public int mY() {
        return this.has_more;
    }

    public void bt(int i) {
        this.Ei = i;
    }

    public int mZ() {
        return this.Ei;
    }

    public void a(Page page) {
        if (page != null) {
            this.Ef = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.Eg = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Eh = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Ei = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ef = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.Eg = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Eh = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Ei = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
