package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int VB = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int VC = 0;
    private int has_more = 0;
    private int VD = 0;
    private int total_count = 0;

    public int sb() {
        return this.VB;
    }

    public void bB(int i) {
        this.VB = i;
    }

    public int rA() {
        return this.total_num;
    }

    public void bC(int i) {
        this.total_num = i;
    }

    public int sc() {
        return this.total_count;
    }

    public int sd() {
        return this.current_page;
    }

    public void bD(int i) {
        this.current_page = i;
    }

    public int se() {
        return this.VC;
    }

    public void bE(int i) {
        this.VC = i;
    }

    public void bF(int i) {
        this.has_more = i;
    }

    public int sf() {
        return this.has_more;
    }

    public void bG(int i) {
        this.VD = i;
    }

    public int sg() {
        return this.VD;
    }

    public void a(Page page) {
        if (page != null) {
            this.VB = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.VC = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.VD = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VB = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.VC = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.VD = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
