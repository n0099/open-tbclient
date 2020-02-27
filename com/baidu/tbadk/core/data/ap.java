package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ap {
    private int cPM = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int cPO = 0;
    private int has_more = 0;
    private int cPP = 0;
    private int total_count = 0;
    private int cPN = 0;

    public int aBd() {
        return this.cPM;
    }

    public void jz(int i) {
        this.cPM = i;
    }

    public int aAl() {
        return this.total_num;
    }

    public void jA(int i) {
        this.total_num = i;
    }

    public int aBe() {
        return this.total_count;
    }

    public int aBf() {
        return this.cPN;
    }

    public void jB(int i) {
        this.cPN = i;
    }

    public int aBg() {
        return this.current_page;
    }

    public void jC(int i) {
        this.current_page = i;
    }

    public int aBh() {
        return this.cPO;
    }

    public void jD(int i) {
        this.cPO = i;
    }

    public void jE(int i) {
        this.has_more = i;
    }

    public int aBi() {
        return this.has_more;
    }

    public void jF(int i) {
        this.cPP = i;
    }

    public int aBj() {
        return this.cPP;
    }

    public void a(Page page) {
        if (page != null) {
            this.cPM = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.cPO = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.cPP = page.has_prev.intValue();
            this.cPN = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cPM = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.cPO = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.cPP = jSONObject.optInt("has_prev", 0);
                this.cPN = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
