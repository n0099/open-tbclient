package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bz {
    public int aMA;
    private int[] aMB;
    private int[] aMC;
    private int[] aMD;
    private int[] aME;
    private int[] aMF;
    private String aMp;
    private String aMq;
    private String aMr;
    private String aMs;
    private String aMt;
    private String aMu;
    private String aMv;
    private String aMw;
    public boolean aMx;
    private String aMy;
    public int aMz;
    public String id;
    public String name;
    public int price;
    public int type;

    public bz() {
        this.aMx = false;
    }

    public bz(int i, JSONObject jSONObject) {
        int i2;
        this.aMx = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aMp = jSONObject.optString("barrage_start_color");
        this.aMq = jSONObject.optString("barrage_end_color");
        this.aMr = jSONObject.optString("portrait_start_color");
        this.aMs = jSONObject.optString("portrait_end_color");
        this.aMt = jSONObject.optString("portrait_frame_start_color");
        this.aMu = jSONObject.optString("portrait_frame_end_color");
        this.aMv = jSONObject.optString("btn_start_color");
        this.aMw = jSONObject.optString("btn_end_color");
        this.aMy = jSONObject.optString("btn_border_color");
        this.aMz = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aMy)) {
            this.aMx = true;
        }
        try {
            i2 = (int) (((this.aMz * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aMz = i2;
        this.aMA = jSONObject.optInt("noble_level");
    }

    public bz Dp() {
        this.type = 1;
        this.price = 100;
        this.aMp = "#FF613EFB";
        this.aMq = "#FF44E3FF";
        this.aMr = "#FF623DFE";
        this.aMs = "#FF03E2F5";
        this.aMt = "#FF61A0FF";
        this.aMu = "#FF73FFEF";
        return this;
    }

    public int[] Dq() {
        if (this.aMB == null || this.aMB.length != 2) {
            this.aMB = j(this.aMv, this.aMw, "#FF623DFE", "#FF03E2F5");
        }
        return this.aMB;
    }

    public int[] Dr() {
        if (this.aMF == null || this.aMF.length != 2) {
            this.aMF = j(this.aMy, this.aMy, "#FFFFC926", "#FFFFC926");
        }
        return this.aMF;
    }

    public int[] Ds() {
        if (this.aMC == null || this.aMC.length != 2) {
            this.aMC = j(this.aMr, this.aMs, "#FF623DFE", "#FF03E2F5");
        }
        return this.aMC;
    }

    public int[] Dt() {
        if (this.aMD == null || this.aMD.length != 2) {
            this.aMD = j(this.aMp, this.aMq, "#FF613EFB", "#FF44E3FF");
        }
        return this.aMD;
    }

    public int[] Du() {
        if (this.aME == null || this.aME.length != 2) {
            this.aME = j(this.aMt, this.aMu, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aME;
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
