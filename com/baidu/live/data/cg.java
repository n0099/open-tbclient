package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cg {
    private String aPA;
    private String aPB;
    private String aPC;
    public boolean aPD;
    private String aPE;
    public int aPF;
    public int aPG;
    private int[] aPH;
    private int[] aPI;
    private int[] aPJ;
    private int[] aPK;
    private int[] aPL;
    private String aPv;
    private String aPw;
    private String aPx;
    private String aPy;
    private String aPz;
    public String id;
    public String name;
    public int price;
    public int type;

    public cg() {
        this.aPD = false;
    }

    public cg(int i, JSONObject jSONObject) {
        int i2;
        this.aPD = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aPv = jSONObject.optString("barrage_start_color");
        this.aPw = jSONObject.optString("barrage_end_color");
        this.aPx = jSONObject.optString("portrait_start_color");
        this.aPy = jSONObject.optString("portrait_end_color");
        this.aPz = jSONObject.optString("portrait_frame_start_color");
        this.aPA = jSONObject.optString("portrait_frame_end_color");
        this.aPB = jSONObject.optString("btn_start_color");
        this.aPC = jSONObject.optString("btn_end_color");
        this.aPE = jSONObject.optString("btn_border_color");
        this.aPF = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aPE)) {
            this.aPD = true;
        }
        try {
            i2 = (int) (((this.aPF * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aPF = i2;
        this.aPG = jSONObject.optInt("noble_level");
    }

    public cg En() {
        this.type = 1;
        this.price = 100;
        this.aPv = "#FF613EFB";
        this.aPw = "#FF44E3FF";
        this.aPx = "#FF623DFE";
        this.aPy = "#FF03E2F5";
        this.aPz = "#FF61A0FF";
        this.aPA = "#FF73FFEF";
        return this;
    }

    public int[] Eo() {
        if (this.aPH == null || this.aPH.length != 2) {
            this.aPH = j(this.aPB, this.aPC, "#FF623DFE", "#FF03E2F5");
        }
        return this.aPH;
    }

    public int[] Ep() {
        if (this.aPL == null || this.aPL.length != 2) {
            this.aPL = j(this.aPE, this.aPE, "#FFFFC926", "#FFFFC926");
        }
        return this.aPL;
    }

    public int[] Eq() {
        if (this.aPI == null || this.aPI.length != 2) {
            this.aPI = j(this.aPx, this.aPy, "#FF623DFE", "#FF03E2F5");
        }
        return this.aPI;
    }

    public int[] Er() {
        if (this.aPJ == null || this.aPJ.length != 2) {
            this.aPJ = j(this.aPv, this.aPw, "#FF613EFB", "#FF44E3FF");
        }
        return this.aPJ;
    }

    public int[] Es() {
        if (this.aPK == null || this.aPK.length != 2) {
            this.aPK = j(this.aPz, this.aPA, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aPK;
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
