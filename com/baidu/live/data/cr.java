package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cr {
    private String aRK;
    private String aRL;
    private String aRM;
    private String aRN;
    private String aRO;
    private String aRP;
    private String aRQ;
    private String aRR;
    public boolean aRS;
    private String aRT;
    public int aRU;
    public int aRV;
    private int[] aRW;
    private int[] aRX;
    private int[] aRY;
    private int[] aRZ;
    private int[] aSa;
    public String id;
    public String name;
    public int price;
    public int type;

    public cr() {
        this.aRS = false;
    }

    public cr(int i, JSONObject jSONObject) {
        int i2;
        this.aRS = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aRK = jSONObject.optString("barrage_start_color");
        this.aRL = jSONObject.optString("barrage_end_color");
        this.aRM = jSONObject.optString("portrait_start_color");
        this.aRN = jSONObject.optString("portrait_end_color");
        this.aRO = jSONObject.optString("portrait_frame_start_color");
        this.aRP = jSONObject.optString("portrait_frame_end_color");
        this.aRQ = jSONObject.optString("btn_start_color");
        this.aRR = jSONObject.optString("btn_end_color");
        this.aRT = jSONObject.optString("btn_border_color");
        this.aRU = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aRT)) {
            this.aRS = true;
        }
        try {
            i2 = (int) (((this.aRU * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aRU = i2;
        this.aRV = jSONObject.optInt("noble_level");
    }

    public cr CL() {
        this.type = 1;
        this.price = 100;
        this.aRK = "#FF613EFB";
        this.aRL = "#FF44E3FF";
        this.aRM = "#FF623DFE";
        this.aRN = "#FF03E2F5";
        this.aRO = "#FF61A0FF";
        this.aRP = "#FF73FFEF";
        return this;
    }

    public int[] CM() {
        if (this.aRW == null || this.aRW.length != 2) {
            this.aRW = j(this.aRQ, this.aRR, "#FF623DFE", "#FF03E2F5");
        }
        return this.aRW;
    }

    public int[] CN() {
        if (this.aSa == null || this.aSa.length != 2) {
            this.aSa = j(this.aRT, this.aRT, "#FFFFC926", "#FFFFC926");
        }
        return this.aSa;
    }

    public int[] CO() {
        if (this.aRX == null || this.aRX.length != 2) {
            this.aRX = j(this.aRM, this.aRN, "#FF623DFE", "#FF03E2F5");
        }
        return this.aRX;
    }

    public int[] CP() {
        if (this.aRY == null || this.aRY.length != 2) {
            this.aRY = j(this.aRK, this.aRL, "#FF613EFB", "#FF44E3FF");
        }
        return this.aRY;
    }

    public int[] CQ() {
        if (this.aRZ == null || this.aRZ.length != 2) {
            this.aRZ = j(this.aRO, this.aRP, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aRZ;
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
