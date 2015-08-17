package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class p {
    private int Vh = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Vi = 0;
    private int has_more = 0;
    private int Vj = 0;
    private int total_count = 0;

    public int rP() {
        return this.Vh;
    }

    public void bt(int i) {
        this.Vh = i;
    }

    public int ru() {
        return this.total_num;
    }

    public void bu(int i) {
        this.total_num = i;
    }

    public int rQ() {
        return this.total_count;
    }

    public int rR() {
        return this.current_page;
    }

    public void bv(int i) {
        this.current_page = i;
    }

    public int rS() {
        return this.Vi;
    }

    public void bw(int i) {
        this.Vi = i;
    }

    public void bx(int i) {
        this.has_more = i;
    }

    public int rT() {
        return this.has_more;
    }

    public void by(int i) {
        this.Vj = i;
    }

    public int rU() {
        return this.Vj;
    }

    public void a(Page page) {
        if (page != null) {
            this.Vh = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.total_count = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Vi = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Vj = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vh = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.total_count = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Vi = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Vj = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
