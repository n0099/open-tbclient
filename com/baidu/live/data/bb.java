package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb {
    private String ael;
    private String aem;
    private String aen;
    private String aeo;
    private String aep;
    private String aeq;
    private String aer;
    private String aes;
    private int[] aet;
    private int[] aeu;
    private int[] aev;
    private int[] aew;
    public String id;
    public String name;
    public int price;
    public int type;

    public bb() {
    }

    public bb(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.ael = jSONObject.optString("barrage_start_color");
        this.aem = jSONObject.optString("barrage_end_color");
        this.aen = jSONObject.optString("portrait_start_color");
        this.aeo = jSONObject.optString("portrait_end_color");
        this.aep = jSONObject.optString("portrait_frame_start_color");
        this.aeq = jSONObject.optString("portrait_frame_end_color");
        this.aer = jSONObject.optString("btn_start_color");
        this.aes = jSONObject.optString("btn_end_color");
    }

    public bb qQ() {
        this.type = 1;
        this.price = 100;
        this.ael = "#FF613EFB";
        this.aem = "#FF44E3FF";
        this.aen = "#FF623DFE";
        this.aeo = "#FF03E2F5";
        this.aep = "#FF61A0FF";
        this.aeq = "#FF73FFEF";
        return this;
    }

    public int[] qR() {
        if (this.aet == null || this.aet.length != 2) {
            this.aet = j(this.aer, this.aes, "#FF623DFE", "#FF03E2F5");
        }
        return this.aet;
    }

    public int[] qS() {
        if (this.aeu == null || this.aeu.length != 2) {
            this.aeu = j(this.aen, this.aeo, "#FF623DFE", "#FF03E2F5");
        }
        return this.aeu;
    }

    public int[] qT() {
        if (this.aev == null || this.aev.length != 2) {
            this.aev = j(this.ael, this.aem, "#FF613EFB", "#FF44E3FF");
        }
        return this.aev;
    }

    public int[] qU() {
        if (this.aew == null || this.aew.length != 2) {
            this.aew = j(this.aep, this.aeq, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aew;
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
