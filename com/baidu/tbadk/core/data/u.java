package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class u {
    private int VQ = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int VS = 0;
    private int has_more = 0;
    private int VT = 0;
    private int total_count = 0;
    private int VR = 0;

    public int sq() {
        return this.VQ;
    }

    public void bK(int i) {
        this.VQ = i;
    }

    public int rG() {
        return this.total_num;
    }

    public void bL(int i) {
        this.total_num = i;
    }

    public int sr() {
        return this.total_count;
    }

    public int ss() {
        return this.VR;
    }

    public void bM(int i) {
        this.VR = i;
    }

    public int st() {
        return this.current_page;
    }

    public void bN(int i) {
        this.current_page = i;
    }

    public int su() {
        return this.VS;
    }

    public void bO(int i) {
        this.VS = i;
    }

    public void bP(int i) {
        this.has_more = i;
    }

    public int sv() {
        return this.has_more;
    }

    public void bQ(int i) {
        this.VT = i;
    }

    public int sw() {
        return this.VT;
    }

    public void a(Page page) {
        if (page != null) {
            this.VQ = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.VS = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.VT = page.has_prev.intValue();
            this.VR = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VQ = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.VS = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.VT = jSONObject.optInt("has_prev", 0);
                this.VR = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
