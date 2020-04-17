package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be {
    private String awB;
    private String awC;
    private String awD;
    private String awE;
    private String awF;
    private String awG;
    private String awH;
    private String awI;
    private int[] awJ;
    private int[] awK;
    private int[] awL;
    private int[] awM;
    public String id;
    public String name;
    public int price;
    public int type;

    public be() {
    }

    public be(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.awB = jSONObject.optString("barrage_start_color");
        this.awC = jSONObject.optString("barrage_end_color");
        this.awD = jSONObject.optString("portrait_start_color");
        this.awE = jSONObject.optString("portrait_end_color");
        this.awF = jSONObject.optString("portrait_frame_start_color");
        this.awG = jSONObject.optString("portrait_frame_end_color");
        this.awH = jSONObject.optString("btn_start_color");
        this.awI = jSONObject.optString("btn_end_color");
    }

    public be vh() {
        this.type = 1;
        this.price = 100;
        this.awB = "#FF613EFB";
        this.awC = "#FF44E3FF";
        this.awD = "#FF623DFE";
        this.awE = "#FF03E2F5";
        this.awF = "#FF61A0FF";
        this.awG = "#FF73FFEF";
        return this;
    }

    public int[] vi() {
        if (this.awJ == null || this.awJ.length != 2) {
            this.awJ = j(this.awH, this.awI, "#FF623DFE", "#FF03E2F5");
        }
        return this.awJ;
    }

    public int[] vj() {
        if (this.awK == null || this.awK.length != 2) {
            this.awK = j(this.awD, this.awE, "#FF623DFE", "#FF03E2F5");
        }
        return this.awK;
    }

    public int[] vk() {
        if (this.awL == null || this.awL.length != 2) {
            this.awL = j(this.awB, this.awC, "#FF613EFB", "#FF44E3FF");
        }
        return this.awL;
    }

    public int[] vl() {
        if (this.awM == null || this.awM.length != 2) {
            this.awM = j(this.awF, this.awG, "#FF61A0FF", "#FF73FFEF");
        }
        return this.awM;
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
