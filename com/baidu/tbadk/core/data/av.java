package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class av {
    private int eby = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int ebA = 0;
    private int has_more = 0;
    private int ebB = 0;
    private int total_count = 0;
    private int ebz = 0;

    public int bej() {
        return this.eby;
    }

    public void nf(int i) {
        this.eby = i;
    }

    public int bdn() {
        return this.total_num;
    }

    public void ng(int i) {
        this.total_num = i;
    }

    public int bek() {
        return this.total_count;
    }

    public int bel() {
        return this.ebz;
    }

    public void nh(int i) {
        this.ebz = i;
    }

    public int bem() {
        return this.current_page;
    }

    public void ni(int i) {
        this.current_page = i;
    }

    public int ben() {
        return this.ebA;
    }

    public void nj(int i) {
        this.ebA = i;
    }

    public void nk(int i) {
        this.has_more = i;
    }

    public int beo() {
        return this.has_more;
    }

    public void nl(int i) {
        this.ebB = i;
    }

    public int bep() {
        return this.ebB;
    }

    public void a(Page page) {
        if (page != null) {
            this.eby = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.ebA = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.ebB = page.has_prev.intValue();
            this.ebz = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eby = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.ebA = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.ebB = jSONObject.optInt("has_prev", 0);
                this.ebz = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
