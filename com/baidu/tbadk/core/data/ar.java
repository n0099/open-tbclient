package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ar {
    private int XZ = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Yb = 0;
    private int has_more = 0;
    private int Yc = 0;
    private int total_count = 0;
    private int Ya = 0;

    public int qy() {
        return this.XZ;
    }

    public void bG(int i) {
        this.XZ = i;
    }

    public int pr() {
        return this.total_num;
    }

    public void bH(int i) {
        this.total_num = i;
    }

    public int qz() {
        return this.total_count;
    }

    public int qA() {
        return this.Ya;
    }

    public void bI(int i) {
        this.Ya = i;
    }

    public int qB() {
        return this.current_page;
    }

    public void bJ(int i) {
        this.current_page = i;
    }

    public int qC() {
        return this.Yb;
    }

    public void bK(int i) {
        this.Yb = i;
    }

    public void bL(int i) {
        this.has_more = i;
    }

    public int qD() {
        return this.has_more;
    }

    public void bM(int i) {
        this.Yc = i;
    }

    public int qE() {
        return this.Yc;
    }

    public void a(Page page) {
        if (page != null) {
            this.XZ = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Yb = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Yc = page.has_prev.intValue();
            this.Ya = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XZ = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Yb = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Yc = jSONObject.optInt("has_prev", 0);
                this.Ya = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
