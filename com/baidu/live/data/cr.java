package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cr {
    private int[] aTA;
    private String aTk;
    private String aTl;
    private String aTm;
    private String aTn;
    private String aTo;
    private String aTp;
    private String aTq;
    private String aTr;
    public boolean aTs;
    private String aTt;
    public int aTu;
    public int aTv;
    private int[] aTw;
    private int[] aTx;
    private int[] aTy;
    private int[] aTz;
    public String id;
    public String name;
    public int price;
    public int type;

    public cr() {
        this.aTs = false;
    }

    public cr(int i, JSONObject jSONObject) {
        int i2;
        this.aTs = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aTk = jSONObject.optString("barrage_start_color");
        this.aTl = jSONObject.optString("barrage_end_color");
        this.aTm = jSONObject.optString("portrait_start_color");
        this.aTn = jSONObject.optString("portrait_end_color");
        this.aTo = jSONObject.optString("portrait_frame_start_color");
        this.aTp = jSONObject.optString("portrait_frame_end_color");
        this.aTq = jSONObject.optString("btn_start_color");
        this.aTr = jSONObject.optString("btn_end_color");
        this.aTt = jSONObject.optString("btn_border_color");
        this.aTu = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aTt)) {
            this.aTs = true;
        }
        try {
            i2 = (int) (((this.aTu * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aTu = i2;
        this.aTv = jSONObject.optInt("noble_level");
    }

    public cr CO() {
        this.type = 1;
        this.price = 100;
        this.aTk = "#FF613EFB";
        this.aTl = "#FF44E3FF";
        this.aTm = "#FF623DFE";
        this.aTn = "#FF03E2F5";
        this.aTo = "#FF61A0FF";
        this.aTp = "#FF73FFEF";
        return this;
    }

    public int[] CP() {
        if (this.aTw == null || this.aTw.length != 2) {
            this.aTw = j(this.aTq, this.aTr, "#FF623DFE", "#FF03E2F5");
        }
        return this.aTw;
    }

    public int[] CQ() {
        if (this.aTA == null || this.aTA.length != 2) {
            this.aTA = j(this.aTt, this.aTt, "#FFFFC926", "#FFFFC926");
        }
        return this.aTA;
    }

    public int[] CR() {
        if (this.aTx == null || this.aTx.length != 2) {
            this.aTx = j(this.aTm, this.aTn, "#FF623DFE", "#FF03E2F5");
        }
        return this.aTx;
    }

    public int[] CS() {
        if (this.aTy == null || this.aTy.length != 2) {
            this.aTy = j(this.aTk, this.aTl, "#FF613EFB", "#FF44E3FF");
        }
        return this.aTy;
    }

    public int[] CT() {
        if (this.aTz == null || this.aTz.length != 2) {
            this.aTz = j(this.aTo, this.aTp, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aTz;
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
