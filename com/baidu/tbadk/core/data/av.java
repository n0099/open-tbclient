package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class av {
    private int eBT = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int eBV = 0;
    private int has_more = 0;
    private int eBW = 0;
    private int total_count = 0;
    private int eBU = 0;

    public int bll() {
        return this.eBT;
    }

    public void nX(int i) {
        this.eBT = i;
    }

    public int bkp() {
        return this.total_num;
    }

    public void nY(int i) {
        this.total_num = i;
    }

    public int blm() {
        return this.total_count;
    }

    public int bln() {
        return this.eBU;
    }

    public void nZ(int i) {
        this.eBU = i;
    }

    public int blo() {
        return this.current_page;
    }

    public void oa(int i) {
        this.current_page = i;
    }

    public int blp() {
        return this.eBV;
    }

    public void ob(int i) {
        this.eBV = i;
    }

    public void oc(int i) {
        this.has_more = i;
    }

    public int blq() {
        return this.has_more;
    }

    public void od(int i) {
        this.eBW = i;
    }

    public int blr() {
        return this.eBW;
    }

    public void a(Page page) {
        if (page != null) {
            this.eBT = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.eBV = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.eBW = page.has_prev.intValue();
            this.eBU = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBT = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.eBV = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.eBW = jSONObject.optInt("has_prev", 0);
                this.eBU = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
