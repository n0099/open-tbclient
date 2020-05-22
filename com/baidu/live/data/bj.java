package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bj {
    private String aBR;
    private String aBS;
    private String aBT;
    private String aBU;
    private String aBV;
    private String aBW;
    private String aBX;
    private String aBY;
    public boolean aBZ;
    private String aCa;
    public int aCb;
    public int aCc;
    private int[] aCd;
    private int[] aCe;
    private int[] aCf;
    private int[] aCg;
    private int[] aCh;
    public String id;
    public String name;
    public int price;
    public int type;

    public bj() {
        this.aBZ = false;
    }

    public bj(int i, JSONObject jSONObject) {
        int i2;
        this.aBZ = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aBR = jSONObject.optString("barrage_start_color");
        this.aBS = jSONObject.optString("barrage_end_color");
        this.aBT = jSONObject.optString("portrait_start_color");
        this.aBU = jSONObject.optString("portrait_end_color");
        this.aBV = jSONObject.optString("portrait_frame_start_color");
        this.aBW = jSONObject.optString("portrait_frame_end_color");
        this.aBX = jSONObject.optString("btn_start_color");
        this.aBY = jSONObject.optString("btn_end_color");
        this.aCa = jSONObject.optString("btn_border_color");
        this.aCb = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aCa)) {
            this.aBZ = true;
        }
        try {
            i2 = (int) (((this.aCb * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aCb = i2;
        this.aCc = jSONObject.optInt("noble_level");
    }

    public bj wv() {
        this.type = 1;
        this.price = 100;
        this.aBR = "#FF613EFB";
        this.aBS = "#FF44E3FF";
        this.aBT = "#FF623DFE";
        this.aBU = "#FF03E2F5";
        this.aBV = "#FF61A0FF";
        this.aBW = "#FF73FFEF";
        return this;
    }

    public int[] ww() {
        if (this.aCd == null || this.aCd.length != 2) {
            this.aCd = j(this.aBX, this.aBY, "#FF623DFE", "#FF03E2F5");
        }
        return this.aCd;
    }

    public int[] wx() {
        if (this.aCh == null || this.aCh.length != 2) {
            this.aCh = j(this.aCa, this.aCa, "#FFFFC926", "#FFFFC926");
        }
        return this.aCh;
    }

    public int[] wy() {
        if (this.aCe == null || this.aCe.length != 2) {
            this.aCe = j(this.aBT, this.aBU, "#FF623DFE", "#FF03E2F5");
        }
        return this.aCe;
    }

    public int[] wz() {
        if (this.aCf == null || this.aCf.length != 2) {
            this.aCf = j(this.aBR, this.aBS, "#FF613EFB", "#FF44E3FF");
        }
        return this.aCf;
    }

    public int[] wA() {
        if (this.aCg == null || this.aCg.length != 2) {
            this.aCg = j(this.aBV, this.aBW, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aCg;
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
