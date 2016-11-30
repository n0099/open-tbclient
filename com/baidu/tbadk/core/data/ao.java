package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ao {
    private int Sq = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Ss = 0;
    private int has_more = 0;
    private int St = 0;
    private int total_count = 0;
    private int Sr = 0;

    public int qy() {
        return this.Sq;
    }

    public void bK(int i) {
        this.Sq = i;
    }

    public int pd() {
        return this.total_num;
    }

    public void bL(int i) {
        this.total_num = i;
    }

    public int qz() {
        return this.total_count;
    }

    public int qA() {
        return this.Sr;
    }

    public void bM(int i) {
        this.Sr = i;
    }

    public int qB() {
        return this.current_page;
    }

    public void bN(int i) {
        this.current_page = i;
    }

    public int qC() {
        return this.Ss;
    }

    public void bO(int i) {
        this.Ss = i;
    }

    public void bP(int i) {
        this.has_more = i;
    }

    public int qD() {
        return this.has_more;
    }

    public void bQ(int i) {
        this.St = i;
    }

    public int qE() {
        return this.St;
    }

    public void a(Page page) {
        if (page != null) {
            this.Sq = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Ss = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.St = page.has_prev.intValue();
            this.Sr = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Sq = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Ss = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.St = jSONObject.optInt("has_prev", 0);
                this.Sr = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
