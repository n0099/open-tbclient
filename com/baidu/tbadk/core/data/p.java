package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class p {
    private int Eb = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Ed = 0;
    private int has_more = 0;
    private int Ee = 0;
    private int Ec = 0;

    public int mS() {
        return this.Eb;
    }

    public void bj(int i) {
        this.Eb = i;
    }

    public int mt() {
        return this.total_num;
    }

    public void bk(int i) {
        this.total_num = i;
    }

    public int mT() {
        return this.Ec;
    }

    public int mU() {
        return this.current_page;
    }

    public void bl(int i) {
        this.current_page = i;
    }

    public int mV() {
        return this.Ed;
    }

    public void bm(int i) {
        this.Ed = i;
    }

    public void bn(int i) {
        this.has_more = i;
    }

    public int mW() {
        return this.has_more;
    }

    public void bo(int i) {
        this.Ee = i;
    }

    public int mX() {
        return this.Ee;
    }

    public void a(Page page) {
        if (page != null) {
            this.Eb = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.Ec = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Ed = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Ee = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Eb = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.Ec = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Ed = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Ee = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
