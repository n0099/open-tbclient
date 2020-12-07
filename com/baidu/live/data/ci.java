package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ci {
    private String aSA;
    private String aSB;
    private String aSC;
    private String aSD;
    private String aSE;
    public boolean aSF;
    private String aSG;
    public int aSH;
    public int aSI;
    private int[] aSJ;
    private int[] aSK;
    private int[] aSL;
    private int[] aSM;
    private int[] aSN;
    private String aSx;
    private String aSy;
    private String aSz;
    public String id;
    public String name;
    public int price;
    public int type;

    public ci() {
        this.aSF = false;
    }

    public ci(int i, JSONObject jSONObject) {
        int i2;
        this.aSF = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aSx = jSONObject.optString("barrage_start_color");
        this.aSy = jSONObject.optString("barrage_end_color");
        this.aSz = jSONObject.optString("portrait_start_color");
        this.aSA = jSONObject.optString("portrait_end_color");
        this.aSB = jSONObject.optString("portrait_frame_start_color");
        this.aSC = jSONObject.optString("portrait_frame_end_color");
        this.aSD = jSONObject.optString("btn_start_color");
        this.aSE = jSONObject.optString("btn_end_color");
        this.aSG = jSONObject.optString("btn_border_color");
        this.aSH = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aSG)) {
            this.aSF = true;
        }
        try {
            i2 = (int) (((this.aSH * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aSH = i2;
        this.aSI = jSONObject.optInt("noble_level");
    }

    public ci FY() {
        this.type = 1;
        this.price = 100;
        this.aSx = "#FF613EFB";
        this.aSy = "#FF44E3FF";
        this.aSz = "#FF623DFE";
        this.aSA = "#FF03E2F5";
        this.aSB = "#FF61A0FF";
        this.aSC = "#FF73FFEF";
        return this;
    }

    public int[] FZ() {
        if (this.aSJ == null || this.aSJ.length != 2) {
            this.aSJ = j(this.aSD, this.aSE, "#FF623DFE", "#FF03E2F5");
        }
        return this.aSJ;
    }

    public int[] Ga() {
        if (this.aSN == null || this.aSN.length != 2) {
            this.aSN = j(this.aSG, this.aSG, "#FFFFC926", "#FFFFC926");
        }
        return this.aSN;
    }

    public int[] Gb() {
        if (this.aSK == null || this.aSK.length != 2) {
            this.aSK = j(this.aSz, this.aSA, "#FF623DFE", "#FF03E2F5");
        }
        return this.aSK;
    }

    public int[] Gc() {
        if (this.aSL == null || this.aSL.length != 2) {
            this.aSL = j(this.aSx, this.aSy, "#FF613EFB", "#FF44E3FF");
        }
        return this.aSL;
    }

    public int[] Gd() {
        if (this.aSM == null || this.aSM.length != 2) {
            this.aSM = j(this.aSB, this.aSC, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aSM;
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
