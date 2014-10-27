package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class m {
    private int zU = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int zW = 0;
    private int has_more = 0;
    private int zX = 0;
    private int zV = 0;

    public int kc() {
        return this.zU;
    }

    public void aN(int i) {
        this.zU = i;
    }

    public int kd() {
        return this.total_num;
    }

    public void aO(int i) {
        this.total_num = i;
    }

    public int ke() {
        return this.zV;
    }

    public int kf() {
        return this.current_page;
    }

    public void aP(int i) {
        this.current_page = i;
    }

    public int kg() {
        return this.zW;
    }

    public void aQ(int i) {
        this.zW = i;
    }

    public void aR(int i) {
        this.has_more = i;
    }

    public int kh() {
        return this.has_more;
    }

    public void aS(int i) {
        this.zX = i;
    }

    public int ki() {
        return this.zX;
    }

    public void a(Page page) {
        if (page != null) {
            this.zU = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.zV = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.zW = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.zX = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.zU = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.zV = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.zW = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.zX = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
