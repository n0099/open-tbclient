package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class av {
    private int enC = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int enE = 0;
    private int has_more = 0;
    private int enF = 0;
    private int total_count = 0;
    private int enD = 0;

    public int bgS() {
        return this.enC;
    }

    public void nC(int i) {
        this.enC = i;
    }

    public int bfW() {
        return this.total_num;
    }

    public void nD(int i) {
        this.total_num = i;
    }

    public int bgT() {
        return this.total_count;
    }

    public int bgU() {
        return this.enD;
    }

    public void nE(int i) {
        this.enD = i;
    }

    public int bgV() {
        return this.current_page;
    }

    public void nF(int i) {
        this.current_page = i;
    }

    public int bgW() {
        return this.enE;
    }

    public void nG(int i) {
        this.enE = i;
    }

    public void nH(int i) {
        this.has_more = i;
    }

    public int bgX() {
        return this.has_more;
    }

    public void nI(int i) {
        this.enF = i;
    }

    public int bgY() {
        return this.enF;
    }

    public void a(Page page) {
        if (page != null) {
            this.enC = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.enE = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.enF = page.has_prev.intValue();
            this.enD = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.enC = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.enE = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.enF = jSONObject.optInt("has_prev", 0);
                this.enD = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
