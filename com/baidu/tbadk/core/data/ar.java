package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class ar {
    private int XX = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int XZ = 0;
    private int has_more = 0;
    private int Ya = 0;
    private int total_count = 0;
    private int XY = 0;

    public int qy() {
        return this.XX;
    }

    public void bG(int i) {
        this.XX = i;
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
        return this.XY;
    }

    public void bI(int i) {
        this.XY = i;
    }

    public int qB() {
        return this.current_page;
    }

    public void bJ(int i) {
        this.current_page = i;
    }

    public int qC() {
        return this.XZ;
    }

    public void bK(int i) {
        this.XZ = i;
    }

    public void bL(int i) {
        this.has_more = i;
    }

    public int qD() {
        return this.has_more;
    }

    public void bM(int i) {
        this.Ya = i;
    }

    public int qE() {
        return this.Ya;
    }

    public void a(Page page) {
        if (page != null) {
            this.XX = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.XZ = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Ya = page.has_prev.intValue();
            this.XY = page.lz_total_floor.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XX = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.XZ = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Ya = jSONObject.optInt("has_prev", 0);
                this.XY = jSONObject.optInt("lz_total_floor", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
