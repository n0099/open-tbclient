package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class av {
    private String abL;
    private String abM;
    private String abN;
    private String abO;
    private String abP;
    private String abQ;
    private String abR;
    private String abS;
    private int[] abT;
    private int[] abU;
    private int[] abV;
    private int[] abW;
    public String id;
    public String name;
    public int price;
    public int type;

    public av() {
    }

    public av(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.abL = jSONObject.optString("barrage_start_color");
        this.abM = jSONObject.optString("barrage_end_color");
        this.abN = jSONObject.optString("portrait_start_color");
        this.abO = jSONObject.optString("portrait_end_color");
        this.abP = jSONObject.optString("portrait_frame_start_color");
        this.abQ = jSONObject.optString("portrait_frame_end_color");
        this.abR = jSONObject.optString("btn_start_color");
        this.abS = jSONObject.optString("btn_end_color");
    }

    public av pU() {
        this.type = 1;
        this.price = 100;
        this.abL = "#FF613EFB";
        this.abM = "#FF44E3FF";
        this.abN = "#FF623DFE";
        this.abO = "#FF03E2F5";
        this.abP = "#FF61A0FF";
        this.abQ = "#FF73FFEF";
        return this;
    }

    public int[] pV() {
        if (this.abT == null || this.abT.length != 2) {
            this.abT = i(this.abR, this.abS, "#FF623DFE", "#FF03E2F5");
        }
        return this.abT;
    }

    public int[] pW() {
        if (this.abU == null || this.abU.length != 2) {
            this.abU = i(this.abN, this.abO, "#FF623DFE", "#FF03E2F5");
        }
        return this.abU;
    }

    public int[] pX() {
        if (this.abV == null || this.abV.length != 2) {
            this.abV = i(this.abL, this.abM, "#FF613EFB", "#FF44E3FF");
        }
        return this.abV;
    }

    public int[] pY() {
        if (this.abW == null || this.abW.length != 2) {
            this.abW = i(this.abP, this.abQ, "#FF61A0FF", "#FF73FFEF");
        }
        return this.abW;
    }

    private int[] i(String str, String str2, String str3, String str4) {
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
