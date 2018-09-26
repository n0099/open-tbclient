package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class al {
    private int aiZ = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int ajb = 0;
    private int has_more = 0;
    private int ajc = 0;
    private int total_count = 0;
    private int aja = 0;

    public int vp() {
        return this.aiZ;
    }

    public void bR(int i) {
        this.aiZ = i;
    }

    public int uF() {
        return this.total_num;
    }

    public void bS(int i) {
        this.total_num = i;
    }

    public int vq() {
        return this.total_count;
    }

    public int vr() {
        return this.aja;
    }

    public void bT(int i) {
        this.aja = i;
    }

    public int vs() {
        return this.current_page;
    }

    public void bU(int i) {
        this.current_page = i;
    }

    public int vt() {
        return this.ajb;
    }

    public void bV(int i) {
        this.ajb = i;
    }

    public void bW(int i) {
        this.has_more = i;
    }

    public int vu() {
        return this.has_more;
    }

    public void bX(int i) {
        this.ajc = i;
    }

    public int vv() {
        return this.ajc;
    }

    public void a(Page page) {
        if (page != null) {
            this.aiZ = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.ajb = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.ajc = page.has_prev.intValue();
            this.aja = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aiZ = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.ajb = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.ajc = jSONObject.optInt("has_prev", 0);
                this.aja = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
