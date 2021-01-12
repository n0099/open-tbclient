package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ck {
    private String aOI;
    private String aOJ;
    private String aOK;
    private String aOL;
    private String aOM;
    private String aON;
    private String aOO;
    private String aOP;
    public boolean aOQ;
    private String aOR;
    public int aOS;
    public int aOT;
    private int[] aOU;
    private int[] aOV;
    private int[] aOW;
    private int[] aOX;
    private int[] aOY;
    public String id;
    public String name;
    public int price;
    public int type;

    public ck() {
        this.aOQ = false;
    }

    public ck(int i, JSONObject jSONObject) {
        int i2;
        this.aOQ = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aOI = jSONObject.optString("barrage_start_color");
        this.aOJ = jSONObject.optString("barrage_end_color");
        this.aOK = jSONObject.optString("portrait_start_color");
        this.aOL = jSONObject.optString("portrait_end_color");
        this.aOM = jSONObject.optString("portrait_frame_start_color");
        this.aON = jSONObject.optString("portrait_frame_end_color");
        this.aOO = jSONObject.optString("btn_start_color");
        this.aOP = jSONObject.optString("btn_end_color");
        this.aOR = jSONObject.optString("btn_border_color");
        this.aOS = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aOR)) {
            this.aOQ = true;
        }
        try {
            i2 = (int) (((this.aOS * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aOS = i2;
        this.aOT = jSONObject.optInt("noble_level");
    }

    public ck Bw() {
        this.type = 1;
        this.price = 100;
        this.aOI = "#FF613EFB";
        this.aOJ = "#FF44E3FF";
        this.aOK = "#FF623DFE";
        this.aOL = "#FF03E2F5";
        this.aOM = "#FF61A0FF";
        this.aON = "#FF73FFEF";
        return this;
    }

    public int[] Bx() {
        if (this.aOU == null || this.aOU.length != 2) {
            this.aOU = j(this.aOO, this.aOP, "#FF623DFE", "#FF03E2F5");
        }
        return this.aOU;
    }

    public int[] By() {
        if (this.aOY == null || this.aOY.length != 2) {
            this.aOY = j(this.aOR, this.aOR, "#FFFFC926", "#FFFFC926");
        }
        return this.aOY;
    }

    public int[] Bz() {
        if (this.aOV == null || this.aOV.length != 2) {
            this.aOV = j(this.aOK, this.aOL, "#FF623DFE", "#FF03E2F5");
        }
        return this.aOV;
    }

    public int[] BA() {
        if (this.aOW == null || this.aOW.length != 2) {
            this.aOW = j(this.aOI, this.aOJ, "#FF613EFB", "#FF44E3FF");
        }
        return this.aOW;
    }

    public int[] BB() {
        if (this.aOX == null || this.aOX.length != 2) {
            this.aOX = j(this.aOM, this.aON, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aOX;
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
