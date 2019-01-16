package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int asK = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int asM = 0;
    private int has_more = 0;
    private int asN = 0;
    private int total_count = 0;
    private int asL = 0;

    public int yX() {
        return this.asK;
    }

    public void cF(int i) {
        this.asK = i;
    }

    public int yn() {
        return this.total_num;
    }

    public void cG(int i) {
        this.total_num = i;
    }

    public int yY() {
        return this.total_count;
    }

    public int yZ() {
        return this.asL;
    }

    public void cH(int i) {
        this.asL = i;
    }

    public int za() {
        return this.current_page;
    }

    public void cI(int i) {
        this.current_page = i;
    }

    public int zb() {
        return this.asM;
    }

    public void cJ(int i) {
        this.asM = i;
    }

    public void cK(int i) {
        this.has_more = i;
    }

    public int zc() {
        return this.has_more;
    }

    public void cL(int i) {
        this.asN = i;
    }

    public int zd() {
        return this.asN;
    }

    public void a(Page page) {
        if (page != null) {
            this.asK = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.asM = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.asN = page.has_prev.intValue();
            this.asL = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asK = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.asM = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.asN = jSONObject.optInt("has_prev", 0);
                this.asL = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
