package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cg {
    private String aRg;
    private String aRh;
    private String aRi;
    private String aRj;
    private String aRk;
    private String aRl;
    private String aRm;
    private String aRn;
    public boolean aRo;
    private String aRp;
    public int aRq;
    public int aRr;
    private int[] aRs;
    private int[] aRt;
    private int[] aRu;
    private int[] aRv;
    private int[] aRw;
    public String id;
    public String name;
    public int price;
    public int type;

    public cg() {
        this.aRo = false;
    }

    public cg(int i, JSONObject jSONObject) {
        int i2;
        this.aRo = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aRg = jSONObject.optString("barrage_start_color");
        this.aRh = jSONObject.optString("barrage_end_color");
        this.aRi = jSONObject.optString("portrait_start_color");
        this.aRj = jSONObject.optString("portrait_end_color");
        this.aRk = jSONObject.optString("portrait_frame_start_color");
        this.aRl = jSONObject.optString("portrait_frame_end_color");
        this.aRm = jSONObject.optString("btn_start_color");
        this.aRn = jSONObject.optString("btn_end_color");
        this.aRp = jSONObject.optString("btn_border_color");
        this.aRq = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aRp)) {
            this.aRo = true;
        }
        try {
            i2 = (int) (((this.aRq * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aRq = i2;
        this.aRr = jSONObject.optInt("noble_level");
    }

    public cg EW() {
        this.type = 1;
        this.price = 100;
        this.aRg = "#FF613EFB";
        this.aRh = "#FF44E3FF";
        this.aRi = "#FF623DFE";
        this.aRj = "#FF03E2F5";
        this.aRk = "#FF61A0FF";
        this.aRl = "#FF73FFEF";
        return this;
    }

    public int[] EX() {
        if (this.aRs == null || this.aRs.length != 2) {
            this.aRs = j(this.aRm, this.aRn, "#FF623DFE", "#FF03E2F5");
        }
        return this.aRs;
    }

    public int[] EY() {
        if (this.aRw == null || this.aRw.length != 2) {
            this.aRw = j(this.aRp, this.aRp, "#FFFFC926", "#FFFFC926");
        }
        return this.aRw;
    }

    public int[] EZ() {
        if (this.aRt == null || this.aRt.length != 2) {
            this.aRt = j(this.aRi, this.aRj, "#FF623DFE", "#FF03E2F5");
        }
        return this.aRt;
    }

    public int[] Fa() {
        if (this.aRu == null || this.aRu.length != 2) {
            this.aRu = j(this.aRg, this.aRh, "#FF613EFB", "#FF44E3FF");
        }
        return this.aRu;
    }

    public int[] Fb() {
        if (this.aRv == null || this.aRv.length != 2) {
            this.aRv = j(this.aRk, this.aRl, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aRv;
    }

    private int[] j(String str, String str2, String str3, String str4) {
        int parseColor;
        int parseColor2;
        try {
            parseColor = Color.parseColor(str);
            parseColor2 = Color.parseColor(str2);
        } catch (Exception e) {
            parseColor = Color.parseColor(str3);
            parseColor2 = Color.parseColor(str4);
        }
        return new int[]{parseColor, parseColor2};
    }
}
