package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bo {
    private String aEc;
    private String aEd;
    private String aEe;
    private String aEf;
    private String aEg;
    private String aEh;
    private String aEi;
    private String aEj;
    public boolean aEk;
    private String aEl;
    public int aEm;
    public int aEn;
    private int[] aEo;
    private int[] aEp;
    private int[] aEq;
    private int[] aEr;
    private int[] aEs;
    public String id;
    public String name;
    public int price;
    public int type;

    public bo() {
        this.aEk = false;
    }

    public bo(int i, JSONObject jSONObject) {
        int i2;
        this.aEk = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aEc = jSONObject.optString("barrage_start_color");
        this.aEd = jSONObject.optString("barrage_end_color");
        this.aEe = jSONObject.optString("portrait_start_color");
        this.aEf = jSONObject.optString("portrait_end_color");
        this.aEg = jSONObject.optString("portrait_frame_start_color");
        this.aEh = jSONObject.optString("portrait_frame_end_color");
        this.aEi = jSONObject.optString("btn_start_color");
        this.aEj = jSONObject.optString("btn_end_color");
        this.aEl = jSONObject.optString("btn_border_color");
        this.aEm = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aEl)) {
            this.aEk = true;
        }
        try {
            i2 = (int) (((this.aEm * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aEm = i2;
        this.aEn = jSONObject.optInt("noble_level");
    }

    public bo wT() {
        this.type = 1;
        this.price = 100;
        this.aEc = "#FF613EFB";
        this.aEd = "#FF44E3FF";
        this.aEe = "#FF623DFE";
        this.aEf = "#FF03E2F5";
        this.aEg = "#FF61A0FF";
        this.aEh = "#FF73FFEF";
        return this;
    }

    public int[] wU() {
        if (this.aEo == null || this.aEo.length != 2) {
            this.aEo = j(this.aEi, this.aEj, "#FF623DFE", "#FF03E2F5");
        }
        return this.aEo;
    }

    public int[] wV() {
        if (this.aEs == null || this.aEs.length != 2) {
            this.aEs = j(this.aEl, this.aEl, "#FFFFC926", "#FFFFC926");
        }
        return this.aEs;
    }

    public int[] wW() {
        if (this.aEp == null || this.aEp.length != 2) {
            this.aEp = j(this.aEe, this.aEf, "#FF623DFE", "#FF03E2F5");
        }
        return this.aEp;
    }

    public int[] wX() {
        if (this.aEq == null || this.aEq.length != 2) {
            this.aEq = j(this.aEc, this.aEd, "#FF613EFB", "#FF44E3FF");
        }
        return this.aEq;
    }

    public int[] wY() {
        if (this.aEr == null || this.aEr.length != 2) {
            this.aEr = j(this.aEg, this.aEh, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aEr;
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
