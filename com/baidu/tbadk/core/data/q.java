package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes.dex */
public class q {
    private int Qp = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int Qr = 0;
    private int has_more = 0;
    private int Qs = 0;
    private int Qq = 0;

    public int qN() {
        return this.Qp;
    }

    public void bk(int i) {
        this.Qp = i;
    }

    public int qt() {
        return this.total_num;
    }

    public void bl(int i) {
        this.total_num = i;
    }

    public int qO() {
        return this.Qq;
    }

    public int qP() {
        return this.current_page;
    }

    public void bm(int i) {
        this.current_page = i;
    }

    public int qQ() {
        return this.Qr;
    }

    public void bn(int i) {
        this.Qr = i;
    }

    public void bo(int i) {
        this.has_more = i;
    }

    public int qR() {
        return this.has_more;
    }

    public void bp(int i) {
        this.Qs = i;
    }

    public int qS() {
        return this.Qs;
    }

    public void a(Page page) {
        if (page != null) {
            this.Qp = page.total_page.intValue();
            this.total_num = page.total_num.intValue();
            this.Qq = page.total_count.intValue();
            this.current_page = page.current_page.intValue();
            this.Qr = page.page_size.intValue();
            this.has_more = page.has_more.intValue();
            this.Qs = page.has_prev.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Qp = jSONObject.optInt("total_page", 0);
                this.total_num = jSONObject.optInt("total_num", 0);
                this.Qq = jSONObject.optInt("total_count", 0);
                this.current_page = jSONObject.optInt("current_page", 0);
                this.Qr = jSONObject.optInt("page_size", 0);
                this.has_more = jSONObject.optInt("has_more", 0);
                this.Qs = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
